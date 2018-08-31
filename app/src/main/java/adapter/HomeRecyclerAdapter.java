package adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.albert.rob.peachblossomrob.R;
import com.bumptech.glide.Glide;

import java.util.List;

import bean.HomeRecyclerBean;


public class HomeRecyclerAdapter extends RecyclerView.Adapter<HomeRecyclerAdapter.ContactsViewHolder> {

    private Context mContext;
    private List<HomeRecyclerBean> mbean;
    private OnItemClickListener mOnItemClickListener;

    public HomeRecyclerAdapter(Context context, List<HomeRecyclerBean> mbean) {
        this.mContext = context;
        this.mbean = mbean;
    }

    @Override
    public ContactsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_home_recycler, null);
        return new ContactsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ContactsViewHolder holder, int position) {

        if (mOnItemClickListener != null) {
            holder.itemView.setOnClickListener(view -> mOnItemClickListener.onClick(position));
        }
        holder.itemView.setOnLongClickListener(view -> {
            mOnItemClickListener.onLongClick(position);
            return true;
        });
        if(mContext != null){
            Glide.with(mContext).load(mbean.get(position).getImgUrl()).into(holder.mImage);
        }
        holder.mContent.setText(mbean.get(position).getContent());
        holder.mRelayNum.setText(mbean.get(position).getRelayNum()+"");
        holder.mLikeNum.setText(mbean.get(position).getLikeNum()+"");
        if(mContext != null){
            Glide.with(mContext).load(mbean.get(position).getHeadImage()).into(holder.mHead);
        }
        holder.nickName.setText(mbean.get(position).getNickName());
        holder.drawingBoard.setText(mbean.get(position).getDrawingBoard());
    }


    @Override
    public int getItemCount() {
        return mbean.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    class ContactsViewHolder extends RecyclerView.ViewHolder {
        ImageView mImage;
        TextView mContent;
        TextView mRelayNum;
        TextView mLikeNum;
        ImageView mHead;
        TextView nickName;
        TextView drawingBoard;
        ContactsViewHolder(View itemView) {
            super(itemView);
            mImage = itemView.findViewById(R.id.item_home_image);
            mContent = itemView.findViewById(R.id.item_home_content);
            mRelayNum = itemView.findViewById(R.id.tv_home_relay_num);
            mLikeNum = itemView.findViewById(R.id.tv_home_like_num);
            mHead = itemView.findViewById(R.id.civ_home_head);
            nickName = itemView.findViewById(R.id.tv_home_nick_name);
            drawingBoard = itemView.findViewById(R.id.tv_home_drawing_board);
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
