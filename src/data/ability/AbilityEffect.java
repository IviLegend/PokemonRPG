package data.ability;

import entity.Pokemon;

/**
 * The Ability interfaces manages the pokémon's abilities.
 */
@FunctionalInterface
public interface AbilityEffect
{
    void habilityEffect(Pokemon objective, Pokemon attacker);
}
