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

import java.util.HashMap;
import java.util.Map;

public class EditPlan extends AppCompatActivity {
    private TextInputEditText name, price, description, location;
    private Button updatePlanButton, deletePlanButton;

    private ProgressBar progressBar;

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private  String planID;
    private PlanRVModal planRVModal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_plan);
        firebaseDatabase =FirebaseDatabase.getInstance();
        name = findViewById(R.id.name);
        price = findViewById(R.id.price);
        description = findViewById(R.id.description);
        location = findViewById(R.id.location);
        updatePlanButton = findViewById(R.id.updatePlan);
        deletePlanButton = findViewById(R.id.deletePlan);
        progressBar = findViewById(R.id.progressBar);
        planRVModal = getIntent().getParcelableExtra("plan");

        if(planRVModal != null){
            name.setText(planRVModal.getPlanName());
            price.setText(planRVModal.getPlanPrice());
            description.setText(planRVModal.getPlanDesc());
            location.setText(planRVModal.getPlanLocation());
            planID =planRVModal.getPlanID();
        }

        databaseReference = firebaseDatabase.getReference("Plans").child(planID);
        updatePlanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                String planName = name.getText().toString();
                String planPrice = price.getText().toString();
                String planDesc = description.getText().toString();
                String planLocation = location.getText().toString();

                Map<String,Object> map = new HashMap<>();
                map.put("planName",planName);
                map.put("planPrice",planPrice);
                map.put("planDesc",planDesc);
                map.put("planLocation",planLocation);
                map.put("planID",planID);


                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        progressBar.setVisibility(View.GONE);
                        databaseReference.updateChildren(map);
                        Toast.makeText(EditPlan.this, "Plan Updated", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(EditPlan.this, MainActivity.class));
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                        Toast.makeText(EditPlan.this, "Fail to update course..", Toast.LENGTH_SHORT).show();


                    }
                });
            }
        });
        deletePlanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deletePlan();
            }
        });
    }
private void deletePlan(){
        databaseReference.removeValue();
    Toast.makeText(this, "Plan Deleted...", Toast.LENGTH_SHORT).show();
    startActivity(new Intent(EditPlan.this, MainActivity.class));
}
}