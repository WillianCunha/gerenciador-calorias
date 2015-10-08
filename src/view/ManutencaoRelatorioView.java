/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.RelatorioController;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import model.IndiceNivelAtividadeEnum;
import model.RelatorioModel;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.Binding;
import org.jdesktop.beansbinding.BindingGroup;
import org.jdesktop.beansbinding.Bindings;
import org.jdesktop.beansbinding.Converter;
import org.jdesktop.beansbinding.ELProperty;
import session.SessionManager;

/**
 *
 * @author visitante
 */
public class ManutencaoRelatorioView extends javax.swing.JInternalFrame {

    private RelatorioModel model = new RelatorioModel();
    private RelatorioController controller = new RelatorioController(model);

    /**
     * Creates new form TelaRelatório
     */
    public ManutencaoRelatorioView() {
        initComponents();
        controller.carregarPesoAtual(SessionManager.getUsuarioLogado());
        controller.getModel().setRegistroEditado(SessionManager.getUsuarioLogado());
        myInit();
        doBindings();
    }
    
    private void myInit() {
        IndiceNivelAtividadeEnum[] niveis = IndiceNivelAtividadeEnum.values();
        DefaultComboBoxModel dcbm = new DefaultComboBoxModel();
        for (IndiceNivelAtividadeEnum nivel : niveis) {
            dcbm.addElement(nivel.getDescricao());
        }
        nivelAtividadeField.setModel(dcbm);
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
                ELProperty.create("${registroEditado.altura}"), alturaField, BeanProperty.create("text"));
        binding.setSourceUnreadableValue("");
        bindingGroup.addBinding(binding);
        
        binding = Bindings.createAutoBinding(AutoBinding.UpdateStrategy.READ_WRITE, model,
                ELProperty.create("${registroEditado.peso}"), pesoField, BeanProperty.create("text"));
        binding.setSourceUnreadableValue("");
        bindingGroup.addBinding(binding);
        
        binding = Bindings.createAutoBinding(AutoBinding.UpdateStrategy.READ_WRITE, model,
                ELProperty.create("${registroEditado.dataNascimento}"), dataNascimentoField, BeanProperty.create("text"));
        binding.setSourceUnreadableValue("");
        binding.setConverter(new Converter() {

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
        bindingGroup.addBinding(binding);
        
        binding = Bindings.createAutoBinding(AutoBinding.UpdateStrategy.READ_WRITE, model,
                ELProperty.create("${registroEditado.genero}"), generoField, BeanProperty.create("text"));
        binding.setSourceUnreadableValue("");
        bindingGroup.addBinding(binding);
        
//        binding = Bindings.createAutoBinding(AutoBinding.UpdateStrategy.READ_WRITE, model,
//                ELProperty.create("${registroEditado.imc}"), imcField, BeanProperty.create("text"));
//        binding.setSourceUnreadableValue("");
//        bindingGroup.addBinding(binding);
        
        binding = Bindings.createAutoBinding(AutoBinding.UpdateStrategy.READ_WRITE, model,
                ELProperty.create("${registroEditado.nivelAtividade}"), nivelAtividadeField, BeanProperty.create("selectedItem"));
        binding.setSourceUnreadableValue("");
        bindingGroup.addBinding(binding);
        
//        binding = Bindings.createAutoBinding(AutoBinding.UpdateStrategy.READ_WRITE, model,
//                ELProperty.create("${registroEditado.cotaCalorica}"), cotaCaloricaField, BeanProperty.create("text"));
//        binding.setSourceUnreadableValue("");
//        bindingGroup.addBinding(binding);
        
        bindingGroup.bind();
    }

    public void setController(RelatorioController controller) {
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        idField = new javax.swing.JTextField();
        nomeField = new javax.swing.JTextField();
        alturaField = new javax.swing.JTextField();
        pesoField = new javax.swing.JTextField();
        dataNascimentoField = new javax.swing.JTextField();
        generoField = new javax.swing.JTextField();
        imcField = new javax.swing.JTextField();
        cotaCaloricaField = new javax.swing.JTextField();
        closeButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        nivelAtividadeField = new javax.swing.JComboBox();

        setClosable(true);
        setIconifiable(true);
        setTitle("Relatório");
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

        jLabel1.setText("ID:");

        jLabel2.setText("Nome:");

        jLabel3.setText("Altura:");

        jLabel4.setText("Peso:");

        jLabel5.setText("Data de Nascimento:");

        jLabel6.setText("Gênero:");

        jLabel7.setText("IMC:");

        jLabel8.setText("Nível de Atividade Física:");

        jLabel9.setText("Cota Calórica Diária:");

        idField.setEditable(false);
        idField.setEnabled(false);

        imcField.setEditable(false);
        imcField.setEnabled(false);

        cotaCaloricaField.setEditable(false);
        cotaCaloricaField.setEnabled(false);

        closeButton.setText("Fechar");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        saveButton.setText("Salvar");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idField)
                            .addComponent(nomeField)
                            .addComponent(alturaField)
                            .addComponent(pesoField)
                            .addComponent(dataNascimentoField)
                            .addComponent(generoField)
                            .addComponent(imcField)
                            .addComponent(cotaCaloricaField)
                            .addComponent(nivelAtividadeField, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 236, Short.MAX_VALUE)
                        .addComponent(saveButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(closeButton)))
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
                    .addComponent(jLabel3)
                    .addComponent(alturaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(pesoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(dataNascimentoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(generoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(imcField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(nivelAtividadeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cotaCaloricaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(closeButton)
                    .addComponent(saveButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        DesktopManager.remove(DesktopManager.MANUTENCAO_RELATORIO_VIEW);
    }//GEN-LAST:event_formInternalFrameClosed

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        dispose();
    }//GEN-LAST:event_closeButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saveButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField alturaField;
    private javax.swing.JButton closeButton;
    private javax.swing.JTextField cotaCaloricaField;
    private javax.swing.JTextField dataNascimentoField;
    private javax.swing.JTextField generoField;
    private javax.swing.JTextField idField;
    private javax.swing.JTextField imcField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JComboBox nivelAtividadeField;
    private javax.swing.JTextField nomeField;
    private javax.swing.JTextField pesoField;
    private javax.swing.JButton saveButton;
    // End of variables declaration//GEN-END:variables
}
