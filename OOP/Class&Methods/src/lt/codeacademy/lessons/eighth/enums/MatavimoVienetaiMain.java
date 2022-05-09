package lt.codeacademy.lessons.eighth.enums;

public class MatavimoVienetaiMain {

    public static void main(String[] args) {

        MatavimoVienetai matavimoVienetai = MatavimoVienetai.MILIMETRAS;

        System.out.println(matavimoVienetai);

        System.out.println(MatavimoVienetai.METRAS.equals(MatavimoVienetai.METRAS));
        System.out.println(MatavimoVienetai.METRAS.equals(MatavimoVienetai.MILIMETRAS));
    }


}
