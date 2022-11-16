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
    private boolean isMutated;

    private final static Logger log = LogManager.getLogger(Node.class);

    public Node(Tree tree, NodeType type, int depth) {
        this.tree = tree;
        this.type = type;
        this.depth = depth;
    }

    public Node(Node another)
    {
        this.tree = another.tree;
        this.type = another.type;
        this.name = another.name;
        this.value = another.value;
        this.depth = another.depth;
        this.number = another.number;
        this.children = another.children;
        this.isMutated = another.isMutated;
    }

    public String toString() {
        return getLogName();
    }

    public void print() {
        log.setLevel(Level.ALL);
        log.info(getPrettyString() + getLogName());
        children.forEach(Node::print);
    }

    public String getLogName()
    {
        return getType() == NodeType.ID ? getName() : getType() == NodeType.INT ? "(" + getValue() + ")" : getType().GetName();
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

    public void clearChildren() {
        children.clear();
    }
    public void mutate() {
        isMutated = true;
    }

//    public Node crossover() {
//
//    }
}