package bg.softuni.tophoppers.domain.service;

import bg.softuni.tophoppers.domain.entity.CategoryEntity;
import bg.softuni.tophoppers.domain.entity.CategoryName;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

  void initCategories();

  CategoryEntity find(CategoryName categoryName);

  List<CategoryEntity> getAllCategories();

  Optional<CategoryEntity> getCategoryById(String categoryId);
}
