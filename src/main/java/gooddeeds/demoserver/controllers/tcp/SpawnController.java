package gooddeeds.demoserver.controllers.tcp;

import gooddeeds.demoserver.services.player.PlayerService;
import gooddeeds.demoserver.services.tcp_controller.business.ITcpController;
import gooddeeds.demoserver.services.tcp_server.business.TcpSocketThread;

public class SpawnController implements ITcpController {
    private PlayerService playerService;

    public SpawnController(PlayerService playerService)
    {
        this.playerService = playerService;
    }

    @Override
    public String getRouteKey() {
        return "spawn";
    }

    @Override
    public String handle(String message, TcpSocketThread socketThread) {
        var chunks = message.split(" ");
        if (chunks.length < 2) {
            return "<|ERR|>";
        }

        var playerKey = chunks[1];
        var player = this.playerService.getPlayerByKey(playerKey);
        if (player == null) {
            return "<|ERR|>";
        }

        player.socketThread = socketThread;

        socketThread.tcpServerService.broadcast("spawn " + playerKey + " " + player.user.getUsername());

        return "<|OK|>";
    }
}
