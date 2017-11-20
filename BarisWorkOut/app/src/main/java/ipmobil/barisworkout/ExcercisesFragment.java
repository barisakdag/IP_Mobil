package ipmobil.barisworkout;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.zip.Inflater;

import static ipmobil.barisworkout.R.id.listview;

/**
 * Created by Barre on 2017-11-19.
 */

public class ExcercisesFragment extends android.support.v4.app.Fragment implements AdapterView.OnItemClickListener {
    //ListView
    ListView lst;
    String benchPress = "Bench Press";
    String shoulderPress = "Shoulder Press";
    String barbellDeadLift = "Barbell DeadLift";

    String[] workouts = {benchPress,shoulderPress,barbellDeadLift};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.excercises,container,false);

        lst= (ListView) v.findViewById(listview);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, workouts);

        //Set listview to use the arrayadapter and a onclicklistener for the arrayadapter.
        lst.setAdapter(arrayAdapter);
        lst.setOnItemClickListener(this);

        return v;
    }


    //AdapterOnClickListener
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView tv = (TextView)view;
       // Toast.makeText(getActivity(), "You clicked on" + tv.getText() , Toast.LENGTH_SHORT).show();

        //When the first position on the list is clicked, it will open up a new view with information regarding the excercise.
        if(position==0) {
            Toast.makeText(getActivity(), "You clicked on" + tv.getText() , Toast.LENGTH_SHORT).show();
            LayoutInflater inflater = (LayoutInflater)   getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.excercises_tip, null);
            ViewGroup rootView = (ViewGroup) getView();
            rootView.removeAllViews();
            rootView.addView(view);

            //SetImageView with external lib picasso.
            ImageView imgv = (ImageView) view.findViewById(R.id.excercisepic);
            Picasso.with(getActivity().getApplicationContext())
                    .load("https://cdn.stronglifts.com/wp-content/uploads/bench-press.jpg")
                    .into(imgv);

            //Settextview
            TextView txtv = (TextView) rootView.findViewById(R.id.excercisetext);
            txtv.setText("1. Setup. Lie on the flat bench with your eyes under the bar. Lift your chest and squeeze your shoulder-blades. Feet flat on the floor.\n" +
                    "2.Grab the bar. Put your pinky on the ring marks of your bar. Hold the bar in the base of your palm with a full grip and straight wrists.\n" +
                    "3. Unrack. Take a big breath and unrack the bar by straightening your arms. Move the bar over your shoulders with your elbows locked.\n" +
                    "4. Lower the bar. Lower it to your mid-chest while tucking your elbows 75°. Keep your forearms vertical. Hold your breath at the bottom.\n" +
                    "5. Press. Press the bar from your mid-chest to above your shoulders. Keep your butt on the bench. Lock your elbows at the top. Breathe.");

        }

        if(position==1) {
            Toast.makeText(getActivity(), "You clicked on" + tv.getText() , Toast.LENGTH_SHORT).show();
            LayoutInflater inflater = (LayoutInflater)   getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.excercises_tip, null);
            ViewGroup rootView = (ViewGroup) getView();
            rootView.removeAllViews();
            rootView.addView(view);

            //SetImageView with external lib picasso.
            ImageView imgv = (ImageView) view.findViewById(R.id.excercisepic);
            Picasso.with(getActivity().getApplicationContext())
                    .load("https://cdn.stronglifts.com/wp-content/uploads/stronglifts-overhead-press.jpg")
                    .into(imgv);


            //Settextview
            TextView txtv = (TextView) rootView.findViewById(R.id.excercisetext);
            txtv.setText("1. Setup. Stand with the bar on your front shoulders. Narrow grip, straight wrists, vertical forearms. Lock your knees and hips.\n" +
                    "2. Lift Your Chest. Raise your chest towards the ceiling by arching your upper-back. Try to touch your chin with your upper-chest.\n" +
                    "3. Press. Take a big breath, hold it and press the bar in a vertical line. Don’t press it in front or behind your head. Press it over your head.\n" +
                    "4. Move Forward. Stay close to the bar while you press the weight up. Shift your torso forward once the bar has passed your forehead.\n" +
                    "5. Lockout. Hold the bar over your shoulders and mid-foot for proper balance. Lock your elbows. Shrug your shoulders to the ceiling.");

        }

        if(position==2) {
            Toast.makeText(getActivity(), "You clicked on" + tv.getText() , Toast.LENGTH_SHORT).show();
            LayoutInflater inflater = (LayoutInflater)   getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.excercises_tip, null);
            ViewGroup rootView = (ViewGroup) getView();
            rootView.removeAllViews();
            rootView.addView(view);

            //SetImageView with external lib picasso.
            ImageView imgv = (ImageView) view.findViewById(R.id.excercisepic);
            Picasso.with(getActivity().getApplicationContext())
                    .load("https://cdn.stronglifts.com/wp-content/uploads/deadlift.jpg")
                    .into(imgv);


            //Settextview
            TextView txtv = (TextView) view.findViewById(R.id.excercisetext);
            txtv.setText("1. Walk to the bar. Stand with your mid-foot under the bar. Your shins shouldn’t touch it yet.\n Put your heels hip-width apart, narrower than on Squats.\n Point your toes out 15°.\n" +
                    "2. Grab the bar. Bend over without bending your legs. Grip the bar narrow, about shoulder-width apart like on the Overhead Press. Your arms must be vertical when looking from the front.\n" +
                    "3. Bend your knees. Drop into position by bending your knees until your shins touch the bar. Do NOT let the bar move away from your mid-foot. If it moves, start from scratch with step one.\n" +
                    "4. Lift your chest. Straighten your back by raising you chest. Do not change your position – keep the bar over your mid-foot, your shins against the bar, and your hips where they are.\n" +
                    "5. Pull. Take a big breath, hold it and stand up with the weight. Keep the bar in contact with your legs while you pull. Don’t shrug or lean back at the top. Lock your hips and knees");

        }

    }

}
