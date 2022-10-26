package lt.codeacademy.lessons.eighth.array;

import java.util.Arrays;

public class Task3 {

    public static void main(String[] args) {

        String zodis = "Java";

        // metodas string paversti i char areju
        char[] simboliai = zodis.toUpperCase().toCharArray();

        System.out.println(Arrays.toString(simboliai));

    }
}
