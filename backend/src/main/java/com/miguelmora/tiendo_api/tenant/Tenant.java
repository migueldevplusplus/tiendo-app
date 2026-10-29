package com.miguelmora.tiendo_api.tenant;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "tenants")
public class Tenant {

    @Id
    @GeneratedValue
    @UuidGenerator(style = UuidGenerator.Style.VERSION_7)
    private UUID id;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(name = "phone_number",length = 20, nullable = false)
    private String phoneNumber;

    @Column(length = 50, nullable = false, unique = true)
    private String slug;

    @Column
    private String address;

    @Column(name = "logo_url")
    private String logoUrl;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false, nullable = false)
    private OffsetDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private OffsetDateTime updatedAt;

    @Column(name = "disabled_at")
    private OffsetDateTime disabledAt;

    public boolean isActive(){
        return disabledAt == null;
    }

    public void enable(){
        disabledAt = null;
    }

    public void disable(){
        if(disabledAt == null){
            disabledAt = OffsetDateTime.now();
        }
    }

    public Tenant(String name, String phoneNumber, String slug) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.slug = slug;
    }

    public void updateProfile(String name, String phoneNumber, String address, String logoUrl) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.logoUrl = logoUrl;
    }
}
