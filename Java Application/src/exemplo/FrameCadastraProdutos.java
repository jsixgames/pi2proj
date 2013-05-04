/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplo;


import br.com.modelos.Produto;
import exemplo.controller.ProdutoController;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

/**
 *
 * @author 41010027
 */
public class FrameCadastraProdutos extends JFrame{

        private static Image img;   
        private JDesktopPane dp1; 
        private JTextField tfCodigo;
        private JButton btConsultar;
        private JTextField tfNome;
        private JComboBox jcPlat;
        private JTextField tfPreco;
        private JTextField tfQtd;
        private JTextArea taDesc;
        private JButton btBuscaAvancada;
        private JButton btAdicionar;
        private JButton btCancelar;
        private Color corCompBloqueado = new Color(249, 251, 253);
        private Color corCompPreencher = new Color(255, 255, 183);
    
    
    public FrameCadastraProdutos(){
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        UIManager.put("TextField.inactiveBackground",corCompBloqueado); 
        UIManager.put("TextField.inactiveForegroung", Color.BLACK); 
        UIManager.put("ComboBox.disabledBackground", corCompBloqueado);
        UIManager.put("ComboBox.disabledForeground", Color.BLACK);
        UIManager.put("TextArea.Foreground", Color.BLACK);
        UIManager.put("TextArea.background", corCompBloqueado);
        setResizable(false);
        setSize(800, 600);
       
        try   
        {   
            img = javax.imageio.ImageIO.read(new java.net.URL(getClass().getResource("fundo.jpg"), "fundo.jpg"));   
  
        }   
        catch(Exception e){} 
  
     dp1 = new JDesktopPane()   
     {   
         @Override
         public void paintComponent(Graphics g)   
         {   
           super.paintComponent(g);   
           if(img != null)   
           {   
               g.drawImage(img, 0,0,1000,800,this);         
           }   
          else   
               g.drawString("Image not found", 50,50);   
           /* O repaint e o VAlidade aparentimente n fazem diferença. Caso  
              encontrem algum bom motivo para usa-los, postem, please! xD  
           */   
           //super.repaint();   
           //super.validate();   
         }   
  
     };
     
     getContentPane().add(dp1);
     dp1.setLayout(null);
     

     JLabel lbNome = new JLabel();
     lbNome.setSize(90, 25);
     lbNome.setText("Nome:");
    
     lbNome.setForeground(Color.WHITE);
     lbNome.setLocation(20, 50);
     dp1.add(lbNome);
     
     tfNome = new JTextField();
     tfNome.setSize(690, 25);
     tfNome.setLocation(80, 50);
     dp1.add(tfNome);
     
     JLabel lbPlataforma = new JLabel();
     lbPlataforma.setSize(90, 25);
     lbPlataforma.setText("Console:");
     lbPlataforma.setForeground(Color.WHITE);
     lbPlataforma.setLocation(20, 95);
     dp1.add(lbPlataforma);
         
     jcPlat = new JComboBox();
     jcPlat.setSize(200, 25);
     jcPlat.setLocation(80, 95);
     dp1.add(jcPlat);
     
     // BLOCO DE INSTRUÇÃO APENAS PARA TESTE ----- 


     // BLOCO DE INSTRUÇÃO APENAS PARA TESTE -----
     
     JLabel lbPreco = new JLabel();
     lbPreco.setSize(90, 25);
     lbPreco.setText("Preço:");
     lbPreco.setForeground(Color.WHITE);
     lbPreco.setLocation(290, 95);
     dp1.add(lbPreco);
     
     tfPreco = new JTextField();
     tfPreco.setSize(200, 25);
     tfPreco.setLocation(340, 95);
     dp1.add(tfPreco);
     
     
     JLabel lbDesc = new JLabel();
     lbDesc.setSize(90, 25);
     lbDesc.setText("Descrição:");
     lbDesc.setForeground(Color.WHITE);
     lbDesc.setLocation(20, 155);
     dp1.add(lbDesc);
     
     taDesc = new JTextArea();
     taDesc.setSize(750, 300);
     taDesc.setLocation(20, 180);
     taDesc.setLineWrap(true);
     dp1.add(taDesc);
     
     
     btAdicionar = new JButton();
     btAdicionar.setSize(120, 40);
     btAdicionar.setText("Cadastrar");
     btAdicionar.setLocation(510, 500);
     btAdicionar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                Produto prod = new Produto();
                prod.setNomeProd(tfNome.getText());
                prod.setCategProd("PS3");
                prod.setDescProd(taDesc.getText());
                prod.setPrecoProd(Double.parseDouble(tfPreco.getText()));
                ProdutoController jpaProd = null;
             try {
                 jpaProd = new ProdutoController();
                 JOptionPane.showMessageDialog(null,"Cadastrado com sucesso");
             } catch (Exception ex) {
                 Logger.getLogger(FrameCadastraProdutos.class.getName()).log(Level.SEVERE, null, ex);
             }
        try {
            jpaProd.create(prod);
        } catch (Exception e) {

    }             
            }
        });
     dp1.add(btAdicionar);
     
     btCancelar = new JButton();
     btCancelar.setSize(120, 40);
     btCancelar.setText("Cancelar");
     btCancelar.setLocation(650, 500);
     btCancelar.addActionListener(new ActionListener() {
         
            @Override
            public void actionPerformed(ActionEvent ae) {
                dispose();
            }
        });
     dp1.add(btCancelar);
     
    }
    
    
    public static void main (String args []){
    
        FrameCadastraProdutos p = new FrameCadastraProdutos();
        p.setVisible(true);
    
    }
    

    

}