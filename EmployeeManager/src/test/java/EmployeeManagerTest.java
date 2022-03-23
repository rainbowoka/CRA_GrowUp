import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EmployeeManagerTest {

    EmployeeManager em = new EmployeeManager();

    @BeforeEach
    void DataAdd(){
        List<Employee> emps = new ArrayList<>();
        emps.add(new Employee("15123099","VXIHXOTH JHOP","CL3","010-3112-2609","19771211","ADV"));
        emps.add(new Employee("17112609","FB NTAWR","CL4","010-5645-6122","19861203","PRO"));
        emps.add(new Employee("18115040","TTETHU HBO","CL3","010-4581-2050","20080718","ADV"));
        emps.add(new Employee("88114052","NQ LVARW","CL4","010-4528-3059","19911021","PRO"));
        emps.add(new Employee("19129568","SRERLALH HMEF","CL2","010-3091-9521","19640910","PRO"));
        emps.add(new Employee("17111236","VSID TVO","CL1","010-3669-1077","20120718","PRO"));
        emps.add(new Employee("18117906","TWU QSOLT","CL4","010-6672-7186","20030413","PRO"));
        emps.add(new Employee("08123556","WN XV","CL1","010-7986-5047","20100614","PRO"));
        emps.add(new Employee("02117175","SBILHUT LDEXRI","CL4","010-2814-1699","19950704","ADV"));
        emps.add(new Employee("03113260","HH LTUPF","CL2","010-5798-5383","19791018","PRO"));
        emps.add(new Employee("14130827","RPO JK","CL4","010-3231-1698","20090201","ADV"));
        emps.add(new Employee("01122329","DN WD","CL4","010-7174-5680","20071117","PRO"));
        emps.add(new Employee("08108827","RTAH VNUP","CL4","010-9031-2726","19780417","ADV"));
        emps.add(new Employee("85125741","FBAH RTIJ","CL1","010-8900-1478","19780228","ADV"));
        emps.add(new Employee("08117441","BMU MPOSXU","CL3","010-2703-3153","20010215","ADV"));
        emps.add(new Employee("10127115","KBU MHU","CL3","010-3284-4054","19660814","ADV"));
        emps.add(new Employee("12117017","LFIS JJIVL","CL1","010-7914-4067","20120812","PRO"));
        emps.add(new Employee("11125777","TKOQKIS HC","CL1","010-6734-2289","19991001","PRO"));
        emps.add(new Employee("11109136","QKAHCEX LTODDO","CL4","010-2627-8566","19640130","PRO"));
        emps.add(new Employee("05101762","VCUHLE HMU","CL4","010-3988-9289","20030819","PRO"));
        em.add(emps);
        em.restructIndexs();
    }


    @Test
    void AddTest(){
        assertEquals(20, EmployeeManager.getEmployeeList("employeeNum").stream().count());
    }

    @Test
    void SearchTest(){
        List<Employee> items_phoneNum = em.search("phoneNum_middle", e->e.phoneNum_middle.equals("3284"));
        assertEquals(1, items_phoneNum.stream().count());

        List<Employee> items_birth = em.search("birthday_mm", e->e.birthday_mm.equals("12"));
        assertEquals(2, items_birth.stream().count());

        List<Employee> items_birth2 = em.search("birthday_dd", e->e.birthday_dd.equals("04"));
        assertEquals(1, items_birth2.stream().count());
        assertEquals("02117175", items_birth2.get(0).employeeNum);

        List<Employee> items_Certi = em.search("certi", e->e.certi.equals("PRO"));
        assertEquals(12, items_Certi.stream().count());

        List<Employee> items_emp = em.search("employeeNum", e->e.employeeNum.equals("79110836"));
        assertEquals(0, items_emp.stream().count());
    }

    @Test
    void SearchTest2(){
        List<Employee> birthday = em.search("birthday_yy", e->e.birthday_yy.equals("2003"));
        assertEquals(2, birthday.stream().count());

        assertEquals("05101762",birthday.get(0).employeeNum);
        assertEquals("18117906",birthday.get(1).employeeNum);
    }

    @Test
    void empNoFormatChangeTest(){
        assertEquals("1996000000", em.MakeYYYY2EmpNo("96000000"));
        assertEquals("2000000000", em.MakeYYYY2EmpNo("00000000"));
        assertEquals("1969000000", em.MakeYYYY2EmpNo("69000000"));
        assertEquals("2018000000", em.MakeYYYY2EmpNo("18000000"));
    }


    @Test
    void ModTest(){
        List<Employee> items = em.search("certi", e->e.certi.equals("ADV"));
        assertEquals(8, items.stream().count());
        Employee cloneObj = items.get(0).clone();

        em.mod(items, "birthday", "20050520");
        assertEquals("20050520", items.get(0).birthday);
        assertEquals("19780228" , cloneObj.birthday);

        List<Employee> re_serachitems = em.search("name", e->e.name.equals("FB NTAWR"));
        assertEquals("19861203", re_serachitems.get(0).birthday);
    }


    @Test
    void DelTest(){
        List<Employee> items = em.search("employeeNum", e->e.employeeNum.equals("18115040"));
        assertEquals(1, items.stream().count());
        Employee cloneObj = items.get(0).clone();

        em.delete(items);
        assertEquals(19, EmployeeManager.getEmployeeList("employeeNum").stream().count());
        assertEquals(19, EmployeeManager.getEmployeeList("name").stream().count());
        assertEquals(19, EmployeeManager.getEmployeeList("name_first").stream().count());
        assertEquals(19, EmployeeManager.getEmployeeList("name_last").stream().count());
        assertEquals(19, EmployeeManager.getEmployeeList("cl").stream().count());
        assertEquals(19, EmployeeManager.getEmployeeList("phoneNum").stream().count());
        assertEquals(19, EmployeeManager.getEmployeeList("phoneNum_middle").stream().count());
        assertEquals(19, EmployeeManager.getEmployeeList("phoneNum_last").stream().count());
        assertEquals(19, EmployeeManager.getEmployeeList("birthday").stream().count());
        assertEquals(19, EmployeeManager.getEmployeeList("birthday_yy").stream().count());
        assertEquals(19, EmployeeManager.getEmployeeList("birthday_mm").stream().count());
        assertEquals(19, EmployeeManager.getEmployeeList("birthday_dd").stream().count());
        assertEquals(19, EmployeeManager.getEmployeeList("certi").stream().count());
    }



    @Test
    void ValidTest(){

        assertEquals(true, em.isValidEmpNo("12131450"));
        assertEquals(true, em.isValidEmpNo("10000000"));

        assertEquals(false, em.isValidEmpNo("1213145052"));
        assertEquals(false, em.isValidEmpNo("121314"));
        assertEquals(false, em.isValidEmpNo("121314a4"));

        assertEquals(false, em.isValidName("Hello Choi"));
        assertEquals(true, em.isValidName("HELLO CHOI"));
        assertEquals(false, em.isValidName("ccokdk asdfj"));
        assertEquals(false, em.isValidName("HelloChoi"));

        assertEquals(true, em.isValidPhone("1990-010-800"));
        assertEquals(true, em.isValidPhone("190-010-800"));
        assertEquals(false, em.isValidPhone("1990-010-800-2332"));
        assertEquals(false, em.isValidPhone("1990-010800"));

        assertEquals(true, em.isValidBirthday("19900108"));
        assertEquals(false, em.isValidBirthday("19901308"));
        assertEquals(false, em.isValidBirthday("19901312"));

        assertEquals(true  , em.isValid(new Employee("10000000","KAD C","CL3","010-0001-0001","19900107","ADV")));
        assertEquals(false  , em.isValid(new Employee("100000001","KAD","1","1","1","1")));
        assertEquals(false  , em.isValid(new Employee("1000000","H","1","1","1","1")));

        assertEquals(false  , em.isValid(new Employee("1000000a","1","1","1","1","1")));
    }
}