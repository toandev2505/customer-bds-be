package com.chude2.chude2.api;

import com.chude2.chude2.entity.UserEntity;
import com.chude2.chude2.repository.UserRepository;
import com.chude2.chude2.security.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@RestController(value = "apiOfAuthentication")
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthAPI {
    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody Map<String, String> loginData) {
        String username = loginData.get("username");
        String password = loginData.get("password");

        UserEntity user = userRepository.findByUserName(username);

        if (user != null && user.getPassword().equals(password)) {
            String jwt = jwtProvider.generateToken(username);
            return ResponseEntity.ok(Collections.singletonMap("token", jwt));
        }

        return ResponseEntity.status(401).body("Tài khoản hoặc mật khẩu không chính xác");
    }
}
