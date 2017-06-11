import java.util.Scanner;

/**
 * Created by vika on 03.05.17.
 */
public class Program {
    public static void main(String[] args) {
        if(selectThread()){
            Server server = new Server();
            Thread thread2 = new Thread(server);
            thread2.start();
        }
        else {
            Client client = new Client();
            Thread thread1 = new Thread(client);
            thread1.start();
        }

    }

    private static boolean selectThread (){
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        if (input.equals("s")){
            return true;
        }
        else
            return false;
        }
    }
