package com.assignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final String TAG = MainActivity.class.toString();
    private ListView mListView;
    //creating arrays for name and numbers
    public static String[] name = {"Prabhu", "Sadashiva", "Pramod", "Madana",
            "Usha", "Bhavana", "Siddalinga", "Latha"};
    public static String[] number = {"8923233445", "8392496748", "9692935783", "9153658749",
            "8214355667", "9734524667", "7421647386", "8192837465"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // initialise layout
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: ");
        mListView = findViewById(R.id.listView); // init list view

        MyListAdapter adapter = new MyListAdapter(this, name, number);
        mListView.setAdapter(adapter);  // set adapter
        registerForContextMenu(mListView);   // register for context menu
    }

    // This method will create context menu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Select the Action");
        getMenuInflater().inflate(R.menu.my_context_menu, menu); // add costume menu
    }

    // This method will call when context menu item selected
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        try {
            // condition for edit
            if (item.getItemId() == R.id.edit) {
                Toast.makeText(this, "Edit " + name[info.position], Toast.LENGTH_SHORT).show(); // show toast when context item selected
            }
            // condition for call
            else if (item.getItemId() == R.id.call) {
                Toast.makeText(this, "Call to " + name[info.position], Toast.LENGTH_SHORT).show(); // show toast when context item selected
            }
            // condition for sms
            else if (item.getItemId() == R.id.sms) {
                Toast.makeText(this, "SMS to " + name[info.position], Toast.LENGTH_SHORT).show(); // show toast when context item selected
            }
            return true;
        } catch (Exception e) {//if false catch exception
            return true;
        }

    }
}
