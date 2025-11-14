package main.dados;

import java.util.ArrayList;

/*Crie uma classe Aluno (entidade) que deve conter os atributos:

matricula (int)

nome (String)

nota1 (double)

nota2 (double)*/

public class Aluno {
	private int matricula;
	private String nome;
	private double nota1;
	private double nota2;
	
	public Aluno(String nome, double n1, double n2){
		this.nome = nome;
		this.nota1 = n1;
		this.nota2 = n2;
	}
	
	public Aluno() {
		this.nome = null;
		this.nota1 = 0;
		this.nota2 = 0;
	}
	
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getNota1() {
		return nota1;
	}
	public void setNota1(double nota1) {
		this.nota1 = nota1;
	}
	public double getNota2() {
		return nota2;
	}
	public void setNota2(double nota2) {
		this.nota2 = nota2;
	}

	public double calcularMedia() {
		return (nota1+nota2)/2;
	}
	
	public ArrayList<String> imprimeInfo() {
		ArrayList<String> ret = new ArrayList<String>();
		ret.add(Integer.toString(getMatricula()));
		ret.add(getNome());
		ret.add(Double.toString(calcularMedia()));
			
		return ret;
	}
}
