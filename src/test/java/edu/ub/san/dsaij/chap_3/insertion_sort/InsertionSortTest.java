package edu.ub.san.dsaij.chap_3.insertion_sort;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by san on 10/23/15 for dsaij.
 */
public class InsertionSortTest {

    @Test
    public void testInsertionSortSingleValue() throws Exception {
        char[] input = new char[]{'D'};
        char[] expected = new char[]{'D'};
        char[] actual = InsertionSort.insertionSort(input);

        assertArrayEquals("Actual Array not as expected",expected,actual);
    }

    @Test
    public void testInsertionSortTwoValues() throws Exception {
        char[] input = new char[]{'d','b'};
        char[] expected = new char[]{'b','d'};
        char[] actual = InsertionSort.insertionSort(input);

        assertArrayEquals("Actual Array not as expected",expected,actual);
    }

    @Test
    public void testInsertionSortPreSortedValues() throws Exception {
        char[] input = new char[]{'a','b','c','d','e','z'};
        char[] expected = new char[]{'a','b','c','d','e','z'};
        char[] actual = InsertionSort.insertionSort(input);

        assertArrayEquals("Actual Array not as expected",expected,actual);
    }

    @Test
    public void testInsertionSortWorstCaseSortedValues() throws Exception {
        char[] input = new char[]{'z','e','d','c','b','a'};
        char[] expected = new char[]{'a','b','c','d','e','z'};
        char[] actual = InsertionSort.insertionSort(input);

        assertArrayEquals("Actual Array not as expected",expected,actual);
    }
}