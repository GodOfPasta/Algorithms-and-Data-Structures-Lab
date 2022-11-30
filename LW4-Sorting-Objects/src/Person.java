public class Person {
    private int id;
    private String name;
    private String lastname;
    private String postalCode;
    private String phone;

    Person(){
        id = 0;
        name = "name";
        lastname = "lastname";
        postalCode = "0";
        phone = "0-(000)-000-00-00";
    }

    Person(int id, String name, String lastname, String postalCode, String phone){
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.postalCode = postalCode;
        this.phone = phone;
    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getLastname() {return lastname;}
    public void setLastname(String lastname) {this.lastname = lastname;}
    public String getPostalCode() {return postalCode;}
    public void setPostalCode(String mailIndex) {this.postalCode = mailIndex;}
    public String getPhone() {return phone;}
    public void setPhone(String phone) {this.phone = phone;}

    public String toString(){
        return "id: " + id +
                "\nname: "  + name +
                "\nlastname: " + lastname +
                "\nmailIndex: " + postalCode +
                "\nphone: " + phone;
    }
}