package br.com.hdo.jogo_da_velha;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {

    private String letter = "X";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        TextView txt = findViewById(R.id.txtPlayer);
        txt.setText("Jogador " + letter);
    }

    private void clear(){
        Button txt1 = findViewById(R.id.btn1);
        Button txt2 = findViewById(R.id.btn2);
        Button txt3 = findViewById(R.id.btn3);
        Button txt4 = findViewById(R.id.btn4);
        Button txt5 = findViewById(R.id.btn5);
        Button txt6 = findViewById(R.id.btn6);
        Button txt7 = findViewById(R.id.btn7);
        Button txt8 = findViewById(R.id.btn8);
        Button txt9 = findViewById(R.id.btn9);

        txt1.setText("");
        txt2.setText("");
        txt3.setText("");
        txt4.setText("");
        txt5.setText("");
        txt6.setText("");
        txt7.setText("");
        txt8.setText("");
        txt9.setText("");
    }

    private void isFinish(){
        Button txt1 = findViewById(R.id.btn1);
        Button txt2 = findViewById(R.id.btn2);
        Button txt3 = findViewById(R.id.btn3);
        Button txt4 = findViewById(R.id.btn4);
        Button txt5 = findViewById(R.id.btn5);
        Button txt6 = findViewById(R.id.btn6);
        Button txt7 = findViewById(R.id.btn7);
        Button txt8 = findViewById(R.id.btn8);
        Button txt9 = findViewById(R.id.btn9);

        // VERIFICA SE ALGUÉM VENCEU
        if(txt1.getText().toString().equals(txt2.getText().toString()) && txt1.getText().toString().equals(txt3.getText().toString()) && !txt1.getText().toString().isEmpty() && !txt2.getText().toString().isEmpty() && !txt3.getText().toString().isEmpty()
            || txt4.getText().toString().equals(txt5.getText().toString()) && txt4.getText().toString().equals(txt6.getText().toString()) && !txt4.getText().toString().isEmpty() && !txt5.getText().toString().isEmpty() && !txt6.getText().toString().isEmpty()
            || txt7.getText().toString().equals(txt8.getText().toString()) && txt7.getText().toString().equals(txt9.getText().toString()) && !txt7.getText().toString().isEmpty() && !txt8.getText().toString().isEmpty() && !txt9.getText().toString().isEmpty()
            || txt1.getText().toString().equals(txt4.getText().toString()) && txt1.getText().toString().equals(txt7.getText().toString()) && !txt1.getText().toString().isEmpty() && !txt4.getText().toString().isEmpty() && !txt7.getText().toString().isEmpty()
            || txt2.getText().toString().equals(txt5.getText().toString()) && txt2.getText().toString().equals(txt8.getText().toString()) && !txt2.getText().toString().isEmpty() && !txt5.getText().toString().isEmpty() && !txt8.getText().toString().isEmpty()
            || txt3.getText().toString().equals(txt6.getText().toString()) && txt3.getText().toString().equals(txt9.getText().toString()) && !txt3.getText().toString().isEmpty() && !txt6.getText().toString().isEmpty() && !txt9.getText().toString().isEmpty()
            || txt1.getText().toString().equals(txt5.getText().toString()) && txt1.getText().toString().equals(txt9.getText().toString()) && !txt1.getText().toString().isEmpty() && !txt5.getText().toString().isEmpty() && !txt9.getText().toString().isEmpty()
            || txt3.getText().toString().equals(txt5.getText().toString()) && txt3.getText().toString().equals(txt7.getText().toString()) && !txt3.getText().toString().isEmpty() && !txt5.getText().toString().isEmpty() && !txt7.getText().toString().isEmpty()){
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("O jogador " + letter + " venceu!")
                    .setTitle("")
                    .setCancelable(false)
                    .setNegativeButton("Sair", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    })
                    .setPositiveButton("Nova partida", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            clear();
                        }
                    });
                AlertDialog dialog = builder.create();
                dialog.show();
        }

        // VERIFICA SE DEU VELHA
        else if(!txt1.getText().toString().isEmpty() && !txt2.getText().toString().isEmpty() && !txt3.getText().toString().isEmpty()
            && !txt4.getText().toString().isEmpty() && !txt5.getText().toString().isEmpty() && !txt6.getText().toString().isEmpty()
            && !txt7.getText().toString().isEmpty() && !txt8.getText().toString().isEmpty() && !txt9.getText().toString().isEmpty()){
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Deu velha!")
                    .setTitle("")
                    .setCancelable(false)
                    .setNegativeButton("Sair", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    })
                    .setPositiveButton("Nova partida", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            clear();
                        }
                    });
                AlertDialog dialog = builder.create();
                dialog.show();
        }
    }

    public void btnClick(View view){
        Button btn = (Button) view;
        TextView txt = findViewById(R.id.txtPlayer);

        if(btn.getText().toString().isEmpty()) {
            btn.setText(letter);

            isFinish();

            if (letter.equals("X")) {
                letter = "O";
            } else {
                letter = "X";
            }

            txt.setText("Jogador " + letter);
        }
    }
}
