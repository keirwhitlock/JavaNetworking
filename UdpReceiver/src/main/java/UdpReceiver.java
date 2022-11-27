import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpReceiver {
    public static void main(String[] args) {
        System.out.println("Creating socket");
        try(DatagramSocket ds = new DatagramSocket(3333)) {
            DatagramPacket dp = new DatagramPacket(new byte[51], 51);

            System.out.println("Ready to receive messages");
            while (true){
                ds.receive(dp);
                String msg = "";
                for(byte b: dp.getData()) {
                    msg += Character.toString(b);
                }
                System.out.println(msg);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
