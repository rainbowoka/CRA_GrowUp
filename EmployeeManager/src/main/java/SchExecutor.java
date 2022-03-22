import java.util.ArrayList;
import java.util.List;

class SchExecutor implements Executor{
    private ArrayList<String> makePrintMsg(List<Employee> searchedList, String printOption){
        ArrayList<String> printStringList = new ArrayList<>();

        String prefixString = "SCH,";

        if(searchedList.size() == 0){
            printStringList.add(prefixString + "NONE");
            return printStringList;
        }

        if(printOption == "") {
            printStringList.add(prefixString + searchedList.size());
        }
        else{
            for(int i = 0; i<5 || i < searchedList.size(); i++){
                printStringList.add(prefixString + searchedList.get(i).GetObject("employeeNum") + ","
                        + searchedList.get(i).GetObject("name") + ","
                        + searchedList.get(i).GetObject("cl") + ","
                        + searchedList.get(i).GetObject("phoneNum") + ","
                        + searchedList.get(i).GetObject("birthday") + ","
                        + searchedList.get(i).GetObject("certi"));
            }
        }

        return printStringList;
    }

    public ArrayList<String> execute(Command command, EmployeeManager em) {
        SearchManager searchManager = new SearchManager();

        ArrayList<String> printString;
        String key = command.getFieldList().get(0);
        String value = command.getFieldList().get(1);
        String printOption = command.getOptionListElement(0).getOption();
        String searchOption = command.getOptionListElement(1).getOption();

        List<Employee> searchedList = searchManager.searchEmployee(key, searchOption, value);
        printString = makePrintMsg(searchedList, printOption);

        return printString;
    }
}