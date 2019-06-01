/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lendle.courses.soa.finalexam;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

/**
 *
 * @author lendle
 */
@Service
public class JdbcTaskService implements TaskService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Task> getTasks() {
        List<Task> ret = jdbcTemplate.query("select * from Task", new TaskRowMapper());
        return ret;
    }

    @Override
    public List<Task> getTasksBySubject(String subject) {
        return jdbcTemplate.query("select * from Task where subject=?",
                new Object[]{subject}, new TaskRowMapper());
    }

    @Override
    public List<Task> getTasksByDate(String date) {
        return jdbcTemplate.query("select * from Task where dueDate=?",
                new Object[]{date}, new TaskRowMapper());
    }

    @Override
    public Task getTask(int id) {
        return jdbcTemplate.queryForObject("select * from Task where id=?",
                new Object[]{id},
                new TaskRowMapper());
    }

    @Override
    public void addTask(Task task) {
        jdbcTemplate.update("insert into Task (dueDate, subject, content) values (?,?,?)",
                task.getDueDate(), task.getSubject(), task.getContent());
    }

    @Override
    public void updateTask(Task task) {
        jdbcTemplate.update("update Task set dueDate=?, subject=?, content=? where id=?",
                task.getDueDate(), task.getSubject(), task.getContent(), task.getId());
    }

    @Override
    public void deleteTask(int id) {
        jdbcTemplate.update("delete from Task where id=?", id);
    }

    static class TaskRowMapper implements RowMapper<Task> {

        public Task mapRow(ResultSet rs, int i) throws SQLException {
            Task task = new Task();
            task.setId(rs.getInt("id"));
            task.setDueDate(rs.getString("dueDate"));
            task.setSubject(rs.getString("subject"));
            task.setContent(rs.getString("content"));
            return task;
        }
    }

}
