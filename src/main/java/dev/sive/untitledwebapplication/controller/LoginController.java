package dev.sive.untitledwebapplication.controller;

import dev.sive.untitledwebapplication.domain.Member;
import dev.sive.untitledwebapplication.repository.MemberH2Repository;
import dev.sive.untitledwebapplication.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.sql.ResultSet;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final MemberService memberService;

    @GetMapping("/login")
    public String login(Model model, HttpServletRequest request) {

        if(request.getSession(false) != null) return "redirect:/";

        model.addAttribute("memberForm", new MemberForm());
        return "login/login";
    }

    @PostMapping("/login")
    public String successLogin(@Valid MemberForm memberForm, BindingResult result, HttpServletRequest request) {

        if(result.hasErrors()) {
            return "login/login";
        }

        HttpSession session = request.getSession();

        Member foundMember = memberService.findOne(memberForm.getName());

        String name = "status: logged in";
        session.setAttribute("user" + String.valueOf(foundMember.getId()), foundMember);

        return "redirect:/";
    }
}
