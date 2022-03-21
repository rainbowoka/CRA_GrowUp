import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ParsingManagerTest {
    @Mock
    private ParsingManager parsingManager;

    @BeforeEach
    void setup(){
        parsingManager = mock(ParsingManager.class);
    }

    @Test
    void test() {
        when(parsingManager.parseCommand(anyString())).thenReturn(new Command());

        Command actual = new Command();
        assertEquals(actual, parsingManager.parseCommand("1"));
    }

}
