package tests;

import static org.junit.Assert.*;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;
import java.util.Vector;

import list.ArrayListInt;
import list.ListInt;
import list.LinkedListInt;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ListIntTest
{

    public static final int TO_ADD_SIZE = 100;
    ListInt list;
    Class listClass;

    public ListIntTest(Class clazz, Object objects)
    {
        listClass = clazz;
    }

    @Before
    public void before() throws InstantiationException, IllegalAccessException
    {
        list = (ListInt) listClass.newInstance();
    }

    public void fillList()
    {
        for (int i = 0; i < TO_ADD_SIZE; i++)
        {
            list.addLast(i);
        }
    }

    @Test
    public void testAdd()
    {

        fillList();
        for (int i = 0; i < TO_ADD_SIZE; i++)
        {
            assertEquals(i, list.get(i));
        }
    }

    @Test
    public void testAddToPosition()
    {
        fillList();
        for (int i = 0; i < TO_ADD_SIZE; i++)
        {
            list.add(TO_ADD_SIZE / 2, i);
            assertEquals(i, list.get(TO_ADD_SIZE / 2));
        }
    }

    @Test
    public void testAddStart()
    {

        for (int i = 0; i < TO_ADD_SIZE; i++)
        {
            list.addFirst(i);
        }
        for (int i = 0; i < TO_ADD_SIZE; i++)
        {
            assertEquals(TO_ADD_SIZE - i - 1, list.get(i));
        }
    }

    @Test
    public void testSize()
    {
        assertEquals(list.size(), 0);
        fillList();
        assertEquals(list.size(), TO_ADD_SIZE);
        for (int i = 0; i < TO_ADD_SIZE / 2; i++)
        {
            list.del(i);
        }
        assertEquals(list.size(), TO_ADD_SIZE / 2);

        for (int i = 0; i < TO_ADD_SIZE; i++)
        {
            list.addLast(i);
        }
        assertEquals(list.size(), TO_ADD_SIZE + TO_ADD_SIZE / 2);
    }

    @Test
    public void testSort()
    {

        Random r = new Random();
        fillList();
        list.sort();
        for (int i = 0; i < TO_ADD_SIZE; i++)
        {
            assertEquals(i, list.get(i));
        }

        list.clear();

        for (int i = TO_ADD_SIZE; i >= 0; i--)
        {
            list.addLast(r.nextInt());
        }
        list.sort();
        for (int i = 0; i < TO_ADD_SIZE - 1; i++)
        {
            assertTrue(list.get(i) <= list.get(i + 1));
        }
    }

    @Test
    public void testSet()
    {

        fillList();
        for (int i = 0; i < TO_ADD_SIZE; i++)
        {
            list.set(i, i * 2);
        }
        for (int i = 0; i < TO_ADD_SIZE; i++)
        {
            assertEquals(i * 2, list.get(i));
        }
    }

    @Test
    public void testRemove()
    {
        fillList();
        for (int i = 0; i < TO_ADD_SIZE / 2; i++)
        {
            list.del(0);
        }
        assertEquals(TO_ADD_SIZE / 2, list.size());

        for (int i = 0; i < TO_ADD_SIZE / 2; i++)
        {
            list.del(0);
        }
        assertEquals(0, list.size());
    }

    @Test
    public void testClear()
    {
        fillList();
        list.clear();
        assertEquals(0, list.size());
    }

    @Test
    public void testIterator()
    {

        fillList();
        int i = 0;
        for (Integer value : list)
        {
            assertEquals(i, value.intValue());
            i++;
        }

    }

    @Parameters
    public static Collection parTestValues()
    {
        return Arrays.asList(new Object[][]{
//				{ ArrayListInt.class, "" },
                // { RoundIndexList.class, "" },
                {LinkedListInt.class, ""}});
    }
}
