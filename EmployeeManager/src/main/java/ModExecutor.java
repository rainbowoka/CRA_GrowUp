import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class ModExecutor implements Executor{
    public ArrayList<String> execute(Command command, EmployeeManager em) {
        System.out.println("Execute MOD with options");

        ArrayList<String> printString = new ArrayList<>(1);
        //SearchManager searchManager = new SearchManager();

        List<Employee> empList = null;

        if (command.getFieldList().get(0).equals("employeeNum")) {
            empList = em.search("employeeNum", e->e.employeeNum.equals(command.getFieldList().get(1)));
        }

        if (command.getFieldList().get(0).equals("name")) {
            if (command.getOptionList().get(1).getOption().equals("f")) {
                empList = em.search("name", e->e.name_first.equals(command.getFieldList().get(1)));
            }
            else if (command.getOptionList().get(1).getOption().equals("l")) {
                empList = em.search("name", e->e.name_last.equals(command.getFieldList().get(1)));
            }
            else {
                empList = em.search("name", e->e.name.equals(command.getFieldList().get(1)));
            }
        }

        if (command.getFieldList().get(0).equals("cl")) {
            empList = em.search("cl", e->e.cl.equals(command.getFieldList().get(1)));
        }

        if (command.getFieldList().get(0).equals("phoneNum")) {
            if (command.getOptionList().get(1).getOption().equals("m")) {
                empList = em.search("phoneNum", e->e.phoneNum_middle.equals(command.getFieldList().get(1)));
            }
            else if (command.getOptionList().get(1).getOption().equals("l")) {
                empList = em.search("phoneNum", e->e.phoneNum_last.equals(command.getFieldList().get(1)));
            }
            else {
                empList = em.search("phoneNum", e->e.phoneNum.equals(command.getFieldList().get(1)));
            }
        }

        if (command.getFieldList().get(0).equals("birthday")) {
            empList = em.search("birthday", e->e.birthday.equals(command.getFieldList().get(1)));
        }

        if (command.getFieldList().get(0).equals("certi")) {
            empList = em.search("certi", e->e.certi.equals(command.getFieldList().get(1)));
        }

        if (command.getFieldList().get(2).equals("employeeNum")) {
            return null;
        }

        em.mod(empList, command.getFieldList().get(2), command.getFieldList().get(3));

        if (empList.stream().count() == 0) {
            printString.add("MOD,NONE");
            return printString;
        }

        if (command.getOptionList().get(0).getOption().equals("p")) {

            for (int i = 0; i < 5 && i < empList.size(); i++) {
                String temp = "MOD," + empList.get(0).GetObject("employeeNum") + "," +
                                       empList.get(0).GetObject("name") + "," +
                                       empList.get(0).GetObject("cl") + "," +
                                       empList.get(0).GetObject("phoneNum") + "," +
                                       empList.get(0).GetObject("birthday") + "," +
                                       empList.get(0).GetObject("certi") + ",";
                printString.add(temp);
            }

            return printString;
        }

        printString.add("MOD," + empList.size());
        return printString;
    }
}