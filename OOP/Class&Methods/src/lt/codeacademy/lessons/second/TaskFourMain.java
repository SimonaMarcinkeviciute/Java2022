package lt.codeacademy.lessons.second;

public class TaskFourMain {

    public static void main(String[] args) {

        TaskFour taskFourMain = new TaskFour();

        int a = taskFourMain.triangleArea(5,6);
        int b = taskFourMain.rectangleArea(5,6);
        int c = taskFourMain.squareArea(5);
        float d = taskFourMain.circleArea(6);

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println((int)d);





    }
}
