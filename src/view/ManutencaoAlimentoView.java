/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.AlimentoController;
import entity.Alimento;
import exception.BusinessException;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import model.AlimentoModel;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.Binding;
import org.jdesktop.beansbinding.BindingGroup;
import org.jdesktop.beansbinding.Bindings;
import org.jdesktop.beansbinding.ELProperty;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

/**
 *
 * @author Aluca
 */
public class ManutencaoAlimentoView extends javax.swing.JInternalFrame {

    private AlimentoModel model = new AlimentoModel();
    private AlimentoController controller = new AlimentoController(model);

    /**
     * Creates new form TelaConsultaAlimento
     */
    public ManutencaoAlimentoView() {
        initComponents();
        controller.carregarAlimentos();
        doBindings();
    }
    
    private void doBindings() {
        BindingGroup bindingGroup = new BindingGroup();
        
        JTableBinding jTableBinding = SwingBindings.createJTableBinding(AutoBinding.UpdateStrategy.READ, model,
                ELProperty.create("${alimentos}"), masterTable);
        
        JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(ELProperty.create("${id}"));
        columnBinding.setColumnName("ID");
        columnBinding.setColumnClass(Long.class);
        
        columnBinding = jTableBinding.addColumnBinding(ELProperty.create("${nome}"));
        columnBinding.setColumnName("Nome");
        columnBinding.setColumnClass(String.class);      
        
        columnBinding = jTableBinding.addColumnBinding(ELProperty.create("${tipo}"));
        columnBinding.setColumnName("Tipo");
        columnBinding.setColumnClass(String.class);
        
        // Adicionar demais colunas (Porção, Calorias, Unidade (?))
        
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

        filterValueField = new javax.swing.JTextField();
        filterCriteriaField = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        masterTable = new javax.swing.JTable();
        addButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        applyFilterButton = new javax.swing.JButton();
        clearFilterButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Consulta de Alimento");
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

        filterValueField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                filterValueFieldKeyReleased(evt);
            }
        });

        filterCriteriaField.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nome", "Tipo" }));
        filterCriteriaField.setToolTipText("Tipo de pesquisa a ser feita");

        masterTable.setModel(new AlimentoTableModel());
        jScrollPane1.setViewportView(masterTable);

        addButton.setText("Adicionar");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        updateButton.setText("Alterar");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        removeButton.setText("Remover");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
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

        closeButton.setText("Fechar");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(closeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(filterCriteriaField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(filterValueField)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(applyFilterButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clearFilterButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filterValueField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filterCriteriaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(applyFilterButton)
                    .addComponent(clearFilterButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(updateButton)
                    .addComponent(removeButton)
                    .addComponent(closeButton))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        DesktopManager.remove(DesktopManager.TELA_CONSULTA_ALIMENTO);
    }//GEN-LAST:event_formInternalFrameClosed

    private void filterValueFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filterValueFieldKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            applyFilterButton.doClick();
        }
    }//GEN-LAST:event_filterValueFieldKeyReleased

    private void clearFilterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearFilterButtonActionPerformed
        controller.carregarAlimentos();
        filterCriteriaField.setSelectedIndex(0);
    }//GEN-LAST:event_clearFilterButtonActionPerformed

    private void applyFilterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyFilterButtonActionPerformed
        controller.doFilter(model.getFilterValue(), model.getFilterCriteria());
    }//GEN-LAST:event_applyFilterButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        model.setBackupRegistro(model.getRegistroSelecionado());
        model.setRegistroEditado(model.getRegistroSelecionado());
        new Thread(() -> {
            ManutencaoAlimentoForm form = new ManutencaoAlimentoForm((Frame) SwingUtilities.windowForComponent(this), true);
            form.setTitle("Alterar Alimento");
            form.setController(controller);
            form.setVisible(true);
        }).start();
    }//GEN-LAST:event_updateButtonActionPerformed

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        dispose();
    }//GEN-LAST:event_closeButtonActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        int opcao = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir o registro selecionado?",
                "Confirmação de remoção", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (opcao == JOptionPane.OK_OPTION) {
            try {
                controller.remove(model.getRegistroSelecionado());
            } catch (BusinessException ex) {
                Logger.getLogger(ManutencaoAlimentoView.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_removeButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        model.setBackupRegistro(model.getRegistroSelecionado());
        Alimento alimento = new Alimento();
        model.setRegistroEditado(alimento);
        new Thread(() -> {
            ManutencaoAlimentoForm form = new ManutencaoAlimentoForm((Frame) SwingUtilities.windowForComponent(this), true);
            form.setTitle("Adicionar Alimento");
            form.setController(controller);
            form.setVisible(true);
        }).start();
    }//GEN-LAST:event_addButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton applyFilterButton;
    private javax.swing.JButton clearFilterButton;
    private javax.swing.JButton closeButton;
    private javax.swing.JComboBox filterCriteriaField;
    private javax.swing.JTextField filterValueField;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable masterTable;
    private javax.swing.JButton removeButton;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables

    private class AlimentoTableModel extends AbstractTableModel {

        private List<Alimento> alimentos;
        private final String[] columnNames = {"ID", "Nome", "Tipo"};
        private final int COLUMN_COUNT = columnNames.length;

        public AlimentoTableModel() {
            alimentos = new ArrayList();
        }

        public AlimentoTableModel(List<Alimento> alimentos) {
            this();
            this.alimentos.addAll(alimentos);
        }

        @Override
        public int getRowCount() {
            return alimentos.size();
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
            Alimento alimento = alimentos.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    return alimento.getId();
                case 1:
                    return alimento.getNome();
                case 2:
                    return alimento.getTipo();
                default:
                    return "";
            }
        }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            Alimento alimento = alimentos.get(rowIndex);

            switch (columnIndex) {
                case 0:
                    try {
                        alimento.setId(Long.parseLong(aValue.toString()));
                    } catch (NumberFormatException ex) {
                        Logger.getLogger(ManutencaoAlimentoView.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case 1:
                    alimento.setNome(aValue.toString());
                    break;
                case 2:
                    alimento.setTipo(aValue.toString());
                    break;
            }
            fireTableDataChanged();
        }
    }

    private class AlimentoMasterTableListSelectionListener implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (e.getValueIsAdjusting()) {
                return;
            }
            int row = masterTable.getSelectedRow();
            if (row >= 0) {
                Alimento a = model.getAlimentos().get(row);
                model.setBackupRegistro(new Alimento(a.getId(), a.getNome(), a.getTipo()));
                model.setRegistroSelecionado(new Alimento(a.getId(), a.getNome(), a.getTipo()));
            }
        }
    }
}
