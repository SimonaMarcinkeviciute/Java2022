package lt.codeacademy.lessons.second;

public class OverloadingExample {

    public static void main(String[] args) {

        OverloadingExample overloadingExample = new OverloadingExample();

        int intSum = overloadingExample.sum(10,5);
        double doubleSum = overloadingExample.sum(55.5, 100.55);

        System.out.println(intSum);
        System.out.println(doubleSum);

    }

    //overloading, turi sutapti metodu vardai, turi skirtis parametru skaicius arba tipai

    public int sum(int numb, int secondNumb) {
        return numb + secondNumb;
    }

    public double sum(double num, double secondNum){
        return num + secondNum;
    }
}
