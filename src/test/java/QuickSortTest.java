

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
import tests.*;
import Sorts.QuickSort;
import java.util.Random;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Jeka
 */
public class QuickSortTest {

    private Integer[] mas;
    private QuickSort a = new QuickSort();
    private final int COUNT=100;

    public QuickSortTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        mas = new Integer[COUNT];
        Random r = new Random();
        for (int i = 0; i < COUNT; i++) {
            mas[i] = r.nextInt(COUNT);
        }
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testSort() {
        a.sort(mas);
        boolean b = true;
        for (int i = 0; i < COUNT-1; i++) {
            b = (b) && ((mas[i].compareTo(mas[i + 1]) == -1) || (mas[i].compareTo(mas[i + 1]) == 0));
        }
        assertTrue(b);
    }
}
