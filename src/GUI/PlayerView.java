/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;


import NapakalakiGame.*;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JPanel;
/**
 *
 * @author Rusillo
 */
public class PlayerView extends javax.swing.JPanel {
    private Player playerModel;
    private Napakalaki napakalakiModel;
    
    public void setNapakalaki(Napakalaki model)
    {
        napakalakiModel = model;
    }
    
    private ArrayList<Treasure> getSelectedTreasures(JPanel aPanel){
        TreasureView tv;
        ArrayList<Treasure> output = new ArrayList();
        for (Component c : aPanel.getComponents() ){
            tv=(TreasureView) c;
            if(tv.isSelected())
                output.add(tv.getTreasure());
        }
        return output;
    }
    
    public void setPlayer(Player player){
        playerModel = player;
        this.jugadorTxt.setText(playerModel.getName());
        this.nivelTxt.setText(Integer.toString(playerModel.getLevels()));
        this.NCtext.setText(Integer.toString(playerModel.getCombatLevel()));
        this.enemigoTxt.setText(playerModel.getEnemy().getName());
        if(playerModel.getClass() == CultistPlayer.class)
            this.sectariotxt.setText("Si");
        else
            this.sectariotxt.setText("No");
       // this.nSectarios.setText(Integer.toString(playerModel.getTotalCultistPlayers()));
        
        this.fillTreasurePanel(VPanel,playerModel.getVisibleTreasures());
        this.fillTreasurePanel(OPanel, playerModel.getHiddenTreasures());
        
        this.pendingBadConsequence1.setPendingBadConsequence(playerModel.getPendingBadConsequence());
        this.StealTeasure.setEnabled(playerModel.canISteal());
             
        repaint();
        revalidate();
    }
    
    private void fillTreasurePanel (JPanel aPanel, ArrayList<Treasure> aList) {
        // Se elimina la información antigua, si la hubiera
        aPanel.removeAll();
        // Se recorre la lista de tesoros construyendo y añadiendo sus vistas
        // al panel
        for (Treasure t : aList) {
            TreasureView aTreasureView = new TreasureView();
            aTreasureView.setTreasure (t);
            aTreasureView.setVisible (true);
            aPanel.add (aTreasureView);
           // System.out.print("HHHHH");
            }
        // Se fuerza la actualización visual del panel
        aPanel.repaint();
        aPanel.revalidate();
    }
    
    public void setBC(BadConsequence bc){
        pendingBadConsequence1.setPendingBadConsequence(bc);
        repaint();
    }
    
        
    public void hacervisible(boolean make){
        makeVisible.setEnabled(make);
        DiscardAll.setEnabled(make);
        DiscardTreasure.setEnabled(make);
        StealTeasure.setEnabled(make);
    }
    
    public PlayerView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        VPanel = new javax.swing.JPanel();
        TesorosV = new javax.swing.JLabel();
        OPanel = new javax.swing.JPanel();
        jugador = new javax.swing.JLabel();
        jugadorTxt = new javax.swing.JLabel();
        niveltxt = new javax.swing.JLabel();
        nivelTxt = new javax.swing.JLabel();
        NC = new javax.swing.JLabel();
        NCtext = new javax.swing.JLabel();
        enemigo = new javax.swing.JLabel();
        enemigoTxt = new javax.swing.JLabel();
        sectario = new javax.swing.JLabel();
        sectariotxt = new javax.swing.JLabel();
        makeVisible = new javax.swing.JButton();
        StealTeasure = new javax.swing.JButton();
        DiscardTreasure = new javax.swing.JButton();
        DiscardAll = new javax.swing.JButton();
        pendingBadConsequence1 = new GUI.PendingBadConsequence();
        TesorosO = new javax.swing.JLabel();

        VPanel.setBackground(new java.awt.Color(250, 250, 250));
        VPanel.setToolTipText("");
        VPanel.setPreferredSize(new java.awt.Dimension(471, 471));

        TesorosV.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        TesorosV.setText("TESOROS VISIBLES");
        VPanel.add(TesorosV);

        OPanel.setBackground(new java.awt.Color(140, 140, 140));
        OPanel.setMaximumSize(new java.awt.Dimension(471, 471));
        OPanel.setMinimumSize(new java.awt.Dimension(471, 471));
        OPanel.setPreferredSize(new java.awt.Dimension(471, 471));

        jugador.setText("Jugador:");

        jugadorTxt.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jugadorTxt.setText("jugadorTxt");

        niveltxt.setText("Nivel: ");

        nivelTxt.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nivelTxt.setText("nivelTxt");

        NC.setText("Nivel Combate:");

        NCtext.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        NCtext.setText("NCTxt");

        enemigo.setText("Enemigo:");

        enemigoTxt.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        enemigoTxt.setText("Enemigotxt");

        sectario.setText("Sectario:");

        sectariotxt.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        sectariotxt.setText("sectariotxt");

        makeVisible.setText("Hacer Visible");
        makeVisible.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                makeVisibleActionPerformed(evt);
            }
        });

        StealTeasure.setText("Robar Tesoro");
        StealTeasure.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StealTeasureActionPerformed(evt);
            }
        });

        DiscardTreasure.setText("Descartar Tesoro");
        DiscardTreasure.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DiscardTreasureActionPerformed(evt);
            }
        });

        DiscardAll.setText("Descartar TODOS los Tesoros");
        DiscardAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DiscardAllActionPerformed(evt);
            }
        });

        TesorosO.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        TesorosO.setText("TESOROS OCULTOS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(NC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(niveltxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jugador))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jugadorTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(NCtext)
                                    .addComponent(nivelTxt))
                                .addGap(45, 111, Short.MAX_VALUE)
                                .addComponent(enemigo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(enemigoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(sectario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(sectariotxt)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(pendingBadConsequence1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(DiscardTreasure, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(DiscardAll))
                                .addGap(234, 234, 234))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(makeVisible, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(StealTeasure, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(VPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(OPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGap(649, 649, 649)
                .addComponent(TesorosO)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jugadorTxt)
                            .addComponent(jugador)
                            .addComponent(enemigo)
                            .addComponent(enemigoTxt))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(niveltxt)
                            .addComponent(nivelTxt))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NCtext)
                            .addComponent(NC))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(sectario)
                            .addComponent(sectariotxt)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(makeVisible)
                                    .addComponent(StealTeasure))
                                .addGap(31, 31, 31)
                                .addComponent(DiscardTreasure)
                                .addGap(43, 43, 43)
                                .addComponent(DiscardAll))
                            .addComponent(pendingBadConsequence1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(26, 26, 26)
                .addComponent(VPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TesorosO)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(OPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void StealTeasureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StealTeasureActionPerformed
        if(playerModel.stealTreasure()!=null)
            StealTeasure.setEnabled(false);
        playerModel.stealTreasure();
        
        setPlayer(napakalakiModel.getCurrentPlayer());
    }//GEN-LAST:event_StealTeasureActionPerformed

    private void makeVisibleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makeVisibleActionPerformed
        ArrayList<Treasure> selHidden = getSelectedTreasures(OPanel);
        napakalakiModel.makeTreasuresVisible(selHidden);
        setPlayer(napakalakiModel.getCurrentPlayer());
    //    repaint();
    }//GEN-LAST:event_makeVisibleActionPerformed

    private void DiscardAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DiscardAllActionPerformed
        playerModel.discardAllTreasures();
        setPlayer(napakalakiModel.getCurrentPlayer());
       // repaint();
    }//GEN-LAST:event_DiscardAllActionPerformed

    private void DiscardTreasureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DiscardTreasureActionPerformed
        ArrayList<Treasure> selVisible = getSelectedTreasures(VPanel);
        napakalakiModel.discardVisibleTreasures(selVisible);
        
        ArrayList<Treasure> selHidden = getSelectedTreasures(OPanel);
        napakalakiModel.discardHiddenTreasures(selHidden);
        
        setPlayer(napakalakiModel.getCurrentPlayer());
       // repaint();
    }//GEN-LAST:event_DiscardTreasureActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DiscardAll;
    private javax.swing.JButton DiscardTreasure;
    private javax.swing.JLabel NC;
    private javax.swing.JLabel NCtext;
    private javax.swing.JPanel OPanel;
    private javax.swing.JButton StealTeasure;
    private javax.swing.JLabel TesorosO;
    private javax.swing.JLabel TesorosV;
    private javax.swing.JPanel VPanel;
    private javax.swing.JLabel enemigo;
    private javax.swing.JLabel enemigoTxt;
    private javax.swing.JLabel jugador;
    private javax.swing.JLabel jugadorTxt;
    private javax.swing.JButton makeVisible;
    private javax.swing.JLabel nivelTxt;
    private javax.swing.JLabel niveltxt;
    private GUI.PendingBadConsequence pendingBadConsequence1;
    private javax.swing.JLabel sectario;
    private javax.swing.JLabel sectariotxt;
    // End of variables declaration//GEN-END:variables
}
