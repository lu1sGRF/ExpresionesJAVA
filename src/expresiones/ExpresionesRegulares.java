package expresiones;

import expresiones.Token.Tipos;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.UIManager;
import com.jtattoo.plaf.aero.AeroLookAndFeel;
import javax.swing.JOptionPane;

public class ExpresionesRegulares extends javax.swing.JFrame {

    private int numero = 0;
    private int operador = 0;
    private int variable = 0;
    private int constante = 0;
    private int desconocido = 0;

    public ExpresionesRegulares() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtExpresion = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtResultado = new javax.swing.JTextArea();
        btnAnalizar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 435, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Expresión matemática : ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 159, -1, -1));

        txtExpresion.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtExpresion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtExpresionActionPerformed(evt);
            }
        });
        getContentPane().add(txtExpresion, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 197, 205, 46));

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("RESULTADO");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(402, 159, -1, -1));

        txtResultado.setEditable(false);
        txtResultado.setColumns(20);
        txtResultado.setRows(5);
        jScrollPane2.setViewportView(txtResultado);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(298, 197, 336, 217));

        btnAnalizar.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnAnalizar.setForeground(new java.awt.Color(0, 0, 0));
        btnAnalizar.setText("Analizar");
        btnAnalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalizarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAnalizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 261, 156, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/marketing (Logotipo).png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(97, 22, 485, 125));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 440));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAnalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalizarActionPerformed
        String entrada = this.txtExpresion.getText();
        ArrayList<Token> tokens = lex(entrada);
        String result = "";
        for (Token token : tokens) {
            result = result + token.getTipo() + " : " + token.getValor() + "\n";
        }//cierre del for
        this.txtResultado.setText(result);

        String encontrados = ("Numeros encontrados: " + numero
            + "\nOperadores encontrados: " + operador
            + "\nVariables encontradas: " + variable
            + "\nConstantes encontrads: " + constante
            + "\nDesconocidos encontrados: " + desconocido);

        JOptionPane.showMessageDialog(this, encontrados, "RECUENTO de los Resultados Encontrados", JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_btnAnalizarActionPerformed

    private void txtExpresionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtExpresionActionPerformed
        
    }//GEN-LAST:event_txtExpresionActionPerformed

    public static void main(String args[]) {
        try {
            AeroLookAndFeel.setTheme("Green-Giant-Fon");
            UIManager.setLookAndFeel(new AeroLookAndFeel());
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }

        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {

                new ExpresionesRegulares().setVisible(true);
            }
        });
    }

    private ArrayList<Token> lex(String entrada) {
        final ArrayList<Token> tokens = new ArrayList();
        final StringTokenizer st = new StringTokenizer(entrada);

        while (st.hasMoreTokens()) {
            String palabra = st.nextToken();
            boolean bandera = false;

            for (Tipos tokenTipo : Tipos.values()) {
                Pattern patron = Pattern.compile(tokenTipo.patron);
                Matcher busqueda = patron.matcher(palabra);

                if (busqueda.find()) {
                    Token token = new Token();
                    token.setTipo(tokenTipo);
                    token.setValor(palabra);

                    if (String.valueOf(token.getTipo()).equals("NUMERO")) {
                        numero += 1;
                    } else if (String.valueOf(token.getTipo()).equals("OPERADOR")) {
                        operador += 1;
                    } else if (String.valueOf(token.getTipo()).equals("VARIABLE")) {
                        variable += 1;
                    } else if (String.valueOf(token.getTipo()).equals("CONSTANTE")) {
                        constante += 1;
                    } else if (String.valueOf(token.getTipo()).equals("DESCONOCIDO")) 
                        desconocido += 1;
                    

                    tokens.add(token);
                    bandera = true;
                    break;
                }
            }
        }

        return tokens;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnalizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txtExpresion;
    private javax.swing.JTextArea txtResultado;
    // End of variables declaration//GEN-END:variables
}
