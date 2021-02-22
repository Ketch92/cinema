package core.model.dto;

import core.lib.FieldMatch;
import core.lib.ValidateEmail;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@FieldMatch(message = "Passwords are different.",
        field = "password",
        fieldMatch = "repeatPassword")
public class UserRequestDto {
    @ValidateEmail
    @Size(min = 4)
    private String email;
    @NotNull(message = "Please, don't leave this field empty.")
    @Size(min = 4)
    private String password;
    @NotNull(message = "Please, don't leave this field empty.")
    @Size(min = 4)
    private String repeatPassword;
    
    public UserRequestDto() {
    }
    
    public UserRequestDto(String email, String password, Long roleId) {
        this.email = email;
        this.password = password;
    }
    
    public String getRepeatPassword() {
        return repeatPassword;
    }
    
    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    @Override
    public String toString() {
        return "UserRequestDto{"
               + "email='" + email + '\''
               + ", password='" + password + '\''
               + '}';
    }
}
