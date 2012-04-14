package tests;



/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
import Sorts.*;
import tests.*;
import java.util.Random;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Jeka
 */
public class SortTest {

    private Integer[] mas;
    private final int COUNT=100;

    public SortTest() {
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
    public void shellSortTest() {
        ShellSort a=new ShellSort();
        a.sort(mas);
        boolean b = true;
        for (int i = 0; i < COUNT-1; i++) {
            b = (b) && ((mas[i].compareTo(mas[i + 1]) == -1) || (mas[i].compareTo(mas[i + 1]) == 0));
        }
        assertTrue(b);
    }
    
    @Test
    public void qiuckSortTest() {
        QuickSort a = new QuickSort();
        a.sort(mas);
        boolean b = true;
        for (int i = 0; i < COUNT-1; i++) {
            b = (b) && ((mas[i].compareTo(mas[i + 1]) == -1) || (mas[i].compareTo(mas[i + 1]) == 0));
        }
        assertTrue(b);
    }
    
    @Test
    public void mergeSortTest() {
        MergeSort a = new MergeSort();
        a.sort(mas);
        boolean b = true;
        for (int i = 0; i < COUNT-1; i++) {
            b = (b) && ((mas[i].compareTo(mas[i + 1]) == -1) || (mas[i].compareTo(mas[i + 1]) == 0));
        }
        assertTrue(b);
    }
    
    @Test
    public void bubleSortTest() {
        BubbleSort a = new BubbleSort();
        a.sort(mas);
        boolean b = true;
        for (int i = 0; i < COUNT-1; i++) {
            b = (b) && ((mas[i].compareTo(mas[i + 1]) == -1) || (mas[i].compareTo(mas[i + 1]) == 0));
        }
        assertTrue(b);
    }
    
    @Test
    public void insertSortTest() {
        InsertSort a = new InsertSort();
        a.sort(mas);
        boolean b = true;
        for (int i = 0; i < COUNT-1; i++) {
            b = (b) && ((mas[i].compareTo(mas[i + 1]) == -1) || (mas[i].compareTo(mas[i + 1]) == 0));
        }
        assertTrue(b);
    }
    
    @Test
    public void heapSortTest() {
        HeapSort a = new HeapSort();
        a.sort(mas);
        boolean b = true;
        for (int i = 0; i < COUNT-1; i++) {
            b = (b) && ((mas[i].compareTo(mas[i + 1]) == -1) || (mas[i].compareTo(mas[i + 1]) == 0));
        }
        assertTrue(b);
    }
    
    @Test
    public void selectionSortTest() {
        SelectionSort a = new SelectionSort();
        a.sort(mas);
        boolean b = true;
        for (int i = 0; i < COUNT-1; i++) {
            b = (b) && ((mas[i].compareTo(mas[i + 1]) == -1) || (mas[i].compareTo(mas[i + 1]) == 0));
        }
        assertTrue(b);
    }
}
