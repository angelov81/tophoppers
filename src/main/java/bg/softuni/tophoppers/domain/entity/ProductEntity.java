package bg.softuni.tophoppers.domain.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "products")
public class ProductEntity extends BaseEntity {

  private String name;
  private String description;
  private BigDecimal price;
  private LocalDateTime expiresOn;
  private CategoryEntity category;
  private FarmEntity farm;

  public ProductEntity() {
  }

  @Column(name = "name", nullable = false, unique = true)
  @Length(min = 3, max = 20)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Column(name = "description", columnDefinition = "TEXT")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Column(name = "price")
  @DecimalMin(value = "0")
  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  @Column(name = "expires_on", nullable = false)
  public LocalDateTime getExpiresOn() {
    return expiresOn;
  }

  public void setExpiresOn(LocalDateTime expiresOn) {
    this.expiresOn = expiresOn;
  }

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  public CategoryEntity getCategory() {
    return category;
  }

  public void setCategory(CategoryEntity category) {
    this.category = category;
  }

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  public FarmEntity getFarm() {
    return farm;
  }

  public void setFarm(FarmEntity farm) {
    this.farm = farm;
  }
}
