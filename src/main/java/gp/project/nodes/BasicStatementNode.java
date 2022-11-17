package gp.project.nodes;

import gp.project.Tree;
import gp.project.enums.NodeType;
import gp.project.enums.StatementType;
import gp.project.utils.Utils;

import java.io.Serializable;

public class BasicStatementNode extends Node implements Serializable {
    BasicStatementNode(Tree tree, NodeType type, int depth) {
        super(tree, type, depth);
    }

    public BasicStatementNode(Node another)
    {
        super(another);
    }

    public void grow()
    {
        switch(this.getType()) {
            case IN:
                addVariableNode(); // X1
                break;
            case OUT:
                addNodeByStatementType(StatementType.FACTORS); // X1, 2
                break;
            case IF:
                addNodeByStatementType(StatementType.EXPRESSIONS); // X1 < 2
                addNodeByStatementType(StatementType.BASIC_STATEMENTS);

                boolean addElse = Utils.GetRandomNumber(1) == 1;
                if (addElse)
                {
                    addNodeByStatementType(StatementType.BASIC_STATEMENTS);
                }

                break;
            case FOR:
                addAssignNode(); // int i = 0
                addNodeByStatementType(StatementType.EXPRESSIONS); // i < 0
                addAssignNode(); // i = i + 1
                addNodeByStatementType(StatementType.BASIC_STATEMENTS);

                break;
            case ASSIGN:
                addVariableNode(); // X1
                boolean token = Utils.GetRandomNumber(2) == 1;
                if(token || getDepth() >= Utils.MAX_DEPTH - 1)
                    addNodeByStatementType(StatementType.FACTORS); // X1 = X2
                else {
                    addNodeByStatementType(StatementType.EXPRESSIONS); // X1 = 2 + 2
                }
        }

        getChildren().forEach(Node::grow);
    }

    @Override
    public void mutate() {
        super.mutate();
        clearChildren();
        NodeType type = NodeType.getRandomNodeTypeByStatementType(StatementType.BASIC_STATEMENTS);
        this.setType(type);
        grow();
    }
}
