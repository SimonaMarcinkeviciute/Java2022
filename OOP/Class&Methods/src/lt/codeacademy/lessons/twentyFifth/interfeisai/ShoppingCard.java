package lt.codeacademy.lessons.twentyFifth.interfeisai;

public class ShoppingCard implements Cart, Cart2{
    @Override
    public void printCartInfo() {
        System.out.println("Cart info");
    }

    @Override
    public double getCartAmount() {
        return 22.5;
    }
    // sito metodo nematys Cart cart = new ShoppingCard(); toks objektas
    public void testMethod() {
        System.out.println("Method");
    }
// Cart cart = new ShoppingCard(); objektas iskvies perrasyta sita metoda
    @Override
    public void testDefoult() {
        System.out.println("cart defoult");
    }

    @Override
    public void secondCartMethod() {

    }
}
