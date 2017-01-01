package com.akdag.baris.barisakdag;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.math.BigInteger;
import java.util.Random;

import static android.R.attr.digits;

/**
 * Created by ezs338 on 2016-12-14.
 */

public class TabOneFragment extends android.support.v4.app.Fragment {

    public static final String PREFS_NAME = "MyPrefsFile";
    public static final int BINARY_DIGITS = 8;
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


        // Sharedpreferences
        final SharedPreferences sharedPrefs = getActivity().getSharedPreferences(PREFS_NAME, 0);
        final SharedPreferences.Editor editor = sharedPrefs.edit();

        // Button and edittext for operations.
        Button primeButton = (Button) getActivity().findViewById(R.id.checkPrime);
        final TextView primeText = (TextView) getActivity().findViewById(R.id.highestPrimeNumber);
        primeText.setText("" + sharedPrefs.getLong(PREFS_NAME,0));

        // onclicklistener for the primebutton
        primeButton.setOnClickListener(new View.OnClickListener(){

            // Randomize number with Biginteger and check if it's even if its not run isPrime() and check with sharedprefs highest prime to update the edittext and sharedprefs.
            @Override
            public void onClick(View view) {
                BigInteger prime = new BigInteger(BINARY_DIGITS, 0, new Random());
                    if(isPrime(prime.longValue()) && prime.longValue()> sharedPrefs.getLong(PREFS_NAME,0)){
                        // update Sharedprefs which updates the edittext.
                        primeText.setText("" + prime.intValue());
                        editor.putLong(PREFS_NAME ,prime.longValue());
                        editor.commit();
                    }else{
                        Snackbar.make(view, "The number isn't a prime number", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                    }
                }

        });

    }


    // Randomize long and run through boolean, if true add to sharedprefs if not continue.
    private boolean isPrime(long candidate) {
        long sqrt = (long)Math.sqrt(candidate);
        for(long i = 3; i <= sqrt; i += 2){
            if(candidate % i == 0)
                return false;
        }
        return true;
    }

}
