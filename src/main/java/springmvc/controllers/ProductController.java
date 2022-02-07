package springmvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import springmvc.domain.Product;
import springmvc.services.ProductService;

import java.util.List;

@RequestMapping("/product")
@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping("/list")
    public String getAllProducts(Model model){
        model.addAttribute("products",productService.all());
        return "/product/list";
    }

    @RequestMapping("view/{id}")
    public String showProduct(@PathVariable Integer id, Model model){
        model.addAttribute("product", productService.getById(id));
        return "/product/view";
    }

    @RequestMapping("edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("product", productService.getById(id));
        return "/product/productform";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String save(Product product){
        Product savedProduct = productService.saveOrUpdate(product);
        return "redirect:/product/view/" + savedProduct.getId();
    }

    @RequestMapping("new")
    public String newProduct(Model model){
        model.addAttribute("product", new Product());
        return "product/productform";
    }

    @RequestMapping("delete/{id}")
    public String delete(@PathVariable Integer id){
        productService.delete(id);
        return "redirect:/product/list";
    }
}
