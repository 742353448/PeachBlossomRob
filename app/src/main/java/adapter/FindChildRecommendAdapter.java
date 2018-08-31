package adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.albert.rob.peachblossomrob.R;

import java.util.List;

import bean.FindChildCategoryBean;
import bean.FindChildRecommendBean;


/**
 * 子页-发现推荐兴趣列表
 */

public class FindChildRecommendAdapter extends RecyclerView.Adapter<FindChildRecommendAdapter.ContactsViewHolder> {
    private Context mContext;
    private OnItemClickListener mOnItemClickListener;
    private List<FindChildRecommendBean> mBean;

    public FindChildRecommendAdapter(Context context, List<FindChildRecommendBean> mBean) {
        this.mContext = context;
        this.mBean = mBean;
    }
    public void updateList(List<FindChildRecommendBean> list) {
        // 在原有的数据之上增加新数据
        if (list != null) {
            mBean.addAll(list);
            notifyDataSetChanged();
        }
    }
    @Override
    public ContactsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_find_child_recommend, null);
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
