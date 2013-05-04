/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package paineis;

/**
 *
 * @author jeckson
 */


import br.com.modelos.Console;
import exemplo.controller.ConsoleController;
import java.awt.Color;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import tabelas.TabelaPlataforma;

/**
 *
 * @author jeckson
 */
public class delPlataforma extends JFrame{
    JLabel msgErro;
    JTextField tfPlat;
    JPanel painel;
    JTable tabela;
    int nunFlag = 0;
    public delPlataforma (){
        
        painel = new JPanel();
        painel.setLayout(null);
        setSize(600,400);
        painel.setSize(600,400);
        painel.setBackground(new Color(55,96,145));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        JLabel lbPlat = new JLabel();
        lbPlat.setSize(90, 25);
        lbPlat.setText("Plataforma");
        lbPlat.setLocation(20, 20);
        painel.add(lbPlat);
        
        tfPlat = new JTextField();
        tfPlat.setSize(320, 25);
        tfPlat.setLocation(100, 20);
        tfPlat.setEditable(false);
        painel.add(tfPlat);
        
        msgErro = new JLabel("Digite uma plataforma!!!");
        msgErro.setSize(250, 25);
        msgErro.setLocation(180, 200);
        

        List<Console> lista = getListaPla();
        tabelas.TabelaPlataforma modelo = new TabelaPlataforma(lista);
        tabela = new JTable(modelo);
        tabela.setSize(400, 200);
        tabela.setLocation(0, 0);
        tabela.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                tfPlat.setText(tabela.getValueAt(tabela.getSelectedRow(), 1).toString());
                nunFlag = 1;
            }
        });
        ScrollPane scroll = new ScrollPane();
        scroll.setSize(400, 200);
        scroll.setLocation(20, 70);
        scroll.add(tabela);
        add(scroll);
        
        
        JButton botaoAdd = new JButton();
        botaoAdd.setText("Deletar");
        botaoAdd.setSize(110, 25);
        botaoAdd.setLocation(330, 320);
        botaoAdd.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                 if(tfPlat.getText().isEmpty() || nunFlag == 0){
                     JOptionPane.showMessageDialog(null,"Selecione uma plataforma para ser deletada!");
                 }
                 else {
                        ConsoleController control = null;
                        try {
                                control = new ConsoleController();
                        } catch (Exception ex) {
                         Logger.getLogger(AltPlataforma.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        long index = Long.parseLong(tabela.getValueAt(tabela.getSelectedRow(),0).toString());
                        Console con = new Console(index,tfPlat.getText());  
                        control.remove(con);
              
                     dispose();
                     JOptionPane.showMessageDialog(null, "Plataforma deletada com sucesso");
                     
                 }
            }
            
        });
        
        painel.add(botaoAdd);
        
        JButton botaoCan= new JButton();
        botaoCan.setText("Cancelar");
        botaoCan.setSize(110, 25);
        botaoCan.setLocation(450, 320);
        botaoCan.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
              dispose();
                
            }
        });
        painel.add(botaoCan);
        add(painel);
    }
    
    public List<Console> getListaPla(){
        List<Console> lista = null;
        try {
            lista = new ConsoleController().findAll();
        } catch (Exception ex) {
            Logger.getLogger(delPlataforma.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    return lista;
    }
    


    
}
