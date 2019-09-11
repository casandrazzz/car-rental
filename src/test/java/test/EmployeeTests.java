package test;

import com.spring.rental.dao.EmployeeRepository;
import com.spring.rental.domain.Employee;
import com.spring.rental.dto.EmployeeInsertDto;
import com.spring.rental.exceptions.ValidationException;
import com.spring.rental.exceptions.employeeexceptions.*;
import com.spring.rental.service.EmployeeServiceImpl;
import com.spring.rental.validation.emplservicevalidation.EmployeeValidation;
import org.junit.After;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(locations = { "classpath:beans.xml" })
public abstract class EmployeeTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    abstract EmployeeServiceImpl getEmployeeService();


    @After
    public void reset() throws NoEmployeeFound {
        List<Employee> employees = new ArrayList<>(getEmployeeService().getAllEmployees());

        for (Employee employee : employees){
            getEmployeeService().deleteEmployee(employee.getPk());
        }

    }
    @Test
    public  void test_empty() throws NoEmployeeFound {
        List<Employee> employees = getEmployeeService().getAllEmployees();
        Assert.assertTrue(employees.isEmpty());
    }
    @Test
    public  void test_add_no_first_name() throws InvalidEmployeeUsername, InvalidEmployeeAge, InvalidEmployeeEmailAddress, InvalidEmployeeFirstAndLastName, InvalidEmployeePassword, InvalidEmployeePhoneNumber {     EmployeeInsertDto e = new EmployeeInsertDto();
          e.setLastName("viorel");
          e.setAge(23);
          e.setPhoneNumber("0264258810");
          e.setUsername("admin");
          e.setEmailAddress("ceva@yahoo.com");
          e.setPassword("Par0laa");
          getEmployeeService().addEmployee(e);
    }
    @Test
    public  void test_add_no_last_name() throws InvalidEmployeeUsername, InvalidEmployeeAge, InvalidEmployeeEmailAddress, InvalidEmployeeFirstAndLastName, InvalidEmployeePassword, InvalidEmployeePhoneNumber {     EmployeeInsertDto e = new EmployeeInsertDto();
        e.setFirstName("viorel");
        e.setAge(23);
        e.setPhoneNumber("0264258810");
        e.setUsername("admin");
        e.setEmailAddress("ceva@yahoo.com");
        e.setPassword("Par0laa");
        getEmployeeService().addEmployee(e);
    }
    @Test
    public  void test_add_no_age() throws InvalidEmployeeUsername, InvalidEmployeeAge, InvalidEmployeeEmailAddress, InvalidEmployeeFirstAndLastName, InvalidEmployeePassword, InvalidEmployeePhoneNumber {     EmployeeInsertDto e = new EmployeeInsertDto();
        e.setFirstName("ghita");
        e.setLastName("viorel");
        e.setPhoneNumber("0264258810");
        e.setUsername("admin");
        e.setEmailAddress("ceva@yahoo.com");
        e.setPassword("Par0laa");
        getEmployeeService().addEmployee(e);
    }
    @Test
    public  void test_add_no_number() throws InvalidEmployeeUsername, InvalidEmployeeAge, InvalidEmployeeEmailAddress, InvalidEmployeeFirstAndLastName, InvalidEmployeePassword, InvalidEmployeePhoneNumber {     EmployeeInsertDto e = new EmployeeInsertDto();
        e.setFirstName("ghita");
        e.setLastName("viorel");
        e.setAge(23);
        e.setUsername("admin");
        e.setEmailAddress("ceva@yahoo.com");
        e.setPassword("Par0laa");
        getEmployeeService().addEmployee(e);
    }
    @Test
    public  void test_add_no_username() throws InvalidEmployeeUsername, InvalidEmployeeAge, InvalidEmployeeEmailAddress, InvalidEmployeeFirstAndLastName, InvalidEmployeePassword, InvalidEmployeePhoneNumber {     EmployeeInsertDto e = new EmployeeInsertDto();
        e.setFirstName("ghita");
        e.setLastName("viorel");
        e.setAge(23);
        e.setPhoneNumber("0264258810");
        e.setEmailAddress("ceva@yahoo.com");
        e.setPassword("Par0laa");
        getEmployeeService().addEmployee(e);
    }
    @Test
    public  void test_add_no_email() throws InvalidEmployeeUsername, InvalidEmployeeAge, InvalidEmployeeEmailAddress, InvalidEmployeeFirstAndLastName, InvalidEmployeePassword, InvalidEmployeePhoneNumber {     EmployeeInsertDto e = new EmployeeInsertDto();
        e.setFirstName("ghita");
        e.setLastName("viorel");
        e.setAge(23);
        e.setUsername("admin");
        e.setPhoneNumber("0264258810");
        e.setPassword("Par0laa");
        getEmployeeService().addEmployee(e);
    }
    @Test
    public  void test_add_no_password() throws InvalidEmployeeUsername, InvalidEmployeeAge, InvalidEmployeeEmailAddress, InvalidEmployeeFirstAndLastName, InvalidEmployeePassword, InvalidEmployeePhoneNumber {     EmployeeInsertDto e = new EmployeeInsertDto();
        e.setFirstName("ghita");
        e.setLastName("viorel");
        e.setAge(23);
        e.setUsername("admin");
        e.setPhoneNumber("0264258810");
        e.setEmailAddress("ceva@yahoo.com");
        getEmployeeService().addEmployee(e);
    }
    @Test
    public  void test_add_invalid_firstname() throws InvalidEmployeeUsername, InvalidEmployeeAge, InvalidEmployeeEmailAddress, InvalidEmployeeFirstAndLastName, InvalidEmployeePassword, InvalidEmployeePhoneNumber {     EmployeeInsertDto e = new EmployeeInsertDto();
        e.setFirstName("ghita123");
        e.setLastName("viorel");
        e.setAge(23);
        e.setUsername("admin");
        e.setPhoneNumber("0264258810");
        e.setEmailAddress("ceva@yahoo.com");
        e.setPassword("Par0laa");
        getEmployeeService().addEmployee(e);
    }
    @Test
    public  void test_add_invalid_lastname() throws InvalidEmployeeUsername, InvalidEmployeeAge, InvalidEmployeeEmailAddress, InvalidEmployeeFirstAndLastName, InvalidEmployeePassword, InvalidEmployeePhoneNumber {     EmployeeInsertDto e = new EmployeeInsertDto();
        e.setFirstName("ghita");
        e.setLastName("viorel123");
        e.setAge(23);
        e.setUsername("admin");
        e.setPhoneNumber("0264258810");
        e.setEmailAddress("ceva@yahoo.com");
        e.setPassword("Par0laa");
        getEmployeeService().addEmployee(e);
    }
    @Test
    public  void test_add_overage() throws InvalidEmployeeUsername, InvalidEmployeeAge, InvalidEmployeeEmailAddress, InvalidEmployeeFirstAndLastName, InvalidEmployeePassword, InvalidEmployeePhoneNumber {     EmployeeInsertDto e = new EmployeeInsertDto();
        e.setFirstName("ghita123");
        e.setLastName("viorel");
        e.setAge(60);
        e.setUsername("admin");
        e.setPhoneNumber("0264258810");
        e.setEmailAddress("ceva@yahoo.com");
        e.setPassword("Par0laa");
        getEmployeeService().addEmployee(e);
    }
    @Test
    public  void test_add_underage() throws InvalidEmployeeUsername, InvalidEmployeeAge, InvalidEmployeeEmailAddress, InvalidEmployeeFirstAndLastName, InvalidEmployeePassword, InvalidEmployeePhoneNumber {     EmployeeInsertDto e = new EmployeeInsertDto();
        e.setFirstName("ghita123");
        e.setLastName("viorel");
        e.setAge(10);
        e.setUsername("admin");
        e.setPhoneNumber("0264258810");
        e.setEmailAddress("ceva@yahoo.com");
        e.setPassword("Par0laa");
        getEmployeeService().addEmployee(e);
    }
    @Test
    public  void test_add_invalid_username() throws InvalidEmployeeUsername, InvalidEmployeeAge, InvalidEmployeeEmailAddress, InvalidEmployeeFirstAndLastName, InvalidEmployeePassword, InvalidEmployeePhoneNumber {     EmployeeInsertDto e = new EmployeeInsertDto();
        e.setFirstName("ghita123");
        e.setLastName("viorel");
        e.setAge(60);
        e.setUsername("admin123");
        e.setPhoneNumber("0264258810");
        e.setEmailAddress("ceva@yahoo.com");
        e.setPassword("Par0laa");
        getEmployeeService().addEmployee(e);
    }
    @Test
    public  void test_add_invalid_username_toLong() throws InvalidEmployeeUsername, InvalidEmployeeAge, InvalidEmployeeEmailAddress, InvalidEmployeeFirstAndLastName, InvalidEmployeePassword, InvalidEmployeePhoneNumber {     EmployeeInsertDto e = new EmployeeInsertDto();
        e.setFirstName("ghita123");
        e.setLastName("viorel");
        e.setAge(30);
        e.setUsername("viorelacasandrei");
        e.setPhoneNumber("0264258810");
        e.setEmailAddress("ceva@yahoo.com");
        e.setPassword("Par0laa");
        getEmployeeService().addEmployee(e);
    }
    @Test
    public  void test_add_invalid_phoneNumber() throws InvalidEmployeeUsername, InvalidEmployeeAge, InvalidEmployeeEmailAddress, InvalidEmployeeFirstAndLastName, InvalidEmployeePassword, InvalidEmployeePhoneNumber {     EmployeeInsertDto e = new EmployeeInsertDto();
        e.setFirstName("ghita");
        e.setLastName("viorel");
        e.setAge(23);
        e.setUsername("admin");
        e.setPhoneNumber("02642g8101");
        e.setEmailAddress("ceva@yahoo.com");
        e.setPassword("Par0laa");
        getEmployeeService().addEmployee(e);
    }
    @Test
    public  void test_add_phoneNumber_tooLong() throws InvalidEmployeeUsername, InvalidEmployeeAge, InvalidEmployeeEmailAddress, InvalidEmployeeFirstAndLastName, InvalidEmployeePassword, InvalidEmployeePhoneNumber {     EmployeeInsertDto e = new EmployeeInsertDto();
        e.setFirstName("ghita");
        e.setLastName("viorel");
        e.setAge(23);
        e.setUsername("admin");
        e.setPhoneNumber("0264258810321");
        e.setEmailAddress("ceva@yahoo.com");
        e.setPassword("Par0laa");
        getEmployeeService().addEmployee(e);
    }
    @Test
    public  void test_add_invalid_tooShort() throws InvalidEmployeeUsername, InvalidEmployeeAge, InvalidEmployeeEmailAddress, InvalidEmployeeFirstAndLastName, InvalidEmployeePassword, InvalidEmployeePhoneNumber {     EmployeeInsertDto e = new EmployeeInsertDto();
        e.setFirstName("ghita");
        e.setLastName("viorel");
        e.setAge(23);
        e.setUsername("admin");
        e.setPhoneNumber("026410");
        e.setEmailAddress("ceva@yahoo.com");
        e.setPassword("Par0laa");
        getEmployeeService().addEmployee(e);
    }
    @Test
    public  void test_add_invalid_email() throws InvalidEmployeeUsername, InvalidEmployeeAge, InvalidEmployeeEmailAddress, InvalidEmployeeFirstAndLastName, InvalidEmployeePassword, InvalidEmployeePhoneNumber {     EmployeeInsertDto e = new EmployeeInsertDto();
        e.setFirstName("ghita");
        e.setLastName("viorel");
        e.setAge(23);
        e.setUsername("admin");
        e.setPhoneNumber("0264258810");
        e.setEmailAddress("cevayahoo.com");
        e.setPassword("Par0laa");
        getEmployeeService().addEmployee(e);
    }
    @Test
    public  void test_add_password_tooshort() throws InvalidEmployeeUsername, InvalidEmployeeAge, InvalidEmployeeEmailAddress, InvalidEmployeeFirstAndLastName, InvalidEmployeePassword, InvalidEmployeePhoneNumber {     EmployeeInsertDto e = new EmployeeInsertDto();
        e.setFirstName("ghita");
        e.setLastName("viorel");
        e.setAge(23);
        e.setUsername("admin");
        e.setPhoneNumber("0264258810");
        e.setEmailAddress("ceva@yahoo.com");
        e.setPassword("P0r3");
        getEmployeeService().addEmployee(e);
    }
    @Test
    public  void test_add_password_tooLong() throws InvalidEmployeeUsername, InvalidEmployeeAge, InvalidEmployeeEmailAddress, InvalidEmployeeFirstAndLastName, InvalidEmployeePassword, InvalidEmployeePhoneNumber {     EmployeeInsertDto e = new EmployeeInsertDto();
        e.setFirstName("ghita");
        e.setLastName("viorel");
        e.setAge(23);
        e.setUsername("admin");
        e.setPhoneNumber("0264258810");
        e.setEmailAddress("ceva@yahoo.com");
        e.setPassword("Par0laasdvsddsd334");
        getEmployeeService().addEmployee(e);
    }
    @Test
    public  void test_add_password_tooSimple() throws InvalidEmployeeUsername, InvalidEmployeeAge, InvalidEmployeeEmailAddress, InvalidEmployeeFirstAndLastName, InvalidEmployeePassword, InvalidEmployeePhoneNumber {     EmployeeInsertDto e = new EmployeeInsertDto();
        e.setFirstName("ghita");
        e.setLastName("viorel");
        e.setAge(23);
        e.setUsername("admin");
        e.setPhoneNumber("0264258810");
        e.setEmailAddress("ceva@yahoo.com");
        e.setPassword("parolae");
        getEmployeeService().addEmployee(e);
    }
    // rest of the methods with postman


















}
