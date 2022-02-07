package springmvc.domain;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Product extends AbstractDomainClass{

    private String Description;
    private BigDecimal price;
    private String imageUrl;

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
