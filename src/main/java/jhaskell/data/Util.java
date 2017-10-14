package jhaskell.data;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public final class Util
{
    @SafeVarargs
    @SuppressWarnings("varargs")
    public static <T> List<T> list(T... a)
    {
        return newArrayList(a);
    }
}
