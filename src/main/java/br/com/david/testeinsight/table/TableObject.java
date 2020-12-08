package br.com.david.testeinsight.table;

/**
 * Define um método que deverá retornar um Objetc
 * @author David Arruda
 */
public interface TableObject {
    
    /**
     * Método para retornar uma determinada coluna de uma classe model
     * @param column
     * @return 
     */
    Object value(int column);
}
