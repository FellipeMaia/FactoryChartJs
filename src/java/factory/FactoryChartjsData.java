/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author fmaia
 */
public class FactoryChartjsData {
    
    
    private List<FactoryDatasets> datasets = new ArrayList<>();
    private String label;

    public static FactoryChartjsData setLabelCalendar(List<Calendar> label){
        FactoryChartjsData chartjs = new FactoryChartjsData();
        String Label = "";
        for(Calendar c: label){
            Label = Label +"\""+ 
                    FactoryChartjsData.toFormatString(c, "dd-MM-yyyy hh:mm")+
                    "\", ";
        }
        chartjs.label = Label.substring(0, Label.length()-2);
        return chartjs;
    }
    
    public static FactoryChartjsData setLabelDouble(List<Double> label){
        FactoryChartjsData chartjs = new FactoryChartjsData();
        String Label = "";
        for(Double d: label){
            Label = Label +"\""+ 
                    d.toString()+
                    "\", ";
        }
        chartjs.label = Label.substring(0, Label.length()-2);
        return chartjs;
    }
    
    public static FactoryChartjsData setLabelInteger(List<Integer> label){
        FactoryChartjsData chartjs = new FactoryChartjsData();
        String Label = "";
        for(Integer I: label){
            Label = Label +"\""+ 
                    I.toString()+
                    "\", ";
        }
        chartjs.label = Label.substring(0, Label.length()-2);
        return chartjs;
    }
    
        public static FactoryChartjsData setLabelString(List<String> label){
        FactoryChartjsData chartjs = new FactoryChartjsData();
        String Label = "";
        for(String s: label){
            Label = Label +"\"" +s+ "\", ";
        }
        chartjs.label = Label.substring(0, Label.length()-2);
        return chartjs;
    }


    public void addFactoryDatasetsDouble(String nameLine,List<Double> listDados){
        this.datasets.add(FactoryDatasets.newDatasetsDouble(nameLine, listDados));
    }
    
    public void addFactoryDatasetsFloat(String nameLine,List<Float> listDados){
        this.datasets.add(FactoryDatasets.newDatasetsFloat(nameLine, listDados));
    }
    
    public void addFactoryDatasetsInteger(String nameLine,List<Integer> listDados){
        this.datasets.add(FactoryDatasets.newDatasetsInteger(nameLine, listDados));
    }
    
    public String getCharjsData(){
        String data = 
                "{\n" +
"                    labels: ["+this.label+"],\n" +
"                    datasets: [";
        for(FactoryDatasets d: this.datasets){
            data += d.getDatasets();
            data += ",";
        } 
        data = data.substring(0, data.length()-1);
        data += "]\n}";
        return data;
    }
    
    private static String toFormatString(Calendar dataCalendar, String formato){
        if(dataCalendar == null)
           return "";
        SimpleDateFormat dataFormat = new SimpleDateFormat(formato);
        return dataFormat.format(dataCalendar.getTime());
    }
    
}
