package View;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import javax.swing.JTable;
import java.awt.GridBagConstraints;

import javax.swing.text.Element;
import dao.PersonagensDubladosDAO;
import model.PersonagensDublados;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Insets;
import java.util.Iterator;
import java.util.List;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.EtchedBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewPersonagens extends JPanel {
	private JTable table;
	private JSplitPane splitPane;//Guarda a janela a direita do menu, isso me permite alternar as janelas
	private ViewDublador janelaDublador;
	private String[] tipoDeVoz = {"TODOS OS TIPOS", "SOPRANO", "MEZZO SOPRANO", "CONTRALTO", "TENOR", "BARITONO", "BAIXO"};
	private String avisoInformacaoPersonagem = "<html>Selecione um personagem da<br/> tabela para obter mais informacao<html>";

	public ViewPersonagens(JSplitPane splitPane) {
		this.splitPane = splitPane;
		janelaDublador = new ViewDublador(this);
		janelaDublador.initViewDublador();
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{5, 5, 0, 0, 40, 0, 0};
		gridBagLayout.rowHeights = new int[]{5, 5, 5, 5, 5, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel label_PERSON_DUB = new JLabel("PERSONAGENS DUBLADOS ");
		label_PERSON_DUB.setForeground(Color.BLACK);
		label_PERSON_DUB.setHorizontalAlignment(SwingConstants.CENTER);
		label_PERSON_DUB.setLabelFor(label_PERSON_DUB);
		label_PERSON_DUB.setFont(new Font("Tahoma", Font.PLAIN, 18));//Fonte para titulo principal
		label_PERSON_DUB.setBackground(Color.BLACK);
		GridBagConstraints gbc_label_PERSON_DUB = new GridBagConstraints();
		gbc_label_PERSON_DUB.gridwidth = 3;
		gbc_label_PERSON_DUB.anchor = GridBagConstraints.WEST;
		gbc_label_PERSON_DUB.gridheight = 2;
		gbc_label_PERSON_DUB.insets = new Insets(0, 3, 5, 5);
		gbc_label_PERSON_DUB.gridx = 0;
		gbc_label_PERSON_DUB.gridy = 0;
		add(label_PERSON_DUB, gbc_label_PERSON_DUB);
		
		JLabel labelAvisoFunc = new JLabel(avisoInformacaoPersonagem);	
		labelAvisoFunc.setForeground(Color.RED);
		labelAvisoFunc.setFont(new Font("Tahoma", Font.BOLD, 11));//Manter esse tamanho de fonte para o aviso
		labelAvisoFunc.setVisible(false);
		GridBagConstraints gbc_labelAvisoFunc = new GridBagConstraints();
		gbc_labelAvisoFunc.gridwidth = 2;
		gbc_labelAvisoFunc.fill = GridBagConstraints.HORIZONTAL;
		gbc_labelAvisoFunc.anchor = GridBagConstraints.SOUTH;
		gbc_labelAvisoFunc.insets = new Insets(0, 0, 0, 5);
		gbc_labelAvisoFunc.gridx = 3;
		gbc_labelAvisoFunc.gridy = 4;
		add(labelAvisoFunc, gbc_labelAvisoFunc);
		
		JLabel lblNewLabel = new JLabel(" Filtrar vozes:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 2;
		add(lblNewLabel, gbc_lblNewLabel);

		JComboBox comboBox = new JComboBox(tipoDeVoz);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridwidth = 2;
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 2;
		add(comboBox, gbc_comboBox);
		
		table = new JTable();
		table.setAutoCreateColumnsFromModel(true);
		table.setAutoCreateRowSorter(true);
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));//Manter, fonte padrao da tabela nao eh alterada pela Classe View
		
		table.setForeground(Color.BLACK);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
		table.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		String[] colunasDasTabelas = {"ANIME", "PERSONAGEM", "TIPO DE VOZ"};
		DefaultTableModel defaultModel = new DefaultTableModel(new Object[][] {},colunasDasTabelas) {
				Class[] columnTypes = new Class[] {
					String.class, String.class, String.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
				boolean[] columnEditables = new boolean[] {
					false, false, false //Desabilita edições dos dados
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
			}
		};
		
		table.setModel(defaultModel);//Repassa pra tabela a formatacao que inclui como default
		
		JButton btnSelecaoInfoTab = new JButton("Informacoes do Personagem");
		GridBagConstraints gbc_btnSelecaoInfoTab = new GridBagConstraints();
		gbc_btnSelecaoInfoTab.anchor = GridBagConstraints.SOUTHEAST;
		gbc_btnSelecaoInfoTab.gridx = 5;
		gbc_btnSelecaoInfoTab.gridy = 4;
		
		JButton btnBuscar = new JButton("Buscar");
		GridBagConstraints gbc_btnBuscar = new GridBagConstraints();
		gbc_btnBuscar.anchor = GridBagConstraints.WEST;
		gbc_btnBuscar.insets = new Insets(0, 0, 5, 5);
		gbc_btnBuscar.gridx = 3;
		gbc_btnBuscar.gridy = 2;
		add(btnBuscar, gbc_btnBuscar);
		
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.gridwidth = 6;
		gbc_table.insets = new Insets(0, 0, 5, 0);
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 0;
		gbc_table.gridy = 3;
		
		JScrollPane panelTable = new JScrollPane(table);
		panelTable.setEnabled(false);
		
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				labelAvisoFunc.setVisible(false);//Desativa o botao de aviso
				try {
					List<PersonagensDublados> infos = PersonagensDubladosDAO.getAvaliacaoDublador(comboBox.getSelectedIndex());//consulta no banco
					splitPane.repaint();
					splitPane.revalidate();
					defaultModel.getDataVector().removeAllElements();//Apaga todos dados da tabela
	
					for(PersonagensDublados it: infos) {
						defaultModel.addRow(new Object[] { it.getAnime(), it.getPersonagem(), it.getTipoDeVoz()});//Insiro os dados na tabela
					}
				}catch(RuntimeException exception) {
					JOptionPane.showMessageDialog(ViewPersonagens.this, exception.getMessage(),"Falhas", JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
		});
		
		btnSelecaoInfoTab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow() >= 0) {//Se alguma linha estiver selecionada
					try {
						//Busco o anime e o personagem que deseja obter informacoes
						String anime = (String) defaultModel.getValueAt(table.getSelectedRow(), 0);
						String personagem = (String) defaultModel.getValueAt(table.getSelectedRow(), 1);
						String tipoDeVoz = (String) defaultModel.getValueAt(table.getSelectedRow(), 2);
						
						//Inclui na tabela de avaliacaoDublador
						janelaDublador.addInfoTable(anime, personagem, tipoDeVoz);
						labelAvisoFunc.setVisible(false);//Retira o aviso da tela
						splitPane.setRightComponent(janelaDublador);//Alterna para a tela do dublador
					}catch(RuntimeException exception) {
						JOptionPane.showMessageDialog(ViewPersonagens.this, exception.getMessage(),"Falhas", JOptionPane.ERROR_MESSAGE);
						return;
					}
				}else//Caso nenhuma linha estiver selecionada eh reportado um aviso
					labelAvisoFunc.setVisible(true);
			}
		});
		
		panelTable.setViewportBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		add(panelTable, gbc_table);
		add(btnSelecaoInfoTab, gbc_btnSelecaoInfoTab);	
	}
	
	public void setVisibleView() {
		splitPane.setRightComponent(this);
	}
}
