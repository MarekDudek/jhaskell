package jhaskell;

import jhaskell.data.Semigroup;
import jhaskell.data.list.ConsList;
import jhaskell.data.list.ConsLists;
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
    public void string()
    {
        // given
        final ConsList<Integer> ns = cons(1, cons(2, cons(3, nil())));
        assertThat(ns.toString(), is("1,2,3"));
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

    @Test
    public void two_lists_can_be_appended()
    {
        // given
        final Semigroup<ConsList<Integer>> S = ConsLists.Semigroup();
        // then
        assertTrue(equal(S.mappend(nil(), nil()), nil()));
        assertTrue(equal(S.mappend(nil(), cons(1, nil())), cons(1, nil())));
        assertTrue(equal(S.mappend(cons(1, nil()), nil()), cons(1, nil())));
        assertTrue(equal(S.mappend(cons(1, nil()), cons(2, nil())), cons(1, cons(2, nil()))));
        // given
        final ConsList<Integer> as = cons(1, cons(2, cons(3, nil())));
        final ConsList<Integer> bs = cons(4, cons(5, cons(6, nil())));
        // when
        final ConsList<Integer> cs = S.mappend(as, bs);
        // then
        assertTrue(equal(cs, cons(1, cons(2, cons(3, cons(4, cons(5, cons(6, nil()))))))));
    }
}
