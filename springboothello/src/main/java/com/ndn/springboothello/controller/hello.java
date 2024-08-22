package com.ndn.springboothello.controller;

import com.ndn.springboothello.Email;
import com.ndn.springboothello.repositry.EmailRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class hello {
    @Autowired
    EmailRepositry emailRepositry;
    @GetMapping("/")
    public String hi() {
        return "home.html";
    }
    @GetMapping("/all-emails")
    public ModelAndView getAllEmails(){
        List<Email> list = emailRepositry.findAll();
        ModelAndView model = new ModelAndView("all-emails.html");
        model.addObject(    "list", list);
        return model;
    }

    @PostMapping("/save-email")
    public ModelAndView saveEmail(@RequestBody Map<String, String> body){
        String email = body.get("email");
        String name = body.get("name");
        int age = Integer.parseInt( body.get("age"));
        Object obj =  emailRepositry.save( new Email(name,email,age));
        System.out.println(obj);
        ModelAndView model = new ModelAndView("SAVED.html");
        return model;
    }
}
