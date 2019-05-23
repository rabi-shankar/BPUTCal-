package com.rabi.shankar.bputcal;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        TextView sourceCodeLink = (TextView) findViewById(R.id.application_source_code);
        String linkText = "Source code: <a href='http://www.github.com'>Github</a>.";
        sourceCodeLink.setText(Html.fromHtml(linkText));
        sourceCodeLink.setMovementMethod(LinkMovementMethod.getInstance());

        //Email
        /*TextView email = (TextView) findViewById(R.id.textView2);
        String emailText = "Send email: <a href=\"mailto:person@stackoverflow.com\">Click Me!</a>";
        email.setText(Html.fromHtml(emailText));
        email.setMovementMethod(LinkMovementMethod.getInstance());*/
    }
}
