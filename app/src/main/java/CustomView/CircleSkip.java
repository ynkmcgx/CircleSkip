package CustomView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class CircleSkip extends View {

    private Paint paint;
    private int width;
    private int hight;
    private float x=0;

    public CircleSkip(Context context) {
        super(context);
    }

    public CircleSkip(Context context, AttributeSet attrs) {
        super(context, attrs);
        //初始化画笔
        init();

    }

    private void init() {

        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setDither(true);
    }

    //设置圆弧X的进度
    public void setX(float num) {
        x=num;
        invalidate();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //获取用户设置的宽高
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int hgihtSize = MeasureSpec.getSize(heightMeasureSpec);
        int hightMode = MeasureSpec.getMode(heightMeasureSpec);

        width=widthMode==MeasureSpec.EXACTLY ? widthSize:200;
        hight=hightMode==MeasureSpec.EXACTLY ? hgihtSize:200;
        //设置宽高
        setMeasuredDimension(width,hight);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        //画圆
        paint.setColor(Color.parseColor("#555555"));
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(60,60,60,paint);

        //写字
        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setTextSize(45);
        paint.setStrokeWidth(1);
        canvas.drawText("跳过",20,75,paint);

        //画外圈
        paint.setColor(Color.RED);
        paint.setStrokeWidth(3);
        RectF rectF = new RectF(2,2,120,120);
        canvas.drawArc(rectF,-90,x,false,paint);

    }
}
