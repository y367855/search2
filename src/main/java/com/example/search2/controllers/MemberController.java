package com.example.search2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.search2.domains.Member;
import com.example.search2.mappers.MemberMapper;

@Controller
public class MemberController {
	private final MemberMapper memberMapper;

	@Autowired
	public MemberController(MemberMapper memberMapper) {
		this.memberMapper = memberMapper;
	}

	@GetMapping("/")
	public String index(Model model) {
		List<Member>members = memberMapper.all();
		model.addAttribute("members",members);
		return "index";
	}

	@GetMapping("/create")
    public String showCreateForm() {
        return "create";
    }

    @PostMapping("/create")
    public String create(@RequestParam("member_name") String memberName) {
        Member member = new Member(memberName);
        memberMapper.add(member);
        return "redirect:/";
    }

}
