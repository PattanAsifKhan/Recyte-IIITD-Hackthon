package tech.geeksquad.recyte;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class DashBoardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
    }

    public void profile(View view) {
        startActivity(new Intent(this, ProfileActivity.class));
    }

    public void bot(View view) {
        startActivity(new Intent(this, BotActivity.class));
    }

    public void orders(View view) {
        startActivity(new Intent(this, OrdersActivity.class));
    }

    public void industry(View view) {
        startActivity(new Intent(this, PlacesNearMeActivity.class));
    }
}
