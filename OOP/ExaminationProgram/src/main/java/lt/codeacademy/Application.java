package lt.codeacademy;

import lt.codeacademy.controller.UserInterfaceController;

public class Application {
    public static void main(String[] args) {
        UserInterfaceController controller = new UserInterfaceController();
        controller.startApplication();
    }
}
