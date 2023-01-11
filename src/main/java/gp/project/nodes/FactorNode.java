package gp.project.nodes;

import gp.project.Tree;
import gp.project.enums.NodeType;
import gp.project.utils.Utils;

import java.io.Serializable;
import java.util.Optional;

public class FactorNode extends Node implements Serializable {
    public FactorNode(Tree tree, NodeType type, int depth) {
        super(tree, type, depth);

        if (type == NodeType.ID)
        {
            this.setName(tree.getRandomVariable());
        } 
        else
        {
            this.setValue(Utils.GetRandomNumberBetween(this.getTree().minRandomNumber, this.getTree().maxRandomNumber));
        }
    }

    public FactorNode(Node another)
    {
        super(another);
    }

    @Override
    public void mutate() {
        super.mutate();
        if (getType() == NodeType.ID) {
            this.setName(this.getTree().getRandomVariable());
        } else {
            this.setValue(Utils.GetRandomNumberBetween(this.getTree().minRandomNumber, this.getTree().maxRandomNumber));
        }
    }

    @Override
    public String toCode()
    {
        return getType() == NodeType.ID ? getName() : String.valueOf(getValue());
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
