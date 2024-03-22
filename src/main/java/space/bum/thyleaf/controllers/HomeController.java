package space.bum.thyleaf.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import space.bum.thyleaf.services.ProductService;

@Controller
public class HomeController {
  
  private ProductService productService;
  
  @Autowired
  public void setProductService(ProductService productService) {
    this.productService = productService;
  }
  
  @GetMapping
  public String home(Model model) {
    model.addAttribute("products", productService.listProducts());
    return "index";
  }
}
