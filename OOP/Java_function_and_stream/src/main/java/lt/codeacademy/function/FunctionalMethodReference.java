package lt.codeacademy.function;


//mano iterfeisas funkcinis, gali buti tik vienas public methodas, interfeisuose metodai yra public pagal defoult
//galima antra sukurti defoult metoda
@FunctionalInterface
interface MyFunction{
    String sayHi(String value);

    default String secondMethod(int a) {
        return String.valueOf(a);
    }
}


//mano ne funkcinis interfeisas
interface MyNonFunction{
    String sayHi(String value);

    //String secondMethod(int a);
}

public class FunctionalMethodReference {

    private String myMethod(String value) {
        return "Labas" + value;
    }

    public static void main(String[] args) {

        FunctionalMethodReference reference = new FunctionalMethodReference();
        //is statinio ne statini metoda pasiekti reikia objekto tos klases,
        // jei butu statiniiai abu, butut galima per klases pav
        MyFunction mf = reference::myMethod;

        // neveiks jei intefeisas turi du public metodus
        MyNonFunction nf = reference::myMethod;
        //kviecia FunctionalMethodReference sayHi metoda


        System.out.println(mf.sayHi("Andrius"));
        System.out.println(nf.sayHi("Petras"));

        MyFunction secondMf = value -> "Second function" + value;
        MyNonFunction secondNf = value -> "Second non funcion" + value;

        System.out.println(secondMf.sayHi("jonas"));
        System.out.println(secondNf.sayHi("Onas"));
    }

}
