import java.util.ArrayList;
import java.util.Arrays;

public class ParsingManager {
    private String delimiter;
    public ParsingManager(String delimiter){
        this.delimiter = delimiter;
    }

    public Command parseCommand(String message){
        String[] options = message.split(delimiter);
        ArrayList<Option> optionArrayList = new ArrayList<>(3);
        Command command = new Command();
        ArrayList<String> fieldList = new ArrayList<>();

        for(int i=1;i<=3;i++){
            optionArrayList.add(new Option(options[i]));
        }
        for(int i=4;i<options.length;i++){
            fieldList.add(options[i]);
        }

        command.setName(options[0]);
        command.setOptionList(optionArrayList);
        command.setFieldList(fieldList);

        return command;
    }
}
