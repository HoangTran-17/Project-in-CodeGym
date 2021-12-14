package hue.motorcycle.market.request;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.*;

public class UserRoleRequestWrapper extends HttpServletRequestWrapper {
    private String user;
    private List<String> roles = null;
    private HttpServletRequest realRequest;

    public UserRoleRequestWrapper(String user, List<String> roles, HttpServletRequest request) {
        super(request);
        this.user = user;
        this.roles = roles;
        this.realRequest = request;
    }

    @Override
    public boolean isUserInRole(String role) {
        if (roles == null) {
            return this.realRequest.isUserInRole(role);
        }
        return roles.contains(role);
    }

    @Override
    public Principal getUserPrincipal() {
        if (this.user == null) {
            return realRequest.getUserPrincipal();
        }

        // Make an anonymous implementation to just return our user
        return new Principal() {
            @Override
            public String getName() {
                return user;
            }
        };
    }

}
