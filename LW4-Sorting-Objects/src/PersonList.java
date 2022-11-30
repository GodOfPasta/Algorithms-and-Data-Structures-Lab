public class PersonList {
    private final Person[] people;
    PersonList(){
        people = new Person[]{};
    }
    PersonList(Person ... dudes){
        people = new Person[dudes.length];
        System.arraycopy(dudes, 0, people, 0, dudes.length);
    }

    public void sortByIdUp(){
        for (int i = 1; i < people.length; i++) {
            Person current = people[i];
            int j = i - 1;
            while(j >= 0 && current.getId() < people[j].getId()) {
                people[j+1] = people[j];
                j--;
            }
            people[j+1] = current;
        }
    }
    public void sortByNameUp(){
        for (int i = 1; i < people.length; i++) {
            Person current = people[i];
            int j = i - 1;
            while(j >= 0 && current.getName().compareTo(people[j].getName()) < 0) {
                people[j+1] = people[j];
                j--;
            }
            people[j+1] = current;
        }
    }
    public void sortByLastnameUp(){
        for (int i = 1; i < people.length; i++) {
            Person current = people[i];
            int j = i - 1;
            while(j >= 0 && current.getLastname().compareTo(people[j].getLastname()) < 0) {
                people[j+1] = people[j];
                j--;
            }
            people[j+1] = current;
        }
    }
    public void sortByPhoneUp(){
        for (int i = 1; i < people.length; i++) {
            Person current = people[i];
            int j = i - 1;
            while(j >= 0 && current.getPhone().compareTo(people[j].getPhone()) < 0) {
                people[j+1] = people[j];
                j--;
            }
            people[j+1] = current;
        }
    }
    public void sortByPostalCodeUp(){
        for (int i = 1; i < people.length; i++) {
            Person current = people[i];
            int j = i - 1;
            while(j >= 0 && current.getPostalCode().compareTo(people[j].getPostalCode()) < 0) {
                people[j+1] = people[j];
                j--;
            }
            people[j+1] = current;
        }
    }

    public void sortByIdDown(){
        for (int i = 1; i < people.length; i++) {
            Person current = people[i];
            int j = i - 1;
            while(j >= 0 && current.getId() > people[j].getId()) {
                people[j+1] = people[j];
                j--;
            }
            people[j+1] = current;
        }
    }
    public void sortByNameDown(){
        for (int i = 1; i < people.length; i++) {
            Person current = people[i];
            int j = i - 1;
            while(j >= 0 && current.getName().compareTo(people[j].getName()) > 0) {
                people[j+1] = people[j];
                j--;
            }
            people[j+1] = current;
        }
    }
    public void sortByLastnameDown(){
        for (int i = 1; i < people.length; i++) {
            Person current = people[i];
            int j = i - 1;
            while(j >= 0 && current.getLastname().compareTo(people[j].getLastname()) > 0) {
                people[j+1] = people[j];
                j--;
            }
            people[j+1] = current;
        }
    }
    public void sortByPhoneDown(){
        for (int i = 1; i < people.length; i++) {
            Person current = people[i];
            int j = i - 1;
            while(j >= 0 && current.getPhone().compareTo(people[j].getPhone()) > 0) {
                people[j+1] = people[j];
                j--;
            }
            people[j+1] = current;
        }
    }
    public void sortByPostalCodeDown(){
        for (int i = 1; i < people.length; i++) {
            Person current = people[i];
            int j = i - 1;
            while(j >= 0 && current.getPostalCode().compareTo(people[j].getPostalCode()) > 0) {
                people[j+1] = people[j];
                j--;
            }
            people[j+1] = current;
        }
    }

    public String toString(){
        String text = "";
        for(Person i : people)
            text += i+"\n\n";
        return text;
    }
}