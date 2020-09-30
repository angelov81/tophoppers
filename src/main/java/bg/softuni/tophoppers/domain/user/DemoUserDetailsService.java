package bg.softuni.tophoppers.domain.user;

import bg.softuni.tophoppers.domain.entity.AuthorityEntity;
import bg.softuni.tophoppers.domain.entity.UserEntity;
import bg.softuni.tophoppers.domain.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class DemoUserDetailsService implements UserDetailsService {

  private final UserRepository userRepository;

  public DemoUserDetailsService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String username) {
    Optional<UserEntity> userEntity = this.userRepository.findByUsername(username);

    return userEntity
        .map(this::map)
        .orElseThrow(() -> new UsernameNotFoundException("User" + username + " not found!"));
  }

  private UserDetails map(UserEntity userEntity) {
    return new User(
        userEntity.getUsername(),
        userEntity.getPassword(),
        userEntity.getAuthorities()
            .stream()
            .map(this::map)
            .collect(Collectors.toList()));
  }

  private GrantedAuthority map(AuthorityEntity authorityEntity) {
    return new SimpleGrantedAuthority(authorityEntity.getName());
  }

}
