package com.mymur.importantappforjonny;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.fragment.app.ListFragment;

import java.lang.reflect.Array;

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
        // Для того, чтобы показать список, надо задействовать адаптер.
// Такая конструкция работает для списков, например ListActivity.
// Здесь создаем из ресурсов список городов (из массива)
        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(), R.array.Contacts, android.R.layout.simple_list_item_activated_1);
        setListAdapter(adapter);
// Определение, можно ли будет расположить рядом герб в другом фрагменте
        // getActivity - получить контекст activity, где расположен фрагмент
        View messageFrame = getActivity().findViewById(R.id.messageTextFragment);
        isExistMessageForm = messageFrame !=null && messageFrame.getVisibility() == View.VISIBLE;

// Если это не повторное создание, то восстановим текущую позицию
    if (savedInstanceState != null) {
        //восстановление текущей позиции (контакта)
        currentContact = savedInstanceState.getInt("CurrentContact", 0);
    }
//Если можно нарисовать рядом фрагмент с текстом, сделаем это
    if (isExistMessageForm){
        getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        showMessageFragment();
    }



    }

//Показать сообщение. Если возможно, то показать рядом со списком контактов,
//Если нет, то открыть вторую activity

    private void showMessageFragment(){
        if (isExistMessageForm){
            //выделим текущий элемент списка
            getListView().setItemChecked(currentContact, true);

            //проверим, что фрагмент с сообщением существует в активити
            SetMessageTextFragment messageTextFragment = (SetMessageTextFragment)
                    getFragmentManager().findFragmentById(R.id.SetMessageTextFragment);

        }
    }

}
