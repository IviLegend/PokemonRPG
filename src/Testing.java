public class Testing
{
    public static void main(String[] args)
    {
        int countTrue = 0;
        int countFalse = 0;
        for (int i = 0; i < 100000; i++)
        {
            boolean prob = Utils.calculateProbability(10);

            if (prob) countTrue++;
            else countFalse++;
        }

        System.out.println("true: " + countTrue);
        System.out.println("false: " + countFalse);
    }
}
