package core.model.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class UserRequestDto {
    @NotNull(message = "Please, don't leave this field empty.")
    @Min(value = 4)
    private String email;
    @NotNull(message = "Please, don't leave this field empty.")
    @Min(value = 4)
    private String password;
    @NotNull(message = "Please, don't leave this field empty.")
    @Min(value = 4)
    private String repeatPassword;
    
    public UserRequestDto() {
    }
    
    public UserRequestDto(String email, String password) {
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
