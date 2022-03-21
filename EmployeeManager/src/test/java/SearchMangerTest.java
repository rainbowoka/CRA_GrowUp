import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.*;

public class SearchMangerTest {
    @Mock
    private SearchManager searchManager;

    @BeforeEach
    void SetUp(){
        searchManager = mock(SearchManager.class);
    }

    @Test
    void isExistIndexTest(){
        final String[] indexArray = new String[]{ "employeeNum", "name", "cl", "phoneNum","birthday","certi" };

        for(String index : indexArray){
            when(searchManager.isExistIndex(index)).thenReturn(true);
        }

        Assertions.assertEquals(true, searchManager.isExistIndex("employeeNum"));
        Assertions.assertEquals(true, searchManager.isExistIndex("name"));
        Assertions.assertEquals(true, searchManager.isExistIndex("cl"));
        Assertions.assertEquals(true, searchManager.isExistIndex("phoneNum"));
        Assertions.assertEquals(true, searchManager.isExistIndex("birthday"));
        Assertions.assertEquals(true, searchManager.isExistIndex("certi"));

        Assertions.assertEquals(false, searchManager.isExistIndex("sex"));
        Assertions.assertEquals(false, searchManager.isExistIndex("age"));
    }

    @Test
    void isExistEmployeeTest(){
        Assertions.assertEquals(true, searchManager.isExistEmployee(new Employee("name", "홍길동")));
    }

    @Test
    void getDataKeyListFromEmployeeManagerTest(){
        Assertions.assertEquals(new String[]{"cl1", "cl2", "cl3", "cl4"}, searchManager.getDataKeyListFromEmployeeManager("cl"));
    }



}
