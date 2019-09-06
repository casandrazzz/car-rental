package com.spring.rental.service;

import com.spring.rental.dao.EmployeeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.spring.rental.dto.EmployeeDto;
import com.spring.rental.dto.EmployeeInsertDto;
import com.spring.rental.domain.Employee;
import com.spring.rental.exceptions.employeeexceptions.*;
import com.spring.rental.transformer.employeetransformer.EmployeeEntityToEmployeeDtoInsertTransformer;
import com.spring.rental.transformer.employeetransformer.EmployeeEntityToEmployeeDtoTransformer;
import com.spring.rental.validation.emplservicevalidation.EmployeeValidation;
import org.apache.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.spring.rental.exceptions.employeeexceptions.Codes.NO_EMPLOYEE;

@Service
public class EmployeeServiceImpl implements EmployeeServiceInterface {

    @Autowired
    private EmployeeRepository employeeRepository;

    private static final Logger Log = Logger.getLogger(EmployeeServiceImpl.class);

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {

        this.employeeRepository = employeeRepository;
    }

   /* @Override
    public void addEmployee(String firstName, String lastName, int age, String phoneNumber, String emailAddress, String username, String password) {

    }*/

    @Override
    public void addEmployee(EmployeeInsertDto employeeInsertDto) throws InvalidEmployeeFirstAndLastName, InvalidEmployeePhoneNumber, InvalidEmployeePassword, InvalidEmployeeUsername, InvalidEmployeeAge, InvalidEmployeeEmailAddress {
        //String insertSql = "insert into employee values(firstName,lastName,age,phoneNumber,emailAddress,username,password)";

        EmployeeValidation.firstNameValidation(employeeInsertDto);
        EmployeeValidation.lastNameValidation(employeeInsertDto);
        EmployeeValidation.phoneNumberOfEmployeeValidation(employeeInsertDto);
        EmployeeValidation.employeePasswordValidation(employeeInsertDto);
        EmployeeValidation.usernameValidation(employeeInsertDto);
        EmployeeValidation.employeeAgeValidation(employeeInsertDto);
        EmployeeValidation.employeeEmailAddressValidation(employeeInsertDto);

        Employee employee = employeeRepository.findById(employeeInsertDto.getId()).get();

        //maybe a transformer

        employeeRepository.save(employee);




    }


   /* @Override
    public boolean deleteEmployee(String username) {

        String deleteSql = "delete from employee where username='" + username + "'";

        try {
            EmployeeValidation.usernameValidation(EmployeeInsertDto.builder().username(username).build());
        } catch (InvalidEmployeeUsername invalidEmployeeUsername) {
            invalidEmployeeUsername.printStackTrace();
        }



        jdbcTemplate.update(deleteSql); // TODO recheck for injection

        return true;

    }
*/
    @Override
    public List<EmployeeDto> getEmployees(String firstName, String lastName, int age, String phoneNumber, String emailAddress) throws NoEmployeeFound {


        List<EmployeeDto> availableEmployees = new ArrayList<>();

        List<Employee> employees = employeeRepository.getEmployees( firstName,  lastName,  age,  phoneNumber,  emailAddress);
        for (Employee employee : employees)
        {
            EmployeeDto employeeDto = new EmployeeDto();

            employeeDto.setFirstName(employee.getFirstName());
            employeeDto.setLastName(employee.getLastName());
            employeeDto.setAge(employee.getAge());
            employeeDto.setPhoneNumber(employee.getPhoneNumber());
            employeeDto.setEmailAddress(employeeDto.getEmailAddress());

            availableEmployees.add(employeeDto);
            if (availableEmployees.isEmpty()){
                throw new NoEmployeeFound("We didn't find you any employee at this moment", NO_EMPLOYEE);
            }


        }

        return availableEmployees;
            // This one is converted


    }

    @Override
    public List<EmployeeDto> delete(String firstName, String lastName, int age, String phoneNumber, String emailAddress, long pk) throws NoEmployeeFound {

        List<EmployeeDto> availableEmployees = new ArrayList<>();

        List<Employee> employees = employeeRepository.getEmployees( firstName,  lastName,  age,  phoneNumber,  emailAddress);
        for (Employee employee : employees)
        {
            EmployeeDto employeeDto = new EmployeeDto();

            employeeDto.setFirstName(employee.getFirstName());
            employeeDto.setLastName(employee.getLastName());
            employeeDto.setAge(employee.getAge());
            employeeDto.setPhoneNumber(employee.getPhoneNumber());
            employeeDto.setEmailAddress(employeeDto.getEmailAddress());

            availableEmployees.add(employeeDto);
            if (availableEmployees.isEmpty()){
                throw new NoEmployeeFound("We didn't find you any employee at this moment", NO_EMPLOYEE);
            }
        }
        availableEmployees = employeeRepository.deleteEmployee(pk);

        return  availableEmployees;
        // TODO Maybe it's good
    } }

  /*  @Override
    public EmployeeFindResults<EmployeeInsertDto> search(String firstName, String lastName, String username, String emailAddress) {
        return null;
    }*/

   /* @Override
    public List<EmployeeDto> deleteEmployee(long pk) {


        return null;
    }*/

 /*   @Override
    public EmployeeDto findEmployeeByFirstName(String firstName) {

        try {
            EmployeeValidation.firstNameValidation(EmployeeDto.builder().firstName(firstName).build());
        } catch (InvalidEmployeeFirstAndLastName invalidEmployeeFirstAndLastName) {
            invalidEmployeeFirstAndLastName.printStackTrace();
        }

        Employee employee = employeeRepository.findByFirstName(firstName);

        EmployeeDto employeeDto = new EmployeeDto();
        BeanUtils.copyProperties(employee, employeeDto);

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(employee, employeeDto);

        EmployeeDto employeeDtoTest = EmployeeEntityToEmployeeDtoTransformer.transform(employee);

        return employeeDtoTest;
    }

    @Override
    public EmployeeDto findEmployeeByLastName(String lastName) {
        try {
            EmployeeValidation.lastNameValidation(EmployeeDto.builder().lastName(lastName).build());
        } catch (InvalidEmployeeFirstAndLastName invalidEmployeeFirstAndLastName) {
            invalidEmployeeFirstAndLastName.printStackTrace();
        }

        Employee employee = employeeRepository.findByLastName(lastName);

        EmployeeDto employeeDto = new EmployeeDto();
        BeanUtils.copyProperties(employee, employeeDto);

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(employee, employeeDto);

        EmployeeDto employeeDtoTest = EmployeeEntityToEmployeeDtoTransformer.transform(employee);

        return employeeDtoTest;
    }

    @Override
    public EmployeeInsertDto findEmployeeByUsername(String username) {
        try {
            EmployeeValidation.usernameValidation(EmployeeInsertDto.builder().username(username).build());
        } catch (InvalidEmployeeUsername invalidEmployeeUsername) {
            invalidEmployeeUsername.printStackTrace();
        }
        Employee employee = employeeRepository.findByUsername(username);

        EmployeeInsertDto employeeInsertDto = new EmployeeInsertDto();
        BeanUtils.copyProperties(employee, employeeInsertDto);

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(employee, employeeInsertDto);

        EmployeeInsertDto employeeInsertDtoTest = EmployeeEntityToEmployeeDtoInsertTransformer.transform(employee);

        return employeeInsertDtoTest;

    }


    @Override
    public EmployeeDto findEmployeeByEmailAddress(String emailAddress) {
        try {
            EmployeeValidation.employeeEmailAddressValidation(EmployeeDto.builder().emailAddress(emailAddress).build());
        } catch (InvalidEmployeeEmailAddress invalidEmployeeEmailAddress) {
            invalidEmployeeEmailAddress.printStackTrace();
        }

        Employee employee = employeeRepository.findByEmailAdress(emailAddress);

        EmployeeDto employeeDto = new EmployeeDto();
        BeanUtils.copyProperties(employee, employeeDto);

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(employee, employeeDto);

        EmployeeDto employeeDtoTest = EmployeeEntityToEmployeeDtoTransformer.transform(employee);

        return employeeDtoTest;
    }
*/
  /*  @Override
    public EmployeeInsertDto updateEmployeeFirstName(String firstName) {
        String updateSql = "update employee set firstName =? where id = ?";

        try {
            EmployeeValidation.firstNameValidation(EmployeeInsertDto.builder().firstName(firstName).build());
        } catch (InvalidEmployeeFirstAndLastName invalidEmployeeFirstAndLastName) {
            invalidEmployeeFirstAndLastName.printStackTrace();
        }

        Connection connection = null;

        try (PreparedStatement ps = connection.prepareStatement(updateSql)) {
            ps.setString(1, "Johnny");
            ps.setInt(2, 5000);
            ps.executeUpdate();
            Log.info("Employee first name changed with succes");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        jdbcTemplate.update(updateSql);

        return null; //TODO recreate this function
    }

    @Override
    public EmployeeInsertDto updateEmployeeLastName(String lastName) {
        String updateSql = "update employee set lastName =? where id = ?";

        try {
            EmployeeValidation.lastNameValidation(EmployeeInsertDto.builder().lastName(lastName).build());
        } catch (InvalidEmployeeFirstAndLastName invalidEmployeeFirstAndLastName) {
            invalidEmployeeFirstAndLastName.printStackTrace();
        }
        //TODO Update after master
        Connection connection = null;
        try (PreparedStatement ps = connection.prepareStatement(updateSql)) {
            ps.setString(1, "John");
            ps.setInt(2, 6000);
            ps.executeUpdate();
            Log.info("Employee first name changed with succes");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        jdbcTemplate.update(updateSql);

        return null; //TODO recreate this function

    }

    @Override
    public EmployeeInsertDto updateEmployeeUsername(String userName) {

        String updateSql = "update employee set username =? where id = ?";

        try {
            EmployeeValidation.firstNameValidation(EmployeeInsertDto.builder().username(userName).build());
        } catch (InvalidEmployeeFirstAndLastName invalidEmployeeFirstAndLastName) {
            invalidEmployeeFirstAndLastName.printStackTrace();
        }
        Connection connection = null;
        try (PreparedStatement ps = connection.prepareStatement(updateSql)) {
            ps.setString(1, "alin");
            ps.setInt(2, 5500);
            ps.executeUpdate();
            Log.info("Employee username changed with succes");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        jdbcTemplate.update(updateSql);


        return null; //TODO recreate this function

    }

    @Override
    public EmployeeInsertDto updateEmployeeAge(Integer age) {

        String updateSql = "update employee set age =? where id = ?";

        try {
            EmployeeValidation.employeeAgeValidation(EmployeeInsertDto.builder().age(age).build());
        } catch (InvalidEmployeeAge invalidEmployeeAge) {
            invalidEmployeeAge.printStackTrace();
        }

        Connection connection = null;
        try (PreparedStatement ps = connection.prepareStatement(updateSql)) {
              ps.setInt(1,25);
              ps.setInt(2,5400);
              ps.executeUpdate();
              Log.info("Employee age changed with succes");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        jdbcTemplate.update(updateSql);

        return null; //TODO recreate this function
    }

    @Override
    public EmployeeInsertDto updateEmployeePassword(String password) {
        String updateSql = "update employee set password =? where id = ?";

        try {
            EmployeeValidation.employeePasswordValidation(EmployeeInsertDto.builder().password(password).build());
        } catch (InvalidEmployeePassword invalidEmployeePassword) {
            invalidEmployeePassword.printStackTrace();
        }
        Connection connection= null;
        try (PreparedStatement ps = connection.prepareStatement(updateSql)){
            ps.setString(1,"Abcd#1");
            ps.setInt(2,90);
            ps.executeUpdate();
            Log.info("Employee password changed with succes");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        jdbcTemplate.update(updateSql);

        return null; //TODO recreate this function
    }

    @Override
    public EmployeeInsertDto updateEmployeeEmailAddress(String emailAddress) {
        String updateSql = "update employee set emailAddress =? where id = ?";

        try {
            EmployeeValidation.employeeEmailAddressValidation(EmployeeInsertDto.builder().emailAddress(emailAddress).build());
        } catch (InvalidEmployeeEmailAddress invalidEmployeeEmailAddress) {
            invalidEmployeeEmailAddress.printStackTrace();
        }
        Connection connection= null;
        try (PreparedStatement ps = connection.prepareStatement(updateSql)){
            ps.setString(1,"alin@yahoo.com");
            ps.setInt(2,91);
            ps.executeUpdate();
            Log.info("Employee email address changed with succes");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        jdbcTemplate.update(updateSql);
        return null; //TODO recreate this function
    }

    @Override
    public EmployeeInsertDto updateEmployeePhoneNumber(String phoneNumber) {
        String updateSql = "update employee set phoneNumber =? where id = ?";

        try {
            EmployeeValidation.phoneNumberOfEmployeeValidation(EmployeeInsertDto.builder().phoneNumber(phoneNumber).build());
        } catch (InvalidEmployeePhoneNumber invalidEmployeePhoneNumber) {
            invalidEmployeePhoneNumber.printStackTrace();
        }
        Connection connection= null;
        try (PreparedStatement ps = connection.prepareStatement(updateSql)){
            ps.setString(1,"023456610");
            ps.setInt(2,60);
            ps.executeUpdate();
            Log.info("Employee phone number changed with succes");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        jdbcTemplate.update(updateSql);
        return null; //TODO recreate this function
    }
//Todo new functions on contrloller and on dao

}
*/