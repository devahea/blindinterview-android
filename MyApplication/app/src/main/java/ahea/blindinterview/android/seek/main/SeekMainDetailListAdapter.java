package ahea.blindinterview.android.seek.main;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;

import java.util.List;

import ahea.blindinterview.android.R;
import ahea.blindinterview.android.seek.detail.SeekDetailActivity;

public class SeekMainDetailListAdapter extends RecyclerView.Adapter<SeekMainDetailListAdapter.SeekMainListDetailItemHolder> {

    private List items;

    SeekMainDetailListAdapter(List modelData) {
        if (modelData == null) {
            throw new IllegalArgumentException(
                    "modelData must not be null");
        }
        this.items = modelData;
    }

    @Override
    public SeekMainListDetailItemHolder onCreateViewHolder(
            ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.seek_main_detail_item, viewGroup, false);
        return new SeekMainListDetailItemHolder(itemView, viewType);
    }

    @Override
    public void onBindViewHolder(
            final SeekMainListDetailItemHolder viewHolder, int position) {
//        DemoModel model = items.get(position);
//        viewHolder.label.setText(model.label);
//        String dateStr = DateUtils.formatDateTime(
//                viewHolder.label.getContext(),
//                model.dateTime.getTime(),
//                DateUtils.FORMAT_ABBREV_ALL);
//        viewHolder.dateTime.setText(dateStr);

//        List detailDummyItemList = new ArrayList();
//        detailDummyItemList.add(new Object());
//        detailDummyItemList.add(new Object());

        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowmanager = (WindowManager) viewHolder.context.getSystemService(Context.WINDOW_SERVICE);
        windowmanager.getDefaultDisplay().getMetrics(displayMetrics);
        int deviceWidth = displayMetrics.widthPixels;



        ViewGroup.LayoutParams params = viewHolder.rootLayout.getLayoutParams();;
// Changes the height and width to the specified *pixels*
        params.width = deviceWidth/2;
        viewHolder.rootLayout.setLayoutParams(params);

        viewHolder.rootLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(viewHolder.context, SeekDetailActivity.class);
                viewHolder.context.startActivity(intent);
            }
        });



    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    public final static class SeekMainListDetailItemHolder extends RecyclerView.ViewHolder {


        Context context;
        LinearLayout rootLayout;

        public SeekMainListDetailItemHolder(View itemView, int viewType) {
            super(itemView);

            context = itemView.getContext();
            rootLayout = (LinearLayout)itemView.findViewById(R.id.rootLayout);

        }
    }

}
