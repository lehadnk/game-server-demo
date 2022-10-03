package gooddeeds.demoserver.services.player.business;

import gooddeeds.demoserver.dto.Player;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class PlayerRepository {
    private HashMap<String, Player> players = new HashMap<>();

    public void addPlayer(Player player)
    {
        this.players.put(player.key, player);
    }

    public Player getPlayer(String key)
    {
        return this.players.get(key);
    }
}
