import java.io.IOException;
import java.io.InputStream;

public class FileInputStream {
    public static void main(String[] args) throws IOException {
        InputStream is = new java.io.FileInputStream("CodeGym.txt");
        byte[] bytes = new byte[10];
        int i = -1;
        while ((i = is.read(bytes))!= -1) {
            String s = new String(bytes,0, i);
            System.out.println(s);
        }
        is.close();
    }
}
