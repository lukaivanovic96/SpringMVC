package springmvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import springmvc.domain.Customer;
import springmvc.domain.Product;
import springmvc.services.CustomerService;
import springmvc.services.ProductService;

@RequestMapping("/customer")
@Controller
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @RequestMapping("/list")
    public String getAllProducts(Model model){
        model.addAttribute("customers",customerService.all());
        return "customer/list";
    }

    @RequestMapping("/view/{id}")
    public String showProduct(@PathVariable Integer id, Model model){
        model.addAttribute("customer", customerService.getById(id));
        return "customer/view";
    }

    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("customer", customerService.getById(id));
        return "customer/customerform";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String customer(Customer customer){
        Customer savedCustomer = customerService.saveOrUpdate(customer);
        return "redirect:/customer/view/" + savedCustomer.getId();
    }

    @RequestMapping("/new")
    public String newProduct(Model model){
        model.addAttribute("customer", new Customer());
        return "customer/customerform";
    }

    @RequestMapping("delete/{id}")
    public String delete(@PathVariable Integer id){
        customerService.delete(id);
        return "redirect:/customer/list";
    }
}
