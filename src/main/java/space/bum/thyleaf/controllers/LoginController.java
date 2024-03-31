package space.bum.thyleaf.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import space.bum.thyleaf.comands.CheckoutCommand;
import space.bum.thyleaf.domain.Credential;

@Controller
public class LoginController {

  @GetMapping("/login")
  public String loginForm(Model model) {
    model.addAttribute("credential", new Credential());
    return "login";
  }

  @PostMapping("/welcome")
  public String checkCredential(@Valid Credential credential,
      BindingResult result, Model model) {
    if (result.hasErrors()) {
      return "login";
    } else {
      model.addAttribute("credential", credential);
      checkAccount(credential);
      return "welcome";
    }
  }

  private void checkAccount(@Valid Credential credential) {
    // TODO Auto-generated method stub
  }
}
