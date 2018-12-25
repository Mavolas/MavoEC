package com.mavolas.mavo.bottom;

import java.util.LinkedHashMap;

/**
 * Author by Andy
 * Date on 2018/12/25.
 */
public class ItemBuilder {

    private final LinkedHashMap<BottonTabBean, BottomItemDelegate> ITEMS = new LinkedHashMap<>();

    static ItemBuilder builder(){
        return new ItemBuilder();
    }

    public final ItemBuilder addItem(BottonTabBean bean, BottomItemDelegate delegate){
        ITEMS.put(bean,delegate);
        return this;

    }

    public final ItemBuilder addItems(LinkedHashMap<BottonTabBean, BottomItemDelegate> items ){
        ITEMS.putAll(items);
        return this;

    }

    public final LinkedHashMap<BottonTabBean, BottomItemDelegate> build(){
        return ITEMS;
    }


}
