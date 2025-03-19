package data;

/**
 * The PokemonData interface stores all the information for every Pokemon.
 */
public class PokemonData
{
    /// FIELDS
    // General fields
    public int pokemonNumber = 0;
    public String name = "Missingno";

    ElementType principalType = null;
    ElementType secondaryType = null;

    public Category category;
    public Growth growthType;

    double weigth = 0; // Expressed in KG
    double height = 0; // Expressed in M

    public double malePercentage;

    // Hability Fields
//    private Hability hability;
//    private Hability hiddenHability;

    // Combat fields
    int initialHealthPoints = 0;

    int initialAttack = 0;
    int initialDefense = 0;

    int initialSpecialAttack = 0;
    int initialSpecialDefense = 0;

    int initialSpeed = 0;

    int[] initialValues = {initialHealthPoints, initialAttack, initialDefense, initialSpecialAttack, initialSpecialAttack, initialSpecialDefense, initialSpeed};

    /// CONSTRUCTORS

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
        switch (module)
        {
            case 0 ->
            {
                return 0;
            }
            case 1 ->
            {
                return 0.008;
            }
            case 2 ->
            {
                return 0.014;
            }
        }
        return 0;
    }
}
