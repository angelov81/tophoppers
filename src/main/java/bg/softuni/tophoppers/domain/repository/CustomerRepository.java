package bg.softuni.tophoppers.domain.repository;

import bg.softuni.tophoppers.domain.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, String> {

  Optional<CustomerEntity> findByEmail(String email);

}
