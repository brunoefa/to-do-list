package com.senai.tarefas.activity;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.senai.tarefas.R;
import com.senai.tarefas.dao.TarefaDao;
import com.senai.tarefas.modelo.Tarefa;

public class CadastroActivity extends Activity {

	private TarefaDao tarefaDao;
	private Tarefa tarefa;
	ArrayList<String> listaTarefa = new ArrayList<String>();
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cadastro);
		tarefaDao = new TarefaDao(this);
		Intent intent = getIntent();
		ArrayList<String> listaTarefaAuxiliar = intent.getStringArrayListExtra("listaTarefa");
		if (listaTarefaAuxiliar != null) {
			listaTarefa = listaTarefaAuxiliar;
		}
	}
	
	public void salvar(View view) {
		capturarDados();
		adicionarTarefa(tarefa.toString());
		mostrarListagem();
	}
	
	private void adicionarTarefa(String tarefa) {
		listaTarefa.add(tarefa);
	}
	
	private void mostrarListagem() {
		Intent intent = new Intent(this, ListagemActivity.class);
		intent.putStringArrayListExtra("listaTarefa", listaTarefa);
		startActivity(intent);
	}
	
	private void capturarDados() {
		this.tarefa = new Tarefa();
		
		EditText etTarefa = (EditText)findViewById(R.id.et_tarefa);
		tarefa.setTarefa(etTarefa.getText().toString());
		
		EditText etCategoria = (EditText)findViewById(R.id.et_categoria);
		tarefa.setCategoria(etCategoria.getText().toString());
		
		EditText etDataConclusao = (EditText)findViewById(R.id.et_conclusao);
		tarefa.setDataConclusao(etDataConclusao.getText().toString());
		
		RadioGroup rgPrioridade = (RadioGroup)findViewById(R.id.rg_prioridade);
		tarefa.setPrioridade(((RadioButton)findViewById(rgPrioridade.getCheckedRadioButtonId())).getText().toString());
		
	}
	
	private void mostrarMensagem(String m) {
		Toast.makeText(this, m, Toast.LENGTH_LONG).show();
	}
	
	private void cancelar() {
		mostrarListagem();
	}
	
	public void cancelar(View view) {
		cancelar();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.cadastro, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.acao_cancelar) {
			cancelar();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
