package com.onlinehotelreservations.config;

import com.onlinehotelreservations.entities.EventEntity;
import com.onlinehotelreservations.entities.NewsEntity;
import com.onlinehotelreservations.entities.RoleEntity;
import com.onlinehotelreservations.entities.UserEntity;
import com.onlinehotelreservations.repositories.RoleRepository;
import com.onlinehotelreservations.repositories.UserRepository;
import com.onlinehotelreservations.services.EventService;
import com.onlinehotelreservations.services.NewsService;
import com.onlinehotelreservations.shared.enums.EventType;
import com.onlinehotelreservations.shared.enums.Role;
import com.onlinehotelreservations.shared.enums.UserStatus;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Configuration
public class DataSeedingListener implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private EventService eventService;

    @Autowired
    private NewsService newsService;

    @Value("${jwt-key}")
    private String signingKey;

    private void addRoleIfMissing(Role role) {
        if (roleRepository.findByName(role.toString()) == null) {
            RoleEntity roleEntity = new RoleEntity();
            roleEntity.setName(role.toString());
            roleRepository.save(roleEntity);
        }
    }

    private void addUserIfMissing(String username, String password, Role... roles) {
        if (!userRepository.findByEmail(username).isPresent()) {

            RoleEntity roleIsExists = new RoleEntity();
            for (Role role : roles) {
                roleIsExists = roleRepository.findByName(role.toString());
            }
            userRepository.save(UserEntity.builder().email(username).password(new BCryptPasswordEncoder().encode(password))

                    .roleId(roleIsExists.getId())
                    .fullName("Khanh nguyen")
                    .phoneNumber("0382189922")
                    .birthday(new Date())
                    .status(UserStatus.ACTIVE)
                    .build());
        }
    }

    private void addEventsIfMissing() {
        for (int i = 0; i < 100; ++i) {
            if (this.eventService.getByTitle(("Title" + i)) == null) {
                EventEntity eventEntity = EventEntity.builder()
                        .address("Mong A" + i)
                        .countNeedParticipate(69)
                        .countRegistered(68)
                        .createdBy("ADMIN")
                        .description("Des")
                        .descriptionParticipant("Des")
                        .descriptionRequired("Des")
                        .countParticipated(69)
                        .startAt(new Date())
                        .endAt(new Date())
                        .type(EventType.PARTY)
                        .title("Title" + i)
                        .imagesStr("ok")
                        .build();
                eventEntity = this.eventService.create(eventEntity);
            }
        }
    }

    private void addNewsIfMissing() {
        for (int i = 0; i < 100; ++i) {
            if (this.newsService.getByTitle(("Title" + i)) == null) {
                NewsEntity newsEntity = NewsEntity.builder()
                        .title("Title" + i)
                        .imagesStr("A")
                        .description("OK")
                        .countView(10)
                        .build();
                this.newsService.create(newsEntity);
            }
        }
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        addRoleIfMissing(Role.ROLE_ADMIN);
        addRoleIfMissing(Role.ROLE_USER);
        addUserIfMissing("khanh1025@gmail.com", "123456789aaA", Role.ROLE_USER);
        addUserIfMissing("khanhadmin1025@gmail.com", "123456789aaA", Role.ROLE_USER);
        addEventsIfMissing();

        for (int i = 0; i < 15; ++i) {
            String username = "khanh1025" + i + "@gmail.com";
            addUserIfMissing(username, "123456789aaA", Role.ROLE_ADMIN, Role.ROLE_USER);
        }

        if (signingKey == null || signingKey.length() == 0) {
            String jws = Jwts.builder()
                    .setSubject("kunlezIsme")
                    .signWith(SignatureAlgorithm.HS256, "kunlezIsmeApi").compact();

            System.out.println("Use this jwt key:");
            System.out.println("jwt-key=" + jws);
        }
    }
}
