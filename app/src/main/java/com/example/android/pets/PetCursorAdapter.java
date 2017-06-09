package com.example.android.pets;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.android.pets.data.PetContract;

/**
 * Created by simranjain1507 on 17/04/17.
 */

public class PetCursorAdapter extends CursorAdapter {
    public PetCursorAdapter(Context context, Cursor c) {
        super(context, c /*flags*/);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.list_item, parent, false );
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView nameTextView=(TextView) view.findViewById(R.id.name);
        TextView summaryTextView=(TextView) view.findViewById(R.id.summary);

        int nameColumnIndex=cursor.getColumnIndex(PetContract.PetEntry.COLUMN_PET_NAME);
        int breedColumnIndex=cursor.getColumnIndex(PetContract.PetEntry.COLUMN_PET_BREED);

        String name=cursor.getString(nameColumnIndex);
        String summary=cursor.getString(breedColumnIndex);

        if (TextUtils.isEmpty(summary)) {
            summary = context.getString(R.string.unknown_breed);
        }

        nameTextView.setText(name);
        summaryTextView.setText(summary);

    }
}
