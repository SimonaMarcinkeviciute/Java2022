package lt.codeacademy.lessons.twentySixth.pilimorfizmas.task1;

public class Main {
    public static void main(String[] args) {

        TeigiamasSkaicius teigiamasSkaicius = new TeigiamasSkaicius(20, 100, 200);
        run(teigiamasSkaicius);
        Skaicius lyginisSkaicius = new LyginisSkaicius(10, 200, 300);
        run(lyginisSkaicius);
        Skaicius nelyginisSkaicius = new NelyginisSkaicius(10, 200, 5000);
        run(nelyginisSkaicius);

        Skaicius neigiamasSkaicius = new NeigiamiSkaiciai(10, 100, 200);
        run(neigiamasSkaicius);

    }

    private static void run(Skaicius sk) {
        sk.generuok();
        System.out.println(sk.sum());
    }
}
