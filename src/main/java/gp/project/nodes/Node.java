package gp.project.nodes;

import gp.project.enums.StatementType;
import gp.project.utils.Utils;
import lombok.Data;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import java.util.*;

import gp.project.enums.NodeType;
import gp.project.Tree;

@Data
public abstract class Node {
    private Tree tree;
    private NodeType type;
    private String name;
    private int value;
    private int depth;
    private int number;
    private List<Node> children = new ArrayList<>();

    private final static Logger log = LogManager.getLogger(Node.class);

    public Node(Tree tree, NodeType type, int depth) {
        this.tree = tree;
        this.type = type;
        this.depth = depth;
    }

    public String toString() {
        return type.toString();
    }

    public void print() {
        log.setLevel(Level.ALL);
        String name = getType() == NodeType.ID ? getName() : getType() == NodeType.INT ? "(" + getValue() + ")" : getType().name();
        log.info(getPrettyString() + name);
        children.forEach(Node::print);
    }

    public void grow() {

    }

    private String getPrettyString() {
        return "-".repeat(depth);
    }

    public Node addNodeByStatementType(StatementType statementType) {
        if(statementType == StatementType.BASIC_STATEMENTS && depth >= Utils.MAX_DEPTH - 2)
        {
            statementType = StatementType.SINGLE_STATEMENTS;
        }

        NodeType nodeType = NodeType.getRandomNodeTypeByStatementType(statementType);

        switch (statementType) {
            case IO_FUNCTIONS:
            case SINGLE_STATEMENTS:
            case BASIC_STATEMENTS:
                BasicStatementNode bNode = new BasicStatementNode(tree, nodeType, depth + 1);
                children.add(bNode);
                return bNode;
            case EQUATIONS:
            case EXPRESSIONS:
                ExpressionNode eNode = new ExpressionNode(tree, nodeType, depth + 1);
                children.add(eNode);
                return eNode;
            case FACTORS:
                FactorNode fNode = new FactorNode(tree, nodeType, depth + 1);
                children.add(fNode);
                return fNode;
            default:
                throw new IllegalStateException();
        }
    }

    public void addVariableNode()
    {
        FactorNode fNode = new FactorNode(tree, NodeType.ID, depth + 1);
        children.add(fNode);
    }

    public void addAssignNode()
    {
        BasicStatementNode aNode = new BasicStatementNode(tree, NodeType.ASSIGN, depth + 1);
        children.add(aNode);
    }
}
