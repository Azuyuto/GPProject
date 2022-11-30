package gp.project.enums;

import gp.project.utils.Utils;

import java.util.Arrays;

public enum NodeType {
    INIT("init", 0),
    BLOCK_STATEMENT("block statement", 1),
    IN("in", 2),
    OUT("out", 3),
    ASSIGN("=", 4),
    IF("if", 5),
    FOR("for", 6),
    PLUS("+", 7),
    MINUS("-", 8),
    TIMES("*", 9),
    DIV("/", 10),
    GREATER(">", 11),
    LESS("<", 12),
    GREATER_EQUAL(">=", 13),
    LESS_EQUAL("<=", 14),
    AND("&&", 15),
    OR("||", 16),
    NOT("!", 17),
    EQUAL("==", 18),
    NOT_EQUAL("!=", 19),
    ID("id", 20),
    INT("int", 21);

    String name;
    int value;

    NodeType(String name, int i) {
        this.name = name;
        this.value = i;
    }

    public String GetName()
    {
        return name;
    }

    public static NodeType getRandomNodeTypeByStatementType(StatementType statementType)
    {
        switch (statementType)
        {
            case BLOCK_STATEMENTS:
                return getNodeTypeBetween(BLOCK_STATEMENT, BLOCK_STATEMENT);
            case SINGLE_STATEMENTS:
                return getNodeTypeBetween(IN, ASSIGN);
            case BASIC_STATEMENTS:
                return getNodeTypeBetween(IN, FOR);
            case IO_FUNCTIONS:
                return getNodeTypeBetween(IN, OUT);
            case EXPRESSIONS:
                return getNodeTypeBetween(PLUS, NOT_EQUAL);
            case EQUATIONS:
                return getNodeTypeBetween(PLUS, DIV);
            case FACTORS:
                return getNodeTypeBetween(ID, INT);
            default:
                return null;
        }
    }

    public static NodeType getNodeTypeBetween(NodeType first, NodeType last)
    {
        return getByValue(Utils.GetRandomNumberBetween(first.value, last.value));
    }

    public static NodeType getByValue(int value)
    {
        return Arrays.stream(NodeType.values())
                .filter(n -> n.value == value)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
