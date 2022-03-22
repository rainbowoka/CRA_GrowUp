import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SearchManager {
    List<String> indexList = Arrays.asList("employeeNum", "name", "cl", "phoneNum", "birthday", "certi");

    public boolean isExistIndex(String index){
        return indexList.contains(index);
    }

    private String convertIndex(String index, String option){
        if(index.equals("name")){
            if(option.equals("f")){
                return "name_first";
            }
            else if(option.equals("l")){
                return "name_last";
            }
        }
        if(index.equals("phoneNum")){
            if(option.equals("m")){
                return "phoneNum_middle";
            }
            else if(option.equals("l")){
                return "phoneNum_last";
            }
        }
        if(index.equals("birthday")){
            if(option.equals("y")){
                return "birthday_yy";
            }
            else if(option.equals("m")){
                return "birthday_mm";
            }
            else if(option.equals("d")){
                return "birthday_dd";
            }
        }
        return index;
    }

    private Predicate<Employee> convertIndexToPredicateWithOption(String index, String value){
        if(index.equals("name_first")) {
            return (e -> e.name_first.equals(value));
        }
        else if(index.equals("name_last")) {
            return (e -> e.name_last.equals(value));
        }
        else if(index.equals("name")) {
            return (e -> e.name.equals(value));
        }
        else if(index.equals("phoneNum_last")) {
            return (e -> e.phoneNum_last.equals(value));
        }
        else if(index.equals("phoneNum_middle")) {
            return (e -> e.phoneNum_middle.equals(value));
        }
        else if(index.equals("phoneNum")) {
            return (e -> e.phoneNum.equals(value));
        }
        else if(index.equals("birthday_yy")){
            return (e -> e.birthday_yy.equals(value));
        }
        else if(index.equals("birthday_mm")){
            return (e -> e.birthday_mm.equals(value));
        }
        else if(index.equals("birthday_dd")){
            return (e -> e.birthday_dd.equals(value));
        }
        else if(index.equals("birthday")){
            return (e -> e.birthday.equals(value));
        }
        else if(index.equals("employeeNum")) {
            return (e -> e.employeeNum.equals(value));
        }
        else if(index.equals("cl")){
            return (e -> e.cl.equals(value));
        }
        else if(index.equals("certi")){
            return (e -> e.certi.equals(value));
        }
        throw new RuntimeException();
    }

    public List<Employee> searchEmployee(String index, String option, String value){
        if(isExistIndex(index) == false)
            throw new RuntimeException();

        index = convertIndex(index, option);

        List<Employee> employeeList = EmployeeManager.getEmployeeList(index);
        employeeList = employeeList.stream().filter(convertIndexToPredicateWithOption(index, value)).collect(Collectors.toList());

        return employeeList;
    }
}
