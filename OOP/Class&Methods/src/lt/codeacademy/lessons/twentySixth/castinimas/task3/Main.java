package lt.codeacademy.lessons.twentySixth.castinimas.task3;

public class Main {
    public static void main(String[] args) {
        DuomenuBaze duomenuBaze = new DuomenuBaze();
        RemoteDisc remoteDisc = new RemoteDisc();

        Info info1 = new Info(1, "Simple text");
        Info info2 = new Info(2, "Simple text");
        Info info3 = new Info(3, "Simple text");
        Info info4 = new Info(4, "Simple text");

        save(duomenuBaze, info1);
        save(duomenuBaze, info2);

        save(remoteDisc, info3);
        save(remoteDisc, info4);

        findInfo(remoteDisc, "text");

    }

    private static void save(Saugykla saugykla, Info info) {
        saugykla.saveInfo(info);
    }

    private static void findInfo(Saugykla saugykla, int id) {
        Info info = saugykla.findInfo(id);
        System.out.println(info);
    }

    private static void findInfo(Saugykla saugykla, String text) {
        Info info = saugykla.findInfo(text);
        System.out.println(info);
    }
}
