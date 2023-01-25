package gp.project.nodes;

import gp.project.Tree;
import gp.project.enums.NodeType;
import gp.project.enums.StatementType;
import gp.project.utils.Utils;

import java.io.Serializable;
import java.util.Optional;

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
                addNodeByStatementType(StatementType.BLOCK_STATEMENTS);

                boolean addElse = Utils.GetRandomNumber(2) == 1;
                if (addElse)
                {
                    addNodeByStatementType(StatementType.BASIC_STATEMENTS);
                }

                break;
            case FOR:
                addAssignNode(); // int i = 0
                addNodeByStatementType(StatementType.EXPRESSIONS); // i < 0
                addAssignNode(); // i = i + 1
                addNodeByStatementType(StatementType.BLOCK_STATEMENTS);

                break;
            case ASSIGN:
                addVariableNode(); // X1
                boolean token = Utils.GetRandomNumber(2) == 1;
                if(token || getDepth() >= Utils.MAX_DEPTH - 1)
                    addNodeByStatementType(StatementType.FACTORS); // X1 = X2
                else {
                    addNodeByStatementType(StatementType.EQUATIONS); // X1 = 2 + 2
                }
        }

        getChildren().forEach(Node::grow);
    }

    @Override
    public void mutate() {
        super.mutate();
        clearChildren();
        if(getType() != NodeType.ASSIGN)
        {
            NodeType type = NodeType.getRandomNodeTypeByStatementType(StatementType.BASIC_STATEMENTS);
            this.setType(type);
        }
        grow();
    }

    @Override
    public String toCode()
    {
        switch (getType())
        {
            case IN:
                return String.format(" %s = in;\n", getChildren().get(0).toCode());
            case OUT:
                return String.format(" out = %s;\n", getChildren().get(0).toCode());
            case IF:
                String e = getChildren().get(0).toCode();
                String i = getChildren().get(1).toCode();
                String s = String.format(" if (%s) %s", e, i);
                if(getChildren().size() == 3)
                {
                    return String.format("%s else %s", s, i);
                }
                return s;
            case FOR:
                String a1 = getChildren().get(0).toCode();
                String ex = getChildren().get(1).toCode();
                String a2 = getChildren().get(2).toCode();
                String st = getChildren().get(3).toCode();
                return String.format(" for(%s;%s;%s) %s", a1.substring(0, a1.length() - 2), ex, a2.substring(0, a2.length() - 2), st);
            case ASSIGN:
                return String.format(" %s = %s;\n", getChildren().get(0).toCode(), getChildren().get(1).toCode());
            default:
                return "";
        }
    }

    @Override
    public Optional<Node> crossover(Node node, int nodeNumber) {
        if (number != nodeNumber) {
            return Optional.empty();
        } else {
            return crossoverBody(node);
        }
    }
}
