package space.bum.thyleaf.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.LocaleResolver;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import space.bum.thyleaf.comands.CheckoutCommand;

@Controller
public class CheckoutController {

  @GetMapping("/checkout")
  public String checkoutProduct(Model model) {
    model.addAttribute("checkoutCommand", new CheckoutCommand());
    return "checkoutform";
  }
  
  @Autowired
  LocaleResolver localeResolver;
  
  @PostMapping("/docheckout")
  public String checkoutProduct(@Valid CheckoutCommand command,
      BindingResult result, HttpServletRequest request) {
    /**
     * 언어별 성씨 길이 제한치를 불충족하면 필드 오류를 만들어 result 에 더한다.
     */
    String lastNLenError = null;
    int lastNLen = command.getLastName().trim().length();
    
    switch (localeResolver.resolveLocale(request).getLanguage()) {
    case "ko":
      if (lastNLen == 0 || lastNLen > 2)
        lastNLenError = "\"성씨\"는 하나 혹은 두 글자만 가능합니다.";
      break;
    case "en":
      if (lastNLen < 2 || lastNLen > 30)
        lastNLenError = "\"Last name\" must be within 2 to 30 characters.";
      break;
    default:
    }
    if (lastNLenError != null)
      result.addError(new FieldError("command", "lastName", lastNLenError));
    
    if (result.hasErrors()) {
      return "checkoutform";
    } else {
      return "checkoutdone";
    }
  }
}
