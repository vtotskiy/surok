package ru.korus.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.korus.service.SpringDAOService;


@RestController
public class DBController {
    private SpringDAOService springDAOService;

    @Autowired
    public DBController(SpringDAOService springDAOService) {
        this.springDAOService = springDAOService;
    }

    @RequestMapping("/db")
    public String getNameFromController(@RequestParam(value="id", required=false, defaultValue="") String name) {
        return springDAOService.getName();
    }
}