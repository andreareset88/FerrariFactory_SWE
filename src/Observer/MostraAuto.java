package Observer;

import Observer.Observer;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public final class MostraAuto implements Observer {

    private Rivenditore riv;

    public MostraAuto(Rivenditore riv){
        this.riv = riv;
        this.riv.attach(this);
    }

    @Override
    public void update() throws IOException, InterruptedException {
        System.out.println("L'auto scelta verrà mostrata in una nuova scheda");
        Thread.sleep(3000);
        this.draw(riv.getAutoScelta());
    }

    public void draw(int tipoAuto) throws IOException {
        File laferrari = new File("C:\\Users\\acer\\OneDrive\\Immagini\\la-ferrari.jpg");
        File sf90 = new File("C:\\Users\\acer\\OneDrive\\Immagini\\sf90-stradale.jpg");
        File testarossa = new File("C:\\Users\\acer\\OneDrive\\Immagini\\testarossa.jpg");
        BufferedImage image;
        if(tipoAuto == 0)
            image = ImageIO.read(laferrari);
        else if(tipoAuto == 1)
            image = ImageIO.read(sf90);
        else image = ImageIO.read(testarossa);
        ImageIcon imageIcon = new ImageIcon(image);
        JFrame jFrame = new JFrame();
        jFrame.setLayout(new FlowLayout());
        jFrame.setSize(824, 494);
        JLabel jLabel = new JLabel();
        jLabel.setIcon(imageIcon);
        jFrame.add(jLabel);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
