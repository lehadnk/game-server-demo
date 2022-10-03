package gooddeeds.demoserver.services.player;

import gooddeeds.demoserver.dto.Player;
import gooddeeds.demoserver.persistence.models.User;
import gooddeeds.demoserver.services.player.business.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    public Player login(User user)
    {
        var player = new Player();
        player.user = user;
        player.key = user.getId().toString();
        this.playerRepository.addPlayer(player);

        return player;
    }

    public Player getPlayerByKey(String key)
    {
        return this.playerRepository.getPlayer(key);
    }
}
