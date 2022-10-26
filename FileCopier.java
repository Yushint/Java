import java.io.*;


public class FileCopier {
    public static void main(String[] args){
        PrintWriter pw = new PrintWriter(System.out, true);
        FileInputStream inputFile = null;
        FileOutputStream outputFile = null;
        int symbolByte;

        if (args.length != 2){
            pw.println("Not enough arguments. FileCopier <input_file> <output_file>...");
            return;
        }

        try{
            inputFile = new FileInputStream(args[0]);
            outputFile = new FileOutputStream(args[1]);

            do{
                symbolByte = inputFile.read();
                if (symbolByte != -1) outputFile.write(symbolByte);
            }while (symbolByte != -1);
        }catch (IOException e){
            pw.println("Input/Output error has been raised: " + e);
        }finally {
            try{
                if (inputFile != null) inputFile.close();
            }catch (IOException e){
                pw.println("Can't close input file.");
            }
            try {
                if (outputFile != null) outputFile.close();
            }catch (IOException e){
                pw.println("Can't close output file.");
            }
        }
    }
}
