package com.sample.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/hello")
    public String getHello() {
        return "hello";
    }

    @PostMapping("/hello")
    public String postRequest(@RequestParam("text1") String str, Model model) {
        model.addAttribute("sample", str);
        return "helloResponse";
    }

    @PostMapping("/hello/db")
    public String postDbRequest(@RequestParam("text2") String str, Model model) {
        Integer id = Integer.parseInt(str);
        Employee employee = employeeService.findOneById(id);
        model.addAttribute("id", employee.getId());
        model.addAttribute("name", employee.getName());
        return "helloResponseDb";
    }

    @PostMapping("/hello/create")
    public @ResponseBody String createEmployee(@RequestParam String name, @RequestParam Integer age) {
        Employee employee = new Employee();
        employee.setAge(age);
        employee.setName(name);

        employeeService.create(employee);
        return "saved";
    }
}