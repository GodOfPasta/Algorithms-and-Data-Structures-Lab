import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int n, start, fin;
        System.out.print("Введите количество элементов массива:\nN = ");
        n = scan.nextInt();
        int[] array = new int[n];
        System.out.print("Введите границы значений:\nОт ");
        start = scan.nextInt();
        System.out.print("до ");
        fin = scan.nextInt();
        for(int i = 0; i < array.length; i++){
            array[i] = start + (int)(Math.random()*(fin-start+1));
        }
        array = new int[]{41, 9, 37, -21, 9, -42, 34, -64, -29, -9};
        System.out.println("Unsorted array is");
        printArray(array);
        sort(array);
        System.out.println("Sorted array is");
        printArray(array);
    }
    static void printArray(int[] arr)
    {
        for (int i : arr)
            System.out.print(i + " ");
        System.out.println();
    }
    public static void sort(int[] arr)
    {
        int[] heap = new int[arr.length];
        heap[0] = arr[0];
        for(int i = 1; i < arr.length; i++){
            int index = i + 1;
            heap[i] = arr[i];
            while(index > 1 && heap[index - 1] < heap[index/2 - 1]) {
                heap[index-1] = (heap[index/2-1] + heap[index-1]) - (heap[index/2-1] = heap[index-1]);
                index /= 2;
            }
        }
        System.out.println("Heap is");
        showHeap(heap, 1);
        System.out.println();

        for(int i = 0; i < arr.length; i++){
            arr[i] = heap[0];
            heap[0] = heap[heap.length-1-i];
            int index = 1;
            while(index * 2 < heap.length-1-i && (heap[index-1] > heap[index*2-1] || heap[index-1] > heap[index*2])){
                if(heap[index*2-1] < heap[index*2]){
                    heap[index-1] = (heap[index*2-1] + heap[index-1]) - (heap[index*2-1] = heap[index-1]);
                    index *= 2;
                }
                else{
                    heap[index-1] = (heap[index*2] + heap[index-1]) - (heap[index*2] = heap[index-1]);
                    index = index * 2 + 1;
                }
            }
        }
    }
    public static void showHeap(int[] heap, int index){
        if(index * 2 <= heap.length) {
            if (index == 1 || index % 2 == 0)
                System.out.print("(");
            System.out.print(heap[index - 1]);
            if (index * 4 > heap.length) {
                System.out.print("(" + heap[index * 2 - 1]);
                if (index * 2 < heap.length)
                    System.out.print(" " + heap[index * 2]);
                System.out.print(")");
            }
            else {
                showHeap(heap, index * 2);
                System.out.print(" ");
                showHeap(heap, index * 2 + 1);
                System.out.print(")");
            }
        }
    }
}
