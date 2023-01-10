package gp.project;

import gp.antlr4.GrammarCustomVisitor;
import gp.antlr4.gen.GrammarLexer;
import gp.antlr4.gen.GrammarParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;
import java.util.List;

public class App
{
    public static void main( String[] args )
    {
        //long seed = -1;
        //TinyGP gp = new TinyGP(seed);
        //gp.evolve();

        String code = "init {\n" +
                "if ((X2) || X3) \n" +
                "{\n" +
                "out = -3;\n" +
                "X1 = in;\n" +
                "}\n" +
                "out = -4;\n" +
                "out = -4;\n" +
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
