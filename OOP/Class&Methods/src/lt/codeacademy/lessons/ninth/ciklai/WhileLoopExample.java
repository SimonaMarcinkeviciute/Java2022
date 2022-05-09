package lt.codeacademy.lessons.ninth.ciklai;

public class WhileLoopExample {

    public static void main(String[] args) {

        int count = 0;

        while (count != 5) {
            System.out.println(count);
            count++;
        }

        do {
            System.out.println(count);
        } while (count != 5);
    }
}
