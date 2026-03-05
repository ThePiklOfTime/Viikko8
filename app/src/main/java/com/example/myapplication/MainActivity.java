package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText textInput;
    private TextView textOutput;
    // https://stackoverflow.com/questions/7552660/convert-float-to-string-and-string-to-float-in-java
    //Katsoin tuolta miten castata floatista stringiin
    //https://mkyong.com/java/how-to-round-double-float-value-to-2-decimal-points-in-java/
    //Katsoin tuolta miten String.format toimii
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            System.out.println("HEllo world");
            textInput = findViewById(R.id.EuroInput);
            textOutput = findViewById(R.id.ResultText);
            return insets;
        });
    }
    public void convertToUsd(View view) {
        float euroInput = Float.parseFloat(textInput.getText().toString());
        float usdOutput = euroInput * 1.05f;
        String output = String.format("$%.2f", usdOutput);
        textOutput.setText(output);
    }
    public void convertToGbd(View view) {
        float euroInput = Float.parseFloat(textInput.getText().toString());
        float usdOutput = euroInput * 0.83f;
        String output = String.format("£%.2f", usdOutput);
        textOutput.setText(output);

    }
}