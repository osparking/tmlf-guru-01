package space.bum.thyleaf.services;

import java.util.List;
import space.bum.thyleaf.domain.Product;

public interface ProductService {
  Product getProduct(Integer id);

  List<Product> listProducts();
}
