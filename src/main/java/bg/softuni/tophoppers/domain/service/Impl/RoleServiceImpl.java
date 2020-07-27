package bg.softuni.tophoppers.domain.service.Impl;

import bg.softuni.tophoppers.domain.entity.RoleEntity;
import bg.softuni.tophoppers.domain.repository.RoleRepository;
import bg.softuni.tophoppers.domain.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class RoleServiceImpl implements RoleService {

  private final RoleRepository roleRepository;

  public RoleServiceImpl(RoleRepository roleRepository) {
    this.roleRepository = roleRepository;
  }

  @PostConstruct
  public void initRoles() {
    if (this.roleRepository.count() == 0) {
      RoleEntity customer = new RoleEntity("CUSTOMER");
      RoleEntity farm = new RoleEntity("FARM");
      RoleEntity admin = new RoleEntity("ADMIN");

      this.roleRepository.save(customer);
      this.roleRepository.save(farm);
      this.roleRepository.save(admin);
    }
  }

}
