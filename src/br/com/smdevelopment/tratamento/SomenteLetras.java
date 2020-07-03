
package br.com.smdevelopment.tratamento;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class SomenteLetras extends PlainDocument{

    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
        super.insertString(offs, str.toUpperCase()/*replaceAll("[^a-z^A-Z|^ ]", "")*/, a);
    } 
//    public void replace(int offs, String str, AttributeSet a) throws BadLocationException {
//        super.insertString(offs, str.replaceAll("[^a-z|^A-Z|^ ]", ""), a); //To change body of generated methods, choose Tools | Templates.
//    }
}
