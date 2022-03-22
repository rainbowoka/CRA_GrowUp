public class ParsingManager {
    private String delimiter;
    public ParsingManager(String delimiter){
        this.delimiter = delimiter;
    }

    public Command parseCommand(String message){
        String[] options = message.split(delimiter);
        Command command = new Command();
        command.setCommand(options);
        return command;
    }
}
