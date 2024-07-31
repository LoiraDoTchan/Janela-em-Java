
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/***
 * Classe com escutador externo
 */
public class MinhaJanela extends JFrame {

	private static final long serialVersionUID = 8899038834135112346L;

	private JLabel jlabel;
	private JLabel jlabel2;
	protected JTextField jtext;
	private JButton jbutton;

	// float resultado;
	float valor;

	public MinhaJanela(String titulo) {
		super(titulo);
		setLayout(new FlowLayout());

		jlabel = new JLabel("Celsius");
		jtext = new JTextField("0");
		jtext.setColumns(10);
		jbutton = new JButton("Convert");
		jlabel2 = new JLabel("32 Fahrenheit");

		// valor = converter();
		// resultado = calcula(valor);

		add(jtext);
		add(jlabel);		
		add(jbutton);
		add(jlabel2);
		
		TextFieldHandler handler = new TextFieldHandler(this);

		jtext.addActionListener(handler);
		jbutton.addActionListener(handler);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public float calcula() {
		float valor = Float.parseFloat(jtext.getText());
		return (valor * (9 / 5)) + 32;
	}

	public static void main(String[] args) {
		MinhaJanela my = new MinhaJanela("Converte Celsius");
		// MyJFrame my = new MyJFrame();
		my.setSize(250, 130);
		my.setVisible(true);
	}
	
	public void setResultado(float valor) {
		jlabel2.setText(Float.toString(valor) +" Fahrenheit");
	}

}

class TextFieldHandler implements ActionListener {
	MinhaJanela janela;

	public TextFieldHandler(MinhaJanela janela) {
		this.janela = janela;
	}

	@Override
	public void actionPerformed(ActionEvent event) {

		//JOptionPane.showMessageDialog(janela, "Em Fahrenheit: " + janela.calcula() );

		janela.setResultado(janela.calcula() );
		
	}

}
