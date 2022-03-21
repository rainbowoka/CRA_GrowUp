import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EmployeeManager {
    public static final String EMPTY = " ";

    protected String[] indexList = new String[] {"employeeNum", "name", "name_first", "name_last", "cl", "phoneNum", "phoneNum_middle","phoneNum_last", "birthday", "birthday_yy", "birthday_mm", "birthday_dd", "certi"};
    protected HashMap<String, ArrayList<Employee>> index = new HashMap<>();

    public EmployeeManager()
    {
        for(String key : indexList) {
            index.put(key, new ArrayList<Employee>());
        }
    }

    public void add(ArrayList<Employee> emps)
    {
        for(Employee e:emps) {
            if(isValid(e) == false){
               return;
            }
        }
        for(String key : indexList) {
            index.get(key).addAll(emps);
        }

        restructIndex();
    }

    protected boolean isValid(Employee e) {
        if (isValidEmpNo(e.employeeNum) == false)
            return false;
        if(isValidName(e.name) == false)
            return false;

        return true;
    }
    protected boolean isValidEmpNo(String empNo) {
        if(index.get("employeeNum").stream().filter(x->x.employeeNum == empNo).count() != 0)
            return false;

        if (empNo.matches("[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]") == true)
            return true;
        else
            return false;
    }
    protected boolean isValidName(String name) {
        //중간에 띄워쓰기가 있는 한글,영문
        if (name==EMPTY || name.matches("[A-Z]+( )[A-Z]+") == true)
            return true;
        else
            return false;
    }

    private void restructIndex()
    {
        sortEmployeeNum();
        sortName();
        sortCareerLevel();
        sortPhoneNum();
        sortBirthday();
        sortCerti();
    }
    private void sortObject(String indexKey){
        Collections.sort(index.get(indexKey), (t1, t2) -> compareTo(t1.GetObject(indexKey), t2.GetObject(indexKey), t1.GetObject("employeeNum"), t2.GetObject("employeeNum")));
    }

    private void sortEmployeeNum()
    {
        sortObject("employeeNum");
    }
    private void sortName(){
        sortObject("name");
        sortObject("name_first");
        sortObject("name_last");
    }

    private void sortCareerLevel(){
        sortObject("cl");
    }

    private void sortPhoneNum(){
        sortObject("phoneNum");
        sortObject("phoneNum_middle");
        sortObject("phoneNum_last");
    }
    private void sortBirthday(){
        sortObject("birthday");
        sortObject("birthday_yy");
        sortObject("birthday_mm");
        sortObject("birthday_dd");
    }
    private void sortCerti(){
        sortObject("certi");
    }

    private int compareTo(String compare1, String compare2){
        if (compare1.compareTo(compare2) > 0) {
            return 1;
        }
        else if (compare1.compareTo(compare2) < 0) {
            return -1;
        }
        else
        {
            return 0;
        }
    }

    private int compareTo(String compare1, String compare2, String default1, String default2){
        if (compare1.compareTo(compare2) > 0) {
            return 1;
        }
        else if (compare1.compareTo(compare2) < 0) {
            return -1;
        }
        else
        {
            return compareTo(default1, default2);
        }
    }

    public List<Employee> search(String key, Predicate<Employee> p){
        ArrayList<Employee> empNoindex = index.get(key);
        List<Employee> a = empNoindex.stream().filter(p).collect(Collectors.toList());

        return a;
    }

    public void delete(Employee e)
    {
        for(String key : indexList)
            index.get(key).remove(e);
    }

    public int getLength()
    {
        long length = (int) index.get(indexList[0]).stream().count();
        for(String key : indexList) {
            if (length != index.get(key).stream().count())
                return -1;
        }
        return (int) length;
    }
}
