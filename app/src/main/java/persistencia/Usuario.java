package persistencia;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Usuario {

    private SQLiteOpenHelper bancoHelper;
    private SQLiteDatabase banco;

    private int id;
    private String nome;
    private String login;
    private String senha;
    private int categoria;

    public Usuario(Context context){
        bancoHelper = new Banco(context);
    }

    public void cadastrar(){
        banco = bancoHelper.getWritableDatabase();

        ContentValues conteudo = new ContentValues();
        conteudo.put("nome", this.nome);
        conteudo.put("login", this.login);
        conteudo.put("senha", this.senha);
        conteudo.put("categoria", this.categoria);

        banco.insert("usuarios", null, conteudo);
        banco.close();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }
}
