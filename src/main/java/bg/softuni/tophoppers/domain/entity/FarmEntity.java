package bg.softuni.tophoppers.domain.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "farms")
public class FarmEntity extends BaseEntity {

  private String farmName;
  private String address;
  private String email;
  private boolean isEnabled;
  private Set<ProductEntity> products;

  public FarmEntity() {
  }

  @NotNull
  @Column(name = "farm_name", nullable = false, unique = true)
  public String getName() {
    return farmName;
  }

  public void setName(String name) {
    this.farmName = name;
  }

  @NotNull
  @Column(name = "address", nullable = false)
  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  @NotNull
  @Email
  @Column(name = "email", nullable = false, unique = true)
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @NotNull
  @Column(name = "is_enabled")
  public boolean isEnabled() {
    return isEnabled;
  }

  public void setEnabled(boolean enabled) {
    this.isEnabled = enabled;
  }

  @OneToMany(mappedBy = "farm", cascade = CascadeType.ALL)
  public Set<ProductEntity> getProducts() {
    return products;
  }

  public void setProducts(Set<ProductEntity> products) {
    this.products = products;
  }
}
