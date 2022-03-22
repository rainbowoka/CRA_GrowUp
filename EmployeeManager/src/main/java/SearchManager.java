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

    private Predicate<Employee> convertIndexToPredicateWithOption(String index, String option, String value){
        if(index.equals("name")){
            if(option.equals("f")){
                return (e -> e.name_first.equals(value));
            }
            else if(option.equals("l")){
                return (e -> e.name_last.equals(value));
            }
            return (e -> e.name.equals(value));
        }
        if(index.equals("phoneNum")){
            if(option.equals("m")){
                return (e -> e.phoneNum_middle.equals(value));
            }
            else if(option.equals("l")){
                return (e -> e.phoneNum_last.equals(value));
            }
        }
        if(index.equals("birthday")){
            if(option.equals("y")){
                return (e -> e.birthday_yy.equals(value));
            }
            else if(option.equals("m")){
                return (e -> e.birthday_mm.equals(value));
            }
            else if(option.equals("d")){
                return (e -> e.birthday_dd.equals(value));
            }
            return (e -> e.birthday.equals(value));
        }
        if(index.equals("employeeNum")) {
            return (e -> e.employeeNum.equals(value));
        }
        if(index.equals("cl")){
            return (e -> e.cl.equals(value));
        }
        if(index.equals("certi")){
            return (e -> e.certi.equals(value));
        }

        throw new RuntimeException();
    }

    public List<Employee> searchEmployee(String index, String option, String value){
        if(isExistIndex(index) == false)
            throw new RuntimeException();

        List<Employee> employeeList = EmployeeManager.getEmployeeList(index);

        employeeList = employeeList.stream().filter(convertIndexToPredicateWithOption(index, option, value)).collect(Collectors.toList());

        return employeeList;
    }
}
