package lt.codeacademy.lessons.fifth;

public class TaskAdvanced {

    public static void main(String[] args) {

        TaskAdvanced taskAdvanced = new TaskAdvanced();

        taskAdvanced.removeDublicate("w3recource");

    }

    private void removeDublicate(String text) {
        String textDublicate = text.substring(0,9);

        System.out.println(textDublicate);
    }


}
