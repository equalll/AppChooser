package io.julian.appchooser.module.mediatypes;

import android.content.Context;
import android.view.View;

import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;

import io.julian.appchooser.R;
import io.julian.appchooser.data.MediaType;

import static io.julian.common.Preconditions.checkNotNull;

/**
 * @author Zhu Liang
 * @version 1.0
 * @since 2017/4/15 下午9:35
 */

class MediaTypesAdapter extends CommonAdapter<MediaType> {

    private OnMediaTypesListener mOnMediaTypesListener;

    MediaTypesAdapter(Context context, OnMediaTypesListener onMediaTypesListener) {
        super(context, R.layout.item_media_type, new ArrayList<MediaType>());
        mOnMediaTypesListener = checkNotNull(onMediaTypesListener);
    }

    @Override
    protected void convert(ViewHolder viewHolder, final MediaType item, int position) {
        viewHolder.setText(R.id.text_view_media_type_name, item.getDisplayName());
        viewHolder.getConvertView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnMediaTypesListener.onMediaType(item);
            }
        });
    }

    public void replaceData(List<MediaType> mediaTypes) {
        mDatas.clear();
        mDatas.addAll(mediaTypes);
    }
}