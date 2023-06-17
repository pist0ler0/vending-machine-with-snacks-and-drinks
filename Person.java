public class Person {
    private String name;
    private String surname;

    public Person(String name, String surname){
        this.name = name;
        this.surname = surname;
    }
    public Person(){
        name = "Jan";
        surname = "Kowalski";
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
    
}
