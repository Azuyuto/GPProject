package gp.project.nodes;

import gp.project.Tree;
import gp.project.enums.NodeType;
import gp.project.enums.StatementType;
import gp.project.utils.Utils;

public class InitNode extends Node {

    public InitNode(Tree tree) {
        super(tree, NodeType.INIT, 0);
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
        int rand = Utils.GetRandomNumber(this.getTree().getNumberOfNodes());
        if (rand == 0) {
            clearChildren();
            grow();
        } else {
            Node nodeToMutate = this.getTree().getNodeByNumber(rand);
            nodeToMutate.mutate();
        }
    }
}
