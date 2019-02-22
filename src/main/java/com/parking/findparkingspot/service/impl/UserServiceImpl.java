package com.parking.findparkingspot.service.impl;

import com.parking.findparkingspot.model.User;
import com.parking.findparkingspot.repository.UserRepository;
import com.parking.findparkingspot.service.UserService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service("userService")
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Mono<User> createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Mono<User> updateUser(User user, String id) {
        return userRepository.findById(id).doOnSuccess(
                dbUser -> {
                    dbUser.setFirstName(user.getFirstName());
                    dbUser.setLastName(user.getLastName());
                    dbUser.setPhoneNumber(user.getPhoneNumber());
                    userRepository.save(dbUser);
                }
        ).switchIfEmpty(Mono.error(new Exception("User not found")));
    }

    @Override
    public Mono<User> getUserById(String id) {
        return userRepository.findById(id)
                .switchIfEmpty(Mono.error(new Exception("User not found")));
    }

    @Override
    public Flux<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public Mono<Void> deleteUser(String id) {
        return userRepository
                .findById(id).
                        doOnSuccess(userRepository::delete)
                .flatMap(user -> Mono.empty());
    }
}
