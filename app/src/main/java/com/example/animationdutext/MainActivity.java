package com.example.animationdutext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button mButton;
    private int tailleMin=6,tailleMax=26,n=10;
    private int longueur;
    private float pas,taille,deplacement;
    private static final String KEY_B ="b_key";
    private static final String KEY_LONGUEUR ="bss_key";
    private static final String KEY_DEPLACEMENT ="bdd_key";
    private static final String KEY_TAILLE ="bee_key";
    private static final String KEY_PAS ="baa_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton = findViewById(R.id.button);
        pas= (tailleMax-tailleMin)/n;
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                longueur = tailleMax-tailleMin;
                deplacement = deplacement + pas;
                taille = tailleMin + deplacement;
                if((deplacement >= longueur) || deplacement <= 0)
                    pas = -pas;
                mButton.setTextSize(TypedValue.COMPLEX_UNIT_PT, taille);
            }
        });
        if (savedInstanceState != null) {
            String savedB = savedInstanceState.getString(KEY_B);
            mButton.setText(savedB);
            int savedL = savedInstanceState.getInt(KEY_LONGUEUR);
            longueur = savedL;
            float savedD = savedInstanceState.getFloat(KEY_DEPLACEMENT);
            deplacement = savedD;
            float savedT = savedInstanceState.getFloat(KEY_TAILLE);
            taille = savedT;
            float savedP = savedInstanceState.getFloat(KEY_PAS);
            pas = savedP;

        }else{
            Toast.makeText(this, "Nouvelle Page", Toast.LENGTH_SHORT).show();
        }

    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

        savedInstanceState.putString(KEY_B, mButton.getText().toString());
        savedInstanceState.putInt(KEY_LONGUEUR,longueur);
        savedInstanceState.putFloat(KEY_DEPLACEMENT,deplacement);
        savedInstanceState.putFloat(KEY_TAILLE,taille);
        savedInstanceState.putFloat(KEY_PAS,pas);


        super.onSaveInstanceState(savedInstanceState);
    }
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mButton.setText(savedInstanceState.getString(KEY_B));
        longueur = savedInstanceState.getInt(KEY_LONGUEUR);
        deplacement = savedInstanceState.getFloat(KEY_DEPLACEMENT);
        taille = savedInstanceState.getFloat(KEY_TAILLE);
        pas = savedInstanceState.getFloat(KEY_PAS);
        mButton.setTextSize(TypedValue.COMPLEX_UNIT_PT,taille);
    }

}