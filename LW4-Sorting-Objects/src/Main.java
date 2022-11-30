public class Main {
    public static void main(String[] args) {
        Person dude1 = new Person(1, "sas","terf","5012","+7-898-11-321-33");
        Person dude2 = new Person(222, "bib","terf","X42","+7-814-17-321-32");
        Person dude3 = new Person(33, "bib","uno","21700","+7-800-71-691-13");
        Person dude4 = new Person(1, "cri","nge","610-0312","+7-824-51-761-83");

        PersonList dudes = new PersonList(dude1, dude2, dude3, dude4);
        dudes.sortByIdUp();
        System.out.println(dudes);
        //dudes.sortByNameUp();
        dudes.sortByLastnameDown();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" + dudes);
        //dudes.sortByPhoneDown();
        //dudes.sortByPostalCodeUp();
    }
}
