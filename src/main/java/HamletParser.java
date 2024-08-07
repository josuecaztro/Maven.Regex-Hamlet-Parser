import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {

    private String hamletData;

    public HamletParser(){
        this.hamletData = loadFile();
    }

    private String loadFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("hamlet.txt").getFile());
        StringBuilder result = new StringBuilder("");

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                String newLine = changeHamlets(line);
                result.append(newLine).append("\n");
            }

            scanner.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return result.toString();
    }

    public String getHamletData(){
        return hamletData;
    }

    public void createNewFile(){
        //creates a new file
        try {
            File myObj = new File("src/main/resources/newHamlet.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void copyFileToFile(File a, File b) throws IOException {
        FileInputStream in = new FileInputStream(a);
        FileOutputStream out = new FileOutputStream(b);
        try {
            int n;
            // read() function to read the
            // byte of data
            while ((n = in.read()) != -1) {
                // write() function to write
                // the byte of data
                out.write(n);
            }
        }
        finally {
            if (in != null) {
                // close() function to close the
                // stream
                in.close();
            }
            // close() function to close
            // the stream
            if (out != null) {
                out.close();
            }
        }
        System.out.println("File Copied");
    }

    public String changeHamlets(String line){
        Pattern pattern = Pattern.compile("Hamlet");
        Matcher matcher = pattern.matcher(line);
        return matcher.replaceAll("Leon");
    }

    public String changeHoratios(String line){
        Pattern pattern = Pattern.compile("Horatio");
        Matcher matcher = pattern.matcher(line);
        return matcher.replaceAll("Tariq");
    }

    public static void main(String[] args) throws IOException {
        HamletParser hp = new HamletParser();
        System.out.println(hp.loadFile());
//        File fileOne = new File("src/main/resources/hamlet.txt");
//        File fileTwo = new File("src/main/resources/hamletCopy.txt");
//
//        hp.modifyToNewFile(fileOne, fileTwo);


    }


}
