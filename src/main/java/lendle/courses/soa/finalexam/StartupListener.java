/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lendle.courses.soa.finalexam;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

/**
 * Web application lifecycle listener.
 *
 * @author lendle
 */
public class StartupListener implements ServletContextListener {
    @Autowired
    private JdbcTemplate jdbcTemplate=null;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
        jdbcTemplate.update("create table task (id INTEGER IDENTITY PRIMARY KEY, dueDate varchar(255), subject varchar(255), content LONGVARCHAR);");
        jdbcTemplate.update("insert into task (duedate, subject, content) values (?,?,?)", 
                "20190502", "final exam", "prepare for the final exam");
        jdbcTemplate.update("insert into task (duedate, subject, content) values (?,?,?)", 
                "20190501", "say hello", "hello world!");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        
    }
}
