package com.mobilerepair.app.contextmenu53;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    String Phone;
    ListView lv;
    String name1, name2, name3, name4, name5, name6, name7,
            phone1, phone2, phone3, phone4, phone5, phone6, phone7;

    ArrayList<Person> mArrayList;
    PersonAdapter mStudentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) findViewById(R.id.listview);


        mArrayList = new ArrayList<>();

        mArrayList.add(new Person("abc", "9778987987"));
        mArrayList.add(new Person("xyz", "9778987987"));
        mArrayList.add(new Person("mno", "9778987987"));
        mArrayList.add(new Person("pqr", "9778987987"));
        mArrayList.add(new Person("lmn", "9778987987"));
        mArrayList.add(new Person("ijk", "9778987987"));
        mArrayList.add(new Person("asd", "9778987987"));

        mStudentAdapter = new PersonAdapter(this, mArrayList);
        lv.setAdapter(mStudentAdapter);
        registerForContextMenu(lv);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                lv.showContextMenuForChild(view);
            }
        });

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.contextmenu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.call:
                Toast.makeText(getApplicationContext(), "CALL " , Toast.LENGTH_SHORT).show();

                return true;
            case R.id.sms:
                Toast.makeText(getApplicationContext(), "SMS " , Toast.LENGTH_SHORT).show();

                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }
}
