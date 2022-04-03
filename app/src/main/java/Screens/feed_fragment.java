package Screens;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.app.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.snackbar.Snackbar;


public class feed_fragment extends Fragment {
    private View parentHolder;
    private Context context;
    private Button filter_on_tenure;
    private BottomSheetDialog dialog ;
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    public feed_fragment() { }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        parentHolder =  inflater.inflate(R.layout.feed_fragment, container, false);
        dialog = new BottomSheetDialog(context);

        filter_on_tenure = parentHolder.findViewById(R.id.filter_feed_btn);
        createDialog();

        filter_on_tenure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();
            }
        });

        return parentHolder;
 }
    private void createDialog(){


        View v = getLayoutInflater().inflate(R.layout.bottom_sheet_feedfragment,null , false);
        Button short_term , long_term , mid_term;
        short_term = v.findViewById(R.id.short_term);
        mid_term = v.findViewById(R.id.mid_term);
        long_term = v.findViewById(R.id.long_term);

        short_term.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast("short term");
            }
        });
        mid_term.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast("mid term");
            }
        });
        long_term.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast("long term");
            }
        });
        dialog.setContentView(v);
    }


    private void showSnackBar(String text){
        Snackbar.make(getActivity().findViewById(android.R.id.content), text, Snackbar.LENGTH_LONG)
                .show();
    }
    private void showToast(String text){
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }
}