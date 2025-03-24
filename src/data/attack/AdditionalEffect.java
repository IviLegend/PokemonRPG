package data.attack;

import entity.Pokemon;

/**
 * The AdditionalEffect interface process the additional effects attacks can cause.
 */
@FunctionalInterface
public interface AdditionalEffect
{
    void effect(Pokemon objective, Pokemon attacker);
}
