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

    public int run(List<Integer> inputs) {
        // TODO: NOT NOW!
        return 1;
    }
}