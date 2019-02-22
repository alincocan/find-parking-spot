package com.parking.findparkingspot.resource;


import com.parking.findparkingspot.model.User;
import com.parking.findparkingspot.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/users")
public class UserResource {

    private final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public Mono<User> getById(@PathVariable String id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public Mono<User> save(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/{id}")
    public Mono<User> update(@PathVariable String id, @RequestBody User user) {
        return userService.updateUser(user, id);
    }
}
