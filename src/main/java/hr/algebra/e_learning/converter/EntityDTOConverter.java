package hr.algebra.e_learning.converter;

public interface EntityDTOConverter<E, D> {
    D toDto(E entity);
    E toEntity(D dto);
}
