import java.net.InetAddress;
import java.net.UnknownHostException;

public class Test7 {
    public static void main(String[] args) {


        try {
            final InetAddress localHost = InetAddress.getLocalHost();
            System.out.println("hostAddress: " + localHost.getHostAddress());
            System.out.println("hostName: " + localHost.getHostName());
        } catch (UnknownHostException e) {
            System.out.println("Get Host Info Error");
            e.printStackTrace();
        }


    }

}
