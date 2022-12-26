package com.divya.divyaworkbook.workbook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Driver {
    public static void main(String[] args) {

        List<Employee> employeeList = getAllEmployees();

        List<Employee> employeeListByCity = filterEmployeesByCity(employeeList, "Mysore", "Mysore1");

        printEmpoyees(employeeListByCity);
    }

    private static void printEmpoyees(List<Employee> employeeListByCity) {
        employeeListByCity.forEach(Employee::print);
    }

    private static List<Employee> filterEmployeesByCity(List<Employee> employeeList, String city1, String city2) {
        return employeeList.stream()
                .filter(employee -> employee.getAddresses().stream()
                        .anyMatch(address -> address.getCity().equals(city1) || address.getCity().equals(city2)))
                .collect(Collectors.toList());
    }

    private static List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        List<Address> addressesOfEmp1 = Arrays.asList(new Address("abc1", "Mysore1"),
                new Address("abc2", "Bangalore"));
        Employee employee1 = new Employee("emp1", 20, addressesOfEmp1);
        employees.add(employee1);

        List<Address> addressesOfEmp2 = Arrays.asList(new Address("abc1", "Mysore2"),
                new Address("abc2", "Bangalore"));
        Employee employee2 = new Employee("emp2", 20, addressesOfEmp2);
        employees.add(employee2);

        List<Address> addressesOfEmp3 = Arrays.asList(new Address("abc1", "Mysore"),
                new Address("abc2", "Bangalore"));
        Employee employee3 = new Employee("emp3", 20, addressesOfEmp3);
        employees.add(employee3);

        List<Address> addressesOfEmp4 = Arrays.asList(new Address("abc1", "Mysore"),
                new Address("abc2", "Bangalore"));
        Employee employee4 = new Employee("emp4", 20, addressesOfEmp4);
        employees.add(employee4);

        List<Address> addressesOfEmp5 = Arrays.asList(new Address("abc1", "Mysore"),
                new Address("abc2", "Bangalore"));
        Employee employee5 = new Employee("emp5", 20, addressesOfEmp5);
        employees.add(employee5);

        return employees;
    }
}
