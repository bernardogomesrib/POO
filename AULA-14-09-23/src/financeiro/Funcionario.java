package financeiro;

public class Funcionario {
    public static void print(String s){
        System.out.println(s);
    }
	private String Nome;	
	private String cargo;
	private String horario;
	private double salariobase;
	public Funcionario(String Nome,String cargo,String horario,double salariobase) {
		// TODO Auto-generated constructor stub
	}
	public void relatorio() {
		
		print("Nome: "+this.Nome);
		print("Cargo: "+this.cargo);
		print("Horário: "+this.horario);
		print(String.format("Salário base: R$%.2f",salariobase));
		

		
		
		double adcionalPericulosidade = 0;
		if (cargo.equals("Vigilante") || cargo.equals("vigilante")) {			
			adcionalPericulosidade = this.salariobase*0.4;
			print(String.format("Adicional de periculosidade: R$%.2f",adcionalPericulosidade));			
		}
		double adcionalNoturno = 0;
		if(this.horario.equals("19h às 07h") || this.horario.equals("19h as 07h")) {
			adcionalNoturno = this.salariobase*0.3;
			print("Adcional noturno: "+String.format("R$%.2f",adcionalNoturno));
		}
		double somatorioSalario = (this.salariobase + adcionalNoturno+ adcionalPericulosidade);
		double descontoAlimentacao = this.salariobase*retornaDisconto(this.salariobase);
		print(String.format("Desconto de alimentação: R$%.2f",descontoAlimentacao));
		double inss = somatorioSalario*retornaInssCalculo(somatorioSalario);
		print(String.format("INSS: R$%.2f",inss));
		double irrf = retornaIRRF(somatorioSalario- inss);
		print(String.format("IRRF: R$%.2f",irrf));
		double salarioLiquido = somatorioSalario - inss - irrf;
		print(String.format("Salário liquido: R$%.2f",salarioLiquido));
		
	}
	private static double retornaDisconto(double salario) {
		if (salario<=2000){
			return 0.01;
		}else {
			return 0.02;
		}
	}
	private static double retornaInssCalculo(double salario) {
		if(salario<=1312){
			return 0.075;
		}else if (salario >1312 && salario <2571.30) {
			return 0.09;
		}else if (salario<3856.94) {
			return 0.12;
		}else {
			return 0.14;
		}
	}
	private static double retornaIRRF(double salario) {
		if (salario <= 1903.98){return salario;}
		else if (salario >= 1903.98 && salario <= 2826.65){
			return salario * 0.075; 	
		}

		if (salario >= 2826.65 && salario <= 3751.06){
			return salario * 0.15;
		} 
		if (salario >= 3751.06 && salario <= 4664.68){
			return salario * 0.225;	
		}

		else {
			return salario * 0.275;	
		}

	}
}
