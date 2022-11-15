package gp.project.enums;

public enum StatementType {
    SINGLE_STATEMENTS(0),
    BASIC_STATEMENTS(1),
    IO_FUNCTIONS(2),
    EXPRESSIONS(3),
    EQUATIONS(4),
    FACTORS(5);

    int number;

    StatementType(int number) {
        this.number = number;
    }
}
