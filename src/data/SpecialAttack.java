package data;

import data.attack.AdditionalEffect;
import data.attack.Attack;
import data.attack.AttackCategory;
import data.attack.AttackTarget;
import entity.Pokemon;

/**
 * The SpecialAttack class is a class that will store every attack that has some special behaviour.
 */
public class SpecialAttack extends Attack
{
    /// FIELDS
    public AdditionalEffect additionalEffect;

    /// CONSTRUCTORS
    public SpecialAttack(String name, String description, ElementType type, AttackCategory attackCategory, AdditionalEffect additionalEffect, int power, int precision, int powerPoints, AttackTarget target, boolean contact, int priority, AdditionalEffect additionalEffect1)
    {
        super(name, description, type, attackCategory, additionalEffect, power, precision, powerPoints, target, contact, priority);
        this.additionalEffect = additionalEffect1;
    }

    /// METHODS
    @Override
    public void processAttack(Pokemon objective, Pokemon attacker)
    {
        super.processAttack(objective, attacker);
        if (additionalEffect != null)
        {
            additionalEffect.effect(objective, attacker);
        }
    }
}
