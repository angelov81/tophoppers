package bg.softuni.tophoppers.init;

import bg.softuni.tophoppers.domain.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CategoryInit implements CommandLineRunner {

  private final CategoryService categoryService;

  public CategoryInit(CategoryService categoryService) {
    this.categoryService = categoryService;
  }

  @Override
  public void run(String... args) throws Exception {
    this.categoryService.initCategories();
  }
}
