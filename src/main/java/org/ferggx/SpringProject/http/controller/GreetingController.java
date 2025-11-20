package org.ferggx.SpringProject.http.controller;

import jakarta.servlet.http.HttpServletRequest;

import org.ferggx.SpringProject.dto.UserDto;
import org.ferggx.SpringProject.dto.UserReadDto;
import org.ferggx.SpringProject.entities.Role;
import org.ferggx.SpringProject.repository.CompanyRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller
@SessionAttributes({"user"})
@RequestMapping("/api/v1")
public class GreetingController {


    @ModelAttribute("roles")
    public List<Role> getRoles  () {
        return Arrays.asList(Role.values());
    }


    @GetMapping("/hello")
    public String hello(Model model,
                        UserReadDto userReadDto) {
        model.addAttribute("user", userReadDto);
        return "greeting/hello";
    }


    @GetMapping("/hello/{id}")
    public String hello(@RequestParam Integer age,
                              @RequestHeader String accept,
                              @CookieValue(value = "JSESSIONID") String jsessionId,
                              @PathVariable ("id") Integer id,
                        Model model, UserReadDto userReadDto) {
        model.addAttribute( "user", userReadDto);

        return "greeting/hello";
    }

    @GetMapping("/bye")
    public String bye(@SessionAttribute("user") UserReadDto user) {
        return "greeting/bye";
    }
}