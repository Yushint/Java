import java.io.*;


public class ReadFileInput {
    public static void main(String[] args) {
        PrintWriter pw = new PrintWriter(System.out, true);
        int i;
        FileInputStream file = null;

        if (args.length != 1) {
            pw.println("Use ReadFileInput <filename>.");
            return;
        }
        try {
            file = new FileInputStream(args[0]);
            do{
                i = file.read();
                if (i != -1) pw.println((char) i);
            }while (i != -1);
        }catch (IOException e){
            pw.println("Input/Output error has been raised: " + e);
        }finally {
            try{
                if (file != null) file.close();
            }catch (IOException e){
                pw.println("An error has been raised while closing the file.");
                return;
            }
        }
    }
}
