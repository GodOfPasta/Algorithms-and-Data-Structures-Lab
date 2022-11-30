public class ArrayListNew {
    private List first;
    public ArrayListNew(){
        first = new List();
    }
    public void addAtRow(int index, double data){
        List current = first;
        if(index == 0){
            current.insert(current.length(), data);
        }
        else if(length() - 1 < index){
            while (current.next != null) {
                current = current.next;
            }
                List newList = new List();
                newList.next = null;
                current.next = newList;
                newList.insert(newList.length(), data);
        }
        else {
                while (index != 1) {
                    current = current.next;
                    index--;
                }
                current.next.insert(current.next.length(), data);
            }
    }

    public void addAtCol(int index, double data){
        List newList = new List();
        List current = first;
        while (current.next != null) {
            current = current.next;
        }
        newList.next = null;
        current.next = newList;
        if(index == 0) {
            newList.insert(newList.length(), data);
        }
        else{
            while(index != 0){
                newList.insert(newList.length(), 0);
                index--;
            }
            newList.insert(newList.length(), data);
        }
    }
    public void delete(int x, int y){
        List current = first;
        while(x != 0){
            current = current.next;
            x--;
        }
        current.delete(y+1);
    }
    public void set(int x, int y, double data){
        List current = first;
        while(x != 0){
            current = current.next;
            x--;
        }
        current.insert(y, data);
        current.delete(y+1);
    }
    public int length(){
        List current = first;
        int length = 0;
        while(current!=null){
            current = current.next;
            length++;
        }
        return length;
    }
    public void display(){
        List current = first;
        while(current!=null){
            current.display();
            current = current.next;
        }
    }
    public double get(int x, int y){
        List current = first;
        while(x != 0){
            current = current.next;
            x--;
        }
        return current.get(y).data;
    }
}
