package bg.softuni.tophoppers.domain.service.Impl;

import bg.softuni.tophoppers.domain.entity.CategoryEntity;
import bg.softuni.tophoppers.domain.entity.CategoryName;
import bg.softuni.tophoppers.domain.entity.ProductEntity;
import bg.softuni.tophoppers.domain.repository.ProductRepository;
import bg.softuni.tophoppers.domain.service.CategoryService;
import bg.softuni.tophoppers.domain.service.FarmService;
import bg.softuni.tophoppers.domain.service.ProductService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

  private final ProductRepository productRepository;
  private final CategoryService categoryService;
  private final FarmService farmService;

  public ProductServiceImpl(ProductRepository productRepository,
                            CategoryService categoryService, FarmService farmService) {
    this.productRepository = productRepository;
    this.categoryService = categoryService;
    this.farmService = farmService;
  }

  @Override
  public void initProduct(String productName, String productDesc, BigDecimal productPrice,
                          LocalDateTime expiresOn, String categoryName) {
    boolean productNotPresent = this.productRepository.findByName(productName).isEmpty();
    if (productNotPresent) {
      ProductEntity product = new ProductEntity();
      product.setName(productName);
      product.setDescription(productDesc);
      product.setPrice(productPrice);
      product.setExpiresOn(expiresOn);
      product.setFarm(this.farmService.getFarm("Default"));
      CategoryEntity category = this.categoryService.find(CategoryName.valueOf(categoryName));
      product.setCategory(category);

      this.productRepository.save(product);
    }
  }

  @Override
  public List<ProductEntity> getAllProducts() {
    return this.productRepository.findAll();
  }

  @Override
  public List<ProductEntity> getAllProductsByCategory(CategoryEntity categoryEntity) {
    return this.productRepository.findAllByCategory(categoryEntity);
  }

  @Override
  public Optional<ProductEntity> getProductById(String id) {
    return this.productRepository.findById(id);
  }

  @Override
  public ProductEntity save(ProductEntity product) {
    return this.productRepository.save(product);
  }


}
