package bg.softuni.tophoppers.web.controller;

import bg.softuni.tophoppers.domain.entity.CategoryEntity;
import bg.softuni.tophoppers.domain.entity.FarmEntity;
import bg.softuni.tophoppers.domain.entity.ProductEntity;
import bg.softuni.tophoppers.domain.service.FarmService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/farms")
public class FarmController {

  private final FarmService farmService;

  public FarmController(FarmService farmService) {
    this.farmService = farmService;
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

  // TODO: Fix me !!!
  @GetMapping("/{farmId}/products/{categoryId}")
  public ResponseEntity<Set<ProductEntity>> getFarmProductsByCategory(@PathVariable String farmId,
                                                                      @PathVariable String categoryId) {
    Optional<FarmEntity> theFarm = this.farmService.getFarmById(farmId);

    return theFarm.map(f ->
        f.getProducts().stream()
            .filter(p ->
                p.getCategory().getCategoryName().equals(categoryId))
            .collect(Collectors.toSet()))
        .map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
  }

}
