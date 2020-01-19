package org.sid.java.practice;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class SortArray {

    @Test
    public void sortNumberArray() {
        int[] toSort = {-1, 0, 3,-3, 4, 2, -2};
        int[] expectedResult = {-3, -2, -1, 0, 2, 3, 4};
        Arrays.sort(toSort);
        Assert.assertArrayEquals(toSort, expectedResult);
    }

    @Test
    public void bubbleSort() {
        int[] toSort = {-1, 0, 3,-3, 4, 2, -2};
        int[] expectedResult = {-3, -2, -1, 0, 2, 3, 4};
        boolean sorted = false;
        while(!sorted) {
            sorted = true;
            for (int i = 0; i < toSort.length -1; i++) {
                if (toSort[i + 1] < toSort[i]) {
                    int temp = toSort[i + 1];
                    toSort[i + 1] = toSort[i];
                    toSort[i] = temp;
                    sorted = false;
                }
            }
        }
        Assert.assertArrayEquals(toSort, expectedResult);
    }

    @Test
    public void insertionSort() {
        int[] toSort = {-1, 0, 3,-3, 4, 2, -2};
        int[] expectedResult = {-3, -2, -1, 0, 2, 3, 4};

        for(int i = 1; i < toSort.length; i++) {
            int current = toSort[i];
            int j = i - 1;
            while(j>=0 && current < toSort[j]) {
                toSort[j+1] = toSort[j];
                j--;
            }
            toSort[j+1] = current;
        }

        Assert.assertArrayEquals(toSort, expectedResult);
    }

    @Test
    public void selectionSort() {
        int[] toSort = {-1, 0, 3,-3, 4, 2, -2};
        int[] expectedResult = {-3, -2, -1, 0, 2, 3, 4};

        for(int i = 0; i < toSort.length; i++) {
            for(int j = i + 1; j < toSort.length; j++) {
                int current = toSort[i];
                if(current > toSort[j]) {
                    toSort[i] = toSort[j];
                    toSort[j] = current;
                }
            }
        }
        Assert.assertArrayEquals(toSort, expectedResult);
    }
}
