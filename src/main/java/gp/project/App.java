package gp.project;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class App
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        String file_name = "data.dat";
        long seed = -1;
        TinyGP gp = new TinyGP(file_name, seed);
        gp.evolve();
    }
}
