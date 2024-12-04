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
        String sql = "CREATE TABLE usuarios ("+
                "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "nome TEXT,"+
                "login TEXT,"+
                "senha TEXT,"+
                "categoria INTEGER);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS usuarios");
        onCreate(db);
    }

}
