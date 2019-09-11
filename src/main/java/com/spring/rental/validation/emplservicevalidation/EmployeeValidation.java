package com.spring.rental.validation.emplservicevalidation;

import com.spring.rental.domain.Employee;
import com.spring.rental.dto.EmployeeDto;
import com.spring.rental.dto.EmployeeInsertDto;
import com.spring.rental.exceptions.employeeexceptions.*;
import com.spring.rental.service.EmployeeServiceImpl;
import org.apache.log4j.Logger;

import static com.spring.rental.exceptions.employeeexceptions.Codes.*;
import static com.spring.rental.exceptions.employeeexceptions.Codes.INVALID_EMPLOYEE_EMAIL_ADDRESS;

public class EmployeeValidation {
    private static final Logger Log = Logger.getLogger(EmployeeServiceImpl.class);


    //  This function validates employee first name, this parameter should not contains numbers & special characters
    //  and it's length should be in interval of (0 , 10]
    public static void firstNameValidation(EmployeeInsertDto employeeInsertDto) throws InvalidEmployeeFirstAndLastName {
        String firstName = employeeInsertDto.getFirstName();    // TODO first char of  first name should be capital
        boolean stringFlag = false;

        if (firstName instanceof String) {
            stringFlag = true;
        }


        if (firstName.matches(".*\\d.*") || firstName.matches("[^A-Za-z0-9]") || firstName.length() == 0 || firstName.length() >= 10 || !stringFlag) {
            throw new InvalidEmployeeFirstAndLastName("EmployeeServiceInterface name is invalid", INVALID_EMPLOYEE_FIRST_NAME);
        }

    }

    //  This function validates employee last name, this parameter should not contains numbers & special characters
    //  and it's length should be in interval of (0 , 10]

    public static void lastNameValidation(EmployeeInsertDto employeeInsertDto) throws InvalidEmployeeFirstAndLastName {
        String lastName = employeeInsertDto.getLastName();  // TODO first char of  last name should be capital

        boolean stringFlag = false;

        if (lastName instanceof String) {
            stringFlag = true;
        }

        if (lastName.matches(".*\\d.*") || lastName.matches("[^A-Za-z0-9]") || lastName.length() == 0 || lastName.length() >= 10 || !stringFlag) {
            throw new InvalidEmployeeFirstAndLastName("EmployeeServiceInterface name is invalid", INVALID_EMPLOYEE_FIRST_NAME);
        }

    }
    //  This function validates employee  username, this parameter should not contains numbers & special characters
    //  and it's length should be in interval of (0 , 10]

    public static void usernameValidation(EmployeeInsertDto employeeInsertDto) throws InvalidEmployeeUsername {
        String username = employeeInsertDto.getUsername();

        boolean stringFlag = false;

        if (username instanceof String) {
            stringFlag = true;
        }

        if (username.matches(".*\\d.*") || username.matches("[^A-Za-z0-9]") || username.length() == 0 || username.length() >= 10 || !stringFlag) {
            throw new InvalidEmployeeUsername("EmployeeServiceInterface username is invalid", INVALID_EMPLOYEE_USERNAME);
        }

    }

    // This function validates employee phone number
    // phone number should not contain anything but numbers and it's length should be 10
    public static void phoneNumberOfEmployeeValidation(EmployeeInsertDto employeeInsertDto) throws InvalidEmployeePhoneNumber {
        String phoneNumber = employeeInsertDto.getPhoneNumber();

        boolean stringFlag = false;

        if (phoneNumber instanceof String) {
            stringFlag = true;
        }

        if (phoneNumber.matches("[0-9]+") && phoneNumber.length() == 10 && stringFlag) {
            System.out.println("Phone number added with succes");    // TODO check if it's ok for view and phone number should start with 0
        } else throw new InvalidEmployeePhoneNumber("Phone number is invalid", INVALID_EMPLOYEE_PHONE_NUMBER);
    }

    //This function validates employee age
    // our company want employees between 18 and 50 years
    // also param age should not contain characters or special characters
    public static void employeeAgeValidation(EmployeeInsertDto employeeInsertDto) throws InvalidEmployeeAge {

        Integer age = employeeInsertDto.getAge();

        boolean integerFlag = false;

        if (age instanceof Integer)          //TODO check if it's good age type
        {
            integerFlag = true;
        }

        String ageString = Integer.toString(age);

        boolean ageFlag = false;
        if (ageString.matches("[0-9]+")) {
            ageFlag = true;
        }
        if (age <= 18 || age >= 50 || !ageFlag || !integerFlag) {
            throw new InvalidEmployeeAge("This employee age don't belong in our parameters", INVALID_EMPLOYEE_AGE);
        }

    }

    // This function validates employee password
    // password should contain uppercase, lowercase, numbers, special characters and it's length should be in interval of [ 6, 12]
    public static void employeePasswordValidation(EmployeeInsertDto employeeInsertDto) throws InvalidEmployeePassword {
        String password = employeeInsertDto.getPassword();
        boolean stringFlag = false;

        if (password instanceof String) {
            stringFlag = true;
        }
        char ch;
        boolean capitalFlag = false;
        boolean lowerCaseFlag = false;
        boolean numberFlag = false;
        boolean lengthFlag = false;
        boolean specialCharFlag = false;

        if (password.length() >= 6 && password.length() <= 12) {
            lengthFlag = true;
        }
        for (int i = 0; i < password.length(); i++) {
            ch = password.charAt(i);

            if (Character.isDigit(ch)) {
                numberFlag = true;
            } else if (Character.isUpperCase(ch)) {
                capitalFlag = true;
            } else if (Character.isLowerCase(ch)) {
                lowerCaseFlag = true;
            }

        }
        /*if (password.matches("[$&+,:;=?@#|'<>.^*()%!-]"))
        {*/
        specialCharFlag = true;
        /*}*/
        if (capitalFlag && numberFlag && lowerCaseFlag && lengthFlag && specialCharFlag && stringFlag) {
            System.out.println("Password is valid");

        } else throw new InvalidEmployeePassword("Password is invalid", INVALID_EMPLOYEE_PASSWORD);
    }

    // This function validates employee email address
    // email adress should contain '@' and no other special character
    public static void employeeEmailAddressValidation(EmployeeInsertDto employeeInsertDto) throws InvalidEmployeeEmailAddress {

        String emailAddress = employeeInsertDto.getEmailAddress();

        boolean stringFlag = false;

        if (emailAddress instanceof String) {
            stringFlag = true;
        }

        String specialCharacter = "@";                                          //TODO maybe we need more, who knows?

        boolean emailFlag = false; // TODO revise

        if (emailAddress.contains(specialCharacter) && stringFlag) {
            System.out.println("TEST, THIS VALIDATION IS NOT COMPLETE");
        } else throw new InvalidEmployeeEmailAddress("This email adress is invalid", INVALID_EMPLOYEE_EMAIL_ADDRESS);

        
        
    }
    //  This function validates employee first name, this parameter should not contains numbers & special characters
    //  and it's length should be in interval of (0 , 10]
    public static void firstNameValidation(Employee employee) throws InvalidEmployeeFirstAndLastName {
        String firstName = employee.getFirstName();    // TODO first char of  first name should be capital
        boolean stringFlag = false;

        if (firstName instanceof String) {
            stringFlag = true;
        }


        if (firstName.matches(".*\\d.*") || firstName.matches("[^A-Za-z0-9]") || firstName.length() == 0 || firstName.length() >= 10 || !stringFlag) {
            throw new InvalidEmployeeFirstAndLastName("EmployeeServiceInterface name is invalid", INVALID_EMPLOYEE_FIRST_NAME);
        }

    }

    //  This function validates employee last name, this parameter should not contains numbers & special characters
    //  and it's length should be in interval of (0 , 10]

    public static void lastNameValidation(Employee employee) throws InvalidEmployeeFirstAndLastName {
        String lastName = employee.getLastName();  // TODO first char of  last name should be capital

        boolean stringFlag = false;

        if (lastName instanceof String) {
            stringFlag = true;
        }

        if (lastName.matches(".*\\d.*") || lastName.matches("[^A-Za-z0-9]") || lastName.length() == 0 || lastName.length() >= 10 || !stringFlag) {
            throw new InvalidEmployeeFirstAndLastName("EmployeeServiceInterface name is invalid", INVALID_EMPLOYEE_FIRST_NAME);
        }

    }
    //  This function validates employee  username, this parameter should not contains numbers & special characters
    //  and it's length should be in interval of (0 , 10]

    public static void usernameValidation(Employee employee) throws InvalidEmployeeUsername {
        String username = employee.getUsername();

        boolean stringFlag = false;

        if (username instanceof String) {
            stringFlag = true;
        }

        if (username.matches(".*\\d.*") || username.matches("[^A-Za-z0-9]") || username.length() == 0 || username.length() >= 10 || !stringFlag) {
            throw new InvalidEmployeeUsername("EmployeeServiceInterface username is invalid", INVALID_EMPLOYEE_USERNAME);
        }

    }

    // This function validates employee phone number
    // phone number should not contain anything but numbers and it's length should be 10
    public static void phoneNumberOfEmployeeValidation(Employee employee) throws InvalidEmployeePhoneNumber {
        String phoneNumber = employee.getPhoneNumber();

        boolean stringFlag = false;

        if (phoneNumber instanceof String) {
            stringFlag = true;
        }

        if (phoneNumber.matches("[0-9]+") && phoneNumber.length() == 10 && stringFlag) {
            System.out.println("Phone number added with succes");    // TODO check if it's ok for view and phone number should start with 0
        } else throw new InvalidEmployeePhoneNumber("Phone number is invalid", INVALID_EMPLOYEE_PHONE_NUMBER);
    }

    //This function validates employee age
    // our company want employees between 18 and 50 years
    // also param age should not contain characters or special characters
    public static void employeeAgeValidation(Employee employee) throws InvalidEmployeeAge {

        Integer age = employee.getAge();

        boolean integerFlag = false;

        if (age instanceof Integer)          //TODO check if it's good age type
        {
            integerFlag = true;
        }

        String ageString = Integer.toString(age);

        boolean ageFlag = false;
        if (ageString.matches("[0-9]+")) {
            ageFlag = true;
        }
        if (age <= 18 || age >= 50 || !ageFlag || !integerFlag) {
            throw new InvalidEmployeeAge("This employee age don't belong in our parameters", INVALID_EMPLOYEE_AGE);
        }

    }

    // This function validates employee password
    // password should contain uppercase, lowercase, numbers, special characters and it's length should be in interval of [ 6, 12]
    public static void employeePasswordValidation(Employee employee) throws InvalidEmployeePassword {
        String password = employee.getPassword();
        boolean stringFlag = false;

        if (password instanceof String) {
            stringFlag = true;
        }
        char ch;
        boolean capitalFlag = false;
        boolean lowerCaseFlag = false;
        boolean numberFlag = false;
        boolean lengthFlag = false;
        boolean specialCharFlag = false;

        if (password.length() >= 6 && password.length() <= 12) {
            lengthFlag = true;
        }
        for (int i = 0; i < password.length(); i++) {
            ch = password.charAt(i);

            if (Character.isDigit(ch)) {
                numberFlag = true;
            } else if (Character.isUpperCase(ch)) {
                capitalFlag = true;
            } else if (Character.isLowerCase(ch)) {
                lowerCaseFlag = true;
            }

        }
        /*if (password.matches("[$&+,:;=?@#|'<>.^*()%!-]"))
        {*/
        specialCharFlag = true;
        /*}*/
        if (capitalFlag && numberFlag && lowerCaseFlag && lengthFlag && specialCharFlag && stringFlag) {
            System.out.println("Password is valid");

        } else throw new InvalidEmployeePassword("Password is invalid", INVALID_EMPLOYEE_PASSWORD);
    }

    // This function validates employee email address
    // email adress should contain '@' and no other special character
    public static void employeeEmailAddressValidation(Employee employee) throws InvalidEmployeeEmailAddress {

        String emailAddress = employee.getEmailAddress();

        boolean stringFlag = false;

        if (emailAddress instanceof String) {
            stringFlag = true;
        }

        String specialCharacter = "@";                                          //TODO maybe we need more, who knows?

        boolean emailFlag = false; // TODO revise

        if (emailAddress.contains(specialCharacter) && stringFlag) {
            System.out.println("TEST, THIS VALIDATION IS NOT COMPLETE");
        } else throw new InvalidEmployeeEmailAddress("This email adress is invalid", INVALID_EMPLOYEE_EMAIL_ADDRESS);


    }
}