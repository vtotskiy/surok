package ru.korus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.korus.classes.DB2Class;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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

}