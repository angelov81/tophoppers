package bg.softuni.tophoppers.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class RoleEntity extends BaseEntity {

  private String name;

  public RoleEntity() {
  }

  public RoleEntity(String role) {
    this.name = role;
  }

  @Column(name = "name", unique = true)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
