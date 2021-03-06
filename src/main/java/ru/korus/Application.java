package ru.korus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@SpringBootApplication //Определяем точку входа в приложение
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    @RequestMapping("/") //Основной разбор урлов идет в контроллерах
    public String showHelloWorld(){
        return "hello-world";
    }
    @RequestMapping("/admin") //Привязываем урл к шаблону в папке templates. тут используется fremaker https://freemarker.apache.org/docs/
    public String admin() {
        return "/admin";
    }
    @RequestMapping("/db2/ins")
    public String showIns(){
        return "db2/ins";
    }
    @RequestMapping("/db2/del")
    public String showDel(){
        return "db2/del";
    }

}
