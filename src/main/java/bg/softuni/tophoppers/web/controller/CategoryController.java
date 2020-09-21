package bg.softuni.tophoppers.web.controller;

import bg.softuni.tophoppers.domain.entity.CategoryEntity;
import bg.softuni.tophoppers.domain.entity.ProductEntity;
import bg.softuni.tophoppers.domain.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/categories")
public class CategoryController {

  private final CategoryService categoryService;

  public CategoryController(CategoryService categoryService) {
    this.categoryService = categoryService;
  }

  @GetMapping
  public List<CategoryEntity> getAllCategories() {
    return this.categoryService.getAllCategories();
  }

  @GetMapping("/{categoryId}")
  public ResponseEntity<CategoryEntity> getCategory(@PathVariable String categoryId) {
    Optional<CategoryEntity> theCategory = this.categoryService.getCategoryById(categoryId);

    return theCategory
        .map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
  }

  @GetMapping("/{categoryId}/products")
  public ResponseEntity<Set<ProductEntity>> getProductsByCategory(@PathVariable String categoryId) {
    Optional<CategoryEntity> theCategory = this.categoryService.getCategoryById(categoryId);

    return theCategory
        .map(CategoryEntity::getProducts)
        .map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
  }

}
