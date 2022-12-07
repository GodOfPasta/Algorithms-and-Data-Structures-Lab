import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] num16 = {0x1a0, 0x45, 0x75, 0xb0, 0xcd2, 0x2, 0xd4, 0x66,0x23,0x234,0x3,0x2fa2,0x44, -0x1001, -0x789, 0x123, 0xddf, -0x99999};
        int[] num10 = {10, 45, 75, 0, 782, 2, -84, 66, 23, 234, 3, 22, 44, -1001, -789, 123, 16534, -99999};
        int[] num2 = {0b110, 0b10, 0b11010011, 0b0, 0b1110, -0b111, 0b11110010, 0b1001, 0b1010, 0b11010, -0b1001, -0b101, 0b1110, 0b1010011100111, -0b11111111111};
        int[] num8 = {0170, 045, 075, 07120, 02, 02, 0704, 066, 023, 0234, 03, 022, 044, -01001, -0722, 0123, 034724, -0777777};
        int[] numMix = {0b110, 0b10, 0b11010011, 0x23, 0x234, 0x32, -84, 66, 0234, 03, 022, 044};

        int[][] arrays = {num2, num8, num10, num16, numMix};

        for(int[] arr : arrays){
            print(arr);
            radixSort(arr);
            print(arr);
            System.out.println();
        }
    }
    public static void print(int[] input){
        for(int i : input) System.out.print(i + " ");
        System.out.println();
    }
    public static void radixSort(int[] input){
        ArrayList<Integer>[] buckets = new ArrayList[19];
        int tmp = -1, divisor = 1;
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }
        while (tmp != 0) {
            for (Integer i : input) {
                tmp = i / divisor;
                buckets[tmp % 10 + 9].add(i);
            }
            int a = 0;
            for (List<Integer> bucket : buckets) {
                for (Integer num : bucket) {
                    input[a++] = num;
                }
                bucket.clear();
            }
            divisor *= 10;
        }
    }
}
