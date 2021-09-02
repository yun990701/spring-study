package org.zerock.sample;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class) //현재 테스트 코드로 스프링 실행
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml") // 스프링에 빈객체 생성

@Log4j
public class SampleTests {
	
	@Setter( onMethod_ = @Autowired)
	private Restaurant restaurant;
	
	@Test
	public void testExist() {
		
		assertNotNull(restaurant);
		
		log.info(restaurant);
		log.info("--------------------------------");
		log.info(restaurant.getChef());
		
	}
	
	

}
