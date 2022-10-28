package com.org.demo.slide;


import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.org.helloworld.R;

/**
 * ================================================
 * 作    者：顾修忠-guxiuzhong@youku.com/gfj19900401@163.com
 * 版    本：
 * 创建日期：16/7/8-下午6:10
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class MyViewHolder extends RecyclerView.ViewHolder {

    public TextView textView;

    public MyViewHolder(View itemView) {
        super(itemView);
        textView = (TextView) itemView.findViewById(R.id.id_tv);

    }
}
