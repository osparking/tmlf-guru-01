package space.bum.thyleaf.domain;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import lombok.Data;

@Data
public class Product {
  private Integer id;
  private String courseName;
  private String courseSubtitle;
  private String courseDescription;
  private Author author;
  private BigDecimal price;
  private String priceStr;
  private List<ProductCategory> productCategories = new ArrayList<>();
  private String imageUrl;

  public void setPrice(BigDecimal price, Locale locale) {
    this.price = price;
    NumberFormat cuFmt = NumberFormat.getCurrencyInstance(locale);
    this.priceStr = cuFmt.format(price);
  }
}
