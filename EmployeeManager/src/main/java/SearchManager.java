import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SearchManager {
    List<String> indexList = Arrays.asList("employeeNum", "name", "cl", "phoneNum", "birthday", "certi");

    public boolean isExistIndex(String index){
        return indexList.contains(index);
    }

    public boolean isExistEmployee(String index, String value){
        if(isExistIndex(index) == false)
            throw new RuntimeException();

        List<String> employeeList = searchEmployee(index, null, value);

        if(employeeList.size() != 0)
            return true;
        else
            return false;
    }

    private String convertIndexWithOption(String index, String option){
        if(index == "name"){
            if(option == "f"){
                return "name_first";
            }
            else if(option == "l"){
                return "name_last";
            }
        }
        if(index == "phoneNum"){
            if(option == "m"){
                return "phoneNum_middle";
            }
            else if(option == "l"){
                return "phoneNum_last";
            }
        }
        if(index == "birthday"){
            if(option == "y"){
                return "birthday_yy";
            }
            else if(option == "m"){
                return "birthday_mm";
            }
            else if(option == "d"){
                return "birthday_dd";
            }
        }
        return index;
    }

    private List<String> extractTargetEmployee(HashMap<String, List<String>> employeeHashMap, String key){
        return employeeHashMap.get(key);
    }


    public List<String> searchEmployee(String index, String option, String value){
        if(isExistIndex(index) == false)
            throw new RuntimeException();

        if (option != null)
            index = convertIndexWithOption(index, option);

        HashMap<String, List<String>> employeeHashMap;
        employeeHashMap = EmployeeManager.getHashMap(index);

        List<String> employeeNumList = extractTargetEmployee(employeeHashMap, value);

        return employeeNumList;
    }
}
