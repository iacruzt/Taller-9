import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.BoxLayout;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

public class UserInterface implements Runnable
{

    // ------------------------------------------------------------------------- ATTRIBUTES

    private JFrame frame;

    // ------------------------------------------------------------------------- CONSTRUCTOR

    public UserInterface ()
    {
        frame = new JFrame ( "Title" );
        // Default constructor!
    }

    public UserInterface (String frameTitle)
    {
        frame = new JFrame ( frameTitle );
    }

    // ------------------------------------------------------------------------- METHODS

    @Override
    public void run ()
    {
        this.frame.setPreferredSize ( new Dimension ( 200 , 250 ) );
        this.frame.setDefaultCloseOperation ( WindowConstants.EXIT_ON_CLOSE );
        this.createComponents ( this.frame.getContentPane() );
        this.frame.pack ();
        this.frame.setVisible ( true );
    }

    private void createComponents ( Container container )
    {
        BoxLayout layout = new BoxLayout ( container , BoxLayout.Y_AXIS );
        container.setLayout ( layout );

        container.add ( new JLabel ("Are you?") );
        container.add ( new JCheckBox ("Yes!") );
        container.add ( new JCheckBox ("No!") );
        container.add ( new JLabel ( "Why?" ) );

        JRadioButton firstOption = new JRadioButton( "No reason" );
        JRadioButton secondOption = new JRadioButton( "Because it is fun!" );

        ButtonGroup options = new ButtonGroup ();
        options.add ( firstOption );
        options.add ( secondOption );

        container.add ( firstOption );
        container.add ( secondOption );

        container . add ( new JButton ( "Done!" ) );

    }

    public JFrame getFrame ()
    {
        return this.frame;
    }

    // --------------------------------------------------------------------- TEST

    public static void main ( String [] args )
    {
        UserInterface ui = new UserInterface ( "Survey" );
        SwingUtilities.invokeLater ( ui );
    }

}
