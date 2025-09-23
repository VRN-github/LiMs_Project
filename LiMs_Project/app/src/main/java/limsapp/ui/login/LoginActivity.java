package limsapp.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import limsapp.ui.dashboard.DashboardActivity;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText username = findViewById(R.id.username);
        EditText password = findViewById(R.id.password);
        Button loginBtn = findViewById(R.id.loginBtn);

        loginBtn.setOnClickListener(v -> {
            String user = username.getText().toString();
            String pass = password.getText().toString();
            if(user.equals("admin") && pass.equals("admin")) {
                startActivity(new Intent(LoginActivity.this, DashboardActivity.class));
                finish();
            } else {
                Toast.makeText(this, "Invalid credentials", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
