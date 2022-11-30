public class Queue{
    private double[] array;
    private final int MAX_SIZE = 300;

    Queue(double ... array){
        this.array = array;
    }

    public void push(double value){
        if(array.length + 1 > MAX_SIZE) {
            System.out.println("Queue Overflow");
        }
        else {
            double[] temp = new double[array.length + 1];
            temp[array.length] = value;
            System.arraycopy(array, 0, temp, 0, array.length);
            array = temp;
        }
    }
    public double pop(){
        double ret;
        try {
            ret = array[array.length-1];
            double[] temp = new double[array.length - 1];
            System.arraycopy(array, 0, temp, 0, array.length - 1);
            array = temp;
            return ret;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Queue is Empty");
        }
        return -1;
    }
    public void peek(){
        try {
            System.out.println(array[array.length-1]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Queue is Empty");
        }
    }

}
