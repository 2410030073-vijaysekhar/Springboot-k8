import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Throw_s {
    static void readfile() throws IOException{
        FileReader fr= new  FileReader("test.txt");
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();
        System.out.println("First Line: "+ line);
        br.close();
    }
    public static void main(String[] args) {
        try {
            readfile();
        } catch (IOException e) {
            System.out.println("Error: "+ e.getMessage());
        }
    }
}