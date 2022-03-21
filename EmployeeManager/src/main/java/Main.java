import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        File file = new File("input_20_20.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String str;
        ParsingManager parsingManager = new ParsingManager();
        Command command;
        String result = "";
        PrintWriter pw = new PrintWriter("output.txt");
        while ((str = br.readLine()) != null) {
            command = parsingManager.parseCommand(str);
            result += "\n";
        }
        pw.print(result);
        br.close();
        pw.close();
    }
}
