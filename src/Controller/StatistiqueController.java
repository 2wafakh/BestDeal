/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import edu.esprit.dao.StatDAO;
import edu.esprit.entities.Categories;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.demo.BarChartDemo1;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.category.SlidingCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.statistics.DefaultStatisticalCategoryDataset;

/**
 *
 * @author Amouna
 */
public class StatistiqueController {

    public StatistiqueController() {
    }

    public ChartPanel Statistique() {

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        StatDAO b = new StatDAO();

        DefaultPieDataset pieDataset = new DefaultPieDataset();
        for (int i = 0; i < b.DisplayAll().size(); i++) {


            String type = (String) b.DisplayAll().get(i).getNom();
            System.out.print(type);
            int nombre = (Integer) b.DisplayAll().get(i).getId();

            pieDataset.setValue(type, nombre);
        }


        JFreeChart chart = ChartFactory.createPieChart3D("Catégorie la plus vendu", // Title
                pieDataset, // Dataset
                true, // Show legend
                true, // Use tooltips
                false // Configure chart to generate URLs?
                );

        ChartPanel pane = new ChartPanel(chart);


        return pane;
    }

    public ChartPanel Statistiqueavis() {

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        StatDAO b = new StatDAO();
        for (int i = 0; i < b.DisplayAllnote().size(); i++) {


            String type = (String) b.DisplayAllnote().get(i).getNom();
            System.out.print(type);
            int nombre = (Integer) b.DisplayAllnote().get(i).getId();

            dataset.setValue(nombre, "Catégorie", type);
        }


        JFreeChart chart = ChartFactory.createBarChart3D("Avis", "", "Echelle", dataset, PlotOrientation.VERTICAL, true, true, true);
        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.black);

        ChartPanel pane = new ChartPanel(chart);


        return pane;
    }
}
