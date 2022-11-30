package gp.project.nodes;

import gp.project.Tree;
import gp.project.enums.NodeType;
import gp.project.enums.StatementType;
import gp.project.utils.Utils;

import java.io.Serializable;

public class BlockStatement extends Node implements Serializable {
    BlockStatement(Tree tree, NodeType type, int depth) {
        super(tree, type, depth);
    }

    public BlockStatement(Node another)
    {
        super(another);
    }

    public void grow()
    {
        BasicStatementNode node = (BasicStatementNode)addNodeByStatementType(StatementType.BASIC_STATEMENTS);
        node.grow();

        boolean nextStatement = Utils.GetRandomNumber(2) == 1;
        if (nextStatement)
        {
            grow();
        }
    }

    @Override
    public void mutate() {
        super.mutate();
        clearChildren();
        grow();
    }
}
