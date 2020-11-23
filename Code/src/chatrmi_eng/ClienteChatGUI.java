/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatrmi_eng;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.io.Serializable;

/**
 *
 * @author Nara
 */
public class ClienteChatGUI extends javax.swing.JFrame {

    /**
     * Creates new form ClienteChatGUI
     */
    //precoProduto = new ArrayList<String>();
    public ClienteChatGUI() throws RemoteException, NotBoundException {
        int i = 0;
        usuariosConectados = new DefaultListModel();
        locVending = new EstoqueImpl();
        //Vamos buscar no servidor de nomes 
        //a referência ao nosso servidor...
        Registry registry = LocateRegistry.getRegistry("localhost");
        chat = (IChat) registry.lookup("nossoChat");
        //ArrayList<String> nomeProduto;
        //ArrayList<String> precoProduto;
        //ArrayList<Integer> quantidadeProduto;
        nomeProduto = new ArrayList<String>();
        precoProduto = new ArrayList<String>();
        quantidadeProduto = new ArrayList<Integer>();

        nomeProduto.add("Vitamina C");
        nomeProduto.add("Colirio");
        nomeProduto.add("Bombinha de Asma");
        nomeProduto.add("Protetor Labial");
        nomeProduto.add("Marcara Higienica");
        nomeProduto.add("Adesivo para Dor");
        nomeProduto.add("Esparadrapo");
        nomeProduto.add("Band-Aid");
        nomeProduto.add("Aspirina");
        nomeProduto.add("Neosaldina");
        nomeProduto.add("Dorflex");
        nomeProduto.add("Buscopan");
        nomeProduto.add("Eno");
        nomeProduto.add("Tums");
        nomeProduto.add("Epocler");
        nomeProduto.add("Drasil");
        nomeProduto.add("Loratadina");
        nomeProduto.add("Vick");
        nomeProduto.add("Xarope da Rochelle");

        precoProduto.add("R$ 6,00");
        precoProduto.add("R$ 8.50");
        precoProduto.add("R$ 12.00");
        precoProduto.add("R$ 5.00");
        precoProduto.add("R$ 2.00");
        precoProduto.add("R$ 2.00");
        precoProduto.add("R$ 2.50");
        precoProduto.add("R$ 1.00");
        precoProduto.add("R$ 2.00");
        precoProduto.add("R$ 2.00");
        precoProduto.add("R$ 3.00");
        precoProduto.add("R$ 2.00");
        precoProduto.add("R$ 3.00");
        precoProduto.add("R$ 3.00");
        precoProduto.add("R$ 2.00");
        precoProduto.add("R$ 3.00");
        precoProduto.add("R$ 2.00");
        precoProduto.add("R$ 3.00");
        precoProduto.add("R$ 2.00");
        System.out.println("chegou aqui");
        for (int n = 0; n < 19; n++) {
            quantidadeProduto.add(50);
        }

        for (int a = 0; a < 19; a++) {
            locVending.cadastrarProduto(nomeProduto.get(a), precoProduto.get(a), quantidadeProduto.get(a));
            chat.addQtdProduto(nomeProduto.get(a), quantidadeProduto.get(a));
        }
        // nome = JOptionPane.showInputDialog(null, "Digite seu nome: ");

        String[] nome = {"Shopping"};

        //Object unidade = JOptionPane.showInputDialog(null, "Unidade:", "Selection", JOptionPane.DEFAULT_OPTION, null, nome, "0");
        ICallback callback = new CallbackImpl(this);
        for (i = 0; i < nome.length; i++) {
            this.setTitle(nome[i]);
            ArrayList<Usuario> usuarios = chat.registrar(nome[i], callback, 50);
            System.out.println("Registrado no Servidor!");

        }

        initComponents();
    }

    public String getNome() {
        return nome;
    }

    public DefaultListModel getUsuariosConectados() {
        return usuariosConectados;
    }

    /*public ArrayList<Integer> getEstoque(){
        return quantidadeProduto;
    }*/
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bntEstoque = new javax.swing.JButton();
        displayValor = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        dig1 = new javax.swing.JButton();
        dig2 = new javax.swing.JButton();
        dig3 = new javax.swing.JButton();
        dig4 = new javax.swing.JButton();
        dig5 = new javax.swing.JButton();
        dig7 = new javax.swing.JButton();
        dig8 = new javax.swing.JButton();
        dig6 = new javax.swing.JButton();
        dig9 = new javax.swing.JButton();
        dig0 = new javax.swing.JButton();
        digc = new javax.swing.JButton();
        digx = new javax.swing.JButton();
        digok = new javax.swing.JButton();
        moeda = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bntEstoque.setText("<html><center> Exibir <br> Estoque </center></html>");
        bntEstoque.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bntEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntEstoqueActionPerformed(evt);
            }
        });
        getContentPane().add(bntEstoque, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 510, 70, 50));

        displayValor.setBackground(new java.awt.Color(0, 102, 102));
        displayValor.setForeground(new java.awt.Color(255, 255, 255));
        displayValor.setBorder(null);
        getContentPane().add(displayValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(691, 72, 60, 20));

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chatrmi_eng/machine1.jpg"))); // NOI18N
        getContentPane().add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        dig1.setText("1");
        dig1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dig1MouseClicked(evt);
            }
        });
        getContentPane().add(dig1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 310, 20, -1));

        dig2.setText("jButton1");
        dig2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dig2MouseClicked(evt);
            }
        });
        getContentPane().add(dig2, new org.netbeans.lib.awtextra.AbsoluteConstraints(714, 310, 20, -1));

        dig3.setText("jButton1");
        dig3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dig3MouseClicked(evt);
            }
        });
        getContentPane().add(dig3, new org.netbeans.lib.awtextra.AbsoluteConstraints(737, 310, 20, -1));

        dig4.setText("jButton1");
        dig4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dig4MouseClicked(evt);
            }
        });
        getContentPane().add(dig4, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 332, 20, -1));

        dig5.setText("jButton1");
        dig5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dig5MouseClicked(evt);
            }
        });
        getContentPane().add(dig5, new org.netbeans.lib.awtextra.AbsoluteConstraints(714, 332, 20, -1));

        dig7.setText("jButton1");
        dig7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dig7MouseClicked(evt);
            }
        });
        getContentPane().add(dig7, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 357, 20, -1));

        dig8.setText("jButton1");
        dig8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dig8MouseClicked(evt);
            }
        });
        getContentPane().add(dig8, new org.netbeans.lib.awtextra.AbsoluteConstraints(714, 357, 20, -1));

        dig6.setText("jButton1");
        dig6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dig6MouseClicked(evt);
            }
        });
        getContentPane().add(dig6, new org.netbeans.lib.awtextra.AbsoluteConstraints(737, 332, 20, -1));

        dig9.setText("jButton1");
        dig9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dig9MouseClicked(evt);
            }
        });
        getContentPane().add(dig9, new org.netbeans.lib.awtextra.AbsoluteConstraints(737, 357, 20, -1));

        dig0.setText("jButton1");
        dig0.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dig0MouseClicked(evt);
            }
        });
        getContentPane().add(dig0, new org.netbeans.lib.awtextra.AbsoluteConstraints(714, 380, 20, -1));

        digc.setText("jButton1");
        digc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                digcMouseClicked(evt);
            }
        });
        getContentPane().add(digc, new org.netbeans.lib.awtextra.AbsoluteConstraints(737, 380, 20, -1));

        digx.setText("jButton1");
        digx.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                digxMouseClicked(evt);
            }
        });
        getContentPane().add(digx, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 380, 20, -1));

        digok.setText("jButton1");
        digok.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                digokMouseClicked(evt);
            }
        });
        getContentPane().add(digok, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 410, 70, -1));

        moeda.setText("jButton1");
        moeda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                moedaMouseClicked(evt);
            }
        });
        moeda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moedaActionPerformed(evt);
            }
        });
        getContentPane().add(moeda, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 110, 60, 60));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dig1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dig1MouseClicked
        //  int intitem = Integer.parseInt(item);
        if (item.equals("") || "1".equals(item) || item.equals(" ")) {
            item = item + "1";
            numeroProduto = Integer.parseInt(item);
            displayValor.setText("" + item);
        } else {
            displayValor.setText("ERROR");
            item = "";
        }
    }//GEN-LAST:event_dig1MouseClicked

    private void dig2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dig2MouseClicked
        if (item == "" || "1".equals(item) || item == " ") {
            item = item + "2";
            numeroProduto = Integer.parseInt(item);
            displayValor.setText("" + item);
        } else {
            displayValor.setText("ERROR");
            item = "";
        }
    }//GEN-LAST:event_dig2MouseClicked

    private void dig3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dig3MouseClicked
        if (item == "" || "1".equals(item) || item == " ") {
            item = item + "3";
            numeroProduto = Integer.parseInt(item);
            displayValor.setText("" + item);
        } else {
            displayValor.setText("ERROR");
            item = "";
        }
    }//GEN-LAST:event_dig3MouseClicked

    private void dig4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dig4MouseClicked
        if (item == "" || "1".equals(item) || item == " ") {
            item = item + "4";
            numeroProduto = Integer.parseInt(item);
            displayValor.setText("" + item);
        } else {
            displayValor.setText("ERROR");
            item = "";
        }
    }//GEN-LAST:event_dig4MouseClicked

    private void dig5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dig5MouseClicked
        if (item == "" || "1".equals(item) || item == " ") {
            item = item + "5";

            numeroProduto = Integer.parseInt(item);
            displayValor.setText("" + item);
        } else {
            displayValor.setText("ERROR");
            item = "";
        }
    }//GEN-LAST:event_dig5MouseClicked

    private void dig6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dig6MouseClicked
        if (item == "" || "1".equals(item) || item == " ") {
            item = item + "6";
            numeroProduto = Integer.parseInt(item);
            displayValor.setText("" + item);
        } else {
            displayValor.setText("ERROR");
            item = "";
        }
    }//GEN-LAST:event_dig6MouseClicked

    private void dig7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dig7MouseClicked
        if (item == "" || "1".equals(item) || item == " ") {
            item = item + "7";
            numeroProduto = Integer.parseInt(item);
            displayValor.setText("" + item);
        } else {
            displayValor.setText("ERROR");
            item = "";
        }
    }//GEN-LAST:event_dig7MouseClicked

    private void dig8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dig8MouseClicked
        if (item == "" || "1".equals(item) || item == " ") {
            item = item + "8";
            numeroProduto = Integer.parseInt(item);
            displayValor.setText("" + item);
        } else {
            displayValor.setText("ERROR");
            item = "";
        }
    }//GEN-LAST:event_dig8MouseClicked

    private void dig9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dig9MouseClicked
        if (item == "" || "1".equals(item) || item == " ") {
            item = item + "9";
            numeroProduto = Integer.parseInt(item);
            displayValor.setText("" + item);
        } else {
            displayValor.setText("ERROR");
            item = "";
        }
    }//GEN-LAST:event_dig9MouseClicked

    private void digxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_digxMouseClicked

        displayValor.setText("");
        item = "";

    }//GEN-LAST:event_digxMouseClicked

    private void dig0MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dig0MouseClicked
        if (item == "" || "1".equals(item) || item == " ") {
            item = item + "0";
            numeroProduto = Integer.parseInt(item);
            displayValor.setText("" + item);
        } else {
            displayValor.setText("ERROR");
            item = "";
        }
    }//GEN-LAST:event_dig0MouseClicked

    private void digcMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_digcMouseClicked
        displayValor.setText("");
        item = "";
    }//GEN-LAST:event_digcMouseClicked

    private void digokMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_digokMouseClicked

        int itemNumero = Integer.parseInt(item);
        itemNumero --;
        try {
            preco = chat.buscaPrecoProduto(nomeProduto.get(itemNumero));
            status = "ok";
            //System.out.print("passou no preço");
        } catch (RemoteException ex) {
            Logger.getLogger(ClienteChatGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        displayValor.setText(preco);
        //displayValor.setText("alo");

        //quantidadeProduto[numeroProduto] = quantidadeProduto[numeroProduto] - 1;
    }//GEN-LAST:event_digokMouseClicked

    private void bntEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntEstoqueActionPerformed

        String msg = "<html><table> <tr><th>Produto</th><th> Qtd</th></tr> <br>";

        for (int i = 0; i < nomeProduto.size(); i++) {
            msg = msg + "<tr><td>" + nomeProduto.get(i) + "</td><td>" + Integer.toString(quantidadeProduto.get(i)) + "</td></tr><br>";
        }
        msg = msg + "</table></center></html>";

        JOptionPane optionPane = new JOptionPane();
        optionPane.setMessage(msg);
        optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
        JDialog dialog = optionPane.createDialog(null, "Estoque");
        dialog.setVisible(true);
    }//GEN-LAST:event_bntEstoqueActionPerformed

    private void moedaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_moedaMouseClicked

        int itemNumero = Integer.parseInt(item);
        itemNumero --;
        if (status.equals("ok")) {

            String nomeProd = nomeProduto.get(itemNumero);
            try {
                chat.realizaVenda(nomeProd); //esse atualiza o valor que ta declarado na classe CHAT IMPL
                realizarVenda(itemNumero); // esse atualiza o valor que ta declarado NESTA classe
                status = "finalizado";
                item = "";
                displayValor.setText("Vendido");
            } catch (RemoteException ex) {
                Logger.getLogger(ClienteChatGUI.class.getName()).log(Level.SEVERE, null, ex);
                //System.out.print("n deu certo amiga");
            }

        }
    }//GEN-LAST:event_moedaMouseClicked

    private void realizarVenda(int indice) {
        quantidadeProduto.set(indice, quantidadeProduto.get(indice) - 1); 
    }
    

    private void moedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moedaActionPerformed
        // TODO add your handling code here:        
    }//GEN-LAST:event_moedaActionPerformed

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
            java.util.logging.Logger.getLogger(ClienteChatGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClienteChatGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClienteChatGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClienteChatGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ClienteChatGUI().setVisible(true);
                } catch (RemoteException ex) {
                    Logger.getLogger(ClienteChatGUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NotBoundException ex) {
                    Logger.getLogger(ClienteChatGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntEstoque;
    private javax.swing.JButton dig0;
    private javax.swing.JButton dig1;
    private javax.swing.JButton dig2;
    private javax.swing.JButton dig3;
    private javax.swing.JButton dig4;
    private javax.swing.JButton dig5;
    private javax.swing.JButton dig6;
    private javax.swing.JButton dig7;
    private javax.swing.JButton dig8;
    private javax.swing.JButton dig9;
    private javax.swing.JButton digc;
    private javax.swing.JButton digok;
    private javax.swing.JButton digx;
    private javax.swing.JTextField displayValor;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JButton moeda;
    // End of variables declaration//GEN-END:variables
    //Declaração das nossas variáveis necessárias:
    private String nome = "";
    private IChat chat;
    DefaultListModel usuariosConectados;
    private String item = "";
    private String status = "";
    private String preco = "";
    private int numeroProduto;
    private EstoqueImpl locVending;
    //Lista Usada no JList
    //ArrayList<Usuario> usuariosConectados;
    ArrayList<String> nomeProduto;
    ArrayList<String> precoProduto;
    ArrayList<Integer> quantidadeProduto;

}
