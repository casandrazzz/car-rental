package test;

import com.spring.rental.service.EmployeeServiceImpl;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfiguration.class})
class EmployeeTestsConfig extends EmployeeTests {

	@Autowired
	private EmployeeServiceImpl service;
	


	@Override
	protected EmployeeServiceImpl getEmployeeService() {
		return service;
	}
	
	
	
}
