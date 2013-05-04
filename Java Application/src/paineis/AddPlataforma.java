/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package paineis;


import br.com.modelos.Console;
import exemplo.controller.ConsoleController;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author jeckson
 */
public class AddPlataforma extends JFrame{
    JLabel msgErro;
    JTextField tfPlat;
    JPanel painel;
    
    
    public AddPlataforma (){
        painel = new JPanel();
        painel.setLayout(null);
        setSize(600,400);
        painel.setSize(600,400);
        painel.setBackground(new Color(55,96,145));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        JLabel lbPlat = new JLabel();
        lbPlat.setSize(90, 25);
        lbPlat.setText("Plataforma");
        lbPlat.setLocation(100, 20);
        painel.add(lbPlat);
        
        tfPlat = new JTextField();
        tfPlat.setSize(240, 25);
        tfPlat.setLocation(180, 20);
        painel.add(tfPlat);
        
        msgErro = new JLabel("Digite uma plataforma!!!");
        msgErro.setSize(250, 25);
        msgErro.setLocation(180, 200);
        
        
        JButton botaoAdd = new JButton();
        botaoAdd.setText("Adicionar");
        botaoAdd.setSize(110, 25);
        botaoAdd.setLocation(180, 60);
        botaoAdd.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                 if(tfPlat.getText().isEmpty()){
                     painel.add(msgErro);
                     repaint();
                 }
                 else {
                     
                     repaint();
                     Console con = new Console(tfPlat.getText());
                     ConsoleController control = null;                     
                     try {
                         control = new ConsoleController();
                     } catch (Exception ex) {
                         Logger.getLogger(AddPlataforma.class.getName()).log(Level.SEVERE, null, ex);
                     }
                     control.create(con);
                     dispose();
                     JOptionPane.showMessageDialog(null, "Plataforma adicionado com sucesso");
                     
                 }
            }
        });
        
        painel.add(botaoAdd);
        
        JButton botaoCan= new JButton();
        botaoCan.setText("Cancelar");
        botaoCan.setSize(110, 25);
        botaoCan.setLocation(310, 60);
        botaoCan.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
              dispose();
            }
        });
        painel.add(botaoCan);
        add(painel);
    }
    
    
}
