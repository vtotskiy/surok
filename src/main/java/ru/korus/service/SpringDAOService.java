package ru.korus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import ru.korus.model.SpringDao;

import javax.sql.DataSource;


@Service
public class SpringDAOService {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public SpringDAOService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String getName(){
        SpringDao sd = new SpringDao(this.jdbcTemplate);
        return sd.getRecordName(1);
    }

}
