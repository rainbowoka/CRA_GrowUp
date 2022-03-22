import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class ModExecutor implements Executor{
    public ArrayList<String> execute(Command command, EmployeeManager em) {
        // 1. SearchManager로부터 매칭되는 employee 정보 찾음 (parsing)
        // 2. if option[0] == "p", 해당 employee의 query 미리 요청
        // 3. if option[1] == "f", 이름으로 검색
        // 4. if option[1] == "l" && name, 성으로 검색
        // 5. if option[1] == "m", 전화번호 중간 자리로 검색
        // 6. if option[1] == "l" && phoneNum, 전화번호 뒷 자리로 검색
        // 7. em.mod()
        // 8. if option[0] == "p", 쿼리 전부 출력, 리턴
        // 9. MOD,* 리턴

        ArrayList<String> printString = new ArrayList<>(1);
        SearchManager searchManager = new SearchManager();

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

        if (empList.stream().count() == 0) {
            return null;
        }

        if (command.getFieldList().get(2).equals("employeeNum")) {
            return null;
        }

        em.mod(empList, command.getFieldList().get(2), command.getFieldList().get(3));


        if (command.getOptionList().get(0).getOption().equals("p")) {

            for (int i = 0; i < empList.size(); i++) {
                String temp = "MOD," + empList.get(0).GetObject("employeeNum") + "," +
                                       empList.get(0).GetObject("name") + "," +
                                       empList.get(0).GetObject("cl") + "," +
                                       empList.get(0).GetObject("phoneNum") + "," +
                                       empList.get(0).GetObject("birthday") + "," +
                                       empList.get(0).GetObject("certi") + ",";
                printString.add(temp);
            }
        }



        // 1. SearchManager로부터 매칭되는 employee 사번 찾음
//        List<String> searchedEmpNumList = searchManager.searchEmployee(
//                command.getFieldList().get(0), command.getOptionList().get(1).getOption(), command.getFieldList().get(1));
//
//        if (searchedEmpNumList == null) {
//            return null;
//        }

//        String option2 = command.getOptionList().get(1).getOption();
//        String columnName = command.getFieldList().get(0);
//        List<Employee> queriedEmps = null;
//
//        for (int i = 0; i < searchedEmpNumList.size(); i++) {
//            String temp = searchedEmpNumList.get(i);
//
//            // 사번이 temp인 employee 검색
//            List<Employee> queryEmpNum = em.search("employeeNum", e->e.employeeNum.equals(temp));
//            queryEmpNum.get(0).GetObject()
//
//            switch (option2) {
//                case "f":
//                    // 3. if option[1] == "f", 이름으로 검색
//                    queriedEmps = em.search(columnName, e->e.name.equals(temp));
//                    break;
//                case "l":
//                    // 4. if option[1] == "l" && name, 성으로 검색
//                    if (command.getFieldList().get(0).equals("name")) {
//                        // search by family name
//                        queriedEmps = em.search(columnName, e->e.name_last.equals(""))
//                    }
//
//                    // 6. if option[1] == "l" && phoneNum, 전화번호 뒷 자리로 검색
//                    if (command.getFieldList().get(0).equals("phoneNum")) {
//                        // search by phoneNum
//                    }
//                    break;
//                case "m":
//                    // 5. if option[1] == "m", 전화번호 중간 자리로 검색
//
//                    break;
//            }
//        }

        System.out.println("Execute MOD with options");
        return null;
    }
}