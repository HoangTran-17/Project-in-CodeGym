//package motorcycle.views;
//
//import vn.tnh.maket.motorcycle.model.News;
//import vn.tnh.maket.motorcycle.model.User;
//import vn.tnh.maket.motorcycle.services.NewsService;
//import vn.tnh.maket.motorcycle.services.UserService;
//
//import java.util.List;
//import java.util.Scanner;
//
//public class NewsView {
//    private final NewsService newsService = new NewsService();
//    private final UserService userService = new UserService();
//    private Scanner scanner = new Scanner(System.in);
//    private int choice = 0;
//
//    public void createNews(int userId) {
//        System.out.printf("-------------CREATE NEWS-------------%n");
//        System.out.printf("Motorcycle Brand('HONDA','YAMAHA','SUZUKI'):%n");
//        String brand = scanner.nextLine();
//        System.out.printf("Motorcycle type ('Scooter', 'Underbone','Sportbike'): %n");
//        String type = scanner.nextLine();
//
//        System.out.printf("Motorcycle line ('SH','Air Blade','Exciter'):%n");
//        String line = scanner.nextLine();
//
//        System.out.printf("Color('White','Black','Blue'): %n");
//        String color = scanner.nextLine();
//
//        System.out.printf("Year('2017'): %n");
//        int year = Integer.parseInt(scanner.nextLine());
//
//        System.out.printf("The number of kilometers traveled('Hơn 10000 km'): %n");
//        String km = scanner.nextLine();
//
//        System.out.printf("Price(VND): %n");
//        double price = Double.parseDouble(scanner.nextLine());
//        System.out.printf("Description: %n");
//        String description = scanner.nextLine();
//
//        long id = System.currentTimeMillis() / 1000;
//        News news = new News(id, userId, brand, type, line, color, year, km, price, description);
//
//        try {
//            newsService.create(news);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.printf("---------------Create successful new news-------------%n%n");
//        System.out.printf("1. Show news detail %n");
//        System.out.printf("2. Show motorcycle list %n");
//        System.out.printf("3. Back to home %n");
//        System.out.printf("------------------------------------------------------%n");
//        System.out.print("Your choice: ");
//        choice = scanner.nextInt();
//        scanner.nextLine();
//        switch (choice) {
//            case 1:
//                showNewsDetail(userId, id);
//                break;
//            case 2:
//                showNewsList(userId);
//                break;
//            case 3:
//                //	userView.managementForUser(userId);
//                break;
//            default:
//                throw new IllegalStateException("Unexpected value: " + choice);
//        }
//    }
//
//
//    public void showNewsList(int userId) {
//        try {
//            do {
//                System.out.printf("-----------------------------------------------MOTORCYCLE LIST-----------------------------------------------%n");
//                System.out.printf("%-8s %-10s %-10s %-10s %-10s %-8s %-15s %15s %n", "Serial", "Brand", "Type", "Line", "Color", "Year", "Km traveled", "Price");
//                List<News> newsList = newsService.getNewsList();
//                for (int i = newsList.size() - 1; i >= 0; --i) {
//                    News news = newsList.get(i);
//                    System.out.printf("%-8s %s%n", newsList.size() - i, news.toString());
//                }
//                System.out.printf("-------------------------------------------------------------------------------------------------------------%n");
//                System.out.printf("Enter serial number to news detail%n");
//                System.out.print("Enter '0' to home: ");
//                choice = scanner.nextInt();
//                scanner.nextLine();
//                if (choice == 0) {
//                    System.out.printf("%n%n");
//                    break;
//                }
//                if (choice >= 1 && choice <= newsList.size()) {
//                    long id = newsList.get(newsList.size() - choice).getId();
//                    if (showNewsDetail(userId, id) == -1)
//                        break;
//                }
//            } while (true);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    public int showNewsDetail(Integer userId, long id) {
//        try {
//            System.out.printf("---------------MOTORCYCLE DETAIL---------------%n");
//            News news = newsService.getById(id);
//            int sellerId = news.getUserId();
//            User user = userService.getById(sellerId);
//
//            System.out.printf("Brand: %s%n", news.getBrand());
//            System.out.printf("Type: %s%n", news.getType());
//            System.out.printf("Line: %s%n", news.getLine());
//            System.out.printf("Color: %s%n", news.getColor());
//            System.out.printf("Year: %d%n", news.getYear());
//            System.out.printf("Km traveled: %s%n", news.getKm());
//            System.out.printf("Price: %,.0f vnđ%n", news.getPrice());
//            System.out.printf("Description: %s%n", news.getDescription());
//            System.out.printf("Seller's name: %s%n", user.getName());
//            System.out.printf("Seller's phone number: %s%n", user.getPhone());
//            System.out.printf("Address: %s%n", user.getAddress());
//            System.out.println("------------------------------------------------");
//
//            System.out.printf("1. Back to motorcycle list %n");
//            System.out.printf("2. Back to home %n");
//            if (userId == sellerId) {
//                System.out.printf("9.Edit news%n");
//            }
//            System.out.print("Enter choice: ");
//            choice = scanner.nextInt();
//            scanner.nextLine();
//            if (choice == 2)
//                return -1;
//            if (userId == sellerId && choice == 9) {
//                updateNews(news);
//                return -1;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return 1;
//    }
//
//    public void updateNews(News news) {
//        System.out.printf("-------------UPDATE MOTORCYCLE------------%n");
//        System.out.printf("Your news: %-10s %-10s %-10s %-10s %-8s %-15s %,.0f vnđ%n", news.getBrand(), news.getType(), news.getLine(), news.getColor(), news.getYear(), news.getKm(), news.getPrice());
//        System.out.printf("Motorcycle Brand('HONDA','YAMAHA','SUZUKI'): %n");
//        String brand = scanner.nextLine();
//        System.out.printf("Motorcycle type ('Scooter', 'Underbone','Sportbike'): %n");
//        String type = scanner.nextLine();
//
//        System.out.printf("Motorcycle line ('SH','Air Blade','Exciter'):%n");
//        String line = scanner.nextLine();
//
//        System.out.printf("Color('White','Black','Blue'): %n");
//        String color = scanner.nextLine();
//
//        System.out.printf("Year('2017'): %n");
//        int year = Integer.parseInt(scanner.nextLine());
//
//        System.out.printf("The number of kilometers traveled('Hơn 10000 km'): %n");
//        String km = scanner.nextLine();
//
//        System.out.printf("Price(VND): %n");
//        double price = Double.parseDouble(scanner.nextLine());
//
//        System.out.printf("Description: %n");
//        String description = scanner.nextLine();
//        long id = news.getId();
//        int userId = news.getUserId();
//        news = new News(id, userId, brand, type, line, color, year, km, price, description);
//        try {
//            newsService.update(news);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//        System.out.printf("---------------Update successful-------------%n%n");
//        System.out.print("Enter 0 continue:");
//        scanner.next();
//    }
//
//    public void showNewsOfUser(int id) {
//        try {
//            System.out.printf("---------------YOUR NEWS LIST---------------%n");
//            System.out.printf("%-15s %-10s %-10s %-10s %-10s %-8s %-15s %15s %n", "ID", "Brand", "Type", "Line", "Color", "Year", "Km traveled", "Price");
//            List<News> newsList = newsService.getNewsList();
//            for (News news : newsList) {
//                if (news.getUserId() == id) {
//                    System.out.printf("%-15s %-10s %-10s %-10s %-10s %-8s %-15s %,17.0f vnđ %n", news.getId(), news.getBrand(), news.getType(), news.getLine(), news.getColor(), news.getYear(), news.getKm(), news.getPrice());
//                }
//            }
//            System.out.printf("----------------------------------------------------------------------------------------------------------------%n");
//            System.out.printf("Enter news id for update %n");
//            System.out.printf("Enter '0' to  back%n");
//            long choice = scanner.nextLong();
//            for (News news : newsList) {
//                if (news.getId() == choice) {
//                    updateNews(news);
//                    return;
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
