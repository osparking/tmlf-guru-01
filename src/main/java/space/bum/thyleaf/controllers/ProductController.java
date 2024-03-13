package space.bum.thyleaf.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {
  @GetMapping("/product")
  public String getProduct() {
    return "product";
  }
}
