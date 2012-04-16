package SynhronizedSort;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created with IntelliJ IDEA. User: stvad Date: 14.04.12 Time: 0:55 To change
 * this template use File | Settings | File Templates.
 */
public class SynhronizedShellSort<ToCompare extends Comparable<ToCompare>> extends SynhronizedSort<ToCompare> {

    private void shell() throws InterruptedException, BrokenBarrierException {
        int[] d = {1, 4, 10, 23, 57, 145, 356, 911, 1968, 4711, 11969, 27901,
            84801, 213331, 543749, 1355339, 3501671, 8810089, 21521774,
            58548857, 157840433, 410151271, 1131376761, 2147483647};   // we'll pre-define d to increase performance
        int m = 0, k, i, j;
        ToCompare h;
        int length = data.length;
        while (d[m] < length) {
            ++m;
        }
        while (--m >= 0) {
            k = d[m];
            for (i = k; i < length; i++) {     //
                j = i;
                h = data[i];
                while ((j >= k) && (data[j - k].compareTo(h) == 1)) {
                    ///Synhronyzed value
                    //System.out.println("Shell working");
                    gate.await();
                    ///
                    data[j] = data[j - k];
                    j = j - k;
                }
                data[j] = h;
            }
        }
    }

    public void run() {
        try {
            shell();
            while (true) {
                gate.await();
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } catch (BrokenBarrierException ex) {
            ex.printStackTrace();
        }
    }
}
