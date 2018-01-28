package progress.com.dbase.Dfirebase.firemodel;

/**
 * Created by Umar Saidu Auna on 1/28/2018.
 */

public class firemodelreceive{
    private String Name,Surname,Email,Phone;

    public firemodelreceive() {

    }

    public firemodelreceive(String Name, String Surname, String Email, String Phone) {
        this.Name = Name;
        this.Surname = Surname;
        this.Email = Email;
        this.Phone = Phone;
    }

    public String getName() {
        return this.Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getSurname() {
        return this.Surname;
    }

    public void setSurname(String surname) {
        this.Surname=surname;
    }

    public String getEmail() {
        return this.Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public String getPhone() {
        return this.Phone;
    }

    public void setPhone(String phone) {
        this.Phone = phone;
    }
}
