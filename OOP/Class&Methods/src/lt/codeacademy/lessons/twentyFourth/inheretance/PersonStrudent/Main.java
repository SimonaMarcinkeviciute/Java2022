package lt.codeacademy.lessons.twentyFourth.inheretance.PersonStrudent;

public class Main {
    public static void main(String[] args) {
        Student student = new Student("Andrius", "Pavarde", "333", "KTU");
        //galiu paimti situos kintamuosius, nes Strudent klase paveldi Person klase
        student.getName();
        student.getSurname();
        //isspausdint tik perrasyra metoda
        System.out.println(student.printInfo());
        // id gausim su perrasytu metodu

        Person person = new Person("Andris", "Baltrunas", "3333");
        // gausim id reisme su neperrasytu metodu
        //isspausdint metoda is person
        System.out.println(person.printInfo());

        Person person1 = new Student("Andrius", "Pavarde", "333", "KTU");
        //gaus studento info
        System.out.println(person1.printInfo());

        //gauti universiteta
        if(person1 instanceof Student st) {
            System.out.println(st.getUniversity());
        }


    }

    private static void testMethod(Person person) {
        System.out.println(person.printInfo());

    }
}
