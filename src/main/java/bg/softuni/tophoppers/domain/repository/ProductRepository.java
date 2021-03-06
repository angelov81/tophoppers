package bg.softuni.tophoppers.domain.repository;

import bg.softuni.tophoppers.domain.entity.CategoryEntity;
import bg.softuni.tophoppers.domain.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, String> {

  Optional<ProductEntity> findByName(String name);

  Optional<ProductEntity> findById(String id);

  List<ProductEntity> findAllByCategory(CategoryEntity category);

}
