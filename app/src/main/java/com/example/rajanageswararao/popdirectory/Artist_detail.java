package com.example.rajanageswararao.popdirectory;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RajaNageswaraRao on 4/23/2015.
 */
class popDetail
{
    String description;
    Integer bigImage;
    String name;

    public popDetail(Integer bigImage,String description,String name)
    {
        this.name=name;
        this.description=description;
        this.bigImage=bigImage;
    }
    public String getDescription()
    {
        return description;
    }
    public Integer getBigImage()
    {
        return bigImage;
    }
    public String getName()
    {
        return name;
    }
}

public class Artist_detail extends Activity
{
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.artist_detail);


        List<popDetail> pop_artist=new ArrayList<>();
        pop_artist.add(new popDetail(R.drawable.elvis_presly,"Without Elvis Presley, its hard to imagine how much of what came after in pop and rock music could have happened. He brought rock 'n roll into American living rooms. Elvis Presley became a larger than life cultural icon. He recorded over 100 pop top 40 hits. Elvis Presley died in 1977 at the age of 42. ","Elvis Presly"));
        pop_artist.add(new popDetail(R.drawable.elton_john_levon,"Elton John is the foremost piano player in pop music history. He has released over 50 top 40 singles including a phenomenal 38 consecutive top 40 singles from 1972 through 1986. His music could be considered definitive of mainstream pop in the 1970s. In recent years Elton John has toured frequently with a fellow successful piano playing pop musician, Billy Joel.","Elton John Levon"));
        pop_artist.add(new popDetail(R.drawable.mariah_carey,"With 18 under her belt, Mariah Carey is the only currently recording artist in striking distance of reaching the Beatles' all-time record of 20 #1 pop singles in the US. Her collaboration with Boyz II Men on \"One Sweet Day\" spent 16 weeks at #1 on the Billboard Hot 100 which remains a record. Mariah Carey's vocal range and melismatic approach are trademarks that have influenced countless other female vocalists in the past two decades.","Mariah Carey"));
        pop_artist.add(new popDetail(R.drawable.stevie_wonder,"Stevie Wonder emerged in the early 1960s as a precocious child star with one of the most infectious live hits ever recorded, \"Fingertips - Pt. 2.\" Through the rest of the decade and early 1970s he matured as an artist until he took full artistic control as singer, musician, producer and songwriter. His music ranged across styles, but usually remained rooted in highly rhythmic textures. The songs are noted for their positive outlook even when dealing with difficult social issues. After over 45 years Stevie Wonder continues to record for his original label Motown.","Stevie Wonder"));
        pop_artist.add(new popDetail(R.drawable.rod_stewart,"Rod Stewart's voice is one of the most instantly recognizable instruments in pop music. His musical career has spanned over 40 years in which he has gone from heavy rock vocalist to pop and disco superstar to a champion of pop standards. Rod Stewart is also respected as a top confessional pop songwriter although his most recent recorded work has primarily been engaged in interpreting the songs of others.","Rod Stewart"));

        TextView description = (TextView)findViewById(R.id.description);
        ImageView imageView = (ImageView)findViewById(R.id.bigImage);
        TextView name = (TextView)findViewById(R.id.name);

        Intent myIntent=getIntent();
        Bundle myBundle = myIntent.getExtras();
        int position=myBundle.getInt("position");

        setTitle(pop_artist.get(position).getName());

        description.setText(pop_artist.get(position).getDescription());
        name.setText(pop_artist.get(position).getName());
        imageView.setImageResource(pop_artist.get(position).getBigImage());


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
