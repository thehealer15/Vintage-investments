package Screens.authentication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.app.MainActivity;
import com.example.app.R;

public class WelcomeActivity extends AppCompatActivity {
    FrameLayout fragment_container;
    private Button login_welcome, signup_welcome;
    LinearLayout btn_layout;
    TextView welcome_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_activity);
        MainActivity.welcomed = true;

        login_welcome = findViewById(R.id.login_welcome);
        signup_welcome = findViewById(R.id.signup_welcome);
        btn_layout = findViewById(R.id.btn_layout);
        fragment_container = findViewById(R.id.container);
        welcome_text = findViewById(R.id.textView3);

        login_welcome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    disappear(btn_layout);
                    disappear(welcome_text);
                    loadFragment(new loginFragment());
                }
                catch (Exception e){
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });
        signup_welcome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    disappear(btn_layout);
                    disappear(welcome_text);
                    loadFragment(new registerFragment());
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
            transaction.replace(R.id.container, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
            return true;
        }
        return false;
    }
    private void disappear(View v){
        v.setVisibility(View.GONE);
    }

}