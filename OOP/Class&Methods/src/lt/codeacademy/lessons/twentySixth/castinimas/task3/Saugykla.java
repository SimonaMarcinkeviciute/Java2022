package lt.codeacademy.lessons.twentySixth.castinimas.task3;

public interface Saugykla {
    void saveInfo(Info info);

    Info findInfo(int id);

    Info findInfo(String word);
}
