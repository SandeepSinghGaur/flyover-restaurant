package com.flyover.restaurant.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;


@Entity
@AttributeOverrides({
        @AttributeOverride(name = "uuid", column = @Column(name = "user_id"))
})
@Table(name="users")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "user_id")
@DynamicUpdate
@Data
public class User extends BaseEntity implements Serializable, UserDetails {
    @Serial
    private static final long serialVersionUID = 1L;
    @Column(name="user_name")
    private String userName;
    @Column(name="user_last_name")
    private String userFirstName;
    @Column(name="user_first_name")
    private String userLatName;
    @Column(name="user_birth_date")
    private String userBirthDate;
    @Column(name="user_email_address")
    private String userEmailId;
    @Column(name="user_mobile_number")
    private String userMobileNumber;
    @Column(name="user_status")
    private int userIsEnabled;
    @Column(name="user_gender",length = 1)
    private char userGender;
    @Column(name="user_referral_code")
    private String userReferralCode;
    @Column(name="user_referred_by")
    private String userReferredBy;
    @Column(name="user_image")
    private String userImage;
    @Column(name="password")
    private String userPassword;
    @Column(name="user_address")
    private String userAddress;
    @CreationTimestamp
    @Column(name = "created_at",  nullable = false)
    private Timestamp created_at;
    @UpdateTimestamp
    @Column(name = "updated_at",  nullable = false)
    private Timestamp updated_at;
    @OneToMany(mappedBy = "ownerId", cascade = CascadeType.ALL)
    private List<Restaurant> restaurants = new ArrayList<>();

    public User() {
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.userPassword;
    }

    @Override
    public String getUsername() {
        return this.userMobileNumber;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
