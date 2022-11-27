import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UdpSender {
    public static void main(String[] args) {
        try(DatagramSocket ds = new DatagramSocket()) {
            String msg = java.time.Clock.systemUTC().instant() + " Hi there! How are you?!";
            System.out.println("Message size: " + msg.getBytes().length);
            InetAddress address = InetAddress.getByName("127.0.0.1");
            DatagramPacket dp = new DatagramPacket(msg.getBytes(), msg.length(), address, 3333);
            System.out.println("Sending UDP packet");
            ds.send(dp);
        } catch (Exception ec) {
            ec.printStackTrace();
        }
    }
}
