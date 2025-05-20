/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Finals;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Finals.Login;

public class SKIBIDIS extends javax.swing.JFrame {
    
    
    

    
    
    
    private String loggedInUserFile;

    public SKIBIDIS(String username) {
        initComponents();
        
      DefaultTableModel model = new DefaultTableModel(
            new String[]{"Full Name", "Contact #", "Address", "Amount of Loan", "Years", "Months", "Interest Rate", "Monthly Payment", "Total Payment"}, 0
        );
        TABLE.setModel(model);
        loggedInUserFile = "C:\\Users\\Eunace Faith Emactao\\OneDrive\\Documents\\assignments\\LOAN CALCULATOR SYSTEM\\LOAN CALCULATOR STORAGE FINAL.txt";

        loadUserTableData();
    }

    private void loadUserTableData() {
        DefaultTableModel model = (DefaultTableModel) TABLE.getModel();
        model.setRowCount(0);  // clear table

        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Eunace Faith Emactao\\OneDrive\\Documents\\assignments\\LOAN CALCULATOR SYSTEM\\LOAN CALCULATOR STORAGE FINAL.txt"))) {
            String line;
            String currentUsername = "";
            boolean isCurrentUser = false;
            String fullName = "", contact = "", address = "", amountOfLoan = "", years = "", months = "", 
                   interestRate = "", monthlyPayment = "", totalPayment = "";

            while ((line = reader.readLine()) != null) {
                line = line.trim();
                
                if (line.startsWith("Username:")) {
                    currentUsername = line.substring(9).trim();
                    isCurrentUser = currentUsername.equals(Login.Myusername);
                } else if (isCurrentUser) {
                    if (line.startsWith("Full Name:")) {
                        fullName = line.substring(10).trim();
                    } else if (line.startsWith("Contact #:")) {
                        contact = line.substring(10).trim();
                    } else if (line.startsWith("Address:")) {
                        address = line.substring(8).trim();
                    } else if (line.startsWith("Amount of Loan:")) {
                        amountOfLoan = line.substring(15).trim();
                    } else if (line.startsWith("Loan Duration:")) {
                        String duration = line.substring(14).trim();
                        if (duration.contains("Years")) {
                            years = duration.split("Years")[0].trim();
                        }
                        if (duration.contains("Months")) {
                            months = duration.split("Months")[0].trim();
                            if (months.contains("Years")) {
                                months = months.split("Years")[1].trim();
                            }
                        }
                    } else if (line.startsWith("Interest Rate:")) {
                        interestRate = line.substring(14).trim().replace("%", "");
                    } else if (line.startsWith("Monthly Payment:")) {
                        monthlyPayment = line.substring(16).trim();
                    } else if (line.startsWith("Total Payment:")) {
                        totalPayment = line.substring(14).trim();
                    } else if (line.equals("========================================")) {
                        if (!fullName.isEmpty() && !address.isEmpty() && !amountOfLoan.isEmpty()) {
                            model.addRow(new Object[]{
                                fullName,
                                contact,
                                address,
                                amountOfLoan,
                                years.isEmpty() ? "N/A" : years,
                                months.isEmpty() ? "N/A" : months,
                                interestRate,
                                monthlyPayment,
                                totalPayment
                            });
                            fullName = contact = address = amountOfLoan = years = months = 
                            interestRate = monthlyPayment = totalPayment = "";
                        }
                    }
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error loading user loan data: " + ex.getMessage());
        }
    }

    private void saveUserLoan(String fullName, String contact, String address, String amountOfLoan, String years,
                               String months, String interestRate, String monthlyPayment, String totalPayment) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Eunace Faith Emactao\\OneDrive\\Documents\\assignments\\LOAN CALCULATOR SYSTEM\\LOAN CALCULATOR STORAGE FINAL.txt", true))) {
            writer.write("\n========================================\n");
            writer.write("LOAN DETAILS\n");
            writer.write("========================================\n");
            writer.write("Full Name: " + fullName + "\n");
            writer.write("Contact #: " + contact + "\n");
            writer.write("Address: " + address + "\n");
            writer.write("Amount of Loan: ₱" + amountOfLoan + "\n");
            writer.write("Loan Duration: ");
            if (!years.equals("N/A")) {
                writer.write(years + " Years ");
            }
            if (!months.equals("N/A")) {
                writer.write(months + " Months");
            }
            writer.write("\n");
            writer.write("Interest Rate: " + interestRate + "%\n");
            writer.write("Monthly Payment: " + monthlyPayment + "\n");
            writer.write("Total Payment: " + totalPayment + "\n");
            writer.write("========================================\n");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error saving user loan data: " + ex.getMessage());
        }
    }
    public SKIBIDIS() {
        initComponents();

        DefaultTableModel model = new DefaultTableModel(
                new String[]{"Full Name", "Address", "Amount of Loan", "Years", "Months", "Interest Rate", "Monthly Payment", "Total Payment"}, 0
        );
        TABLE.setModel(model);

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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        CALCULATE = new javax.swing.JButton();
        ADDLOAN = new javax.swing.JButton();
        DELETE = new javax.swing.JButton();
        SHOW = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        FULLNAME = new javax.swing.JTextField();
        ADDRESS = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        AMOUNTOFLOAN = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        YEARS = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        INTERESTRATE = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        MONTHLYPAYMENT = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        TOTALPAYMENT = new javax.swing.JTextField();
        MONTHS = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TABLE = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        CONTACT = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1200, 800));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setMinimumSize(new java.awt.Dimension(1720, 1030));
        jPanel1.setPreferredSize(new java.awt.Dimension(1720, 1030));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(144, 190, 109));

        jLabel1.setBackground(new java.awt.Color(51, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("LOAN CALCULATOR SYSTEM");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(446, 446, 446)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1631, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 1730, 130));

        jPanel3.setBackground(new java.awt.Color(144, 190, 109));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("EXIT ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 30, 210, 80));

        CALCULATE.setBackground(new java.awt.Color(255, 255, 255));
        CALCULATE.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        CALCULATE.setForeground(new java.awt.Color(0, 0, 0));
        CALCULATE.setText("CALCULATE LOAN");
        CALCULATE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CALCULATEActionPerformed(evt);
            }
        });
        jPanel3.add(CALCULATE, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 210, 80));

        ADDLOAN.setBackground(new java.awt.Color(255, 255, 255));
        ADDLOAN.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        ADDLOAN.setForeground(new java.awt.Color(0, 0, 0));
        ADDLOAN.setText("ADD LOAN");
        ADDLOAN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADDLOANActionPerformed(evt);
            }
        });
        jPanel3.add(ADDLOAN, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 30, 210, 80));

        DELETE.setBackground(new java.awt.Color(255, 255, 255));
        DELETE.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        DELETE.setForeground(new java.awt.Color(0, 0, 0));
        DELETE.setText("DELETE");
        DELETE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DELETEActionPerformed(evt);
            }
        });
        jPanel3.add(DELETE, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 30, 210, 80));

        SHOW.setBackground(new java.awt.Color(255, 255, 255));
        SHOW.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        SHOW.setForeground(new java.awt.Color(0, 0, 0));
        SHOW.setText("SHOW");
        SHOW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SHOWActionPerformed(evt);
            }
        });
        jPanel3.add(SHOW, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 30, 210, 80));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 640, 1670, 150));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setMinimumSize(new java.awt.Dimension(1600, 1030));
        jPanel4.setPreferredSize(new java.awt.Dimension(1600, 1030));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(0, 153, 153));

        jLabel3.setBackground(new java.awt.Color(51, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("LOAN CALCULATOR SYSTEM");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1728, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1720, 130));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("FULL NAME:");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));
        jPanel4.add(FULLNAME, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 230, 40));

        ADDRESS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADDRESSActionPerformed(evt);
            }
        });
        jPanel4.add(ADDRESS, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 230, 40));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("ADDRESS:");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("AMOUNT OF");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, -1, -1));

        AMOUNTOFLOAN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AMOUNTOFLOANActionPerformed(evt);
            }
        });
        jPanel4.add(AMOUNTOFLOAN, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 280, 230, 40));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("YEARS:");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, -1, -1));
        jPanel4.add(YEARS, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 330, 230, 40));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("   RATE:");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 450, -1, -1));
        jPanel4.add(INTERESTRATE, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 430, 230, 40));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("MONTHLY");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 500, -1, -1));

        MONTHLYPAYMENT.setBackground(new java.awt.Color(144, 190, 109));
        jPanel4.add(MONTHLYPAYMENT, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 480, 230, 70));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("TOTAL ");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 570, -1, -1));

        TOTALPAYMENT.setBackground(new java.awt.Color(144, 190, 109));
        TOTALPAYMENT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TOTALPAYMENTActionPerformed(evt);
            }
        });
        jPanel4.add(TOTALPAYMENT, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 560, 230, 70));
        jPanel4.add(MONTHS, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 380, 230, 40));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("MONTHS:");
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, -1, -1));

        TABLE.setBackground(new java.awt.Color(255, 255, 255));
        TABLE.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        TABLE.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "FULL NAME", "ADDRESS", "Contact #", "AMOUNT OF LOAN", "YEARS", "MONTHS", "INTEREST RATE", "MONTHLY PAYMENT", "TOTAL PAYMENT"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TABLE.setToolTipText("");
        jScrollPane1.setViewportView(TABLE);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 130, 1210, 510));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("LOAN:");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, -1, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("INTEREST ");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, -1, -1));

        CONTACT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CONTACTActionPerformed(evt);
            }
        });
        jPanel4.add(CONTACT, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, 230, 40));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("CONTACT #:");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 90, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("   PAYMENT:");
        jPanel4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 510, 90, 30));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("PAYMENT:");
        jPanel4.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 590, -1, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 0, 1640, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1623, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        int result = JOptionPane.showConfirmDialog(this, // Reference to the current SKIBIDIS JFrame
                "Are you sure you want to log out?",
                "Confirm Logout",
                JOptionPane.YES_NO_OPTION
        );

        if (result == JOptionPane.YES_OPTION) {
            dispose();
            new Login().setVisible(true);
        }


    }//GEN-LAST:event_jButton1ActionPerformed
    public static double Pmt(double r, double n, double p) {

        if (r == 0) {

            return -p / n;
        } else {

            return r * p / (1 - Math.pow(1 + r, -n));
        }
    }


    private void CALCULATEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CALCULATEActionPerformed

        try {
            // Get input values from your fields
            String fullName = FULLNAME.getText().trim();
            String address = ADDRESS.getText().trim();

            // Check if required fields are empty
            StringBuilder missingFields = new StringBuilder();

            if (fullName.isEmpty()) {
                missingFields.append("Full Name\n");
            }
            if (address.isEmpty()) {
                missingFields.append("Address\n");
            }
            if (AMOUNTOFLOAN.getText().trim().isEmpty()) {
                missingFields.append("Loan Amount\n");
            }
            if (INTERESTRATE.getText().trim().isEmpty()) {
                missingFields.append("Interest Rate\n");
            }

            // Check if both years and months are empty
            String yearsText = YEARS.getText().trim();
            String monthsText = MONTHS.getText().trim();

            if (yearsText.isEmpty() && monthsText.isEmpty()) {
                missingFields.append("Either Years or Months\n");
            }

            // If any fields are missing, show an error message
            if (missingFields.length() > 0) {
                JOptionPane.showMessageDialog(this,
                        "Please fill in the following fields:\n" + missingFields.toString(),
                        "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Get loan amount and interest rate
            double loanAmount = Double.parseDouble(AMOUNTOFLOAN.getText());
            double annualInterestRate = Double.parseDouble(INTERESTRATE.getText());

            // Parse YEARS and MONTHS fields (only one needs to be provided)
            int years = 0;
            int months = 0;

            if (!yearsText.isEmpty()) {
                years = Integer.parseInt(yearsText);
            }
            if (!monthsText.isEmpty()) {
                months = Integer.parseInt(monthsText);
            }

            // Calculate total number of payments
            int numberOfPayments = (years * 12) + months;

            if (numberOfPayments <= 0) {
                JOptionPane.showMessageDialog(this,
                        "Please enter a valid number of Years, Months, or both.",
                        "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Calculate monthly interest rate
            double monthlyInterestRate = annualInterestRate / 12 / 100;

            // Calculate monthly payment
            double monthlyPayment;
            if (monthlyInterestRate > 0) {
                monthlyPayment = (loanAmount * monthlyInterestRate)
                        / (1 - Math.pow(1 + monthlyInterestRate, -numberOfPayments));
            } else {
                // If interest rate is 0, simple division
                monthlyPayment = loanAmount / numberOfPayments;
            }

            // Calculate total payment
            double totalPayment = monthlyPayment * numberOfPayments;

            // Display results with Peso sign
            MONTHLYPAYMENT.setText("₱" + String.format("%.2f", monthlyPayment));
            TOTALPAYMENT.setText("₱" + String.format("%.2f", totalPayment));

            // Optionally, display the full name and address in console
            System.out.println("Customer Full Name: " + fullName);
            System.out.println("Customer Address: " + address);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Please enter valid numbers in all fields.",
                    "Input Error", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_CALCULATEActionPerformed

    private void ADDLOANActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADDLOANActionPerformed
        String fullName = FULLNAME.getText().trim();
        String contact = CONTACT.getText().trim();
        String address = ADDRESS.getText().trim();
        String amountOfLoan = AMOUNTOFLOAN.getText().trim();
        String years = YEARS.getText().trim();
        String months = MONTHS.getText().trim();
        String interestRate = INTERESTRATE.getText().trim();
        String monthlyPayment = MONTHLYPAYMENT.getText().trim();
        String totalPayment = TOTALPAYMENT.getText().trim();

        // Validate inputs
        if (fullName.isEmpty() || contact.isEmpty() || address.isEmpty() || amountOfLoan.isEmpty()
                || interestRate.isEmpty() || monthlyPayment.isEmpty() || totalPayment.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all required fields.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (years.isEmpty() && months.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter either Years or Months.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Add to table
        DefaultTableModel model = (DefaultTableModel) TABLE.getModel();
        model.addRow(new Object[]{
            fullName,
            contact,
            address,
            amountOfLoan,
            years.isEmpty() ? "N/A" : years,
            months.isEmpty() ? "N/A" : months,
            interestRate,
            monthlyPayment,
            totalPayment
        });

        // Save to user's file
        saveUserLoan(fullName, contact, address, amountOfLoan, 
                    years.isEmpty() ? "N/A" : years,
                    months.isEmpty() ? "N/A" : months,
                    interestRate, monthlyPayment, totalPayment);

        // Clear input fields
        FULLNAME.setText("");
        CONTACT.setText("");
        ADDRESS.setText("");
        AMOUNTOFLOAN.setText("");
        YEARS.setText("");
        MONTHS.setText("");
        INTERESTRATE.setText("");
        MONTHLYPAYMENT.setText("");
        TOTALPAYMENT.setText("");

        JOptionPane.showMessageDialog(null, "Loan added successfully!", "LOAN", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_ADDLOANActionPerformed

    private void DELETEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DELETEActionPerformed
        try {
            // Read all lines from the file
            File file = new File("C:\\Users\\Eunace Faith Emactao\\OneDrive\\Documents\\assignments\\LOAN CALCULATOR SYSTEM\\LOAN CALCULATOR STORAGE FINAL.txt");
            java.util.List<String> lines = new java.util.ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    lines.add(line);
                }
            }

            // Create a temporary file
            File tempFile = new File(file.getAbsolutePath() + ".tmp");
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
                boolean isCurrentUser = false;
                boolean skipCurrentUserLoanDetails = false;

                for (int i = 0; i < lines.size(); i++) {
                    String line = lines.get(i).trim();
                    
                    // Check if this is the current user's section
                    if (line.startsWith("Username:")) {
                        String username = line.substring(9).trim();
                        isCurrentUser = username.equals(Login.Myusername);
                        writer.write(lines.get(i));
                        writer.newLine();
                        continue;
                    }

                    // Always write username and password
                    if (isCurrentUser && (line.startsWith("Password:") || line.startsWith("Date Created:"))) {
                        writer.write(lines.get(i));
                        writer.newLine();
                        continue;
                    }

                    // Skip all loan details and separators for current user
                    if (isCurrentUser && (line.equals("========================================") || 
                        line.startsWith("LOAN DETAILS") || 
                        line.startsWith("Full Name:") || 
                        line.startsWith("Contact #:") || 
                        line.startsWith("Address:") || 
                        line.startsWith("Amount of Loan:") || 
                        line.startsWith("Loan Duration:") || 
                        line.startsWith("Interest Rate:") || 
                        line.startsWith("Monthly Payment:") || 
                        line.startsWith("Total Payment:"))) {
                        continue;
                    }

                    // Write all other lines (other users' data)
                    if (!isCurrentUser) {
                        writer.write(lines.get(i));
                        writer.newLine();
                    }
                }
            }

            // Replace the original file with the temporary file
            if (file.exists()) {
                file.delete();
            }
            tempFile.renameTo(file);

            // Clear the table
            DefaultTableModel model = (DefaultTableModel) TABLE.getModel();
            model.setRowCount(0);

            JOptionPane.showMessageDialog(null, "All loan details have been deleted.", "Deleted", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error updating file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_DELETEActionPerformed

    private void TOTALPAYMENTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TOTALPAYMENTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TOTALPAYMENTActionPerformed

    private void ADDRESSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADDRESSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ADDRESSActionPerformed

    private void AMOUNTOFLOANActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AMOUNTOFLOANActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AMOUNTOFLOANActionPerformed

    private void SHOWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SHOWActionPerformed
        int selectedRow = TABLE.getSelectedRow();

        if (selectedRow != -1) {
            DefaultTableModel model = (DefaultTableModel) TABLE.getModel();

            String fullName = model.getValueAt(selectedRow, 0).toString();
            String contact = model.getValueAt(selectedRow, 1).toString();
            String address = model.getValueAt(selectedRow, 2).toString();
            String amountOfLoan = model.getValueAt(selectedRow, 3).toString();
            String years = model.getValueAt(selectedRow, 4).toString();
            String months = model.getValueAt(selectedRow, 5).toString();
            String interestRate = model.getValueAt(selectedRow, 6).toString();
            String monthlyPayment = model.getValueAt(selectedRow, 7).toString();
            String totalPayment = model.getValueAt(selectedRow, 8).toString();

            String message = "Summary:\n\n"
                    + "Full Name: " + fullName + "\n"
                    + "Contact #: " + contact + "\n"
                    + "Address: " + address + "\n"
                    + "Amount of Loan: ₱" + amountOfLoan + "\n"
                    + "Loan Duration: "
                    + (years.equals("N/A") ? "" : years + " Years ")
                    + (months.equals("N/A") ? "" : months + " Month/s") + "\n"
                    + "Interest Rate: " + interestRate + "%\n"
                    + "Monthly Payment: " + monthlyPayment + "\n"
                    + "Total Payment: " + totalPayment;

            JOptionPane.showMessageDialog(this, message, "Loan Summary", JOptionPane.PLAIN_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Please select a row to show the loan summary.", "No Selection", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_SHOWActionPerformed

    private void CONTACTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CONTACTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CONTACTActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SKIBIDIS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SKIBIDIS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SKIBIDIS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SKIBIDIS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new SKIBIDIS().setVisible(true);
        } // Variables declaration - do not modify
        );
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ADDLOAN;
    private javax.swing.JTextField ADDRESS;
    private javax.swing.JTextField AMOUNTOFLOAN;
    private javax.swing.JButton CALCULATE;
    private javax.swing.JTextField CONTACT;
    private javax.swing.JButton DELETE;
    private javax.swing.JTextField FULLNAME;
    private javax.swing.JTextField INTERESTRATE;
    private javax.swing.JTextField MONTHLYPAYMENT;
    private javax.swing.JTextField MONTHS;
    private javax.swing.JButton SHOW;
    private javax.swing.JTable TABLE;
    private javax.swing.JTextField TOTALPAYMENT;
    private javax.swing.JTextField YEARS;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private void saveTableData() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
