package ahea.blindinterview.android.seek.main;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ahea.blindinterview.android.R;

public class SeekMainListAdapter extends RecyclerView.Adapter<SeekMainListAdapter.SeekMainListItemHolder> {

    private List items;

    SeekMainListAdapter(List modelData) {
        if (modelData == null) {
            throw new IllegalArgumentException(
                    "modelData must not be null");
        }
        this.items = modelData;
    }

    @Override
    public SeekMainListItemHolder onCreateViewHolder(
            ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.seek_main_list_item, viewGroup, false);
        return new SeekMainListItemHolder(itemView, viewType);
    }

    @Override
    public void onBindViewHolder(
            SeekMainListItemHolder viewHolder, int position) {
//        DemoModel model = items.get(position);
//        viewHolder.label.setText(model.label);
//        String dateStr = DateUtils.formatDateTime(
//                viewHolder.label.getContext(),
//                model.dateTime.getTime(),
//                DateUtils.FORMAT_ABBREV_ALL);
//        viewHolder.dateTime.setText(dateStr);

        List detailDummyItemList = new ArrayList();
        detailDummyItemList.add(new Object());
        detailDummyItemList.add(new Object());

        SeekMainDetailListAdapter adapter = new SeekMainDetailListAdapter(detailDummyItemList);

        viewHolder.detailList.setAdapter(adapter);


    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    public final static class SeekMainListItemHolder extends RecyclerView.ViewHolder {

        RecyclerView detailList;

        public SeekMainListItemHolder(View itemView, int viewType) {
            super(itemView);
            detailList = (RecyclerView)itemView.findViewById(R.id.seek_detail_list);
            LinearLayoutManager layoutManager = new LinearLayoutManager(itemView.getContext());
            layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            detailList.setLayoutManager(layoutManager);

        }
    }

}
