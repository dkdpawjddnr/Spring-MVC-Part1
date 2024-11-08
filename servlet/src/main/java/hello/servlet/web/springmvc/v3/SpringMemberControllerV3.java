package hello.servlet.web.springmvc.v3;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/springmvc/v3/members")
public class SpringMemberControllerV3 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    //애노테이션 기반의 컨트롤러는 문자를 반환해도 얘가 view이름인줄 알고 프로세스가 진행된다.
    @GetMapping("/new-form")
    public String newForm() {
        return "new-form";
    }

    @PostMapping("save")
    public String save(
            @RequestParam("username") String username, // 요청 파라미터 받고,
            @RequestParam("age") int age, // 타입 변환도 스프링이 알아서 해줌
            Model model) {

        Member member = new Member(username, age);
        memberRepository.save(member);

        // 모델에 담고
        model.addAttribute("member", member);
        return "save-result"; // 뷰 이름 반환
    }

    @GetMapping
    public String members(Model model){

        List<Member> members = memberRepository.findAll();

        model.addAttribute("members", members);
        return "members";
    }
}

