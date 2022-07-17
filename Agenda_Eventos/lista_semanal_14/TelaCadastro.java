package lista_semanal_14;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaCadastro extends JFrame{
	
	private String nome;
	private String data;
	private ArrayList<String> eventos = new ArrayList<>();
	private static ArrayList<Evento> ListaDeeventos = new ArrayList<>();
	public int interValo=0;
	public int cliques=0;
	public static TelaListagem janela = new TelaListagem(ListaDeeventos);
	public TelaCadastro() {

		setSize(400, 400);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		setBounds(getX()+200,getY(),400,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Tela Cadastro");
		
		
		adiconarComponentes(this);
		setVisible(true);
	}
	
	
	public void adiconarComponentes(JFrame tela){
		JPanel painel = new JPanel();
		painel.setBounds(0,0,400,70);

		
		JTextField nome= new JTextField("Nome do evento",23);

		painel.add(nome);

		JTextField data= new JTextField("Data do evento",23);
		painel.add(data);

		
		tela.add(painel);
		
		
		JPanel painel2 = new JPanel();
		painel2.setBounds(0,72,400,30);
		painel2.setLayout(null);
		
		
		JButton adicionarEvento= new JButton("Adicionar");
		adicionarEvento.setBounds(70,0,260,25);
		painel2.add(adicionarEvento);
		
		adicionarEvento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				setName(nome.getText());
				
				setData(data.getText());
				eventos.add(nome.getText());
				
				ListaDeeventos.add(new Evento(nome.getText(), data.getText()));

				//Exibe os dados da Lista
				for(String evento: eventos) {
					System.out.println(evento);
				}
				
				 
				if(interValo==1) {
					interValo=0;
					janela.dispose();
					janela = new TelaListagem(ListaDeeventos);
				}else {
					interValo=1;
					janela.dispose();
					janela = new TelaListagem(ListaDeeventos);
				}
				
			}
		});
		
		tela.add(painel2);
	}

	public String getNome() {
		return nome;
	}


	public void setNomePListar(String nome) {
		this.nome = nome;
	}


	public String getData() {
		return data;
	}


	public void setData(String data) {
		this.data = data;
	}
	
	

}
