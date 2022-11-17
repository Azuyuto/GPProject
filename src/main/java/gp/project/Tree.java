package gp.project;

import gp.project.nodes.InitNode;
import gp.project.nodes.Node;
import gp.project.utils.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.*;
import org.apache.commons.lang3.SerializationUtils;

@Data
@AllArgsConstructor
public class Tree implements Serializable  {
    private List<String> variables = new ArrayList<>();
    private InitNode root = new InitNode(this);


    public Tree() {}

    public Tree(Tree that) {
        this.variables.addAll(that.getVariables());
        this.root = new InitNode(that.getRoot());
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

    public void mutate() {
        numerateNodes();
        int rand = Utils.GetRandomNumber(Utils.countNodes);
        Node nodeToMutate = getNodeByNumber(rand);
        nodeToMutate.mutate();
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
}