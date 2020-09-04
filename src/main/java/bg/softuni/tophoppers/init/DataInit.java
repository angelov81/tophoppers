package bg.softuni.tophoppers.init;

import bg.softuni.tophoppers.domain.service.CategoryService;
import bg.softuni.tophoppers.domain.service.FarmService;
import bg.softuni.tophoppers.domain.service.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
public class DataInit implements CommandLineRunner {

  private final FarmService farmService;
  private final CategoryService categoryService;
  private final ProductService productService;

  public DataInit(FarmService farmService, CategoryService categoryService, ProductService productService) {
    this.farmService = farmService;
    this.categoryService = categoryService;
    this.productService = productService;
  }

  @Override
  public void run(String... args) {
    this.farmService.initDefaultFarm();
    this.categoryService.initCategories();
    initMeat();
    initFish();
    initBakery();
  }

  private void initMeat() {
    this.productService.initProduct(
        "Steak",
        "Buffalo Steak",
        new BigDecimal("120"),
        LocalDateTime.of(2021, 9, 9, 23, 1),
        "MEAT");
  }

  private void initFish() {
    this.productService.initProduct(
        "SeaBass",
        "Sea Bass Filet",
        new BigDecimal("85"),
        LocalDateTime.of(2020, 9, 23, 23, 1),
        "FISH_AND_SEAFOOD");
  }

  private void initBakery() {
    this.productService.initProduct(
        "Bread",
        "Home made bread",
        new BigDecimal("2"),
        LocalDateTime.of(2020, 9, 12, 14, 0),
        "BAKERY");
  }

}
