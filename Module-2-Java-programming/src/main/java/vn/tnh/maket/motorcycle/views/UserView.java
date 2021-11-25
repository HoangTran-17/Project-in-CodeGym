package vn.tnh.maket.motorcycle.views;

import vn.tnh.maket.motorcycle.model.User;
import vn.tnh.maket.motorcycle.services.IUserService;
import vn.tnh.maket.motorcycle.services.UserService;

import java.util.Scanner;

public class UserView {

    private final IUserService userService;
    private final Scanner scanner = new Scanner(System.in);
    NewsView newsView = new NewsView();

    public UserView() {
        userService = new UserService();
    }


    public void show(int userId) {
        do {
            try {
                System.out.printf("--------------------USER DETAIL--------------------%n");
                User user = userService.getById(userId);
                System.out.printf("Name: %s%n", user.getName());
                System.out.printf("phoneNumber: %s%n", user.getPhone());
                System.out.printf("Email: %s%n", user.getEmail());
                System.out.printf("Address: %s%n", user.getAddress());
                System.out.printf("Password: %s%n", user.getPassword());
                System.out.println("----------------------------------------");


                System.out.printf("1. Show motorcycles list %n");
                System.out.printf("2. Post news %n");
                System.out.printf("3. Manage your news %n");
                System.out.printf("4. Update user detail %n");
                System.out.printf("0. Exit %n");
                System.out.print("Enter choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();
                if (choice == 0)
                    break;
                switch (choice) {
                    case 1:
                        newsView.showNewsList(userId);
                        break;
                    case 2:
                        newsView.createNews(userId);
                        break;
                    case 3:
                        newsView.showNewsOfUser(userId);
                        break;
                    case 4:
                        updateUser(userId);
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (true);

    }

    public void updateUser(int id) {
        String phoneNumber = "0".concat(String.valueOf(id));

        System.out.printf("------------------UPDATE USER-----------------%n");
        System.out.printf("--------- Your phoneNumber number: %s --------%n", phoneNumber);

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Address: ");
        String address = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();


        User user = new User(id, name, phoneNumber, email, address, password);
        System.out.println("Confirmed phone number and email!");

        try {
            userService.update(user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}