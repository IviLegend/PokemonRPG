package data.attack;

import entity.Pokemon;

public class AttackEffects
{
    public void guillotine(Pokemon objective)
    {
        objective.healthPoints = 0;
    }

    public void swordsDance(Pokemon attacker)
    {
        attacker.attack += attacker.calculateOtherStat(2, attacker.level+2);
    }

    public void whirlwind(Pokemon objective, Pokemon attacker)
    {
        // TODO: When combat is done, check if you are fighting with a trainer or with a wild pokemon
        if (attacker.level > objective.level)
        {
            // TODO: End combat
        }
    }

    public void sandAttack(Pokemon objective)
    {
//        objective.precision -=
    }

    public void impactrueno(Pokemon objective, Pokemon attacker)
    {
        System.out.println("Cosas");
    }
}
