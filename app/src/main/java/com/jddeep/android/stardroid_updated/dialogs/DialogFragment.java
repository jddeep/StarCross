package com.jddeep.android.stardroid_updated.dialogs;

import android.support.v4.app.FragmentManager;

public abstract class DialogFragment extends android.support.v4.app.DialogFragment {
    @Override
    public void show(FragmentManager manager, String tag) {
        if(this.isAdded()) return;
        super.show(manager, tag);
    }
}
