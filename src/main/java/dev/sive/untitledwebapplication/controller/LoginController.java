package dev.sive.untitledwebapplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.sql.ResultSet;
@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("memberForm", new MemberForm());
        return "login/login";
    }

    @PostMapping("/login")
    public String successLogin(@Valid MemberForm memberForm, BindingResult result) {

        if(result.hasErrors()) {
            return "login/login";
        }

        return "redirect:/";
    }
}
