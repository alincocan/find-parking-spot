package com.parking.findparkingspot.service;

import com.parking.findparkingspot.model.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {

    Mono<User> createUser(User user);
    Mono<User> updateUser(User user, String id);
    Mono<User> getUserById(String id);
    Flux<User> getUsers();
    Mono<Void> deleteUser(String  id);
}
