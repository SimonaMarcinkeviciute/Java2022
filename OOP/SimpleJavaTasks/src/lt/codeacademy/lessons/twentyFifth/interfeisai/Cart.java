package lt.codeacademy.lessons.twentyFifth.interfeisai;

public interface Cart extends Cart2 {

    ///naudojami kad nepriieitu vartotojas

    void printCartInfo();

    double getCartAmount();

    default void testDefoult() {
        System.out.println("Interface defoult method");
    }
}
