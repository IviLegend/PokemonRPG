package exceptions;

public class NotAnyPokemonInTeamException extends RuntimeException
{
    public NotAnyPokemonInTeamException(String message)
    {
        super(message);
    }
}
