package bg.softuni.tophoppers.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "comments")
public class CommentEntity extends BaseEntity {

  private Integer rate;
  private String content;
  private ProductEntity product;
  private FarmEntity farm;

  public CommentEntity() {
  }

  @Column(name = "rate", nullable = false)
  public Integer getRate() {
    return rate;
  }

  public void setRate(Integer rate) {
    this.rate = rate;
  }

  @Column(name = "content", columnDefinition = "TEXT")
  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  @ManyToOne
  public ProductEntity getProduct() {
    return product;
  }

  public void setProduct(ProductEntity product) {
    this.product = product;
  }

  @ManyToOne
  public FarmEntity getFarm() {
    return farm;
  }

  public void setFarm(FarmEntity farm) {
    this.farm = farm;
  }
}
