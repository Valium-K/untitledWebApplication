Basic
=====
## static 폴더와 templates 폴더
* controller에서 mapping을 하지 않는다면 기본적으로 static 폴더로 빠진다.    
  controller에서 mapping을 했을 때 찾는 view가 없으면 static 폴더를 찾는게 아니다. 
  
thymeleaf
=========
## context-path 와 view 에서의 경로 매칭 
* 프로젝트: `server.servlet.context-path: /spring`    
  view: `<a th:href="@{/}">It goes to /spring</a>`
  
## `@Valid`의 대상 DTO의 이름은 addAttribute의 이름이 아닌 타입(camelCase)로 정의된다.
* 가령 아래의 예시처럼 MemberForm의 필드변수를 재사용해 'MemberForm loginForm' 으로 정의하면 에러가 난다.
```java
@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(Model model) {
        // MemberForm의 구성 필드변수를 재사용하기위해 Attribute이름만 바꿔서 view에 보냈다.
        // 여기까지는 잘 작동한다.
        model.addAttribute("loginForm", new MemberForm());
        return "login/login";
    }

    @PostMapping("/login")
    public String successLogin(@Valid MemberForm loginForm, BindingResult result) {

        // 그러나 에러처리로 인해 다시 view로 넘어갈 때는 Attribute이름이 아닌 MemberForm의 camelCase로 넘어간다.
        // 그래서 model.Attribute를 그냥 memberForm으로 넘기거나 DTO를 새로 만들어야한다. 
        if(result.hasErrors()) {
            // error
            return "login/login";
        }

        return "redirect:/";
    }
}
```