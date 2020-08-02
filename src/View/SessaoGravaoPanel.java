package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EtchedBorder;
import javax.swing.table.AbstractTableModel;

import model.Cena;
import model.SessaoGravacao;
import java.awt.Font;

/**
 * Essa classe tem como funcao encapsular a view que vai mostrar uma sessao.
 */
public class SessaoGravaoPanel extends JPanel {
	private JTable CenaTable;
	private JLabel lblTexto;
	private JLabel lblNewLabel;

	
	public SessaoGravaoPanel(SessaoGravacao ssg) {
		// define a interface
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setLayout(new BorderLayout(0, 0));
		//define o titulo do item
		lblTexto = new JLabel();
		lblTexto.setOpaque(true);
		lblTexto.setBackground(Color.WHITE);
		lblTexto.setText("Sala - " + ssg.getSala().getNumero() + " - " + ssg.getData() + " - " + ssg.getHora_inicial() + " - " + ssg.getHora_final() + " - "
				+ ssg.getCenas().get(0).getEpisodio().getAnime() + " - Temporada: " + ssg.getCenas().get(0).getEpisodio().getTemporada()
				+ " - Tecnico: " + ssg.getTecnico().getNome());
		add(lblTexto, BorderLayout.NORTH);
		//definicao de uma tabela para mostrar as cenas
		CenaTable = new JTable(new TableModelListaSessao(ssg.getCenas()));
		CenaTable.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		
		CenaTable.setRowSelectionAllowed(false);
		
		// java não coloca o header junto da tabela. Os dois devem ser adicionados separados.
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		panel.add(CenaTable.getTableHeader(), BorderLayout.PAGE_START);
		panel.add(CenaTable,BorderLayout.CENTER);

	}
/*
 * Modelo que vai cuidar de definir os dados que vai ser mostrado na view.
 */
private class TableModelListaSessao extends AbstractTableModel{
		
		private List<Cena> lista;
		
		public TableModelListaSessao(List<Cena> lista) {
			this.lista = lista;
		}

		@Override
		public int getRowCount() {
			return lista.size();
		}
		
		

		@Override
		public String getColumnName(int column) {
			if(column == 0) {
				return "Episodio";
			}else if(column == 1) {
				return "Cena";
			}
			return "";
		}

		@Override
		public int getColumnCount() {
			return 2;
		}
		
		

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			if(columnIndex == 0) {
				return lista.get(rowIndex).getEpisodio().getNumeroEp();
			}else if(columnIndex == 1) {
				return lista.get(rowIndex).getNumero();
			}
			return null;
		}
		
	}

}
