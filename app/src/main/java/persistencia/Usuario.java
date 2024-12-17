package persistencia;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Usuario {

    private static Usuario usuario;

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

    public static Usuario logado(){
        return usuario;
    }

    public boolean realizarLogin(String login, String senha){
        if(this.getUsuario(login)){
            if(this.senha.equals(senha)){
                usuario = this;
                return true;
            }
        }
        return false;
    }

    public boolean getUsuario(String login){
        this.banco = this.bancoHelper.getReadableDatabase();

        String condicao = "login = ?";
        String[] args = {login};
        Cursor cursor = this.banco.query(
                "usuarios",
                null,
                condicao,
                args,
                null,
                null,
                null
        );
        if(cursor.moveToFirst()){
            this.id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
            this.nome = cursor.getString(cursor.getColumnIndexOrThrow("nome"));
            this.login = cursor.getString(cursor.getColumnIndexOrThrow("login"));
            this.senha = cursor.getString(cursor.getColumnIndexOrThrow("senha"));
            this.categoria = cursor.getInt(cursor.getColumnIndexOrThrow("categoria"));
            return true;
        }
        return false;

    }//Fim da Função

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
