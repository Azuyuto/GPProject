package gp.project.enums;

public enum StatementType {
    BLOCK_STATEMENTS(0),
    SINGLE_STATEMENTS(1),
    BASIC_STATEMENTS(2),
    IO_FUNCTIONS(3),
    EXPRESSIONS(4),
    EQUATIONS(5),
    FACTORS(6);

    int number;

    StatementType(int number) {
        this.number = number;
    }
}
