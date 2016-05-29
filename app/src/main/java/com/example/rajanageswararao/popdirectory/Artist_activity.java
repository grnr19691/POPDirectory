package com.example.rajanageswararao.popdirectory;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Artist_activity extends Activity {
    static List<Map<String, String>> artistFavorite = new ArrayList<Map<String,String>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist_activity);
        setTitle("Favorite Artists");
        ListView lv = (ListView) findViewById(R.id.listView);
        SimpleAdapter simpleAdpt = new SimpleAdapter(this, artistFavorite, android.R.layout.simple_list_item_1, new String[] {"planet"}, new int[] {android.R.id.text1});
        lv.setAdapter(simpleAdpt);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_second, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.information) {
            startActivity(new Intent(this,concert_information.class));
            return true;
        }
        else if (id == R.id.favorites) {
            startActivity(new Intent(this,Artist_activity.class));
            return true;
        }
        else if (id == R.id.uninstall) {
            Intent delIntent=new Intent(Intent.ACTION_DELETE);
            delIntent.setData(Uri.parse("package:com.example.rajanageswararao.popdirectory"));
            startActivity(delIntent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    static HashMap<String, String> createPlanet(String key, String name)
    {
        HashMap<String, String> planet = new HashMap<String, String>();
        planet.put(key, name);
        return planet;
    }
}
