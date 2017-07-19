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
            clientSocket.getInputStream();
            clientSocket.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String sendMessage (Message message){
        Gson gson = new Gson();
        String json = gson.toJson(message);
        return json;
    }


}



