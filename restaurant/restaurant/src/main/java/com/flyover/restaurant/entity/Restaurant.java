package com.flyover.restaurant.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@AttributeOverrides({
        @AttributeOverride(name = "uuid", column = @Column(name = "restaurant_id"))
})
@Table(name="restaurants")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "restaurant_id")
@DynamicUpdate
@Data
public class Restaurant extends BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    @Column(name="restaurant_name")
    private String restaurantName;
    @Column(name="restaurant_Onboard_date")
    private String RestaurantOnboardDate;
    @Column(name="restaurant_email_address")
    private String restaurantEmailId;
    @Column(name="restaurant_mobile_number")
    private String restaurantMobileNumber;
    @Column(name="restaurant_status")
    private int restaurantIsEnabled;
    @Column(name="restaurant_type")
    private int restaurantType;
    @Column(name="restaurant_referral_code")
    private String restaurantReferralCode;
    @Column(name="restaurant_referred_by")
    private String restaurantReferredBy;
    @Column(name="restaurant_image")
    private String restaurantImage;
    @Column(name="restaurant_address")
    private String restaurantAddress;
    @Column(name="restaurant_rating")
    private float restaurantRating;
    @CreationTimestamp
    @Column(name = "created_at", insertable = false, updatable = false, nullable = false)
    private Timestamp created_at;
    @UpdateTimestamp
    @Column(name = "updated_at", insertable = false, updatable = false, nullable = false)
    private Timestamp updated_at;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User ownerId;


}
