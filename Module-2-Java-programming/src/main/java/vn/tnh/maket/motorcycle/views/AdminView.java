package vn.tnh.maket.motorcycle.views;

import vn.tnh.maket.motorcycle.model.Role;
import vn.tnh.maket.motorcycle.model.User;
import vn.tnh.maket.motorcycle.model.UserStatus;
import vn.tnh.maket.motorcycle.regex.UserRegex;
import vn.tnh.maket.motorcycle.services.IUserService;
import vn.tnh.maket.motorcycle.services.UserService;

import java.util.List;
import java.util.Scanner;

public class AdminView {
    private final IUserService userService = new UserService();
    NewsView newsView = new NewsView();
    private final Scanner scanner = new Scanner(System.in);

    public void showUsersList() {
        try {
            System.out.printf("---------------------------------------USERS LIST---------------------------------------%n");
            System.out.printf("%-30s %-15s %-30s %-30s%n", "Name", "Phone", "Email", "Address");
            List<User> userList = userService.getUsers();

            for (User user : userList) {
                if (user.getRole() == Role.USER) {
                    System.out.printf("%-30s %-15s %-30s %-30s%n", user.getName(), user.getPhone(), user.getEmail(), user.getAddress());
                }
            }
            System.out.printf("----------------------------------------------------------------------------------------%n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showAdmin() throws Exception {
        NewsView newsView = new NewsView();
        HomeView homeView = new HomeView();
        do {
            System.out.printf("---------------Management page for admin--------------------%n");
            System.out.printf("1. Show motorcycle list %n");
            System.out.printf("2. Show user list %n");
            System.out.printf("0. Exit %n");
            System.out.printf("------------------------------------------------------------%n");
            System.out.printf("Your choice: %n");

            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 0) {
                homeView.show();
            }
            switch (choice) {
                case 1:
                    newsView.showNewsList(1);
                    break;
                case 2:
                    showUsersList();
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + choice);
            }
        } while (true);

    }

    public void showAdministrator() throws Exception {
        HomeView homeView = new HomeView();
        int choice;
        do {
            System.out.printf("---------------Management page for Director administrator--------------------%n");
            System.out.printf("1. Show admin account list %n");
            System.out.printf("2. Create new admin account %n");
            System.out.printf("3. Delete admin account %n");
            System.out.printf("0. Back to the home %n");
            System.out.printf("-----------------------------------------------------------------------------%n");
            System.out.print("Your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 0)
                homeView.show();
            switch (choice) {
                case 1:
                    showAdminList();
                    break;
                case 2:
                    createAdmin();
                    break;
                case 3:
                    deleteAdmin();
                    break;
            }
        } while (true);

    }

    private void showAdminList() {
        try {
            System.out.printf("----------------------------------ADMINS LIST----------------------------------%n");
            System.out.printf("%-15s %-15s %-30s %-30s%n", "Name", "Phone", "Email", "Address");
            List<User> userList = userService.getUsers();

            for (User user : userList) {
                if (user.getRole() == Role.ADMIN) {
                    System.out.printf("%-15s %-15s %-30s %-30s%n", user.getName(), user.getPhone(), user.getEmail(), user.getAddress());
                }
            }
            System.out.printf("------------------------------------------------------------------------------%n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createAdmin() {
        System.out.printf("-------------CREATE NEW ADMIN-------------%n");
        System.out.print("Phone number(\"0987654321\"): ");
        String phone = scanner.nextLine();
        while (UserRegex.validatePhoneNumber(phone)) {
            System.out.print("Error! Request to re-enter phone number: ");
            phone = scanner.nextLine();
        }
        int id = Integer.parseInt(phone.substring(1));

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
        System.out.printf("------------------------------%n");

        System.out.printf("%d, %s, %s, %s, %s, %s%n", id, name, phone, email, address, password);

        User admin = new User(id, name, phone, email, address, password);
        admin.setRole(Role.ADMIN);
        admin.setStatus(UserStatus.AVAILABLE);

        try {
            userService.signUp(admin);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.printf("---------------Create new admin account successful-------------%n%n");
    }

    private void deleteAdmin() {
        System.out.print("Select the admin id you want to delete: ");
        int choice = scanner.nextInt();
        userService.delete(choice);

        System.out.printf("---------------Delete successful-------------%n%n");

    }
}
