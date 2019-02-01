import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TartarugaFrame extends JFrame {
	
	private final JPanel panelListaComandos;
	private final JPanel panelComandos;
	private EspacoPanel espacoTartaruga;
	
	private final JButton botaoComandos;
	
	private final JTextField fieldComandos;
	
	private int[] comandos;
	private String[] comandosString;
	
	private JLabel labelOrientacaoTartaruga;
	private JLabel labelCanetaTartaruga;
	private JLabel labelPosicaoTartaruga;
	
	public TartarugaFrame() {
		
		panelListaComandos = new JPanel(new GridLayout(7, 2));
		panelComandos = new JPanel(new FlowLayout());
		espacoTartaruga = new EspacoPanel(new int[2]);
		espacoTartaruga.setBackground(Color.WHITE);

		botaoComandos = new JButton("Iniciar");
		fieldComandos = new JTextField(50);
		fieldComandos.setText("1, 5, 500, 1, 3, 5, 100, 2, 5, 300, 4, 5, 300, 4, 5, 300, 4, 5, 300");
		
		labelOrientacaoTartaruga = new JLabel(String.format("Direção Tartaruga: %s", espacoTartaruga.getTartaruga().getOrientacao()));
		labelCanetaTartaruga = new JLabel(String.format("Posicão Caneta: %s", espacoTartaruga.getTartaruga().getCaneta()));
		labelPosicaoTartaruga = new JLabel(String.format("Posição Tartaruga: (%d, %d)", espacoTartaruga.getTartaruga().getPosicao()[0],
				espacoTartaruga.getTartaruga().getPosicao()[1]));
		
		panelListaComandos.add(new JLabel("  1"));
		panelListaComandos.add(new JLabel("Caneta para cima "));
		panelListaComandos.add(new JLabel("  2"));
		panelListaComandos.add(new JLabel("Caneta para baixo "));
		panelListaComandos.add(new JLabel("  3"));
		panelListaComandos.add(new JLabel("Vira para a direita "));
		panelListaComandos.add(new JLabel("  4"));
		panelListaComandos.add(new JLabel("Vira para a esquerda "));
		panelListaComandos.add(new JLabel("  5, n"));
		panelListaComandos.add(new JLabel("Avançar n pixels "));
		
		panelComandos.add(fieldComandos);
		panelComandos.add(botaoComandos);
		panelComandos.add(labelOrientacaoTartaruga);
		panelComandos.add(labelCanetaTartaruga);
		panelComandos.add(labelPosicaoTartaruga);
		
		add(panelComandos, BorderLayout.NORTH);
		add(panelListaComandos, BorderLayout.WEST);
		add(espacoTartaruga, BorderLayout.CENTER);
		
		botaoComandos.addMouseListener(new MouseAdapter() {

			
			@Override
			public void mousePressed(MouseEvent arg0) {
				
				comandosString = fieldComandos.getText().split(", ");
				comandos = new int[comandosString.length];
				
				for(int i = 0; i < comandos.length; i++) {
					
					comandos[i] = Integer.parseInt(comandosString[i]);
					
				}

				espacoTartaruga.setComandos(comandos);
				espacoTartaruga.validate();
				espacoTartaruga.repaint();
				espacoTartaruga.updateUI();
				
				labelOrientacaoTartaruga.setText(String.format("Direção Tartaruga: %s", espacoTartaruga.retornaStringOrientaacao()));
				labelCanetaTartaruga.setText(String.format("Posicão Caneta: %s", espacoTartaruga.retornaStringCaneta()));
				labelPosicaoTartaruga.setText(String.format("Posição Tartaruga: %s", espacoTartaruga.retornaStringPosicao()));
				
				
				validate();
				repaint();
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				
				labelOrientacaoTartaruga.setText(String.format("Direção Tartaruga: %s", espacoTartaruga.retornaStringOrientaacao()));
				labelCanetaTartaruga.setText(String.format("Posicão Caneta: %s", espacoTartaruga.retornaStringCaneta()));
				labelPosicaoTartaruga.setText(String.format("Posição Tartaruga: %s", espacoTartaruga.retornaStringPosicao()));
				
			}
			
			
			
		});
		
		

		
	}
	
}
