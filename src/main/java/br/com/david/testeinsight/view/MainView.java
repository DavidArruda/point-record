package br.com.david.testeinsight.view;

import java.awt.event.ItemEvent;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import br.com.david.testeinsight.controller.MarkingMadeController;
import br.com.david.testeinsight.model.HoursDelay;
import br.com.david.testeinsight.model.MarkingMade;
import br.com.david.testeinsight.model.OverTime;
import br.com.david.testeinsight.model.WorkingHours;
import br.com.david.testeinsight.table.TableCellRenderer;
import br.com.david.testeinsight.table.TableModel;
import br.com.david.testeinsight.validator.MarkingMadeValidator;
import br.com.david.testeinsight.validator.WorkingHoursValidator;
import br.com.david.testeinsight.validator.impl.MarkingMadeValidatorImpl;
import br.com.david.testeinsight.validator.impl.WorkingHoursValidatorImpl;

/**
 *
 * @author David Arruda
 */
public class MainView extends javax.swing.JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    //WorkingHours
    private LinkedList<WorkingHours> listWorkingHours = new LinkedList<>();
    private TableModel tbWKHours = new TableModel(listWorkingHours, WorkingHours.getColumns());

    //MarkingMade
    private LinkedList<MarkingMade> listMkMades = new LinkedList<>();
    private TableModel tbModelMKMade = new TableModel(listMkMades, MarkingMade.getColumnsMarkingMade());

    //HoursDelay
    private LinkedList<HoursDelay> listHRDelays = new LinkedList<>();
    private TableModel tbModelHRDelay = new TableModel(listHRDelays, HoursDelay.getColumns());

    //OverTime
    private LinkedList<OverTime> listOverTime = new LinkedList<>();
    private TableModel tbModelOverTime = new TableModel(listOverTime, OverTime.getColumns());

    // CONTROLLER
    private MarkingMadeController controller = new MarkingMadeController();

    // VALIDATES
    WorkingHoursValidator validatorWK = new WorkingHoursValidatorImpl();
    MarkingMadeValidator validatorMK = new MarkingMadeValidatorImpl();

    // CRIA O OBJETO DE MARCAÇÃO
    MarkingMade markingMade = new MarkingMade();
    
    // Gerador de ID
    private Random idGenerator = new Random();

    /**
     * Creates new form MainView
     */
    public MainView() {
        initComponents();

        // Table WorkingHours
        tableWorkingHours.setModel(tbWKHours); // Define o modelo de dados para esta tabela
        tableWorkingHours.setColumnSelectionAllowed(false); // Define se as colunas neste modelo podem ser selecionadas.
        tableWorkingHours.getTableHeader().setReorderingAllowed(false); // Define se o usuário pode arrastar cabeçalhos de coluna para reordenar colunas.
        tableWorkingHours.setDefaultRenderer(Object.class, new TableCellRenderer()); // Define um renderizador de célula padrão a ser usado
        tableWorkingHours.setEnabled(false);

        // Table MarkingMade
        tbMKMade.setModel(tbModelMKMade); // Define o modelo de dados para esta tabela
        tbMKMade.setColumnSelectionAllowed(false); // Define se as colunas neste modelo podem ser selecionadas.
        tbMKMade.getTableHeader().setReorderingAllowed(false); // Define se o usuário pode arrastar cabeçalhos de coluna para reordenar colunas.
        tbMKMade.setDefaultRenderer(Object.class, new TableCellRenderer()); // Define um renderizador de célula padrão a ser usado
        tbMKMade.setEnabled(false);

        // Table HoursDelays
        tbHRDelays.setModel(tbModelHRDelay); // Define o modelo de dados para esta tabela
        tbHRDelays.setColumnSelectionAllowed(false); // Define se as colunas neste modelo podem ser selecionadas.
        tbHRDelays.getTableHeader().setReorderingAllowed(false); // Define se o usuário pode arrastar cabeçalhos de coluna para reordenar colunas.
        tbHRDelays.setDefaultRenderer(Object.class, new TableCellRenderer()); // Define um renderizador de célula padrão a ser usado
        tbHRDelays.setEnabled(false);

        // Table OverTime
        tbOverTime.setModel(tbModelOverTime); // Define o modelo de dados para esta tabela
        tbOverTime.setColumnSelectionAllowed(false); // Define se as colunas neste modelo podem ser selecionadas.
        tbOverTime.getTableHeader().setReorderingAllowed(false); // Define se o usuário pode arrastar cabeçalhos de coluna para reordenar colunas.
        tbOverTime.setDefaultRenderer(Object.class, new TableCellRenderer()); // Define um renderizador de célula padrão a ser usado
        tbOverTime.setEnabled(false);
        
        // COMBO BOX
        cbBoxWorkingHours.setModel(new DefaultComboBoxModel(listWorkingHours.toArray()));
        cbBoxWorkingHours.setSelectedIndex(-1);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelWkHours = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableWorkingHours = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtEntryTimeWkHours = new javax.swing.JFormattedTextField();
        txtDepartureTimeWkHours = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        btnSaveWkHours = new javax.swing.JButton();
        btnNewWKHours = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jPanelMKMade = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbMKMade = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtEntryTimeMKMade = new javax.swing.JFormattedTextField();
        txtDepartureTimeMKMade = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        btnSaveMKMade = new javax.swing.JButton();
        btnNewMKMade = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        cbBoxWorkingHours = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        jPanelHRDelays = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbHRDelays = new javax.swing.JTable();
        jPanelOverTime = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbOverTime = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelWkHours.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Horário de trabalho"));

        tableWorkingHours.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tableWorkingHours);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Cadastrar"));

        jLabel1.setText("Entrada");

        try {
            txtEntryTimeWkHours.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            txtDepartureTimeWkHours.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel2.setText("Saída");

        btnSaveWkHours.setText("Salvar");
        btnSaveWkHours.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveWkHoursActionPerformed(evt);
            }
        });

        btnNewWKHours.setText("Novo");
        btnNewWKHours.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewWKHoursActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEntryTimeWkHours, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtDepartureTimeWkHours, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(btnNewWKHours, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSaveWkHours, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(91, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEntryTimeWkHours, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDepartureTimeWkHours, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSaveWkHours)
                    .addComponent(btnNewWKHours))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanelWkHoursLayout = new javax.swing.GroupLayout(jPanelWkHours);
        jPanelWkHours.setLayout(jPanelWkHoursLayout);
        jPanelWkHoursLayout.setHorizontalGroup(
            jPanelWkHoursLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelWkHoursLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelWkHoursLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jSeparator2))
                .addContainerGap())
        );
        jPanelWkHoursLayout.setVerticalGroup(
            jPanelWkHoursLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelWkHoursLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanelMKMade.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Marcações"));

        tbMKMade.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tbMKMade);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Cadastrar"));

        jLabel3.setText("Entrada");

        try {
            txtEntryTimeMKMade.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            txtDepartureTimeMKMade.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel4.setText("Saída");

        btnSaveMKMade.setText("Salvar");
        btnSaveMKMade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveMKMadeActionPerformed(evt);
            }
        });

        btnNewMKMade.setText("Novo");
        btnNewMKMade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewMKMadeActionPerformed(evt);
            }
        });

        jLabel7.setText("ID Jornada de trabalho");

        cbBoxWorkingHours.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbBoxWorkingHoursItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEntryTimeMKMade, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDepartureTimeMKMade, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbBoxWorkingHours, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNewMKMade, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(btnSaveMKMade, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEntryTimeMKMade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDepartureTimeMKMade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbBoxWorkingHours, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNewMKMade)
                            .addComponent(btnSaveMKMade))
                        .addContainerGap())))
        );

        javax.swing.GroupLayout jPanelMKMadeLayout = new javax.swing.GroupLayout(jPanelMKMade);
        jPanelMKMade.setLayout(jPanelMKMadeLayout);
        jPanelMKMadeLayout.setHorizontalGroup(
            jPanelMKMadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMKMadeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelMKMadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                    .addComponent(jSeparator1))
                .addContainerGap())
        );
        jPanelMKMadeLayout.setVerticalGroup(
            jPanelMKMadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMKMadeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelHRDelays.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Horas de atraso"));

        tbHRDelays.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tbHRDelays);

        javax.swing.GroupLayout jPanelHRDelaysLayout = new javax.swing.GroupLayout(jPanelHRDelays);
        jPanelHRDelays.setLayout(jPanelHRDelaysLayout);
        jPanelHRDelaysLayout.setHorizontalGroup(
            jPanelHRDelaysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHRDelaysLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelHRDelaysLayout.setVerticalGroup(
            jPanelHRDelaysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHRDelaysLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanelOverTime.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Horas Extra"));

        tbOverTime.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(tbOverTime);

        javax.swing.GroupLayout jPanelOverTimeLayout = new javax.swing.GroupLayout(jPanelOverTime);
        jPanelOverTime.setLayout(jPanelOverTimeLayout);
        jPanelOverTimeLayout.setHorizontalGroup(
            jPanelOverTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelOverTimeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4)
                .addContainerGap())
        );
        jPanelOverTimeLayout.setVerticalGroup(
            jPanelOverTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOverTimeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelWkHours, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelHRDelays, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelMKMade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelOverTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelMKMade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelWkHours, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelOverTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelHRDelays, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveWkHoursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveWkHoursActionPerformed
        WorkingHours workingHours = new WorkingHours();

        try {
            if (validatorWK.validate(new String[]{txtEntryTimeWkHours.getText(), txtDepartureTimeWkHours.getText()})) {

                LocalDate date = LocalDate.now();
                LocalTime entryTime = LocalTime.parse(txtEntryTimeWkHours.getText().toString());
                LocalTime departureTime = LocalTime.parse(txtDepartureTimeWkHours.getText().toString());

                workingHours.setEntryTime(LocalDateTime.of(date, entryTime));
                workingHours.setDepartureTime(LocalDateTime.of(date, departureTime));
                workingHours.setId(idGenerator.nextInt());

                // VERIFICA SE O HORARIO DE ENTRADA É MAIOR QUE O HORÁRIO DE SAIDA
                if (entryTime.getHour() > departureTime.getHour()) {
                    workingHours.setDepartureTime(workingHours.getDepartureTime().plusDays(1)); // MUDA A SAÍDA PARA O PRÓXIMO DIA
                }

                tbWKHours.addRow(workingHours);

                cbBoxWorkingHours.addItem(workingHours);
                cbBoxWorkingHours.setSelectedItem(workingHours);

                if (listWorkingHours.size() >= 3) {
                    btnSaveWkHours.setEnabled(false);
                    btnNewWKHours.setEnabled(false);
                }
                
                txtEntryTimeWkHours.setText("");
                txtDepartureTimeWkHours.setText("");
                
            }

        } catch (Exception e) {
            msgInvalidTime();
            e.printStackTrace();
        }

    }//GEN-LAST:event_btnSaveWkHoursActionPerformed

    /**
     *
     */
    private void msgInvalidTime() {
        JOptionPane.showMessageDialog(null, "Digite um horário válido. Ex 08:45");
    }

    private void btnSaveMKMadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveMKMadeActionPerformed

        try {

            if (validatorMK.validate(new String[]{txtEntryTimeMKMade.getText(),
                txtDepartureTimeMKMade.getText()})) {

                // CRIAÃOÃO DA DATA E HORARIO DA MARCAÇÃO
                LocalDate date = LocalDate.now();
                LocalTime entryTime = LocalTime.parse(txtEntryTimeMKMade.getText());
                LocalTime departureTime = LocalTime.parse(txtDepartureTimeMKMade.getText());

                // SETA O OBJETO DE MARCAÇÃO COM A DATA DA MARCAÇÃO
                markingMade.setEntryTime(LocalDateTime.of(date, entryTime));
                markingMade.setDepartureTime(LocalDateTime.of(date, departureTime));
                markingMade.setId(idGenerator.nextInt());

                // RELACIONA A MARCAÇÃO FEITA COM UM HORÁRIO DE TRABALHO
                WorkingHours workingHours = (WorkingHours)cbBoxWorkingHours.getSelectedItem();
                markingMade.setWorkingHours(workingHours);

                // VERIFICA SE A MARÇÃO FOI REALIZADA NO MESMO DIA OU NO DIA POSTERIOR
                int resultEntrys = controller.nextDayEntry(markingMade, entryTime);
                int resultDepartures = controller.nextDayDeparture(markingMade, departureTime);
                controller.verifyEntryAndDeparture(markingMade, resultEntrys, resultDepartures);

                // ADICIONA NA TABELA
                tbModelMKMade.addRow(markingMade);

                // ADICIONA AS HORAS PENDENTES NAS TABELAS
                controller.addPendingHours(markingMade, workingHours, tableWorkingHours, tbMKMade, tbModelHRDelay,
                        tbModelOverTime, cbBoxWorkingHours.getSelectedIndex());
                
                markingMade = new MarkingMade();
                
                txtDepartureTimeMKMade.setText("");
                txtEntryTimeMKMade.setText("");
            }

        } catch (Exception ex) {
            msgInvalidTime();
            Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnSaveMKMadeActionPerformed

    private void btnNewMKMadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewMKMadeActionPerformed
        txtDepartureTimeMKMade.setText("");
        txtEntryTimeMKMade.setText("");
    }//GEN-LAST:event_btnNewMKMadeActionPerformed

    private void btnNewWKHoursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewWKHoursActionPerformed
        txtDepartureTimeWkHours.setText("");
        txtEntryTimeWkHours.setText("");
    }//GEN-LAST:event_btnNewWKHoursActionPerformed

    private void cbBoxWorkingHoursItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbBoxWorkingHoursItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED){
            markingMade.setWorkingHours((WorkingHours) cbBoxWorkingHours.getSelectedItem());
            cbBoxWorkingHours.setSelectedItem(markingMade);
        }
    }//GEN-LAST:event_cbBoxWorkingHoursItemStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNewMKMade;
    private javax.swing.JButton btnNewWKHours;
    private javax.swing.JButton btnSaveMKMade;
    private javax.swing.JButton btnSaveWkHours;
    private javax.swing.JComboBox<WorkingHours> cbBoxWorkingHours;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelHRDelays;
    private javax.swing.JPanel jPanelMKMade;
    private javax.swing.JPanel jPanelOverTime;
    private javax.swing.JPanel jPanelWkHours;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable tableWorkingHours;
    private javax.swing.JTable tbHRDelays;
    private javax.swing.JTable tbMKMade;
    private javax.swing.JTable tbOverTime;
    private javax.swing.JFormattedTextField txtDepartureTimeMKMade;
    private javax.swing.JFormattedTextField txtDepartureTimeWkHours;
    private javax.swing.JFormattedTextField txtEntryTimeMKMade;
    private javax.swing.JFormattedTextField txtEntryTimeWkHours;
    // End of variables declaration//GEN-END:variables
}
