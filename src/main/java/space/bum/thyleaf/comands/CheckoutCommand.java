package space.bum.thyleaf.comands;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CheckoutCommand {
  @NotEmpty
  private String lastName;
  
  @NotEmpty
  @Size(min = 1, max = 5)
  private String firstName;

  @NotEmpty
  @Size(min = 2, max = 50)
  private String addressLine1;
  
  @NotEmpty
  private String addressLine2;

  @NotEmpty
  @Size(min = 2, max = 50)
  private String city;

  @NotEmpty
  @Pattern(regexp="\\d{5}")
  private String zipCode;
}
