/*
 * VectorSymbolPanel.java
 *
 * Created on July 6, 2006, 8:36 AM
 */

package ika.gui;

import ika.geo.VectorSymbol;

/**
 *
 * @author  Bernhard Jenny, Institute of Cartography, ETH Zurich.
 */
public class VectorSymbolPanel extends javax.swing.JPanel {
    
    private VectorSymbol vs;
    private boolean updating = false;
    
    /** Creates new form VectorSymbolPanel */
    public VectorSymbolPanel() {
        initComponents();
    }
    
    public void setVectorSymbol(VectorSymbol vs) {
        this.vs = vs;
        this.write();
    }
    
    public VectorSymbol getVectorSymbol() {
        return this.vs;
    }
    
    public void write() {
        if (this.vs == null) {
            // stroke
            this.strokeWidthNumberField.setEnabled(false);
            this.strokeCheckBox.setEnabled(false);
            this.strokeColorButton.setEnabled(false);
            
            // fill
            this.fillCheckBox.setEnabled(false);
            this.fillColorButton.setEnabled(false);
            return;
        }
        
        // stroke
        this.strokeWidthNumberField.setEnabled(true);
        this.strokeCheckBox.setEnabled(true);
        this.strokeColorButton.setEnabled(true);
        
        // fill
        this.fillCheckBox.setEnabled(true);
        this.fillColorButton.setEnabled(true);
        
        try {
            updating = true;
            
            // stroke
            this.strokeWidthNumberField.setDoubleValue(vs.getStrokeWidth());
            this.strokeCheckBox.setSelected(vs.isStroked());
            this.strokeColorButton.setColor(vs.getStrokeColor());
            
            // fill
            this.fillCheckBox.setSelected(vs.isFilled());
            java.awt.Color fillColor = vs.getFillColor();
            this.fillColorButton.setColor(fillColor);
            final int alpha = 255 - fillColor.getAlpha();
            this.colorTransparencySlider.setValue(alpha);
            this.colorTransparencyNumberField.setDoubleValue(alpha);
        } finally {
            updating = false;
        }
    }
    
    public void read() {
        if (updating)
            return;
        
        if (this.vs == null)
            return;
        
        VectorSymbol old_vs = (VectorSymbol)this.vs.clone();
        
        // stroke
        vs.setStrokeWidth((float)this.strokeWidthNumberField.getDoubleValue());
        vs.setStroked(this.strokeCheckBox.isSelected());
        vs.setStrokeColor(this.strokeColorButton.getColor());
        
        // fill
        vs.setFilled(this.fillCheckBox.isSelected());
        java.awt.Color fillColor = this.fillColorButton.getColor();
        
        final int alpha = 255 - colorTransparencySlider.getValue();
        fillColor = new java.awt.Color(fillColor.getRed(), fillColor.getGreen(),
                fillColor.getBlue(), alpha);
        vs.setFillColor(fillColor);
        
        this.firePropertyChange("vectorsymbol", old_vs, this.vs);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        strokeLabel = new javax.swing.JLabel();
        strokeCheckBox = new javax.swing.JCheckBox();
        strokeColorButton = new ika.gui.ColorButton();
        strokeWidthNumberField = new ika.gui.NumberField();
        fillLabel = new javax.swing.JLabel();
        fillCheckBox = new javax.swing.JCheckBox();
        fillColorButton = new ika.gui.ColorButton();
        colorTransparencySlider = new javax.swing.JSlider();
        colorTransparencyNumberField = new ika.gui.NumberField();
        jLabel7 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(150, 176));
        setLayout(new java.awt.GridBagLayout());

        strokeLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        strokeLabel.setText("Stroke:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        add(strokeLabel, gridBagConstraints);

        strokeCheckBox.setSelected(true);
        strokeCheckBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        strokeCheckBox.setMargin(new java.awt.Insets(0, 0, 0, 0));
        strokeCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                strokeCheckBoxgeometryActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 8, 0, 0);
        add(strokeCheckBox, gridBagConstraints);

        strokeColorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                strokeColorButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        add(strokeColorButton, gridBagConstraints);

        strokeWidthNumberField.setMin(0.0);
        strokeWidthNumberField.setPreferredSize(new java.awt.Dimension(60, 28));
        strokeWidthNumberField.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                strokeWidthNumberFieldpropertyChange(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        add(strokeWidthNumberField, gridBagConstraints);

        fillLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        fillLabel.setText("Fill:");
        fillLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        add(fillLabel, gridBagConstraints);

        fillCheckBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        fillCheckBox.setMargin(new java.awt.Insets(0, 0, 0, 0));
        fillCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fillCheckBoxgeometryActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 8, 0, 0);
        add(fillCheckBox, gridBagConstraints);

        fillColorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fillColorButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        add(fillColorButton, gridBagConstraints);

        colorTransparencySlider.setMajorTickSpacing(85);
        colorTransparencySlider.setMaximum(255);
        colorTransparencySlider.setMinorTickSpacing(17);
        colorTransparencySlider.setPaintLabels(true);
        colorTransparencySlider.setPaintTicks(true);
        colorTransparencySlider.setValue(0);
        colorTransparencySlider.setPreferredSize(new java.awt.Dimension(90, 52));
        colorTransparencySlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                colorTransparencySlidercolorSliderStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 88;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        add(colorTransparencySlider, gridBagConstraints);

        colorTransparencyNumberField.setMax(255.0);
        colorTransparencyNumberField.setMin(0.0);
        colorTransparencyNumberField.setPattern("#.#");
        colorTransparencyNumberField.setPreferredSize(new java.awt.Dimension(50, 28));
        colorTransparencyNumberField.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                colorTransparencyNumberFieldPropertyChange(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        add(colorTransparencyNumberField, gridBagConstraints);

        jLabel7.setText("Transparency:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        add(jLabel7, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents
    
    private void colorTransparencyNumberFieldPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_colorTransparencyNumberFieldPropertyChange
        if (evt.getSource() instanceof NumberField
                && !"value".equals(evt.getPropertyName()))
            return;
        
        if (this.updating)
            return;
        try {
            this.updating = true;
            final int alpha = (int)this.colorTransparencyNumberField.getDoubleValue();
            this.colorTransparencySlider.setValue(alpha);
        } finally {
            this.updating = false;
        }
        this.read();
    }//GEN-LAST:event_colorTransparencyNumberFieldPropertyChange
    
    private void colorTransparencySlidercolorSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_colorTransparencySlidercolorSliderStateChanged
        if (this.updating)
            return;
        try {
            this.updating = true;
            final int alpha = this.colorTransparencySlider.getValue();
            this.colorTransparencyNumberField.setDoubleValue(alpha);
        } finally {
            this.updating = false;
        }
        
        this.read();
    }//GEN-LAST:event_colorTransparencySlidercolorSliderStateChanged
    
    private void fillColorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fillColorButtonActionPerformed
        this.fillCheckBox.setSelected(true);
        this.read();
    }//GEN-LAST:event_fillColorButtonActionPerformed
    
    private void fillCheckBoxgeometryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fillCheckBoxgeometryActionPerformed
        this.read();
    }//GEN-LAST:event_fillCheckBoxgeometryActionPerformed
    
    private void strokeWidthNumberFieldpropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_strokeWidthNumberFieldpropertyChange
        if (evt.getSource() instanceof NumberField
                && !"value".equals(evt.getPropertyName()))
            return;
        this.read();
    }//GEN-LAST:event_strokeWidthNumberFieldpropertyChange
    
    private void strokeColorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_strokeColorButtonActionPerformed
        this.strokeCheckBox.setSelected(true);
        this.read();
    }//GEN-LAST:event_strokeColorButtonActionPerformed
    
    private void strokeCheckBoxgeometryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_strokeCheckBoxgeometryActionPerformed
        this.read();
    }//GEN-LAST:event_strokeCheckBoxgeometryActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private ika.gui.NumberField colorTransparencyNumberField;
    private javax.swing.JSlider colorTransparencySlider;
    private javax.swing.JCheckBox fillCheckBox;
    private ika.gui.ColorButton fillColorButton;
    private javax.swing.JLabel fillLabel;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JCheckBox strokeCheckBox;
    private ika.gui.ColorButton strokeColorButton;
    private javax.swing.JLabel strokeLabel;
    private ika.gui.NumberField strokeWidthNumberField;
    // End of variables declaration//GEN-END:variables
    
}
