package org.honorato.multistatetogglebutton;


import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.multistatetogglebutton.R;

public class MultiStateToggleButton extends ToggleButton {

	private static final String TAG = "MultiStateToggleButton";
	List<Button> buttons;
	
	public MultiStateToggleButton(Context context) {
		super(context, null);
	}
	
    public MultiStateToggleButton(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        
        TypedArray a = context.obtainStyledAttributes(attrs,
        		R.styleable.MultiStateToggleButton, 0, 0);
        CharSequence[] texts = a.getTextArray(R.styleable.MultiStateToggleButton_values);
        a.recycle();

        setOrientation(LinearLayout.HORIZONTAL);
        setGravity(Gravity.CENTER_VERTICAL);

        LayoutInflater inflater = (LayoutInflater) context
            .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        LinearLayout mainLayout = (LinearLayout) inflater.inflate(R.layout.view_multi_state_toggle_button, this, true);

        // TODO: Add an exception
        if(texts.length < 2) {
        	Log.d(TAG, "Minimum quantity: 2");
        	return;
        }
        
        this.buttons = new ArrayList<Button>();
        for(int i = 0; i < texts.length; i++) {
        	Button b = null;
        	if(i == 0) {
        		b = (Button) inflater.inflate(R.layout.view_left_toggle_button, mainLayout, false);
        	} else if(i == texts.length - 1) {
        		b = (Button) inflater.inflate(R.layout.view_right_toggle_button, mainLayout, false);
        	} else {
        		b = (Button) inflater.inflate(R.layout.view_center_toggle_button, mainLayout, false);
        	}
        	b.setText(texts[i]);
        	final int position = i;
        	b.setOnClickListener(new View.OnClickListener() {

    			@Override
    			public void onClick(View v) {
    				setValue(position);
    			}
    			
    		});
        	mainLayout.addView(b);
        	this.buttons.add(b);
        }
        mainLayout.setBackgroundResource(R.drawable.button_section_shape);
    }
    
	public void setButtonState(Button button, boolean selected) {
		if(button == null) {
			return;
		}
		button.setSelected(selected);
		if(selected) {
			button.setBackgroundResource(R.drawable.button_pressed);
			button.setTextAppearance(this.context, R.style.WhiteBoldText);
		} else {
			button.setBackgroundResource(R.drawable.button_not_pressed);
			button.setTextAppearance(this.context, R.style.BlackNormalText);
		}
	}
	
	public int getValue() {
		for(int i = 0; i < this.buttons.size(); i++) {
			if(buttons.get(i).isSelected()) {
				return i;
			}
		}
		return -1;
	}
	
	public void setValue(int state) {

		for(int i = 0; i < this.buttons.size(); i++) {
			if(i == state) {
			setButtonState(buttons.get(i), true);
			} else {
			setButtonState(buttons.get(i), false);
				
			}
		}
		super.setValue(state);
	}


}
