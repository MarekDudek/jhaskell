package jhaskell.data.utils;

public class UglyStuff
{
    public static <A> A error()
    {
        throw new RuntimeException("error");
    }

    public static <A> A error(String message)
    {
        throw new RuntimeException(message);
    }
}
