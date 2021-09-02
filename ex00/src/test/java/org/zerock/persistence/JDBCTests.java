package org.zerock.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class JDBCTests {

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		}catch(Exception e){
			e.printStackTrace();
			
		}
	}
		
		@Test
		public void testConnection() {
			
			try(Connection con =
					DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:orcl",
					"c##book_ex",
					"book_ex")){
				
				log.info(con);
			}catch(Exception e) {
				
				fail(e.getMessage());
			}
							
		}
		
	}

