package br.com.modelos;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class MetodosGerais {

    public long converterLong(String string) {
        String auxiliar = string;
        long objConvertido = 0;
        for (int i = 0; i < auxiliar.length(); i++) {
            char a;
            int b;
            a = auxiliar.charAt(i);
            if (a == '1' || a == '2' || a == '3' || a == '4' || a == '5' || a == '6' || a == '7' || a == '8' || a == '9' || a == '0') {
                b = ((int) a - 48);
                objConvertido = ((objConvertido * 10) + b);
            }
                }
        return objConvertido;
    }
    
    public String tirardotecoma(String value){
               String cpf = value;
          if (value!= null && !value.equals(""))
               cpf = value.replaceAll("\\.", "")
              .replaceAll("\\-", "").replaceAll("\\(", "").replaceAll("\\)", "")
                       .replaceAll("\\/", "");
          return cpf;    
    }
    
    public java.sql.Date formataData(String data) throws Exception {   
        if (data == null || data.equals(""))  
            return null;  
          
        java.sql.Date date = null;  
        try {  
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
            date = new java.sql.Date( ((java.util.Date)formatter.parse(data)).getTime() );  
        } catch (ParseException e) {              
            throw e;  
        }  
        return date;  
    }  
}

