/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.PesoUsuarioController;
import entity.Peso;
import exception.BusinessException;
import java.awt.Component;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import model.PesoUsuarioModel;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.Binding;
import org.jdesktop.beansbinding.BindingGroup;
import org.jdesktop.beansbinding.Bindings;
import org.jdesktop.beansbinding.Converter;
import org.jdesktop.beansbinding.ELProperty;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import session.SessionManager;

/**
 *
 * @author winston.sonnesen
 */
public class ManutencaoPesoUsuarioView extends JInternalFrame {

    private PesoUsuarioModel model = new PesoUsuarioModel();
    private PesoUsuarioController controller = new PesoUsuarioController(model);

    /**
     * Creates new form ManutencaoProdutoView
     */
    public ManutencaoPesoUsuarioView() {
        initComponents();
        controller.carregarPesos(SessionManager.getUsuarioLogado());
        doBindings();
    }

    private void doBindings() {
        BindingGroup bindingGroup = new BindingGroup();

        JTableBinding jTableBinding = SwingBindings.createJTableBinding(AutoBinding.UpdateStrategy.READ, model,
                ELProperty.create("${pesos}"), masterTable);

        JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(ELProperty.create("${id}"));
        columnBinding.setColumnName("ID");
        columnBinding.setColumnClass(Long.class);

        columnBinding = jTableBinding.addColumnBinding(ELProperty.create("${data}"));
        columnBinding.setColumnName("Data");
        columnBinding.setColumnClass(Date.class);
        columnBinding.setConverter(new Converter() {

            @Override
            public Object convertForward(Object value) {
                String str = "";
                if (value != null) {
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    try {
                        str = sdf.format(value);
                    } catch (IllegalArgumentException ex) {

                    }
                }
                return str;
            }

            @Override
            public Object convertReverse(Object value) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                Date date = null;

                try {
                    date = sdf.parse(value.toString());
                } catch (ParseException ex) {
                    //Logger.getLogger(DoacaoView.class.getName()).log(Level.SEVERE, null, ex);
                }

                return date;
            }
        });

        columnBinding = jTableBinding.addColumnBinding(ELProperty.create("${peso}"));
        columnBinding.setColumnName("Peso");
        columnBinding.setColumnClass(Float.class);

        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();

        Binding binding = Bindings.createAutoBinding(AutoBinding.UpdateStrategy.READ_WRITE, model,
                ELProperty.create("${filterValue}"), filterValueField, BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        binding = Bindings.createAutoBinding(AutoBinding.UpdateStrategy.READ_WRITE, model,
                ELProperty.create("${filterCriteria}"), filterCriteriaField, BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        binding = Bindings.createAutoBinding(AutoBinding.UpdateStrategy.READ, model,
                ELProperty.create("${registroSelecionado != null}"), updateButton, BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        binding = Bindings.createAutoBinding(AutoBinding.UpdateStrategy.READ, model,
                ELProperty.create("${registroSelecionado != null}"), removeButton, BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);
        bindingGroup.bind();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        removeButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        masterTable = new javax.swing.JTable();
        updateButton = new javax.swing.JButton();
        filterCriteriaField = new javax.swing.JComboBox();
        applyFilterButton = new javax.swing.JButton();
        clearFilterButton = new javax.swing.JButton();
        filterValueField = new javax.swing.JFormattedTextField();

        setClosable(true);
        setIconifiable(true);
        setTitle("Consulta Peso");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        removeButton.setText("Remover");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        closeButton.setText("Fechar");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        addButton.setText("Adicionar");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        masterTable.setDefaultRenderer(Object.class, new PesoTableCellRenderer());
        masterTable.setModel(new PesoTableModel());
        masterTable.getSelectionModel().addListSelectionListener(new PesoMasterTableListSelectionListener());
        jScrollPane2.setViewportView(masterTable);

        updateButton.setText("Alterar");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        filterCriteriaField.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Data", "Peso" }));
        filterCriteriaField.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                filterCriteriaFieldItemStateChanged(evt);
            }
        });

        applyFilterButton.setText("Aplicar");
        applyFilterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applyFilterButtonActionPerformed(evt);
            }
        });

        clearFilterButton.setText("Limpar");
        clearFilterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearFilterButtonActionPerformed(evt);
            }
        });

        try {
            filterValueField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        filterValueField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                filterValueFieldKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 617, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(closeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(filterCriteriaField, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(filterValueField, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(applyFilterButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clearFilterButton)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filterCriteriaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(applyFilterButton)
                    .addComponent(clearFilterButton)
                    .addComponent(filterValueField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(removeButton)
                    .addComponent(closeButton)
                    .addComponent(updateButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
        model.setBackupRegistro(model.getRegistroSelecionado());
        Peso peso = new Peso();
        peso.setUsuario(SessionManager.getUsuarioLogado());
        model.setRegistroEditado(peso);
        new Thread(() -> {
            ManutencaoPesoUsuarioForm form = new ManutencaoPesoUsuarioForm((Frame) SwingUtilities.windowForComponent(this), true);
            form.setTitle("Adicionar Peso");
            form.setController(controller);
            form.setVisible(true);
        }).start();
    }//GEN-LAST:event_addButtonActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        // TODO add your handling code here:
        int opcao = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir o registro selecionado?",
                "Confirmação de remoção", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (opcao == JOptionPane.OK_OPTION) {
            try {
                controller.remove(model.getRegistroSelecionado());
            } catch (BusinessException ex) {
                Logger.getLogger(ManutencaoPesoUsuarioView.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_removeButtonActionPerformed

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_closeButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        // TODO add your handling code here:
        model.setBackupRegistro(model.getRegistroSelecionado());
        model.setRegistroEditado(model.getRegistroSelecionado());
        new Thread(() -> {
            ManutencaoPesoUsuarioForm form = new ManutencaoPesoUsuarioForm((Frame) SwingUtilities.windowForComponent(this), true);
            form.setTitle("Alterar Peso");
            form.setController(controller);
            form.setVisible(true);
        }).start();
    }//GEN-LAST:event_updateButtonActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        // TODO add your handling code here:
        DesktopManager.remove(DesktopManager.TELA_CONSULTA_PESO);
    }//GEN-LAST:event_formInternalFrameClosed

    private void applyFilterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyFilterButtonActionPerformed
        // TODO add your handling code here:
        controller.doFilter(model.getFilterValue(), model.getFilterCriteria());
    }//GEN-LAST:event_applyFilterButtonActionPerformed

    private void clearFilterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearFilterButtonActionPerformed
        // TODO add your handling code here:
        controller.carregarPesos(SessionManager.getUsuarioLogado());
        filterCriteriaField.setSelectedIndex(0);
    }//GEN-LAST:event_clearFilterButtonActionPerformed

    private void filterCriteriaFieldItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_filterCriteriaFieldItemStateChanged
        // TODO add your handling code here:
        try {
            filterValueField.setFormatterFactory(null);
            MaskFormatter mask;
            if (filterCriteriaField.getSelectedItem().equals("Data")) {
                mask = new MaskFormatter("##/##/####");
            } else {
                mask = new MaskFormatter("###,##");
            }
            mask.setValidCharacters("0123456789");
            filterValueField.setFormatterFactory(new DefaultFormatterFactory(mask));
            filterValueField.setText(null);
            filterValueField.setValue(null);
            model.setFilterValue(null);
            filterValueField.requestFocus();
        } catch (Exception ex) {
            Logger.getLogger(ManutencaoPesoUsuarioView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_filterCriteriaFieldItemStateChanged

    private void filterValueFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filterValueFieldKeyReleased
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            applyFilterButton.doClick();
        }
    }//GEN-LAST:event_filterValueFieldKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton applyFilterButton;
    private javax.swing.JButton clearFilterButton;
    private javax.swing.JButton closeButton;
    private javax.swing.JComboBox filterCriteriaField;
    private javax.swing.JFormattedTextField filterValueField;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable masterTable;
    private javax.swing.JButton removeButton;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables

    private class PesoTableModel extends AbstractTableModel {

        private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        private List<Peso> pesos;
        private final String[] columnNames = {"ID", "Data", "Peso"};
        private final int COLUMN_COUNT = columnNames.length;

        public PesoTableModel() {
            pesos = new ArrayList();
        }

        public PesoTableModel(List<Peso> pesos) {
            this();
            this.pesos.addAll(pesos);
        }

        @Override
        public int getRowCount() {
            return pesos.size();
        }

        @Override
        public int getColumnCount() {
            return COLUMN_COUNT;
        }

        @Override
        public String getColumnName(int i) {
            return columnNames[i];
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Peso peso = pesos.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    return peso.getId();
                case 1:
                    return peso.getData();
                case 2:
                    return peso.getPeso();
                default:
                    return "";
            }
        }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            Peso peso = pesos.get(rowIndex);
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            switch (columnIndex) {
                case 0:
                    try {
                        peso.setId(Long.parseLong(aValue.toString()));
                    } catch (NumberFormatException ex) {
                        Logger.getLogger(ManutencaoPesoUsuarioView.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case 1:
                    try {
                        peso.setData(df.parse(aValue.toString()));
                    } catch (ParseException ex) {
                        Logger.getLogger(ManutencaoPesoUsuarioView.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case 2:
                    try {
                        peso.setPeso(Long.parseLong(aValue.toString()));
                    } catch (NumberFormatException ex) {
                        Logger.getLogger(ManutencaoPesoUsuarioView.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case 3: {

                }
                break;
            }
            fireTableDataChanged();
        }

    }

    private class PesoMasterTableListSelectionListener implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (e.getValueIsAdjusting()) {
                return;
            }
            int row = masterTable.getSelectedRow();
            if (row >= 0) {
                Peso p = model.getPesos().get(row);
                model.setBackupRegistro(new Peso(p.getId(), p.getData(), p.getPeso(), p.getUsuario()));
                model.setRegistroSelecionado(new Peso(p.getId(), p.getData(), p.getPeso(), p.getUsuario()));
            }
        }
    }

    private class PesoTableCellRenderer extends JLabel implements TableCellRenderer {

        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            JLabel label = (JLabel) renderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (value instanceof Float) {
                DecimalFormat df = new DecimalFormat("#,##0.00");
                try {
                    label.setText(df.format(value));
                } catch (IllegalArgumentException ex) {
                    Logger.getLogger(PesoTableCellRenderer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return label;
        }

    }

}
