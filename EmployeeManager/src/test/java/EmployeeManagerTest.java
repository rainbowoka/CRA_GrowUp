import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EmployeeManagerTest {

    @Test
    void FullCycleTest() {
        EmployeeManager em = new EmployeeManager();
        ArrayList<Employee> emps = new ArrayList<>();
        emps.add(new Employee("10000000","1","1","1","1","1"));
        emps.add(new Employee("11000000","1","1","1","1","1"));
        emps.add(new Employee("12000000","1","1","1","1","1"));
        emps.add(new Employee("13000000","1","1","1","1","1"));
        emps.add(new Employee("14000000","1","1","1","1","1"));
        emps.add(new Employee("15000000","1","1","1","1","1"));
        em.Add(emps);

        System.out.println("Employee 데이터 6건 추가 후 데이터 출력(=6)");
        assertEquals(6, em.getLength());

        System.out.println("EmployeeNo의 앞 두자리가 10인 데이터 검색 (=1)");
        var emp_no_5 = em.Search(e->e.employeeNum.substring(0,2).equals("10"));
        assertEquals(1, emp_no_5.stream().count());

        System.out.println("검색된 데이터 삭제 후 데이터 출력(=5)");
        em.Delete(emp_no_5.get(0));
        assertEquals(5, em.getLength());
    }

    @Test
    void ValidTest(){
        EmployeeManager em = new EmployeeManager();
        assertEquals(true, em.isValidEmpNo("12131450"));
        assertEquals(false, em.isValidEmpNo("1213145052"));
        assertEquals(false, em.isValidEmpNo("121314"));
        assertEquals(false, em.isValidEmpNo("121314a4"));

        assertEquals(true  , em.isValid(new Employee("10000000","1","1","1","1","1")));
        assertEquals(false  , em.isValid(new Employee("100000001","1","1","1","1","1")));
        assertEquals(false  , em.isValid(new Employee("1000000","1","1","1","1","1")));
        assertEquals(false  , em.isValid(new Employee("1000000a","1","1","1","1","1")));
    }
}