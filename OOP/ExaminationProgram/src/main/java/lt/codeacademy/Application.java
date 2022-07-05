package lt.codeacademy;

import lt.codeacademy.controller.UserInterfaceController;
import lt.codeacademy.provider.SessionFactoryProvider;
import org.hibernate.SessionFactory;

public class Application {
    public static void main(String[] args) {
        UserInterfaceController controller = new UserInterfaceController();
        controller.startApplication();

    }
}
