package gp.project;

import gp.antlr4.GrammarCustomVisitor;
import gp.antlr4.gen.GrammarLexer;
import gp.antlr4.gen.GrammarParser;
import gp.project.nodes.InitNode;
import gp.project.nodes.Node;
import gp.project.utils.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Tree implements Serializable  {
    private List<String> variables = new ArrayList<>();
    private InitNode root = new InitNode(this);
    public int minRandomNumber, maxRandomNumber;

    public Tree() {}

    public Tree(Tree that) {
        this.variables.addAll(that.getVariables());
        this.root = new InitNode(that.getRoot());
    }

    public void grow() {
        root.grow();
    }

    public List<Integer> run(List<Integer> inputs) {
        //System.out.print(toCode());
        GrammarLexer lexer = new GrammarLexer(CharStreams.fromString(toCode()));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        GrammarParser parser = new GrammarParser(tokens);

        ParseTree tree = parser.init();
        GrammarCustomVisitor<Integer> visitor = new GrammarCustomVisitor<>(inputs);
        visitor.visit(tree);

        return visitor.getOutputs();
    }

    public void addVariable(String variable)
    {
        variables.add(variable);
    }

    public String getRandomVariable() {
        int variableIndex = Utils.GetRandomNumber(variables.size() + 1);
        
        if (variableIndex == variables.size()) 
        {
            addVariable("X" + variableIndex);
        }

        return variables.get(variableIndex);
    }

    public void mutate() {
        if (Utils.MAX_DEPTH == 1) {
            return;
        }
        numerateNodes();
        int rand = Utils.GetRandomNumber(Utils.countNodes);
        Node nodeToMutate = getNodeByNumber(rand);
        nodeToMutate.mutate();
    }

    public void crossover(Tree tree) {
        root.crossover(tree.root);
    }

    public void numerateNodes() {
        Utils.countNodes = 0;
        root.numerateNodes();
    }

    //public Node getNodeByNumber(int number) {
    //    return number == 0 ? root : root.getChildren().stream().filter(c -> c.getNumber() == number).findFirst().orElseThrow(IllegalStateException::new);
    //}

    public Node getNodeByNumber(int number){
        return root.getNodeByNumber(number);
    }

    public String toCode()
    {
        return root.toCode();
    }
}