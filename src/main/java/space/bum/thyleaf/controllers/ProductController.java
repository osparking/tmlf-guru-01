package space.bum.thyleaf.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import space.bum.thyleaf.services.ProductService;

@Controller
public class ProductController {

  private ProductService productService;

  @Autowired
  public void setProductService(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping("/product")
  public String getProduct() {
    return "redirect:/index";
  }

  @GetMapping("/product/{id}")
  public String getProductById(@PathVariable("id") Integer id, Model model) {
    model.addAttribute("product", productService.getProduct(id));
    return "product";
  }
}
