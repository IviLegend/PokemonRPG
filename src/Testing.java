import battle.Battle;
import data.*;
import data.attack.Attack;
import data.attack.AttackCategory;
import data.attack.AttackEffects;
import data.attack.AttackTarget;
import entity.Pokemon;
import other.Utils;

import java.util.HashMap;
import java.util.Map;

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

        System.out.println(Utils.separateNumberWithDots(100_000_000));

        System.out.println("true: " + countTrue);
        System.out.println("false: " + countFalse);

        Attack impactrueno = new Attack("Impactrueno", "Descripción", ElementType.ELECTRIC, AttackCategory.PHYSICAL, (objective, attacker) -> attackEffects.impactrueno(objective, attacker), 50, 100, 15, AttackTarget.EVERY_OPONENT, true, 0);

        Battle battle = new Battle();

        Map<Attack, Integer> kyogreAttackMap = new HashMap<>();
        kyogreAttackMap.put(impactrueno, 11);

        PokemonData kyogre = new PokemonData("Kyogre", ElementType.DRAGON, ElementType.ELECTRIC, kyogreAttackMap);

        System.out.println(battle.getEffectivity(impactrueno, kyogre.principalType, kyogre.secondaryType));

        Pokemon kyogreIvan = new Pokemon(kyogre, 10);
        kyogreIvan.levelUp();

        for (int i = 0; i < 100; i++)
        {

        }
    }
}
