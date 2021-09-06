package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ContactActivity extends AppCompatActivity {

private ListView lvContact;
private List<ContactModel> listContacts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        initData();
        lvContact = (ListView) findViewById(R.id.lvContact);
        ContactAdapter adapter = new ContactAdapter(listContacts,this);
        lvContact.setAdapter(adapter);

        lvContact.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ContactModel contactModel = listContacts.get(position);
                Toast.makeText(ContactActivity.this, contactModel.getName(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void initData(){
        listContacts.add(new ContactModel("Nguyen Van A", "0123456789", R.drawable.ic_avatar1));
        listContacts.add(new ContactModel("Nguyen Van B", "12312414122", R.drawable.ic_avatar2));
        listContacts.add(new ContactModel("Nguyen Van C", "12312421314", R.drawable.ic_avatar3));
        listContacts.add(new ContactModel("Nguyen Van D", "12312425234", R.drawable.ic_avatar4));
    }
}