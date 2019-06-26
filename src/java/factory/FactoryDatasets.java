/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import java.util.List;
import java.util.Random;





/**
 *
 * @author fmaia
 */
class FactoryDatasets {
    
    private String color = "";
    private String nameLine;
    private String dados;

    private FactoryDatasets() {
    }

    public static FactoryDatasets newDatasetsDouble (String nameLine, List<Double> listDados) {
        FactoryDatasets Datasets = new FactoryDatasets();
        Datasets.nameLine = nameLine;
        Datasets.dados = Datasets.setData(listDados);
        Datasets.color = redoomColor();
        return Datasets;
    }
    
    public static FactoryDatasets newDatasetsFloat (String nameLine, List<Float> listDados) {
        FactoryDatasets Datasets = new FactoryDatasets();
        Datasets.nameLine = nameLine;
        Datasets.dados = Datasets.setData(listDados);
        Datasets.color = redoomColor();
        return Datasets;
    }
    
    public static FactoryDatasets newDatasetsInteger (String nameLine, List<Integer> listDados) {
        FactoryDatasets Datasets = new FactoryDatasets();
        Datasets.nameLine = nameLine;
        Datasets.dados = Datasets.setData(listDados);
        Datasets.color = redoomColor();
        return Datasets;
    }
        
    private String setData(List listDados){
        String Label = "";
        for(Object d: listDados){
            Label = Label + d.toString()+", ";
        }
        return Label.substring(0, Label.length()-2);
    }
    
    public static String redoomColor(){
        Random ra = new Random();
        int r, g, b;
        r=ra.nextInt(255);
        g=ra.nextInt(255);
        b=ra.nextInt(255);
        return String.format("#%02X%02X%02X", r, g, b);
    }

    public String getDatasets() {
        return 
            "{\n" +
"                        label: '"+nameLine+"',\n" +
"                        fill: false,\n" +
"                        data: ["+dados+"],\n" +
"                        lineTension: 0,\n" +
"                        backgroundColor: '"+color+"',\n" +
"                        borderColor: '"+color+"',\n" +
"                        borderWidth: 4,\n" +
"                        pointBackgroundColor: '"+color+"'\n" +
"                      }";
    }
    
}
