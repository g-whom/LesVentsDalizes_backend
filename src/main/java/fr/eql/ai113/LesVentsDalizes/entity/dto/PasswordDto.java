package fr.eql.ai113.LesVentsDalizes.entity.dto;

/**
 * class that allows to manipulate passwords
 */
public class PasswordDto {

    private String username;
    private String password;
    private String passwordNew;
    private String passwordNewBis;


    /// CONSTRUCTOR ///
    public PasswordDto() {
    }

    public PasswordDto(String username, String password, String passwordNew, String passwordNewBis) {
        this.username = username;
        this.password = password;
        this.passwordNew = passwordNew;
        this.passwordNewBis = passwordNewBis;
    }

    /// FUNCTIONS ///

    /// GETTER ///


    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPasswordNew() {
        return passwordNew;
    }

    public String getPasswordNewBis() {
        return passwordNewBis;
    }

    /// SETTER ///


    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPasswordNew(String passwordNew) {
        this.passwordNew = passwordNew;
    }

    public void setPasswordNewBis(String passwordNewBis) {
        this.passwordNewBis = passwordNewBis;
    }

    /// TOSTring ///


}
