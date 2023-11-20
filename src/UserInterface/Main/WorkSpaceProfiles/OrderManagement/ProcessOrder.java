/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Main.WorkSpaceProfiles.OrderManagement;

import UserInterface.ProductManagement.*;
import TheBusiness.Business.Business;
import TheBusiness.CustomerManagement.CustomerProfile;
import TheBusiness.MarketModel.Channel;
import TheBusiness.MarketModel.Market;
import TheBusiness.MarketModel.MarketChannelAssignment;
import TheBusiness.MarketModel.SolutionOffer;
import TheBusiness.OrderManagement.MasterOrderList;
import TheBusiness.OrderManagement.Order;
import TheBusiness.OrderManagement.OrderItem;
import TheBusiness.ProductManagement.Product;
import TheBusiness.ProductManagement.ProductCatalog;
import TheBusiness.ProductManagement.ProductSummary;
import TheBusiness.SalesManagement.SalesPersonProfile;
import TheBusiness.Supplier.Supplier;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kal bugrara
 */
public class ProcessOrder extends javax.swing.JPanel {

    /**
     * Creates new form ManageSuppliersJPanel
     */
    JPanel CardSequencePanel;
    Business business;
    Supplier selectedsupplier;
    Product selectedproduct;
    Order currentOrder;
    CustomerProfile customer;
    SalesPersonProfile salesperson;
    Market m;

    public ProcessOrder(Business bz, CustomerProfile cp, SalesPersonProfile spp, JPanel jp) {

        CardSequencePanel = jp;
        this.business = bz;
        initComponents();
        customer = cp;
        salesperson = spp;
        salesPersonTextField.setText(salesperson.getPerson().toString());
        customerTextField1.setText(customer.getCustomerId());
        m = customer.getMarkets().get(0);
        txtMarket.setText(m.getName());
        
        MasterOrderList mol = business.getMasterOrderList();
        currentOrder =  mol.newOrder(customer, salesperson); //no order was made yet
        initializeTable();

    }

    private void initializeTable() {

//clear supplier table
        cleanUpCombobox();
        cleanUpTable();
        
        
        

//load suppliers to the combobox
        ArrayList<Supplier> supplierlist = business.getSupplierDirectory().getSuplierList();
        String MarketName = m.getName();
        
        
        for(Channel c : m.getValidchannels()){
            comboChannel.addItem(c.getChannelType());
            comboChannel.setSelectedIndex(0);     
        }
        String type = comboChannel.getSelectedItem().toString();
        Channel c = business.getChannelCatalog().findChannel(type);
        System.out.println("$$$$$$$$"+c.getChannelType());
        MarketChannelAssignment mca = business.getMarketChannelComboCatalog().finMarketChannelCombo(m, c);
        System.out.println("$$$$$$$$"+mca);
        ArrayList<SolutionOffer> solnList = business.getSolutionOfferCatalog().findSolutionsForMarketChannelCombo(mca);
        System.out.println("$$$$$$$$"+solnList);
        if (solnList.isEmpty()) {
            return;
        }
        
        for(SolutionOffer s : solnList){
        SuppliersComboBox1.addItem(String.valueOf(s.getId()));
        SuppliersComboBox1.setSelectedIndex(0);
        }
        
        String id = SuppliersComboBox1.getSelectedItem().toString();
        
        SolutionOffer so = business.getSolOfferMap().findKey(id);
        
        System.out.println("$$$$$$$$ . "+so.getProducts());
        for (Product pt : so.getProducts()) {
            System.out.println("$$$$$$$$ . "+pt);
            //SuppliersComboBox1.addItem(s.toString());
            //SuppliersComboBox1.setSelectedIndex(0);
            /*String suppliername = (String) SuppliersComboBox1.getSelectedItem();
            selectedsupplier = business.getSupplierDirectory().findSupplier(suppliername);
            ProductCatalog pc = selectedsupplier.getProductCatalog();
            for (Product pt : pc.getProductList()) {*/

                Object[] row = new Object[4];
                row[0] = pt;
                row[1] = pt.getFloorPrice();
                row[2] = pt.getCeilingPrice();
                row[3] = pt.getTargetPrice();

                ((DefaultTableModel) SupplierCatalogTable.getModel()).addRow(row);
          //  }

        }
    }

    public void cleanUpCombobox() {
        //Clean the combobox for supplier choices

        comboChannel.removeAllItems();
        SuppliersComboBox1.removeAllItems();

    }

    public void cleanUpTable() {

        //Clean the product catalog table
        int rc = SupplierCatalogTable.getRowCount();
        int i;
        for (i = rc - 1; i >= 0; i--) {
            ((DefaultTableModel) SupplierCatalogTable.getModel()).removeRow(i);
        }
    }
    public void cleanUpItemsTable() {

        //Clean the product catalog table
        int rc = OrderItemsTable.getRowCount();
        int i;
        for (i = rc - 1; i >= 0; i--) {
            ((DefaultTableModel) OrderItemsTable.getModel()).removeRow(i);
        }
    }

    public void refreshSupplierProductCatalogTable() {

//clear supplier table
        int rc = SupplierCatalogTable.getRowCount();
        int i;
        for (i = rc - 1; i >= 0; i--) {
            ((DefaultTableModel) SupplierCatalogTable.getModel()).removeRow(i);
        }

        String suppliername = (String) SuppliersComboBox1.getSelectedItem();

        selectedsupplier = business.getSupplierDirectory().findSupplier(suppliername);
        if (selectedsupplier == null) {
            return;
        }
        ProductCatalog pc = selectedsupplier.getProductCatalog();

        for (Product pt : pc.getProductList()) {

            Object[] row = new Object[4];
            row[0] = pt;
            row[1] = pt.getFloorPrice();
            row[2] = pt.getCeilingPrice();
            row[3] = pt.getTargetPrice();
//                row[1] = pt.getPerformanceMeasure();
//               row[2] = la.getName();
            ((DefaultTableModel) SupplierCatalogTable.getModel()).addRow(row);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Back = new javax.swing.JButton();
        Next = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        SupplierCatalogTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        OrderItemsTable = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        comboChannel = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        txtMarket = new javax.swing.JTextField();
        salesPersonTextField = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        productFrequencyBelowTargetTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        productFrequencyAboveTargetTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        productPricePerformanceTextField = new javax.swing.JTextField();
        productRevenueTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        productNameTextField = new javax.swing.JTextField();
        customerTextField1 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        SuppliersComboBox1 = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(0, 153, 153));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Back.setText("X Cancel");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });
        add(Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 480, 80, -1));

        Next.setText("Submit");
        Next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextActionPerformed(evt);
            }
        });
        add(Next, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 440, 80, -1));

        jLabel1.setText("Suppliers");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 60, -1));

        SupplierCatalogTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Name", "Floor", "Ceiling", "Target"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        SupplierCatalogTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SupplierCatalogTableMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                SupplierCatalogTableMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(SupplierCatalogTable);

        jScrollPane2.setViewportView(jScrollPane1);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 600, 110));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel2.setText("Prepare Order");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 550, -1));

        jLabel8.setText("Product");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, 20));

        OrderItemsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product", "Actual price", "Quanity", "Item total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        OrderItemsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                OrderItemsTableMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                OrderItemsTableMousePressed(evt);
            }
        });
        jScrollPane4.setViewportView(OrderItemsTable);

        jScrollPane3.setViewportView(jScrollPane4);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 600, 100));

        jLabel9.setText("Order Items");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, 20));

        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddProductItemActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 140, 90, 30));

        comboChannel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboChannelActionPerformed(evt);
            }
        });
        add(comboChannel, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 90, 160, -1));

        jLabel10.setText("Market-Channel");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 40, 150, -1));
        add(txtMarket, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 60, 160, -1));
        add(salesPersonTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 60, 160, -1));

        jLabel11.setText("Sales person");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 40, 150, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Business-wide Product Intelligence", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 14))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setText("Frequency Below Target");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, 150, -1));
        jPanel1.add(productFrequencyBelowTargetTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 70, 150, -1));

        jLabel4.setText("Frequency Above Target");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, 150, -1));
        jPanel1.add(productFrequencyAboveTargetTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 150, -1));

        jLabel7.setText("Marign around target");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 150, -1));

        productPricePerformanceTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productPricePerformanceTextFieldActionPerformed(evt);
            }
        });
        jPanel1.add(productPricePerformanceTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, 150, -1));

        productRevenueTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productRevenueTextFieldActionPerformed(evt);
            }
        });
        jPanel1.add(productRevenueTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 150, -1));

        jLabel5.setText("Sales Revenues");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 110, -1));

        jLabel3.setText("Product name");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 110, -1));

        productNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productNameTextFieldActionPerformed(evt);
            }
        });
        jPanel1.add(productNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 150, -1));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 600, 170));
        jPanel1.getAccessibleContext().setAccessibleName("Business -wide Product Intelligence");

        add(customerTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, 160, -1));

        jLabel12.setText("Customer");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, 150, -1));

        SuppliersComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SuppliersComboBox1ActionPerformed(evt);
            }
        });
        add(SuppliersComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 180, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        // TODO add your handling code here:
        currentOrder.CancelOrder();
        CardSequencePanel.remove(this);
        ((java.awt.CardLayout) CardSequencePanel.getLayout()).next(CardSequencePanel);

    }//GEN-LAST:event_BackActionPerformed

    private void NextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextActionPerformed
        // TODO add your handling code here:
        currentOrder.Submit();
        CardSequencePanel.remove(this);
        ((java.awt.CardLayout) CardSequencePanel.getLayout()).next(CardSequencePanel);


    }//GEN-LAST:event_NextActionPerformed

    private void SupplierCatalogTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SupplierCatalogTableMousePressed
        // TODO add your handling code here:
        int suppliertablesize = SupplierCatalogTable.getRowCount();
        int selectedrow = SupplierCatalogTable.getSelectionModel().getLeadSelectionIndex();

        if (selectedrow < 0 || selectedrow > suppliertablesize - 1) {
            return;
        }
        selectedproduct = (Product) SupplierCatalogTable.getValueAt(selectedrow, 0);
        if (selectedproduct == null) {
            return;
        }

        ProductSummary productsummary = new ProductSummary(selectedproduct);

        productNameTextField.setText(selectedproduct.toString());
        String revenues = String.valueOf(productsummary.getSalesRevenues());
        productRevenueTextField.setText(revenues);
        productFrequencyAboveTargetTextField.setText(String.valueOf(productsummary.getNumberAboveTarget()));
        productFrequencyBelowTargetTextField.setText(String.valueOf(productsummary.getNumberBelowTarget()));
        productPricePerformanceTextField.setText(String.valueOf(productsummary.getProductPricePerformance()));

    }//GEN-LAST:event_SupplierCatalogTableMousePressed

    private void productNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_productNameTextFieldActionPerformed

    private void productRevenueTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productRevenueTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_productRevenueTextFieldActionPerformed

    private void productPricePerformanceTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productPricePerformanceTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_productPricePerformanceTextFieldActionPerformed

    private void SupplierCatalogTableMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SupplierCatalogTableMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_SupplierCatalogTableMouseEntered

    private void OrderItemsTableMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OrderItemsTableMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_OrderItemsTableMouseEntered

    private void OrderItemsTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OrderItemsTableMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_OrderItemsTableMousePressed

    private void AddProductItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddProductItemActionPerformed
        // TODO add your handling code here:
        String MarketName = m.getName();
     //   currentOrder.getMca()
        int suppliertablesize = SupplierCatalogTable.getRowCount();
        int selectedrow = SupplierCatalogTable.getSelectionModel().getLeadSelectionIndex();

        if (selectedrow < 0 || selectedrow > suppliertablesize - 1) {
            return;
        }
        selectedproduct = (Product) SupplierCatalogTable.getValueAt(selectedrow, 0);
        if (selectedproduct == null) return;
        
        OrderItem item = currentOrder.newOrderItem(selectedproduct, 1000, 1);
            Object[] row = new Object[5];

            row[0] = String.valueOf(item.getSelectedProduct());
            row[1] = String.valueOf(item.getActualPrice());
            row[2] = String.valueOf(item.getQuantity());
            row[3] = String.valueOf(item.getOrderItemTotal());

            ((DefaultTableModel) OrderItemsTable.getModel()).addRow(row);
 
            

    }//GEN-LAST:event_AddProductItemActionPerformed

    private void comboChannelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboChannelActionPerformed
        // TODO add your handling code here:
     refreshSupplierProductCatalogTable();
    }//GEN-LAST:event_comboChannelActionPerformed

    private void SuppliersComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SuppliersComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SuppliersComboBox1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JButton Next;
    private javax.swing.JTable OrderItemsTable;
    private javax.swing.JTable SupplierCatalogTable;
    private javax.swing.JComboBox<String> SuppliersComboBox1;
    private javax.swing.JComboBox<String> comboChannel;
    private javax.swing.JTextField customerTextField1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField productFrequencyAboveTargetTextField;
    private javax.swing.JTextField productFrequencyBelowTargetTextField;
    private javax.swing.JTextField productNameTextField;
    private javax.swing.JTextField productPricePerformanceTextField;
    private javax.swing.JTextField productRevenueTextField;
    private javax.swing.JTextField salesPersonTextField;
    private javax.swing.JTextField txtMarket;
    // End of variables declaration//GEN-END:variables

}