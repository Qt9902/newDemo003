package com.example.demo003.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.example.demo003.Domain.User;
import com.example.demo003.Repository.UserRepository;

@Service
public class UserService {
    // rang buoc
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // phuong thuc luu du lieu
    public User handlereatUser(User user) { // khai bao mot pt moi, handlecreat nhan postmen. cac tham so json da truyen
                                            // vap handlecreatuser
        return this.userRepository.save(user); // truyen tham so user dat la user. day pt user sang repo va day no voa
                                               // phuong thuc save cua jpa
    }

    // phuong thuc delete theo id
    public void handleDeleteUser(Long Id) { // pt khong tra ve nhap vao. lay Id day id sang jpa roi delete
        this.userRepository.deleteById(Id);
    }

    // phuong thuc tim kiem tat ca
    public List<User> fenchHandleUser() {
        return this.userRepository.findAll();
    }

    // phuong thuc tim kiem theo id
    public User getByIDUser(long Id) {
        Optional<User> userOptional = this.userRepository.findById(Id);
        if (userOptional.isPresent()) {
            return userOptional.get();
        }
        return null;
    }

    // phuong thuc update data
    public User updateUser2(User updateUser) {
        User newUser = this.getByIDUser(updateUser.getId());
        if (newUser != null) {
            newUser.setEmail(updateUser.getEmail());
            newUser.setName(updateUser.getName());
            newUser.setPassWord(updateUser.getName());

            newUser = this.userRepository.save(newUser);
        }

        return newUser;
    }
}
