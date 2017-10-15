package jhaskell.list;

import jhaskell.data.list.ConsList;
import org.junit.Test;

import static jhaskell.data.list.ConsList.cons;
import static jhaskell.data.list.ConsList.nil;
import static jhaskell.data.list.ConsLists.*;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public final class ConsListTest
{
    @Test
    public void is_list_empty()
    {
        assertTrue(empty(nil()));
        assertFalse(empty(cons(1, nil())));
    }

    @Test
    public void what_is_the_length()
    {
        // given
        final ConsList<Integer> nil = nil();
        final ConsList<Integer> three = cons(3, nil);
        final ConsList<Integer> two = cons(2, three);
        final ConsList<Integer> one = cons(1, two);
        // then
        assertThat(length(nil), is(0));
        assertThat(length(three), is(1));
        assertThat(length(two), is(2));
        assertThat(length(one), is(3));
    }

    @Test
    public void mapping()
    {
        // given
        final ConsList<Integer> ns = cons(1, cons(2, cons(3, nil())));
        final ConsList<String> ss = map(ns, Object::toString);
        // then
        assertTrue(equal(ss, cons("1", cons("2", cons("3", nil())))));
    }

    @Test
    public void pattern_matching()
    {
        // given
        final ConsList<Integer> ns = cons(1, cons(2, cons(3, nil())));
        // when
    }
}
