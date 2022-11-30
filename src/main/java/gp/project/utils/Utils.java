package gp.project.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Utils {
    public static Integer countNodes = 0;

    public static Integer MAX_DEPTH = 5;

    public static List<Integer> declarationNumbers = new ArrayList<>();

    public static int GetRandomDeclarationNumbers(){ return declarationNumbers.get(rd.nextInt(declarationNumbers.size())); }

    public static Random rd = new Random();

    public static int GetRandomNumberBetween(int first, int last)
    {
        return rd.nextInt(last - first + 1) + first;
    }

    public static int GetRandomNumber(int value)
    {
        return rd.nextInt(value);
    }

    public static void SetSeed(long seed)
    {
        rd.setSeed(seed);
    }
}
