package mypackage;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeProcessing {
    public static void main(String[] args) {
        LocalDate dateAfter = LocalDate.parse("2021-01-01");

        List<Employee> employees = Arrays.asList(
                new Employee(1, "Alice", "IT", 70000, LocalDate.parse("2020-01-01")),
                new Employee(2, "Bob", "HR", 50000, LocalDate.parse("2021-06-01")),
                new Employee(3, "Charlie", "IT", 80000, LocalDate.parse("2022-01-01"))
        );

        // Filtering by Date
        List<Employee> employeesJoinedAfterDate = employees.stream()
                .filter(emp -> emp.getJoinDate().isAfter(dateAfter))
                .collect(Collectors.toList());

        // Average Calculation for a specific department
        String departmentForAverage = "IT";
        double averageSalaryInDepartment = employees.stream()
                .filter(emp -> emp.getDepartment().equals(departmentForAverage))
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0); // Default value if no employees found

        // Mapping and Collecting names of employees in a specific department
        String specificDepartment = "IT";
        List<String> namesInDepartment = employees.stream()
                .filter(emp -> emp.getDepartment().equals(specificDepartment))
                .map(Employee::getName)
                .collect(Collectors.toList());

        // Maximum and Minimum salary
        Optional<Employee> employeeWithMaxSalary = employees.stream()
                .max(Comparator.comparing(Employee::getSalary));

        Optional<Employee> employeeWithMinSalary = employees.stream()
                .min(Comparator.comparing(Employee::getSalary));

        // Displaying results
        System.out.println("Employees joined after " + dateAfter + ":");
        employeesJoinedAfterDate.forEach(emp -> System.out.println(emp.getId() + ": " + emp.getName()));

        System.out.println("\nAverage salary in department " + departmentForAverage + ": " + averageSalaryInDepartment);

        System.out.println("\nNames of employees in department " + specificDepartment + ":");
        namesInDepartment.forEach(System.out::println);

        employeeWithMaxSalary.ifPresent(emp ->
                System.out.println("\nEmployee with the highest salary: " + emp.getName() + " - Salary: " + emp.getSalary()));

        employeeWithMinSalary.ifPresent(emp ->
                System.out.println("Employee with the lowest salary: " + emp.getName() + " - Salary: " + emp.getSalary()));
    }
}

