public class Stack{
    private double[] array;
    private final int MAX_SIZE = 300;

    Stack(double ... array){
        this.array = array;
    }

    public void push(double value){
        if(array.length + 1 > MAX_SIZE) {
            System.out.println("Stack overflow");
        }
        else {
            double[] temp = new double[array.length + 1];
            temp[0] = value;
            System.arraycopy(array, 0, temp, 1, array.length);
            array = temp;
        }
    }
    public double pop(){
        double ret;
        try {
            ret = array[0];
            double[] temp = new double[array.length - 1];
            System.arraycopy(array, 1, temp, 0, array.length - 1);
            array = temp;
            return ret;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Stack is empty");
        }
        return -1;
    }
    public void peek(){
        try {
            System.out.println(array[0]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Stack is empty");
        }
    }
}
