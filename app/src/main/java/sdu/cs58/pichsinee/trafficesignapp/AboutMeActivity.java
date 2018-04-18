package sdu.cs58.pichsinee.trafficesignapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AboutMeActivity extends AppCompatActivity {
    //Explict
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);
    }

    public void clickBack(View view) {
        finish();
    }//end back Method

    public void playSound(View view) {
        if (mediaPlayer != null) { //ตรวจสอบว่ามี Obj. mediaPlayer เล่นอยู่หรือไม่
            mediaPlayer.stop(); //ถ้ามีให้หยุดเล่น
            mediaPlayer.release(); //คืน resource ที่ mediaPlayer
        }

        mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.naruto);
        mediaPlayer.start();

    }//end playSound Method

    public void clickFacebook(View view) {
        Intent fbIntent = new Intent(Intent.ACTION_VIEW);
        fbIntent.setData(Uri.parse("https://www.facebook.com/Piy4nutt"));
        startActivity(fbIntent);

    }//end clickFacebook Method

    public void clickMobile(View view) {
        Intent mobileIntent = new Intent(Intent.ACTION_DIAL);
        mobileIntent.setData(Uri.parse("tel:0946644010"));
        startActivity(mobileIntent);

    }

    public void clickMap(View view) {
        String lat = "13.776023";
        String lng = "100.510628";
        String label = "มหาวิทยาลัยสวนดุสิต";

        Uri location = Uri.parse("https://maps.google.com/maps?z=10&q=loc:"+lat+","+lng+"("+label+")");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW,location);
        //mapIntent.setPackage("com.google.android.apps.maps"); //บังคับใฟ้เลือกแอพ ใช้ test บน Genymotion ไม่ได้
        startActivity(mapIntent);



    }//end clickMap method

}//end Class

