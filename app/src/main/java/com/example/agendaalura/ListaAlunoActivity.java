package com.example.agendaalura;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.agendaalura.dao.AlunoDAO;
import com.example.agendaalura.modelo.Aluno;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class ListaAlunoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_aluno);

        AlunoDAO dao = new AlunoDAO(this);
        List<Aluno> alunos = dao.buscaAlunos();
        dao.close();

        ListView listaAlunos = (ListView) findViewById(R.id.lista_alunos);
        ArrayAdapter<Aluno> adapter = new ArrayAdapter<Aluno>(this, android.R.layout.simple_list_item_1, alunos);
        listaAlunos.setAdapter(adapter);

        FloatingActionButton novoAluno = findViewById(R.id.lista_alunos_btn_novo_aluno);
        novoAluno.setOnClickListener((v) -> {
                Intent btnFormulario = new Intent(ListaAlunoActivity.this, FormularioActivity.class);
                startActivity(btnFormulario);
            });
    }
}