package gestao;

public class DispositivoGrupo {
	private String nome;
	private int quantidade;
	private double potencia;
	private double horasUsadas;
	
	public DispositivoGrupo(String nome,int quantidade,double potencia,double horasUsadas) {
		this.nome = nome;
		this.quantidade = quantidade;
		this.potencia = potencia;
		this.horasUsadas = horasUsadas;		
	}
	public double getConsumoIndividual(){
		return this.potencia*horasUsadas;
	}
	public double getConsumoGrupal() {
		return this.potencia*this.horasUsadas*this.quantidade;
	}
	public String getNome() {
		return nome;
	}
}
