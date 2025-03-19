
import java.util.Random;

/**
 * The Utils class contains some useful static methods.
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
}
