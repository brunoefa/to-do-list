package com.senai.tarefas.dao;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.senai.tarefas.modelo.Tarefa;

public class TarefaDao {
	
	private SQLiteDatabase database;
	private AppDatabase dbHelper;
	private String[] colunas = {
			AppDatabase.COLUMN_ID,
			AppDatabase.COLUMN_TAREFA,
			AppDatabase.COLUMN_CATEGORIA,
			AppDatabase.COLUMN_DATA_CONCLUSAO,
			AppDatabase.COLUMN_PRIORIDADE,
			AppDatabase.COLUMN_CONCLUIDO,
	};
	
	public TarefaDao(Context context) {
		dbHelper = new AppDatabase(context);
		database = dbHelper.getDatabase();
	}

	public Tarefa salvar(Tarefa t) {

		ContentValues values = new ContentValues();
		values.put(AppDatabase.COLUMN_TAREFA , t.getTarefa());
		values.put(AppDatabase.COLUMN_CATEGORIA , t.getCategoria());
		values.put(AppDatabase.COLUMN_DATA_CONCLUSAO , t.getDataConclusao());
		values.put(AppDatabase.COLUMN_PRIORIDADE , t.getPrioridade());
		
		long insertId = database.insert(AppDatabase.TABLE_TAREFAS, null, values);
		Tarefa novaTarefa = buscar(insertId);
		return novaTarefa;
	}
	
	public Tarefa buscar(long id) {
		Tarefa t = null;
		Cursor cursor = database.query(AppDatabase.TABLE_TAREFAS, colunas,
				AppDatabase.COLUMN_ID + " = ?",
				new String[] { String.valueOf(id) }, null, null, null);

		if (cursor.moveToFirst()) {
			t = cursorToTarefa(cursor);
		}
		cursor.close();
		return t;
	}
	
	public Tarefa atualizar(Tarefa t) {
		ContentValues values = new ContentValues();
		values.put(AppDatabase.COLUMN_TAREFA , t.getTarefa());
		values.put(AppDatabase.COLUMN_CATEGORIA , t.getCategoria());
		values.put(AppDatabase.COLUMN_DATA_CONCLUSAO , t.getDataConclusao());
		values.put(AppDatabase.COLUMN_PRIORIDADE , t.getPrioridade());
		values.put(AppDatabase.COLUMN_CONCLUIDO , t.getConcluido());

		long insertId = database.update(AppDatabase.TABLE_TAREFAS, values, AppDatabase.COLUMN_ID + " = ?", new String[] {String.valueOf(t.getId())});
		Tarefa novaTarefa = buscar(insertId);
		return novaTarefa;
	}	
	
	public ArrayList<Tarefa> buscarTodos() {
		Tarefa t = null;
		ArrayList<Tarefa> listaDeTarefas = new ArrayList<Tarefa>();
		Cursor cursor = database.query(AppDatabase.TABLE_TAREFAS, colunas, null, null, null, null, null);
		
		if (cursor.moveToFirst()) {
			while (!cursor.isAfterLast()) {
				t = cursorToTarefa(cursor);
				listaDeTarefas.add(t);
				cursor.moveToNext();
			}			
		}
		cursor.close();
		return listaDeTarefas;
	}
	
	public ArrayList<Tarefa> buscarNaoConcluidos() {
		Tarefa t = null;
		ArrayList<Tarefa> listaDeTarefas = new ArrayList<Tarefa>();
		Cursor cursor = database.query(AppDatabase.TABLE_TAREFAS, colunas, AppDatabase.COLUMN_CONCLUIDO + " = ?", new String[] {"0"}, null, null, null);
		
		if (cursor.moveToFirst()) {
			while (!cursor.isAfterLast()) {
				t = cursorToTarefa(cursor);
				listaDeTarefas.add(t);
				cursor.moveToNext();
			}			
		}
		cursor.close();
		return listaDeTarefas;
	}
	
	private Tarefa cursorToTarefa(Cursor cursor) {
		Tarefa t = new Tarefa(
				cursor.getInt(0),
				cursor.getString(1),
				cursor.getString(2),
				cursor.getString(3),
				cursor.getString(4),
				cursor.getInt(5) == 1
		);
		return t;
	}
	
}











