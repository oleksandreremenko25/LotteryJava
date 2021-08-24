package com.example.lotteryjava;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonCheck = (Button)findViewById(R.id.buttonCheckNumberTicket);
        EditText edit = (EditText)findViewById(R.id.inputNumberTicket);
        TextView message = (TextView)findViewById(R.id.message);
        ImageView bulb = (ImageView)findViewById(R.id.bulb);

        buttonCheck.setOnClickListener(new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                int firstPartTicket = 0;
                int secondPartTicket = 0;
                //String numberTicket = Integer.toString(345765);
                String numberTicket = edit.getText().toString();

                if (numberTicket.length() != 6) {
                    message.setText("Не вірний номер");
                } else {
                    for (int y = 0; y < 3; y++) {
                        firstPartTicket = firstPartTicket + Character.getNumericValue(numberTicket.charAt(y));
                    }

                    for (int y = 3; y < 6; y++) {
                        secondPartTicket = secondPartTicket + Character.getNumericValue(numberTicket.charAt(y));
                    }

                    if (firstPartTicket == secondPartTicket) {
                        //bulb.setBackgroundColor(Color.GREEN);
                        bulb.getBackground().setColorFilter(0xff00ff00, PorterDuff.Mode.MULTIPLY);
                        //bulb.setBackgroundResource(R.drawable.circle);
                    } else {
                        //bulb.setBackgroundColor(Color.RED);
                        bulb.getBackground().setColorFilter(0xffff0000, PorterDuff.Mode.MULTIPLY);
                    }
                }
            }
        });
    }
}