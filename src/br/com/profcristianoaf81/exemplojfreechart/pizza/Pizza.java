/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.profcristianoaf81.exemplojfreechart.pizza;
import java.awt.Color;
import java.text.NumberFormat;
import java.util.Random;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

public class Pizza {
    private JFreeChart chart;
    
    private static PieDataset criarsetDeDados()
    {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("IPhone", new Double(200.0));
        dataset.setValue("Samsung", new Double(207.3));
        dataset.setValue("MotoG", new Double(149.7));
        dataset.setValue("Nokia", new Double(122.7));
        return dataset;
    }
    
    public JFreeChart criaGraficoPizza()
    {
     chart = ChartFactory.createPieChart(
             "Vendas Celulares" //titulo do grafico
             , criarsetDeDados() //dados do grafico
             , true //legenda
             , true //dicas de tela
             , false); //url vinculda (geralmente nao necessária)
     
              
        //prepara área para mostrar dados em percentual
        PiePlot plotagem = (PiePlot) chart.getPlot();
        //define quais labels serao exibidos
        plotagem.setLabelGenerator(new StandardPieSectionLabelGenerator("{0} {1} - {2}"
                ,NumberFormat.getNumberInstance(), NumberFormat.getPercentInstance()));
        
        //cor de fundo da legenda
        plotagem.setLabelBackgroundPaint(Color.WHITE);
        
        //seta cor das linhas de contorno do label
        plotagem.setLabelOutlinePaint(Color.GRAY);
        
        //seta cor do sombreamento do label
        plotagem.setLabelShadowPaint(Color.WHITE);
        
        //seta cor da linha do label
        plotagem.setLabelLinkPaint(new Color(70,75,149));
        
        //muda cor de fundo do grafico de cinza para branco
        plotagem.setBackgroundPaint(Color.white);
        
        //define a cor das bordas das fatias
        plotagem.setBaseSectionOutlinePaint(Color.WHITE);
        
        //seta cor do sombreamento das fatias
        plotagem.setShadowPaint(Color.white);
        
        
        
        
        for(int i=1; i<5;i++){
            Random cores = new Random();
            int r = cores.nextInt(255);
            int g = cores.nextInt(255);
            int b = cores.nextInt(255);
            plotagem.setSectionPaint(i, new Color(r,g,b));
            plotagem.setSectionOutlinePaint(i, new Color(r,g,b));
        } 
        
        //retorna o gráfico pronto
        return chart;
    }
    
}
