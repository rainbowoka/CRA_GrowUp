import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EmployeeManager {
    private String[] indexList = new String[] {"employeeNum", "name", "name_first", "name_last", "cl", "phoneNum", "phoneNum_middle","phoneNum_last", "birthday", "birth_yy", "birth_mm", "birth_dd", "certi"};
    private HashMap<String, ArrayList<Employee>> index = new HashMap<>();

    public EmployeeManager()
    {
        for(String key : indexList) {
            index.put(key, new ArrayList<Employee>());
        }
    }

    public ArrayList<Employee> getDataByKey(String indexName)
    {
        return index.get(indexName);
    }

    public void Add(ArrayList<Employee> emps)
    {
        for(Employee e:emps) {
            if(isValid(e) == false){
               return;
            }
        }
        for(String key : indexList) {
            index.get(key).addAll(emps);
            RestructIndex(key);
        }
    }

    protected boolean isValid(Employee e) {
        if (isValidEmpNo(e.employeeNum) == false)
            return false;
        return true;
    }
    protected boolean isValidEmpNo(String empNo) {
        if (empNo.matches("[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]") == true)
            return true;
        else
            return false;
    }




    private void RestructIndex(String key)
    {
        Collections.sort(index.get(key), (t1, t2) -> {
            if (t1.name.compareTo(t2.name) < 0)
                return 1;
            else
                return -1;
        });
    }

    public List<Employee> Search(Predicate<Employee> p)
    {
        ArrayList<Employee> empNoindex = index.get("employeeNum");
        List<Employee> a = empNoindex.stream().filter(p).collect(Collectors.toList());

        return a;
    }

    public void Delete(Employee e)
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
