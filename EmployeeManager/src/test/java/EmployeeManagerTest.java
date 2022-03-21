import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EmployeeManagerTest {

    @Test
    void ModTest(){
        EmployeeManager em = new EmployeeManager();
        ArrayList<Employee> emps = new ArrayList<>();
        emps.add(new Employee("10000000","KK AA","CL3","010-0001-0001","19900107","ADV"));
        emps.add(new Employee("13000000","KK BB","CL2","010-0001-0002","19900106","EX"));
        emps.add(new Employee("11000001","KK CC","CL1","010-0001-0003","19900105","PRO"));
        emps.add(new Employee("11000000","KK DD","CL1","010-0002-0001","19900104","PRO"));
        emps.add(new Employee("12000000","KK FF","CL3","010-0002-0001","19900103","EX"));
        emps.add(new Employee("14000000","GG CC","CL1","010-0003-0008","19900102","ADV"));
        emps.add(new Employee("15000000","GG BB","CL3","010-0004-0009","19900101","ADV"));
        em.add(emps);

        var emp_phonmdl0001 = em.search("phoneNum_middle", e->e.phoneNum_middle.equals("0001"));
        assertEquals(3, emp_phonmdl0001.stream().count());

        em.mod(emp_phonmdl0001, "phoneNum", "010-1000-9999");
        assertEquals(3, em.search("phoneNum", e->e.phoneNum.equals("010-1000-9999")).stream().count());
    }

    @Test
    void FullCycleTest() {
        EmployeeManager em = new EmployeeManager();
        ArrayList<Employee> emps = new ArrayList<>();
        emps.add(new Employee("10000000","땡땡 허","CL3","010-0001-0001","19900107","ADV"));
        emps.add(new Employee("13000000","땡일 박","CL2","010-0001-0002","19900106","EX"));
        emps.add(new Employee("11000001","땡일 구","CL1","010-0001-0003","19900105","PRO"));
        emps.add(new Employee("11000000","땡일 구","CL1","010-0002-0001","19900104","PRO"));
        emps.add(new Employee("12000000","땡땡 이","CL3","010-0002-0001","19900103","EX"));
        emps.add(new Employee("14000000","땡땡 최","CL1","010-0003-0008","19900102","ADV"));
        emps.add(new Employee("15000000","땡땡 장","CL3","010-0004-0009","19900101","ADV"));

        em.add(emps);

        System.out.println("Employee 데이터 7건 추가 확인(=7)");
        assertEquals(7, em.getLength());

        System.out.println("Employee 데이터 7건에 대해 정렬 확인(=7)");
        assertEquals("10000000" , em.index.get("employeeNum").get(0).employeeNum);
        assertEquals("11000000" , em.index.get("employeeNum").get(1).employeeNum);
        assertEquals("11000001" , em.index.get("employeeNum").get(2).employeeNum);
        assertEquals("12000000" , em.index.get("employeeNum").get(3).employeeNum);
        assertEquals("13000000" , em.index.get("employeeNum").get(4).employeeNum);
        assertEquals("14000000" , em.index.get("employeeNum").get(5).employeeNum);
        assertEquals("15000000" , em.index.get("employeeNum").get(6).employeeNum);

        assertEquals("구" , em.index.get("name_last").get(0).name_last);
        assertEquals("11000000" , em.index.get("name_last").get(0).employeeNum);
        assertEquals("구" , em.index.get("name_last").get(1).name_last);
        assertEquals("11000001" , em.index.get("name_last").get(1).employeeNum);
        assertEquals("박" , em.index.get("name_last").get(2).name_last);
        assertEquals("이" , em.index.get("name_last").get(3).name_last);
        assertEquals("장" , em.index.get("name_last").get(4).name_last);
        assertEquals("최" , em.index.get("name_last").get(5).name_last);
        assertEquals("허" , em.index.get("name_last").get(6).name_last);
        
        System.out.println("EmployeeNo의 앞 두자리가 10인 데이터 검색 (=1)");
        var emp_no5 = em.search("employeeNum", e->e.employeeNum.substring(0,2).equals("10"));
        assertEquals(1, emp_no5.stream().count());

        System.out.println("전화번호의 가운데가 0001인 데이터 검색 (=3)");
        var emp_phonmdl0001 = em.search("phoneNum_middle", e->e.phoneNum_middle.equals("0001"));
        assertEquals(3, emp_phonmdl0001.stream().count());

        System.out.println("검색된 데이터 삭제 후 데이터 출력(=6)");
        em.delete(emp_no5.get(0));
        assertEquals(6, em.getLength());
    }

    @Test
    void ValidTest(){
        EmployeeManager em = new EmployeeManager();

        assertEquals(true, em.isValidEmpNo("12131450"));
        assertEquals(true, em.isValidEmpNo("10000000"));
        assertEquals(false, em.isValidEmpNo("1213145052"));
        assertEquals(false, em.isValidEmpNo("121314"));
        assertEquals(false, em.isValidEmpNo("121314a4"));

        assertEquals(true, em.isValidName("Hello Choi"));
        assertEquals(true, em.isValidName("HELLO CHOI"));
        assertEquals(true, em.isValidName("ccokdk asdfj"));
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