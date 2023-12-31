import java.util.ArrayList;
import java.io.*;
public class Main {
    public void save(String path, ArrayList<Product> list) throws IOException {
        DataOutputStream dos = new DataOutputStream(new FileOutputStream(path));
        dos.writeInt(list.size());
        for (Product i : list) {
            dos.writeUTF(i.getMaSanPham());
            dos.writeUTF(i.getTenSanPham());
            dos.writeDouble(i.getGia());
            dos.writeUTF(i.getHangSanXuat());
        }
        dos.close();
    }
    public ArrayList<Product> load (String path) throws IOException {
        ArrayList<Product> list = new ArrayList<>();
        File file = new File(path);
        if (!file.exists()) {
            return null;
        }
        DataInputStream dis = new DataInputStream(new FileInputStream(path));
        int numberProduct = dis.readInt();
        for (int i = 0; i < numberProduct; i++) {
            String product_id = dis.readUTF();
            String product_name = dis.readUTF();
            double product_price = dis.readDouble();
            String product_brand = dis.readUTF();
            Product product = new Product(product_id,product_name,product_price,product_brand);
            list.add(product);
        }
        return list;
    }
    public static void main(String[] args) throws IOException {
        ArrayList<Product> list = new ArrayList<>();
        Product s1 = new Product("1","Tivi",1000,"Sony");
        Product s2 = new Product("2","MayGiat",1000,"LG");
        Product s3 = new Product("3","TuLanh",1000,"Hitachi");
        list.add(s1);
        list.add(s2);
        list.add(s3);
        s3.setGia(1200);
        new Main().save("data.txt",list);
        System.out.println(new Main().load("data.txt"));

    }
}