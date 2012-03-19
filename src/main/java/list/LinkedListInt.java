package list;

/**
 * Created by IntelliJ IDEA.
 * User: stvad
 * Date: 19.03.12
 * Time: 21:00
 * To change this template use File | Settings | File Templates.
 */
public class LinkedListInt extends ListInt
{
    protected class listNode
    {
        listNode next;
        int data;

        public listNode(listNode nxt, int ndata)
        {
            next = nxt;
            data = ndata;
        }
    }

    protected listNode begin;
    //listNode

    public LinkedListInt()
    {
        size = 0;
        begin = null;
    }

    protected listNode getNode(int index)
    {
        listNode temp = begin;
        int cnt = 0;
        while (cnt++ != index && temp != null)
            temp = temp.next;

        return temp;
    }
    
    @Override
    public void add(int index, int item)
    {
        listNode temp = getNode(index);
        if(temp != null)
        {
            temp.next = new listNode(temp.next, item);
            size++;
        }
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
        begin = null;
        size = 0;
    }

    @Override
    public void del(int index)
    {

    }

    @Override
    public int get(int index)
    {
        return getNode(index).data;
    }

    @Override
    public void set(int index, int item)
    {
        getNode(index).data = item;
    }
}
