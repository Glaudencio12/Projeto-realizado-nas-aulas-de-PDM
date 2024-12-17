package com.br.tarefas1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import persistencia.Usuario;


public class MainActivity extends AppCompatActivity {

    private EditText editLogin;
    private EditText editSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.editLogin = findViewById(R.id.editLogin);
        this.editSenha = findViewById(R.id.editSenha);
    }

    public void logar(View v){

        String login = editLogin.getText().toString();
        String senha = editSenha.getText().toString();
        Usuario usuario = new Usuario(this);
        if(usuario.realizarLogin(login, senha)){
            Intent janela_principal = new Intent(this,
                    PrincipalActivity.class);
            startActivity(janela_principal);
        }else{
            AlertDialog.Builder msg = new AlertDialog.Builder(this);
            msg.setMessage("Usuário não encontrado ou senha inválida!");
            msg.setTitle("Aviso");
            msg.setNeutralButton("OK", null);
            msg.create();
            msg.show();
        }
    }

    public void abrirCadastro(View v){
        Intent tela_cadastro = new Intent(this, CadastroUsuarioActivity.class);
        startActivity(tela_cadastro);
    }

}