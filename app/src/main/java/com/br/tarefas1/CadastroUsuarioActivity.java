package com.br.tarefas1;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import persistencia.Usuario;

public class CadastroUsuarioActivity extends AppCompatActivity {

    private EditText nome;
    private EditText login;
    private EditText senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_usuario);
        this.nome = findViewById(R.id.campoNome);
        this.login = findViewById(R.id.campoLogin);
        this.senha = findViewById(R.id.campoSenha);
    }


    public void salvar(View v){
        Usuario usuario = new Usuario(this);
        usuario.setNome(this.nome.getText().toString());
        usuario.setLogin(this.login.getText().toString());
        usuario.setSenha(this.senha.getText().toString());
        usuario.setCategoria(1);

        usuario.cadastrar();

        AlertDialog.Builder msg = new AlertDialog.Builder(this);
        msg.setMessage("Usuário cadastrado com sucesso");
        msg.setTitle("Confirmação");
        msg.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        msg.create();
        msg.show();

    }

}//Fim da Classe