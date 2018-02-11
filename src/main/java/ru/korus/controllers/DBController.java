package ru.korus.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.korus.service.SpringDAOService;


@RestController
public class DBController {

    @RequestMapping("/db")
    public String getNameFromController(@RequestParam(value="id", required=false, defaultValue="") String name) {
        SpringDAOService nm = new SpringDAOService();
        return nm.getName();
    }
}