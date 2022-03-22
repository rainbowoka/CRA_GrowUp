import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

public class SchExecutorTest {
    @Mock
    private SchExecutor schExecutor;

    @BeforeEach
    void SetUp(){
        schExecutor = mock(SchExecutor.class);
    }

    @Test
    void executeTest(){
        Command cmd = new Command();
        cmd.setName("SCH");
        ArrayList<String> fieldList = new ArrayList<>();
        fieldList.add("cl");
        fieldList.add("CL2");
        cmd.setFieldList(fieldList);

        ArrayList<Option> optionList= new ArrayList<>();
        optionList.add(new Option("p"));
        optionList.add(new Option("m"));
        cmd.setOptionList(optionList);

        ArrayList<String> printStringList = new ArrayList<>();


        Assertions.assertEquals(printStringList, schExecutor.execute(cmd, new EmployeeManager()));
    }
}
