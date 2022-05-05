package com.onlinehotelreservations.entities;

import com.onlinehotelreservations.shared.enums.SexType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "participants")
public class ParticipantEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private String email;

    @NotBlank(message = "Phone is required")
    @Pattern(regexp = "(0)+([0-9]{9})\\b", message = "Phone not in correct format")
    private String phoneNumber;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SexType sex;

    @Column(nullable = false)
    private boolean isActive;

    @Column(nullable = false)
    private String avatar;

    @Column(nullable = false)
    private String info_description;
}
