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
                return ((0.8)*Math.pow(level, 3));
            }
            // TODO: Finish the experience types formulas
        }
        return 1.0;
    }
}
