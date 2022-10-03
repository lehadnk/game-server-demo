package gooddeeds.demoserver.services.tcp_controller.communication.plugin;

import gooddeeds.demoserver.controllers.tcp.SpawnController;
import gooddeeds.demoserver.services.player.PlayerService;
import gooddeeds.demoserver.services.tcp_controller.business.ITcpController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class TcpControllerDependencyProvider {
    @Autowired
    private PlayerService playerService;

    public List<ITcpController> provideDependencies()
    {
        var controllerList = new LinkedList<ITcpController>();
        controllerList.add(new SpawnController(this.playerService));
        return controllerList;
    }
}
