import data.*;
import other.Utils;

public class Testing
{
    public static void main(String[] args)
    {
        AttackEffects attackEffects = new AttackEffects();
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

        Attack impactrueno = new Attack("Impactrueno", "Descripción", ElementType.ELECTRIC, AttackCategory.PHYSICAL, (objective, attacker) -> attackEffects.impactrueno(objective, attacker), 50, 100, 15, AttackTarget.EVERY_OPONENT, true, 0);
    }
}
