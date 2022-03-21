public class CommandExecutor {
    private String command; // Command 변수를 어떻게 처리할지 자료형 확인 후 수정 필요.

    public CommandExecutor() { }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public boolean execute(Executor executor) {
        return executor.execute(command);
    }

}


interface Executor {
    public boolean execute(String command);
}

class AddExecutor implements Executor{
    public boolean execute(String command) {
        // 1. Search manager에 query request
        // 2. if request index == null, ADD & return true
        // 3. else return false

        if (command.equals("Hello")){
            System.out.println("Execute ADD with options");
            return true;
        }
        return false;
    }
}

class ModExecutor implements Executor{
    public boolean execute(String command) {
        // 1. Search manager에 query request
        // 2. if request index != null, MOD & return true
        // 3. else return false

        if (command.equals("Hello")){
            System.out.println("Execute MOD with options");
            return true;
        }
        return false;
    }
}

class DelExecutor implements Executor{
    public boolean execute(String command) {
        // 1. Search manager에 query request
        // 2. if request index != null, DEL & return true
        // 3. else return false

        if (command.equals("Hello")){
            System.out.println("Execute DEL with options");
            return true;
        }
        return false;
    }
}

