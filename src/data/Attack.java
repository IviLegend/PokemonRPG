package data;

public class Attack
{
    /// FIELDS
    // Basic information
    public String name;
    public ElementType type;

    public AttackCategory attackCategory;

    // Attack stats
    public int power;
    public int precision;
    public int powerPoints;
    public AttackTarget target;
    public boolean contact;
    public int priority;
}
