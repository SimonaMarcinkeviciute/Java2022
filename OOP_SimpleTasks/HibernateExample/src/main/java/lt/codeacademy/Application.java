package lt.codeacademy;

import lt.codeacademy.servise.PassportServise;
import lt.codeacademy.servise.UserService;

public class Application {
    public static void main(String[] args) {
        UserService userService = new UserService();
        PassportServise passportServise = new PassportServise();
        userService.createUser();

        //passportServise.showAllPassports();

        userService.showFiltered();
        /*userService.showUsersEmails();
        userService.showUserById(1L);
        userService.showUpdateUser();
        userService.showUserById(1L);
        userService.showUpdateEmailById();
        userService.showUserById(1L);*/
        //userService.deleteUser();
        //userService.deleteUserById(2L);
        //userService.deleteUserByEmail("jonas.jonaitis@gmail.com");

    }
}
