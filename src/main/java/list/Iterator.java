package list;

public class Iterator
{
    private ListInt list;
    private int i = 0;

    public Iterator(ListInt list)
    {
        this.list = list;
    }

    public boolean hasNext()
    {
        if (i < list.size())
            return true;
        return false;
    }

    public int next()
    {
        return list.get(i++);
    }
}