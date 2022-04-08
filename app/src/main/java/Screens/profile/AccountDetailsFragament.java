package Screens.profile;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.app.R;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;


public class AccountDetailsFragament extends Fragment {
    private View parentHolder;
    private Button editBtn , save_infoBtn;
    private TextInputLayout name, email , bankAccountNo, pan , mobile_no, nominee ;
    private void init(){
        name = parentHolder.findViewById(R.id.user_name);
        email = parentHolder .findViewById(R.id.user_email);
        bankAccountNo = parentHolder.findViewById(R.id.user_bank_ac);
        pan = parentHolder.findViewById(R.id.user_pan_card);
        mobile_no = parentHolder.findViewById(R.id.user_mobile_no);
        nominee = parentHolder.findViewById(R.id.user_Nominee);
        editBtn = parentHolder.findViewById(R.id.edit_info);
        save_infoBtn = parentHolder.findViewById(R.id.save_info);
    }

    public AccountDetailsFragament() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        parentHolder =  inflater.inflate(R.layout.account_details_fragament, container, false);
        init();
        controlEditText(false);
        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controlEditText(true);
            }
        });

        save_infoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        return parentHolder;
    }

    private  void controlEditText(boolean val){
        name.getEditText().setFocusableInTouchMode(val);
        email.getEditText().setFocusableInTouchMode(val);
        bankAccountNo.getEditText().setFocusableInTouchMode(val);
        pan.getEditText().setFocusableInTouchMode(val);
        mobile_no.getEditText().setFocusableInTouchMode(val);
        nominee.getEditText().setFocusableInTouchMode(val);
    }

}