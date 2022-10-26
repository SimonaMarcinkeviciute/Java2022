package lt.codeacademy.lessons.fourteenth.staticFinal;

public class Task3Final {
    int a;
   final int b;

   // deklaruoti final kintamaji galima per konstruktoriu

    public Task3Final(int b ) {
        this.b = b;
    }

    public  void keisti(int one, int two) {
        a = one;
        //negalima priskirti reiksmes
        //b = two;
        System.out.println("Priskirtos reiksmes" + a);
        System.out.println("Priskirtos reiksmes" + b);
    }
}
