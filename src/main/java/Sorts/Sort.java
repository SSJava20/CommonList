package Sorts;

/**
 * Created with IntelliJ IDEA.
 * User: stvad
 * Date: 14.04.12
 * Time: 0:42
 * To change this template use File | Settings | File Templates.
 */
public abstract class Sort<ToCompare extends Comparable<ToCompare> >
{
    public abstract void sort(ToCompare[] data);
}
