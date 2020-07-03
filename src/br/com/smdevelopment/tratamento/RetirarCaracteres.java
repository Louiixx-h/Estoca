
package br.com.smdevelopment.tratamento;

public class RetirarCaracteres {
    
    public static String retirarCaracteresEspesciais(String str){
        
        str = str.replace('(', ' ').replace(')', ' ').replaceAll("[ ./-]", "");
        
        return str;
    }
}
