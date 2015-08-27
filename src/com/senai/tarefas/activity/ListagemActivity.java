package com.senai.tarefas.activity;


import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.senai.tarefas.R;
import com.senai.tarefas.adapter.TarefaAdapter;
import com.senai.tarefas.dao.TarefaDao;
import com.senai.tarefas.modelo.Tarefa;

public class ListagemActivity extends ListActivity {
	
	private ArrayList<Tarefa> listaTarefa = new ArrayList<Tarefa>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_listagem);
		
		ListView list = getListView();
		
		TarefaDao dao = new TarefaDao(this);
		listaTarefa = dao.buscarTodos();

		TarefaAdapter adapter = new TarefaAdapter(this, listaTarefa);
		list.setAdapter(adapter);
	}
	
	private void novaTarefa() {
		Intent intent = new Intent(this, CadastroActivity.class);
		startActivity(intent);
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
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
