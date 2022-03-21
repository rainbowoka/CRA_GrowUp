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
    void AddExecutorOptionTest1() {
        commandExecutor = new CommandExecutor();
        commandExecutor.setCommand(new Command(0, "-p"));
        commandExecutor.getCommand().getOptionListElement(0);
        assertEquals(true, commandExecutor.getCommand().getOptionListElement(0).getOption().equals("-p"));
        // Input: ADD,-p, , ,*
    }

    @Test
    void AddExecutorOptionTest2() {
        commandExecutor = new CommandExecutor();
        commandExecutor.setCommand(new Command(2, "-p"));
        commandExecutor.getCommand().getOptionListElement(2);
        assertEquals(false, commandExecutor.getCommand().getOptionListElement(2).getOption().equals("-p"));
        // Input: ADD, , ,-p,*
    }

    @Test
    void AddExecutorOptionTest3() {
        commandExecutor = new CommandExecutor();
        commandExecutor.setCommand(new Command(1, "-p"));
        commandExecutor.getCommand().getOptionListElement(1);
        assertEquals(false, commandExecutor.getCommand().getOptionListElement(2).getOption().equals("-p"));
        // Input: ADD, ,-p, ,*
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
