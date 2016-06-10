package com.example.spoorthi.todolist;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_newList = (Button) findViewById(R.id.btn_newList);

        final Context con = this;
        assert btn_newList != null;

        ListView  listView = (ListView) findViewById(R.id.listView_listName);
        final ArrayList<String> listNames = new ArrayList<>();
        final TextView mtextView = (TextView) findViewById(R.id.txt_item);


        btn_newList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  Intent intent = new Intent(this,ListViewActivity.class);
               // startActivity(intent);
                LayoutInflater dialoginflater = LayoutInflater.from(con);
                View promptsView = dialoginflater.inflate(R.layout.user_prompt,null);
                final EditText user_input = (EditText)promptsView.findViewById(R.id.user_inputName);

                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(con);
                dialogBuilder.setView(promptsView);

                dialogBuilder.setCancelable(false)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                listNames.add(user_input.getText().toString());
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.cancel();
                                    }
                                }
                        );

                AlertDialog alert = dialogBuilder.create();
                alert.show();

            }
        });

        ArrayAdapter<String> namesAdapter = new ArrayAdapter<>(this,R.layout.list_item,listNames);
//        Log.i("names",listNames.get(0));
         listView.setAdapter(namesAdapter);

    }



}





