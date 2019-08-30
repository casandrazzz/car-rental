package com.spring.rental.controller;

import com.spring.rental.domain.Employee;
import com.spring.rental.dto.EmployeeDto;
import com.spring.rental.dto.EmployeeInsertDto;
import com.spring.rental.exceptions.employeeexceptions.*;
import com.spring.rental.service.EmployeeServiceInterface;
import com.spring.rental.service.EmployeeServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EmployeeController {

    private static final Logger Log = Logger.getLogger(EmployeeServiceImpl.class);

    @Autowired
    private EmployeeServiceInterface employeeServiceInterface;






    @PostMapping(value = "/employees")
    public ModelAndView addEmployee(@ModelAttribute EmployeeInsertDto employeeInsertDto) throws InvalidEmployeeUsername, InvalidEmployeeAge,
            InvalidEmployeeEmailAddress, InvalidEmployeeFirstAndLastName, InvalidEmployeePassword, InvalidEmployeePhoneNumber {

        try{
            employeeServiceInterface.addEmployee(employeeInsertDto);

            Log.info(" EmployeeServiceInterface inserted with success");
        } catch (InvalidEmployeeUsername invalidEmployeeUsername) {
           Log.error(invalidEmployeeUsername.getLocalizedMessage() + ":" + invalidEmployeeUsername.getCode());

        } catch (InvalidEmployeeEmailAddress invalidEmployeeEmailAddress) {
           Log.error(invalidEmployeeEmailAddress.getLocalizedMessage() + ":" + invalidEmployeeEmailAddress.getCode());

        } catch (InvalidEmployeePhoneNumber invalidEmployeePhoneNumber) {
            Log.error(invalidEmployeePhoneNumber.getLocalizedMessage() + ":" + invalidEmployeePhoneNumber.getCode());

        } catch (InvalidEmployeeAge invalidEmployeeAge) {
           Log.error(invalidEmployeeAge.getLocalizedMessage() + ":" + invalidEmployeeAge.getCode() );

        } catch (InvalidEmployeePassword invalidEmployeePassword) {
          Log.error(invalidEmployeePassword.getLocalizedMessage() + ":" + invalidEmployeePassword.getCode());

        } catch (InvalidEmployeeFirstAndLastName invalidEmployeeFirstAndLastName) {
          Log.error(invalidEmployeeFirstAndLastName.getLocalizedMessage() + ":" + invalidEmployeeFirstAndLastName.getCode());
        }
        employeeServiceInterface.addEmployee(employeeInsertDto);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");

        return modelAndView;
        // good
    }

    /**
     *
     * @param username employeeServiceInterface's  username,
     * the param we choose for this case to delete an employeeServiceInterface
     * @return modelAndView after the delete happened or not.
     */
   /* @PostMapping(value = "/delete")
    public ModelAndView deleteEmployee(@RequestParam("username") String username) throws InvalidEmployeeUsername {
        if(employeeServiceInterface.deleteEmployee(username))
        {
            Log.info("Employee deleted");
        } else {
            Log.error("Employee could not be deleted");
        }

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");

        return modelAndView;

    }*/
/*
    @PostMapping(value = "/update")
    public  ModelAndView updateEmployeeFirstName(@RequestParam("firstName") String firstName)
    {

        //TODO search baeldung


        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;


    }
    @PostMapping(value = "/update")
    public  ModelAndView updateEmployeeLastName(@RequestParam("lastName") String lastName)
    {




        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;


    }
    @PostMapping(value = "/update")
    public  ModelAndView updateEmployeeUsername(@RequestParam("username") String username)
    {




        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;


    }
    @PostMapping(value = "/update")
    public  ModelAndView updateEmployeEmailAddress(@RequestParam("emailAddress") String emailAddress)
    {




        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;

    }
    @PostMapping(value = "/update")
    public  ModelAndView updateEmployeeAge(@RequestParam("age") Integer age)
    {




        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;

    }
    @PostMapping(value = "/update")
    public  ModelAndView updateEmployeePassword(@RequestParam("password") String password)
    {




        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;

    }
    @PostMapping(value = "/update")
    public  ModelAndView updateEmployeePhoneNumber(@RequestParam("phoneNumber") String phoneNumber)
    {




        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;

    }

*/



@PostMapping("/employees")
    public List<EmployeeDto> getAllemployes( @ModelAttribute String firstName, @ModelAttribute String lastName,
                                             @ModelAttribute int age, @ModelAttribute String phoneNumber, @ModelAttribute String emailAddress) throws NoEmployeeFound {
    return employeeServiceInterface.getEmployees(firstName, lastName,age,phoneNumber,emailAddress);
}
/*
@PostMapping("/deleteemployees")
   List<EmployeeDto> deleteEmployee ( long pk)
{
    return  employeeServiceInterface.deleteEmployee(pk);
}*/ //TODO redo this controller




}
