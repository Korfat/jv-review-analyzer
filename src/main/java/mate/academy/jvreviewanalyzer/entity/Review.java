package mate.academy.jvreviewanalyzer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "product_id")
    private String productId;
    @Column(name = "profile_name")
    private String profileName;
    @Column(name = "comment", length = 10000)
    private String comment;

    public Review() {
    }

    public Review(String productId, String profileName, String comment) {
        this.productId = productId;
        this.profileName = profileName;
        this.comment = comment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "ReviewData{"
                + "id=" + id
                + ", profileName='" + profileName + '\''
                + ", productId='" + productId + '\''
                + ", comment='" + comment + '\''
                + '}';
    }
}