package gp.project.nodes;

import gp.project.Tree;
import gp.project.enums.NodeType;
import gp.project.enums.StatementType;
import gp.project.utils.Utils;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

        boolean nextStatement = Utils.IsWidthExtension();
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

    @Override
    public String toCode()
    {
        List<String> codes = getChildren().stream().map(Node::toCode).collect(Collectors.toList());
        return String.format("\n{\n%s}\n", String.join("", codes));
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
