package ui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {

        try(FileInputStream f = new FileInputStream("config/config.properties")){
            Properties p = new Properties();
            p.load(f);
            System.out.println(p.getProperty("pepe"));
        }catch(FileNotFoundException e){
            System.out.println("File not fund exception");
        }catch(IOException e){
            System.out.println("IOException error");
        }catch(Exception e){
            System.out.println("Cualquier error");
        }

    }
}
