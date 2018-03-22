package aayush.neupane.me.web.test.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ActiveProfiles("dev")
@ContextConfiguration(locations= { 
		"classpath:aayush/neupane/me/web/config/dao-context.xml",
		"classpath:aayush/neupane/me/web/config/security-context.xml"
		 })

@RunWith(SpringJUnit4ClassRunner.class)
public class UserDaoTests {
	
	@Test
	public void testCreateuser() {
		assertEquals("Dummy test", 1, 1);
	}

}
