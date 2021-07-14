package dev.sive.untitledwebapplication.controller;

import dev.sive.untitledwebapplication.domain.Member;
import dev.sive.untitledwebapplication.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/members/new")
    public String createForm(Model model) {
        MemberForm memberForm = new MemberForm();
        model.addAttribute("memberForm", memberForm);

        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm memberForm) {
        Member member = Member.createMember(
                memberForm.getName(),
                memberForm.getCity(),
                memberForm.getStreet(),
                memberForm.getZipcode());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members/list")
    public String list(Model model) {
        List<Member> members = memberService.findAll();
        model.addAttribute("members", members);
        return "members/printAllMembers";
    }
}
