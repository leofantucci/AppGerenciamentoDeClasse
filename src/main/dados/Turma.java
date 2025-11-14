package main.dados;

import java.util.ArrayList;

/*Crie uma classe Turma (controle/negócio) que deve conter como atributo:

Um vetor (array) de objetos Aluno. Ex: Aluno[] alunos;

Um contador (int) para saber quantos alunos já foram inseridos no vetor (necessário para não ultrapassar o limite).

Método adicionarAluno(Aluno a): Adiciona um novo aluno ao vetor. (Lembre-se de verificar se o vetor não está cheio).

Método listarAlunos(): Retorna uma String (ou um ArrayList<String>) contendo os dados de todos os alunos cadastrados e sua respectiva média.


*/

public class Turma {
	ArrayList<Aluno> alunos = new ArrayList<Aluno>();
	int contador = 1;
	
	public void adicionarAluno(Aluno a) {
		if(contador <= 40) {
			alunos.add(a);
			a.setMatricula(contador);
			contador++;
		} else {
			System.out.println("Erro! Turma cheia...");
		}
	}
	
	public ArrayList<String> listarAlunos() {
		ArrayList<String> ret = new ArrayList<String>();
		for(Aluno a : alunos) {
			ret.add(a.getMatricula() + a.getNome() + a.calcularMedia());
		}
		return ret;
	}
	
	public ArrayList<Aluno> getAlunos(){
		return alunos;
	}
	
public ArrayList<String> getAlunosNome(){
	ArrayList<String> ret = new ArrayList<String>();
	for(Aluno a : alunos) {
		ret.add(a.getNome());
	}
	return ret;
	}
	
	public void consultarAluno(int matricula) {
		boolean tem = false;
		for(Aluno a : alunos) {
			if(a.getMatricula() == matricula) {
				System.out.println(a.imprimeInfo());
				tem = true;
				break;
			}	
		}
		if(!tem) {
			System.out.println("Nenhum aluno com essa matricula foi encontrado...");
		}
	}
	
	public void consultarAluno(String nome) { // Opcao de mostrar o primeiro retorno ou todos
		boolean tem = false;
		for(Aluno a : alunos) {
			if(a.getNome().toLowerCase().equals(nome.toLowerCase())) {
				System.out.println(a.imprimeInfo());
				tem = true;

				/*if(key == 0) {
					break;
				}*/
			}
		}
		if(!tem) {
			System.out.println("Nenhum aluno com esse nome foi encontrado...");
		}
	}
	
	public int getIdAtual() {
		return contador;
	}
}
