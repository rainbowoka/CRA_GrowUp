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
        if(index == "name"){
            if(option == "f"){
                return (e -> e.name_first == value);
            }
            else if(option == "l"){
                return (e -> e.name_last == value);
            }
            return (e -> e.name == value);
        }
        if(index == "phoneNum"){
            if(option == "m"){
                return (e -> e.phoneNum_middle == value);
            }
            else if(option == "l"){
                return (e -> e.phoneNum_last == value);
            }
        }
        if(index == "birthday"){
            if(option == "y"){
                return (e -> e.birthday_yy == value);
            }
            else if(option == "m"){
                return (e -> e.birthday_mm == value);
            }
            else if(option == "d"){
                return (e -> e.birthday_dd == value);
            }
            return (e -> e.birthday == value);
        }
        if(index == "employeeNum") {
            return (e -> e.employeeNum == value);
        }
        if(index == "cl"){
            return (e -> e.cl == value);
        }
        if(index == "certi"){
            return (e -> e.certi == value);
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
