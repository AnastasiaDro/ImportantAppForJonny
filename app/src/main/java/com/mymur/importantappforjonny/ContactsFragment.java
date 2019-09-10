package com.mymur.importantappforjonny;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.ListFragment;

public class ContactsFragment extends ListFragment {

    boolean isExistMessageForm;  // Можно ли расположить рядом фрагмент с гербом
    int currentContact = 0;    // Текущая позиция (выбранный контакт)

    //при создании фрагмента укажем его макет
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.contacts_list, container, false);
    }
    // activity создана, можно к ней обращаться. Выполним начальные действия
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

}
