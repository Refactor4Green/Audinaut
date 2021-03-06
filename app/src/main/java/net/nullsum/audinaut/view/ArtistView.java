/*
 This file is part of Subsonic.

 Subsonic is free software: you can redistribute it and/or modify
 it under the terms of the GNU General Public License as published by
 the Free Software Foundation, either version 3 of the License, or
 (at your option) any later version.

 Subsonic is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with Subsonic.  If not, see <http://www.gnu.org/licenses/>.

 Copyright 2009 (C) Sindre Mehus
 */
package net.nullsum.audinaut.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import net.nullsum.audinaut.R;
import net.nullsum.audinaut.domain.Artist;
import net.nullsum.audinaut.util.FileUtil;

import java.io.File;

/**
 * Used to display albums in a {@code ListView}.
 *
 * @author Sindre Mehus
 */
public class ArtistView extends UpdateView<Artist> {

    private final TextView titleView;
    private File file;

    public ArtistView(Context context) {
        super(context, true);
        LayoutInflater.from(context).inflate(R.layout.basic_list_item, this, true);

        titleView = findViewById(R.id.item_name);
        moreButton = findViewById(R.id.item_more);
        moreButton.setOnClickListener(View::showContextMenu);
    }

    protected void setObjectImpl(Artist artist) {
        titleView.setText(artist.getName());
        file = FileUtil.getArtistDirectory(context, artist);
    }

    @Override
    protected void updateBackground() {
        exists = file.exists();
    }

    public File getFile() {
        return file;
    }
}
