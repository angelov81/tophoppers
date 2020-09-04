package bg.softuni.tophoppers.domain.service;

import bg.softuni.tophoppers.domain.entity.CategoryEntity;
import bg.softuni.tophoppers.domain.entity.ProductEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface ProductService {

  void initProduct(String productName, String productDesc, BigDecimal price,
                   LocalDateTime expiresOn, String categoryName);

  List<ProductEntity> getAllProducts();

  List<ProductEntity> getAllProductsByCategory(CategoryEntity categoryEntity);

}
