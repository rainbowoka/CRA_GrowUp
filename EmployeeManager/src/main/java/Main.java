import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        PrintWriter pw = new PrintWriter("output.txt");

        String message;
        Command command;
        CommandExecutor commandExecutor = new CommandExecutor();
        Executor executor;
        String result = "";
        ParsingManager parsingManager = new ParsingManager(",");
        EmployeeManager employeeManager = new EmployeeManager();

        while ((message = br.readLine()) != null) {
            //정상적으로 parsing 되지 않을 경우 예외 추가 예정
            command = parsingManager.parseCommand(message);
            if (command.getName() == "ADD"){
                executor = new AddExecutor();
            }
            if (command.getName() == "DEL"){
                executor = new DelExecutor();
            }
            if (command.getName() == "SCH"){
                executor = new SchExecutor();
            }
            else {
                executor = new ModExecutor();
            }
            //commandExecutor에서 결과물 return 필요함
            commandExecutor.setCommand(command);
            commandExecutor.execute(executor);

            result += "\n";
        }
        pw.print(result);
        br.close();
        pw.close();
    }
}
