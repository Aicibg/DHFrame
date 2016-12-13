/*
 * Copyright (C) 2016 MarkZhai (http://zhaiyifan.cn).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.tengda.databindingframe.adapter;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * @author markzhai on 16/3/18
 * @version 1.0.0
 */
public class BindingViewHolder<T extends ViewDataBinding> extends RecyclerView.ViewHolder {

    protected T mBinding;
    public View itemView;

    public BindingViewHolder(T binding) {
        super(binding.getRoot());
        itemView=binding.getRoot();
        mBinding = binding;
    }

    public BindingViewHolder(View itemView){
        super(itemView);
        this.itemView=itemView;
    }

    public T getBinding() {
        return mBinding;
    }
}