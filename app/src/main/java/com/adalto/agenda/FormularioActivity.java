package com.adalto.agenda;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import com.adalto.agenda.model.Pessoa;

public class FormularioActivity extends AppCompatActivity {

    private EditText etNome, etTelefone;
    private RadioButton rbFeminino, rbMasculino;
    private Button btnSalvar;
    private Spinner spCidade;
    private CheckBox cbFilhos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        etNome = (EditText) findViewById(R.id.etNome);
        etTelefone = (EditText) findViewById(R.id.etTelefone);
        rbFeminino = (RadioButton) findViewById(R.id.rbFeminino);
        rbMasculino = (RadioButton) findViewById(R.id.rbMasculino);
        cbFilhos = (CheckBox) findViewById(R.id.cbFilhos);
        spCidade = (Spinner) findViewById(R.id.spCidade);
        btnSalvar = (Button) findViewById(R.id.btnSalvar);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvar();
            }
        });

    }


    private void salvar(){

        Pessoa pessoa = new Pessoa();
        String nome = etNome.getText().toString();

        if( ! nome.isEmpty() && spCidade.getSelectedItemPosition() != 0 ){
             pessoa.setNome( nome );
             pessoa.setTelefone( etTelefone.getText().toString() );
             pessoa.setCidade( spCidade.getSelectedItem().toString() );
             if( rbFeminino.isChecked() ){
                 pessoa.setSexo( "Feminino" );
             }else {
                if( rbMasculino.isChecked() ){
                    pessoa.setSexo( "Masculino" );
                }else {
                    pessoa.setSexo( "Não informado");
                }
             }
             pessoa.setTemFilhos( cbFilhos.isChecked() );

        }else {
            AlertDialog.Builder alerta = new AlertDialog.Builder(this);
            alerta.setTitle(getResources().getString(R.string.txtAtencao));
            alerta.setIcon( android.R.drawable.ic_dialog_alert );
            alerta.setMessage( "Os campos Nome e Cidade são obrigatórios!" );
            alerta.setNegativeButton("OK", null);
            alerta.show();
        }


    }




}










