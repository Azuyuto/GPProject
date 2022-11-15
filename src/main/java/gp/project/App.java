package gp.project;

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
