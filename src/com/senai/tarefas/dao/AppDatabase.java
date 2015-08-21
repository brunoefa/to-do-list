package com.senai.tarefas.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class AppDatabase {
	
	private final int DATABASE_VERSION = 1;

	private static final String DATABASE_NAME = "tarefas.db";
	
	private static final String TABLE_TAREFAS 		  = "tarefas";
	private static final String COLUMN_ID 			  = "_id";
	private static final String COLUMN_TAREFA 		  = "tarefa";
	private static final String COLUMN_CATEGORIA 	  = "categoria";
	private static final String COLUMN_DATA_CONCLUSAO = "dataconclusao";
	private static final String COLUMN_PRIORIDADE 	  = "prioridade";
	private static final String COLUMN_CONCLUIDO      = "concluido";
	
	private static final String TABLE_TAREFAS_CREATE = "create table " + TABLE_TAREFAS + " ("
			+ COLUMN_ID 			+ " integer primary key autoincrement, "
			+ COLUMN_TAREFA 		+ " text not null, "
			+ COLUMN_CATEGORIA 		+ " text not null, "
			+ COLUMN_DATA_CONCLUSAO + " text not null, "
			+ COLUMN_PRIORIDADE 	+ " text not null, "
			+ COLUMN_CONCLUIDO 		+ " integer DEFAULT 0);";
	
	private SQLiteDatabase database;
	private DatabaseHelper dbHelper;
	
	public AppDatabase(Context context) {
		this.dbHelper = new DatabaseHelper(context);
		this.database = dbHelper.getWritableDatabase();
	}
	
	public SQLiteDatabase getDatabase() {
		return database;
	}
	
	public void closeConnection() {
		dbHelper.close();
	}
	
	class DatabaseHelper extends SQLiteOpenHelper {

		public DatabaseHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
		}
		
		@Override
		public void onCreate(SQLiteDatabase db) {
			db.execSQL(TABLE_TAREFAS_CREATE);
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			Log.w("APP DATABASE", "Atualizando banco de dados da versão " + oldVersion +
				  " para a versão " + newVersion + ". Todos os dados serão perdidos");
			db.execSQL("DROP TABLE IF EXISTS " + TABLE_TAREFAS);
			onCreate(db);
		}
	}
}
