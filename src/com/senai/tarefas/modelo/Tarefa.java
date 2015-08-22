package com.senai.tarefas.modelo;

public class Tarefa {

	private Integer id;
	private String tarefa;
	private String categoria;
	private String dataConclusao;
	private String prioridade;
	private Boolean concluido;

	public Tarefa(Integer id, String tarefa, String categoria,
			String dataConclusao, String prioridade, Boolean concluido) {
		super();
		this.id = id;
		this.tarefa = tarefa;
		this.categoria = categoria;
		this.dataConclusao = dataConclusao;
		this.prioridade = prioridade;
		this.concluido = concluido;
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getConcluido() {
		return concluido;
	}

	public void setConcluido(Boolean concluido) {
		this.concluido = concluido;
	}

	@Override
	public String toString() {
		return getTarefa() + " - " + getCategoria() + " - "
				+ getDataConclusao() + " - " + getPrioridade();
	}
}
