package list;

public abstract class ListInt
{

    protected int size;

    protected ListInt()
    {
    }

    public abstract void add(int index, int item);

    public abstract void addFirst(int item);

    public abstract void addLast(int item);

    public abstract void clear();

    public abstract void del(int index);

    public abstract int get(int index);

    public abstract void set(int index, int item);

    public Iterator iterator()
    {
        return new Iterator(this);
    }

    public int size()
    {
        return size;
    }

    public void sort()
    {

    }
}
