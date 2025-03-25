package battle;

import data.ElementType;
import data.TypeChart;
import data.attack.Attack;
import data.attack.AttackCategory;
import entity.Pokemon;
import other.Utils;

public class Battle
{
    /// FIELDS
    public BattleType battleType;
    public Pokemon attacker;
    public Pokemon attacker2;

    public Pokemon objective;
    public Pokemon objective2;

    public Pokemon currentPokemonTurn;

    public int timesTriedToRun = 0;

    public int turn = 0;

    /// METHODS
    public void changeTurn()
    {

    }

    /**
     * Calculates the possibility of fleeing from a combat.
     * @param instantRun - If the method is called from a place where the run is always successfull.
     * @return If the run succeed or not.
     */
    public boolean run(boolean instantRun)
    {
        if (instantRun) { return true; }
        if ((battleType == BattleType.TRAINER) || (battleType == BattleType.TRAINER_DOUBLE)) { return false; }
        if (currentPokemonTurn.pokemonData.principalType == ElementType.GHOST) { return true; }

        int objectiveSpeed = objective.speed;
        if (objectiveSpeed == 0) { objectiveSpeed = 1; }

        timesTriedToRun++;

        int F = ((((currentPokemonTurn.speed * 128) / objectiveSpeed) + 30 * timesTriedToRun) % 256);

        return F < Utils.generateRandomNumber(0, 255);
    }

    public void changePokemon(Pokemon pokemonToChange)
    {

    }

    // Attacking methods
    public int getAttackDamage(Pokemon attacker, Attack attack, Pokemon objective)
    {
        return (int)Math.round((0.01 * getBonus(attacker, attack) * Utils.generateRandomNumber(85, 100)));
    }

    public double getBonus(Pokemon attacker, Attack attack)
    {
        if (attacker.pokemonData.principalType == attack.type) { return 1.5; }
        else { return 1.0; }
    }

    /**
     *
     * @param attack - The attack that is used.
     * @param objectivePrincipalType - The objective's principal type.
     * @param objectiveSecondaryType - The objective's secondary type, even if it's null.
     * @return
     * <ul>
     *     <li>{@code 0.0}</li>
     *     <li>{@code 0.25}</li>
     *     <li>{@code 0.5}</li>
     *     <li>{@code 1.0}</li>
     *     <li>{@code 2.0}</li>
     *     <li>{@code 4.0}</li>
     * </ul>
     */
    public double getEffectivity(Attack attack, ElementType objectivePrincipalType, ElementType objectiveSecondaryType)
    {
        double a;
        double b;

        a = TypeChart.effectiveness[attack.type.ordinal()][objectivePrincipalType.ordinal()];

        if (objectiveSecondaryType == null) { b = 1.0; }
        else { b = TypeChart.effectiveness[attack.type.ordinal()][objectiveSecondaryType.ordinal()]; }

        return a * b;
    }

    public int getAttack(Pokemon attacker, Attack attack)
    {
        if (attack.attackCategory == AttackCategory.PHYSICAL) { return attacker.attack; }
        else if (attack.attackCategory == AttackCategory.SPECIAL) { return attacker.specialAttack; }
        return 0; // TODO: Check if this brokes something (probably yes)
    }
}
