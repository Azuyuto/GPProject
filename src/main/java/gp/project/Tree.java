package gp.project;

import gp.project.nodes.InitNode;
import gp.project.nodes.Node;
import gp.project.utils.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.lang3.SerializationUtils;

import java.io.Serializable;
import java.util.*;

@Data
@AllArgsConstructor
public class Tree implements Serializable  {
    private List<String> variables = new ArrayList<>();
    private InitNode root = new InitNode(this);

    public Tree() {}

    public Tree(Tree that) {
        this(that.getVariables(), that.getRoot());
    }

    public void grow() {
        root.grow();
    }

    public void print()
    {
        root.print();
    }

    public int run(List<Integer> inputs) {
        // TODO: NOT NOW!
        return 1;
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

    public Tree mutate() {
        Tree tree = new Tree(this);
        tree.numerateNodes();
        tree.getRoot().mutate();

        return tree;
    }

    public void numerateNodes() {
        int i = 0;
        root.setNumber(i++);
        for (Node child : root.getChildren()) {
            child.setNumber(i++);
        }
    }

    public int getNumberOfNodes() {
        return root.getChildren().size() + 1;
    }

    public Node getNodeByNumber(int number) {
        return number == 0 ? root : root.getChildren().stream().filter(c -> c.getNumber() == number).findFirst().orElseThrow(IllegalStateException::new);
    }
}