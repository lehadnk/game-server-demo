package gooddeeds.demoserver.services.tcp_controller.business;

import gooddeeds.demoserver.services.tcp_server.TcpServerService;
import gooddeeds.demoserver.services.tcp_server.business.TcpSocketThread;

public interface ITcpController {
    public String getRouteKey();
    public String handle(String message, TcpSocketThread tcpSocketThread);
}
