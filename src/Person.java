enum Gender{
    Male,
    Female;
}
public class Person {

    private String name;
    private String surname;
    private int row;
    Gender gender;
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public Person(String name, String surname, int row, Gender gender) {
        this.row = row;
        this.name = name;
        this.surname = surname;
        this.gender = gender;

    }

    public Person () {

    }

    @Override
    public String toString() {
        return "Name: " + name + "Surname: " + surname + "Gender: " + gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

}
