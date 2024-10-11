package com.example.demo003.Controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo003.Domain.User;
import com.example.demo003.Service.UserService;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/table0003/")
    public User creatNewUser(@RequestBody User postMenUser) { // mapping json va cac thuoc tinh da khai bao o user
        User newUser = this.userService.handlereatUser(postMenUser); // day postmen sang handlecreat
        return newUser; // phuong thuc co return. tra ve json
    }

    // deleteUser theo id
    @DeleteMapping("/table0003/{Id}") // Id
    public String deleteUser(@PathVariable("Id") Long Id) { // lay Id tra ve String. gan tam so Id day Id sang ben
                                                            // service
        this.userService.handleDeleteUser(Id);
        return "delete_User" + " : " + Id;
    }

    // phuong thuc get lay tat ca du lieu
    @GetMapping("/table0003/")
    public List<User> fenchUser() {
        return this.userService.fenchHandleUser();
    }

    // phuong thuc get lay du lieu theo id
    @GetMapping("/table0003/{Id}")
    public User getById(@PathVariable("Id") long Id) {
        return this.userService.getByIDUser(Id);
    }

    // sua xoa
    @PutMapping("/table0003/")
    public User updateData(@RequestBody User user) {
        User newUser = this.userService.updateUser2(user);
        return newUser;
    }
}
