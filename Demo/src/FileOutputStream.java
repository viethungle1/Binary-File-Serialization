import java.io.IOException;
import java.io.OutputStream;

public class FileOutputStream {
    public static void main(String[] args) throws IOException {
        OutputStream os = new java.io.FileOutputStream("CodeGym.txt");
        byte[] bytes = new byte[] {'h','u','n','g'};
        for (int i = 0; i < bytes.length; i++) {
            byte b = bytes[i];
            os.write(b);
        }
        os.close();
    }
}
