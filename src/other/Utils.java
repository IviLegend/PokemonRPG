package other;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * The other.Utils class contains some useful static methods.
 */
public class Utils
{
    /**
     * Generates a random number between 2 values.
     * @param min The lower value than can be generated, included.
     * @param max The higher value than can be generated, included.
     * @return The number generated.
     */
    public static int generateRandomNumber(int min, int max)
    {
        if (min > max)
        {
            throw new IllegalArgumentException("The minimum value cannot be lower than the maximum value.");
        }

        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }

    /**
     * @param probability The probability of something happening.
     * @return
     * <ul>
     *     <li>{@code true} - If the probability succeed.</li>
     *     <li>{@code false} - If the probability failed.</li>
     * </ul>
     */
    public static boolean calculateProbability(double probability)
    {
        if (probability > 100)
        {
            throw new IllegalArgumentException("The probability must be lower than 100%");
        }

        probability *= 100;
        int number = generateRandomNumber(1, 10000);

        return number <= probability;
    }

    /**
     *
     * @param map
     * @param value
     * @return
     */
    public static <K, V> List<K> getValuesFromMap(Map<K, V> map, V value)
    {
        List<K> values = new ArrayList<>();
        for (Map.Entry<K, V> entrada : map.entrySet())
        {
            if (entrada.getValue().equals(value))
            {
                values.add(entrada.getKey());
            }
        }
        return values;
    }

    /**
     * Separates a number with dots.
     */
    public static String separateNumberWithDots(Number number)
    {
        String newNumber = String.valueOf(number);
        String numberWithDots = "";

        int numberCount = 0;
        for (int i = newNumber.length() - 1; i > 0; i--)
        {
            if (numberCount != 3)
            {
                numberWithDots += newNumber.charAt(i);
                numberCount++;
            }
            else
            {
                numberWithDots += ".";
                numberCount = 0;
            }
        }
        numberWithDots += newNumber.charAt(0);

        return invertString(numberWithDots);
    }

    public static String invertString(String originalString)
    {
        String newString = "";

        for (int i = 0; i < originalString.length(); i++)
        {
            newString += originalString.charAt(originalString.length()-i-1);
        }

        return newString;
    }
}
