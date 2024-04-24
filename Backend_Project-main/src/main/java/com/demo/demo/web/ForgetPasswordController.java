package com.demo.demo.web;


import com.demo.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/FrogetPassword")
public class ForgetPasswordController {


    @Autowired
    private UserService userService;

    @GetMapping("/forgot-password")
    public String showForgotPasswordForm() {
        return "forgot-password";
    }

    @PostMapping("/forgot-password")
    public String handleForgotPassword(@RequestParam("email") String email, Model model) {
        // Implement the logic to handle password reset link
        boolean isEmailSent = userService.sendPasswordResetLink(email);
        
        if (isEmailSent) {
            model.addAttribute("message", "A password reset link has been sent to your email.");
            return "forgot-password";
        } else {
            model.addAttribute("error", "Failed to send reset link. Please check the email provided and try again.");
            return "forgot-password";
        }
    }
}
