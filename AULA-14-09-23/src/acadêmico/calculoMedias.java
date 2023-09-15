package acadêmico;



public class calculoMedias {

	public static void main(String[] args) {
		UnidadeCurricular unidade = new UnidadeCurricular();
		print(unidade.getNome());
		Aluno pior = null;
		Aluno melhor = null;
		double somaMedias = 0;
		for(int i = 0;i<unidade.getAlunos().size();i++) {
			
			String nomeAluno = unidade.getAlunos().get(i).getNome();
			double media =unidade.getAlunos().get(i).getMedia();
			somaMedias += media;
			print("o aluno "+nomeAluno+" tirou uma media de "+media);
			if (i == 0) {
				pior = unidade.getAlunos().get(i);
				melhor = unidade.getAlunos().get(i);
			}else if (media < pior.getMedia()) {
				pior = unidade.getAlunos().get(i);
			}else if (media > melhor.getMedia()) {
				melhor = unidade.getAlunos().get(i);				
			}
				
		}
		print("A media de notas da unidade "+unidade.getNome()+" é "+somaMedias/unidade.getAlunos().size());
		print("o pior aluno é "+pior.getNome()+" com uma media de "+pior.getMedia());
		print("o melhor aluno é "+melhor.getNome()+" com uma media de "+melhor.getMedia());
		
	}
	public static void print(String s) {
		System.out.println(s);
	}

}
