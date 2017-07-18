import com.google.gson.Gson;

import java.io.*;
import java.net.Socket;

/**
 * Created by vika on 18.07.17.
 */
public class Link {
    String  host;
    int port;
    CallBack callBack;

    Link (String host, int port){
        this.host = host;
        this.port = port;
    }

    public void connect(){
        Socket clientSocket = null;
        try {
            clientSocket = new Socket("localhost", 4444);
            //получаем OutputStream
            OutputStream outputStream = clientSocket.getOutputStream();
            PrintWriter out = new PrintWriter(outputStream, true);
            out.println("Kiss my shiny metal ass!");
            out.flush();

            //читаем ответ
            InputStream inputStream = clientSocket.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
            String answer = in.readLine();
            System.out.println(answer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage (Message message){
        Gson gson = new Gson();
        String json = gson.toJson(message);
    }
}



