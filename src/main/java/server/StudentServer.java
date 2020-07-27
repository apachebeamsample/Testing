package server;

import io.grpc.BindableService;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class StudentServer {
    private static final Logger LOG = LoggerFactory.getLogger(StudentServer.class);

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Strating server");
        Server server = ServerBuilder.forPort(8089)
                .addService((BindableService) new StudentServiceImpl())
                .build();

        server.start();
        System.out.println("Server started");

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Received Shutdown Request");
            server.shutdown();
            System.out.println("Successfully stopped the server");
        }));

        server.awaitTermination();
    }
}
