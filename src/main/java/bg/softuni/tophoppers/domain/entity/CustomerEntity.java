package bg.softuni.tophoppers.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "customers")
public class CustomerEntity extends BaseEntity {

  private String firstName;
  private String lastName;
  private Integer age;
  private String email;
  private String address;
  private String password;

  public CustomerEntity() {
  }

  @NotNull
  @Column(name = "first_name", nullable = false)
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  @NotNull
  @Column(name = "last_name", nullable = false)
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  @NotNull
  @Column(name = "age", nullable = false)
  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  @NotNull
  @Column(name = "email", nullable = false, unique = true)
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
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
  @Column(name = "password", nullable = false)
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
