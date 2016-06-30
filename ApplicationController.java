package application;

import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

/*
 *  This class control the javafx application
 *  
 */

public class ApplicationController extends ChartValues{
	
	@FXML LineChart<String,Number> linechart; // binding the linechart along with javafx
	
	int count = 0;
	
	int i;
	public void nextButton(ActionEvent ae){ // function provide for next button
		
		linechart.getData().clear();
		// creating an object of XY Chart
		XYChart.Series<String, Number> ab = new XYChart.Series<String,Number>();
		XYChart.Series<String, Number> ab1 = new XYChart.Series<String,Number>();

		ArrayList<API1> dtdetails = new ArrayList<>();
		try {
			dtdetails = new ChartValues().sendPost(); // set data into arraylist from postmethod
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(i=count;i<(count+10);i++){// forward loop
	
			double a = Double.parseDouble(dtdetails.get(i).param1);
			int b = (int)a;
		ab.getData().add(new XYChart.Data<String,Number>(dtdetails.get(i).date,b));	
		double c = Double.parseDouble(dtdetails.get(i).param2);
		int d = (int)c;
		
		ab1.getData().add(new XYChart.Data<String,Number>(dtdetails.get(i).date,d));
		
	}
		count = i;
		ab.setName("Param1");
		ab1.setName("Param2");
		linechart.getData().addAll(ab,ab1);
		
	}
	
	public void prevButton(ActionEvent ae){ // Function provide for previous button
		
		linechart.getData().clear();
		// creating an object of XY Chart
		XYChart.Series<String, Number> ab = new XYChart.Series<String,Number>();
		XYChart.Series<String, Number> ab1 = new XYChart.Series<String,Number>();
		ChartValues http = new ChartValues();	
		try {
			http.sendPost();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<API1> dtdetails = new ArrayList<>();
		try {
			dtdetails = new ChartValues().sendPost();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int rev = count-10;
		if(rev==0){ //first time click action
			count = 0;
			return;
		}
		
		
		
		for(i=(rev-10);i<rev;i++){ // rev loop
			
			double a = Double.parseDouble(dtdetails.get(i).param1);
			int b = (int)a;
		ab.getData().add(new XYChart.Data<String,Number>(dtdetails.get(i).date,b));	
		double c = Double.parseDouble(dtdetails.get(i).param2);
		int d = (int)c;
		
		ab1.getData().add(new XYChart.Data<String,Number>(dtdetails.get(i).date,d));
		
		
		}
		count = i;
		
		ab.setName("Param1");
		ab1.setName("Param2");
		linechart.getData().addAll(ab,ab1);
	}

}
