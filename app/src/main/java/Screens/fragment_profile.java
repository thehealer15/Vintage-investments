package Screens;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.app.R;

import Screens.profile.AccountDetailsFragament;


public class fragment_profile extends Fragment {
    private View parentHolder;
    private Context context;
    private CardView account;
    private Button allOrders, helpNSupport;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    public fragment_profile() {
        // Required empty public constructor
    }


//    private void disableEditText(EditText editText) {
//        editText.setFocusable(false);
//        editText.setEnabled(false);
//        editText.setCursorVisible(false);
////        editText.setKeyListener(null);
////        editText.setBackgroundColor(Color.TRANSPARENT);
//    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        parentHolder =  inflater.inflate(R.layout.fragment_profile, container, false);
        account = parentHolder.findViewById(R.id.cardView);
        allOrders = parentHolder.findViewById(R.id.all_orders_btn);
        helpNSupport = parentHolder.findViewById(R.id.help_n_support_btn);

        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new AccountDetailsFragament());
            }
        });

        return parentHolder;
    }
    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
            transaction.replace(R.id.fragment_container, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
            return true;
        }
        return false;
    }

}