import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class TCPServer {
    public static void main(String[] args) throws Exception {
        ServerSocket outFirstServerSocket = new ServerSocket(6789);
        readAsByte(outFirstServerSocket);

    }

    public static void readAsByte(ServerSocket outFirstServerSocket) throws Exception {
        while (true){
            System.out.println("Waiting input data");
            Socket connection = outFirstServerSocket.accept();
            System.out.println("Yeni mushteri geldi");

            DataInputStream dataInputStream = new DataInputStream(connection.getInputStream());

            byte[] arr = readMessage(dataInputStream);
            System.out.println("Message length"+arr.length);
            FileUtility.writeBytes(arr,"C:\\Users\\User\\Desktop\\javaWriter.jpg");

        }
    }

    public static byte[] readMessage( DataInputStream din) throws IOException {
        int msgLen = din.readInt();
        byte[] msg = new byte[msgLen];
        din.readFully(msg);
        return msg;


    }


    public static void readAsString(ServerSocket outFirstServerSocket) throws IOException {
        while (true){
            System.out.println("Waiting input data");
            Socket connection = outFirstServerSocket.accept();
            InputStream is = connection.getInputStream();
            InputStreamReader reader = new InputStreamReader(is);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String messageFromClient = bufferedReader.readLine();
            System.out.println("Message from clienrt is:" + messageFromClient);

        }
    }
}
