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
    Socket clientSocket = null;

    Link (String host, int port){
        this.host = host;
        this.port = port;
    }

    public void connect(){
        try {
            clientSocket = new Socket("localhost", 4444);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage (Message message){
        Gson gson = new Gson();
        String json = gson.toJson(message);
        byte[] massOfByts = json.getBytes();
        try {
            OutputStream outputStream = clientSocket.getOutputStream();
            outputStream.write(massOfByts);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



