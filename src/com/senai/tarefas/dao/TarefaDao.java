package com.senai.tarefas.dao;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.senai.tarefas.modelo.Tarefa;

public class TarefaDao {
	
	private SQLiteDatabase database;
	private AppDatabase dbHelper;
	
	public TarefaDao(Context context) {
		dbHelper = new AppDatabase(context);
		database = dbHelper.getDatabase();
	}

	public long salvar(Tarefa t) {

		ContentValues values = new ContentValues();
		values.put(AppDatabase.COLUMN_TAREFA , t.getTarefa());
		values.put(AppDatabase.COLUMN_CATEGORIA , t.getCategoria());
		values.put(AppDatabase.COLUMN_DATA_CONCLUSAO , t.getDataConclusao());
		values.put(AppDatabase.COLUMN_PRIORIDADE , t.getPrioridade());
		
		long insertId = database.insert(AppDatabase.TABLE_TAREFAS, null, values);
		
		return insertId;
	}
	
	public void deletar(Tarefa t) {

	}
	
	public Tarefa buscar(Integer id) {
		return null;
	}
	
	public ArrayList<Tarefa> buscarTodos() {
		return null;
	}
}
