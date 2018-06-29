package com.codepath.todoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class EditItemActivity extends AppCompatActivity {
        EditText etEditTextItem;
        int itemIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        String editMe = getIntent().getStringExtra("editMe");
        etEditTextItem = (EditText) findViewById(R.id.etEditTextItem);
        //textView.setText(editMe);
        etEditTextItem.setText(getIntent().getExtras().getString("editMe"), TextView.BufferType.EDITABLE);
        itemIndex = getIntent().getExtras().getInt("index");

    }


    public void onSubmit (View v){
        etEditTextItem = (EditText)findViewById(R.id.etEditTextItem);
        Intent data = new Intent();
        data.putExtra("newText", etEditTextItem.getText().toString());
        data.putExtra("indexData", itemIndex);
        setResult(RESULT_OK, data);
        finish();
    }

//    public View getActivity() {
//        return activity;
//    }

//    public View getActivity() {
//        return activity;
//    }
}
