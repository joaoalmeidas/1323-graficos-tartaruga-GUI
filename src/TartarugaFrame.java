import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TartarugaFrame extends JFrame {
	
	private final JPanel panelListaComandos;
	private final JPanel panelComandos;
	private JPanel panelTartaruga;
	
	private final JButton botaoComandos;
	
	private final JTextField fieldComandos;
	
	private int[] comandos;
	private String[] comandosString;
	
	public TartarugaFrame() {
		
		panelListaComandos = new JPanel(new GridLayout(7, 2));
		panelComandos = new JPanel(new FlowLayout());
		panelTartaruga = new JPanel();
		panelTartaruga.setBackground(Color.WHITE);
		
		botaoComandos = new JButton("Iniciar");
		fieldComandos = new JTextField(50);
		
		panelListaComandos.add(new JLabel("1"));
		panelListaComandos.add(new JLabel("Caneta para cima"));
		panelListaComandos.add(new JLabel("2"));
		panelListaComandos.add(new JLabel("Caneta para baixo"));
		panelListaComandos.add(new JLabel("3"));
		panelListaComandos.add(new JLabel("Vira para a direita"));
		panelListaComandos.add(new JLabel("4"));
		panelListaComandos.add(new JLabel("Vira para a esquerda"));
		panelListaComandos.add(new JLabel("5, n"));
		panelListaComandos.add(new JLabel("Avançar n espaços"));
		
		panelComandos.add(fieldComandos);
		panelComandos.add(botaoComandos);
		
		add(panelComandos, BorderLayout.NORTH);
		add(panelListaComandos, BorderLayout.WEST);
		add(panelTartaruga, BorderLayout.CENTER);
		
		botaoComandos.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				comandosString = fieldComandos.getText().split(", ");
				comandos = new int[comandosString.length];
				
				for(int i = 0; i < comandos.length; i++) {
					
					comandos[i] = Integer.parseInt(comandosString[i]);
					
				}

				panelTartaruga = new EspacoPanel(comandos);
				add(panelTartaruga, BorderLayout.CENTER);
				repaint();
				panelTartaruga.repaint();
			}
			
		});
	}
	
}
