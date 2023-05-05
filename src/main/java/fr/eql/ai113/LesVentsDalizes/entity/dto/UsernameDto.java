package fr.eql.ai113.LesVentsDalizes.entity.dto;

public class UsernameDto {

    private String username;
    private String usernameNew;

    /// CONSTRUCTOR ///

    public UsernameDto() {
    }

    public UsernameDto(String username, String usernameNew) {
        this.username = username;
        this.usernameNew = usernameNew;
    }
    /// GETTER ///

    public String getUsername() {
        return username;
    }

    public String getUsernameNew() {
        return usernameNew;
    }

    /// SETTER ///

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUsernameNew(String usernameNew) {
        this.usernameNew = usernameNew;
    }

    /// -- ///
    /// -- ///
}
