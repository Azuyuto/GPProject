package gp.project.nodes;

import gp.project.Tree;
import gp.project.enums.NodeType;
import gp.project.enums.StatementType;
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

    @Override
    public void mutate() {
        NodeType type = NodeType.getRandomNodeTypeByStatementType(StatementType.FACTORS);
        this.setType(type);
        if (type == NodeType.ID) {
            this.setName(this.getTree().getRandomVariable());
        } else {
            this.setValue(Utils.GetRandomDeclarationNumbers());
        }
    }
}
