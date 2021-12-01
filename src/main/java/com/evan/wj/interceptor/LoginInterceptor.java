package com.evan.wj.interceptor;

import com.evan.wj.pojo.User;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        String contextPath = session.getServletContext().getContextPath();
        String[] requireAuthPages = new String[]{
                "index",
        };

        String uri = request.getRequestURI();

        uri = StringUtils.remove(uri, contextPath + "/");

        String page = uri;

        if (beginWidth(page, requireAuthPages)) {
            User user = (User) session.getAttribute("user");
            if (user == null) {
                response.sendRedirect("login");
                return false;
            }
        }

        return true;
    }

    private boolean beginWidth(String page, String[] requireAuthPages) {
        boolean result = false;
        for (String requiredAuthPage : requireAuthPages) {
            if (StringUtils.startsWith(page, requiredAuthPage)) {
                result = true;
                break;
            }
        }
        return result;
    }
}
