package com.senai.tarefas.modelo;

public class Tarefa {
	
	private String tarefa;
	private String categoria;
	private String dataConclusao;
	private String prioridade;
	
	public Tarefa(String tarefa, String categoria, String dataConclusao, String prioridade) {
		super();
		this.tarefa = tarefa;
		this.categoria = categoria;
		this.dataConclusao = dataConclusao;
		this.prioridade = prioridade;
	}
	
	public Tarefa() {
		
	}
	
	public String getTarefa() {
		return tarefa;
	}
	public void setTarefa(String tarefa) {
		this.tarefa = tarefa;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getDataConclusao() {
		return dataConclusao;
	}
	public void setDataConclusao(String dataConclusao) {
		this.dataConclusao = dataConclusao;
	}
	public String getPrioridade() {
		return prioridade;
	}
	public void setPrioridade(String prioridade) {
		this.prioridade = prioridade;
	}
	
	@Override
	public String toString() {
		return getTarefa() + " - " + 
			   getCategoria() + " - " + 
			   getDataConclusao() + " - " + 
			   getPrioridade();
	}
}
