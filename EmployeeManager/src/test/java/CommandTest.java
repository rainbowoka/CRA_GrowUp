import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandTest {
    private Command command;

    @BeforeEach
    void Setup() {
        command = new Command();
    }

    @Test
    void SimpleCommandTest1() {
        command.setOptionListElement(0, "p");

        assertEquals(true, command.getOptionListElement(0).getOption().equals("-p"));
    }

    @Test
    void SimpleCommandTest2() {
        command.setOptionListElement(0, "p");
        Option option = command.getOptionListElement(0);

        assertEquals("p", option.getOption());
    }

    @Test
    void SimpleCommandTest3() {
        command.setOptionListElement(1, "f");

        assertEquals(true, command.getOptionListElement(1).getOption().equals("f"));
    }

    @Test
    void SimpleCommandTestWithWrongOption1() {
        command.setOptionListElement(0, "f");

        assertEquals(false, command.getOptionListElement(0).getOption().equals("f"));
    }

    @Test
    void SimpleCommandTestWithWrongOption2() {
        command.setOptionListElement(1, "p");

        assertEquals(false, command.getOptionListElement(1).getOption().equals("p"));
    }

    @Test
    void CommandTestWithMultipleOptions() {
        Command commandMultiple = new Command(new ArrayList<Integer>(2) {{add(0); add(1);}},
                                        new ArrayList<String>(2) {{ add("p"); add("l");}});

        assertEquals(true, commandMultiple.getOptionListElement(0).getOption().equals("p"));
        assertEquals(true, commandMultiple.getOptionListElement(1).getOption().equals("l"));
    }

    @Test
    void CommandClassUsage() {

        ArrayList<Option> optionList = new ArrayList<>();
        optionList.add(new Option("-p"));
        optionList.add(new Option("-f"));
        ArrayList<String> fieldList = new ArrayList<String>();

        fieldList.add("21013070");
        fieldList.add("Jeonghyeon Wang");
        fieldList.add("CL3");
        fieldList.add("010-1000-1000");
        fieldList.add("20210201");
        fieldList.add("PRO");

        Command command = new Command();
        command.setFieldList(fieldList);
        command.setOptionList(optionList);

        CommandExecutor commandExecutor = new CommandExecutor();
        commandExecutor.setCommand(command);

        assertEquals(true, commandExecutor.getCommand().getFieldList().get(0).equals("21013070"));
        assertEquals(true, commandExecutor.getCommand().getFieldList().get(1).equals("Jeonghyeon Wang"));
        assertEquals(true, commandExecutor.getCommand().getFieldList().get(2).equals("CL3"));
        assertEquals(true, commandExecutor.getCommand().getFieldList().get(3).equals("010-1000-1000"));
        assertEquals(true, commandExecutor.getCommand().getFieldList().get(4).equals("20210201"));
        assertEquals(true, commandExecutor.getCommand().getFieldList().get(5).equals("PRO"));

        assertEquals(true, commandExecutor.getCommand().getOptionList().get(0).getOption().equals("-p"));
        assertEquals(true, commandExecutor.getCommand().getOptionList().get(1).getOption().equals("-f"));
    }
}
