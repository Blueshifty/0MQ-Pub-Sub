import org.zeromq.SocketType;
import org.zeromq.ZMQ;
import org.zeromq.ZMQ.Socket;
import org.zeromq.ZContext;


public class sub
{
    public static void main(String[] args)throws Exception
    {
         ZContext context = new ZContext();
         Socket subscriber = context.createSocket(SocketType.SUB);
         subscriber.connect("tcp://142.93.233.0:5217");
         subscriber.subscribe(args[0].getBytes(ZMQ.CHARSET));
         while (!Thread.currentThread().isInterrupted()){
            String adres = subscriber.recvStr();
            String emir = subscriber.recvStr();
            itaat_et(emir);
            if(emir.equals("3")){break;}
            }
    }

    /*                                  ***>>CMD KOMUTLARI<<*** 
    80 Portunu Kapat.
    netsh advfirewall firewall add rule name="Block Ports" protocol=TCP remoteport=80 action=block dir=OUT
    netsh advfirewall firewall add rule name="Block Ports" protocol=TCP remoteport=80 action=block dir=IN
    8080 Portunu Kapat.
    netsh advfirewall firewall add rule name="Block Ports" protocol=TCP remoteport=8080 action=block dir=OUT
    netsh advfirewall firewall add rule name="Block Ports" protocol=TCP remoteport=8080 action=block dir=IN
    443 Portunu Kapat.
    netsh advfirewall firewall add rule name="Block Ports" protocol=TCP remoteport=443 action=block dir=OUT
    netsh advfirewall firewall add rule name="Block Ports" protocol=TCP remoteport=443 action=block dir=IN
    Kuralı Silmek Icin:
    netsh advfirewall firewall delete rule name="Block Ports"
    */

    public static void itaat_et(String arg)throws Exception{
        switch(arg){
            case "1":{
                System.out.println("Interneti Kes Emri Geldi");
                Process runtime1 = Runtime.getRuntime().exec("netsh advfirewall firewall add rule name=\"Block Ports\" protocol=TCP remoteport=80 action=block dir=OUT");
                Process runtime2 = Runtime.getRuntime().exec("netsh advfirewall firewall add rule name=\"Block Ports\" protocol=TCP remoteport=80 action=block dir=IN");
                Process runtime3 = Runtime.getRuntime().exec("netsh advfirewall firewall add rule name=\"Block Ports\" protocol=TCP remoteport=8080 action=block dir=OUT"); 
                Process runtime4 = Runtime.getRuntime().exec("netsh advfirewall firewall add rule name=\"Block Ports\" protocol=TCP remoteport=8080 action=block dir=IN");
                Process runtime5 = Runtime.getRuntime().exec("netsh advfirewall firewall add rule name=\"Block Ports\" protocol=TCP remoteport=443 action=block dir=OUT");
                Process runtime6 = Runtime.getRuntime().exec("netsh advfirewall firewall add rule name=\"Block Ports\" protocol=TCP remoteport=443 action=block dir=IN");
                break;
            }
            case "2":{
                System.out.println("Interneti Ac Emri Geldi");
                Process runtime = Runtime.getRuntime().exec("netsh advfirewall firewall delete rule name=\"Block Ports\"");
                break;
            }
            case "3":{
                System.out.println("Iletisimi Kesme Emri Gonderildi");
                break;
            }
            default:{
                System.out.println("Iletisimde Bir Hata Olustu");
            }
        }
    }
}