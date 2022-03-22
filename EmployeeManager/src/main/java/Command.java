public class Command {
    private String name;
    private Option option;
    public void setCommand(String[] options){
        name = options[0];
    }
    public String getName(){
        return name;
    }
}
