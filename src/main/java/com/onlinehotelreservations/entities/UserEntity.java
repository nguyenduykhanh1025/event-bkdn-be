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

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @NotBlank(message = "Fist name is required")
    @NotNull
    private String firstName;

    @NotBlank(message = "Last name is required")
    @NotNull
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    private UserStatus status = UserStatus.ACTIVE;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date birthday;

    @Column(name = "tel_number")
    @NotBlank(message = "Phone is required")
    @Pattern(regexp = "(0)+([0-9]{9})\\b", message = "Phone not in correct format")
    private String phone;

}
