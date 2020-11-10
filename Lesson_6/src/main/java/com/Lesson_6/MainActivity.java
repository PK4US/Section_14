package com.Lesson_6;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button);
        button.setBackground(new MyShape());
    }

    private class MyShape extends Drawable {
        private Path path;
        private Paint p;

        public MyShape() {
            path = new Path();
            p = new Paint();
            p.setColor(Color.RED);
        }

        @Override
        public void draw(@NonNull Canvas canvas) {
            canvas.drawPath(path, p);
        }

        @Override
        public void setAlpha(int i) {
            p.setAlpha(i);
        }

        @Override
        public void setColorFilter( ColorFilter colorFilter) {
            p.setColorFilter(colorFilter);
        }

        @Override
        public int getOpacity() {
            return PixelFormat.TRANSPARENT;
        }

        @Override
        protected void onBoundsChange(Rect bounds) {
            super.onBoundsChange(bounds);
            int w = bounds.width();
            int h = bounds.height();
            path.reset();
            RectF rect = new RectF(bounds);
            path.addOval(rect, Path.Direction.CW);
            path.close();
        }
    }
}