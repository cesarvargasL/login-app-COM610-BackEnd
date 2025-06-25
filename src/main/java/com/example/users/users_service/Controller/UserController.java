package com.example.users.users_service.Controller;

import com.example.users.users_service.Security.FirebaseTokenHolder;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UserController {

    @GetMapping("/api/user/userInfo")
    public Map<String, Object> me(Authentication auth) {
        var user = (FirebaseTokenHolder) auth.getPrincipal();
        return Map.of(
                "uid",     user.getUid(),
                "email",   user.getEmail(),
                "name",    user.getName(),
                "picture", user.getPicture()
        );
    }
    @GetMapping("/api/public/test")
    public String testPublic() {
        return "Backend activo y accesible";
    }
    @GetMapping("/api/public/health")
    public String healthCheck() {
        return "Backend activo";
    }

}
