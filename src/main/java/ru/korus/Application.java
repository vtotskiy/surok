package ru.korus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
    @RequestMapping("/admin") //Привязываем урл к шаблону в папке templates
    public String admin() {
        return "/admin";
    }

}
