package View;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import dao.SessaoGravacaoDAO;
import model.SessaoGravacao;

public class ViewSessaoDeGravacao extends JPanel {
	private JComboBox cmbDia;
	private JComboBox cmbMes;
	private JSpinner spnAno;
	private JSpinner spnHora;
	private JSpinner spnMin;
	private JButton btnBuscar;
	private JScrollPane scrollPane;
	private JPanel pnlDados;
	private JButton btnNewButton;

	/**
	 * Create the panel.
	 */
	public ViewSessaoDeGravacao() {
		/*
		 * Definicao de um evento de click para os Radiobutton para definir quais 
		 * campos vão estar ativos ou não
		 */
		ActionListener evento_rdbSelecoes = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getActionCommand().equals("2")) {
					cmbDia.setEnabled(true);
					cmbMes.setEnabled(true);
					spnAno.setEnabled(true);
					spnHora.setEnabled(true);
					spnMin.setEnabled(true);
				}else {
					cmbDia.setEnabled(false);
					cmbMes.setEnabled(false);
					spnAno.setEnabled(false);
					spnHora.setEnabled(false);
					spnMin.setEnabled(false);
				}
			}
		};
		// Definicao dos campos da interface.
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{31, 0};
		gridBagLayout.rowHeights = new int[]{21, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.anchor = GridBagConstraints.WEST;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.VERTICAL;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{101, 121, 50, 0, 50, 50, 50, 0, 0};
		gbl_panel.rowHeights = new int[]{23, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		
		
		JRadioButton rdbSelcaoPorTudo = new JRadioButton("Selecionar Tudo");
		rdbSelcaoPorTudo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbSelcaoPorTudo.setSelected(true);
		rdbSelcaoPorTudo.setActionCommand("1");
		rdbSelcaoPorTudo.addActionListener(evento_rdbSelecoes);
		GridBagConstraints gbc_rdbSelcaoPorTudo = new GridBagConstraints();
		gbc_rdbSelcaoPorTudo.anchor = GridBagConstraints.WEST;
		gbc_rdbSelcaoPorTudo.insets = new Insets(0, 0, 0, 5);
		gbc_rdbSelcaoPorTudo.gridx = 0;
		gbc_rdbSelcaoPorTudo.gridy = 0;
		panel.add(rdbSelcaoPorTudo, gbc_rdbSelcaoPorTudo);
		
		JRadioButton rdbSelecaoPorDataInicial = new JRadioButton("Selecionar por Data Inicial");
		rdbSelecaoPorDataInicial.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbSelecaoPorDataInicial.setActionCommand("2");
		rdbSelecaoPorDataInicial.addActionListener(evento_rdbSelecoes);
		GridBagConstraints gbc_rdbSelecaoPorDataInicial = new GridBagConstraints();
		gbc_rdbSelecaoPorDataInicial.insets = new Insets(0, 0, 0, 5);
		gbc_rdbSelecaoPorDataInicial.anchor = GridBagConstraints.WEST;
		gbc_rdbSelecaoPorDataInicial.gridx = 1;
		gbc_rdbSelecaoPorDataInicial.gridy = 0;
		panel.add(rdbSelecaoPorDataInicial, gbc_rdbSelecaoPorDataInicial);
		
		String[] dias = { "1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		cmbDia = new JComboBox(dias);
		cmbDia.setEnabled(false);
		GridBagConstraints gbc_cmbDia = new GridBagConstraints();
		gbc_cmbDia.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbDia.insets = new Insets(0, 0, 0, 5);
		gbc_cmbDia.gridx = 2;
		gbc_cmbDia.gridy = 0;
		panel.add(cmbDia, gbc_cmbDia);
		
		String[] mes_Abreviacoes_ComboBox = {"Jan" , "Feb" , "Mar" , "Apr" , "May" , "Jun" , "Jul" , "Aug" , "Sep" , "Oct" , "Nov" , "Dec"};
		cmbMes = new JComboBox(mes_Abreviacoes_ComboBox);
		cmbMes.setEnabled(false);
		GridBagConstraints gbc_cmbMes = new GridBagConstraints();
		gbc_cmbMes.insets = new Insets(0, 0, 0, 5);
		gbc_cmbMes.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbMes.gridx = 3;
		gbc_cmbMes.gridy = 0;
		panel.add(cmbMes, gbc_cmbMes);
		
		//spnAno = new JSpinner(2018 , 2000 , 2100 , 1);
		spnAno = new JSpinner();
		spnAno.setModel(new SpinnerNumberModel(new Integer(2019), new Integer(2000), new Integer(2100), new Integer(1)));
		spnAno.setEnabled(false);
		GridBagConstraints gbc_spnAno = new GridBagConstraints();
		gbc_spnAno.fill = GridBagConstraints.HORIZONTAL;
		gbc_spnAno.insets = new Insets(0, 0, 0, 5);
		gbc_spnAno.gridx = 4;
		gbc_spnAno.gridy = 0;
		panel.add(spnAno, gbc_spnAno);
		
		spnHora = new JSpinner();
		spnHora.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0),new Integer(23), new Integer(1)));
		spnHora.setEnabled(false);
		GridBagConstraints gbc_spnHora = new GridBagConstraints();
		gbc_spnHora.fill = GridBagConstraints.HORIZONTAL;
		gbc_spnHora.insets = new Insets(0, 0, 0, 5);
		gbc_spnHora.gridx = 5;
		gbc_spnHora.gridy = 0;
		panel.add(spnHora, gbc_spnHora);
		
		spnMin = new JSpinner();
		spnMin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		spnMin.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), new Integer(59), new Integer(1)));
		spnMin.setEnabled(false);
		GridBagConstraints gbc_spnMin = new GridBagConstraints();
		gbc_spnMin.insets = new Insets(0, 0, 0, 5);
		gbc_spnMin.fill = GridBagConstraints.HORIZONTAL;
		gbc_spnMin.gridx = 6;
		gbc_spnMin.gridy = 0;
		panel.add(spnMin, gbc_spnMin);
		
		ButtonGroup rbgModoSelecao = new ButtonGroup();
		
		rbgModoSelecao.add(rdbSelecaoPorDataInicial);
		rbgModoSelecao.add(rdbSelcaoPorTudo);
		
		btnBuscar = new JButton("Buscar");
		
		GridBagConstraints gbc_btnBuscar = new GridBagConstraints();
		gbc_btnBuscar.gridx = 7;
		gbc_btnBuscar.gridy = 0;
		panel.add(btnBuscar, gbc_btnBuscar);
		
		JLabel lblNewLabel = new JLabel("Sessoes de Gravacao");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		add(lblNewLabel, gbc_lblNewLabel);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 2;
		add(scrollPane, gbc_scrollPane);
		
		pnlDados = new JPanel();
		scrollPane.setViewportView(pnlDados);
		GridBagLayout gbl_pnlDados = new GridBagLayout();
		gbl_pnlDados.columnWeights = new double[]{};
		pnlDados.setLayout(gbl_pnlDados);
		
		btnNewButton = new JButton("DadosTecnico");
		btnNewButton.setEnabled(false);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 10);
		gbc_btnNewButton.anchor = GridBagConstraints.EAST;
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 3;
		add(btnNewButton, gbc_btnNewButton);
		
		/*
		 * define como data inicial a data atual
		 */
		Calendar cal = Calendar.getInstance();
		spnAno.setValue(cal.get(Calendar.YEAR));
		spnHora.setValue(cal.get(Calendar.HOUR_OF_DAY));
		spnMin.setValue(cal.get(Calendar.MINUTE));
		cmbDia.setSelectedIndex(cal.get(Calendar.DAY_OF_MONTH) - 1);
		cmbMes.setSelectedIndex(cal.get(Calendar.MONTH));
		
		
		/*
		 * Definicao de um evento de click para o botao que vai iniciar a busca 
		 * no banco de dados.
		 */
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<SessaoGravacao> listas = null;
				// verifica quais das duas pesquisas vai ser feito
				try {
					if(rdbSelcaoPorTudo.isSelected()) { 
						listas = SessaoGravacaoDAO.getSessaoGravacao();
					}else {
						// define a data que vai ser usada na pesquisa
						String data = "";
						data = data + cmbDia.getSelectedItem() + "/" + cmbMes.getSelectedItem() + "/" + spnAno.getValue() + " " + spnHora.getValue() + ":" + spnMin.getValue();
						listas = SessaoGravacaoDAO.getSessaoGravacaoPorData(data);
					}
				}catch(RuntimeException exception) {
					JOptionPane.showMessageDialog(panel, exception.getMessage(),"Falhas", JOptionPane.ERROR_MESSAGE);
					return;
				}
				pnlDados.removeAll();
				int i = 0;
				// cria as interfaces que vai conter os dados das sessoes
				while( i < listas.size()) {
					SessaoGravaoPanel panel = new SessaoGravaoPanel(listas.get(i));
					GridBagConstraints gbc = new GridBagConstraints();
					gbc.gridx = 0;
					gbc.gridy = i;
					gbc.fill = GridBagConstraints.HORIZONTAL;
					gbc.insets = new Insets(0, 0, 10, 0);
					pnlDados.add(panel , gbc);
					i++;
				}
				//um ultimo componente para que os outros nao fiquem centralizados na tela
				GridBagConstraints gbc = new GridBagConstraints();
				gbc.gridx=0;
				gbc.gridy = i;
				gbc.weighty = 1.0;
				pnlDados.add(new Panel() , gbc);
				scrollPane.validate();
			}
		});
	}
	
}
