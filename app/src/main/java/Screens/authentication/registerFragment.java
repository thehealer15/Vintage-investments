package Screens.authentication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.app.MainActivity;
import com.example.app.R;
import com.google.android.material.textfield.TextInputLayout;

public class registerFragment extends Fragment {
    View parent;
    Context mContext;
    EditText name , surname , bankAc , pan , email , passwd;
    Button createAc;

    private void init(){
        createAc = parent.findViewById(R.id.create_ac_btn);
        name  = parent.findViewById(R.id.name_register);
        surname = parent.findViewById(R.id.surname_register);
        bankAc  = parent.findViewById(R.id.bank_ac_register);
        pan =  parent.findViewById(R.id.pan_register);
        passwd = parent.findViewById(R.id.passwd_register);
        email= parent.findViewById(R.id.email_register);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context;
    }


    public registerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        parent =  inflater.inflate(R.layout.fragment_register, container, false);
        init();
        createAc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.welcomed = false;
                Intent i = new Intent(getActivity(), MainActivity.class);
                i.putExtra("path" , "MainActivity");
                startActivity(i);
            }
        });

        return parent;
    }
}