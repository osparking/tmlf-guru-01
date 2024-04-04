package space.bum.thyleaf.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;
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
      BindingResult result, Model model, RedirectAttributes redAttrs) {
    if (result.hasErrors()) {
      return "login";
    } else {
      checkAccount(credential);
      redAttrs.addFlashAttribute("username", credential.getUsername());
      return "redirect:index";
    }
  }

  private void checkAccount(@Valid Credential credential) {
    // TODO Auto-generated method stub
  }
}
