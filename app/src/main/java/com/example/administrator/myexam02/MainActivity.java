package com.example.administrator.myexam02;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.TreeSet;

public class MainActivity extends AppCompatActivity {
    private View dialog;
    private TextView result;
    private String[] lotterys;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dialog = findViewById(R.id.dialog);
        result = (TextView)findViewById(R.id.result);

        dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showLottery();
            }
        });
    }

    private void showLottery(){
        lotterys = new String[10];
        for (int i=0; i<lotterys.length; i++){
            lotterys[i] = createALottery();
        }

        AlertDialog alert = null;
        AlertDialog.Builder builder =
                new AlertDialog.Builder(this);
        builder.setItems(lotterys, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                result.setText(lotterys[i]);
            }
        });
        alert = builder.create();
        alert.show();

    }

    private String createALottery(){
        TreeSet<Integer> set = new TreeSet<>();
        while (set.size()<6){
            set.add((int)(Math.random()*49+1));
        }
        StringBuffer sb = new StringBuffer();
        for (Integer num : set){
            sb.append(num + "  ");
        }
        return sb.toString();
    }


}
