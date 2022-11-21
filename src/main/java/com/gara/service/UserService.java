package com.gara.service;

import com.gara.entity.User;
import com.gara.enums.UserStatus;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;
import java.util.List;
import java.util.Optional;

@Slf4j
@ApplicationScoped
public class UserService {

    @Transactional
    public void createUser(String name) {
        User user = buildUser(name);
        user.persist();
    }

    public List<User> getUsers() {
        return User.findAll().list();
    }

    public User getUser(Long id) {
        Optional<User> optionalUser = Optional.ofNullable(User.findById(id));
        if (optionalUser.isEmpty()) {
            throw new NotFoundException();
        }
        return optionalUser.get();
    }

    @Transactional
    public void activateUser(Long id) {
        Optional<User> optionalUser = Optional.ofNullable(User.findById(id));
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setStatus(UserStatus.ACTIVE);
            user.persist();
        }
    }

    private User buildUser(String name) {
        return User.builder()
                .name(name)
                .status(UserStatus.INACTIVE)
                .build();
    }

}
