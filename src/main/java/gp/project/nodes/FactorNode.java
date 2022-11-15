package gp.project.nodes;

import gp.project.Tree;
import gp.project.enums.NodeType;
import gp.project.utils.Utils;

public class FactorNode extends Node {
    FactorNode(Tree tree, NodeType type, int depth) {
        super(tree, type, depth);

        if (type == NodeType.ID)
        {
            this.setName(tree.getRandomVariable());
        } 
        else
        {
            this.setValue(Utils.GetRandomDeclarationNumbers());
        }
    }
}
