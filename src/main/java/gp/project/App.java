package gp.project;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class App
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        long seed = -1;
        TinyGP gp = new TinyGP(seed);
        gp.evolve();
    }
}
