/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.profcristianoaf81.exemplojfreechart;
import java.awt.FlowLayout;
import javax.swing.*;
import javax.swing.UnsupportedLookAndFeelException;
import org.jfree.chart.*;
import br.com.profcristianoaf81.exemplojfreechart.pizza.Pizza;
import br.com.profcristianoaf81.exemplojfreechart.barra.Barra;
import br.com.profcristianoaf81.exemplojfreechart.linha.Linha;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@SuppressWarnings("serial")
public class JanelaGrafico_jfreeChart extends JFrame{
    private JButton btGPizza,btGBar,btGLinhasImagem;
    private ChartPanel painelGrafico;
    private JLabel lbPainelGraficoImagem;
    private InputStream arquivo;//usado para receber leitura de buffer 
    private Image imagemGrafico;//usado para armz arquivo de imagem
            
    
    public JanelaGrafico_jfreeChart()
    {
      
      initComp();
      setEvt();
    }
    
       
    public void initComp()
    {
        setLAF();
        setTitle("Exemplos de Gráficos JfreeChart");
        setLayout(new FlowLayout(1, 30, 30));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 500, 620);
        setLocationRelativeTo(null);
        btGPizza = new JButton("Gráfico tipo Pizza");
        btGBar = new JButton("Gráfico tipo Barras");
        btGLinhasImagem = new JButton("Gráfico Tipo Linhas com Imagem");
        setResizable(false);
        add(btGPizza);
        add(btGBar);
        add(btGLinhasImagem);
        
        
    }
    
    public void setEvt()
    {
        btGPizza.addActionListener(
           (evt)->{
             
             if(painelGrafico!=null)
             {
               remove(painelGrafico);
               repaint();  
             }    
             
             if(lbPainelGraficoImagem!=null)
             {
               remove(lbPainelGraficoImagem);
               repaint();
             }
             
             Pizza p = new Pizza();
             painelGrafico = new ChartPanel(p.criaGraficoPizza());
             painelGrafico.setBounds((500-500)/2, 135, 500, 440);
             add(painelGrafico);
             repaint();
             
           }     
        );
        
        btGBar.addActionListener(
           new ActionListener(){
               @Override
               public void actionPerformed(ActionEvent evento)
               {
                   if(painelGrafico!=null)
                   {
                    remove(painelGrafico);
                    repaint();
                   } 
                   
                   if(lbPainelGraficoImagem!=null)
                   {
                    remove(lbPainelGraficoImagem);
                    repaint();
                   }
                   
                   Barra b = new Barra();
                   painelGrafico = new ChartPanel(b.criaGraficoBarras());
                   painelGrafico.setBounds((500-500)/2, 135, 500, 440);
                   add(painelGrafico);
                   repaint();                              
               }
           }     
        );
        
        btGLinhasImagem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Linha l = new Linha();
                if(painelGrafico!=null)
                {
                    remove(painelGrafico);
                    repaint();
                }
                
                if(lbPainelGraficoImagem!=null)
                {
                    remove(lbPainelGraficoImagem);
                    repaint();
                }
                
                l.gerarGraficoLinhasPNG();
                try{
                    //recebe o arquivo
                    arquivo = new BufferedInputStream(
                            new FileInputStream(System.getProperty("user.home")+"/Desktop/linhas.png")
                    );
                    //armazena imagem em uma var tipo image (pct java.awt.image)
                    imagemGrafico = ImageIO.read(arquivo);
                }catch(IOException fnf){
                    JOptionPane.showMessageDialog(null, "Erro Arquivo não Encontrado!"
                            +"\n"+fnf.getMessage());
                }
                
                if(arquivo!=null&&imagemGrafico!=null)
                {
                    lbPainelGraficoImagem = new JLabel(new ImageIcon(imagemGrafico));
                    lbPainelGraficoImagem.setBounds((500-500)/2, 135, 500, 455);
                    add(lbPainelGraficoImagem);
                    repaint();
                }
            }
        });
    
    }
    
    public void setLAF()
    {
      try{
          //com.sun.java.swing.plaf.windows.WindowsLookAndFeel (windows)
          //com.sun.java.swing.plaf.gtk.GTKLookAndFeel (linux)
       UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
      }catch(ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException t){
        try{
        UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        }catch(ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException lafe){
        
        }
      }
    }
}
