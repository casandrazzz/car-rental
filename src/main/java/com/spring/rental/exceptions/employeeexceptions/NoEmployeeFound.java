package com.spring.rental.exceptions.employeeexceptions;

import lombok.Getter;

public class NoEmployeeFound  extends Exception{
    @Getter
    private final int code;

   public NoEmployeeFound(String message, int code)
   {
       super(message);
       this.code = code;
   }
}
