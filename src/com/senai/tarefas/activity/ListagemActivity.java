package com.senai.tarefas.activity;

import java.util.ArrayList;
import java.util.Arrays;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.senai.tarefas.R;

public class ListagemActivity extends ListActivity {
	
	ArrayList<String> listaTarefa = new ArrayList<String>(Arrays.asList(
			"Compra leite",
			"Fazer o para casa",
			"Pagar a conta do açougue",
			"Buscar o João na escola",
			"Enviar e-mail para o pedro",
			"Ler mais um capítulo do livro",
			"Baixar filme para o fim de semana",
			"Imprimir 2ª via do boleto"
	));

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Intent intent = getIntent();
		ArrayList<String> listaTarefaAuxiliar = intent.getStringArrayListExtra("listaTarefa");
		if (listaTarefaAuxiliar != null) {
			listaTarefa = listaTarefaAuxiliar;
		}
		ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, listaTarefa);
		this.setListAdapter(listAdapter);
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		
		l.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		l.setItemChecked(position, true);
		
		Object item = this.getListAdapter().getItem(position);
		Toast.makeText(this, item.toString(), Toast.LENGTH_LONG).show();
	}
	
	private void novaTarefa() {
		Intent intent = new Intent(this, CadastroActivity.class);
		intent.putStringArrayListExtra("listaTarefa", listaTarefa);
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
