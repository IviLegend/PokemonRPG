package exceptions;

public class InvalidCharacterAtNameException extends RuntimeException
{
    public InvalidCharacterAtNameException(String message)
    {
        super(message);
    }
}
