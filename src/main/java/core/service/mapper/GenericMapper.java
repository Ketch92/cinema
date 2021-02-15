package core.service.mapper;

public interface GenericMapper<R, U, E> {
    /**
    R - type for responseDto;
    U - type for requestDto;
    E - entity type object.
     */
    R mapToDto(E entity);
    
    E mapToEntity(U requestDto);
}
