package com.example.kopapirollo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button buttonKo, buttonPapir, buttonOllo;
    private TextView textViewValasztasEmber, textViewValasztasGep, textViewEredmeny, textViewEredmenyEmber, textViewEredmenyGep;
    private ImageView imageViewEmber, imageViewGep;
    private Random random;
    private AlertDialog.Builder alertDialog;
    private int sorsoltSzam, valasztottSzam, gyozelemSzamEmber, gyozelemSzamGep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        buttonKo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageViewEmber.setImageResource(R.drawable.rock);
                valasztottSzam = 0;
                sorsoltSzam = random.nextInt(3);
                if (sorsoltSzam == 0){
                    Toast.makeText(MainActivity.this, "DÖNTETLEN", Toast.LENGTH_SHORT).show();
                    imageViewGep.setImageResource(R.drawable.rock);
                    ellenorzes();
                }
                else if (sorsoltSzam == 1){
                    Toast.makeText(MainActivity.this, "VERESÉG", Toast.LENGTH_SHORT).show();
                    imageViewGep.setImageResource(R.drawable.paper);
                    gyozelemSzamGep++;
                    textViewEredmenyGep.setText("Computer: " + String.valueOf(gyozelemSzamGep));
                    ellenorzes();
                } else{
                    Toast.makeText(MainActivity.this, "GYŐZELEM", Toast.LENGTH_SHORT).show();
                    imageViewGep.setImageResource(R.drawable.scissors);
                    gyozelemSzamEmber++;
                    textViewEredmenyEmber.setText("Ember: " + String.valueOf(gyozelemSzamEmber));
                    ellenorzes();
                }
            }
        });

        buttonPapir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageViewEmber.setImageResource(R.drawable.paper);
                valasztottSzam = 1;
                sorsoltSzam = random.nextInt(3);
                if (sorsoltSzam == 1){
                    Toast.makeText(MainActivity.this, "DÖNTETLEN", Toast.LENGTH_SHORT).show();
                    imageViewGep.setImageResource(R.drawable.paper);
                    ellenorzes();
                }
                else if (sorsoltSzam == 2){
                    Toast.makeText(MainActivity.this, "VERESÉG", Toast.LENGTH_SHORT).show();
                    imageViewGep.setImageResource(R.drawable.scissors);
                    gyozelemSzamGep++;
                    textViewEredmenyGep.setText("Computer: " + String.valueOf(gyozelemSzamGep));
                    ellenorzes();
                } else{
                    Toast.makeText(MainActivity.this, "GYŐZELEM", Toast.LENGTH_SHORT).show();
                    imageViewGep.setImageResource(R.drawable.rock);
                    gyozelemSzamEmber++;
                    textViewEredmenyEmber.setText("Ember: " + String.valueOf(gyozelemSzamEmber));
                    ellenorzes();
                }
            }
        });

        buttonOllo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageViewEmber.setImageResource(R.drawable.scissors);
                valasztottSzam = 2;
                sorsoltSzam = random.nextInt(3);
                if (sorsoltSzam == 2){
                    Toast.makeText(MainActivity.this, "DÖNTETLEN", Toast.LENGTH_SHORT).show();
                    imageViewGep.setImageResource(R.drawable.scissors);
                    ellenorzes();
                }
                else if (sorsoltSzam == 0){
                    Toast.makeText(MainActivity.this, "VERESÉG", Toast.LENGTH_SHORT).show();
                    imageViewGep.setImageResource(R.drawable.rock);
                    gyozelemSzamGep++;
                    textViewEredmenyGep.setText("Computer: " + String.valueOf(gyozelemSzamGep));
                    ellenorzes();
                } else{
                    Toast.makeText(MainActivity.this, "GYŐZELEM", Toast.LENGTH_SHORT).show();
                    imageViewGep.setImageResource(R.drawable.paper);
                    gyozelemSzamEmber++;
                    textViewEredmenyEmber.setText("Ember: " + String.valueOf(gyozelemSzamEmber));
                    ellenorzes();
                }
            }
        });

    }

    public void ellenorzes(){
        if (gyozelemSzamGep == 3 || gyozelemSzamEmber == 3){
            if (gyozelemSzamGep > gyozelemSzamEmber){
                alertDialog.setTitle("Vereség");
                alertDialog.create();
                alertDialog.show();
            }else{
                alertDialog.setTitle("Győzelem");
                alertDialog.create();
                alertDialog.show();
            }
        }
    }

    public void init() {
        buttonKo = findViewById(R.id.buttonKo);
        buttonPapir = findViewById(R.id.buttonPapir);
        buttonOllo = findViewById(R.id.buttonOllo);
        textViewValasztasEmber = findViewById(R.id.textViewValasztasEmber);
        textViewValasztasGep = findViewById(R.id.textViewValasztasGep);
        textViewEredmeny = findViewById(R.id.textViewEredmeny);
        textViewEredmenyEmber = findViewById(R.id.textViewEredmenyEmber);
        textViewEredmenyGep = findViewById(R.id.textViewEredmenyGep);
        imageViewEmber = findViewById(R.id.imageViewEmber);
        imageViewGep = findViewById(R.id.imageViewGep);
        random = new Random();
        gyozelemSzamEmber = 0;
        gyozelemSzamGep = 0;
        AlertDialogCreate();
    }

    public void AlertDialogCreate() {
        alertDialog= new AlertDialog.Builder(MainActivity.this);
        alertDialog.setMessage("Szeretne új játékot játszani?");
        alertDialog.setNegativeButton("NEM", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        alertDialog.setPositiveButton("IGEN", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                resetGame();
            }
        });
        alertDialog.create();
    }

    public void resetGame() {
        gyozelemSzamEmber = 0;
        gyozelemSzamGep = 0;
        imageViewEmber.setImageResource(R.drawable.rock);
        imageViewGep.setImageResource(R.drawable.rock);
        textViewEredmenyEmber.setText("Ember: " + String.valueOf(gyozelemSzamEmber));
        textViewEredmenyGep.setText("Computer: " + String.valueOf(gyozelemSzamGep));
        AlertDialogCreate();
    }
}