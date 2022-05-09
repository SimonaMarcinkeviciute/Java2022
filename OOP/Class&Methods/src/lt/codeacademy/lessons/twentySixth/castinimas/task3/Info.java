package lt.codeacademy.lessons.twentySixth.castinimas.task3;

public class Info {
    private int id;
    private String text;

    public Info(int id, String text) {
        this.id = id;
        this.text = text;
    }

    boolean isInText(String word) {
       return text.contains(word);

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Info{" +
                "id=" + id +
                ", text='" + text + '\'' +
                '}';
    }
}
