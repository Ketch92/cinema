package core.model.dto;

import javax.validation.constraints.NotNull;

public class MovieRequestDto {
    @NotNull(message = "The title field shouldn't be empty.")
    private String title;
    private String description;
    
    @Override
    public String toString() {
        return "MovieResponseDto{"
               + ", title='" + title + '\''
               + ", description='" + description + '\''
               + '}';
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
}
