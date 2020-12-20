package br.com.david.testeinsight.validator;

/**
 * Interface que define o método validate e o seu tipo de dado que será recebido como parâmetro
 * 
 * @author David Arruda
 *
 * @param <T>
 */
public interface FieldValidator<T> {

	boolean validate(T value);
}
