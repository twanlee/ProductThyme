package controllers;

import filter.FontFilter;
import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import service.IProductService;
import service.impl.ProductService;

import javax.servlet.Filter;
import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {
    @Autowired
    FontFilter fontFilter;
    private IProductService productService = new ProductService();
    @GetMapping("/")
    public String index(Model model){
        List<Product> products = productService.getAll();
        model.addAttribute("products", products);
        return "index";

    }
    @GetMapping("/product/add")
    public String add(Model model){
        model.addAttribute("product",new Product());
        return "add";
    }
    @PostMapping("/product/add")
    public String save(Product product, RedirectAttributes redirect){
        product.setId((int)(Math.random() * 10000));
        productService.add(product);
        redirect.addFlashAttribute("success","Add completed");
        return "redirect:/";
    }
    @GetMapping("product/{id}/delete")
    public String delete(@PathVariable int id){
        productService.delete(id);
        return "redirect:/";
    }
    @GetMapping("/product/{id}/update")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "edit";
    }
    @PostMapping("/product/update")
    public String update(Product product, RedirectAttributes redirect) {
        productService.update(product.getId(), product);
        redirect.addFlashAttribute("success", "Modified customer successfully!");
        return "redirect:/";
    }
    @GetMapping("/product/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "view";
    }
}
