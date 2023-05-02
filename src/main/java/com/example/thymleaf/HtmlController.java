package com.example.thymleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HtmlController {

    List<String> pList = new ArrayList<>();

    @RequestMapping("greeting")
    public String formGreeting(){
        return "formGreeting.html";
    }

    @PostMapping("formGreetingReceival")
    public String formGreetingReceiver(@RequestParam String fname,
                                       @RequestParam String lname, Model model){
        model.addAttribute("fname", fname);
        model.addAttribute("lname", lname);
        pList.add(fname+" "+lname);
        return "formGreetingThanks.html";

    }
}
