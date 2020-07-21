package bg.softuni.tophoppers.domain.repository;

import bg.softuni.tophoppers.domain.entity.FarmEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FarmRepository extends JpaRepository<FarmEntity, String> {
}
