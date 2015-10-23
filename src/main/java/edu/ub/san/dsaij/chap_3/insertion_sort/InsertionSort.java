package edu.ub.san.dsaij.chap_3.insertion_sort;

/**
 * Created by san on 10/23/15 for dsaij.
 * The contents of this class is as presented in book "Data Structures & Algorithms in Java (6th Edition) by Goodrich"
 */
public class InsertionSort {

    public static char[] insertionSort(char[] in){
        for(int i = 1; i < in.length; i++){
            char cur = in[i];
            int j = i;
            while(j > 0 && cur < in[j-1]){
                in[j] = in[j-1];
                j--;
            }
            in[j] = cur;
        }
        return in;
    }
}
