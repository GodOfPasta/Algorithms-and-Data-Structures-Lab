import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Stack stack = new Stack();
        Queue queue = new Queue();
        Deque deque = new Deque();
        String command;
        String type;

        do {
            type = newType();
            if(!type.equals("stack") && !type.equals("queue") && !type.equals("deque"))
                System.out.println("Неверная команда! Попробуйте ещё раз");
        }while(!type.equals("stack") && !type.equals("queue") && !type.equals("deque"));

        help();
        do{
            System.out.print("Введите команду: ");
            do{
                command = clearCommand(scan.nextLine());
            }while (command.equals(""));
            switch (command){
                case("change"):{
                    do {
                        type = newType();
                        if(!type.equals("stack") && !type.equals("queue") && !type.equals("deque"))
                            System.out.println("Неверная команда! Попробуйте ещё раз");
                    }while(!type.equals("stack") && !type.equals("queue") && !type.equals("deque"));
                    break;
                }
                case("clear"):{
                    String confirm;
                    do {
                        System.out.println("Вы уверены, что хотите создать очистить текущий АТД?"+
                                "\nY/N");
                        confirm = clearCommand(scan.nextLine());
                        switch (confirm) {
                            case ("Y"): {
                                switch (type){
                                    case("deque"): {
                                        deque = new Deque();
                                        break;
                                    }
                                    case("stack"): {
                                        stack = new Stack();
                                        break;
                                    }
                                    case("queue"): {
                                        queue = new Queue();
                                        break;
                                    }
                                }
                            }
                            case ("N"): {
                                break;
                            }
                            default:
                                System.out.println("Неверная команда! Попробуйте ещё раз");
                        }
                    }while(!confirm.equals("N") && !confirm.equals("Y"));
                    break;
                }
                case("pop"):{
                    switch (type){
                        case ("stack"): {
                            stack.pop();
                            break;
                        }
                        case ("queue"): {
                            queue.pop();
                            break;
                        }
                        default:
                            System.out.println("Неверный тип данных");
                    }
                    break;
                }
                case("push"):{
                    switch (type){
                        case ("stack"): {
                            try {
                                System.out.println("Введите значение элемента, которое хотите добавить, или cancel для отмены");
                                String value = clearCommand(scan.nextLine());
                                if(value.equals("cancel")) break;
                                stack.push(Double.parseDouble(value));
                            }
                            catch (NumberFormatException e){
                                System.out.println("Значение должно быть вещественным числом");
                            }
                            break;
                        }
                        case ("queue"): {
                            try {
                                System.out.println("Введите значение элемента, которое хотите добавить, или cancel для отмены");
                                String value = clearCommand(scan.nextLine());
                                if(value.equals("cancel")) break;
                                queue.push(Double.parseDouble(value));
                            }
                            catch (NumberFormatException e){
                                System.out.println("Значение должно быть вещественным числом");
                            }
                            break;
                        }
                        default:
                            System.out.println("Неверный тип данных");
                    }
                    break;
                }
                case("peek"):{
                    switch (type){
                        case ("stack"): {
                            stack.peek();
                            break;
                        }
                        case ("queue"): {
                            queue.peek();
                            break;
                        }
                        default:
                            System.out.println("Неверный тип данных");
                    }
                    break;
                }
                case("pushStart"):{
                    if(!type.equals("deque")){
                        System.out.println("Неверный тип данных");
                        break;
                    }
                    try {
                        System.out.println("Введите значение элемента, которое хотите добавить, или cancel для отмены");
                        String value = clearCommand(scan.nextLine());
                        if(value.equals("cancel")) break;
                        deque.pushStart(Double.parseDouble(value));
                    }
                    catch (NumberFormatException e){
                        System.out.println("Значение должно быть вещественным числом");
                    }
                    break;
                }
                case("pushEnd"):{
                    if(!type.equals("deque")){
                        System.out.println("Неверный тип данных");
                        break;
                    }
                    try {
                        System.out.println("Введите значение элемента, которое хотите добавить, или cancel для отмены");
                        String value = clearCommand(scan.nextLine());
                        if(value.equals("cancel")) break;
                        deque.pushEnd(Double.parseDouble(value));
                    }
                    catch (NumberFormatException e){
                        System.out.println("Значение должно быть вещественным числом");
                    }
                    break;
                }
                case("popStart"):{
                    if(!type.equals("deque")){
                        System.out.println("Неверный тип данных");
                        break;
                    }
                    deque.popStart();
                    break;
                }
                case("popEnd"):{
                    if(!type.equals("deque")){
                        System.out.println("Неверный тип данных");
                        break;
                    }
                    deque.popEnd();
                    break;
                }
                case("peekStart"):{
                    if(!type.equals("deque")){
                        System.out.println("Неверный тип данных");
                        break;
                    }
                    deque.peekStart();
                    break;
                }
                case("peekEnd"):{
                    if(!type.equals("deque")){
                        System.out.println("Неверный тип данных");
                        break;
                    }
                    deque.peekEnd();
                    break;
                }
                case ("help"): {
                    help();
                    break;
                }
                case ("exit"):{
                    break;
                }
                default:
                    System.out.println("Неверная команда! Попробуйте ещё раз");
            }
        }while(!command.equals("exit"));
    }
    static String newType(){
        Scanner scan = new Scanner(System.in);
        String type;
        System.out.println("Выберите тип данных:\n"+
                "- Стек - stack\n"+
                "- Очередь - queue\n"+
                "- Дек - deque");
        do{
            type = clearCommand(scan.nextLine());
        }while(type.equals(""));
        return type;
    }
    static void help(){
        System.out.println("- Выбрать другой АТД - change;                  \n"+
                "- Очистить текущий АТД - clear;                            \n"+
                "- Добавить элемент - push;                                 \n"+
                "- Взять элемент - pop;                                     \n"+
                "- Посмотреть следующий элемент - peek;                     \n"+
                "ТОЛЬКО ДЛЯ ДЕКА:                                           \n"+
                "   - Добавить элемент в начало - pushStart;                \n"+
                "   - Добавить элемент в конец - pushEnd;                   \n"+
                "   - Взять элемент из начала - popStart;                   \n"+
                "   - Взять элемент из конца - popEnd;                      \n"+
                "   - Посмотреть следующий элемент в начале - peekStart;    \n"+
                "   - Посмотреть следующий элемент в конце - peekEnd;       \n"+
                "- Выйти - exit;                                            \n"+
                "- Помощь - help;                                           \n");
    }
    static String clearCommand(String command){
        for(String ch : command.split(" ")) {
            if (!ch.equals("")){
                command = ch;
                break;
            }
        }
        return command;
    }
}
