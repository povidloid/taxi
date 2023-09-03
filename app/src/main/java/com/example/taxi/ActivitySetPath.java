package com.example.taxi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.taxi.databinding.ActivitySetPathBinding;

public class ActivitySetPath extends AppCompatActivity {
    private ActivitySetPathBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySetPathBinding.inflate(getLayoutInflater());
        View v = binding.getRoot();
        setContentView(v);
    }
    public void onClick(View v){
        String street1 = binding.editTextStreet1.getText().toString();
        String street2 = binding.editTextStreet2.getText().toString();

        String house1 = binding.editTextHouse1.getText().toString();
        String house2 = binding.editTextHouse2.getText().toString();

        String flat1 = binding.editTextFlat1.getText().toString();
        String flat2 = binding.editTextFlat2.getText().toString();

        String args [] = {street1, street2, house1, house2, flat1, flat2};

        boolean filled_fields = true;
        for (String s :
                args) {
            if (s.isEmpty()){
                Toast.makeText(this, "Fill out the fields", Toast.LENGTH_SHORT).show();
                filled_fields = false;
                break;
            }
        }
        if (filled_fields) {
            Intent intent = new Intent();

            intent.putExtra("street1", street1);
            intent.putExtra("street2", street2);

            intent.putExtra("house1", house1);
            intent.putExtra("house2", house2);

            intent.putExtra("flat1", flat1);
            intent.putExtra("flat2", flat2);

            setResult(RESULT_OK, intent);
            finish();
        }
    }
}