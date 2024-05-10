import javax.swing.*;
import java.awt.*;

public class Main extends CarsList {
    private final JPanel mainPane = new JPanel(new GridBagLayout());
    private final GridBagConstraints c = new GridBagConstraints();
    private final JButton chooseFile = new JButton("Zvolit soubor");
    private final JLabel name = new JLabel("Zdeněk Uttendorfský");
    private final JRadioButton volvo = new JRadioButton("Volvo",true);
    private final JRadioButton bmw = new JRadioButton("BMW");
    private final JRadioButton superb = new JRadioButton("Superb");
    private final ButtonGroup buttonGroup = new ButtonGroup();
    private final JLabel kilometers = new JLabel("Ujeté KM");
    private final JLabel kilometersCountLabel = new JLabel("0");
    private final JLabel tanking = new JLabel("Průměrná cena tankování");
    private final JLabel tankingCountLabel = new JLabel("0");


    /**
     * Main constructor to handle all methods and actions
     */
    public Main()
    {
        initComponents();
        addComponents();
        adjustComponents();

        //chooseFile button, when pressed you can choose csv file to get data from
        Controller controller = new Controller(volvo, bmw, superb, kilometersCountLabel, tankingCountLabel);
        chooseFile.addActionListener(controller.getChooseFileListener());

        volvo.addActionListener(controller.getVolvoListener());
        bmw.addActionListener(controller.getBmwListener());
        superb.addActionListener(controller.getSuperbListener());
    }


    /**
     * Method to add components to the scene
     */
    public void addComponents()
    {
        c.insets = new Insets(10,10,10,10);
        //adds buttons to button group
        buttonGroup.add(volvo);
        buttonGroup.add(bmw);
        buttonGroup.add(superb);

        //adds components to JPanel
        add(chooseFile, c);

        c.gridy = 1;
        add(volvo, c);
        add(bmw, c);
        add(superb, c);

        c.gridy = 2;
        add(kilometers, c);

        c.gridy = 3;
        add(tanking, c);

        c.gridwidth = 2;
        c.gridy = 2;
        add(kilometersCountLabel, c);

        c.gridy = 3;
        add(tankingCountLabel, c);

        c.gridx = 2;
        c.gridy = 0;
        add(name, c);

    }

    /**
     * JFrame components to set window and panel attributes
     */
    public void initComponents()
    {
        setContentPane(mainPane);
        setTitle("Kniha jízd");
        setSize(400,200);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    /**
     * Adjusts components to preferred size, spot etc.
     */
    public void adjustComponents()
    {
        chooseFile.setSize(50,50);
    }

    //Starts the program
    public static void main(String[] args) {
        new Main();
    }
}