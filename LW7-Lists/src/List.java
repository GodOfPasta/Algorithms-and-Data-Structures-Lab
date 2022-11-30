public class List {
    private Link first;
    public List next;
    public List(){
        first = null;
    }
    public void insert(int index, double data) {
        Link newLink = new Link(data);
        Link current = first;
        if(index == 0) {
            newLink.next = first;
            first = newLink;
        }
        else{
            while (index != 1) {
                current = current.next;
                index--;
            }
            newLink.next = current.next;
            current.next = newLink;
        }
    }
    public void delete(int index){
        Link current = first;
        if(index == 0) first = first.next;
        else {
            while (index != 1) {
                current = current.next;
                index--;
            }
            current.next = current.next.next;
        }
    }
    public Link get(int index){
        Link current = first;
        while(index != 0) {
            current = current.next;
            index--;
        }
        return current;
    }
    public void display(){
        Link current = first;
        while(current != null) {
            System.out.print(current + " ");
            current = current.next;
        }
        System.out.println();
    }
    public int length(){
        Link current = first;
        int length = 0;
        while(current!=null){
            current = current.next;
            length++;
        }
        return length;
    }
}
