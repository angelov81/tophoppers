package bg.softuni.tophoppers.domain.repository;

import bg.softuni.tophoppers.domain.entity.CategoryEntity;
import bg.softuni.tophoppers.domain.entity.CategoryName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, String> {

  Optional<CategoryEntity> findByCategoryName(CategoryName category);

}
