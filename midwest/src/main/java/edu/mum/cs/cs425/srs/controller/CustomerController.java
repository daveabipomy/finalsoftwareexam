package edu.mum.cs.cs425.srs.controller;

import edu.mum.cs.cs425.srs.model.Customer;
import edu.mum.cs.cs425.srs.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Comparator;
import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    ICustomerService customerService;

    @RequestMapping(value="/customers", method = RequestMethod.GET)
    public ModelAndView customers(){
        List<Customer> customers = customerService.findAllSort();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("customers", customers);
        modelAndView.setViewName("midwest/customer/list");
        return modelAndView;
    }


    @RequestMapping(value="/Customer/insert", method = RequestMethod.GET)
    public String create(Model model){
        model.addAttribute("customer", new Customer());
        return "midwest/customer/insert";
    }

    @RequestMapping(value = "/Customer/insert", method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute("customer") Customer customer,
                         BindingResult result, Model model)  {

        if (result.hasErrors()) {
            model.addAttribute("errors", result.getAllErrors());
            return "/Customer/insert";
        }

        customer = customerService.save(customer);
        return "redirect:/customers";
    }
}
