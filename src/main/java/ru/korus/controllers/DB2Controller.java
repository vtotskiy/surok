package ru.korus.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.korus.classes.DB2Class;
import ru.korus.service.DB2Service;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class DB2Controller {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public DB2Controller(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @RequestMapping("/db2")
    public List<DB2Class> getDB2Service(@RequestParam(value="id", required=false, defaultValue="") String id) {
        DB2Service aa = new DB2Service(this.jdbcTemplate);
         return aa.getDBList(id);
    }
    @RequestMapping("/db2_1")
    public List<DB2Class> getDB2ServiceObj(@RequestParam(value="id", required=true, defaultValue="0") String id) {
        DB2Service aa = new DB2Service(this.jdbcTemplate);
        return aa.getDBObj(id);
    }
    @RequestMapping("/db2_id")
    public Integer getDB2ServiceId(@RequestParam(value="name", required=true, defaultValue="") String name) {
        DB2Service aa = new DB2Service(this.jdbcTemplate);
        return aa.getDBidByName(name);
    }

}