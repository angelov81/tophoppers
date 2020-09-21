package bg.softuni.tophoppers.web.controller;

import bg.softuni.tophoppers.domain.entity.ProductEntity;
import bg.softuni.tophoppers.domain.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductsController {

  private final ProductService productService;

  public ProductsController(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping
  public List<ProductEntity> getAllProducts() {
    return this.productService.getAllProducts();
  }

  @GetMapping("/{productId}")
  public ResponseEntity<ProductEntity> getProduct(@PathVariable String productId) {
    Optional<ProductEntity> theProduct = this.productService.getProductById(productId);

    return theProduct.map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
  }

  // TODO: Change @RequestBody ProductEntity with a DTO class
  @PostMapping
  public ResponseEntity<ProductEntity> create(UriComponentsBuilder uriComponentsBuilder,
                                              @RequestBody ProductEntity productEntity) {
    ProductEntity newProduct = this.productService.save(productEntity);
    return ResponseEntity
        .created(uriComponentsBuilder
            .path("/products/{productId}")
            .buildAndExpand(newProduct.getId())
            .toUri())
        .build();
  }

  @DeleteMapping("/{productId}")
  public ResponseEntity<ProductEntity> delete(@PathVariable String productId) {
    this.productService.delete(productId);

    return ResponseEntity.noContent().build();
  }



}
