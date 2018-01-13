package ru.korus.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.korus.model.StackOverflowWebSite;
import ru.korus.service.TestService;
import java.util.List;

@RestController
@RequestMapping("/api/getlist")
public class MainController {
    @Autowired
    private TestService testService;

    @RequestMapping
    public List<StackOverflowWebSite> getListOfProviders(){
        //Тут надо вызывать сервис
        return testService.getList();

    }
}
