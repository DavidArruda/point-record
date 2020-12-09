package br.com.david.testeinsight.table;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * Classe que permite a manipulação do layout da tabela
 *
 * @author David Arruda
 */
public class TableCellRenderer extends DefaultTableCellRenderer {

    /**
     * Altera a cor de fundo de cada celula, se a mesma estiver selecionada a
     * cor será amarela, e se as linhas forem par então será branco o background
     * senão será cinza claro
     *
     * @param table
     * @param value
     * @param isSelected
     * @param hasFocus
     * @param row
     * @param column
     * @return Component
     */
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        component.setBackground(isSelected ? Color.YELLOW
                : row % 2 == 0 ? Color.WHITE : Color.LIGHT_GRAY);

        return component;
    }

}
