package gooddeeds.demoserver.controllers.http;

import gooddeeds.demoserver.controllers.http.responses.HttpResponse;
import gooddeeds.demoserver.services.player.PlayerService;
import gooddeeds.demoserver.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private PlayerService playerService;

    @GetMapping("/user/me")
    public HttpResponse login(
            @RequestParam(value = "username") String name,
            @RequestParam(value = "password") String password
    ) {
        var user = this.userService.getUserByUsernameAndPassword(name, password);
        if (user == null) {
            return new HttpResponse("Incorrect password");
        }

        this.playerService.login(user);

        return new HttpResponse(user);
    }
}
