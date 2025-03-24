package data.attack;

import data.ElementType;
import entity.Pokemon;
import other.Constants;

public class Attack
{
    /// FIELDS
    // Basic information
    public String name;
    public String description;
    public ElementType type;

    public AttackCategory attackCategory;

    // Attack stats
    public int power;
    public int precision;
    public int powerPoints;
    public AttackTarget target;
    public boolean contact;
    public int priority;

    /// CONSTRUCTORES
    public Attack(String name, String description, ElementType type, AttackCategory attackCategory, AdditionalEffect additionalEffect, int power, int precision, int powerPoints, AttackTarget target, boolean contact, int priority)
    {
        this.name = name;
        this.description = description;
        this.type = type;
        this.attackCategory = attackCategory;
        this.power = power;
        this.precision = precision;
        this.powerPoints = powerPoints;
        this.target = target;
        this.contact = contact;
        this.priority = priority;
    }

    /// METHODS
    public void processAttack(Pokemon objective, Pokemon attacker)
    {

    }

    /**
     * @return The maximum PP that an Attack can have.
     */
    public int calculateMaxPowerPoints()
    {
        return powerPoints + (powerPoints * ((Constants.MAX_MORE_PP_ALLOWED * (Constants.MORE_PP_UPGRADE_PERCENTAGE / 100))));
    }
}
