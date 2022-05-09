package lt.codeacademy.lessons.thirthyFourth.varargs;

public class VargsExcample {
    public static void main(String[] args) {

        VargsExcample excample = new VargsExcample();
        excample.print("5", "Andrius", "5", "Teta");
        //galima parametru ir neperduoti
        excample.print("5");

    }
    //gali buti tik tokio pacio tipo, arba norint daugiau reikia irasyti
    // pirmus
    private void print(String a, String... names) {
        for(String name : names) {
            System.out.println(name + a);
        }
    }
}
