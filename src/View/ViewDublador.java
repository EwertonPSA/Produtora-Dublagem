package View;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import dao.AvaliacaoDubladorPersonagemDAO;
import dao.PersonagensDubladosDAO;
import model.AvaliacaoDubladorPersonagem;
import model.PersonagensDublados;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class ViewDublador  extends JPanel{
	private JTable tableDubladores;
	private ViewPersonagens janelaAnterior;
	private Font fontTitulo;
	private JLabel label_info_Personagem;
	private JLabel label_info_tipoDeVoz;
	private JLabel label_info_anime;
	private JLabel label_Descricao_Personagem;
	private DefaultTableModel defaultModel;
	
	/*Guarda a janela anterior para poder alternar entre as telas*/
	public ViewDublador(ViewPersonagens janelaPersonagem) {
		janelaAnterior = janelaPersonagem;
	}
	
	/*Esse construtor inicializa a janela da View avaliacao dos dubladores contendo botoes e tabela*/
	public void initViewDublador() {
		fontTitulo = new Font("Tahoma",Font.BOLD,14);//Coloca os titulos em negrito
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{5, 65, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 5, 5, 0, 5, 5, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JButton btnVoltar = new JButton("Voltar");
		GridBagConstraints gbc_btnVoltar = new GridBagConstraints();
		gbc_btnVoltar.anchor = GridBagConstraints.SOUTHWEST;
		gbc_btnVoltar.insets = new Insets(0, 0, 0, 5);
		gbc_btnVoltar.gridx = 0;
		gbc_btnVoltar.gridy = 6;
		
		JLabel label_Titulo_PERSONAGEM = new JLabel("Personagem:");
		label_Titulo_PERSONAGEM.setFont(fontTitulo);
		label_Titulo_PERSONAGEM.setForeground(Color.BLACK);
		label_Titulo_PERSONAGEM.setHorizontalAlignment(SwingConstants.CENTER);
		label_Titulo_PERSONAGEM.setLabelFor(label_Titulo_PERSONAGEM);
		label_Titulo_PERSONAGEM.setBackground(Color.BLACK);
		GridBagConstraints gbc_label_Titulo_PERSONAGEM = new GridBagConstraints();
		gbc_label_Titulo_PERSONAGEM.anchor = GridBagConstraints.NORTHWEST;
		gbc_label_Titulo_PERSONAGEM.insets = new Insets(0, 3, 5, 5);
		gbc_label_Titulo_PERSONAGEM.gridx = 0;
		gbc_label_Titulo_PERSONAGEM.gridy = 0;
		add(label_Titulo_PERSONAGEM, gbc_label_Titulo_PERSONAGEM);
		
		label_info_Personagem = new JLabel();
		GridBagConstraints gbc_label_info_Personagem = new GridBagConstraints();
		gbc_label_info_Personagem.anchor = GridBagConstraints.WEST;
		gbc_label_info_Personagem.gridwidth = 2;
		gbc_label_info_Personagem.insets = new Insets(0, 0, 5, 5);
		gbc_label_info_Personagem.gridx = 1;
		gbc_label_info_Personagem.gridy = 0;
		add(label_info_Personagem, gbc_label_info_Personagem);
		
		JLabel label_Titulo_TipoVoz = new JLabel("Tipo de voz:");
		label_Titulo_TipoVoz.setFont(fontTitulo);
		label_Titulo_TipoVoz.setHorizontalAlignment(SwingConstants.CENTER);
		label_Titulo_TipoVoz.setBackground(Color.BLACK);
		GridBagConstraints gbc_label_Titulo_TipoVoz = new GridBagConstraints();
		gbc_label_Titulo_TipoVoz.anchor = GridBagConstraints.NORTH;
		gbc_label_Titulo_TipoVoz.insets = new Insets(0, 0, 5, 5);
		gbc_label_Titulo_TipoVoz.gridx = 0;
		gbc_label_Titulo_TipoVoz.gridy = 2;
		add(label_Titulo_TipoVoz, gbc_label_Titulo_TipoVoz);
		
		label_info_tipoDeVoz = new JLabel("");
		GridBagConstraints gbc_label_info_tipoDeVoz = new GridBagConstraints();
		gbc_label_info_tipoDeVoz.gridwidth = 2;
		gbc_label_info_tipoDeVoz.anchor = GridBagConstraints.WEST;
		gbc_label_info_tipoDeVoz.insets = new Insets(0, 0, 5, 0);
		gbc_label_info_tipoDeVoz.gridx = 1;
		gbc_label_info_tipoDeVoz.gridy = 2;
		add(label_info_tipoDeVoz, gbc_label_info_tipoDeVoz);
		
		JLabel label_Titulo_Anime = new JLabel(" Anime:");
		label_Titulo_Anime.setFont(fontTitulo);
		label_Titulo_Anime.setHorizontalAlignment(SwingConstants.CENTER);
		label_Titulo_Anime.setBackground(Color.BLACK);
		GridBagConstraints gbc_label_Titulo_Anime = new GridBagConstraints();
		gbc_label_Titulo_Anime.anchor = GridBagConstraints.NORTHWEST;
		gbc_label_Titulo_Anime.insets = new Insets(0, 0, 5, 5);
		gbc_label_Titulo_Anime.gridx = 0;
		gbc_label_Titulo_Anime.gridy = 1;
		add(label_Titulo_Anime, gbc_label_Titulo_Anime);
		
		label_info_anime = new JLabel("");
		GridBagConstraints gbc_label_info_anime = new GridBagConstraints();
		gbc_label_info_anime.anchor = GridBagConstraints.WEST;
		gbc_label_info_anime.gridwidth = 2;
		gbc_label_info_anime.insets = new Insets(0, 0, 5, 5);
		gbc_label_info_anime.gridx = 1;
		gbc_label_info_anime.gridy = 1;
		add(label_info_anime, gbc_label_info_anime);
		
		JLabel label_Titulo_Descricao = new JLabel(" Descricao:");
		label_Titulo_Descricao.setFont(fontTitulo);
		GridBagConstraints gbc_label_Titulo_Descricao = new GridBagConstraints();
		gbc_label_Titulo_Descricao.anchor = GridBagConstraints.NORTHWEST;
		gbc_label_Titulo_Descricao.insets = new Insets(0, 0, 5, 5);
		gbc_label_Titulo_Descricao.gridx = 0;
		gbc_label_Titulo_Descricao.gridy = 3;
		add(label_Titulo_Descricao, gbc_label_Titulo_Descricao);
		
		tableDubladores = new JTable();
		tableDubladores.setFont(new Font("Tahoma", Font.PLAIN, 15));//Manter, a tabela nao pega o tamanho da font da View
		tableDubladores.setForeground(Color.BLACK);
		tableDubladores.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
		tableDubladores.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		tableDubladores.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		String[] colunasDasTabelas = {"DUBLADORES", "AVALIACAO MEDIA", "NOME AGENCIA", "EMAIL AGENCIA", "TELEFONE AGENCIA"};
		
		defaultModel = new DefaultTableModel(new Object[][] {},colunasDasTabelas) {
				Class[] columnTypes = new Class[] {
					String.class, Integer.class, String.class, String.class, String.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
				boolean[] columnEditables = new boolean[] {
					false, false, false, false, false //Desabilita edições dos dados
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
			}
		};
		
		label_Descricao_Personagem = new JLabel();
		label_Descricao_Personagem.setVerticalAlignment(SwingConstants.BOTTOM);
		label_Descricao_Personagem.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_label_Descricao_Personagem = new GridBagConstraints();
		gbc_label_Descricao_Personagem.anchor = GridBagConstraints.NORTH;
		gbc_label_Descricao_Personagem.fill = GridBagConstraints.HORIZONTAL;
		gbc_label_Descricao_Personagem.gridwidth = 2;
		gbc_label_Descricao_Personagem.gridheight = 2;
		gbc_label_Descricao_Personagem.insets = new Insets(0, 0, 5, 0);
		gbc_label_Descricao_Personagem.gridx = 1;
		gbc_label_Descricao_Personagem.gridy = 3;
		add(label_Descricao_Personagem, gbc_label_Descricao_Personagem);
		
		tableDubladores.setModel(defaultModel);
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.gridwidth = 3;
		gbc_table.insets = new Insets(0, 0, 5, 0);
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 0;
		gbc_table.gridy = 5;
		JScrollPane panelTable = new JScrollPane(tableDubladores);
		panelTable.setViewportBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelTable.setEnabled(false);
	
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				janelaAnterior.setVisibleView();
			}
		});
		
		add(panelTable, gbc_table);
		add(btnVoltar, gbc_btnVoltar);
	}
	
	/* Adiciona informacoes na tabela da ViewDublador*/
	public void addInfoTable(String anime, String personagem, String tipoDeVoz) {
		List<AvaliacaoDubladorPersonagem> infos = AvaliacaoDubladorPersonagemDAO.getAvaliacaoDublador(anime, personagem);//consulta no banco do dublador
		if(infos.size() > 0)
			label_Descricao_Personagem.setText(infos.get(0).getDescricao());
		
		label_info_Personagem.setText(personagem);;
		label_info_tipoDeVoz.setText(tipoDeVoz);
		label_info_anime.setText(anime);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		tableDubladores.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
		
		defaultModel.getDataVector().removeAllElements();//Apaga todos dados da tabela
		for(AvaliacaoDubladorPersonagem it: infos) {
			defaultModel.addRow(new Object[] { it.getNome(), it.getAvaliacaoTotal(), it.getNomeDaAgencia(), it.getEmailAgencia(), it.getTelefoneDaAgencia()});//Insiro os dados na tabela
		}
	}
}
