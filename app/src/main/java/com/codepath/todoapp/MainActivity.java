package com.codepath.todoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String>todoItems;
    ArrayAdapter<String>aTodoAdapter;
    ListView lvItems;
    EditText etEditText;

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        populateArrayItems();
        lvItems = (ListView)findViewById(R.id.lvItems);
        lvItems.setAdapter(aTodoAdapter);
        etEditText = (EditText) findViewById(R.id.etEditText);
        lvItems.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                todoItems.remove(position);
                aTodoAdapter.notifyDataSetChanged();
                writeItems();
                return true;
            }
        });

        lvItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, EditItemActivity.class);
                editItemObject = lvItems.getItemAtPosition(position);
                editItemView(editItemObject, position);
                aTodoAdapter.notifyDataSetChanged();
                writeItems();
                //return true;
                //startActivity(intent);

            }
        });

    }
    public Object editItemObject;
    private final int REQUEST_CODE = 1;



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
            String name = data.getExtras().getString("newText");
            int position = data.getExtras().getInt("indexData");
            todoItems.set(position, name);
            aTodoAdapter.notifyDataSetChanged();
            writeItems();

        }else{
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        }
    }

    public void editItemView(Object o, int position){
        Intent intent = new Intent(MainActivity.this, EditItemActivity.class);
        String editMe = (String) o;
        intent.putExtra("editMe", editMe);
        intent.putExtra("index", position);
        startActivityForResult(intent, REQUEST_CODE);
        //startActivity(intent);
        //writeItems();
    }


    public void populateArrayItems(){
        readItems();
        aTodoAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, todoItems);
    }
    private void readItems(){
        File filesDir = getFilesDir();
        File file = new File(filesDir, "todo.txt");
        try {
            todoItems = new ArrayList<String>(FileUtils.readLines(file));
        }catch(IOException e){

        }
    }
    private void writeItems(){
        File filesDir = getFilesDir();
        File file = new File(filesDir, "todo.txt");
        try {
            FileUtils.writeLines(file, todoItems);
        }catch(IOException e){

        }
    }


    public void onAddItem(View view) {
        aTodoAdapter.add(etEditText.getText().toString());
        etEditText.setText("");
        writeItems();
    }

}
