package SynhronizedSort;

import java.util.concurrent.CyclicBarrier;

/**
 * Created with IntelliJ IDEA.
 * User: stvad
 * Date: 14.04.12
 * Time: 0:42
 * To change this template use File | Settings | File Templates.
 */
public abstract class SynhronizedSort<ToCompare extends Comparable<ToCompare> > implements Runnable
{
    protected CyclicBarrier gate;
    protected ToCompare[] data;
    
    public void setGate(CyclicBarrier gate){
        this.gate=gate;
    }
    public void sort(ToCompare[] data) {
        this.data = data;
    }
}
