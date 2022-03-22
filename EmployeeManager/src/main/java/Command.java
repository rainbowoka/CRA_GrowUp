import java.util.ArrayList;

public class Command {
    private ArrayList<Option> optionList; // for option arguments i.e., -p, -f, -l
    private ArrayList<String> fieldList; // otherwise

    Command() {
        optionList = new ArrayList<Option>(3) {{
            add(new Option()); add(new Option()); add(new Option());}};
    }

    Command(int idx, String opt) {
        optionList = new ArrayList<Option>(3) {{
            add(new Option()); add(new Option()); add(new Option());}};
        setOptionListElement(idx, opt);
    }

    Command(ArrayList<Integer> indices, ArrayList<String> opts) {
        optionList = new ArrayList<Option>(3) {{
            add(new Option()); add(new Option()); add(new Option());}};
        for (Integer idx : indices) {
            setOptionListElement(idx, opts.get(idx));
        }
    }

    public ArrayList<Option> getOptionList() {
        return optionList;
    }

    public void setOptionList(ArrayList<Option> optionList) {
        this.optionList = optionList;
    }

    public ArrayList<String> getFieldList() {
        return fieldList;
    }

    public void setFieldList(ArrayList<String> fieldList) {
        this.fieldList = fieldList;
    }

    public Option getOptionListElement(int idx) {
        return optionList.get(idx);
    }

    public void setOptionListElement(int idx, String opt) {
        if (idx < 0 || idx > 1) {
            return;
        }

        if (idx == 0) {
            if (!opt.equals("p"))
                return;
        }

        if (idx == 1) {
            if (!(opt.equals("f") || opt.equals("l") || opt.equals("m")
                    || opt.equals("y") || opt.equals("m") || opt.equals("d")))
            {
                return;
            }
        }

        optionList.set(idx, new Option(opt));
    }
}
