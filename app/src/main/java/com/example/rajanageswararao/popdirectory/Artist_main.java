package com.example.rajanageswararao.popdirectory;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

class customAdapter extends ArrayAdapter<popArtist>
{
    private final List<popArtist> pop_artist;
    public customAdapter(Context context, int resource,List<popArtist> pop_artist)
    {
        super(context, resource,pop_artist);
        this.pop_artist=pop_artist;
    }

    public View getView(int position,View convertView,ViewGroup parent)
    {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.custom_list_view, null);
        TextView textView = (TextView) row.findViewById(R.id.Name);
        textView.setText(pop_artist.get(position).getName());
        //try
        {
            ImageView imageView = (ImageView) row.findViewById(R.id.Image);
            //InputStream inputStream = getContext().getAssets().open("/res/drawable/rod_stewart.jpg");
            //Drawable drawable = Drawable.createFromStream(inputStream, null);
            //imageView.setImageDrawable(drawable);
            imageView.setImageResource(pop_artist.get(position).getImageFileName());
        }
        //catch (IOException e)
        {
            //  e.printStackTrace();
        }
        return row;
    }

}


class popArtist
{
    String Filename;
    Integer imageFileName;
    String name;

    public popArtist(Integer imageFileName,String name,String Filename)
    {
        this.Filename=Filename;
        this.imageFileName=imageFileName;
        this.name=name;
    }
    public String getName()
    {
        return name;
    }
    public Integer getImageFileName()
    {
        return imageFileName;
    }
    public String getFileName()
    {
        return Filename;
    }
}


public class Artist_main extends Activity {

    List<popArtist> pop_artist=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.artist_main);




        ListView listView=(ListView)findViewById(R.id.listView);

        pop_artist.add(new popArtist(R.mipmap.elvis_presly,"Elvis Presly","Without Elvis Presley, its hard to imagine how much of what came after in pop and rock music could have happened. He brought rock 'n roll into American living rooms. Elvis Presley became a larger than life cultural icon. He recorded over 100 pop top 40 hits. Elvis Presley died in 1977 at the age of 42."));
        pop_artist.add(new popArtist(R.mipmap.elton_john_levon,"Elton John Levon","Elton John is the foremost piano player in pop music history. He has released over 50 top 40 singles including a phenomenal 38 consecutive top 40 singles from 1972 through 1986. His music could be considered definitive of mainstream pop in the 1970s. In recent years Elton John has toured frequently with a fellow successful piano playing pop musician, Billy Joel."));
        pop_artist.add(new popArtist(R.mipmap.mariah_carey,"Mariah Carey","With 18 under her belt, Mariah Carey is the only currently recording artist in striking distance of reaching the Beatles' all-time record of 20 #1 pop singles in the US. Her collaboration with Boyz II Men on \"One Sweet Day\" spent 16 weeks at #1 on the Billboard Hot 100 which remains a record. Mariah Carey's vocal range and melismatic approach are trademarks that have influenced countless other female vocalists in the past two decades."));
        pop_artist.add(new popArtist(R.mipmap.stevie_wonder,"Stevie Wonder","Stevie Wonder emerged in the early 1960s as a precocious child star with one of the most infectious live hits ever recorded, \"Fingertips - Pt. 2.\" Through the rest of the decade and early 1970s he matured as an artist until he took full artistic control as singer, musician, producer and songwriter. His music ranged across styles, but usually remained rooted in highly rhythmic textures. The songs are noted for their positive outlook even when dealing with difficult social issues. After over 45 years Stevie Wonder continues to record for his original label Motown."));
        pop_artist.add(new popArtist(R.mipmap.rod_stewart,"Rod Stewart","Rod Stewart's voice is one of the most instantly recognizable instruments in pop music. His musical career has spanned over 40 years in which he has gone from heavy rock vocalist to pop and disco superstar to a champion of pop standards. Rod Stewart is also respected as a top confessional pop songwriter although his most recent recorded work has primarily been engaged in interpreting the songs of others."));
        listView.setAdapter(new customAdapter(this, R.layout.custom_list_view, pop_artist));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Artist_main.this, Artist_detail.class);
                Bundle myBundle = new Bundle();
                myBundle.putInt("position", position);

                intent.putExtras(myBundle);
                startActivity(intent);
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view,final int position, long id) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        parent.getContext());

                // set title
                alertDialogBuilder.setTitle(pop_artist.get(position).getName());

                // set dialog message
                alertDialogBuilder
                        .setMessage("Add to favorites ?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // if this button is clicked, close
                                // current activity
                                for (int i = 0; i < Artist_activity.artistFavorite.size(); i++) {
                                    if (Artist_activity.artistFavorite.get(i).containsValue(pop_artist.get(position).getName()))
                                        return;
                                }
                                Artist_activity.artistFavorite.add(Artist_activity.createPlanet("planet", pop_artist.get(position).getName()));
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // if this button is clicked, just close
                                // the dialog box and do nothing
                                dialog.cancel();
                            }
                        });

                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();
                return true;
            }
        });


        /*listView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Artist_main.this, secondActivity.class);
                //Bundle myBundle=new Bundle();
                //myBundle.putInt("position",1);
                //intent.putExtras(myBundle);
                startActivity(intent);
            }
        });*/

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
