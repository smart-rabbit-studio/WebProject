package hellospring.mavenproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/web")
public class MainController {
    @GetMapping("/main/{name}")
    public String mainPage(@PathVariable String name, Model model) {
        model.addAttribute("name", name);
        return "main";
    }

    @GetMapping("/member")
    public String memberPage(Model model) {
        return "member";
    }
}
