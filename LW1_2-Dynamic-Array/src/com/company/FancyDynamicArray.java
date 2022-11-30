package com.company;

public class FancyDynamicArray extends DynamicArray{
    FancyDynamicArray(double ... array) {
        super(array);
    }
    private final double[] array = getArray();
    private boolean isSorted = false;
    public void sort() {
        double gapFactor = array.length / 1.247;
        while (gapFactor > 1) {
            int gap = (int) Math.round(gapFactor);
            for (int i = 0, j = gap; j < array.length; i++, j++) {
                if (array[i] > array[j]) {
                    array[i] = (array[j] + array[i]) - (array[j] = array[i]);
                }
            }
            gapFactor /= 1.247;
        }
        isSorted = true;
    }
    public int search(int firstElement, int lastElement, double elementToSearch) {
        if(isSorted) {
            if (lastElement >= firstElement) {
                int mid = firstElement + (lastElement - firstElement) / 2;
                if (array[mid] == elementToSearch)
                    return mid;
                if (array[mid] > elementToSearch)
                    return search(firstElement, mid - 1, elementToSearch);
                return search(mid + 1, lastElement, elementToSearch);
            }
        }
        else {
            for (int index = 0; index < array.length; index++) {
                if (array[index] == elementToSearch)
                    return index;
            }
        }
        return -1;
    }
}