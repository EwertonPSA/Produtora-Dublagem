package View;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Insets;
import javax.swing.JLabel;
import java.awt.event.ActionListener;

/*Sessao de Gravacao
Animes
Tecnicos
Dubladores
Diretores
Personagens-> Consulta timbre e mostra relacao personagem/dublador/avalia
Agencias de dublagens
*/

public class View {

	private JFrame frame;
	private final Action action = new SwingAction();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		java.util.Enumeration keys = UIManager.getDefaults().keys();
		javax.swing.plaf.FontUIResource f = new javax.swing.plaf.FontUIResource("Tahoma",Font.PLAIN,15);
	    while (keys.hasMoreElements()) {
	      Object key = keys.nextElement();
	      Object value = UIManager.get (key);
	      if (value instanceof javax.swing.plaf.FontUIResource)
	        UIManager.put (key, f);
	    }
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View window = new View();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Cria a aplicacao.
	 */
	public View() {
		initialize();
	}

	/**
	 * Inicializa os elementos da janela.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1100, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		frame.getContentPane().add(splitPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		splitPane.setRightComponent(panel);
		
		JScrollPane scrollPane = new JScrollPane();
		splitPane.setLeftComponent(scrollPane);
		
		JPanel panel_1 = new JPanel();
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}
		scrollPane.setViewportView(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0};
		gbl_panel_1.rowHeights = new int[]{25, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel menuRegistrar = new JLabel("  Registrar :");
		GridBagConstraints gbc_menuRegistrar = new GridBagConstraints();
		gbc_menuRegistrar.anchor = GridBagConstraints.WEST;
		gbc_menuRegistrar.insets = new Insets(0, 0, 5, 0);
		gbc_menuRegistrar.gridx = 0;
		gbc_menuRegistrar.gridy = 0;
		panel_1.add(menuRegistrar, gbc_menuRegistrar);
		
		JButton buttonRegistrarGravacao = new JButton("Sessao de Gravacao");
		buttonRegistrarGravacao.setEnabled(false);
		buttonRegistrarGravacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				splitPane.setRightComponent(new ViewSessaoDeGravacao());
			}
		});
		GridBagConstraints gbc_buttonRegistrarGravacao = new GridBagConstraints();
		gbc_buttonRegistrarGravacao.insets = new Insets(0, 0, 5, 0);
		gbc_buttonRegistrarGravacao.fill = GridBagConstraints.HORIZONTAL;
		gbc_buttonRegistrarGravacao.gridx = 0;
		gbc_buttonRegistrarGravacao.gridy = 1;
		panel_1.add(buttonRegistrarGravacao, gbc_buttonRegistrarGravacao);
		
		JButton btnAnimes = new JButton("Animes");
		btnAnimes.setEnabled(false);
		btnAnimes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JButton btnAnimes_1 = new JButton("Animes");
		btnAnimes_1.setEnabled(false);
		GridBagConstraints gbc_btnAnimes_1 = new GridBagConstraints();
		gbc_btnAnimes_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAnimes_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnAnimes_1.gridx = 0;
		gbc_btnAnimes_1.gridy = 2;
		panel_1.add(btnAnimes_1, gbc_btnAnimes_1);
		
		JLabel menuConsultar = new JLabel("  Consultar :");
		GridBagConstraints gbc_menuConsultar = new GridBagConstraints();
		gbc_menuConsultar.insets = new Insets(0, 0, 5, 0);
		gbc_menuConsultar.anchor = GridBagConstraints.WEST;
		gbc_menuConsultar.gridx = 0;
		gbc_menuConsultar.gridy = 3;
		panel_1.add(menuConsultar, gbc_menuConsultar);
		
		JButton btnSessoDeGravao = new JButton("Sessoes de Gravacoes");
		btnSessoDeGravao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewSessaoDeGravacao sessaoGravacao = new ViewSessaoDeGravacao();
				splitPane.setRightComponent(sessaoGravacao);
			}
		});
		GridBagConstraints gbc_btnSessoDeGravao = new GridBagConstraints();
		gbc_btnSessoDeGravao.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSessoDeGravao.insets = new Insets(0, 0, 5, 0);
		gbc_btnSessoDeGravao.gridx = 0;
		gbc_btnSessoDeGravao.gridy = 4;
		panel_1.add(btnSessoDeGravao, gbc_btnSessoDeGravao);
		
		JButton btnPersonagens = new JButton("Personagens");
		btnPersonagens.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewPersonagens viewPersonagem = new ViewPersonagens(splitPane);
				splitPane.setRightComponent(viewPersonagem );
			}
		});
		GridBagConstraints gbc_btnPersonagens = new GridBagConstraints();
		gbc_btnPersonagens.insets = new Insets(0, 0, 5, 0);
		gbc_btnPersonagens.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnPersonagens.gridx = 0;
		gbc_btnPersonagens.gridy = 5;
		panel_1.add(btnPersonagens, gbc_btnPersonagens);
		GridBagConstraints gbc_btnAnimes = new GridBagConstraints();
		gbc_btnAnimes.insets = new Insets(0, 0, 5, 0);
		gbc_btnAnimes.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAnimes.gridx = 0;
		gbc_btnAnimes.gridy = 6;
		panel_1.add(btnAnimes, gbc_btnAnimes);
		
		JButton btnDubladores = new JButton("Dubladores");
		btnDubladores.setEnabled(false);
		GridBagConstraints gbc_btnDubladores = new GridBagConstraints();
		gbc_btnDubladores.insets = new Insets(0, 0, 5, 0);
		gbc_btnDubladores.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnDubladores.gridx = 0;
		gbc_btnDubladores.gridy = 7;
		panel_1.add(btnDubladores, gbc_btnDubladores);
		
		JButton btnTcnicoDeAudio = new JButton("Tecnico de Audio");
		btnTcnicoDeAudio.setEnabled(false);
		GridBagConstraints gbc_btnTcnicoDeAudio = new GridBagConstraints();
		gbc_btnTcnicoDeAudio.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnTcnicoDeAudio.gridx = 0;
		gbc_btnTcnicoDeAudio.gridy = 8;
		panel_1.add(btnTcnicoDeAudio, gbc_btnTcnicoDeAudio);
	}
	

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
