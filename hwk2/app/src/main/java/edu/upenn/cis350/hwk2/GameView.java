package edu.upenn.cis350.hwk2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by RajatBhageria on 2/13/16.
 */
public class GameView extends View {
    public GameView (Context c) {
        super(c);
    }
    public GameView(Context c, AttributeSet a) {
        super(c, a);
    }
    public void onDraw(Canvas canvas){
        Bitmap img = BitmapFactory.decodeResource(getResources(),
                R.drawable.dot);
        for (int i = 0; i < canvas.getWidth(); i++){
            for (int j = 0; j < canvas.getHeight(); j++){

            }
        }
        canvas.drawBitmap(img, 30, 30, null);

        Paint p = new Paint();
        p.setColor(Color.RED);
        p.setStrokeWidth(10);
        canvas.drawLine(40, 20, 60, 50, p);

    }


    public void onTouchEvent(View view){

    }
}
