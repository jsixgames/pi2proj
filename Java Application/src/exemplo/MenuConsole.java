/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplo;

import paineis.AddPlataforma;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import paineis.AltPlataforma;
import paineis.delPlataforma;

/**
 *
 * @author jeckson
 */
public class MenuConsole extends JFrame{
    
        AddPlataforma plat;
        AltPlataforma alt;
        delPlataforma del;
        JPanel painel;
        
        public MenuConsole (){
            
            
      
            alt = new AltPlataforma();
            plat = new AddPlataforma();
            del = new delPlataforma();
            setResizable(false);
            setTitle("Menu de Plataformas");
            setSize(800,600);
            setBackground(new Color(0,119,238));
             painel = new JPanel();
            painel.setLayout(null);
            painel.setSize(800,600);
            painel.setBackground(new Color(55,96,145));
            setLocation(0, 0);
            add(painel);

            JButton botaoAdd = new JButton();
            botaoAdd.setText("Adicionar");
            botaoAdd.setSize(350, 60);
            botaoAdd.setLocation(220, 200);
            botaoAdd.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    if(plat.isEnabled()){
                         plat = new AddPlataforma();
                        plat.setVisible(true);
                    }
                    
                }
            });
            painel.add(botaoAdd);
            
            JButton botaoAlt = new JButton();
            botaoAlt.setText("Alterar");
            botaoAlt.setSize(350, 60);
            botaoAlt.setLocation(220, 280);
            botaoAlt.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    if(alt.isEnabled()){
                        alt = new AltPlataforma();
                        alt.setVisible(true);
                    }
                    
                
                }
            });
            
            painel.add(botaoAlt);
            
            JButton botaoDel = new JButton();
            botaoDel.setText("Deletar");
            botaoDel.setSize(350, 60);
            botaoDel.setLocation(220, 360);
            botaoDel.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    if(del.isEnabled()){
                        del = new delPlataforma();
                        del.setVisible(true);
                    }
                }
            });
            painel.add(botaoDel);
    }
        
    
    public static void main (String args[]){
    
    MenuConsole p = new MenuConsole();
    p.setVisible(true);
    }

    
}
