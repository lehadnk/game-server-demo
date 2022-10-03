package gooddeeds.demoserver.dto;

import gooddeeds.demoserver.persistence.models.User;
import gooddeeds.demoserver.services.tcp_server.business.TcpSocketThread;

public class Player {
    public User user;
    public String key;
    public TcpSocketThread socketThread;
}
