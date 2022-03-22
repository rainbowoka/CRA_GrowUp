import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;

public class DelExecutorTest {
    @Mock
    private DelExecutor delExecutor;

    @BeforeEach
    void SetUp(){
        delExecutor = mock(DelExecutor.class);
    }

    @Test
    void executeTest(){
        Command cmd = new Command();
        cmd.setName("DEL");
        ArrayList<String> fieldList = new ArrayList<>();
        fieldList.add("cl");
        fieldList.add("CL2");
        cmd.setFieldList(fieldList);

        ArrayList<Option> optionList= new ArrayList<>();
        optionList.add(new Option("p"));
        optionList.add(new Option("m"));
        cmd.setOptionList(optionList);

        ArrayList<String> printStringList = new ArrayList<>();


        Assertions.assertEquals(printStringList, delExecutor.execute(cmd, new EmployeeManager()));
    }
}
