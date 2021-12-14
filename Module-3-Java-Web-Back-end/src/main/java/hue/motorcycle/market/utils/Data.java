package hue.motorcycle.market.utils;

import hue.motorcycle.market.bean.UserAccount;
import hue.motorcycle.market.config.SecurityConfig;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Data {
    private static final Map<String, UserAccount> mapUsers = new HashMap<String, UserAccount>();

    static {
        initUsers();
    }

    private static void initUsers() {

        //        Account 1 là Admin
        UserAccount SupperAdmin = new UserAccount(68686,"SupperAdmin", Collections.singletonList(SecurityConfig.ROLE_SUPPER_ADMIN),"0973017102","supper.admin@gmail.com","28 Nguyễn Tri Phương","68686");

        // Account 2 là  user
        UserAccount user = new UserAccount(843017102,"User", Collections.singletonList(SecurityConfig.ROLE_USER),"0843017102","sample.user@gmail.com","28 Nguyễn Tri Phương","843017102");

        mapUsers.put(SupperAdmin.getPhone(), SupperAdmin);
        mapUsers.put(user.getPhone(), user);
    }

        // Tìm kiếm người dùng theo userName và password.
        public static UserAccount findUser(String phone, String password) {
            UserAccount u = mapUsers.get(phone);
            if (u != null && u.getPassword().equals(password)) {
                return u;
            }
            return null;


    }

}
