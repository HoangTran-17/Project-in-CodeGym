package vn.tnh.maket.motorcycle.views;

import vn.tnh.maket.motorcycle.model.Role;
import vn.tnh.maket.motorcycle.model.User;
import vn.tnh.maket.motorcycle.model.UserStatus;
import vn.tnh.maket.motorcycle.regex.UserRegex;
import vn.tnh.maket.motorcycle.services.IUserService;
import vn.tnh.maket.motorcycle.services.UserService;

import java.util.Scanner;

public class LoginView {
    private final IUserService userService = new UserService();
    private final UserView userView = new UserView();
    private final Scanner scanner = new Scanner(System.in);

    public User signIn(Role role) {
        System.out.printf("---------------SIGN IN---------------%n");
        User auth = null;
        do {
            User user = input();
            switch (role) {
                case SUPER_ADMIN:
                    auth = userService.signInAdmin(user.getId(), user.getPassword(), Role.SUPER_ADMIN);
                    break;
                case ADMIN:
                    auth = userService.signInAdmin(user.getId(), user.getPassword(), Role.ADMIN);
                    break;
                case USER:
                    auth = userService.signIn(user.getId(), user.getPassword());
                    break;
            }

            if (auth == null)
                System.out.printf("Error!Request retype %n");
        } while (auth == null);
        System.out.printf("-----------Logged in successfully----------%n%n");
        return auth;
    }

    private User input() {
        System.out.print("|Enter phone number: ");
        String phoneNumber = scanner.nextLine();
        int id = Integer.parseInt(phoneNumber);
        System.out.print("|Enter password: ");
        String password = scanner.nextLine();
        User user = new User();
        user.setId(id);
        user.setPassword(password);
        return user;
    }


    public void signUp() {
        System.out.printf("---------------------SIGN UP---------------------%n");
        Integer id;
        String phoneNumber;
        do {

            System.out.print("Phone number(\"0987654321\"): ");
            phoneNumber = scanner.nextLine();
            while (!UserRegex.validatePhoneNumber(phoneNumber)) {
                System.out.print("Error! Request to re-enter phone number: ");
                phoneNumber = scanner.nextLine();
            }
            id = Integer.parseInt(phoneNumber.substring(1));

            if (userService.exist(id)) {
                id = null;
                System.out.println("Phone number exist");
            }
        } while (id == null);

        System.out.printf("Name(size:6 to 20 and contain only 'a-Z' & space): %n");
        String name = scanner.nextLine();
        while (!UserRegex.validateName(name)) {
            System.out.print("Error! Request to re-enter name: ");
            name = scanner.nextLine();
        }

        System.out.print("Email: ");
        String email = scanner.nextLine().toLowerCase();
        while (!UserRegex.validateEmail(email)) {
            System.out.print("Error! Request to re-enter email: ");
            email = scanner.nextLine();

        }

        System.out.print("Address: ");
        String address = scanner.nextLine();

        System.out.print("Password(size:6 to 12 and contain only 'a-Z'&'0-9'): ");
        String password = scanner.nextLine();
        while (!UserRegex.validatePassword(password)) {
            System.out.print("Error! Request to re-enter password: ");
            password = scanner.nextLine();
        }
        System.out.printf("----------------------------------------------%n");

        User user = new User(id, name, phoneNumber, email, address, password);
        user.setRole(Role.USER);
        user.setStatus(UserStatus.AVAILABLE);

        try {
            userService.signUp(user);
            System.out.printf("------------- Signup in successfully! -------------%n%n");
            userView.show(id);
        } catch (Exception e) {
            System.out.printf("---------------- Signup in Error! ----------------%n%n");
            e.printStackTrace();
        }


    }

}
