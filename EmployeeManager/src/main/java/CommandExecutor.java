public class CommandExecutor {
    private Command command;

    public CommandExecutor() { }

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public boolean execute(Executor executor) {
        return executor.execute(command);
    }

}

interface Executor {
    public boolean execute(Command command);
}

class AddExecutor implements Executor{
    public boolean execute(Command command) {
        // 1. Search manager에 query request
        // 2. if request index == null, ADD & return true
        // 3. else return false
        System.out.println("Execute ADD with options");
        return true;
    }
}

class ModExecutor implements Executor{
    public boolean execute(Command command) {
        // 1. Search manager에 query request
        // 2. if request index != null, MOD & return true
        // 3. else return false
        System.out.println("Execute MOD with options");
        return true;
    }
}

class DelExecutor implements Executor{
    public boolean execute(Command command) {
        // 1. Search manager에 query request
        // 2. if request index != null, DEL & return true
        // 3. else return false
        System.out.println("Execute DEL with options");
        return true;
    }
}


class SchExecutor implements Executor{
    public boolean execute(Command command) {
        System.out.println("Execute DEL with options");
        return true;
    }
}