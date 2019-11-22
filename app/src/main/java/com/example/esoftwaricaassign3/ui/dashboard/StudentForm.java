package com.example.esoftwaricaassign3.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.esoftwaricaassign3.R;
import com.example.esoftwaricaassign3.models.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentForm extends Fragment {
    EditText editName, editAddress, editAge;
    RadioGroup checkGender;
    RadioButton male,female, other;
    Button submit;

    public static List<Student> userDetails = new ArrayList<>();
    String inputName,inputAddress, inputAge,inputGender;

    private DashboardViewModel dashboardViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
       final View root = inflater.inflate(R.layout.student_add, container, false);

        editName = root.findViewById(R.id.editName);
        editAddress = root.findViewById(R.id.editAddress);
        editAge = root.findViewById(R.id.editAge);
        checkGender = root.findViewById(R.id.checkGender);
        male = root.findViewById(R.id.male);
        female = root.findViewById(R.id.female);
        other = root.findViewById(R.id.other);
        submit = root.findViewById(R.id.submit);

        checkGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.male){
                    inputGender = "male";
                    Toast.makeText(getContext(), "male", Toast.LENGTH_SHORT).show();
                }if (checkedId == R.id.female){
                    inputGender = "female";
                    Toast.makeText(getContext(), "female", Toast.LENGTH_SHORT).show();
                }if (checkedId == R.id.other){
                    Toast.makeText(getContext(), "other", Toast.LENGTH_SHORT).show();
                }
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputName = editName.getText().toString();
                inputAddress = editAddress.getText().toString();
                inputAge = editAge.getText().toString();
                userDetails.add(new Student(inputName,inputAge,inputAddress,inputGender));
                Toast.makeText(root.getContext(), "Successfully added", Toast.LENGTH_LONG).show();
            }
        });
        return root;
    }
}