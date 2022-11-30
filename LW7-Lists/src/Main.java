import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int m, n;
        Scanner scan = new Scanner(System.in);
        ArrayListNew matA = new ArrayListNew(),
                matB = new ArrayListNew(),
                result;

        System.out.println("Введите размерность матрицы А - m x n (m строк, n столбцов)");
        System.out.print("m: ");
        m = scan.nextInt();
        System.out.print("n: ");
        n = scan.nextInt();
        System.out.println("Размерность матрицы B - " + n + " x " + m
        + "\nВведите матрицу А");
        fill(matA, m);
        System.out.println("Введите матрицу B");
        fill(matB, n);
        System.out.println("Ответ: ");
        result = mul(matA, matB);
        result.display();
    }
    public static void fill(ArrayListNew mat, int m){
        Scanner scan = new Scanner(System.in);
        double[] row;
        int length;
        boolean flag;
        for(int i = 0; i < m; i++){
            do {
                flag = false;
                String[] str = scan.nextLine().split(" ");
                length = 0;
                for (String ch : str) if(!ch.equals("")) length++;
                row = new double[length];
                for (int j = 0, k = 0; j < str.length; j++) {
                    try {
                        if(!str[j].equals("")) {
                            row[k] = Double.parseDouble(str[j]);
                            k++;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Ошибка! Попробуйте ввести строку ещё раз.\n" +
                                "Среди элементов не должны быть буквы, знаки препинания или спецсимволы.");
                        flag = true;
                        break;
                    }
                }
            }while(flag);
            for (double val : row) {
                mat.addAtRow(i, val);
            }
        }
    }
     public static ArrayListNew mul(ArrayListNew matA, ArrayListNew matB){
        int n = matA.length();
        ArrayListNew result = new ArrayListNew();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                double sum = 0;
                for(int k = 0; k < n; k++){
                    sum += matA.get(i, k) * matB.get(k, j);
                }
                result.addAtRow(i, sum);
            }
        }
        return result;
     }
}
