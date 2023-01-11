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
        if (Utils.MAX_DEPTH == 1) {
            return;
        }
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
        if (Utils.MAX_DEPTH == 1) {
            return;
        }
        super.mutate();
        clearChildren();
        grow();
    }

    public void crossover(Node node) {
        int rand;
        if (Utils.countNodes <= 1){
            rand = 0;
        }
        else {
            rand = Utils.rd.nextInt(Utils.countNodes - 1) + 1;
        }
        crossoverFurther(node, rand);
    }

    @Override
    public String toCode()
    {
        List<String> codes = getChildren().stream().map(Node::toCode).collect(Collectors.toList());
        return String.format("init {\n%s}\n", String.join("", codes));
    }
}
