import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите n");
        int n = scan.nextInt();
        System.out.println("Введите границы: от до");
        int start = scan.nextInt();
        int fin = scan.nextInt();
        int[] array = new int[n];
        for(int i=0;i < array.length; i++){
            array[i] = start - 1 + (int)(Math.random()*(fin-start) + 2);
        }

        int[] newArray1 = new int[array.length];
        int[] newArray2 = new int[array.length];
        int[] newArray3 = new int[array.length];
        int[] newArray4 = new int[array.length];
        System.arraycopy(array, 0, newArray1, 0, array.length);
        System.arraycopy(array, 0, newArray2, 0, array.length);
        System.arraycopy(array, 0, newArray3, 0, array.length);
        System.arraycopy(array, 0, newArray4, 0, array.length);

        hairbrushSort(newArray1);
        newArray1 = dub(newArray1);
        isSorted(newArray1);
        print(newArray1);

        long startTime = System.currentTimeMillis();
        quickSort(newArray2, 0, newArray2.length-1);
        System.out.println("Quick Sort Time is " + (System.currentTimeMillis() - startTime));
        newArray2 = dub(newArray2);
        isSorted(newArray2);
        print(newArray2);

        insertionSort(newArray3);
        newArray3 = dub(newArray3);
        isSorted(newArray3);
        print(newArray3);

        bubbleSort(newArray4);
        newArray4 = dub(newArray4);
        isSorted(newArray4);
        print(newArray4);
    }
    public static void hairbrushSort(int[] array) {
        long startTime = System.currentTimeMillis();
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
        System.out.println("Hairbrush Sort Time is " + (System.currentTimeMillis() - startTime));
    }
    public static void bubbleSort(int[] array) {
        long startTime = System.currentTimeMillis();
        boolean sorted = false;
        int temp;
        while(!sorted) {
            sorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i+1]) {
                    temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                    sorted = false;
                }
            }
        }
        System.out.println("Bubble Sort Time is " + (System.currentTimeMillis() - startTime));
    }
    public static void insertionSort(int[] array) {
        long startTime = System.currentTimeMillis();
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i - 1;
            while(j >= 0 && current < array[j]) {
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = current;
        }
        System.out.println("Insertion Sort Time is " + (System.currentTimeMillis() - startTime));

    }
    public static void quickSort(int[] array, int begin, int end) {
        if (end <= begin) return;
        int pivot = partition(array, begin, end);
        quickSort(array, begin, pivot-1);
        quickSort(array, pivot+1, end);
    }
    static int partition(int[] array, int begin, int end) {
        int counter = begin;
        for (int i = begin; i < end; i++) {
            if (array[i] < array[end]) {
                int temp = array[counter];
                array[counter] = array[i];
                array[i] = temp;
                counter++;
            }
        }
        int temp = array[end];
        array[end] = array[counter];
        array[counter] = temp;

        return counter;
    }
    public static void isSorted(int[] array){
        boolean flag = true;
        for(int i = 0; i < array.length-1;i++){
            if(array[i] > array[i+1]){
                flag = false;
                break;
            }
        }
        if(flag) System.out.println("Массив отсортирован!");
        else System.out.println("! Массив не отсортирован");
    }
    public static int[] dub(int[] array){
        if(array.length == 0) return new int[]{};
        int[] newArray;
        int unique = 1;
        for(int i = 1; i < array.length; i++){
            if(!(array[i] == array[i-1])) unique++;
        }
        newArray = new int[unique];
        newArray[0] = array[0];
        for(int i = 1, j = 1; i < array.length; i++){
            if(!(array[i] == array[i-1])) {
                newArray[j] = array[i];
                j++;
            }
        }
        return newArray;
    }
    public static void print(int[] array){
        System.out.print("[");
        for(int i : array) System.out.print(i + ", ");
        System.out.println("]");
    }
}
