import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandExecutorTest {
    private CommandExecutor commandExecutor;
    private Command command;

    @Test
    void AddExecutorFuncCallTest() {
        commandExecutor = new CommandExecutor();
        commandExecutor.setCommand(command);

        Executor addExecutor = new AddExecutor();

        boolean res = commandExecutor.execute(addExecutor);
        assertEquals(true, res);
    }

    @Test
    void ModExecutorFuncCallTest() {
        commandExecutor = new CommandExecutor();
        commandExecutor.setCommand(command);

        Executor modExecutor = new ModExecutor();

        boolean res = commandExecutor.execute(modExecutor);
        assertEquals(true, res);
    }

    @Test
    void DelExecutorFuncCallTest() {
        commandExecutor = new CommandExecutor();
        commandExecutor.setCommand(command);

        Executor delExecutor = new DelExecutor();

        boolean res = commandExecutor.execute(delExecutor);
        assertEquals(true, res);
    }

    @Test
    void AddExecutorTest1() {
        // Input: ADD, , , ,18050301,KYUMOK KIM,CL2,010-9777-6055,19980906,PRO
    }

    @Test
    void ModExecutorTest1() {
        // Input: MOD, , , ,name,KYUMOK KIM,name,KYUMOK LEE
    }

    @Test
    void ModExecutorTest2() {
        // Input: MOD, , , ,cl,CL3,phoneNum,010-9777-5455
    }

    @Test
    void ModExecutorTest3() {
        // Input: MOD, , , ,phoneNum,010-9777-6055,birthday,20000906
    }

    @Test
    void DelExecutorTest1() {
        // Input:   DEL,-p, , ,cl,CL3
    }

    @Test
    void DelExecutorTest2() {
        // Input:   DEL, , , ,cl,CL3
    }

    @Test
    void DelExecutorTest3() {
        // Input:   DEL, , , ,employeeNum,21050301
    }

}
