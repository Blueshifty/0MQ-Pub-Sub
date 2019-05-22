import org.zeromq.SocketType;
import org.zeromq.ZMQ;
import org.zeromq.ZMQ.Socket;
import org.zeromq.ZContext;
import java.util.Scanner;

public class server
{
    public static void main(String[] args) throws Exception
    {
            ZContext context = new ZContext();
            ZMQ.Socket socket = context.createSocket(SocketType.PUB);
            socket.bind("tcp://*:5217");
            while (!Thread.currentThread().isInterrupted())
            {
                String secilenSub = sub_sec();
                menu_yazdir();
                String emir = emir_ver();
                for(int i = 0; i < secilenSub.length(); ++i){
                    socket.sendMore(String.valueOf(secilenSub.charAt(i)));
                    socket.send(emir);
                }
                Thread.sleep(1000);
            }    
    }
    public static String sub_sec(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Sub Listesi:");
        System.out.println("A- Sadece A Sub'u");
        System.out.println("B- Sadece B Sub'u");
        System.out.println("AB- Heriki Sub a da Gonder");
        System.out.println("Seceneklerden Birini Girin:");
        String girdi = scan.nextLine();
        return girdi;
    }


    public static void menu_yazdir()
    {
        System.out.println("Komut Listesi:");
        System.out.println("1- İnternet Baglantisini Kapat.");
        System.out.println("2- İnternet Bağlantisini Ac.");
        System.out.println("3- İletisimi Kapat.");
        System.out.println("\nBir Komut Numarasi Girin:");
    }

    public static String emir_ver()
    {
        Scanner scan = new Scanner(System.in);
        String girdi = scan.nextLine();
        switch (girdi)
        {
            case "1":{
                System.out.println("Internet Baglantisini Kapat Emri Gonderiliyor");
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
                return emir_ver();
            }
        }
    }
}