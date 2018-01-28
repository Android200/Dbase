package progress.com.dbase.Dfirebase.firemodel;

/**
 * Created by Umar Saidu Auna on 1/28/2018.
 */

public class firemodel {
    private String  name;
    private String  surname;
    private String  email;
    private String  Phonenum;


    public firemodel(){
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.Phonenum = Phonenum;

    }
    public void setName(String name){
        this.name=name;
    }
    public void setSurname(String surname){
        this.surname=surname;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setPhonenum(String phonenum){
        this.Phonenum=phonenum;
    }
    public  String getName(){
        return name;
    }
    public String getSurname(){
        return surname;
    }
    public String getEmail(){
        return email;
    }
    public String getPhonenum(){
        return Phonenum;
    }
}