package gp.project;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

public class TinyGP {
    long seed; // saved seed
    static Random rd = new Random();
    static StringBuilder stringBuilder = new StringBuilder();
    static Tree tree = new Tree("Program");

    final int
            PROGRAM = 100,
            STATEMENT = 101,
            SIMPLE_STATEMENT = 102,
            FITNESS_SET_START = STATEMENT,
            FITNESS_SET_END = SIMPLE_STATEMENT;

    // = input data =
    int inputVarNumber;
    int fitnessCases;;
    // = = =

    double [][] targets;

    int PC;
    char [] program;
    double [] fitness;
    char [][] population;
    double avgLength;
    double fitnessBestPop = 0.0, fitnessAvgPop = 0.0;
    final int
            MAXIMUM_LENGTH = 10000,
            POPULATION_SIZE = 100000,
            DEPTH = 5,
            GENERATIONS = 100,
            TOURNAMENT_SIZE = 2;
    char [] buffer = new char[MAXIMUM_LENGTH];

    public TinyGP(String file_name, long seed) {
        fitness =  new double[POPULATION_SIZE];
        this.seed = seed;
        if ( seed >= 0 )
            rd.setSeed(seed);
        setup_fitness(file_name);
        population = create_random_population(POPULATION_SIZE, DEPTH, fitness );
    }

    int getChildrenByParent(int PARENT)
    {
        switch(PARENT)
        {
            case PROGRAM:
                return STATEMENT;
            case STATEMENT:
                List<Integer> list = new ArrayList<>();
                list.add(STATEMENT);
                list.add(SIMPLE_STATEMENT);
                return list.get(rd.nextInt(list.size()));
            case SIMPLE_STATEMENT:
                return 0;
            default:
                return 0;
        }
    }

    int grow( char [] buffer, int pos, int max, int depth, int PARENT) {
        char prim = (char) rd.nextInt(2);
        int first_child;

        if ( pos >= max )
            return( -1 );

        if ( pos == 0 )
            prim = 1;

        if ( prim == 0 || depth == 0 ) {
            prim = (char) rd.nextInt(inputVarNumber);
            buffer[pos] = prim;
            return(pos+1);
        }
        else  {
            prim = (char) getChildrenByParent(PARENT);
            switch (prim) {
                case STATEMENT:
                    int r = rd.nextInt(2);
                    buffer[pos] = prim;
                    buffer[pos+1] = (char)(r+1);
                    if (r == 1) {
                        first_child = grow(buffer, pos + 2, max, depth - 1, STATEMENT);
                        if (first_child < 0)
                            return (-1);

                        return (grow(buffer, first_child, max, depth - 1, STATEMENT));
                    }
                    return (grow(buffer, pos + 2, max, depth - 1, STATEMENT));
                case SIMPLE_STATEMENT:
                    buffer[pos] = prim;
                    return grow(buffer, pos + 1, max, depth - 1, SIMPLE_STATEMENT);
                default:
                    return 0;
            }
        }
    }

    char [] create_random_in_div( int depth ) {
        char [] ind;
        int len;

        len = grow( buffer, 0, MAXIMUM_LENGTH, depth, PROGRAM);

        while (len < 0 )
            len = grow( buffer, 0, MAXIMUM_LENGTH, depth, PROGRAM);

        ind = new char[len];

        System.arraycopy(buffer, 0, ind, 0, len );
        return( ind );
    }

    double fitness_function( char [] Prog ) {
        return rd.nextInt(10);
    }

    char [][] create_random_population(int n, int depth, double [] fitness ) {
        char [][]pop = new char[n][];
        int i;

        for ( i = 0; i < n; i ++ ) {
            pop[i] = create_random_in_div( depth );
            fitness[i] = fitness_function( pop[i] );
        }
        return( pop );
    }

    void setup_fitness(String file_name) {
        try {
            int i,j;
            String line;

            BufferedReader in =
                    new BufferedReader(
                            new
                                    FileReader(file_name));
            line = in.readLine();
            StringTokenizer tokens = new StringTokenizer(line);
            inputVarNumber = Integer.parseInt(tokens.nextToken().trim());
            fitnessCases = Integer.parseInt(tokens.nextToken().trim());
            targets = new double[fitnessCases][inputVarNumber +1];
            if (inputVarNumber >= FITNESS_SET_START)
                System.out.println("too many variables and constants...");

            for (i = 0; i < fitnessCases; i ++ ) {
                line = in.readLine();
                tokens = new StringTokenizer(line);
                for (j = 0; j <= inputVarNumber; j++) {
                    targets[i][j] = Double.parseDouble(tokens.nextToken().trim());
                }
            }
            in.close();
        }
        catch(FileNotFoundException e) {
            System.out.println("ERROR: Please provide a data file.");
            System.exit(0);
        }
        catch(Exception e ) {
            System.out.println("ERROR: Incorrect data format.");
            System.exit(0);
        }
    }

    int traverse( char [] buffer, int bufferCount ) {
        if (buffer[bufferCount] < FITNESS_SET_START)
            return( ++bufferCount );

        switch (buffer[bufferCount]) {
            case STATEMENT:
                return (traverse(buffer, ++bufferCount));
            case SIMPLE_STATEMENT:
                return ( ++bufferCount );
            default:
                return 0;
        }
    }

    int print_in_div( char []buffer, int bufferCounter, Tree current_tree) {
        int a1=0, a2;
        if ( buffer[bufferCounter] < FITNESS_SET_START) {
            current_tree.data = "X" + (buffer[bufferCounter] + 1 );
            return( ++bufferCounter );
        }
        boolean one_arg = false;
        switch (buffer[bufferCounter]) {
            case STATEMENT:
                current_tree.data = "STATEMENT";
                int r = buffer[++bufferCounter];
                if(r == 1)
                {
                    one_arg = true;
                }
                current_tree.left = new Tree("");
                a1 = print_in_div(buffer, ++bufferCounter, current_tree.left);
                break;
            case SIMPLE_STATEMENT:
                current_tree.data = "SIMPLE_STATEMENT";
                current_tree.left = new Tree("");
                a1 = print_in_div(buffer, ++bufferCounter, current_tree.left);
                one_arg = true;
                break;
        }
        if (one_arg)
        {
            return( a1);
        }

        current_tree.right = new Tree("");
        a2 = print_in_div( buffer, a1, current_tree.right );
        return( a2);
    }

    void stats( double [] fitness, char [][] pop, int gen ) {
        int i, best = rd.nextInt(POPULATION_SIZE);
        int nodeCount = 0;
        fitnessBestPop = fitness[best];
        fitnessAvgPop = 0.0;
        for (i = 0; i < POPULATION_SIZE; i ++ ) {
            nodeCount += traverse( pop[i], 0 );
            fitnessAvgPop += fitness[i];
            if ( fitness[i] > fitnessBestPop) {
                best = i;
                fitnessBestPop = fitness[i];
            }
        }
        avgLength = (double) nodeCount / POPULATION_SIZE;
        fitnessAvgPop /= POPULATION_SIZE;
        System.out.print("Generation="+gen+" Avg Fitness="+(-fitnessAvgPop)+
                " Best Fitness="+(-fitnessBestPop)+" Avg Size="+ avgLength +
                "\nBest Individual: \n");

        stringBuilder = new StringBuilder();
        tree.left = new Tree("");
        print_in_div( pop[best], 0, tree.left);
        tree.print();
        System.out.print(stringBuilder.toString() + "\n");
        System.out.flush();
    }

    void evolve() {
        int gen, indivs, offspring, parent1, parent2, parent;
        double newFit;
        char[] newInd;
        stats(fitness, population, 0);
    }
}