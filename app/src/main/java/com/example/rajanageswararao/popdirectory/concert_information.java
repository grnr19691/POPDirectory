package com.example.rajanageswararao.popdirectory;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class concert_information extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_concert_information);
        setTitle("Concert Information");
        final TextView textView=(TextView)findViewById(R.id.textView4);
        String number=(String)textView.getText();
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:555-1234")));
            }
        });
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


}
