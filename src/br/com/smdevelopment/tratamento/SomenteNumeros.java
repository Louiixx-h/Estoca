package br.com.smdevelopment.tratamento;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class SomenteNumeros extends PlainDocument {

    private int maxlength;

    public SomenteNumeros() {
    }

    public SomenteNumeros(int maxlength) {
        super();
        this.maxlength = maxlength;
    }

    @Override
    public void insertString(int offs, String str, AttributeSet a) {
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException ex) {
            str = "";
        }
        try {
            boolean fixedLengh = (!((getLength() + str.length()) > maxlength));
            if (maxlength == 0 || fixedLengh) {
                super.insertString(offs, str, a);
            }
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }

}
