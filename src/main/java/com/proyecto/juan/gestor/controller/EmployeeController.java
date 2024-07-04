package com.proyecto.juan.gestor.controller;

import com.proyecto.juan.gestor.entity.Employee;
import com.proyecto.juan.gestor.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeRepository theEmployeeRepository;

    @GetMapping("/")
    public String getEmployees(Model model){
        List<Employee> employees = theEmployeeRepository.findAll();
        model.addAttribute("employees", employees);
        return "employee-list";
    }

    @GetMapping("/newEmployee")
    public String newEmployee(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "employee-form";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        theEmployeeRepository.save(employee);
        return "redirect:/";
    }

    @GetMapping("/edit/{employeeId}")
    public String editEmployee(@PathVariable int employeeId, Model model){
        Optional<Employee> employee = theEmployeeRepository.findById(employeeId);
        model.addAttribute("employee", employee);
        return "employee-form";
    }

    @GetMapping("/delete/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        theEmployeeRepository.deleteById(employeeId);
        return "redirect:/";
    }

}
