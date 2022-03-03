package com.github.juke404.test.api.function;

/**
 * @author Jake
 * @since 02/03/2022
 **/

public interface IFunction<T> {
    T executesAndReturns(Object... params);
}
