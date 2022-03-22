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
            boolean addCommand = true;
            boolean firstOthers = true;
            long startTime = System.currentTimeMillis();

            while ((message = br.readLine()) != null) {
                command = parsingManager.parseCommand(message);
                if (command.getName().equals("ADD")){
                    executor = new AddExecutor();
                }
                else if (command.getName().equals("DEL")){
                    executor = new DelExecutor();
                    addCommand = false;
                }
                else if (command.getName().equals("SCH")){
                    executor = new SchExecutor();
                    addCommand = false;
                }
                else {
                    executor = new ModExecutor();
                    addCommand = false;
                }
                if(!addCommand && firstOthers){
                    firstOthers = false;
                    employeeManager.restructIndexs();
                }
                commandExecutor.setCommand(command);
                resultStringArray = commandExecutor.execute(executor, employeeManager);
                if(resultStringArray != null){
                    for(String resultString : resultStringArray){
                        result += resultString + "\n";
                    }
                }
            }
            pw.print(result);
            br.close();
            pw.close();
            System.out.println("elapsedTime(ms) : " + (System.currentTimeMillis() - startTime));
        }
        catch (IOException e){
            System.out.println(e);
        }
    }
}
