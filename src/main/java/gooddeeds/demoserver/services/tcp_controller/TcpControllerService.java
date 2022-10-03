package gooddeeds.demoserver.services.tcp_controller;

import gooddeeds.demoserver.services.tcp_controller.business.TcpRouter;
import gooddeeds.demoserver.services.tcp_server.TcpServerService;
import gooddeeds.demoserver.services.tcp_server.business.TcpSocketThread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TcpControllerService {
    @Autowired
    private TcpRouter router;

    public String handleMessage(String message, TcpSocketThread tcpSocketThread)
    {
        return this.router.routeRequest(message, tcpSocketThread);
    }
}
