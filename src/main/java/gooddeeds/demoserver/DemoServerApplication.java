package gooddeeds.demoserver;

import gooddeeds.demoserver.services.static_context_accessor.StaticContextAccessor;
import gooddeeds.demoserver.services.tcp_server.TcpServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoServerApplication.class, args);
		StaticContextAccessor.getBean(TcpServerService.class).createServer(11000);
	}

}
