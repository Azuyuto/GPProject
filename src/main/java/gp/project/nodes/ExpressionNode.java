package gp.project.nodes;

import gp.project.Tree;
import gp.project.enums.NodeType;
import gp.project.enums.StatementType;
import gp.project.utils.Utils;

import java.io.Serializable;
import java.util.Optional;

public class ExpressionNode extends Node implements Serializable {
    private StatementType statementType;

    ExpressionNode(Tree tree, NodeType type, int depth, StatementType statementType) {
        super(tree, type, depth);
        this.statementType = statementType;
    }

    public ExpressionNode(Node another)
    {
        super(another);
    }

    public void grow() {
        boolean nextStatement = Utils.GetRandomNumber(2) == 1;

        if (nextStatement && this.getDepth() < Utils.MAX_DEPTH - 1)
        {
            Node node = addNodeByStatementType(statementType);
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

    @Override
    public void mutate() {
        super.mutate();
        clearChildren();
        NodeType type = NodeType.getRandomNodeTypeByStatementType(statementType);
        this.setType(type);
        grow();
    }

    @Override
    public String toCode()
    {
        if(getType() == NodeType.NOT)
            return getType().GetName() + getChildren().get(0).toCode();
        String left = getChildren().get(0).toCode();
        String right = getChildren().get(1).toCode();
        return String.format("(%s) %s %s", left, getType().GetName(), right);
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
