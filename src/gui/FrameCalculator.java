package gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import logica.Adicion;




/**
 *@author William Andres Pinilla - Estudiante Ing. Sistemas - Escuela Colombiana de Ingeniería Julio Garavito - 8 semestre
*/

public class FrameCalculator extends JFrame{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JTextArea elementos;
	public JLabel sugerencias;
	public JLabel resultado;
	public JButton add;
	public JTextField suma;	
	public static Adicion adicion = new Adicion();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new FrameCalculator("String Calculator");
	
	}
    
	/**
	    *constructor del frame principal de String Calculator
	 */
	private FrameCalculator(String message) {
		super(message);
		preparePrincipal();
		this.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE);		
		this.setSize(500,200);
		this.setLayout(new BorderLayout());	
		centrar();
		setVisible(true);	
	}
	
	/**
	    *prepara los elementos de GUI <br>	   
	 */

	private void preparePrincipal() {
		prepareElementos();
		prepareAcciones();		
	}



	private void prepareElementos() {
		JPanel jpaneltemp = new JPanel();
		jpaneltemp.setBorder( BorderFactory.createTitledBorder("Operaciones"));
		jpaneltemp.setLayout( null);
		
		sugerencias = new JLabel("Formato: // [Delimitador]>[números a sumar], Puede tener multiples Delimitador");
		jpaneltemp.add(sugerencias);
		sugerencias.setBounds(10, 20,470, 34);
		
		elementos = new JTextArea();
		jpaneltemp.add(elementos);
		elementos.setBounds(10,60,450,20);
		
		resultado = new JLabel("Resultado:");
		jpaneltemp.add(resultado);
		resultado.setBounds(10,90,150,20);
		
		suma = new JTextField("");
		jpaneltemp.add(suma);
		suma.setBounds(80,90,380, 20);
		suma.setEnabled(false);
		
		add = new JButton("add");
		jpaneltemp.add(add);
		add.setBounds(200,120,80, 20);			
		
		jpaneltemp.setBounds(5, 0,470,200);
		this.getContentPane().add( jpaneltemp,BorderLayout.WEST);
		
	}
	
	/**
	    * Boton de add acciones 
	 */
	
	private void prepareAcciones() {
		ActionListener accion = new ActionListener() {		
			public void actionPerformed(ActionEvent e) {
			
				if(e.getSource().equals(add))
				{				
					suma.setText(String.valueOf(adicion.add(elementos.getText())));	
					suma.setBackground(Color.red);
				}				
			}					
		};	
		add.addActionListener(accion);
		
	}
	
    
	/**
	    *centra frame
	 */
	void centrar() {
		Dimension screen = Toolkit.getDefaultToolkit( ).getScreenSize( );
		int xEsquina = ( screen.width-getWidth())/ 2;
		int yEsquina = ( screen.height-getHeight())/ 2;
		setLocation( xEsquina, yEsquina );	
	}

	

}
