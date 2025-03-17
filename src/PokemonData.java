import data.Type;

public interface PokemonData
{
    /// FIELDS
    // General fields
    int pokemonNumber = 0;
    String name = "Missingno";

    Type principalType = null;
    Type secondaryType = null;

//    double weigth = 0; // Expressed in KG
//    double height = 0; // Expressed in M

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
}
