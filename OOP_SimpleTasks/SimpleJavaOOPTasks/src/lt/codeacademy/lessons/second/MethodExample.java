package lt.codeacademy.lessons.second;

public class MethodExample {

    public static void main(String[] args) {

        MethodExample methodExample = new MethodExample();

        methodExample.firstMethod();

        //static metodas kitoje klaseje iskvieciamas

        double spped = StaticMethodsAnotherClass.getName();



    }

    public void firstMethod() {

        System.out.println("Iskviestas");

        int age = getAge();
        System.out.println(age);

        printUserAge(age);

        // iskviesti statini metoda is nesatatinio

        System.out.println(StaticMethodsAnotherClass.getName());

    }

    public int getAge(){
        return 5;
    }

    public void printUserAge(int age){

        System.out.println(age);
    }
}
