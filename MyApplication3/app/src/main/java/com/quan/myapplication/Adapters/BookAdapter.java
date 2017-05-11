package com.quan.myapplication.Adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import com.quan.myapplication.Entities.Book;
import com.quan.myapplication.R;

import org.apache.commons.lang3.StringUtils;

import java.text.Normalizer;
import java.util.ArrayList;

/**
 * Created by Administrator PC on 25-Apr-17.
 */

public class BookAdapter extends ArrayAdapter {
    private ArrayList<Book> mLstBook;
    private ArrayList<Book> originalList;
    private Context mContext;
    private int mLayoutResource;
    private Filter filter;

    public BookAdapter(Context context, int layoutResource, ArrayList<Book> books) {
        super(context, layoutResource, books);
        this.mContext = context;
        mLstBook = new ArrayList<>(books);
        mLayoutResource = layoutResource;
        originalList = new ArrayList<>(mLstBook);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(mLayoutResource, null);
        Book book = mLstBook.get(position);
        TextView bookName = (TextView) convertView.findViewById(R.id.bookName);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView);
        int drawID = mContext.getResources().getIdentifier(book.getImagePath(), "drawable", mContext.getPackageName());

        imageView.setBackgroundResource(drawID);
        bookName.setText(book.getBookName());
        return convertView;
    }

    @Override
    public Filter getFilter() {
        if (filter == null)
            filter = new BookFilter();
        return filter;
    }

    private class BookFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            // NOTE: this function is *always* called from a background thread, and
            // not the UI thread.
            constraint = constraint.toString().toLowerCase();
            FilterResults result = new FilterResults();
            if (!StringUtils.isBlank(constraint)) {
                ArrayList<Book> filteredItems = new ArrayList<Book>();

                for (Book book : originalList) {
                    String bookName = Normalizer.normalize(book.getBookName(), Normalizer.Form.NFD);
                    if (bookName.toLowerCase().contains(Normalizer.normalize(constraint, Normalizer.Form.NFD).toLowerCase())) {
                        filteredItems.add(book);
                    }
                }
                if(filteredItems.size() == 0)
                {
                    Book book = new Book();
                    book.setBookName("Không tìm thấy sách!");
                    book.setImagePath("This is placeholder text");
                    filteredItems.add(book);
                }
                result.count = filteredItems.size();
                result.values = filteredItems;
            } else {
                synchronized (this) {
                    result.values = originalList;
                    result.count = originalList.size();
                }
            }
            return result;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            // NOTE: this function is *always* called from the UI thread.
            mLstBook = (ArrayList<Book>) results.values;
            notifyDataSetChanged();
            clear();
            for (int i = 0, l = mLstBook.size(); i < l; i++)
                add(mLstBook.get(i));
            notifyDataSetInvalidated();
        }
    }
}
