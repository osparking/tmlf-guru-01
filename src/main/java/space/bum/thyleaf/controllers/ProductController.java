package space.bum.thyleaf.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
}
