package com.onlinehotelreservations.entities;

import com.onlinehotelreservations.shared.enums.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private int roleId;

    @Column(nullable = false)
    private int username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank(message = "Phone is required")
    @Pattern(regexp = "(0)+([0-9]{9})\\b", message = "Phone not in correct format")
    private String phoneNumber;

    @NotBlank
    @NotNull
    private String fullName;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    private UserStatus status = UserStatus.ACTIVE;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date birthday;

    @Column(nullable = false)
    private int avatar;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @Builder.Default
    private Date createdAt = new Date();

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @Builder.Default
    private Date updatedAt = new Date();

    @Column(nullable = false)
    private int updatedBy;

    @Column(nullable = false)
    private boolean isActive;
}
