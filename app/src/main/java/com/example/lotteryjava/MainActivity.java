package com.example.lotteryjava;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.res.Resources;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonCheck = (Button)findViewById(R.id.buttonCheckNumberTicket);
        EditText edit = (EditText)findViewById(R.id.inputNumberTicket);
        TextView message = (TextView)findViewById(R.id.message);
        ImageView bulb = (ImageView)findViewById(R.id.bulb);

        calculation(buttonCheck, edit, message, bulb);
    }

    public void calculation(Button buttonCheck, EditText edit, TextView message, ImageView bulb) {
        buttonCheck.setOnClickListener(new View.OnClickListener () {
            public String textInvalidTicket = getString(R.string.invalidLotteryTicket);
            public String textEmptyMessage = getString(R.string.emptyMessage);

            @Override
            public void onClick(View view) {
                int firstPartTicket = 0;
                int secondPartTicket = 0;
                String numberTicket = edit.getText().toString();

                if (numberTicket.length() != 6) {
                    message.setText(textInvalidTicket);
                } else {
                    message.setText(textEmptyMessage);

                    if (equalityTest(firstPartTicket, secondPartTicket, numberTicket)) {
                        bulb.getBackground().setColorFilter(getResources().getColor(R.color.green), PorterDuff.Mode.MULTIPLY);
                        //bulb.getBackground().setColorFilter(0xff00ff00, PorterDuff.Mode.MULTIPLY);
                    } else {
                        bulb.getBackground().setColorFilter(getResources().getColor(R.color.red), PorterDuff.Mode.MULTIPLY);
                    }
                }
            }
        });
    }

    public boolean equalityTest(int firstPartTicket,int secondPartTicket,String numberTicket) {
        for (int y = 0; y < 3; y++) {
            firstPartTicket = firstPartTicket + Character.getNumericValue(numberTicket.charAt(y));
        }

        for (int y = 3; y < 6; y++) {
            secondPartTicket = secondPartTicket + Character.getNumericValue(numberTicket.charAt(y));
        }

        return (firstPartTicket == secondPartTicket);
    }
}