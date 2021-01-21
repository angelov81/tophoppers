package bg.softuni.tophoppers.domain.service.Impl;

import bg.softuni.tophoppers.domain.entity.AuthorityEntity;
import bg.softuni.tophoppers.domain.entity.UserEntity;
import bg.softuni.tophoppers.domain.repository.UserRepository;
import bg.softuni.tophoppers.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  @Autowired
  public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  public void initDefaultSecurityRoles() {
    if (this.userRepository.count() == 0) {
      UserEntity user = new UserEntity();
      user.setUsername("user");
      user.setPassword(passwordEncoder.encode("pass"));
      user.setEmail("user@example.com");
      user.setAddress("Local");
      user.setAge(39);
      user.setFirstName("User");
      user.setLastName("Default");

      AuthorityEntity authorityEntity = new AuthorityEntity();
      authorityEntity.setName("ROLE_USER");
      authorityEntity.setUser(user);

      user.setAuthorities(List.of(authorityEntity));
      this.userRepository.save(user);

      UserEntity admin = new UserEntity();
      admin.setUsername("admin");
      admin.setPassword(passwordEncoder.encode("pass"));
      admin.setEmail("admin@example.com");
      admin.setAddress("Local");
      admin.setAge(39);
      admin.setFirstName("Admin");
      admin.setLastName("Default");

      AuthorityEntity adminUserAuthorityEntity = new AuthorityEntity();
      adminUserAuthorityEntity.setName("ROLE_USER");
      adminUserAuthorityEntity.setUser(admin);

      AuthorityEntity adminAdminAuthorityEntity = new AuthorityEntity();
      adminAdminAuthorityEntity.setName("ROLE_ADMIN");
      adminAdminAuthorityEntity.setUser(admin);

      admin.setAuthorities(List.of(adminUserAuthorityEntity, adminAdminAuthorityEntity));
      this.userRepository.save(admin);
    }
  }

}
