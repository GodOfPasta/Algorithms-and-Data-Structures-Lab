import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        String path;
        String text;
        String command;
        BufferedReader textFile;
        int current;
        help();
        do{
            command = scan.nextLine();
            switch (command){
                case("file"):
                    text = "";
                    System.out.println("Введите путь к файлу");
                    path = scan.nextLine();
                    textFile = new BufferedReader(new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8));
                    while((current = textFile.read()) != -1){
                        text += (char) current;
                    }
                    run(text);
                    break;
                case("console"):
                    text = "";
                    System.out.println("Введите текст. По окончаию введите пустую строку");
                    do {
                        command = scan.nextLine();
                        text += command + " ";
                    }while (!command.equals(""));
                    run(text);
                    break;
                case("exit"):
                    break;
                default:
                    System.out.println("Неверная команда");
            }
        }while(!command.equals("exit"));
    }
    public static void run(String text){
        int longest = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите искомую подстроку");
        String sample = scan.nextLine();
        String[] sentences = text.split("\\.");
        ArrayList<String>[] words = new ArrayList[sentences.length];
        String[][] matrix = new String[sentences.length][];
        for (int i = 0; i < matrix.length; i++){
            matrix[i] = Arrays.stream(sentences[i].split(" ")).filter(s -> !s.equals("")).toArray(String[]::new);
        }
        for (int i = 0; i < matrix.length; i++){
            words[i] = new ArrayList<>();
            for (String word : matrix[i]){
                int t = 0;
                int last = sample.length() - 1;
                while (t < word.length() - last){
                    int p = 0;
                    while( p <= last && word.charAt(t + p) == sample.charAt(p) ){
                        p++;
                    }
                    if(p == sample.length()){
                        if(word.length() > longest) longest = word.length();
                        words[i].add(word);
                        break;
                    }
                    else t++;
                }
            }
        }
        for (ArrayList<String> word : words) {
            String[] row = word.toArray(new String[0]);
            for (String s : row) {
                System.out.printf("%-" + (longest+2) + "s", s);
            }
            System.out.println();
        }
    }
    public static void help(){
        System.out.println("Введите команду:\n" +
                "file - для чтения текста из файла\n" +
                "console - для чтения текста с консоли\n" +
                "exit - для выхода");
    }
}
