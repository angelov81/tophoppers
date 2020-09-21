package bg.softuni.tophoppers.domain.service.Impl;

import bg.softuni.tophoppers.domain.entity.CategoryEntity;
import bg.softuni.tophoppers.domain.entity.CategoryName;
import bg.softuni.tophoppers.domain.repository.CategoryRepository;
import bg.softuni.tophoppers.domain.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

  private final CategoryRepository categoryRepository;
  private final ModelMapper modelMapper;

  public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper) {
    this.categoryRepository = categoryRepository;
    this.modelMapper = modelMapper;
  }

  @Override
  public void initCategories() {
    if (categoryRepository.count() == 0) {
      Arrays.stream(CategoryName.values())
          .forEach(categoryName -> this.categoryRepository
              .save(new CategoryEntity(
                  categoryName, String.format("Description for %s", categoryName.name()))));
    }
  }

  @Override
  public CategoryEntity find(CategoryName categoryName) {
    return this.categoryRepository
        .findByCategoryName(categoryName).orElse(null);
  }

  @Override
  public List<CategoryEntity> getAllCategories() {
    return this.categoryRepository.findAll();
  }

  @Override
  public Optional<CategoryEntity> getCategoryById(String categoryId) {
    return this.categoryRepository.findById(categoryId);
  }


}
