package lt.codeacademy.lessons.sixteen.StringBuilder;

public class Task1 {
    public static void main(String[] args) {
        StringBuilder text1 = new StringBuilder("Liepa");
        StringBuilder text2 = new StringBuilder("Atradienis");

        System.out.println(text1.append(text2));
        System.out.println(text1.reverse());
        System.out.println(text1.delete(0,5).delete(4,10).append("ai"));
        System.out.println(text1.delete(3,6).append("2018"));
        System.out.println(text1.delete(3,10).append("om 2018"));
        System.out.println(text1.delete(0,7).delete(2,3).reverse());

    }
}
