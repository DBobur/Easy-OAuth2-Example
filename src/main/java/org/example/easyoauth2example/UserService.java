package org.example.easyoauth2example;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserEntity saveIfExist(UserEntity user) {
        return userRepository.findByEmail(user.getEmail())
                .orElseGet(() -> userRepository.save(user));
    }

}
