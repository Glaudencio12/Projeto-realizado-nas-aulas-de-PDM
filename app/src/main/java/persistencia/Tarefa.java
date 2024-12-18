package persistencia;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Tarefa {
    private SQLiteOpenHelper bancoHelper;
    private SQLiteDatabase banco;

    private int id;
    private String descricao;
    private String data;
    private int status;


    public Tarefa(Context context) {
        bancoHelper = new Banco(context);
    }

    public void Cadastrar() {
        banco = bancoHelper.getWritableDatabase();

        ContentValues tarefa = new ContentValues();
        tarefa.put("descricao", this.descricao);
        tarefa.put("data", this.data);
        tarefa.put("status", this.status);

        banco.insert("tarefa", null, tarefa);
        banco.close();
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
