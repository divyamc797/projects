package com.divya.learning.examples.optionalExamples;

import java.util.Optional;

public class EmployeeDriver {
    public static void main(String[] args) {
        Employee e1 = new Employee();
        e1.setAge(20);
        e1.setName("abc");

        Employee e2 = new Employee();
        e2.setName("bcd");
        e2.setAge(30);

//        ----------------------------------------------------

        //1. Optional.ofNullable()  -- returns an Optional with a
        // present value if the specified value is non-null, otherwise an empty Optional
//        if(e1!=null){
//            System.out.println(e1.getName());
//        }
//
//        e1 = null;
//        Optional.ofNullable(e1)
//                .ifPresent(employee -> System.out.println(employee.getName()));

//        -----------------------------------------------
        //2. Optional.of() -- returns an Optional with the value present
//        Optional.of(e1)
//                .ifPresent(employee -> System.out.println(employee.getName()));


//       if object  is null - Optional.of() -- Throws:NullPointerException - if value is null
//        e2 = null;
//        Optional.of(e2)
//                .ifPresent(employee -> System.out.println(employee.getName()));

//        ---------------------------------------------------

        //3. Optional.empty() -- returns an empty instance
        // create a Optional
       Optional<Integer> optional = Optional.empty();
       //print value
       System.out.println(optional);
       //output : Optional.empty

//        ---------------------------------------------------

        //4. Optional.isPresent() -- return BOOLEAN
        //                        -- return true if there is a value present, otherwise false.
        //                        -- not highly recommended
        Optional.ofNullable(e1)
                .isPresent();

    }
}
