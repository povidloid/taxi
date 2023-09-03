package com.example.taxi;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.taxi.databinding.ActivityInfoBinding;

public class ActivityInfo extends AppCompatActivity {
    private ActivityInfoBinding binding;
    String fAddress = "", sAddress = "";
    ActivityResultLauncher<Intent> startSetPath = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if(result.getResultCode() == Activity.RESULT_OK){
                Intent intent = result.getData();
                fAddress = intent.getStringExtra("street1") + ", " + intent.getStringExtra("house1") + ", " + intent.getStringExtra("flat1");
                sAddress = intent.getStringExtra("street2") + ", " + intent.getStringExtra("house2") + ", " + intent.getStringExtra("flat2");
                String message = "Taxi will arrive at " + fAddress + " in 5 minutes and take you in " + sAddress + ". If you are agree click \"Call taxi\". ";
                binding.textViewPath.setText(message);

                binding.buttonCallTaxi.setEnabled(true);
            }
        }
    });
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

        binding.buttonCallTaxi.setEnabled(false);
    }
    public void onClick_callTaxi(View v){
        Toast.makeText(this, "The taxi was dispatched. Please wait.", Toast.LENGTH_SHORT).show();
    }
    public void onClick_setPath(View v){
        Intent intent = new Intent(this, ActivitySetPath.class);
        startSetPath.launch(intent);
    }
}