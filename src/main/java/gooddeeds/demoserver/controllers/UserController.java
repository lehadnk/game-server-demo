package gooddeeds.demoserver.controllers;

import gooddeeds.demoserver.models.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @GetMapping("/user/me")
    public User me(
            @RequestParam(value = "name", defaultValue="World") String name
    ) {
        return new User(1, name);
    }
}
