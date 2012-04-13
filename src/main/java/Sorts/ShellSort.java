package Sorts;

/**
 * Created with IntelliJ IDEA.
 * User: stvad
 * Date: 14.04.12
 * Time: 0:55
 * To change this template use File | Settings | File Templates.
 */
public class ShellSort<ToCompare extends Comparable<ToCompare> > extends Sort<ToCompare>
{
    @Override
    public void sort(ToCompare[] data)
    {
        int[] d = {1, 4, 10, 23, 57, 145, 356, 911, 1968, 4711, 11969, 27901,
                84801, 213331, 543749, 1355339, 3501671, 8810089, 21521774,
                58548857, 157840433, 410151271, 1131376761, 2147483647};   // we'll pre-define d to increase performance
        int m = 0, k, i, j;
        ToCompare h;
        int length = data.length;
        while (d[m] < length) ++m;
        while (--m >= 0)
        {
            k = d[m];
            for (i = k; i < length; i++)
            {     //
                j = i;
                h = data[i];
                while ((j >= k) && (data[j - k].compareTo(h) == 1))
                {
                    data[j] = data[j - k];
                    j = j - k;
                }
                data[j] = h;
            }
        }
    }
}
