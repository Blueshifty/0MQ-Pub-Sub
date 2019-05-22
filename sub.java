import org.zeromq.SocketType;
import org.zeromq.ZMQ;
import org.zeromq.ZMQ.Socket;
import org.zeromq.ZContext;

public class sub
{
    public static void main(String[] args)throws Exception
    {
        ZContext baglam = new ZContext();
        Socket subSocket = baglam.createSocket(SocketType.SUB);
        String uri = "tcp://142.93.233.0:5217";
        String emir = "Subscriber";
        subSocket.connect(uri);
        subSocket.subscribe(args[0].getBytes(ZMQ.CHARSET));
        System.out.println(uri+" Adresine ["+ args[0]+"] Grubuna Subscribe Olundu.");
        while(!emir.equals("3"))
        {
           String adres = subSocket.recvStr();
           emir = subSocket.recvStr();
           itaatEt(emir);
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

    public static void itaatEt(String arg)throws Exception{
        switch(arg){
            case "1":{
                System.out.println("Interneti Kes Emri Geldi.");
                Process runtime = Runtime.getRuntime().exec("netsh advfirewall firewall add rule name=\"Block Ports\" protocol=TCP remoteport=80 action=block dir=OUT");
                runtime = Runtime.getRuntime().exec("netsh advfirewall firewall add rule name=\"Block Ports\" protocol=TCP remoteport=80 action=block dir=IN");
                runtime = Runtime.getRuntime().exec("netsh advfirewall firewall add rule name=\"Block Ports\" protocol=TCP remoteport=8080 action=block dir=OUT"); 
                runtime = Runtime.getRuntime().exec("netsh advfirewall firewall add rule name=\"Block Ports\" protocol=TCP remoteport=8080 action=block dir=IN");
                runtime = Runtime.getRuntime().exec("netsh advfirewall firewall add rule name=\"Block Ports\" protocol=TCP remoteport=443 action=block dir=OUT");
                runtime = Runtime.getRuntime().exec("netsh advfirewall firewall add rule name=\"Block Ports\" protocol=TCP remoteport=443 action=block dir=IN");
                break;
            }
            case "2":{
                System.out.println("Interneti Ac Emri Geldi.");
                Process runtime = Runtime.getRuntime().exec("netsh advfirewall firewall delete rule name=\"Block Ports\"");
                break;
            }
            case "3":{
                System.out.println("Iletisimi Kesme Emri Gonderildi.");
                break;
            }
            default:{
                System.out.println("Iletisimde Bir Hata Olustu!");
            }
        }
    }
}