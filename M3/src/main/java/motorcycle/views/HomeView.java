//package motorcycle.views;
//
//import vn.tnh.maket.motorcycle.model.Role;
//import vn.tnh.maket.motorcycle.model.User;
//
//import java.util.Scanner;
//
//public class HomeView {
//    LoginView loginView = new LoginView();
//    private final UserView userView = new UserView();
//    private final AdminView adminView = new AdminView();
//    private final NewsView newsView = new NewsView();
//    private final Scanner scanner = new Scanner(System.in);
//    private User userAuth;
//
//    public void show() throws Exception {
//        if (userAuth == null)
//            notLogged();
//        else
//            logged();
//        do {
//            int choice = scanner.nextInt();
//            scanner.nextLine();
//            if (choice == 0)
//                break;
//            switch (choice) {
//                case 1:
//                    newsView.showNewsList(1);
//                    break;
//                case 2:
//                    userAuth = loginView.signIn(Role.USER);
//                    break;
//                case 3:
//                    loginView.signUp();
//                    break;
//                case 12345:
//                    userAuth = loginView.signIn(Role.ADMIN);
//                    break;
//                case 86868:
//                    userAuth = loginView.signIn(Role.SUPER_ADMIN);
//                    break;
//            }
//            System.out.print("press y to continue:");
//            String character = scanner.next();
//            if (character.equalsIgnoreCase("y"))
//                if (userAuth == null)
//                    notLogged();
//                else
//                    logged();
//        } while (true);
//    }
//
//
//    private void notLogged() {
//        System.out.printf("%n%n ---------Welcome to Hue Motorcycle Market----------%n");
//        System.out.printf("|     1. Show motorcycle list                                             |%n");
//        System.out.printf("|     2. Sign in                                                                         |%n");
//        System.out.printf("|     3. Sign up                                                                       |%n");
//        System.out.printf("|     0. Exit                                                                              |%n");
//        System.out.printf(" ---------------------------------------------------------------------------%n");
//        System.out.print("Your choice: ");
//    }
//
//    private void logged() throws Exception {
//        System.out.printf("%n%n -------Welcome to Hue Motorcycle Market------%n");
//
//        switch (userAuth.getRole()) {
//            case SUPER_ADMIN:
//                adminView.showAdministrator();
//                break;
//            case ADMIN:
//                adminView.showAdmin();
//                break;
//            case USER:
//                userView.show(userAuth.getId());
//                break;
//        }
//
//    }
//}
