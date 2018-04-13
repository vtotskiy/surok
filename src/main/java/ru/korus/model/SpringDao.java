package ru.korus.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class SpringDao {


    private JdbcTemplate jdbcTemplate;

    @Autowired
    public SpringDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int getRecordCount() {
        String sql = "select count(1) from tmp_jj_test";
        return jdbcTemplate.queryForObject(sql, new Object[]{}, Integer.class);
    }

    public String getRecordName(int id) {
        String sql = "select Name from tmp_jj_test where id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, String.class);
    }

}