package adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.albert.rob.peachblossomrob.R;

import java.util.List;

import bean.FindChildCategoryBean;


/**
 * 子页-发现横向类目列表
 */

public class FindChildCategoryAdapter extends RecyclerView.Adapter<FindChildCategoryAdapter.ContactsViewHolder> {
    private Context mContext;
    private OnItemClickListener mOnItemClickListener;
    private List<FindChildCategoryBean> mBean;

    public FindChildCategoryAdapter(Context context, List<FindChildCategoryBean> mBean) {
        this.mContext = context;
        this.mBean = mBean;
    }
    public void updateList(List<FindChildCategoryBean> list) {
        // 在原有的数据之上增加新数据
        if (list != null) {
            mBean.addAll(list);
            notifyDataSetChanged();
        }
    }
    @Override
    public ContactsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_find_child_category, null);
        return new ContactsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ContactsViewHolder holder, final int position) {

        if (mOnItemClickListener != null) {
            holder.itemView.setOnClickListener(view -> mOnItemClickListener.onClick(position));
        }
        holder.itemView.setOnLongClickListener(view -> {
            mOnItemClickListener.onLongClick(position);
            return true;
        });

    }


    @Override
    public int getItemCount() {
        return 8;
    }

    /**
     * 重写getItemId方法。是为了解决ViewHolder的复用导致数据错乱问题
     *
     * @param position
     * @return
     */
    @Override
    public long getItemId(int position) {
        return position;
    }

    class ContactsViewHolder extends RecyclerView.ViewHolder {

        ContactsViewHolder(View itemView) {
            super(itemView);

        }
    }

    public interface OnItemClickListener {
        void onClick(int position);

        void onLongClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }
}
