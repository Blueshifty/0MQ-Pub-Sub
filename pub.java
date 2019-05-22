import org.zeromq.SocketType;
import org.zeromq.ZMQ;
import org.zeromq.ZMQ.Socket;
import org.zeromq.ZContext;
import java.util.Scanner;

public class pub
{
    public static void main(String[] args) throws Exception
    {
        ZContext baglam = new ZContext();
        ZMQ.Socket pubSocket = baglam.createSocket(SocketType.PUB);
        pubSocket.bind("tcp://*:5217");
        while(true)
        {
            String secilenGrup = grupSec();
            menuYazdir();
            String emir = emirVer();
            for(int i = 0; i < secilenGrup.length(); ++i)
            {
                pubSocket.sendMore(String.valueOf(secilenGrup.charAt(i)));
                pubSocket.send(emir);
            }
            Thread.sleep(1000);//Kaliteli Iletisim Icin.
        }
    }

    public static String grupSec()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Grup Listesi:");
        System.out.println("A - Sadece A Grubuna Gonder.");
        System.out.println("B - Sadece B Grubuna Gonder.");
        System.out.println("AB - Her Iki Grubada Gonder.");
        System.out.println("Seceneklerden Birini Girin:");
        String girdi = scan.nextLine();
        return girdi;
    }

    public static void menuYazdir()
    {
        System.out.println("Komut Listesi:");
        System.out.println("1- Grubun Internet Baglantisini Kapat.");
        System.out.println("2- Grubun Internet Bağlantisini Ac.");
        System.out.println("3- Grubun İletisimi Kapat.");
    }

    public static String emirVer()
    {
        System.out.println("Komut Numarasi Giriniz:");
        Scanner scan = new Scanner(System.in);
        String girdi = scan.nextLine();
        switch (girdi)
        {
            case "1":{
                System.out.println("Internet Baglantisini Kapat Emri Gonderiliyor.");
                return girdi;
            }
            case "2":{
                System.out.println("Internet Baglantisini Ac Emri Gonderiliyor.");
                return girdi;
            }
            case "3":{
                System.out.println("Baglantiyi Kesme Emri Gonderiliyor.");
                return girdi;
            }
            default:{
                System.out.println("Gecersiz Komut, Tekrar Komut Giriniz:");
                return emirVer();
            }
        }
    }
}