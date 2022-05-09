package lt.codeacademy.lessons.ninth.ciklai;

public class ReverseArray {

    public static void main(String[] args) {

        int[] numbArray = { 1, 56, 89, 744, 26, 7, 59};

        for (int i = numbArray.length; i > 0; i--) {
            System.out.println(numbArray[i - 1]);
        }
    }
}
