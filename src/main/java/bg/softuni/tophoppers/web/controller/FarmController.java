package bg.softuni.tophoppers.web.controller;

import bg.softuni.tophoppers.domain.entity.FarmEntity;
import bg.softuni.tophoppers.domain.entity.ProductEntity;
import bg.softuni.tophoppers.domain.service.FarmService;
import bg.softuni.tophoppers.domain.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/farms")
public class FarmController {

  private final FarmService farmService;
  private final ProductService productService;

  public FarmController(FarmService farmService, ProductService productService) {
    this.farmService = farmService;
    this.productService = productService;
  }

  @GetMapping
  public List<FarmEntity> getAllFarms() {
    return this.farmService.getAllFarms();
  }

  @GetMapping("/{farmId}")
  public ResponseEntity<FarmEntity> getFarm(@PathVariable String farmId) {
    Optional<FarmEntity> theFarm = this.farmService.getFarmById(farmId);

    return theFarm.map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
  }

  @GetMapping("/{farmId}/products")
  public ResponseEntity<Set<ProductEntity>> getFarmProducts(@PathVariable String farmId) {
    Optional<FarmEntity> theFarm = this.farmService.getFarmById(farmId);

    return theFarm
        .map(FarmEntity::getProducts)
        .map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
  }

  @GetMapping("/{farmId}/products/{productId}")
  public ResponseEntity<ProductEntity> getFarmProduct(@PathVariable String farmId,
                                                      @PathVariable String productId) {
    Optional<ProductEntity> theProduct = this.productService.getProductById(productId);

    return theProduct
        .filter(p -> p.getFarm().getId().equals(farmId))
        .map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
  }

}
