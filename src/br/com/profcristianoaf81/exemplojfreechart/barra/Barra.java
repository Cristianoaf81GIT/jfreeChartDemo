/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.profcristianoaf81.exemplojfreechart.barra;

import java.awt.Color;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Random;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

public class Barra {
    private DefaultCategoryDataset dataset;
    private JFreeChart chart;
   
    
    private DefaultCategoryDataset gerarSetDeDados(){
        dataset = new DefaultCategoryDataset();
        dataset.setValue(new Double(9200.0), "Java", "");
        dataset.setValue(new Double(7300.99), "Python", "");
        dataset.setValue(new Double(5200.0), "C#", "");
        dataset.setValue(new Double(4300.0), "C++", "");
        dataset.setValue(new Double(7200.0), "PHP", "");
        return dataset;
    }

    public JFreeChart criaGraficoBarras(){
        chart = ChartFactory.createBarChart("Programadores por Linguagem"//titulo
                , "Linguagens"//rótulo do eixo categoria
                , "Número de Programadores" //rótulo do eixo de valores
                , gerarSetDeDados() //fonte de dados
                , PlotOrientation.VERTICAL //orientação
                , true //exibição da legenda
                , true //exibição da dica de tela
                , false);//urls
        
        //aplica efeito antialiasing no texto do grafico
        chart.setTextAntiAlias(true);
        
        //prepara para exibir dados no grafico
        CategoryPlot plot = chart.getCategoryPlot();
        
        //muda cor de fundo do grafico para branco
        plot.setBackgroundPaint(Color.WHITE);
        
        //mostra linhas horizontais
        plot.setRangeGridlinesVisible(true);
        //define a cor das linha horizontais
        plot.setRangeGridlinePaint(Color.BLACK);
        
        
        
	BarRenderer renderer = (BarRenderer) plot.getRenderer();
        
        //remove sombreamento das barras
        renderer.setShadowVisible(false);
        
        
        
        
       for(int i = 0;i<5;i++){
            //gera labels para as series exibe valor no topo da pilha
            renderer.setSeriesItemLabelGenerator(i
                , new StandardCategoryItemLabelGenerator("{2}"
                , NumberFormat.getNumberInstance(Locale.getDefault()))
            );
            
            //mostra os labels personalizados no topo das pilhas
            renderer.setSeriesItemLabelsVisible(i, Boolean.TRUE);
            
            //cria cores aleatórias para cada pilha
            Random colors = new Random();
            int r = colors.nextInt(256);
            int g = colors.nextInt(256);
            int b = colors.nextInt(256);
            renderer.setSeriesPaint(i, new Color(r,g,b));
            renderer.setSeriesOutlinePaint(i,new Color(r,g,b));
        } 
        
        
        return chart;
    }
}
