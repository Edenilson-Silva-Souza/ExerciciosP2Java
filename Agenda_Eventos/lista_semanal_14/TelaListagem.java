package lista_semanal_14;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TelaListagem extends JFrame {
	private int cliques=0;
	private int cc=0;
	public TelaListagem(ArrayList<Evento> event) {
	
		adicionarTabela(this, event);
		
		
		setSize(400, 400);
		setLocationRelativeTo(null);
		setBounds(getX()-200,getY(),400,400);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setTitle("Tela Listagem");
	}

	private void adicionarTabela(JFrame frame, ArrayList<Evento> event) {

		DefaultTableModel modelo = new DefaultTableModel();
		
		JTable tabela = new JTable(modelo);
		
		modelo.addColumn("Nome");
		modelo.addColumn("Data");
		
		tabela.addMouseListener(new MouseListener() {
			
			public void mouseReleased(MouseEvent e) {
			}
			
			public void mousePressed(MouseEvent e) {
				cliques++;
			}
			
			public void mouseExited(MouseEvent e) {
				cliques=0;
			}
			
			public void mouseEntered(MouseEvent e) {
			}
		
			public void mouseClicked(MouseEvent e) {
				
				if(tabela.getSelectedRow()==cc) {
					
					
					cliques++;
				}
				else {
					cc =tabela.getSelectedRow();
					cliques=1;
				}
				
				if(cliques>=2) {
					int opcao = JOptionPane.showConfirmDialog(null, "Deseja excluir?","Exculir componente",JOptionPane.YES_OPTION, JOptionPane.PLAIN_MESSAGE);
					
					if(opcao==0) {
						event.remove(tabela.getSelectedRow());
						System.out.println("Linha Apagada");
						dispose();
						TelaCadastro.janela=new TelaListagem(event);
					}
					else {
					System.out.println("Cancelado");	
					}
					
					cliques=0;
				}
			}
		});
		
		for (Evento evento : event) {
			Object[] linhas = new Object[] { evento.getNome(), evento.getDataEvento() };
			modelo.addRow(linhas);
			
		}

		JScrollPane conteiner = new JScrollPane(tabela);
		frame.add(conteiner);
	}

}



