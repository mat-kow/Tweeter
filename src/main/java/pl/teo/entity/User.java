package pl.teo.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 20, unique = true, nullable = false)
    @Size(min = 3, max = 20, message = "Musi mieć od 3 do 20 znaków" )
    private String userName;
    @Size (min = 3, message = "Hasło musi zawierać co najmniej 3 znaki")
    private String password;
    @Size(min = 3, max = 20, message = "Musi mieć od 3 do 20 znaków")
    private String firstName;
    @Size(min = 3, max = 20, message = "Musi mieć od 3 do 20 znaków")
    private String lastName;
    @Column(unique = true)
    @Email(message = "Podaj prawidłowy adres e-mail")
    @NotEmpty
    private String email;

    public long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
