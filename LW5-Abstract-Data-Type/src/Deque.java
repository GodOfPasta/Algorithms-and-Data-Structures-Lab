public class Deque{
    private final int MAX_SIZE = 600;
    private final double[] array;
    private final int startIndex = MAX_SIZE/2;
    private int start = startIndex;
    private int end = startIndex;
    Deque(){
        this.array = new double[MAX_SIZE+1];
    }

    public void pushStart(double value){
        if(start <= 0) {
            System.out.println("Deque overflow");
        }
        else {
            array[--start] = value;
        }
    }
    public double popStart(){
        if(start != startIndex)
            return array[start++];
        else {
            System.out.println("Deque is empty");
            return -1;
        }
    }
    public void peekStart(){
        if(start != startIndex)
            System.out.println(array[start]);
        else {
            System.out.println("Deque is empty");
        }
    }
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
public void pushEnd(double value){
    if(end >= MAX_SIZE) {
        System.out.println("Deque overflow");
    }
    else {
        array[++end] = value;
    }
}
    public double popEnd(){
        if(start != startIndex)
            return array[end--];
        else {
            System.out.println("Deque is empty");
            return -1;
        }
    }
    public void peekEnd(){
        if(end != startIndex)
            System.out.println(array[end]);
        else {
            System.out.println("Deque is empty");
        }
    }
}

