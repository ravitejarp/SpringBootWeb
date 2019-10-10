package com.ravi.springboot.springbootweb.restcontroller;

import com.ravi.springboot.springbootweb.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LoginController {

    final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/login")
    public String login(ModelMap modelMap) {
        return "login";
    }

    @PostMapping("/login")
    public String loginHome(ModelMap modelMap, @RequestParam String name, @RequestParam String password) {
        modelMap.put("name", name);
        modelMap.put("password", password);
        if (loginService.validateUser(name, password)) {
            return "home";
        }
        modelMap.put("errorMessage", "Please enter a valid username & password");
        return "login";
    }

    @GetMapping("/home")
    public String displayHome(@RequestParam String name, ModelMap model) {
        model.put("name", name);
        return "home_sample";
    }

}
