package com.example.holidaytrip;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AddPlan extends AppCompatActivity {

    private TextInputEditText name, price, description, location;
    private Button addPlanButton;

    private ProgressBar progressBar;

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private  String planID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_plan);

        name = findViewById(R.id.name);
        price = findViewById(R.id.price);
        description = findViewById(R.id.description);
        location = findViewById(R.id.location);
        addPlanButton = findViewById(R.id.addPlan);
        progressBar = findViewById(R.id.progressBar);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Plans");
        progressBar.setVisibility(View.VISIBLE);
        addPlanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String planName = name.getText().toString();
                String planPrice = price.getText().toString();
                String planDesc = description.getText().toString();
                String planLocation = location.getText().toString();
                planID = planName;
                PlanRVModal planRVModal = new PlanRVModal(planName, planPrice,planDesc, planLocation, planID);
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        progressBar.setVisibility(View.GONE);
                        databaseReference.child(planID).setValue(planRVModal);
                        Toast.makeText(AddPlan.this, "Plan Added", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(AddPlan.this, MainActivity.class));
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(AddPlan.this, "Error is" +error.toString(), Toast.LENGTH_SHORT).show();
                    }
                });




            }
        });


    }
}