package gp.project.nodes;

import gp.project.Tree;
import gp.project.enums.NodeType;
import gp.project.enums.StatementType;
import gp.project.utils.Utils;

public class ExpressionNode extends Node {
    ExpressionNode(Tree tree, NodeType type, int depth) {
        super(tree, type, depth);
    }

    public void grow() {
        boolean nextStatement = Utils.GetRandomNumber(2) == 1;

        if (nextStatement && this.getDepth() < Utils.MAX_DEPTH - 1)
        {
            Node node = addNodeByStatementType(StatementType.EXPRESSIONS);
            node.grow();
        }
        else
        {
            addNodeByStatementType(StatementType.FACTORS);
        }

        if (getType() != NodeType.NOT)
        {
            addNodeByStatementType(StatementType.FACTORS);
        }
    }
}
