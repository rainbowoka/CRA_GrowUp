import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        try {
            BufferedReader br = new BufferedReader(new FileReader("input.txt"));
            PrintWriter pw = new PrintWriter("output.txt");

            String message;
            Command command;
            CommandExecutor commandExecutor = new CommandExecutor();
            Executor executor;
            String result = "";
            ParsingManager parsingManager = new ParsingManager(",");
            EmployeeManager employeeManager = new EmployeeManager();
            ArrayList<String> resultStringArray;

            while ((message = br.readLine()) != null) {
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

                commandExecutor.setCommand(command);
                resultStringArray = commandExecutor.execute(executor, employeeManager);
                if(!resultStringArray.isEmpty()){
                    for(String resultString : resultStringArray){
                        result += resultString + "\n";
                    }
                }
            }
            pw.print(result);
            br.close();
            pw.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
