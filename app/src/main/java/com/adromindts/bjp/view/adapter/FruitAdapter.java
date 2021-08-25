package com.adromindts.bjp.view.adapter;

import java.util.ArrayList;
import java.util.List;

import com.adromindts.bjp.R;
import com.adromindts.bjp.model.PeopleModel;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
public class FruitAdapter extends ArrayAdapter<PeopleModel.Sheet> {
    private Context context;
    private int resourceId;
    private List<PeopleModel.Sheet> items, tempItems, suggestions;
    private TextView emptyView;
    public FruitAdapter(@NonNull Context context, int resourceId, ArrayList<PeopleModel.Sheet> items,TextView view) {
        super(context, resourceId, items);
        this.items = items;
        this.context = context;
        this.resourceId = resourceId;
        tempItems = new ArrayList<>(items);
        this.emptyView = view;
        suggestions = new ArrayList<>();
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        try {
            if (convertView == null) {
                LayoutInflater inflater = ((Activity) context).getLayoutInflater();
                view = inflater.inflate(resourceId, parent, false);
            }
            TextView name = (TextView) view.findViewById(R.id.filled_exposed);
            PeopleModel.Sheet fruit = getItem(position);


            name.setText(fruit.getNameOfElector());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return view;
    }
    @Nullable
    @Override
    public PeopleModel.Sheet getItem(int position) {
        return items.get(position);
    }
    @Override
    public int getCount() {
        return items.size();
    }
    @Override
    public long getItemId(int position) {
        return position;
    }

    @NonNull
    @Override
    public Filter getFilter() {
        return fruitFilter;
    }
    private Filter fruitFilter = new Filter() {
        @Override
        public CharSequence convertResultToString(Object resultValue) {
            PeopleModel.Sheet fruit = (PeopleModel.Sheet) resultValue;
            return fruit.getNameOfElector();
        }
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            if (charSequence != null) {
                suggestions.clear();
                for (PeopleModel.Sheet fruit: tempItems) {
                    if (fruit.getNameOfElector().toLowerCase().startsWith(charSequence.toString().toLowerCase())) {
                        suggestions.add(fruit);
                    }
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = suggestions;
                filterResults.count = suggestions.size();
                return filterResults;
            } else {
                return new FilterResults();
            }
        }
        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            try {
                ArrayList<PeopleModel.Sheet> tempValues = (ArrayList<PeopleModel.Sheet>) filterResults.values;
                if (filterResults != null && filterResults.count > 0) {
                    clear();
                    for (PeopleModel.Sheet fruitObj : tempValues) {
                        add(fruitObj);
                    }
                    emptyView.setVisibility(View.GONE);
                    notifyDataSetChanged();
                } else {
                    clear();
                    emptyView.setVisibility(View.VISIBLE);
                    notifyDataSetChanged();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
}