package com.example.customermanagementjpa.controller;

import com.example.customermanagementjpa.model.Customer;
import com.example.customermanagementjpa.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;

    @GetMapping("")
    public String index(Model model) {
        List<Customer> customers = iCustomerService.findAll();
        model.addAttribute("customer", customers);
        return "/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("customer", new Customer());
        return "/create";
    }

    @PostMapping("/save")
    public String save(Customer customer) {
        iCustomerService.save(customer);
        return "redirect: /customer";
    }

    @GetMapping("/{id}/update")
    public String update(@PathVariable Long id, Model model) {
        model.addAttribute("customer", iCustomerService.findById(id));
        return "/update";
    }

    @PostMapping("/update")
    public String update(Customer customer) {
        iCustomerService.save(customer);
        return "redirect: /customer";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id, Model model) {
        model.addAttribute("customer", iCustomerService.findById(id));
        return "/delete";
    }

    @PostMapping("/delete")
    public String delete(Customer customer, RedirectAttributes attributes) {
        iCustomerService.remove(customer.getId());
        attributes.addFlashAttribute("success", "remove customer success");
        return "redirect: /customer";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable Long id, Model model) {
        model.addAttribute("customer", iCustomerService.findById(id));
        return "/view";
    }
}
