package hr.algebra.e_learning.mapper;

public interface Mapper<S, T> {
    T convert(S source);
}
