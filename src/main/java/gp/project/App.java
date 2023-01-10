package gp.project;

//import gp.antlr4.GrammarCustomVisitor;

public class App
{
    public static void main( String[] args )
    {
        long seed = -1;
        TinyGP gp = new TinyGP(seed);
        gp.evolve();

        String code = "init {\n" +
                "X0 = in;\n" +
                "for(X1 = X2;(X1) - X1;X3 = (5) + X1) \n" +
                "{\n" +
                "out = 4;\n" +
                "for(X0 = X1;(5) != 4;X3 = -2) \n" +
                "{\n" +
                "X3 = in;\n" +
                "out = X0;\n" +
                "}\n" +
                "X3 = in;\n" +
                "}\n" +
                "out = 4;\n" +
                "}";
        GrammarLexer lexer = new GrammarLexer(CharStreams.fromString(code));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        GrammarParser parser = new GrammarParser(tokens);

        ParseTree tree = parser.init();
        List<Integer> inputs = new ArrayList<>();
        inputs.add(1);
        inputs.add(2);
        GrammarCustomVisitor<Integer> visitor = new GrammarCustomVisitor<>(inputs);
        visitor.visit(tree);
        visitor.printOutputs();
    }
}
