package list;

import java.util.Iterator;

/**
 * Created by IntelliJ IDEA.
 * User: stvad
 * Date: 21.03.12
 * Time: 0:19
 * To change this template use File | Settings | File Templates.
 */
public class DoubleLinkedListInt extends ListInt
{
    protected class DoubleListNode
    {
        DoubleListNode next;
        DoubleListNode previous;
        //        DoubleListNode begin;
        int data;

        public DoubleListNode(DoubleListNode prev, DoubleListNode nxt, int ndata)
        {
            next = nxt;
            data = ndata;
            previous = prev;
        }
    }

    class InnerIterator implements java.util.Iterator<Integer>
    {
        DoubleListNode curNode = begin;

        public boolean hasNext()
        {
            return (curNode.next != null);  //To change body of implemented methods use File | Settings | File Templates.
        }

        public Integer next()
        {
            Integer toret = curNode.data;
            curNode = curNode.next;
            return toret;  //To change body of implemented methods use File | Settings | File Templates.
        }

        public void remove()
        {
            //To change body of implemented methods use File | Settings | File Templates.
        }
    }

    protected DoubleListNode begin;
    protected DoubleListNode end;

    public DoubleLinkedListInt()
    {
        clear();
    }

    protected DoubleListNode getNode(int index)
    {
        DoubleListNode temp = begin;
        int cnt = 0;
        while (cnt++ != index && temp != null)
            temp = temp.next;

        return temp;
    }

    @Override
    public void add(int index, int item)
    {
        if (index == 0 || end == null)
            addFirst(item);
        else
        {
            DoubleListNode addAfter = getNode(index-1);
            DoubleListNode added = new DoubleListNode(addAfter, addAfter.next, item);
            addAfter.next = added;
            size++;
        }

    }

    @Override
    public void addFirst(int item)
    {
        DoubleListNode added = new DoubleListNode(null, begin, item);
        begin = added;
        if (size == 0)
            end = added;
        size++;
    }

    @Override
    public void addLast(int item)
    {
        if (end == null)
            addFirst(item);
        else
        {
            DoubleListNode added = new DoubleListNode(end, null, item);
            end.next = added;
            end = added;
            size++;
        }
    }

    @Override
    public void clear()
    {
        begin = null;
        end = null;
        size = 0;
    }

    @Override
    public void del(int index)
    {
        DoubleListNode sn = getNode(index);
        if(sn != null)
        {
            if(sn.previous != null)
                sn.previous.next = sn.next;
            if(sn.next != null)
                sn.next.previous = sn.previous;
            size--;
        }
    }

    @Override
    public int get(int index)
    {
        return getNode(index).data;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void set(int index, int item)
    {
        getNode(index).data = item;
    }

    @Override
    public int indexOf(int item)
    {
        int cnt = 0;
        DoubleListNode tmp = begin;
        while (tmp.data != item && tmp != null)
        {
            tmp = tmp.next;
            cnt++;
        }
        return cnt;
    }

    @Override
    public Iterator<Integer> getInnerIterator()
    {
        return new InnerIterator();  //To change body of implemented methods use File | Settings | File Templates.
    }
}
