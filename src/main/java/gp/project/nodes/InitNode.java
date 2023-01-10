package gp.project.nodes;

import gp.project.Tree;
import gp.project.enums.NodeType;
import gp.project.enums.StatementType;
import gp.project.utils.Utils;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public String toCode()
    {
        List<String> codes = getChildren().stream().map(Node::toCode).collect(Collectors.toList());
        return String.format("init {\n%s}\n", String.join("", codes));
    }
}
