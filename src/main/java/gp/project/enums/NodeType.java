package gp.project.enums;

import gp.project.utils.Utils;

import java.util.Arrays;

public enum NodeType {
    INIT("init", 0),
    IN("in", 1),
    OUT("out", 2),
    ASSIGN("=", 3),
    IF("if", 4),
    FOR("for", 5),
    PLUS("+", 6),
    MINUS("-", 7),
    TIMES("*", 8),
    DIV("/", 9),
    GREATER(">", 10),
    LESS("<", 11),
    GREATER_EQUAL(">=", 12),
    LESS_EQUAL("<=", 13),
    AND("&&", 14),
    OR("||", 15),
    NOT("!", 16),
    EQUAL("==", 17),
    NOT_EQUAL("!=", 18),
    ID("id", 19),
    INT("int", 20);

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
