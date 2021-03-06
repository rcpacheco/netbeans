/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

/*
 * STSVersionPanelUI.java
 *
 * Created on Aug 28, 2008, 4:41:01 PM
 */

package org.netbeans.modules.websvc.wsitconf.wizard;

import java.util.SortedSet;
import java.util.TreeSet;
import org.netbeans.api.project.Project;
import org.netbeans.modules.websvc.wsitconf.api.WSITConfigProvider;
import org.netbeans.modules.websvc.wsitmodelext.versioning.ConfigVersion;
import org.netbeans.modules.websvc.wsstack.api.WSStackVersion;

/**
 *
 * @author snajper
 */
public class STSVersionPanelUI extends javax.swing.JPanel {

    /** Creates new form STSVersionPanelUI */
    public STSVersionPanelUI(Project project) {        
        initComponents();

        // detect and fill appropriate config options
        WSStackVersion wsStackVersion = WSITConfigProvider.getDefault().getHighestWSStackVersion(project);
        for (ConfigVersion cfgVersion : ConfigVersion.values()) {
            if ((wsStackVersion != null) && (cfgVersion.isSupported(wsStackVersion) && (cfgVersion.isVisible()))) {
                versionCombo.addItem(cfgVersion);
            }
        }

        if (versionCombo.getItemCount() <= 0) {
            versionCombo.addItem(ConfigVersion.getDefault());
            versionCombo.setEnabled(false);
        }
        versionCombo.setSelectedIndex(versionCombo.getItemCount() - 1);
    }

    ConfigVersion getVersion() {
        return (ConfigVersion) versionCombo.getSelectedItem();
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        versionLabel = new javax.swing.JLabel();
        versionCombo = new javax.swing.JComboBox();

        versionLabel.setText(org.openide.util.NbBundle.getMessage(STSVersionPanelUI.class, "STSVersionPanelUI.versionLabel.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(versionLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(versionCombo, 0, 240, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(versionLabel)
                .addComponent(versionCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox versionCombo;
    private javax.swing.JLabel versionLabel;
    // End of variables declaration//GEN-END:variables

}
