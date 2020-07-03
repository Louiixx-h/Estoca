
package br.com.smdevelopment.tratamento;

import br.com.smdevelopment.entidades.UsuarioAtual;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class TratamentoImagem {
    
    private static BufferedImage buffImg;
    
    public BufferedImage getBuffImg() {
        return buffImg;
    }

    public void setBuffImg(BufferedImage buffImage) {
        TratamentoImagem.buffImg = buffImage;
    }
    
    public void abrirImagem(Object tela, JLabel lbImagem) throws IOException{
        
        JFileChooser buscarImg = new JFileChooser();
        buscarImg.setFileFilter(new FileNameExtensionFilter("Imagem", "JPG"));
        buscarImg.setAcceptAllFileFilterUsed(false);
        int retorno;
        System.out.println(retorno = buscarImg.showOpenDialog((Component) tela));
        File file = buscarImg.getSelectedFile();
          
        if(retorno == JFileChooser.APPROVE_OPTION && file != null){

        setBuffImg(ImageIO.read(new File(file.getAbsolutePath())));
        Image diminuirImg = getBuffImg().getScaledInstance(141, 149, 0);
        lbImagem.setIcon(new ImageIcon(diminuirImg));

        }
    }
    
    public byte[] converterParaArrayByte(BufferedImage buffImage){
        
        ByteArrayOutputStream outputS = new ByteArrayOutputStream();
        
        try {
            ImageIO.write(buffImage, "JPG", outputS);
        } catch (IOException ex) {
            Logger.getLogger(UsuarioAtual.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        InputStream inputS = new ByteArrayInputStream(outputS.toByteArray());
        
        return outputS.toByteArray();
    }
    
    public void setarImagem(JLabel lbImagem){
            
        ImageIcon imagemIcon = new ImageIcon(getClass().getResource("/br/com/smdevelopment/icon/foto_usuario.jpg"));    
        
        lbImagem.setIcon(imagemIcon);
        
        Image im = imagemIcon.getImage();
        BufferedImage bi = new BufferedImage(im.getWidth(null),im.getHeight(null),BufferedImage.TYPE_INT_RGB);
        
        Graphics bg = bi.getGraphics();
        bg.drawImage(im, 0, 0, null);
        bg.dispose();
        
        setBuffImg(bi);
        
    }
    
    public void converterParaBufferedImage(byte[] imagem, JLabel lbImagem){
        
        ByteArrayInputStream bais = new ByteArrayInputStream(imagem);
        
        try {
            setBuffImg(ImageIO.read(bais));
            Image diminuirImagem = getBuffImg().getScaledInstance(140, 140, 0);
            lbImagem.setIcon(new ImageIcon(diminuirImagem));
        } catch (IOException ex) {
            Logger.getLogger(TratamentoImagem.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
}
