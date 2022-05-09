package lt.codeacademy.lessons.eighth.enums;

public class EnumMain {
    public static void main(String[] args) {
        System.out.println(Days.ANTRADIENIS);
        System.out.println(Days.ANTRADIENIS.name());

        //per konstanta galima pasiekti kintamuosius, bet reikia
        //susikurti geterius, nes kitaip nepasieksim reiksmiu

        System.out.println(Days.TRECIADIENIS.getName());
        System.out.println(Days.TRECIADIENIS.getNumber());

        Days days = Days.getDayByNumber(2);

        System.out.println(days.getNumber());
        System.out.println(days.getName());
    }
}
