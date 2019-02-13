package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    TextView mTextView;
    Button mButtonTop;
    Button mButtonBottom;
    int mStoryIndex = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mTextView = findViewById(R.id.storyTextView);
        mButtonTop = findViewById(R.id.buttonTop);
        mButtonBottom = findViewById(R.id.buttonBottom);



        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mButtonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mStoryIndex == 1)
                {
                    mStoryIndex = 3;
                } else if (mStoryIndex == 2)
                {
                    mStoryIndex = 3;
                } else if (mStoryIndex == 3)
                {
                    mStoryIndex = 6;
                }

                UpdateText();

            }
        });



        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mButtonBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mStoryIndex == 1)
                {
                    mStoryIndex = 2;
                } else if (mStoryIndex == 2)
                {
                    mStoryIndex = 4;
                } else if (mStoryIndex == 3) {
                    mStoryIndex = 5;
                }

                UpdateText();

            }
        });

    }
    public void UpdateText ()
    {
        if(mStoryIndex == 4 || mStoryIndex == 5 || mStoryIndex == 6)
        {
            mButtonTop.setVisibility(View.GONE);
            mButtonBottom.setVisibility(View.GONE);

            String textID = "T" + mStoryIndex + "_End"; //"R.string.T" + mStoryIndex + "_Story";
            int resID = getApplicationContext().getResources().getIdentifier(textID, "string", "com.londonappbrewery.destini");
            mTextView.setText(getString(resID));

        } else {
            // Update story
            String textID = "T" + mStoryIndex + "_Story"; //"R.string.T" + mStoryIndex + "_Story";
            int resID = getApplicationContext().getResources().getIdentifier(textID, "string", "com.londonappbrewery.destini");
            mTextView.setText(getString(resID));

            // Update top button
            textID = "T" + mStoryIndex + "_Ans1"; //"R.string.T" + mStoryIndex + "_Story";
            resID = getApplicationContext().getResources().getIdentifier(textID, "string", "com.londonappbrewery.destini");
            mButtonTop.setText(getString(resID));

            // Update bottom button
            textID = "T" + mStoryIndex + "_Ans2"; //"R.string.T" + mStoryIndex + "_Story";
            resID = getApplicationContext().getResources().getIdentifier(textID, "string", "com.londonappbrewery.destini");
            mButtonBottom.setText(getString(resID));
        }
    }
}
