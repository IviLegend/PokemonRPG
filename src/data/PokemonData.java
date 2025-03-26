package data;

import data.ability.Ability;
import data.attack.Attack;
import data.attack.TechnicalMachine;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * The PokemonData interface stores all the information for every entity.Pokemon.
 */
public class PokemonData
{
    /// FIELDS
    // General fields
    public int pokemonNumber = 0;
    public String name = "Missingno";
    public String description;

    public ElementType principalType = null;
    public ElementType secondaryType = null;

    public Category category;
    public Growth growthType;
    public Habitat habitat;

    public int captureRatio;

    public Ability abilityUnitary;
    public Ability abilitySecondary;
    public Ability abilityHidden;

    double weigth = 0; // Expressed in kilograms
    double height = 0; // Expressed in meters

    // TODO: Make the gender system.
    public double genderPercentage;

    public PokemonData pokemonEvolution = null;
    public int evolutionLevel = 0;

    public ArrayList<TechnicalMachine> TMList = new ArrayList<>();

    public int cycles;

    // Image fields
    // For sprites that change with the gender, use PokemonDataGender
    public BufferedImage iconImage;
    public BufferedImage frontImage;
    public BufferedImage frontImageShiny;
    public BufferedImage backImage;
    public BufferedImage backImageShiny;

    public BufferedImage footprint;
    public Silhouette silhouette;

    public ColorList color;

    // TODO: Change levelAttacks initialization to constructor when finished every system.
    public Map<Attack, Integer> levelAttacks = new HashMap<>();

    // Combat fields
    public int initialHealthPoints = 0;

    int initialAttack = 0;
    int initialDefense = 0;

    int initialSpecialAttack = 0;
    int initialSpecialDefense = 0;

    int initialSpeed = 0;

    int[] initialValues = {initialHealthPoints, initialAttack, initialDefense, initialSpecialAttack, initialSpecialAttack, initialSpecialDefense, initialSpeed};

    /// CONSTRUCTORS
    // TODO: Remove this constructor when finish testing
    public PokemonData(String name, ElementType principalType, ElementType secondaryType)
    {
        this.name = name;
        this.principalType = principalType;
        this.secondaryType = secondaryType;
    }

    /// METHODS
    public double getExperienceForLevel(int level)
    {
        switch(growthType)
        {
            case FAST:
            {
                return ((4 * Math.pow(level, 3)) / 5);
            }

            case NORMAL:
            {
                return (Math.pow(level, 3));
            }

            case SLOW:
            {
                return ((5 * Math.pow(level, 3)) / 4);
            }

            case PARABOLIC:
            {
                return ((1.2 * Math.pow(level, 3)) - (15 * Math.pow(level, 2)) + (100 * level) - (140));
            }

            case ERRATIC:
            {
                if ((level > 0) && (level <= 50))
                {
                    return ((Math.pow(level, 3)) * (2 - (0.02 * level)));
                }
                else if ((level >= 51) && (level <= 68))
                {
                    return ((Math.pow(level, 3)) * (1.5 - (0.01 * level)));
                }
                else if ((level >= 69) && (level <= 98))
                {
                    return ((Math.pow(level, 3)) * (1.274 - (0.02 * ((double) level / 3))) - erraticModule(level));
                }
                else if ((level >= 99) && (level <= 100))
                {
                    return ((Math.pow(level, 3)) * (1.6 - (0.01 * level)));
                }
            }

            case FLUCTUATING:
            {
                if ((level > 0) && (level <= 15))
                {
                    return (((Math.pow(level, 3)) * (24 + ((double) (level + 1) / 3)) / 50));
                }
                else if ((level >= 16) && (level <= 35))
                {
                    return ((Math.pow(level, 3)) * ((double) (14 + level) / 50));
                }
                else if ((level >= 36) && (level <= 100))
                {
                    return ((Math.pow(level, 3)) * ((double) (32 + (level / 2)) / 50));
                }
            }
        }
        return -1.0;
    }

    public double erraticModule(int level)
    {
        int module = (level % 3);
        double erraticModule = 0;
        switch (module)
        {
            case 0 -> erraticModule = 0;
            case 1 -> erraticModule = 0.008;
            case 2 -> erraticModule = 0.014;
        }
        return erraticModule;
    }

    /**
     * Checks if a pokémon has an specific Ability.
     * @param ability - The Ability that is going to be checked .
     * @return
     * <ul>
     *     <li>{@code true} - If the pokémon has this ability.</li>
     *     <li>{@code false} - If the pokémon doesn't have this ability.</li>
     * </ul>
     */
    public boolean checkIfHasAbility(Ability ability)
    {
        return (ability.equals(abilityUnitary) || ability.equals(abilitySecondary) || ability.equals(abilityHidden));
    }

    public int getStatsTotal()
    {
        return initialHealthPoints + initialAttack + initialDefense + initialSpecialAttack + initialSpecialDefense + initialSpeed;
    }
}
