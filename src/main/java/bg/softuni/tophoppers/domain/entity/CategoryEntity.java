package bg.softuni.tophoppers.domain.entity;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class CategoryEntity extends BaseEntity {

  private CategoryName categoryName;
  private String description;

  public CategoryEntity() {
  }

  public CategoryEntity(CategoryName categoryName, String description) {
    this.categoryName = categoryName;
    this.description = description;
  }

  @Enumerated(EnumType.STRING)
  public CategoryName getCategoryName() {
    return categoryName;
  }

  public void setCategoryName(CategoryName categoryName) {
    this.categoryName = categoryName;
  }

  @Column(name = "description", columnDefinition = "TEXT")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
