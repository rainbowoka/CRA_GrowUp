import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OptionTest {
    private Option option;

    @Test
    void OptionTest1() {
        option = new Option();
        String str = option.getOption();

        assertEquals(true, str.equals(" "));
    }

    @Test
    void CommandOptionTest2() {
        option = new Option("f");
        String str = option.getOption();

        assertEquals(true, str.equals("f"));
    }
}
