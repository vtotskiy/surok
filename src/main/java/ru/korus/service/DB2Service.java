package ru.korus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.*;
import org.springframework.stereotype.Component;
import ru.korus.classes.DB2Class;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class DB2Service {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public DB2Service(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

/*Для примера ровмаппер не вынесен в отдельный класс*/
    public List<DB2Class> getDBList(String id) {

        String sql = "select ID, UP_ID, Name from tmp_jj_test where id = nvl(?, id)";

        List<DB2Class> db2 = this.jdbcTemplate.query(
                sql,
                new Object[]{id},
                new RowMapper<DB2Class>() {
                    public DB2Class mapRow(ResultSet rs, int rowNum) throws SQLException {
                        DB2Class single = new DB2Class();
                        single.setId(rs.getString("id"));
                        single.setUp_ID(rs.getString("up_id"));
                        single.setName(rs.getString("name"));
                        return single;
                    }
                });
        return db2;
     }


    /*Для примера ровмаппер вынесен в отдельный класс*/
    public List<DB2Class> getDBObj(String id) {

        String sql1 = "select ID, UP_ID, Name from tmp_jj_test j where j.id = ?";

        List<DB2Class> db2_1 = this.jdbcTemplate.query(
                sql1,
                new Object[]{id},
                new DB2Mapper());
        return db2_1;
    }

    /*класс ровмапера*/
    private static final class DB2Mapper implements RowMapper<DB2Class> {

        public DB2Class mapRow(ResultSet rs, int rowNum) throws SQLException {
            DB2Class single = new DB2Class();
            single.setId(rs.getString("id"));
            single.setUp_ID(rs.getString("up_id"));
            single.setName(rs.getString("name"));
            return single;
        }
    }



    public Integer getDBidByName(String name) {
        String sql = "select ID from tmp_jj_test where name = ?";
        return this.jdbcTemplate.queryForObject(sql, new Object[]{name},Integer.class);
    }

    public void ins(DB2Class obj) {
        String id = obj.getId();
        String up_id = obj.getUp_ID();
        String name = obj.getName();
        String sql = "insert into tmp_jj_test (id, up_id, name) values (?, ?, ?)";
        this.jdbcTemplate.update(sql, id, up_id, name);

    }

    public void upd(DB2Class obj) {
        String id = obj.getId();
        String up_id = obj.getUp_ID();
        String name = obj.getName();
        String sql = "update tmp_jj_test set up_id = ?, name = ? where id = ?";
        this.jdbcTemplate.update(sql, up_id, name, id);

    }

    public void del(Integer id) {
        String sql = "delete from tmp_jj_test where id = ?";
        this.jdbcTemplate.update(sql, id);
    }

}