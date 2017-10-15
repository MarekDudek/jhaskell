package jhaskell.data.utils;

import jhaskell.data.list.ConsList;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static jhaskell.data.list.ConsList.cons;
import static jhaskell.data.list.ConsList.nil;

public final class Util
{
    @SafeVarargs
    @SuppressWarnings("varargs")
    public static <T> List<T> list(T... a)
    {
        return newArrayList(a);
    }

    public static <A> ConsList<A> consList(A... as)
    {
        ConsList<A> l = nil();
        for (final A a : as)
            l = cons(a, l);
        return l;
    }
}
