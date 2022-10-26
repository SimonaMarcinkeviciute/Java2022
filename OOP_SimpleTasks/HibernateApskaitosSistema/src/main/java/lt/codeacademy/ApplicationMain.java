package lt.codeacademy;


import lt.codeacademy.provider.SessionFactoryProvider;

public class ApplicationMain {
    public static void main(String[] args) {
        UserControler userControler = new UserControler();
        userControler.selectAction();
    }


}
