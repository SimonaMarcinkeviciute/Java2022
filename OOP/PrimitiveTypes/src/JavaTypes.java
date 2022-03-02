public class JavaTypes {

    //Main start application

    public static void main(String[] args) {

        byte byteType = 20; //saugo nuo -128 iki 127, uzima 1 baita(8 bitus)
        System.out.println("Byte: " + byteType);

        short shortType = 32000; //saugo nuo
        System.out.println("Short: " + shortType);

        int intType = 1000000000;
        System.out.println("Int: " + intType);

        long longType = 1000000000000000000L;
        System.out.println("Long: " + longType);

        float floatType = 55.5F;
        System.out.println("Float: " + floatType);

        double doubleType = 10.369;
        System.out.println("Double: " + doubleType);

        char charType = 'A';
        System.out.println("Char: " + charType);

        boolean booleanType = false;
        System.out.println("Boolean: " + booleanType);


        //CTRL + ALT + L sulygiuoja koda
        //CTRL + D pakopijuoja eilute

        int valueA = 10;

        System.out.println("ValueA: " + valueA);
        System.out.println("ValueA: " + valueA++);
        System.out.println("ValueA: " + ++valueA);

        int valueB = 5;

        System.out.println("ValueB: " + valueB--);
        System.out.println("ValueB: " + --valueB);

        double valueC = 5.5;

        //valueC = valueC + 2;
        valueC += 2;
        System.out.println("ValueC: " + valueC);

        int suma = valueA + valueB + (int) valueC;
        //double suma = valueA + valueB + valueC
        System.out.println("Sudetis: " + suma);

        double result = (valueA + valueB) * valueC;
        System.out.println("Veiksmai: " + result);




    }
}
