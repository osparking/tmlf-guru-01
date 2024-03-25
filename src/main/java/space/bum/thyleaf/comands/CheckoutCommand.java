package space.bum.thyleaf.comands;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CheckoutCommand {
  @NotEmpty
  @Size(min = 2, max = 50)
  private String lastName;
  
  @NotEmpty
  @Size(min = 2, max = 50)
  private String firstName;

  @NotEmpty
  @Size(min = 2, max = 50)
  private String addressLine1;
  private String addressLine2;

  @NotEmpty
  @Size(min = 2, max = 50)
  private String city;

  @NotEmpty
  @Size(min = 5, max = 10)
  private String zipCode;
}