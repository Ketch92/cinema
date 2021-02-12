package core.util.mapper;

public interface GenericMapper<R, U, E> {
    /**
    R - type for responseDto;
    U - type for requestDto;
    E - entity type object.
     */
    R mapToDto(E entity);
    
    E mapFromDto(U requestDto);
}
