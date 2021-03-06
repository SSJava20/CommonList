package list;

import Sorts.Sort;

import java.util.Iterator;

public class ArrayListInt extends ListInt
{
    public static final int START_SIZE = 20;
    private Integer[] items = new Integer[START_SIZE];
    private int indexFirst;

    public void SortMe(Sort type)
    {
        type.sort(items);
    }

    @Override
    public void add(int index, int item)
    {
        if (size >= items.length)
        {
            Integer[] items2 = new Integer[ items.length * 2];
            System.arraycopy(items, 0, items2, 0, items.length);
            items = items2;
        }
        if (size > 0)
        {
            for (int i = size - 1; i > index; i--)
                items[i + 1] = items[i];
        } else
            index = 0;
        items[index] = item;
        size++;
    }

    @Override
    public void addFirst(int item)
    {
        add(0, item);
    }

    @Override
    public void addLast(int item)
    {
        add(size, item);
    }

    @Override
    public void clear()
    {
        items = new Integer[ START_SIZE];
        size = 0;
    }

    @Override
    public void del(int index)
    {
        for (int i = index; i < size - 1; i++)
            items[i] = items[i + 1];
        size--;
    }

    @Override
    public int get(int index)
    {
        return items[index];
    }

    @Override
    public void set(int index, int item)
    {
        items[index] = item;
    }

    public void sort()
    {
        for (int i = 0; i < size; i++)
        {
            for (int j = i; j < size; j++)
            {
                if (items[j] < items[i])
                {
                    int tmp = items[i];
                    items[i] = items[j];
                    items[j] = tmp;
                }
            }
        }
    }

    /*
      * (non-Javadoc)
      *
      * @see list.ListInt#indexOf(int)
      */
    @Override
    public int indexOf(int item)
    {
        for (int i = 0; i < items.length; i++)
        {
            if (items[i] == item)
                return i;
        }
        return -1;
    }

    class InnerIterator implements java.util.Iterator<Integer>
    {
        int curIndex;

        public boolean hasNext()
        {
            return curIndex + 1 < size;
        }

        public Integer next()
        {
            return items[curIndex++];
        }

        public void remove()
        {
            // TODO Auto-generated method stub
        }

    }

    /* (non-Javadoc)
      * @see list.ListInt#getInnerIterator()
      */
    @Override
    public java.util.Iterator<Integer> getInnerIterator()
    {
        return new InnerIterator();
    }

}
