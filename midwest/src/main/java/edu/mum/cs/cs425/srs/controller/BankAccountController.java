package edu.mum.cs.cs425.srs.controller;

import edu.mum.cs.cs425.srs.model.Account;
//import edu.mum.cs.cs425.srs.model.Product;
import edu.mum.cs.cs425.srs.repository.IAccountTypeRepository;
import edu.mum.cs.cs425.srs.service.IAccountService;
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

@Controller
public class BankAccountController {

    @Autowired
    ICustomerService customerService;

    @Autowired
    IAccountTypeRepository accountTypeRepository;

    @Autowired
    IAccountService accountService;


    @RequestMapping(value="/accounts", method = RequestMethod.GET)
    public ModelAndView customers(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("accounts", accountService.findAll());
        modelAndView.addObject("liquidity",accountService.liquidity());
        modelAndView.setViewName("midwest/account/list");
        return modelAndView;
    }

    @RequestMapping(value="/account/insert", method = RequestMethod.GET)
    public String create(Model model){

        model.addAttribute("customers",customerService.findAll());
        model.addAttribute("accountType",accountTypeRepository.findAll());
        model.addAttribute("account", new Account());
        return "midwest/account/insert";
    }


    @RequestMapping(value = "/account/insert", method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute("account") Account account,
                         BindingResult result, Model model)  {

        if (result.hasErrors()) {
            model.addAttribute("errors", result.getAllErrors());
            return "accounts";
        }

        account = accountService.save(account);
        return "redirect:/accounts";
    }

}
