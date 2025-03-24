package battle;

import data.ElementType;
import entity.Pokemon;
import other.Utils;

public class Battle
{
    public BattleType battleType;
    public Pokemon attacker;
    public Pokemon attacker2;

    public Pokemon objective;
    public Pokemon objective2;

    public Pokemon currentPokemonTurn;

    public int timesTriedToRun = 0;

    public int turn = 0;

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
}
