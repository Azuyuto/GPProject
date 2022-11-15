package gp.project;

import gp.project.nodes.InitNode;
import gp.project.utils.Utils;
import lombok.Data;

import java.util.*;

@Data
public class Tree {
    private List<String> variables = new ArrayList<>();
    private InitNode root = new InitNode(this);
    private int nodesCount = 1;

    public Tree() {}

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
}