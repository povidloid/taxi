package com.example.taxi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.taxi.databinding.ActivityInfoBinding;

public class ActivityInfo extends AppCompatActivity {
    private ActivityInfoBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityInfoBinding.inflate(getLayoutInflater());
        View v = binding.getRoot();
        setContentView(v);

        String fullName = getIntent().getStringExtra("fName") + " " + getIntent().getStringExtra("sName");
        binding.textViewFirstName.setText(fullName);
        binding.textViewNumber.setText(getIntent().getStringExtra("pNum"));
        binding.textViewPath.setText("");
    }
    public void onClick_callTaxi(View v){
        Toast.makeText(this, "Set the path", Toast.LENGTH_SHORT).show();
    }
    public void onClick_setPath(View v){

    }
}