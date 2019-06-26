/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import factory.FactoryChartjsData;
import java.io.Serializable;
import java.text.DecimalFormat;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

/**
 *
 * @author fmaia
 */

@ManagedBean
public class ChartBean implements Serializable{
    
    Random gerador = new Random();
    List<String> list = new ArrayList<>();
    String nome1 = "Primeiro Dataset";
    String nome2 = "Segundo Dataset";
    
    public String getChartjsFloat(){
        FactoryChartjsData charjsData;
        charjsData = FactoryChartjsData.setLabelString(this.mes());
        charjsData.addFactoryDatasetsFloat(nome1, this.redonFloat(5, 200, 4));
        charjsData.addFactoryDatasetsFloat(nome2, this.redonFloat(5, 200, 4));
        return charjsData.getCharjsData();
    }
    
    public String getChartjsInt(){
        FactoryChartjsData charjsData;
        charjsData = FactoryChartjsData.setLabelString(this.mes());
        charjsData.addFactoryDatasetsInteger(nome1, this.redonInt(5, 200));
        charjsData.addFactoryDatasetsInteger(nome2, this.redonInt(5, 200));
        return charjsData.getCharjsData();
    }

    private List<Integer> redonInt(int quant, int valorMax){
        gerador.setSeed(Calendar.getInstance().getTimeInMillis());
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<quant;i++){
            list.add(gerador.nextInt(valorMax-1));
        }
        return list;
    }

    private List<Float> redonFloat(int quant, int valorMax){
        gerador.setSeed(Calendar.getInstance().getTimeInMillis());
        List<Float> list = new ArrayList<>();
        for(int i=0;i<quant;i++){
            list.add(gerador.nextInt(valorMax) + gerador.nextFloat());
        }
        return list;
    }
    
    private List<Float> redonFloat(int quant, int valorMax, int significativos){
        gerador.setSeed(Calendar.getInstance().getTimeInMillis());
        String zeros = "#";
        if(significativos >0)
           zeros = zeros + ","; 
        for(int i=1;i<=significativos;i++){
            zeros = zeros + "#";
        }
        DecimalFormat df = new DecimalFormat(zeros);
        List<Float> list = new ArrayList<>();
        for(int i=0;i<quant;i++){
            list.add(gerador.nextInt(valorMax) + Float.parseFloat(df.format(gerador.nextFloat())));
        }
        return list;
    }
    
     private List mes(){
        List<String> list = new ArrayList<>();
        list.add("Janeiro");
        list.add("Fevereiro");
        list.add("Março");
        list.add("Abril");
        list.add("Maio");
        list.add("Junho");
        return list;
    }
}




