package ibf2021d2;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class client {
    
    public static void main(String[] args) 
            throws UnknownHostException, IOException{
        
        Socket socket = new Socket("192.168.2.6", 3000);

        try (OutputStream os = socket.getOutputStream() ) {
            BufferedOutputStream bos = new BufferedOutputStream(os);
            DataOutputStream dos = new DataOutputStream(bos);

            String msg = "";

            while (msg.equals("exit")){
                dos.writeUTF("Hello World!");
                dos.flush();
            }
            
        }
        
        socket.close();
    }
}
