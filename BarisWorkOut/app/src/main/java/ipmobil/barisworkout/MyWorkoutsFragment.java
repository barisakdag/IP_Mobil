package ipmobil.barisworkout;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Barre on 2017-11-19.
 */

public class MyWorkoutsFragment extends android.support.v4.app.Fragment implements AdapterView.OnItemClickListener  {


    Button button;
    ListView lst;

    String workoutStr ="";
    int weight=0;
    int reps= 0;

    List<WorkOut> workouts = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.my_workouts,container,false);

        button = (Button) v.findViewById(R.id.addbutton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                View view = (LayoutInflater.from(getContext()).inflate(R.layout.prompts,null));
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setView(view);

                final EditText userInput= (EditText) view.findViewById(R.id.editText);
                final EditText userInput2= (EditText) view.findViewById(R.id.editText2);
                final EditText userInput3= (EditText) view.findViewById(R.id.editText3);


                    builder.setCancelable(true).setPositiveButton("Ok", new DialogInterface.OnClickListener(){
                        String regexStr = "^[0-9]*$";

                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            if(userInput2.getText().toString().trim().matches(regexStr) && userInput3.getText().toString().trim().matches(regexStr))
                            {
                                workoutStr =userInput.getText().toString();
                                weight = Integer.parseInt(userInput2.getText().toString());
                                reps = Integer.parseInt(userInput3.getText().toString());

                                workouts.add(new WorkOut(workoutStr,weight,reps));
                                //write code here for success
                            }
                            else{
                                Toast.makeText(getActivity(), "You need to enter digits on the second and third field", Toast.LENGTH_SHORT).show();
                                // write code for failure
                            }
                        }
                    });

                    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });

                    Dialog dialog = builder.create();
                    dialog.show();


            }
        });

        lst = (ListView) v.findViewById(R.id.my_workouts_list);
        ArrayAdapter<WorkOut> arrayAdapter = new ArrayAdapter<WorkOut>(getActivity(), android.R.layout.simple_list_item_1, workouts);

        //Set listview to use the arrayadapter and a onclicklistener for the arrayadapter.
        lst.setAdapter(arrayAdapter);
        lst.setOnItemClickListener(this);
        return v;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView tv = (TextView)view;
        Toast.makeText(getActivity(), "You clicked on" + tv.getText() , Toast.LENGTH_SHORT).show();
    }


}
