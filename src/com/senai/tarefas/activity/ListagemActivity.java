package com.senai.tarefas.activity;


import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.senai.tarefas.R;
import com.senai.tarefas.adapter.TarefaAdapter;
import com.senai.tarefas.dao.TarefaDao;
import com.senai.tarefas.modelo.Tarefa;

public class ListagemActivity extends ListActivity {
	
	private ArrayList<Tarefa> listaTarefa = new ArrayList<Tarefa>();
	
	private final static Integer NAO_CONCLUIDAS = 0;
	private final static Integer TODOS = 1; 
	private Integer status = NAO_CONCLUIDAS;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_listagem);
		listarTarefas(NAO_CONCLUIDAS);
	}
	
	private void listarTarefas(Integer status){
		ListView list = getListView();
		TarefaDao dao = new TarefaDao(this);

		if (status == TODOS) {
			listaTarefa = dao.buscarTodos();
		} else {
			listaTarefa = dao.buscarNaoConcluidos();
		}
		
		this.status = status;
		
		TarefaAdapter adapter = new TarefaAdapter(this, listaTarefa);
		list.setAdapter(adapter);
	}
	
	private void novaTarefa() {
		Intent intent = new Intent(this, CadastroActivity.class);
		startActivity(intent);
	}

	private void mostrarMensagem(String m) {
		Toast.makeText(this, m, Toast.LENGTH_LONG).show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.listagem, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.acao_cadastrar) {
			novaTarefa();
		}
		if (id == R.id.acao_mostrar_concluidos) {
			if (this.status == TODOS) {
				item.setIcon(R.drawable.checkicon);
				listarTarefas(NAO_CONCLUIDAS);
			} else {
				item.setIcon(R.drawable.uncheckicon);
				listarTarefas(TODOS);
			}
		}
		return super.onOptionsItemSelected(item);
	}
}
