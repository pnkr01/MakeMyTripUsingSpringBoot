package com.pawan.dreambuy.config.configs;

import com.pawan.dreambuy.model.auth.UserRegistration;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Config {
  private   LoggerFactory loggerFactory;
  @Autowired
  private UserRegistration userRegistration;

    public boolean checkIsAnyCurrentUserLoggedIn(HttpServletRequest request) {
        HttpSession session = request.getSession();
        UserRegistration isUserLoggedIn = (UserRegistration) session.getAttribute("loggedInUser");
        return isUserLoggedIn != null;
    }

    public void setSessionAttribute(HttpServletRequest request,UserRegistration currentUser){
        HttpSession session = request.getSession();
        session.setAttribute("loggedInUser",currentUser);
    }
}
