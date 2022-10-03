package gooddeeds.demoserver.services.tcp_server.business;

import gooddeeds.demoserver.services.tcp_controller.TcpControllerService;
import gooddeeds.demoserver.services.tcp_server.TcpServerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.Socket;

public class TcpSocketThread extends Thread {
    private TcpControllerService tcpControllerService;
    public TcpServerService tcpServerService;
    private Socket socket;
    private BufferedReader input;
    private BufferedWriter output;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public TcpSocketThread(Socket socket, TcpServerService tcpServerService, TcpControllerService tcpControllerService) throws IOException {
        this.socket = socket;
        this.tcpControllerService = tcpControllerService;
        this.tcpServerService = tcpServerService;
        this.input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        this.start();
    }

    public void run() {
        try {
            while(true) {
                var inputMessage = input.readLine();
                logger.info("Incoming message: " + inputMessage);
                this.send("<|ACK|>");

                var response = this.tcpControllerService.handleMessage(inputMessage, this);
                this.send(response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void send(String message) {
        try {
            output.write(message + "\n");
            output.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
