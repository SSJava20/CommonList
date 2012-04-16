/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SynhronizedSort;

import java.util.concurrent.BrokenBarrierException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jeka
 */
public class Sleeper<ToCompare extends Comparable<ToCompare>> extends SynhronizedSort<ToCompare> {

    int milisec;
    public Sleeper(int m){
        milisec=m;
    }
    public void run() {
        while (true) {
            try {
                Thread.sleep(milisec);
                try {
                    gate.await();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                } catch (BrokenBarrierException ex) {
                    ex.printStackTrace();
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Sleeper.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
