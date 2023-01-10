package gp.project.nodes;

import gp.project.Tree;
import gp.project.enums.NodeType;
import gp.project.enums.StatementType;
import gp.project.utils.Utils;
import lombok.Data;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public abstract class Node implements Serializable {
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
        for(Node child : another.children)
        {
            switch(child.type) {
                case BLOCK_STATEMENT:
                    this.children.add(new BlockStatement(child));
                    break;
                case IN:
                case OUT:
                case IF:
                case FOR:
                case ASSIGN:
                    this.children.add(new BasicStatementNode(child));
                    break;
                case ID:
                case INT:
                    this.children.add(new FactorNode(child));
                    break;
                default:
                    this.children.add(new ExpressionNode(child));
            }
        }
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
            case BLOCK_STATEMENTS:
                BlockStatement blNode = new BlockStatement(tree, nodeType, depth + 1);
                children.add(blNode);
                return blNode;
            case IO_FUNCTIONS:
            case SINGLE_STATEMENTS:
            case BASIC_STATEMENTS:
                BasicStatementNode bNode = new BasicStatementNode(tree, nodeType, depth + 1);
                children.add(bNode);
                return bNode;
            case EQUATIONS:
            case EXPRESSIONS:
                ExpressionNode eNode = new ExpressionNode(tree, nodeType, depth + 1, statementType);
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

    public void numerateNodes() {
        this.number = (Utils.countNodes++);
        for (Node child : children) {
            child.numerateNodes();
        }
    }

    public Node getNodeByNumber(int number) {
        if (this.number == number){
            return this;
        }
        else {
            for(Node child: children)
            {
                Node node = child.getNodeByNumber(number);
                if(node != null)
                {
                    return node;
                }
            }
        }

        return null;
    }

    public Optional<Node> crossover(Node node, int nodeNumber){
        return Optional.empty();
    }

    protected Optional<Node> crossoverFurther(Node node, int nodeNumber){
        for(int i=0; i<children.size(); i++){
            Optional<Node> toReplace = children.get(i).crossover(node, nodeNumber);
            if (toReplace.isPresent()) {
                children.set(i, toReplace.get());
                return Optional.empty();
            }
        }

        return Optional.empty();
    }

    protected Optional<Node> crossoverBody(Node node) {
        List<Node> properNodes = node.findByClass(this.getClass());
        if (properNodes.isEmpty()) {
            return Optional.empty();
        } else {
            int rand = Utils.rd.nextInt(properNodes.size());
            return Optional.of(properNodes.get(rand));
        }
    }

    public List<Node> findByClass(Class<?> type) {
        List<Node> nodes = new ArrayList<>();
        for(Node child : children) {
            if (type.isInstance(child)) {
                nodes.add(child);
            }

            nodes.addAll(child.findByClass(type));
        }

        return nodes;
    }

    public String toCode()
    {
        return "";
    }

//    public Node crossover() {
//
//    }
}