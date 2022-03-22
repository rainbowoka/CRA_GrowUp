import java.util.ArrayList;

class DelExecutor implements Executor{
    public ArrayList<String> execute(Command command, EmployeeManager em) {
        // 1. SearchManager로부터 매칭되는 employee 정보 찾음
        // 2. if option[0] == "p", 해당 employee의 query 미리 요청
        // 3. if option[1] == "f", 이름으로 검색
        // 4. if option[1] == "l" && name, 성으로 검색
        // 5. if option[1] == "m", 전화번호 중간 자리로 검색
        // 6. if option[1] == "l" && phoneNum, 전화번호 뒷 자리로 검색
        // 7. em.mod()
        // 8. if option[0] == "p", 쿼리 전부 출력, 리턴
        // 9. DEL,* 리턴

        System.out.println("Execute DEL with options");
        return null;
    }
}