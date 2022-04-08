package Screens;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.example.app.R;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseUser;

/*
* my features :==>
    Basically i can keep 2 types of Instruments;
    1. Investment
        - mid to long term
    2. Short Term
        - will be sold to business / buyers within 3 years

*  LOCK IN *

    Allocation Strategy  :
    * BUY SELL should be allowed to both :
    <== short term / actionable ==>
        1. every year premium of 13%
    <== Investment ==>
        1. 3 years LOCK IN period

        redeem option:
        *
 at backend :
 * Table 1
    there will be java class as Investment with parameters:
        * price now , type , date, units , price at that time;
* Table 2
    mapping of ( uuid <=> profile info completed )

*
** PROGRESS 2.0 **
now add realtime data base of firebase
* maintain 3 tables
* mapping (profile completed uuid - bool )
* information
* portfolio
*   - short term
*   - long term
* * * */
public class feed_fragment extends Fragment {
    private View parentHolder;
    private Context context;

    Button short_term , long_term;
    EditText short_term_qnty, long_term_qnty;
    TextView short_term_amount , long_term_amount;


    FirebaseDatabase firebaseDatabase;
    DatabaseReference profile_completed_ref , portfolio , info;
    private void init(){
        short_term = parentHolder.findViewById(R.id.btn1);
        long_term = parentHolder.findViewById(R.id.btn2);

        short_term_qnty = parentHolder.findViewById(R.id.qnty_short_term);
        long_term_qnty = parentHolder.findViewById(R.id.qnty_long_term);

        long_term_amount = parentHolder.findViewById(R.id.amnt_long_term);
        short_term_amount = parentHolder.findViewById(R.id.amnt_short_term);

//        firebaseDatabase = FirebaseDatabase.getInstance();
//
//        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
//
//        profile_completed_ref = firebaseDatabase.getReference("Profile");
//        portfolio = firebaseDatabase.getReference("portfolio");
//        info = firebaseDatabase.getReference("info");
    }

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
        init();

        short_term.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buyShortTerm();
            }
        });
        long_term.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buyLongTerm();
            }
        });


        return parentHolder;
 }

    private void updateQuantity(Integer qty , boolean isLongTerm){
        // update to firebase here
        Toast.makeText(getActivity(), "Do payment", Toast.LENGTH_SHORT).show();
//        Intent i = new Intent(getActivity() , PaymentActivity.class);
//        i.putExtra("amount" , qty);
////        startActivity(i);


    }
    private void buyShortTerm(){
        if(short_term_qnty.getText().toString().length() == 0){
            showSnackBar("Enter Quantity");
            short_term_qnty.setError("Quantity > 0");
        }
        try{
            Integer qty = Integer.parseInt(short_term_qnty.getText().toString());
            String temp = qty*800 +"";
            short_term_amount.setText(temp);
            updateQuantity(qty ,false);
        }catch (Exception e){
            showSnackBar(e.getMessage());
        }
    }
    private void buyLongTerm(){
        if(long_term_qnty.getText().toString().length() == 0){
            showSnackBar("Enter Quantity");
            long_term_qnty.setError("Quantity > 0");
        }
        try{
            Integer qty = Integer.parseInt(long_term_qnty.getText().toString());
            String temp = qty*800 +"";
            long_term_amount.setText(temp);
            updateQuantity(qty , true);
        }catch (Exception e){
            showSnackBar(e.getMessage());
        }
    }

    private void showSnackBar(String text){
        Snackbar.make(getActivity().findViewById(android.R.id.content), text, Snackbar.LENGTH_LONG)
                .show();
    }
    private void showToast(String text){
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }
}