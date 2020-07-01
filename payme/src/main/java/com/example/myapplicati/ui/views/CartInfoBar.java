package com.example.myapplicati.ui.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.myapplicati.R;

public class CartInfoBar extends RelativeLayout {
    private CartInfoBarListener listener;

    @BindView(R.id.cart_price)
    TextView cartInfo;

    public CartInfoBar(Context context) {
        super(context);
        init(context, null);
    }

    public CartInfoBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public void init(Context context, @Nullable AttributeSet attrs) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.view_cart_info_bar, null);
        ButterKnife.bind(this, view);
        addView(view);
    }

    public void setListener(CartInfoBarListener listener) {
        this.listener = listener;
    }

    @OnClick(R.id.container)
    void onContainerClick() {
        if (listener != null)
            listener.onClick();
    }

    public void setData(int itemCount, String price) {
        cartInfo.setText(getContext().getString(R.string.cart_info_bar_data, itemCount, price));
    }

    public interface CartInfoBarListener {
        void onClick();
    }
}