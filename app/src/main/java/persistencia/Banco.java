package persistencia;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Banco extends SQLiteOpenHelper {

    public Banco(Context context){
        super(context, "gerenciador", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlUsuarios = "CREATE TABLE usuarios ("+
                "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "nome TEXT,"+
                "login TEXT,"+
                "senha TEXT,"+
                "categoria INTEGER);";
        db.execSQL(sqlUsuarios);

        String sqlTarefa = "CREATE TABLE tarefa (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "descricao TEXT," +
                "data TEXT," +
                "status INTEGER);";
        db.execSQL(sqlTarefa);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS usuarios");
        db.execSQL("DROP TABLE IF EXISTS tarefa");
        onCreate(db);
    }

}
