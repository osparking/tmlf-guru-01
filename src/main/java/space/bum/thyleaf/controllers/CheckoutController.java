package space.bum.thyleaf.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;
import space.bum.thyleaf.comands.CheckoutCommand;

@Controller
public class CheckoutController {

  @GetMapping("/checkout")
  public String checkoutProduct(Model model) {
    model.addAttribute("checkoutCommand", new CheckoutCommand());
    return "checkoutform";
  }

  @PostMapping("/docheckout")
  public String checkoutProduct(@Valid CheckoutCommand command,
      BindingResult result) {
    
    if (result.hasErrors()) {
      return "checkoutform";
    } else {
      return "checkoutdone";
    }
  }

}
