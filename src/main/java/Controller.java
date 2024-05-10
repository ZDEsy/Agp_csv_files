import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Path;

public class Controller extends CarsList{
    private final JRadioButton volvo;
    private final JRadioButton bmw;
    private final JRadioButton superb;
    private final JLabel kilometersCountLabel;
    private final JLabel tankingCountLabel;

    /**
     * Controller constructor with all needs
     * @param volvo - JRadioButton with name volvo
     * @param bmw - JRadioButton with name bmw
     * @param superb - JRadioButton with name superb
     * @param kilometersCountLabel - JLabel that shows sumarized kilometers for a car
     * @param tankingCountLabel - JLabel that shows average tanking price for a car
     */
    public Controller(JRadioButton volvo, JRadioButton bmw, JRadioButton superb, JLabel kilometersCountLabel, JLabel tankingCountLabel)
    {
        this.volvo = volvo;
        this.bmw = bmw;
        this.superb = superb;
        this.kilometersCountLabel = kilometersCountLabel;
        this.tankingCountLabel = tankingCountLabel;
    }

    /**
     * ActionListener to choose a csv file
     */
    private final ActionListener chooseFileListener = e -> {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("Soubory CSV","csv"));
        fileChooser.setDialogTitle("Volba souboru");
        fileChooser.showOpenDialog(null);
        try {
            fillLists(Path.of(fileChooser.getSelectedFile().getPath()));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Chyba při výběru souboru");
        }
    };

    /**
     * ActionListener to edit Labels based on volvo RadioButton
     */
    private final ActionListener volvoListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(volvo.isSelected())
            {
                kilometersCountLabel.setText(String.valueOf(kilometerSum(getVolvoList())));
                tankingCountLabel.setText(String.format("%.2f", averageTankPrice(getVolvoList())));
            }
        }
    };

    /**
     * ActionListener to edit Labels based on bmw RadioButton
     */
    private final ActionListener bmwListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(bmw.isSelected())
            {
                kilometersCountLabel.setText(String.valueOf(kilometerSum(getBmwList())));
                tankingCountLabel.setText(String.format("%.2f", averageTankPrice(getBmwList())));
            }
        }
    };

    /**
     * ActionListener to edit Labels based on superb RadioButton
     */
    private final ActionListener superbListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(superb.isSelected())
            {
                kilometersCountLabel.setText(String.valueOf(kilometerSum(getSuperbList())));
                tankingCountLabel.setText(String.format("%.2f", averageTankPrice(getSuperbList())));
            }
        }
    };

    //Getters

    public ActionListener getChooseFileListener() {
        return chooseFileListener;
    }

    public ActionListener getVolvoListener() {
        return volvoListener;
    }

    public ActionListener getBmwListener() {
        return bmwListener;
    }

    public ActionListener getSuperbListener() {
        return superbListener;
    }
}
