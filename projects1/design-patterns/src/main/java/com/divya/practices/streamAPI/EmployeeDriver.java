package com.divya.practices.streamAPI;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://javaconceptoftheday.com/solving-real-time-queries-using-java-8-features-employee-management-system/
 */
public class EmployeeDriver {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
        employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
        employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
        employeeList.add(new Employee(155, "Paul ", 26, "Male", "Sales And Marketing", 2015, 13500.0));

        getAllDeptNames(employeeList);

        /**
         * 1. 2nd highest salary
         */
        Optional<Employee> emp = employeeList.stream()
//                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .sorted((o1, o2) -> (int) (o2.getSalary() - o1.getSalary()))
                .skip(1)
                .findFirst();
        System.out.println(emp.get());

        /**
         * 2. How many male and female employees are there in the organization?
         */
        Map<String, Long> noOfMaleAndFemale = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println(noOfMaleAndFemale);

        /**
         * 3. Print the name of all departments in the organization?
         */
        employeeList.stream()
                .map(employee -> employee.getDepartment())
                .distinct()
//        .forEach(s -> System.out.println(s));
                .forEach(System.out::println);

        /**
         * 4. What is the average age of male and female employees?
         */
//        employeeList
//                .stream()
//                .filter(employee -> employee.getGender().equals("Male"))
//                .mapToInt(Employee::getAge)
//                .average();
        Map<String, Double> averageAgeOfMaleAndFemale = employeeList
                .stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
        System.out.println(averageAgeOfMaleAndFemale);


        /**
         * 5. Get the details of highest paid employee in the organization?
         */
        Optional<Employee> highestPaidEmployeeWrapper = employeeList.stream()
                .collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));
        Employee employee = highestPaidEmployeeWrapper.get();
        System.out.println(employee.getId()
                + "\n" + employee.getName()
                + "\n" + employee.getSalary()
                + "\n" + employee.getAge()
                + "\n" + employee.getDepartment());

        /**
         *  6. Get the names of all employees who have joined after 2015?
         */
        List<Employee> employeesJoinedAfter2015 = employeeList
                .stream()
                .filter(employee1 -> employee1.getYearOfJoining() > 2015)
                .collect(Collectors.toList());
        System.out.println(employeesJoinedAfter2015);

        /**
         * 7. Count the number of employees in each department?
         */
        Map<String, Long> employeesInEachDepartmentCount = employeeList
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        System.out.println(employeesInEachDepartmentCount);

        /**
         * 8.  What is the average salary of each department?
         */
        Map<String, Double> avgSalaryOfEachDept = employeeList
                .stream()
                .collect(Collectors
                        .groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(avgSalaryOfEachDept);

        /**
         * 9. Get the details of youngest male employee in the product development department?
         */
        Optional<Employee> first = employeeList
                .stream()
                .filter(employee1 -> employee1.getGender().equalsIgnoreCase("Male") && employee1.getDepartment().equalsIgnoreCase("product development"))
//                .collect(Collectors.toList());
                .sorted((o1, o2) -> o1.getAge() - o2.getAge()).findFirst();
        System.out.println(first.get());

        /**
         * 10.  Who has the most working experience in the organization?
         */
        Optional<Employee> employeeMostWorkingExperience = employeeList.stream()
                .sorted((o1, o2) -> o1.getYearOfJoining() - o2.getYearOfJoining())
                .findFirst();
        System.out.println(employeeMostWorkingExperience.get());

        /**
         * How many male and female employees are there in the sales and marketing team?
         */
        Map<String, Long> sales_and_marketingEmployeeCount = employeeList
                .stream()
                .filter(employee1 -> employee1.getDepartment().equalsIgnoreCase("sales and marketing"))
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println(sales_and_marketingEmployeeCount);


    }


    static List<EmpNameDeptName> getAllDeptNames(List<Employee> employees) {
        employees
                .stream()
//               .map(employee -> {
//                    return employee.getDepartment();
//                })
                .map(Employee::getDepartment)
                .distinct()
                .forEach(System.out::println);


        List<EmpNameDeptName> collect = employees
                .stream()
                .map(employee -> {
                    System.out.println(employee.department);
                    return new EmpNameDeptName(employee.getName(), employee.getDepartment());
                })
                .collect(Collectors.toList());

        return collect;
    }

    public static class EmpNameDeptName {
        String empName;
        String deptName;

        public EmpNameDeptName(String empName, String deptName) {
            this.empName = empName;
            this.deptName = deptName;
        }
    }


}
