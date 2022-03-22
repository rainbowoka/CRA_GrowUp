import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
    void searchEmployeeTest(){
        List<Employee> returnList = Arrays.asList();
        when(searchManager.searchEmployee("cl", "l", "cl4")).thenReturn(returnList);

        Assertions.assertEquals(Collections.EMPTY_LIST, searchManager.searchEmployee("cl", "l", "cl4"));
    }

}
