package gp.project;

import gp.project.utils.Utils;
import org.apache.commons.lang3.SerializationUtils;

import java.util.ArrayList;
import java.util.List;

public class TinyGP {
    List<Tree> population = new ArrayList<>();
    double[] fitness;

    final int
            POPULATION_SIZE = 1,
            GENERATIONS = 2,
            TOURNAMENT_SIZE = 2,
            RANDOM_COUNT = 4,
            MIN_RANDOM = -5,
            MAX_RANDOM = 5;

    final List<List<Integer>> INPUTS = new ArrayList<List<Integer>>() {{
        add(new ArrayList<>() {{
            add(1);
            add(2);
        }});
        add(new ArrayList<>() {{
            add(3);
            add(4);
        }});
    }};
    // [0] => [1, 2]
    // [1] => [3, 4]

    final List<Integer> OUTPUTS = new ArrayList<>() {{
        add(1);
        add(2);
    }};
    // [0] => 1
    // [1] => 2

    public TinyGP(long seed) {
        fitness = new double[POPULATION_SIZE];

        if (seed >= 0)
            Utils.SetSeed(seed);

        for (int i = 0; i < RANDOM_COUNT; i++)
            Utils.declarationNumbers.add(Utils.GetRandomNumberBetween(MIN_RANDOM, MAX_RANDOM));

        createRandomPopulation();
    }

    int fitnessFunction(Tree tree) {
        int fitness = 0;

        for (int i = 0 ; i < OUTPUTS.size() ; i ++) {
            fitness += Math.abs(OUTPUTS.get(i) - tree.run(INPUTS.get(i)));
        }

        return fitness;
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
        tree.grow();

        return tree;
    }

    void evolve() {
        for (int gen = 1; gen < GENERATIONS; gen++) {
            for (int i = 0; i < POPULATION_SIZE; i++) {
                //TODO: add example mutation and crossover
                population.get(0).print();
            }
        }
        //MyJTree.ShowTree(new ArrayList<>(population));

        System.out.println("-----------------------------------------------------------------------------------");

        // # MUTATE 1
        //Tree treeToMutate = new Tree(population.get(0));
        //treeToMutate.mutate();
        //treeToMutate.print();
        //MyJTree.ShowTree(new ArrayList<>(){{add(treeToMutate);}});

        // # MUTATE 2 WITH SERIALIZATION
        Tree copy = SerializationUtils.clone(population.get(0));
        //copy.mutate();
        copy.print();
        System.out.print(copy.toCode());
        //MyJTree.ShowTree(new ArrayList<>(){{add(copy);}});

        //Serializer serializer = new Serializer();
        //Tree desTree = serializer.deserialize("202211301843.txt");
        //MyJTree.ShowTree(new ArrayList<>(){{add(desTree);}});
//        String fileName = new SimpleDateFormat("yyyyMMddHHmm'.txt'").format(new Date());
//        try {
//            FileOutputStream fos = new FileOutputStream(fileName);
//            SerializationUtils.serialize(copy, fos);
//            fos.close();
//
//            FileInputStream fis = new FileInputStream(fileName);
//
//            Tree desTree = (Tree) SerializationUtils.deserialize(fis);
//            System.out.println("-------------DESERIALIZED--------------------");
//            desTree.print();
//            fis.close();
//        } catch (IOException ignore) {
//
//        }

        System.out.print("PROBLEM ? SOLVED\n");
        //System.exit(1);
    }
}
