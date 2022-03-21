import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        PrintWriter pw = new PrintWriter("output.txt");

        String message;
        Command command;
        String result = "";
        ParsingManager parsingManager = new ParsingManager(",");
        EmployeeManager employeeManager = new EmployeeManager();

        while ((message = br.readLine()) != null) {
            //정상적으로 parsing 되지 않을 경우 예외 추가 예정
            command = parsingManager.parseCommand(message);

            //command 를 이용해 CommandExcutor 실행예정
            result += "\n";
        }
        pw.print(result);
        br.close();
        pw.close();
    }
}
