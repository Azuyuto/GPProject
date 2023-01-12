package gp.project;

import gp.project.utils.MyJTree;
import gp.project.utils.Utils;
import org.apache.commons.lang3.SerializationUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static gp.project.utils.Utils.rd;

public class TinyGP {
    List<Tree> population = new ArrayList<>();
    int bestLastPop = 0;
    double fitnessBestPop = 0.0, fitnessAvgPop = 0.0;
    double[] fitness;

    final int
            POPULATION_SIZE = 10000,
            GENERATIONS = 200,
            MIN_RANDOM = -10,
            MAX_RANDOM = 10,
            T_SIZE = 2;

    List<List<Integer>> INPUTS = new ArrayList<>();

    // [0] => [1, 2]
    // [1] => [3, 4]

    List<Integer> OUTPUTS = new ArrayList<>();

    // [0] => 1
    // [1] => 2

    public TinyGP(long seed) {
        //czytanie z pliku
        try{
            DataReader dataReader = new DataReader();
            Data data = dataReader.read();
            INPUTS = data.getINPUTS();
            OUTPUTS = data.getOUTPUTS();
        } catch (Exception e) {
            e.printStackTrace();
        }
        fitness = new double[POPULATION_SIZE];

        if (seed >= 0)
            Utils.SetSeed(seed);

        createRandomPopulation();
    }

    int fitnessFunction(Tree tree) {
        int fitness = 0;

        for (int i = 0 ; i < OUTPUTS.size() ; i ++) {
            List<Integer> treeValues = tree.run(INPUTS.get(i));
            if(treeValues.size() == 0)
                fitness += 1000;
            else
                fitness += Math.abs(OUTPUTS.get(i) - treeValues.get(0));
        }

        return -fitness;
    }

    void createRandomPopulation() {
        for (int i = 0; i < POPULATION_SIZE; i++) {
            Tree tree = createRandomTree();
            population.add(tree);
            fitness[i] = fitnessFunction(tree);
        }
    }

    Tree createRandomTree() {
        Tree tree = new Tree();
        tree.minRandomNumber = MIN_RANDOM;
        tree.maxRandomNumber = MAX_RANDOM;
        tree.grow();

        return tree;
    }

    int tournament() {
        int best = rd.nextInt(POPULATION_SIZE), i, competitor;
        double fitnessBest = -1.0e34;

        for ( i = 0; i < T_SIZE; i ++ ) {
            competitor = rd.nextInt(POPULATION_SIZE);
            if ( fitness[competitor] > fitnessBest ) {
                fitnessBest = fitness[competitor];
                best = competitor;
            }
        }
        return(best);
    }

    int negativeTournament() {
        int worst = rd.nextInt(POPULATION_SIZE), i, competitor;
        double f_worst = 1e34;

        for ( i = 0; i < T_SIZE; i ++ ) {
            competitor = rd.nextInt(POPULATION_SIZE);
            if (fitness[competitor] < f_worst) {
                f_worst = fitness[competitor];
                worst = competitor;
            }
        }
        return(worst);
    }

    void stats( double [] fitness, List<Tree> population, int gen ) {
        int i, best = rd.nextInt(POPULATION_SIZE);
        fitnessBestPop = fitness[best];
        fitnessAvgPop = 0.0;

        for (i = 0; i < POPULATION_SIZE; i ++ ) {
            fitnessAvgPop += fitness[i];
            if ( fitness[i] > fitnessBestPop) {
                best = i;
                fitnessBestPop = fitness[i];
            }
        }
        fitnessAvgPop /= POPULATION_SIZE;
        System.out.print("Generation="+gen+", avg Fitness="+(-fitnessAvgPop)+", best Fitness="+(-fitnessBestPop)+", best population: "+best+"\n");
        //System.out.print(population.get(best).toCode());
        bestLastPop = best;
        System.out.flush();
    }

    Tree crossover(Tree parent1, Tree parent2) {
        Tree offspring = SerializationUtils.clone(parent1);
        offspring.crossover(parent2);
        return offspring;
    }

    void evolve() {
        try {
            Tree newInd;

            stats(fitness, population, 0);
            for (int gen = 1; gen < GENERATIONS; gen++) {
                if (fitnessBestPop > -1e-5) {
                    System.out.print("PROBLEM SOLVED\n");
                    System.out.print(population.get(bestLastPop).toCode());
                    System.exit(0);
                }
                for (int i = 0; i < POPULATION_SIZE; i++) {

//                    if (rd.nextDouble() < 1) {
//                        // TODO: CROSSOVER
//                        int parent1 = tournament();
//                        int parent2 = tournament();
//                        newInd = crossover(population.get(parent1), population.get(parent2));
//                        newInd.toCode();
                    //}
                    //else
                    //{
                        // MUTATE
                        int parent = tournament();
                        newInd = SerializationUtils.clone(population.get(parent));
                        newInd.mutate();
                    //}

                    int offspring = negativeTournament();
                    population.set(offspring, newInd);
                    fitness[offspring] = fitnessFunction(newInd);
                }
                stats(fitness, population, gen);
            }
            System.out.print(population.get(bestLastPop).toCode());
            System.out.println("-----------------------------------------------------------------------------------");
            System.out.print("PROBLEM NOT SOLVED\n");
            System.exit(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void test()
    {

    }

    void testMutate()
    {
        // create mutate element
        Tree treeAfterMutate = new Tree(population.get(0));
        treeAfterMutate.mutate();

        // show in console
        System.out.print(population.get(0).toCode());
        System.out.print(treeAfterMutate.toCode());

        // show tree
        MyJTree.ShowTree(new ArrayList<>(){{add(population.get(0));}});
        MyJTree.ShowTree(new ArrayList<>(){{add(treeAfterMutate);}});
    }

    void testCrossOver()
    {
        // TODO:
    }

    void testCopy()
    {
        // copy
        Tree copy = SerializationUtils.clone(population.get(0));

        // show in console
        System.out.print(population.get(0).toCode());
        System.out.print(copy.toCode());

        // show tree
        MyJTree.ShowTree(new ArrayList<>(){{add(population.get(0));}});
        MyJTree.ShowTree(new ArrayList<>(){{add(copy);}});
    }

    void testDeserialization()
    {
        Serializer serializer = new Serializer();
        Tree desTree = serializer.deserialize("202211301843.txt");
        MyJTree.ShowTree(new ArrayList<>(){{add(desTree);}});
    }

    void testSerialization()
    {
        String fileName = new SimpleDateFormat("yyyyMMddHHmm'.txt'").format(new Date());
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            SerializationUtils.serialize(population.get(0), fos);
            fos.close();

            FileInputStream fis = new FileInputStream(fileName);

            Tree desTree = SerializationUtils.deserialize(fis);
            System.out.println("-------------DESERIALIZED--------------------");
            System.out.print(desTree.toCode());
            fis.close();
        } catch (IOException ignore) {

        }
    }
}
