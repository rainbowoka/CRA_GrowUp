class Employee {
    public String employeeNum;
    public String name;
    protected String name_first;
    protected String name_last;
    public String cl;
    public String phoneNum;
    protected String phoneNum_middle;
    protected String phoneNum_last;
    public String birthday;
    protected String birthday_yy;
    protected String birthday_mm;
    protected String birthday_dd;
    public String certi;

    public Employee(String employeeNum, String name, String cl, String phoneNum, String birthday, String certi) {
        this.employeeNum = employeeNum;
        this.name = name;
        this.cl = cl;
        this.phoneNum = phoneNum;
        this.birthday = birthday;
        this.certi = certi;

        if (name!= EmployeeManager.EMPTY && name.split(" ").length>0){
            this.name_first =name.split(" ")[0];
            this.name_last =name.split(" ")[1];
        }
        else{
            this.name_first =EmployeeManager.EMPTY;
            this.name_last =EmployeeManager.EMPTY;
        }
        if (phoneNum != EmployeeManager.EMPTY && phoneNum.split("-").length>2){
            this.phoneNum_middle =phoneNum.split("-")[1];
            this.phoneNum_last =phoneNum.split("-")[2];
        }
        else{
            this.phoneNum_middle =EmployeeManager.EMPTY;
            this.phoneNum_last =EmployeeManager.EMPTY;
        }

        if (birthday != EmployeeManager.EMPTY && birthday.length()==8){
            this.birthday_yy =birthday.substring(0,4);
            this.birthday_mm =birthday.substring(4,6);
            this.birthday_dd =birthday.substring(6,8);
        }
        else{
            this.birthday_yy =EmployeeManager.EMPTY;
            this.birthday_mm =EmployeeManager.EMPTY;
            this.birthday_dd =EmployeeManager.EMPTY;
        }
    }
    public String GetObject(String key){
        switch(key){
            case "employeeNum":
                return employeeNum;
            case "name":
                return name;
            case "name_first":
                return name_first;
            case "name_last":
                return name_last;
            case "cl":
                return cl;
            case "phoneNum":
                return phoneNum;
            case "phoneNum_middle":
                return phoneNum_middle;
            case "phoneNum_last":
                return phoneNum_last;
            case "birthday":
                return birthday;
            case "birthday_yy":
                return birthday_yy;
            case "birthday_mm":
                return birthday_mm;
            case "birthday_dd":
                return birthday_dd;
            case "certi":
                return certi;
            default:
                return " ";
        }
    }

}