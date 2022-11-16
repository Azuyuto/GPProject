package gp.project;

public class App
{
    public static void main( String[] args )
    {
        long seed = -1;
        TinyGP gp = new TinyGP(seed);
        gp.evolve();
    }
}
