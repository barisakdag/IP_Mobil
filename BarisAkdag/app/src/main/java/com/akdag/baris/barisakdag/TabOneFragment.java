package com.akdag.baris.barisakdag;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

/**
 * Created by ezs338 on 2016-12-14.
 */

public class TabOneFragment extends android.support.v4.app.Fragment {

    //SharedPreferences sharedPrefs;
    //public static final String highestPrime = "primeKey";
   // public static final long primeNumber = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Change fragment
        View rootView = inflater.inflate(R.layout.tab_fragment_one, container, false);



        return rootView;

        // To write:
        // https://developer.android.com/training/basics/data-storage/shared-preferences.html
        //sharedPrefs = getActivity().getPreferences(Context.MODE_PRIVATE);
        //SharedPreferences.Editor editor = sharedPrefs.edit();
        //editor.putInt()
        //editor.commit();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        // Random BigInteger

        //    Button checkButton;


        //BigInteger prime = new BigInteger(digits, 0, new Random());
        EditText randomNumber = (EditText) getActivity().findViewById(R.id.RandomizedNumber);

        //System.out.println(prime);


    }


    // Randomize long and run through boolean, if true add to sharedprefs if not continue.
    private boolean isPrime(long candidate) {
        long sqrt = (long)Math.sqrt(candidate);
        for(long i = 3; i <= sqrt; i += 2)
            if(candidate % i == 0) return false;
        return true;
    }

}
