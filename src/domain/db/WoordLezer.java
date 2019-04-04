package domain.db;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class WoordLezer {
    private ArrayList<String> woorden = new ArrayList<>();

    public WoordLezer(String path) {

        BufferedReader in = getReader(path);
        while(true){
            String line = readLine(in);
            if(line.equals("")){
                break;
            }
            woorden.add(line);
        }
    }




    public ArrayList<String> getWoorden(){
        return woorden;
    }

    public static BufferedReader getReader(String name) {
        BufferedReader in = null;
        try {
            File file = new File(name);
            in = new BufferedReader(
                    new FileReader(file));
        } catch (FileNotFoundException e) {
            System.out.println(
                    "The file" + name + " doesn't exist.");
            System.exit(0);
        }
        return in;
    }
    private static String readLine(BufferedReader in){
        String line = "";
        try {
            line = in.readLine();
        } catch (IOException e) {
            System.out.println("I/O Error");
            System.exit(0);
        }
        return Objects.requireNonNullElse(line, "");
    }

}
