package ru.korus.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import ru.korus.classes.DB2Class;
import ru.korus.service.DB2Service;

import javax.sql.DataSource;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/db2_dml")
public class DB2ControllerDML {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public DB2ControllerDML(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @RequestMapping(value = "/ins", method = POST)
    @ResponseBody
        public DB2Class Insert(@RequestBody DB2Class obj){
           DB2Service aa = new DB2Service(this.jdbcTemplate);
           aa.ins(obj);
           return obj;
        }
    @RequestMapping(value = "/upd", method = POST)
    @ResponseBody
    public DB2Class Update(@RequestBody DB2Class obj){
        DB2Service aa = new DB2Service(this.jdbcTemplate);
        aa.upd(obj);
        return obj;
    }
    @RequestMapping(value = "/del", method = POST)
    @ResponseBody
    public List<DB2Class> Delete(Integer id){
        DB2Service aa = new DB2Service(this.jdbcTemplate);
        aa.del(id);

        return aa.getDBList(null);
    }

}