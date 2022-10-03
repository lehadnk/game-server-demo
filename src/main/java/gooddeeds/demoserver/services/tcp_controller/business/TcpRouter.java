package gooddeeds.demoserver.services.tcp_controller.business;

import gooddeeds.demoserver.services.tcp_controller.communication.plugin.TcpControllerDependencyProvider;
import gooddeeds.demoserver.services.tcp_server.TcpServerService;
import gooddeeds.demoserver.services.tcp_server.business.TcpSocketThread;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class TcpRouter {
    private HashMap<String, ITcpController> controllers = new HashMap<>();

    public TcpRouter(TcpControllerDependencyProvider dependencyProvider)
    {
        for(ITcpController controller: dependencyProvider.provideDependencies()) {
            this.controllers.put(controller.getRouteKey(), controller);
        }
    }

    public String routeRequest(String message, TcpSocketThread tcpSocketThread)
    {
        var chunks = message.split(" ");
        if (chunks.length < 1) {
            return "<|ERR|>";
        }

        var routeKey = chunks[0];
        var controller = this.controllers.get(routeKey);
        if (controller == null) {
            return "<|UNK|>";
        }

        return controller.handle(message, tcpSocketThread);
    }
}
