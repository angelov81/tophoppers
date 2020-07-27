package bg.softuni.tophoppers.domain.service;

import bg.softuni.tophoppers.domain.entity.CategoryEntity;
import bg.softuni.tophoppers.domain.entity.CategoryName;

public interface CategoryService {

  void initCategories();

  CategoryEntity find(CategoryName categoryName);

}
