package com.xpc.fit.controller;

import com.xpc.fit.entity.Person;
import com.xpc.fit.result.Result;
import com.xpc.fit.result.SuccessResult;
import com.xpc.fit.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 收集个人信息
 */
@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService personService;

    @RequestMapping("/collect")
    public Result collect(Person person, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        Map<String, Integer> map;
        map = personService.save(person);
        return new SuccessResult(map);
    }
}
