package hue.motorcycle.market.config;

import java.util.*;

public class SecurityConfig {
    public static final String ROLE_SUPPER_ADMIN = "SUPPER ADMIN";
    public static final String ROLE_ADMIN = "ADMIN";
    public static final String ROLE_USER = "USER";

    private static final Map<String, List<String>> mapConfig = new HashMap<String, List<String>>();

    static {
        init();
    }

    private static void init() {
        // Cấu hình cho vai trò "USER".
        List<String> user = new ArrayList<String>();

        user.add("/userTask");

        mapConfig.put(ROLE_USER,user);

        // Cấu hình cho vai trò "ADMIN".
        List<String> admin = new ArrayList<String>();

        admin.add("/userInfo");
        admin.add("/adminTask");

        mapConfig.put(ROLE_ADMIN,admin);

        // Cấu hình cho vai trò "SUPPER ADMIN".
        List<String> supperAdmin = new ArrayList<String>();

        supperAdmin.add("/adminInfo");
        supperAdmin.add("/supperAdminTask");

        mapConfig.put(ROLE_SUPPER_ADMIN, supperAdmin);
    }

    public static Set<String> getAllAppRoles() {
        return mapConfig.keySet();
    }

    public static List<String> getUrlPatternsForRole(String role) {
        return mapConfig.get(role);
    }
}

