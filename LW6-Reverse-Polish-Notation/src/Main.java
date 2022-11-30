import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
public class Main {
    /*
    \\ 2+2
    4.0
    \\ -4*2
    -8.0
    \\ 3+(-13)
    -10.0
    \\ 2-(-3*4)
    14.0
    \\ 51 - ((42*(1/2))/13^2) + (-3^2^2)/(-1) + (2)
    -28.124260355029584
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String command;
        help();
        do{
            command = scan.nextLine();
        }while (command.equals(""));

        do{
            try {
                double result = calculate(convertToPostfix(split(command)));
                System.out.println(result);
            } catch (NumberFormatException e){
                System.out.println("Ошибка! " +
                        "Введите либо математическое выражение, либо 'exit'");
            }

            command = scan.nextLine();
        }while (!command.equals("exit"));


    }
    static String[] split(String command){
        ArrayList<String> result = new ArrayList<>();
        String temp;
        int length = 0;
        for(String ch : command.split(" ")) {
            temp = "";
            if (!ch.equals("")){
                for(char i : ch.toCharArray()){
                    if (i >= 40 && i <= 43 || i == '/' || i == '-' || i == '^') {
                        if (!temp.equals("")) {
                            result.add(temp);
                            length++;
                        }
                        temp = "";
                        result.add(""+i);
                        length++;
                    }
                    else temp+=i;
                }
                if (!temp.equals("")) {
                    result.add(temp);
                    length++;
                }
            }
        }
        if (result.get(0).equals("-")){
            result.remove(0);
            result.set(0, "-" + result.get(0));
            length--;
        }
        for(int i = 0; i < length; i++){
            if(result.get(i).equals("(") && result.get(i+1).equals("-")){
                if(result.get(i+3).equals(")")){
                    result.remove(i);
                    result.remove(i);
                    result.set(i, "-" + result.get(i));
                    result.remove(i+1);
                    length-=3;
                }
                else{
                    result.remove(i+1);
                    result.set(i+1, "-" + result.get(i+1));
                    length--;
                }
            }
        }
        return result.toArray(new String[0]);
    }
    private static boolean isOperator(String c) {
        return c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/")
                || c.equals("^") || c.equals("(")|| c.equals(")");
    }
    private static int getPrecedence(String ch) {
        switch (ch) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            case "^":
                return 3;
        }
        return -1;
    }
    public static String[] convertToPostfix(String[] infix) {
        Stack<String> stack = new Stack<>();
        ArrayList<String> postfix = new ArrayList<>();
        String c;
        for (String s : infix) {
            c = s;
            if (!isOperator(c)) {
                postfix.add(c);
            } else if (c.equals("(")) {
                    stack.push(c);
            } else if (c.equals(")")) {
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    postfix.add(stack.pop());
                }
                if (!stack.isEmpty() && !stack.peek().equals("("))
                    return null;
                else if (!stack.isEmpty())
                    stack.pop();
            } else if (isOperator(c)) {
                if (!stack.isEmpty() && getPrecedence(c) <= getPrecedence(stack.peek())) {
                    postfix.add(stack.pop());
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            postfix.add(stack.pop());
        }
        return postfix.toArray(new String[0]);
    }
    static double calculate(String[] string){
        Stack<String> stack = new Stack<>();
        for(String str : string)
            if(!isOperator(str)) stack.push(str);
            else{
                double second = Double.parseDouble(stack.pop());
                double first = Double.parseDouble(stack.pop());
                switch (str){
                    case "+": {
                        stack.push(String.valueOf(first + second));
                        break;
                    }
                    case "-":{
                        stack.push(String.valueOf(first - second));
                        break;
                    }
                    case "*":{
                        stack.push(String.valueOf(first * second));
                        break;
                    }
                    case "/":{
                        stack.push(String.valueOf(first / second));
                        break;
                    }
                    case "^":{
                        stack.push(String.valueOf(Math.pow(first, second)));
                        break;
                    }
                }
            }
        return Double.parseDouble(stack.pop());
    }
    public static void help(){
        System.out.println("Введите выражение\n"+
                "В выражении могут присутствовать следующие операторы: -, +, *, /, ^, (, )\n"+
                "Отрицательные числа должны быть в собках\n"+
                "Для выхода введите 'exit'");
    }
}
