import java.util.ArrayList;
import java.util.List;

class AddExecutor implements Executor{
    public ArrayList<String> execute(Command command, EmployeeManager em) {
        SearchManager searchManager = new SearchManager();

        String employeeNum = command.getFieldList().get(0);
        String name = command.getFieldList().get(1);
        String cl = command.getFieldList().get(2);
        String phoneNum = command.getFieldList().get(3);
        String birthday = command.getFieldList().get(4);
        String certi = command.getFieldList().get(5);

        List<Employee> searchedList = searchManager.searchEmployee("employeeNum", " ", employeeNum);
        if(searchedList == null) {
            System.out.println("ADD ERROR! EXISTING EMPLOYEE");
            return null;
        }

        ArrayList<Employee> emp = new ArrayList<Employee>()
                {{add(new Employee(employeeNum, name, cl, phoneNum, birthday, certi));}};
        em.add(emp);

        return null; // 수정 필요...
    }
}