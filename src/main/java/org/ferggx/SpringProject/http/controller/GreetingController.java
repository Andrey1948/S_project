package org.ferggx.SpringProject.http.controller;

import jakarta.servlet.http.HttpServletRequest;

import org.ferggx.SpringProject.repository.CompanyRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller
public class GreetingController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
//    @GetMapping("/hello")
    public ModelAndView hello(ModelAndView mv, CompanyRepository companyRepository,
                       HttpServletRequest request)
//                       @RequestParam Integer age,
//                       @RequestHeader String accept,
//                       @CookieValue ("JSESSIONID") String jsessionId,
//                       @PathVariable("Id") Integer id)
                       {
        mv.setViewName("greeting/hello");
        return mv;
    }

}
