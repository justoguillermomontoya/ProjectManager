package com.elle.ProjectManager.presentation;

import com.elle.ProjectManager.logic.Tab;
import com.elle.ProjectManager.logic.TableFilter;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Louis W.
 * @author Carlos Igreja
 * @since June 10, 2015
 * @version 0.6.3
 */
public class BatchEditWindow extends JFrame {

    // attributes
    private ProjectManagerWindow projectManagerWindow;
    private JTable table;
    private Tab tab;

    //misc
    private boolean batchEditWindowShow;
    private boolean btnConfirmClicked;

    /**
     * CONSTRUCTOR Creates new BatchEditWindow
     */
    public BatchEditWindow() {
        initComponents();
        projectManagerWindow = ProjectManagerWindow.getInstance();
        Map<String, Tab> tabs = projectManagerWindow.getTabs();
        String tabName = projectManagerWindow.getSelectedTabName();
        tab = tabs.get(tabName);
        table = tab.getTable();

        String[] batchEditFields = tab.getBatchEditFields();
        DefaultComboBoxModel model = new DefaultComboBoxModel(batchEditFields);
        comboBoxFieldSelect.setModel(model);

        this.setKeyBoardFocusManager();

        projectManagerWindow.setIsBatchEditWindowShow(true);

        batchEditWindowShow = true;
        btnConfirmClicked = false;

        // set the interface to the middle of the window
        this.setLocationRelativeTo(projectManagerWindow);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); // quit button should be used
        this.setTitle("Batch Editor");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        comboBoxFieldSelect = new javax.swing.JComboBox();
        textFieldNewValue = new javax.swing.JTextField();
        btnCancel = new javax.swing.JButton();
        btnConfirm = new javax.swing.JButton();
        btnQuit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        comboBoxFieldSelect.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "analyst", "priority", "dateAssigned", "notes", "symbol", "dateDone", " ", " ", " " }));
        comboBoxFieldSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxFieldSelectActionPerformed(evt);
            }
        });

        textFieldNewValue.setText("Please enter new value");
        textFieldNewValue.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textFieldNewValueFocusGained(evt);
            }
        });
        textFieldNewValue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldNewValueActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comboBoxFieldSelect, 0, 119, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(textFieldNewValue, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxFieldSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldNewValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnConfirm.setText("Confirm");
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });

        btnQuit.setText("Close");
        btnQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnQuit, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel)
                    .addComponent(btnConfirm)
                    .addComponent(btnQuit))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * clears the text field
     *
     * @param evt
     */
    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        textFieldNewValue.setText("");
    }//GEN-LAST:event_btnCancelActionPerformed

    /**
     * submit changes to the database
     *
     * @param evt
     */
    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed

        projectManagerWindow.makeTableEditable(true);

        String columnName = comboBoxFieldSelect.getSelectedItem().toString();      // column name   
        String newValue = textFieldNewValue.getText();                             // new value to replace old value(s)
        int[] rows = table.getSelectedRows();                                      // selected rows

        projectManagerWindow.loadTableWhenSelectedRows(rows, table);               // move seleted rows to end

        rows = table.getSelectedRows();

        int columnIndex;                                                           // column index
        int rowIndex;                                                              // row index
        int rowCount = table.getSelectedRowCount();                                // number of rows

        // get column index for the combobox selection
        for (columnIndex = 0; columnIndex < table.getColumnCount(); columnIndex++) {
            if (columnName.equals(table.getColumnName(columnIndex))) {
                break;
            }
        }

        // set the value to the table model
        // this also envokes the TableModelListener 
        // and adds the change to the mofified data list for the table
        for (rowIndex = 0; rowIndex < rowCount; rowIndex++) {
            table.setValueAt(newValue, rows[rowIndex], columnIndex);
        }
//        projectManagerWindow.loadTableWhenSelectedRows(rows, table);

        // Add any new changes to be filtered as well
        // so that the records modified do not disappear after the upload.
        TableFilter filter = tab.getFilter();

        // get the filter items for this column
        ArrayList<Object> filterItems
                = new ArrayList<>(filter.getFilterItems().get(columnIndex));

        if (!filterItems.isEmpty()) {
            if (!filterItems.contains(newValue)) {

                // add item to the array
                filterItems.add(newValue);

                // add the array to the filter items list
                filter.addFilterItems(columnIndex, filterItems);
            }
        }
        btnConfirmClicked = true;
    }//GEN-LAST:event_btnConfirmActionPerformed

    /**
     * This terminates the window and returns resources
     *
     * @param evt
     */
    private void btnQuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitActionPerformed

        // set the states for the editing tab
        tab.setBatchEditWindowOpen(false);
        tab.setBatchEditWindowVisible(false);
        tab.setBatchEditBtnEnabled(true);

        // set the batch edit button enabled
        projectManagerWindow.getBtnBatchEdit().setEnabled(true);

        batchEditWindowShow = false;

        projectManagerWindow.setIsBatchEditWindowShow(false);
        // this instance should dispose
        projectManagerWindow.getBatchEditWindow().dispose();
        projectManagerWindow.setIsBatchEditWindowShow(false);

//        projectManagerWindow.loadTable(table);
//        if(!btnConfirmClicked){
//        projectManagerWindow.makeTableEditable(false);
//        }

    }//GEN-LAST:event_btnQuitActionPerformed

    private void textFieldNewValueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldNewValueActionPerformed
//        jString.setText("");
    }//GEN-LAST:event_textFieldNewValueActionPerformed

    private void textFieldNewValueFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textFieldNewValueFocusGained
        textFieldNewValue.setText("");
    }//GEN-LAST:event_textFieldNewValueFocusGained

    private void comboBoxFieldSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxFieldSelectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxFieldSelectActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        projectManagerWindow.makeTableEditable(false);
        this.dispose();
        projectManagerWindow.setIsBatchEditWindowShow(false);
    }//GEN-LAST:event_formWindowClosing

    private void setKeyBoardFocusManager() {

        table.setFocusTraversalKeysEnabled(false);

        KeyboardFocusManager focusFrame = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        if (focusFrame.getFocusOwner() != this) {
            System.out.println("the focus owner is not this!");
            focusFrame.clearFocusOwner();
            this.requestFocus();
        }
        focusFrame.addKeyEventDispatcher(new KeyEventDispatcher() {

            @Override
            public boolean dispatchKeyEvent(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_D && e.isControlDown()) {
                    String columnName = comboBoxFieldSelect.getSelectedItem().toString();      // column name  
                    System.out.println("control d pressed! " + columnName);
                    if (columnName.equals("dateDone")) {
                        if (e.getID() != 401) { // 401 = key down, 402 = key released
                            return false;
                        } else {
                            JTextField selectCom = (JTextField) e.getComponent();
                            selectCom.requestFocusInWindow();
                            selectCom.selectAll();
                            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                            Date date = new Date();
                            String today = dateFormat.format(date);
                            selectCom.setText(today);
                        }
                    }
                } else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    projectManagerWindow.makeTableEditable(true);

                    String columnName = comboBoxFieldSelect.getSelectedItem().toString();      // column name   
                    String newValue = textFieldNewValue.getText();                             // new value to replace old value(s)
                    int[] rows = table.getSelectedRows();                                      // selected rows

                    projectManagerWindow.loadTableWhenSelectedRows(rows, table);               // move seleted rows to end

                    rows = table.getSelectedRows();

                    int columnIndex;                                                           // column index
                    int rowIndex;                                                              // row index
                    int rowCount = table.getSelectedRowCount();                                // number of rows

                    // get column index for the combobox selection
                    for (columnIndex = 0; columnIndex < table.getColumnCount(); columnIndex++) {
                        if (columnName.equals(table.getColumnName(columnIndex))) {
                            break;
                        }
                    }

                    // set the value to the table model
                    // this also envokes the TableModelListener 
                    // and adds the change to the mofified data list for the table
                    for (rowIndex = 0; rowIndex < rowCount; rowIndex++) {
                        table.setValueAt(newValue, rows[rowIndex], columnIndex);
                    }
                    //        projectManagerWindow.loadTableWhenSelectedRows(rows, table);

                    // Add any new changes to be filtered as well
                    // so that the records modified do not disappear after the upload.
                    TableFilter filter = tab.getFilter();

                    // get the filter items for this column
                    ArrayList<Object> filterItems
                            = new ArrayList<>(filter.getFilterItems().get(columnIndex));

                    if (!filterItems.isEmpty()) {
                        if (!filterItems.contains(newValue)) {

                            // add item to the array
                            filterItems.add(newValue);

                            // add the array to the filter items list
                            filter.addFilterItems(columnIndex, filterItems);
                        }
                    }
                    btnConfirmClicked = true;
                }
                return false;
            }

        });
    }

    public boolean isBatchEditWindowShow() {
        return batchEditWindowShow;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnConfirm;
    private javax.swing.JButton btnQuit;
    private javax.swing.JComboBox comboBoxFieldSelect;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField textFieldNewValue;
    // End of variables declaration//GEN-END:variables
}
