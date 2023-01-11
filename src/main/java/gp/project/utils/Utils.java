package gp.project.utils;

import java.util.Random;

public class Utils {
    public static Integer countNodes = 0;

    public static double PROBABILITY_WIDTH_EXTENSION = 0.5;

    public static Integer MAX_DEPTH = 3;

    public static Random rd = new Random();

    public static boolean IsWidthExtension() { return rd.nextInt(100) < (int)(PROBABILITY_WIDTH_EXTENSION * 100); }

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
