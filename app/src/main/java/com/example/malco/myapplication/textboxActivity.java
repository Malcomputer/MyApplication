package com.example.malco.myapplication;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class textboxActivity extends AppCompatActivity {

	TextView textDummyHintMobileNumber;
	TextView textDummyHintPromoCode;
	EditText editMobileNumber;
	EditText editPromoCode;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_laytest);

		textDummyHintMobileNumber = findViewById(R.id.text_dummy_hint_mobile_number);
		textDummyHintPromoCode = findViewById(R.id.text_dummy_hint_promo_code);
		editMobileNumber = findViewById(R.id.num_textbox);
		editPromoCode = findViewById(R.id.edit_promo_code);

		// Mobile number
		editMobileNumber.setOnFocusChangeListener(new View.OnFocusChangeListener() {
			@Override
			public void onFocusChange(View v, boolean hasFocus) {

				if (hasFocus) {
					new Handler().postDelayed(new Runnable() {

						@Override
						public void run() {
							// Show white background behind floating label
							textDummyHintMobileNumber.setVisibility(View.VISIBLE);
						}
					}, 100);
				} else {
					// Required to show/hide white background behind floating label during focus change
					if (editMobileNumber.getText().length() > 0)
						textDummyHintMobileNumber.setVisibility(View.VISIBLE);
					else
						textDummyHintMobileNumber.setVisibility(View.INVISIBLE);
				}
			}
		});

		// Promo code
		editPromoCode.setOnFocusChangeListener(new View.OnFocusChangeListener() {
			@Override
			public void onFocusChange(View v, boolean hasFocus) {

				if (hasFocus) {
					new Handler().postDelayed(new Runnable() {

						@Override
						public void run() {
							// Show white background behind floating label
							textDummyHintPromoCode.setVisibility(View.VISIBLE);
						}
					}, 100);
				} else {
					// Required to show/hide white background behind floating label during focus change
					if (editPromoCode.getText().length() > 0)
						textDummyHintPromoCode.setVisibility(View.VISIBLE);
					else
						textDummyHintPromoCode.setVisibility(View.INVISIBLE);
				}
			}
		});
	}
}
