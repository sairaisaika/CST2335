package com.example.myapplication1;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ChatRoomActivity extends AppCompatActivity{
    private Button sendButton;
    private EditText TypeBar;
    protected SharedPreferences prefs;
    protected String previous;
    private Button receiveButton;
    ArrayList<Message> messages = new ArrayList<>( );
    BaseAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_room_activity);

        ListView theList = findViewById(R.id.listview);
        theList.setAdapter( myAdapter = new MyListAdapter() );
        theList.setOnItemClickListener( ( parent,  view,  position,  id) ->{
            Log.i("CLicked", "You clicked item:" + position);

        });

        TypeBar = (EditText)findViewById(R.id.TextView);
        prefs = getSharedPreferences("FileName", MODE_PRIVATE);
        previous = prefs.getString("ReserveName", "Default Value");

        sendButton = (Button)findViewById(R.id.sendButton);
        if(sendButton != null){
            sendButton.setOnClickListener(n ->{
                String typed = TypeBar.getText().toString();
                messages.add(new Message(typed, true));
                myAdapter.notifyDataSetChanged();
                TypeBar.setText("");

            });

        }

        receiveButton = (Button)findViewById(R.id.recieveButton);
        if (receiveButton != null){
            receiveButton.setOnClickListener(n ->{
                String typed = TypeBar.getText().toString();
                messages.add(new Message(typed, false));
                myAdapter.notifyDataSetChanged();
                TypeBar.setText("");
            });
        }




    }



    //Need to add 4 functions here:
    private class MyListAdapter extends BaseAdapter {

        public int getCount() {  return messages.size();  } //This function tells how many objects to show

        public Message getItem(int position) {
            return  messages.get(position);
        }  //This returns the string at position p

        public long getItemId(int p) { return p; } //This returns the database id of the item at position p

        public View getView(int p, View recycled, ViewGroup parent)
        {

            LayoutInflater inflater = getLayoutInflater();
            View thisRow = recycled;

            if(messages.get(p).getIsTrue()){
                thisRow = inflater.inflate(R.layout.row1_layout, null);

            }else{
                thisRow = inflater.inflate(R.layout.row_layout, null);

        }

            TextView insertText = thisRow.findViewById(R.id.insertText);
            insertText.setText(messages.get(p).getType());


            return thisRow;
        }
    }

}
