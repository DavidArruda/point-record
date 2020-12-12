package br.com.david.testeinsight.table;

import java.util.LinkedList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 * Classe reponsável por permitir manipular as listas de objetos(OverTime,
 * HoursDalay, etc)
 *
 * @author David Arruda
 */
public class TableModel extends DefaultTableModel {

    private final List<TableObject> list;

    /**
     * Construtor. Retornar um TableModel com uma lista de objetos e a descrição
     * das colunas que serão apresentadas
     *
     * @param list
     * @param colunms
     */
    public TableModel(LinkedList list, Object[] colunms) {
        super(colunms, 0);
        this.list = list;
    }

    /**
     * Exibe os dados na tabela Jtable. Ultiliza o método value definido na
     * interface TableObjetc
     *
     * @param row
     * @param column
     * @return
     */
    @Override
    public Object getValueAt(int row, int column) {
        return list.get(row).value(column);
    }

    /**
     * Define o número de elementos na tabela
     *
     * @return int
     */
    @Override
    public int getRowCount() {
        return list != null ? list.size() : 0;
    }

    /**
     * Recupera os dados completos de um objeto da lista.
     *
     * @param row
     * @return TableObject
     */
    public TableObject getValue(int row) {
        return list.get(row);
    }

    /**
     * Adiciona uma nova linha no Jtable.
     *
     * @param TableObject obj
     */
    public void addRow(TableObject obj) {
        list.add(obj);
        this.fireTableDataChanged(); // Atualiza o Jtable com o novo registro
    }

    /**
     * Retorna a lista com todos os elementos da Jtable
     *
     * @return List<TableObject>
     */
    public List<TableObject> getList() {
        return list;
    }

}
