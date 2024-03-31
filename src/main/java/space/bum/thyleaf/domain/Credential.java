package space.bum.thyleaf.domain;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class Credential {
  @NotEmpty
  @Pattern(regexp="[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9]){1,16}[a-zA-Z0-9]")
  private String userid;
  
  @NotEmpty
  private String password;
}
