package core.model.dto;

public class UserResponseDto {
    private Long id;
    private String email;
    
    public UserResponseDto(Long id, String email) {
        this.id = id;
        this.email = email;
    }
    
    public UserResponseDto() {
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    @Override
    public String toString() {
        return "UserResponseDto{"
               + "id=" + id
               + ", email='" + email + '\''
               + '}';
    }
}
