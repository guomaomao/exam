package com.seatrend.exam.common.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * 画板控件,使用贝塞尔曲线设计
 */
public class PainterView extends View {
    private Paint mPaint;
    private Path mPath;
    private float mLastX;//上一次事件的终点x
    private float mLastY;//上一次事件的终点y
    private boolean isTouched = false;

    public PainterView(Context context) {
        this(context, null);
    }

    public PainterView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PainterView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        mPath = new Path();
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(12);
        mPaint.setAntiAlias(true);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mPath.moveTo(x, y);
                mLastX = x;
                mLastY = y;
                return true;//消费按下事件,则整个时间序列都将交给该view处理
            case MotionEvent.ACTION_MOVE:
                isTouched = true;

                float endX = (mLastX + x) / 2;//结束点x
                float endY = (mLastY + y) / 2;//结束点y
                mPath.quadTo(mLastX, mLastY, endX, endY);//上一次的终点作为起点,上一个点作为控制点,中间点作为终点
                mLastX = x;//记录上一次的操作点
                mLastY = y;
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return super.onTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawPath(mPath, mPaint);
    }


    /**
     * 设置画笔颜色
     *
     * @param penColorId
     */
    public void setPenColorRes(@ColorRes int penColorId) {
        int color = getResources().getColor(penColorId);
        mPaint.setColor(color);
    }

    /**
     * 设置画笔颜色
     */
    public void setPenColor(@ColorInt int penColor) {
        mPaint.setColor(penColor);
    }

    /**
     * 设置画笔宽度
     */
    public void setPenWidth(float penWidth) {
        mPaint.setStrokeWidth(penWidth);
    }

    /**
     * 重置,即擦除所有内容
     */
    public void clear() {
        isTouched = false;
        mPath.reset();//重置为空白路径
        invalidate();//绘制空白路径
    }

    /**
     * 生成快照
     */
    public Bitmap createBitmap() {
        Bitmap bitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmap);
        canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);//绘制透明色
        this.draw(canvas);
        return bitmap;
    }

    /**
     * 是否有签名
     */
    public boolean getTouched() {
        return isTouched;
    }

}