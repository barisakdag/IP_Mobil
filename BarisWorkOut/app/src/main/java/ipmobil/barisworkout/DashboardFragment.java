package ipmobil.barisworkout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import static ipmobil.barisworkout.R.id.listview;

/**
 * Created by Barre on 2017-11-19.
 */

public class DashboardFragment extends android.support.v4.app.Fragment implements View.OnClickListener{


    TextView textv1,textv2;
    EditText etext1,etext2;
    Button btn;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.dashboard,container,false);

        textv1 = (TextView) v.findViewById(R.id.weighttext);
        textv2 = (TextView) v.findViewById(R.id.lengthtext);

        etext1 = (EditText) v.findViewById(R.id.setweight);
        etext2 = (EditText) v.findViewById(R.id.setheight);

        btn = (Button) v.findViewById(R.id.changebutton);
        btn.setOnClickListener(this);

        ImageView imgv = (ImageView) v.findViewById(R.id.profilepic);
        Picasso.with(getActivity().getApplicationContext())
                .load("https://media.licdn.com/mpr/mpr/shrinknp_200_200/AAEAAQAAAAAAAAenAAAAJDdiNWI2Yjc2LTJjZjctNGU1NC1iM2NjLTQ3MjY4ZTljMmJhMg.jpg")
                .into(imgv);


        return v;
    }

    @Override
    public void onClick(View v) {

        textv1.setText(etext1.getText().toString()+" Kg");
        textv2.setText(etext2.getText().toString()+" Cm");

    }
}
