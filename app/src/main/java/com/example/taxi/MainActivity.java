package com.example.taxi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.taxi.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    SharedPreferences sPref;
    private void saveText(){
        sPref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sPref.edit();
        editor.putString("PNum", binding.editTextPhone.getText().toString());
        editor.putString("FNum", binding.editTextTextFName.getText().toString());
        editor.putString("SNum", binding.editTextTextSName.getText().toString());
        editor.putBoolean("Log_in", true);
        editor.commit();
    }
    private void loadText(){
        sPref = getPreferences(MODE_PRIVATE);
        binding.editTextPhone.setText(sPref.getString("PNum", ""));
        binding.editTextTextFName.setText(sPref.getString("FNum", ""));
        binding.editTextTextSName.setText(sPref.getString("SNum", ""));

        if (sPref.getBoolean("Log_in", false)){
            binding.button.setText("Log in");
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View v = binding.getRoot();
        setContentView(v);

        loadText();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        saveText();
    }

    public void onClick(View v){
        String pNum = binding.editTextPhone.getText().toString();
        String fName = binding.editTextTextFName.getText().toString();
        String sName = binding.editTextTextSName.getText().toString();

        if ((pNum.isEmpty()) | (fName.isEmpty()) | (sName.isEmpty())){
            Toast.makeText(this, "Fill out the fields", Toast.LENGTH_SHORT).show();
        }
        else{
            Intent intent = new Intent(this, ActivityInfo.class);
            intent.putExtra("pNum", pNum);
            intent.putExtra("fName", fName);
            intent.putExtra("sName", sName);
            startActivity(intent);
            finish();
        }
    }
}