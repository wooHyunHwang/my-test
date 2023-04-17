package socket.client;

import java.net.Socket;

public class MultiClient {

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 5252);
        System.out.println("연결 성공");
        Receiver receiver = new Receiver(socket);
        Sender sender = new Sender(socket);

        receiver.start();
        sender.start();
    }

}
