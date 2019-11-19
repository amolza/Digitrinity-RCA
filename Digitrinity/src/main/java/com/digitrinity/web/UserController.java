package com.digitrinity.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.digitrinity.model.Users;
import com.digitrinity.service.SecurityService;
import com.digitrinity.service.UserService;
import com.digitrinity.validator.UserValidator;

@Controller
public class UserController {
	
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;
    

    @GetMapping("/registration")
    public String registration(Model model) {
    	
        model.addAttribute("userForm", new Users());
        return "pages/registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") Users userForm, BindingResult bindingResult) {

    	userValidator.validate(userForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "pages/registration";
        }
        userService.save(userForm);
        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());
        return "redirect:/welcome";
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "pages/login";
    }

    @GetMapping({"/", "/welcome"})
    public String welcome(Model model) {
        return "pages/welcome";
    }
}
