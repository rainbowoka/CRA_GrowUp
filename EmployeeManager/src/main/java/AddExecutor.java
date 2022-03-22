import java.util.ArrayList;

class AddExecutor implements Executor{
    public ArrayList<String> execute(Command command, EmployeeManager em) {
        SearchManager searchManager = new SearchManager();
        if (searchManager.isExistEmployee("employeeNum", command.getFieldList().get(0))) {
            System.out.println("ADD ERROR! EXISTING EMPLOYEE");
            return null;
        }

        ArrayList<Employee> emp = new ArrayList<>()
                                    {{add(new Employee(command.getFieldList().get(0),
                                            command.getFieldList().get(1),
                                            command.getFieldList().get(2),
                                            command.getFieldList().get(3),
                                            command.getFieldList().get(4),
                                            command.getFieldList().get(5)));}};
        em.add(emp);

        return null; // 수정 필요...
    }
}