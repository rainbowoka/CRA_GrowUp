import java.util.List;

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
//        SearchManager searchManager = new SearchManager();
//        if (searchManager.isExistEmployee("employeeNum", command.getFieldList().get(0))) {
//            System.out.println("ADD ERROR! EXISTING EMPLOYEE");
//            return false;
//        }

//        em.add(new Employee(pd.getEmployeeNum(), pd.getName(), pd.getCl(), pd.getPhoneNum(), pd.getBirthday(), pd.getCerti()));

        return true;
    }
}

class ModExecutor implements Executor{
    public boolean execute(Command command) {
        // 1. Search manager에 query request
        // 2. if request index != null, MOD & return true
        // 3. else return false

//        SearchManager searchManager = new SearchManager();
//        List<String> employeeList = searchManager.searchEmployee();
//        if (employeeList.size() == 0) {
//            System.out.println("MOD ERROR! NO MATCHES FOUND");
//            return false;
//        }

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