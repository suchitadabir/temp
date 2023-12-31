/*
 * BrowseProducts.java
 *
 * Created on October 10, 2008, 9:10 AM
 */
package UserInterface.ManageTheBusiness;

import TheBusiness.Business.Business;
import TheBusiness.MarketModel.Channel;
import TheBusiness.MarketModel.Market;
import TheBusiness.MarketModel.MarketChannelAssignment;
import TheBusiness.MarketModel.MarketChannelComboCatalog;
import TheBusiness.MarketModel.SolutionOffer;
import TheBusiness.ProductManagement.Product;
import TheBusiness.SolutionOrders.SolutionOrder;
import TheBusiness.Supplier.Supplier;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author suchita
 */
public class CreateSolutionsJPanel extends javax.swing.JPanel {
JPanel userProcessContainer;
Business bz;
//SolutionOffer sol;
//SolutionOrder ord;
ArrayList<Product> productList;
SolutionOffer sol;
    public CreateSolutionsJPanel(Business b,JPanel userProcessContainer) {
        initComponents();
        this.bz = b;
        this.userProcessContainer = userProcessContainer;
        productList = new ArrayList<>();

        populateCombo();
        populateProductTable();
        populateCartTable();
      //  ord = bz.getMasterSolutionOrderList().newSolutionOrder(null, null);        

    }

    

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductCatalog = new javax.swing.JTable();
        lblSalesPrice = new javax.swing.JLabel();
        txtSalesPrice = new javax.swing.JTextField();
        lblQuantity = new javax.swing.JLabel();
        spnQuantity = new javax.swing.JSpinner();
        btnAddToCart = new javax.swing.JButton();
        lblItemsInCart = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCart = new javax.swing.JTable();
        txtNewQuantity = new javax.swing.JTextField();
        btnModifyQuantity = new javax.swing.JButton();
        btnCheckOut = new javax.swing.JButton();
        comboChannel = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        comboChannel1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(240, 240, 240));
        setPreferredSize(new java.awt.Dimension(650, 600));

        btnBack.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        tblProductCatalog.setFont(new java.awt.Font("Lucida Grande", 0, 13)); // NOI18N
        tblProductCatalog.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Name", "FP", "CP", "TP"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblProductCatalog);

        lblSalesPrice.setText("Sales Price:");

        lblQuantity.setText("Quantity:");

        spnQuantity.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        btnAddToCart.setText("Add to Cart");
        btnAddToCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddToCartActionPerformed(evt);
            }
        });

        lblItemsInCart.setText("Items in cart:");

        tblCart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Item Name", "Price", "Quantity", "Total Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblCart);

        btnModifyQuantity.setText("Modify Quantity");
        btnModifyQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifyQuantityActionPerformed(evt);
            }
        });

        btnCheckOut.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        btnCheckOut.setText("Check out");
        btnCheckOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckOutActionPerformed(evt);
            }
        });

        comboChannel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboChannelActionPerformed(evt);
            }
        });

        jLabel10.setText("Market-Channel");

        comboChannel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboChannel1ActionPerformed(evt);
            }
        });

        jButton1.setText("GET CHANNEL");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblSalesPrice)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtSalesPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(lblQuantity)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(spnQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnAddToCart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(171, 171, 171))
                        .addComponent(jScrollPane1)
                        .addComponent(lblItemsInCart)
                        .addComponent(jScrollPane2)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnModifyQuantity)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtNewQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(comboChannel, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(comboChannel1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jButton1)))))
                    .addComponent(btnCheckOut, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(86, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {spnQuantity, txtSalesPrice});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBack)
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(comboChannel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(7, 7, 7)
                .addComponent(comboChannel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSalesPrice)
                    .addComponent(txtSalesPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblQuantity)
                    .addComponent(spnQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddToCart))
                .addGap(18, 18, 18)
                .addComponent(lblItemsInCart)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModifyQuantity)
                    .addComponent(txtNewQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnCheckOut, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(73, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jScrollPane1, jScrollPane2});

    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
       
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnCheckOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckOutActionPerformed
        // TODO add your handling code here:
      // masterOrderList.addNewOrder(currentOrder);
       //currentOrder = new Order();
     //   populateCombo();
     //   populateProductTable();
    //    populateCartTable();
        MarketChannelComboCatalog mccc = bz.getMarketChannelComboCatalog();
        String MarketName = comboChannel1.getSelectedItem().toString();
        Market m = bz.getMarketCatalog().findMarket(MarketName);
        String ChannelName = comboChannel.getSelectedItem().toString();
        Channel c = bz.getChannelCatalog().findChannel(ChannelName);
     //   MarketChannelAssignment ma = mccc.newMarketChannelCombo(m, c);
        MarketChannelAssignment ma = mccc.finMarketChannelCombo(m, c);
  
        sol = bz.getSolutionOfferCatalog().newSolutionOffer(ma);
        for (Product p : productList) {
            sol.addProduct(p);
        }

        bz.getSolOfferMap().getSolutionOfferMap().put(String.valueOf(sol.getId()), sol);
        
        JOptionPane.showMessageDialog(this, "Solution Offer Created");

    }//GEN-LAST:event_btnCheckOutActionPerformed

    private void btnModifyQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifyQuantityActionPerformed
        // TODO add your handling code here:
     /*   int selectedRowIndex = tblCart.getSelectedRow();
        
        if(selectedRowIndex < 0){
            JOptionPane.showMessageDialog(this, "Please select the order item first.");
            return;     
        }
        OrderItem item = (OrderItem) tblCart.getValueAt(selectedRowIndex, 0);      
        int quant = 0;
        try{           
            quant = Integer.parseInt(txtNewQuantity.getText());            
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Please check the modified quantity field.");
            return;
        }
            int oldQuant = item.getQuantity();
            if( item.getProduct().getAvail() + oldQuant < quant){
             JOptionPane.showMessageDialog(this,"Please check product availibilty.");
             return;            
            }
            
            item.getProduct().setAvail(item.getProduct().getAvail() + oldQuant - quant);
            item.setQuantity(quant);
            populateCartTable();
            populateProductTable();
  */
    }//GEN-LAST:event_btnModifyQuantityActionPerformed

    private void btnAddToCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddToCartActionPerformed
        // TODO add your handling code here:
        int selectedRowIndex = tblProductCatalog.getSelectedRow();
        
        if(selectedRowIndex < 0){
            JOptionPane.showMessageDialog(this, "Please select the product first.");
            return;
        
        }
        Product product = (Product) tblProductCatalog.getValueAt(selectedRowIndex, 0);
        
        double salesPrice = 0.0;
        int quant = 0;
        
        try{           
            salesPrice = Double.parseDouble(txtSalesPrice.getText());
            quant = (Integer)spnQuantity.getValue();            
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Please check the price and quantity fields.");
            return;
        }
        
        if(salesPrice< product.getTargetPrice()){
             JOptionPane.showMessageDialog(this, "Price should be more than it is set in the price.");
             return;     
        }
       // product.
        productList.add(product);
      //  sol.addProduct(product);

       // OrderItem item = currentOrder.findProduct(product);
       /* 
        if(item == null){
        
            if(product.getAvail() >= quant){
               currentOrder.addNewOrderItem(product,salesPrice,quant);
               product.setAvail(product.getAvail() - quant);
               
               
            }else{
             JOptionPane.showMessageDialog(this,"Please check product availibilty.");
             return;
            }
            
        }else{
            int oldQuant = item.getQuantity();
            if( item.getProduct().getAvail() + oldQuant < quant){
             JOptionPane.showMessageDialog(this,"Please check product availibilty.");
             return;            
            }
            
            item.getProduct().setAvail(item.getProduct().getAvail() + oldQuant - quant);
            item.setQuantity(quant);
        
        }
        */
        populateProductTable();
        populateCartTable();
        
        
    }//GEN-LAST:event_btnAddToCartActionPerformed

    private void comboChannelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboChannelActionPerformed
        // TODO add your handling code here:
       // refreshSupplierProductCatalogTable();
    }//GEN-LAST:event_comboChannelActionPerformed

    private void comboChannel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboChannel1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboChannel1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
      //  comboChannel1.removeAllItems();
        String MarketName = comboChannel1.getSelectedItem().toString();
        Market m = bz.getMarketCatalog().findMarket(MarketName);
       // String MarketName = m.getName();
        
        for(Channel c : m.getValidchannels()){
            comboChannel.addItem(c.getChannelType());
            comboChannel.setSelectedIndex(0);     
        }
        
   
        
    }//GEN-LAST:event_jButton1ActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddToCart;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCheckOut;
    private javax.swing.JButton btnModifyQuantity;
    private javax.swing.JComboBox<String> comboChannel;
    private javax.swing.JComboBox<String> comboChannel1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblItemsInCart;
    private javax.swing.JLabel lblQuantity;
    private javax.swing.JLabel lblSalesPrice;
    private javax.swing.JSpinner spnQuantity;
    private javax.swing.JTable tblCart;
    private javax.swing.JTable tblProductCatalog;
    private javax.swing.JTextField txtNewQuantity;
    private javax.swing.JTextField txtSalesPrice;
    // End of variables declaration//GEN-END:variables

    private void populateCombo() {
        comboChannel.removeAllItems();
        comboChannel1.removeAllItems();
        for(Market m: bz.getMarketCatalog().getMarkets()){
            
            comboChannel1.addItem(m.getName());
            comboChannel1.setSelectedIndex(0);
        
        }
        
        
    }

    private void populateProductTable() {
        

        
        
        DefaultTableModel model = (DefaultTableModel) tblProductCatalog.getModel();
        model.setRowCount(0);

        for (Supplier s  : bz.getSupplierDirectory().getSuplierList()) {
            for(Product p : s.getProductCatalog().getProductList()){
            Object row[] = new Object[4];
            row[0] = p;
            row[1] = p.getFloorPrice();
            row[2] = p.getCeilingPrice();
            row[3] =p.getTargetPrice();
            model.addRow(row);
            }
        }

     
    }
    
   private void populateCartTable() {

        
        
       DefaultTableModel model = (DefaultTableModel) tblCart.getModel();
        model.setRowCount(0);

        for (Product p : productList) {
            Object row[] = new Object[4];
            row[0] = p;
            row[1] = p.getTargetPrice();
            model.addRow(row);
        }

     
    }


}
