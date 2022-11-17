package gp.project.nodes;

import gp.project.Tree;
import gp.project.enums.NodeType;
import gp.project.enums.StatementType;
import gp.project.utils.Utils;

import java.io.Serializable;

public class InitNode extends Node implements Serializable {

    public InitNode(Tree tree) {
        super(tree, NodeType.INIT, 0);
    }

    public InitNode(InitNode another)
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
