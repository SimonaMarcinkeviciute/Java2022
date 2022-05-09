package lt.codeacademy.lessons.belekas;

public class Teacher {

   String name;
   String surname;

    public Teacher(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
