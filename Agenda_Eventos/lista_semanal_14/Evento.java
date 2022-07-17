package lista_semanal_14;

public class Evento {
	private String nome; 
	private String dataEvento;
	
	
	public Evento(String nome, String dataEvento) {
		this.nome = nome;
		this.dataEvento = dataEvento;
	}

	public  String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getDataEvento() {
		return dataEvento;
	}


	public void setDataEvento(String dataEvento) {
		this.dataEvento = dataEvento;
	}
	
	
	
}
