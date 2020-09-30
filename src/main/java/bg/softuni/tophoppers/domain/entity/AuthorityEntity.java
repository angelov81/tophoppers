package bg.softuni.tophoppers.domain.entity;

import javax.persistence.*;

@Entity
@Table(name = "authorities")
public class AuthorityEntity extends BaseEntity {

  private String name;
  private UserEntity user;

  @Column(nullable = false)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  public UserEntity getUser() {
    return user;
  }

  public void setUser(UserEntity user) {
    this.user = user;
  }
}
