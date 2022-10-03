package gooddeeds.demoserver.services.tcp_server;

import gooddeeds.demoserver.services.tcp_controller.TcpControllerService;
import gooddeeds.demoserver.services.tcp_server.business.TcpSocketThread;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

@Service
public class TcpServerService {
    @Autowired
    private TcpControllerService controllerService;
    private LinkedList<TcpSocketThread> sockets = new LinkedList<>();
    Logger logger = LoggerFactory.getLogger(this.getClass());

    public void createServer(int port)
    {
        try {
            ServerSocket server = new ServerSocket(port, 100);
            logger.info("TCP server started");

            while (true) {
                Socket socket = server.accept();
                this.sockets.add(new TcpSocketThread(socket, this, this.controllerService));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void broadcast(String message)
    {
        for (TcpSocketThread socketThread: sockets) {
            socketThread.send(message);
        }
    }
}
