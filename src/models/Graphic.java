package models;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Rafael
 */
public class Graphic {

    public static CategoryDataset createDataset(double vet[]) {

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        dataset.addValue(vet[0], "Read", "L1Data");
        dataset.addValue(vet[2], "Write", "L1Data");
        dataset.addValue(vet[1], "Read", "L1Inst");
        dataset.addValue(0, "Write", "L1Inst");
        dataset.addValue(vet[3], "Read", "LL");
        dataset.addValue( vet[4], "Write", "LL");
        dataset.addValue(vet[0] + vet [1] + vet[3], "Read", "Total");
        dataset.addValue(vet[2] + vet [4], "Write", "Total");

        return dataset;

    }

    public static ChartPanel criaGrafico(CategoryDataset ds) {
      
        JFreeChart graf = ChartFactory.createStackedBarChart3D("Cache Energy Graphic", "Memory Type:" , "Power Consumption", ds, PlotOrientation.VERTICAL, true, true, true);

        ChartPanel myChartPanel = new ChartPanel(graf, true);
        myChartPanel.setVisible(true);
        
        return(myChartPanel);
    }
    
}
