package ru.korus.service;

import org.springframework.stereotype.Service;
import ru.korus.model.StackOverflowWebSite;

import java.util.ArrayList;
import java.util.List;


@Service
public class TestService {
    private static List<StackOverflowWebSite> items =  new ArrayList(); //Так не делается
    static{
        items.add(new StackOverflowWebSite("1","Наиемнвоание","Описанеи"));
        items.add(new StackOverflowWebSite("2","гоша","Нет описания"));
    }
    public List<StackOverflowWebSite> getList() {
        return  items;
    }
}
