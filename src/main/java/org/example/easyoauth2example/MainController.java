package org.example.easyoauth2example;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Collections;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class MainController {

    private final UserService userService;

    @GetMapping("/")
    public ResponseEntity<?> user(@AuthenticationPrincipal OAuth2User oAuth2User) {

        String email = oAuth2User.getAttribute("email");
        String name = oAuth2User.getAttribute("name");
        String id = oAuth2User.getName();

        UserEntity userEntity = UserEntity.builder()
                .clientId(id)
                .name(name)
                .email(email)
                .build();
        userService.saveIfExist(userEntity);
        return ResponseEntity.ok(userEntity);
    }


}
