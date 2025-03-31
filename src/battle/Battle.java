package battle;

import data.ElementType;
import data.StatusCondition;
import data.StatusEffects;
import data.TypeChart;
import data.attack.Attack;
import data.attack.AttackCategory;
import entity.Pokemon;
import other.Utils;

import java.util.Collections;

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

    public Attack chosedAttack;

    public StatusEffects[] attacker1StatusEffects;

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

    public void processTurn()
    {
        // TODO: Each Pokémon decides their action

        // TODO: Check who has the attacking priority

        // TODO: For each Pokémon:
        // TODO: Process the action of the trainer (Run, Attack, Change or Use an item)
        /*
            If run
            // TODO: Try running with max priority
            If change
            // TODO: Change with max priority
            If use an item
            // TODO: Use the item with max priority

            If attack
            // TODO: Check who has the priority

            // TODO: Process the status conditions for that pokemon (Paralized, Burned...)

            // TODO: Process the attack.

            // TODO: Process the status effects (Confused, Cursed...)

            // TODO: Process the status conditions again (Paralized, Burned...) There should be a differentiation on if it's being checked at the start or at the end.
         */
    }

    public void changePokemon(Pokemon pokemonToChange)
    {
        attacker = pokemonToChange;
    }

    // Attacking methods
    public int getAttackDamage(Attack attack, Pokemon attacker, Pokemon objective)
    {
        // TODO: Replace critic index with the attacker's critic index.
        boolean isCritic = isCritic(1);
        double criticMultiplier = 1.0;

        if (isCritic) { criticMultiplier = 1.5; }

        double bonus = getBonus(attacker, attack);
        double effectivity = getEffectivity(attack, objective.pokemonData.principalType, objective.pokemonData.secondaryType);
        double variation = Utils.generateRandomNumber(85, 100);
        double attackerLevel = attacker.level;
        double attackType = getAttack(attacker, attack);
        double attackPower = attack.power;
        double objectiveDefense = objective.defense;

        return (int) ((int) Math.round(0.01 * bonus * effectivity * variation * ((((0.2 * attackerLevel + 1) * attackType * attackPower) / 25 * objectiveDefense) + 2)) * criticMultiplier);
    }

    public boolean isCritic(int criticIndex)
    {
        // TODO: When file reading abilities, check if this isn't broken (It probably is).
        /*if (objective.pokemonData.checkIfHasAbility(shellArmor) || objective.pokemonData.checkIfHasAbility(battleArmor))
        {
            return false;
        }*/

        // TODO: Finish checking special conditions.

        double prob = 0.0;

        switch (criticIndex)
        {
            case 0 -> prob = 6.25;
            case 1 -> prob = 12.5;
            case 2 -> prob = 25.0;
            case 3 -> prob = 33.33;
            case 4 -> prob = 50.0;
        }

        return Utils.calculateProbability(prob);
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
