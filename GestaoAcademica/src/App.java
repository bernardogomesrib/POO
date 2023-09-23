import java.sql.ResultSet;
import java.util.Scanner;
import DAO.AlunoDAO;
import DAO.CursoDAO;
import DB.Connectionn;
import Identities.Aluno;
import Identities.Curso;

public class App {
    public static void main(String[] args) throws Exception {
        boolean loop = true;
        Scanner sc = new Scanner(System.in);
        Aluno aluno = null;
        Curso curso = null;
        Connectionn conn = new Connectionn();
        AlunoDAO.inicializar(conn);
        CursoDAO.inicializar(conn);
        String sn;
        while(loop){
            System.out.println("[1] - Inserir aluno\n[2] - Atualizar aluno\n[3] - Remover aluno\n[4] - Listar alunos\n[5] - Inserir curso\n[6] - Atualizar curso\n[7] - Remover curso\n[8] - Listar cursos\n[9] - Sair\n");
            switch(sc.nextLine()){
                case "1":
                    System.out.println("Inserindo Aluno");
                    aluno = new Aluno(sc, 0);
                    
                    if(AlunoDAO.insert(aluno)==1){
                        System.out.println("Aluno inserido com sucesso!");
                    }else{
                        System.out.println("Não foi possivel inserir aluno");
                    }
                    break;
                case "2":
                    System.out.println("Atualizando Aluno");
                    aluno = new Aluno(sc,1);
                    aluno = AlunoDAO.procura(aluno.getId());
                    if (!aluno.getNome().equals(null)){
                        System.out.println("Nome atual: "+aluno.getNome()+"\nQuer atualizar o nome?[s/n]");
                    sn = sc.nextLine();
                    if(sn.equals("s")||sn.equals("S")){
                        System.out.println("Insira o nome:");
                        aluno.setNome(sc.nextLine());
                    }
                    System.out.println("Curso atual: "+aluno.getCurso()+"\nQuer atualizar o curso:[s/n]");
                    sn = sc.nextLine();
                    if(sn.equals("s")||sn.equals("S")){
                        System.out.println("Insira o curso:");
                        aluno.setCurso(sc.nextLine());
                    }
                    if(AlunoDAO.atualiza(aluno)==1)
                        System.out.println("Aluno atualizado com sucesso");
                    else
                        System.out.println("Não foi possivel atualizar o aluno...");
                    }
                    break;
                case "3":
                    System.out.println("Removendo Aluno");
                    if(AlunoDAO.delete(new Aluno(sc, 1))==1)
                        System.out.println("Aluno deletado com sucesso!");
                    else
                        System.out.println("Ocorreu algum erro ao remover o aluno...");
                    break;
                case "4":
                    System.out.println("Listando Alunos");
                    ResultSet alunos = AlunoDAO.alunos();
                    while(alunos.next()){
                        System.out.println("ID: "+alunos.getString(1)+"\nNome: "+alunos.getString(2)+"\nCurso: "+alunos.getString(3)+"\n");
                    }
                    break;
                case "5":
                    System.out.println("Inserindo Cursos");
                    curso = new Curso(sc, 0);
                    if(CursoDAO.insert(curso)==1){
                        System.out.println("Curso inserido com sucesso!");
                    }else{
                        System.out.println("Ocorreu algum problema ao inserir o curso");
                    }

                    break;
                case "6":
                    System.out.println("Atualizando Cursos");
                    curso = new Curso(sc,1);
                    curso = CursoDAO.procura(curso.getId());
                    if (!curso.getNome().equals(null)){
                        System.out.println("Nome atual: "+curso.getNome()+"\nQuer atualizar o nome?[s/n]");
                    sn = sc.nextLine();
                    if(sn.equals("s")||sn.equals("S")){
                        System.out.println("Insira o nome:");
                        curso.setNome(sc.nextLine());
                    }
                    System.out.println("Descrição atual:\n"+curso.getDescricao()+"\nQuer atualizar a descrição?:[s/n]");
                    sn = sc.nextLine();
                    if(sn.equals("s")||sn.equals("S")){
                        System.out.println("Insira a descrição:");
                        curso.setDescricao(sc.nextLine());
                    }
                    if(CursoDAO.atualiza(curso)==1)
                        System.out.println("Curso atualizado com sucesso");
                    else
                        System.out.println("Não foi possivel atualizar o curso...");
                    }
                     
                    break;
                case "7":
                    System.out.println("Remover Curso");
                    if(CursoDAO.delete(new Curso(sc, 1))==1)
                        System.out.println("Curso deletado com sucesso!");
                    else
                        System.out.println("Ocorreu algum erro ao remover o curso...");
                    break;
                case "8":
                    System.out.println("Listar Cursos");
                    ResultSet cursos = CursoDAO.cursos();
                    while(cursos.next()){
                        System.out.println("ID: "+cursos.getString(1)+"\nNome: "+cursos.getString(2)+"\nDescrição:\n"+cursos.getString(3)+"\n");
                    }
                    break;
                case "9":
                    System.out.println("Saindo");
                    loop = false;
                    break;
            }
        }
    }
}
