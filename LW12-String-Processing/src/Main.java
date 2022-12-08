import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String test = "Иркутск основан как Острог в 1661 году на правом берегу Ангары. В 1686 году ему присвоен статус города. С 1764 года – центр Иркутской губернии.";
        char testCh = 'О';
        int longest = 0;
        String[] sentences = test.split("\\.");
        ArrayList<String>[] words = new ArrayList[sentences.length];
        String[][] matrix = new String[sentences.length][];
        for (int i = 0; i < matrix.length; i++){
            matrix[i] = Arrays.stream(sentences[i].split(" ")).filter(s -> !s.equals("")).toArray(String[]::new);
        }
        for (int i = 0; i < matrix.length; i++){
            words[i] = new ArrayList<>();
            for (String word : matrix[i]){
                for(int j = 0; j < word.length(); j++){
                    if(word.toLowerCase().charAt(j) == Character.toLowerCase(testCh)){
                        if(word.length() > longest)
                            longest = word.length();
                        words[i].add(word);
                        break;
                    }
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
}
