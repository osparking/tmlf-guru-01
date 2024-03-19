package space.bum.thyleaf.domain;

import lombok.Data;

@Data
public class Author {
  private Integer id;
  private String firstName;
  private String lastName;
  private String image;
}
