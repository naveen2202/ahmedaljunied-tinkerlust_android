package atpl.cc.tinkerlust.activities;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import atpl.cc.tinkerlust.adapter.ImageAdapter;
import atpl.cc.tinkerlust.R;

public class First_page extends AppCompatActivity {
ViewPager Scrollimage;
    ImageView imageview1,imageview2,imageview3,imageview4;
    Button Login,Signup;
    int Array[]={R.drawable.tinkerlust_bg,R.drawable.tinkerlust_bg,R.drawable.tinkerlust_bg,R.drawable.tinkerlust_bg};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);
        Scrollimage=(ViewPager)findViewById(R.id.scrollimage);
        Signup=(Button)findViewById(R.id.signup);
        imageview1=(ImageView)findViewById(R.id.imageview1);
        imageview2=(ImageView)findViewById(R.id.imageview2);
        imageview3=(ImageView)findViewById(R.id.imageview3);
        imageview4=(ImageView)findViewById(R.id.imageview4);
        Login=(Button)findViewById(R.id.login);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(First_page.this, Login.class);
                startActivity(i);
            }
        });
        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(First_page.this,Sign_up.class);
                startActivity(i);
            }
        });
        Scrollimage.setAdapter(new ImageAdapter(First_page.this,Array));
        Scrollimage.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {


            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        imageview1.setImageResource(R.drawable.whitecircle);
                        imageview2.setImageResource(R.drawable.lightcircleimage);
                        imageview3.setImageResource(R.drawable.lightcircleimage);
                        imageview4.setImageResource(R.drawable.lightcircleimage);
                        break;
                    case 1:
                        imageview1.setImageResource(R.drawable.lightcircleimage);
                        imageview2.setImageResource(R.drawable.whitecircle);
                        imageview3.setImageResource(R.drawable.lightcircleimage);
                        imageview4.setImageResource(R.drawable.lightcircleimage);
                        break;
                    case 2:
                        imageview1.setImageResource(R.drawable.lightcircleimage);
                        imageview2.setImageResource(R.drawable.lightcircleimage);
                        imageview3.setImageResource(R.drawable.whitecircle);
                        imageview4.setImageResource(R.drawable.lightcircleimage);
                        break;
                    case 3:
                        imageview1.setImageResource(R.drawable.lightcircleimage);
                        imageview2.setImageResource(R.drawable.lightcircleimage);
                        imageview3.setImageResource(R.drawable.lightcircleimage);
                        imageview4.setImageResource(R.drawable.whitecircle);
                        break;

                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
}
