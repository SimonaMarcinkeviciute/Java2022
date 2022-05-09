package lt.codeacademy.lessons.fiftheen.staticFinal;

public class StudentMain {
    public static void main(String[] args) {
        Student studentOne = new Student(1, "Andrius", 50);
        Student studentTwo = new Student(2, "Petras", 41);
        Student studentThree = new Student(3, "Jonas", 96);

        studentOne.printInfo();
        studentOne.setVardas("Baltrunas");
        studentOne.printInfo();

    }
}
