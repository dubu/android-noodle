package com.noodle.abyang.ui;

import android.text.TextUtils;
import android.view.LayoutInflater;

import com.noodle.abyang.R;
import com.noodle.abyang.core.AvatarLoader;
import com.noodle.abyang.core.User;
import com.github.kevinsawicki.wishlist.SingleTypeAdapter;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Adapter to display a list of traffic items
 */
public class UserListAdapter extends SingleTypeAdapter<User> {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("MMMM dd");
    private final AvatarLoader avatars;

    /**
     * @param inflater
     * @param items
     */
    public UserListAdapter(LayoutInflater inflater, List<User> items, AvatarLoader avatars) {
        super(inflater, R.layout.user_list_item);

        this.avatars = avatars;
        setItems(items);
    }

    /**
     * @param inflater
     */
    public UserListAdapter(LayoutInflater inflater, AvatarLoader avatars) {
        this(inflater, null, avatars);

    }

    @Override
    public long getItemId(final int position) {
        final String id = getItem(position).getObjectId();
        return !TextUtils.isEmpty(id) ? id.hashCode() : super
                .getItemId(position);
    }

    @Override
    protected int[] getChildViewIds() {
        return new int[] { R.id.iv_avatar, R.id.tv_name };
    }

    @Override
    protected void update(int position, User user) {

        avatars.bind(imageView(0), user);

        setText(1, String.format("%1$s %2$s", user.getFirstName(), user.getLastName()));

    }

}
