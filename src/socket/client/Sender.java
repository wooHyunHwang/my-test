package socket.client;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Sender extends Thread {
    Socket socket;
    DataOutputStream out;

    public Sender(Socket socket) throws IOException {
        // 초기화와 동시에 스트림도 잡아주면 효율적
        this.socket = socket;
        out = new DataOutputStream(socket.getOutputStream());
        // socket.getOutputStream을 그대로 형변환 해도 된다.
    }

    @Override
    public void run() {
        while(out != null) {
            System.out.print("당신>");
            Scanner scan = new Scanner(System.in);

            try {
                out.writeUTF(scan.nextLine());
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
