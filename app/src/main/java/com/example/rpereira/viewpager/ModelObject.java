package com.example.rpereira.viewpager;

public enum ModelObject {

    LEFT(R.string.layout_esquerda, R.layout.left_layout),
    CENTER(R.string.layout_meio, R.layout.center_layout),
    RIGHT(R.string.layout_direita, R.layout.right_layout);
    //RIGHT_MAX(R.string.max_rigth_label, R.layout.max_right_layout);

    private int mTitleResId;
    private int mLayoutResId;

    ModelObject(int titleResId, int layoutResId) {
        mTitleResId = titleResId;
        mLayoutResId = layoutResId;
    }

    public int getTitleResId() { return mTitleResId; }

    public int getLayoutResId() { return mLayoutResId; }
}
