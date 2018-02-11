package ru.korus.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class SpringDao {


    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate = new JdbcTemplate();


    public int getRecordCount() {
        String sql = "select count(1) from tmp_jj_test";
        return jdbcTemplate.queryForObject(sql, new Object[]{}, Integer.class);
    }

    public String getRecordName(int id) {
        String sql = "select Name from tmp_jj_test where id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, String.class);
    }

    public DataSource getDataSource() {
        return dataSource;
    }
    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

}