import java.lang.reflect.Array;
import java.util.ArrayList;

public class CommandExecutor {
    private Command command;

    public CommandExecutor() { }

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public ArrayList<String> execute(Executor executor, EmployeeManager em) {
        return executor.execute(command, em);
    }
}

interface Executor {
    public ArrayList<String> execute(Command command, EmployeeManager em);
}


class SchExecutor implements Executor{
    public boolean execute(Command command) {
        System.out.println("Execute DEL with options");
        return true;
    }
}