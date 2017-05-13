package com.mobiledev.shapedprogress;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.TextView;


/**
 * Created by mdev3 on 5/4/17.
 */

public class SquareProgressView extends TextView {

    public static final int TYPE_FILL_LEFT = 0;
    public static final int TYPE_FILL_RIGHT = 1;
    public static final int TYPE_FILL_TOP = 2;
    public static final int TYPE_STROKE = 5;

    private Paint mPaint = new Paint();
    private int mProgress;
    private int currentType = TYPE_FILL_LEFT;

    public SquareProgressView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SquareProgressView(Context context) {
        super(context);
    }

    public SquareProgressView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //init();
    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        if (currentType == TYPE_FILL_LEFT) {
            mPaint.setColor(getContext().getResources().getColor(R.color.redColor));
            mPaint.setAntiAlias(true);
            mPaint.setAlpha(128);
            mPaint.setStrokeWidth(1.0f);
            Rect rect = new Rect();
            canvas.getClipBounds(rect);
            rect.left += getPaddingLeft();
            rect.top += getPaddingTop();
            rect.right = (rect.left - getPaddingLeft()) + (mProgress * getWidth() / 100) - getPaddingRight();
            rect.bottom -= getPaddingBottom();
            canvas.drawRoundRect(new RectF(rect), 8.0f, 8.0f, mPaint);
        }

     else if (currentType == TYPE_FILL_RIGHT) {
            mPaint.setColor(getContext().getResources().getColor(R.color.redColor));
            mPaint.setAntiAlias(true);
            mPaint.setAlpha(128);
            mPaint.setStrokeWidth(1.0f);
            Rect rect = new Rect();
            canvas.getClipBounds(rect);
            rect.left += getPaddingLeft();
            rect.top += getPaddingTop();
            rect.right = getWidth() - (mProgress * getWidth() / 100) ;
            rect.bottom -= getPaddingBottom();
            canvas.drawRoundRect(new RectF(rect), 8.0f, 8.0f, mPaint);
        }

        else if (currentType == TYPE_FILL_TOP) {
            mPaint.setColor(getContext().getResources().getColor(R.color.redColor));
            mPaint.setAntiAlias(true);
            mPaint.setAlpha(128);
            mPaint.setStrokeWidth(4.0f);
            Rect rect = new Rect();
            canvas.getClipBounds(rect);
            rect.left += getPaddingLeft();
            rect.top += getPaddingTop();
            rect.bottom = (rect.top - getPaddingTop()) + (mProgress * getHeight() / 100) - getPaddingTop();
            rect.right -= getPaddingRight();
            canvas.drawRoundRect(new RectF(rect), 8.0f, 8.0f, mPaint);
        }


        else if (currentType == TYPE_STROKE) {
            mPaint.setAntiAlias(true);
            mPaint.setColor(Color.parseColor("#bf3f40"));
            mPaint.setAlpha(255);
            Rect rect = new Rect();
            canvas.getClipBounds(rect);
            Paint paint1, paint2, paint3, paint4;
            if (mProgress >= 0 && mProgress < 25) {
                paint1 = new Paint(mPaint);
                Rect temp = new Rect(rect.left + getPaddingLeft(),
                        rect.top + getPaddingTop(),
                        rect.left + mProgress * (getWidth() - getPaddingLeft() - getPaddingRight())
                                / 25 - getPaddingRight(),
                        rect.top + getPaddingTop() + 14);
                canvas.drawRect(temp, paint1);
            } else if (mProgress < 50) {
                paint1 = new Paint(mPaint);
                Rect rect1 = new Rect(rect.left + getPaddingLeft(),
                        rect.top + getPaddingTop(), rect.right - getPaddingRight(),
                        rect.top + getPaddingTop() + 14);
                canvas.drawRect(rect1, paint1);

                paint2 = new Paint(mPaint);
                Rect rect2 = new Rect(rect.right - getPaddingRight() - 14,
                        rect.top + getPaddingTop(), rect.right - getPaddingRight(),
                        rect.top + getPaddingTop() + (mProgress - 25) *
                                (getHeight() - getPaddingTop() - getPaddingBottom()) / 25);
                canvas.drawRect(rect2, paint2);
            } else if (mProgress < 75) {
                paint1 = new Paint(mPaint);
                Rect rect1 = new Rect(rect.left + getPaddingLeft(),
                        rect.top + getPaddingTop(), rect.right - getPaddingRight(),
                        rect.top + getPaddingTop() + 14);
                canvas.drawRect(rect1, paint1);

                paint2 = new Paint(mPaint);
                Rect rect2 = new Rect(rect.right - getPaddingRight() - 14,
                        rect.top + getPaddingTop(), rect.right - getPaddingRight(),
                        rect.bottom - getPaddingBottom());
                canvas.drawRect(rect2, paint2);

                paint3 = new Paint(mPaint);
                Rect rect3 = new Rect(
                        rect.right - getPaddingRight() - (mProgress - 50) *
                                (getWidth() - getPaddingLeft() - getPaddingRight()) / 25,
                        rect.bottom - getPaddingBottom() - 14,
                        rect.right - getPaddingRight(),
                        rect.bottom - getPaddingBottom());
                canvas.drawRect(rect3, paint3);
            } else if (mProgress <= 100) {
                paint1 = new Paint(mPaint);
                Rect rect1 = new Rect(
                        rect.left + getPaddingLeft(),
                        rect.top + getPaddingTop(), rect.right - getPaddingRight(),
                        rect.top + getPaddingTop() + 14);
                canvas.drawRect(rect1, paint1);

                paint2 = new Paint(mPaint);
                Rect rect2 = new Rect(
                        rect.right - getPaddingRight() - 14,
                        rect.top + getPaddingTop(), rect.right - getPaddingRight(),
                        rect.bottom - getPaddingBottom());
                canvas.drawRect(rect2, paint2);

                paint3 = new Paint(mPaint);
                Rect rect3 = new Rect(
                        rect.left ,
                        rect.bottom - getPaddingBottom() - 14, rect.right - getPaddingRight(),
                        rect.bottom - getPaddingRight());
                canvas.drawRect(rect3, paint3);

                paint4 = new Paint(mPaint);
                Rect rect4 = new Rect(
                        rect.left ,
                        rect.bottom - getPaddingBottom() - (mProgress - 75) *
                                (getHeight() - getPaddingTop() - getPaddingBottom()) / 25,
                        rect.left + getPaddingLeft() + 14,
                        rect.bottom - getPaddingBottom());
                canvas.drawRect(rect4, paint4);
            }
        }

        super.onDraw(canvas);
    }

    public void updateProgress(int progress) {
        setGravity(Gravity.CENTER);
        setTextColor(Color.WHITE);
        setText(String.valueOf(progress));
        if (progress >= 0 && progress <= 100) {
            mProgress = progress;
            invalidate();
        } else if (progress < 0) {
            mProgress = 0;
            invalidate();
        } else if (progress > 100) {
            mProgress = 100;
            invalidate();
        }
    }

    public void setType(int type) {
        if (type == TYPE_FILL_LEFT || type == TYPE_FILL_RIGHT || type==TYPE_FILL_TOP )
            currentType = type;
        else
            currentType = TYPE_STROKE;
    }
}
