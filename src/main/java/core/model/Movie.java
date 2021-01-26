package core.model;

import java.util.Objects;

public class Movie {
    private Long id;
    private String title;
    private String description;
    
    private Long getId() {
        return id;
    }
    
    private void setId(Long id) {
        this.id = id;
    }
    
    private String getTitle() {
        return title;
    }
    
    private void setTitle(String title) {
        this.title = title;
    }
    
    private String getDescription() {
        return description;
    }
    
    private void setDescription(String description) {
        this.description = description;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Movie movie = (Movie) o;
        return Objects.equals(id, movie.id)
               && Objects.equals(title, movie.title)
               && Objects.equals(description, movie.description);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id, title, description);
    }
    
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Movie{");
        sb.append("id=").append(id);
        sb.append(", title='").append(title).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
