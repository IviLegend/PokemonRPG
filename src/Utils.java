
import java.util.Random;

/**
 * The Utils class contains some useful static methods.
 */
public class Utils
{
    public static int generateRandomNumber(int min, int max)
    {
        if (min > max)
        {
            throw new IllegalArgumentException("The minimum value cannot be lower than the maximum value.");
        }
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }
}
