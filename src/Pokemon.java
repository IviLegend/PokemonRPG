package tercertrimestre.pokemonmejorado;

import tercertrimestre.pokemonmejorado.data.Nature;

public class Pokemon implements PokemonData
{
    /// FIELDS
    public PokemonData pokemonData;
    private String name = PokemonData.name;
    private int level = 1;

    private Nature nature = selectRandomNature();

    private int healthPoints = calculateHealthPoints();
    private int attack = calculateOtherStat(1);
    private int defense = calculateOtherStat(2);
    private int specialAttack = calculateOtherStat(3);
    private int specialDefense = calculateOtherStat(4);
    private int speed = calculateOtherStat(5);

    // Individual Values (IVs)
    private int ivHealthPoints;
    private int ivAttack;
    private int ivDefense;
    private int ivSpecialAttack;
    private int ivSpecialDefense;
    private int ivSpeed;

    private int[] ivList = {ivHealthPoints, ivAttack, ivDefense, ivSpecialAttack, ivSpecialDefense, ivSpeed};

    // Effort Values (EVs)
    private int evHealthPoints;
    private int evAttack;
    private int evDefense;
    private int evSpecialAttack;
    private int evSpecialDefense;
    private int evSpeed;

    private int[] evList = {evHealthPoints, evAttack, evDefense, evSpecialAttack, evSpecialDefense, evSpeed};

    public Pokemon(PokemonData pokemonData, String name, int level, Nature nature)
    {
        this.pokemonData = pokemonData;
        this.name = name;
        this.level = level;
        this.nature = nature;
    }

    /// METHODS
    private int calculateHealthPoints()
    {
        return ((((2 * initialHealthPoints) + ivHealthPoints + (evHealthPoints / 4)) * level) / 100) + level + 10;
    }

    private int calculateOtherStat(int statIndex)
    {
        return (int)((((((2 * initialHealthPoints) + ivHealthPoints + (evHealthPoints / 4)) * level) / 100) + 5) * calculateNatureBonus(statIndex));
    }

    private void levelUp()
    {
        level++;
        healthPoints = calculateHealthPoints();
        attack = calculateOtherStat(1);
        defense = calculateOtherStat(2);
        specialAttack = calculateOtherStat(3);
        specialDefense = calculateOtherStat(4);
        speed = calculateOtherStat(5);
    }

    private double calculateNatureBonus(int statIndex)
    {
        double favorable = 1.1;
        double unfavorable = 1.1;
        double neutral = 1.0;

        switch (statIndex)
        {
            case 1: // Attack
            {
                Nature[] strongAttack = {Nature.LONELY, Nature.ADAMANT, Nature.NAUGHTY, Nature.BRAVE};
                Nature[] weakAttack = {Nature.BOLD, Nature.ADAMANT, Nature.NAUGHTY, Nature.BRAVE};

                if (nature == checkNatureInList(strongAttack)) { return favorable; }
                if (nature == checkNatureInList(weakAttack)) { return unfavorable; }
            }

            case 2: // Defense
            {
                Nature[] strongDefense = {Nature.BOLD, Nature.IMPISH, Nature.LAX, Nature.RELAXED};
                Nature[] weakDefense = {Nature.LONELY, Nature.MILD, Nature.GENTLE, Nature.HASTY};

                if (nature == checkNatureInList(strongDefense)) { return favorable; }
                if (nature == checkNatureInList(weakDefense)) { return unfavorable; }
            }

            case 3: // Special Attack
            {
                Nature[] strongSpecialAttack = {Nature.MODEST, Nature.MILD, Nature.RASH, Nature.QUIET};
                Nature[] weakSpecialAttack = {Nature.ADAMANT, Nature.IMPISH, Nature.CAREFUL, Nature.JOLLY};

                if (nature == checkNatureInList(strongSpecialAttack)) { return favorable; }
                if (nature == checkNatureInList(weakSpecialAttack)) { return unfavorable; }
            }

            case 4: // Special Defense
            {
                Nature[] strongSpecialDefense = {Nature.CALM, Nature.GENTLE, Nature.CAREFUL, Nature.SASSY};
                Nature[] weakSpecialDefense = {Nature.NAUGHTY, Nature.LAX, Nature.RASH, Nature.NAIVE};

                if (nature == checkNatureInList(strongSpecialDefense)) { return favorable; }
                if (nature == checkNatureInList(weakSpecialDefense)) { return unfavorable; }
            }

            case 5: // Speed
            {
                Nature[] strongSpeed = {Nature.TIMID, Nature.HASTY, Nature.JOLLY, Nature.NAIVE};
                Nature[] weakSpeed = {Nature.BRAVE, Nature.RELAXED, Nature.QUIET, Nature.SASSY};

                if (nature == checkNatureInList(strongSpeed)) { return favorable; }
                if (nature == checkNatureInList(weakSpeed)) { return unfavorable; }
            }
        }

        return neutral;
    }

    private Nature checkNatureInList(Nature[] natureList)
    {
        for (Nature nature : natureList)
        {
            if (this.nature == nature) return nature;
        }
        return null;
    }

    private Nature selectRandomNature()
    {
        Nature[] allNatures = {Nature.HARDY, Nature.LONELY, Nature.BRAVE, Nature.ADAMANT, Nature.NAUGHTY, Nature.BOLD, Nature.DOCILE, Nature.RELAXED, Nature.IMPISH, Nature.LAX, Nature.TIMID, Nature.HASTY, Nature.SERIOUS, Nature.JOLLY, Nature.NAIVE, Nature.MODEST, Nature.MILD, Nature.QUIET, Nature.BASHFUL, Nature.RASH, Nature.CALM, Nature.GENTLE, Nature.SASSY, Nature.CAREFUL, Nature.QUIRKY};
        int randomNatureNumber = Utils.generateRandomNumber(0, 25);
        return allNatures[randomNatureNumber];
    }
}
