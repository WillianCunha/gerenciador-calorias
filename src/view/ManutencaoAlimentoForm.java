/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.AlimentoController;
import entity.CaracteristicaAlimento;
import entity.UnidadePadrao;
import exception.BusinessException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import model.AlimentoEnum;
import model.AlimentoModel;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.Binding;
import org.jdesktop.beansbinding.BindingGroup;
import org.jdesktop.beansbinding.Bindings;
import org.jdesktop.beansbinding.ELProperty;

/**
 *
 * @author Aluca
 */
public class ManutencaoAlimentoForm extends javax.swing.JDialog {

    private AlimentoController controller;
    private AlimentoModel model;

    /**
     * Creates new form ManutencaoAlimentoForm
     */
    public ManutencaoAlimentoForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    private void myInit() {
        AlimentoEnum[] alimentos = AlimentoEnum.values();
        DefaultComboBoxModel dcbm = new DefaultComboBoxModel();
        for (AlimentoEnum alimento : alimentos) {                        
            dcbm.addElement(alimento.getDescricao());
        }
        tipoCriteria.setModel(dcbm);
    }

    private void doBindings() {
        BindingGroup bindingGroup = new BindingGroup();

        Binding binding = Bindings.createAutoBinding(AutoBinding.UpdateStrategy.READ, model,
                ELProperty.create("${registroEditado.id}"), idField, BeanProperty.create("text"));
        binding.setSourceUnreadableValue("");
        bindingGroup.addBinding(binding);

        binding = Bindings.createAutoBinding(AutoBinding.UpdateStrategy.READ_WRITE, model,
                ELProperty.create("${registroEditado.nome}"), nomeField, BeanProperty.create("text"));
        binding.setSourceUnreadableValue("");
        bindingGroup.addBinding(binding);

        binding = Bindings.createAutoBinding(AutoBinding.UpdateStrategy.READ_WRITE, model,
                ELProperty.create("${registroEditado.tipo}"), tipoCriteria, BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        bindingGroup.bind();
    }

    public void setController(AlimentoController controller) {
        this.controller = controller;
        this.model = this.controller.getModel();
        doBindings();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tipoCriteria = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        masterTable = new javax.swing.JTable();
        addCaracteristicaButton = new javax.swing.JButton();
        removeCaracteristicaButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        idField = new javax.swing.JTextField();
        nomeField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("ID:");

        jLabel2.setText("Nome:");

        masterTable.setModel(new CaracteristicaAlimentoTableModel());
        jScrollPane1.setViewportView(masterTable);

        addCaracteristicaButton.setText("Adicionar Característica");

        removeCaracteristicaButton.setText("Remover Característica");

        cancelButton.setText("Fechar");

        saveButton.setText("Salvar");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        idField.setEditable(false);

        jLabel3.setText("Tipo:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(addCaracteristicaButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(removeCaracteristicaButton))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nomeField)
                            .addComponent(idField)
                            .addComponent(tipoCriteria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(saveButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nomeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tipoCriteria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addCaracteristicaButton)
                    .addComponent(removeCaracteristicaButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton)
                    .addComponent(saveButton))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        try {
            controller.saveAlimento(model.getRegistroEditado());
            JOptionPane.showMessageDialog(this, "Registro salvo com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        } catch (BusinessException ex) {
            Logger.getLogger(ManutencaoAlimentoForm.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addCaracteristicaButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField idField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable masterTable;
    private javax.swing.JTextField nomeField;
    private javax.swing.JButton removeCaracteristicaButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JComboBox tipoCriteria;
    // End of variables declaration//GEN-END:variables

    private class CaracteristicaAlimentoTableModel extends AbstractTableModel {

        private List<CaracteristicaAlimento> caracteristicas;
        private final String[] columnNames = {"ID", "Descrição", "Valor", "Unidade"};
        private final int COLUMN_COUNT = columnNames.length;

        public CaracteristicaAlimentoTableModel() {
            caracteristicas = new ArrayList();
        }

        public CaracteristicaAlimentoTableModel(List<CaracteristicaAlimento> caracteristicas) {
            this();
            this.caracteristicas.addAll(caracteristicas);
        }

        @Override
        public int getRowCount() {
            return caracteristicas.size();
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
            CaracteristicaAlimento caracteristica = caracteristicas.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    return caracteristica.getId();
                case 1:
                    return caracteristica.getDescricao();
                case 2:
                    return caracteristica.getValor();
                case 3:
                    return caracteristica.getUnidadePadrao();
                default:
                    return "";
            }
        }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            CaracteristicaAlimento caracteristica = caracteristicas.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    try {
                        caracteristica.setId(Long.parseLong(aValue.toString()));
                    } catch (NumberFormatException ex) {
                        Logger.getLogger(ManutencaoAlimentoForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case 1:
                    caracteristica.setDescricao(aValue.toString());
                    break;
                case 2:
                    try {
                        caracteristica.setValor(Float.parseFloat(aValue.toString()));
                    } catch (NumberFormatException ex) {
                        Logger.getLogger(ManutencaoAlimentoForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case 3:
                    caracteristica.setUnidadePadrao((UnidadePadrao) aValue);
                    break;
            }
            fireTableDataChanged();
        }
    }

    private class CaracteristicaAlimentoMasterTableListSelectionListener implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (e.getValueIsAdjusting()) {
                return;
            }
            int row = masterTable.getSelectedRow();
            if (row >= 0) {
                CaracteristicaAlimento c = model.getCaracteristicaAlimentos().get(row);
                model.setBackupRegistroCaracteristicaAlimento(new CaracteristicaAlimento(c.getId(), c.getDescricao(), c.getValor()));
                model.setRegistroSelecionadoCaracteristicaAlimento(new CaracteristicaAlimento(c.getId(), c.getDescricao(), c.getValor()));
            }
        }

    }

}
