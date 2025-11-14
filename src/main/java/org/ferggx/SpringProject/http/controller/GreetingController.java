package org.ferggx.SpringProject.http.controller;

import jakarta.servlet.http.HttpServletRequest;

import org.ferggx.SpringProject.dto.UserDto;
import org.ferggx.SpringProject.dto.UserReadDto;
import org.ferggx.SpringProject.repository.CompanyRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller
public class GreetingController {


    @GetMapping("/hello/{id}")
    public ModelAndView hello(ModelAndView mv, CompanyRepository companyRepository,
                              HttpServletRequest request,
                              @RequestParam Integer age,
                              @RequestHeader String accept,
                              @CookieValue(value = "JSESSIONID") String jsessionId,
                              @PathVariable ("id") Integer id) {
        mv.setViewName("greeting/hello");
        mv.addObject("user", new UserReadDto (1L, "Artem"));

        return mv;
    }

    @RequestMapping(value = "/bye", method = RequestMethod.GET)
    public ModelAndView bye(ModelAndView mv, CompanyRepository companyRepository,
                            HttpServletRequest request) {
        mv.setViewName("greeting/bye");
        return mv;
    }
}