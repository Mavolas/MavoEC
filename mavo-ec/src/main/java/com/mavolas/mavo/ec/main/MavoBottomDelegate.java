package com.mavolas.mavo.ec.main;

import android.graphics.Color;

import com.mavolas.mavo.bottom.BaseBottomDelegate;
import com.mavolas.mavo.bottom.BottomItemDelegate;
import com.mavolas.mavo.bottom.BottonTabBean;
import com.mavolas.mavo.bottom.ItemBuilder;
import com.mavolas.mavo.ec.main.index.IndexDelegate;
import com.mavolas.mavo.ec.main.sort.SortDelegate;

import java.util.LinkedHashMap;

/**
 * Author by Andy
 * Date on 2018/12/25.
 */
public class MavoBottomDelegate extends BaseBottomDelegate {
    @Override
    public LinkedHashMap<BottonTabBean, BottomItemDelegate> setItems(ItemBuilder builder) {
        final LinkedHashMap<BottonTabBean,BottomItemDelegate> items = new LinkedHashMap<>();
        items.put(new BottonTabBean("{fa-home}","主页"), new IndexDelegate());
        items.put(new BottonTabBean("{fa-sort}","分类"), new SortDelegate());
        items.put(new BottonTabBean("{fa-compass}","发现"), new IndexDelegate());
        items.put(new BottonTabBean("{fa-shopping-cart}","购物车"), new IndexDelegate());
        items.put(new BottonTabBean("{fa-user}","我的"), new IndexDelegate());

        return builder.addItems(items).build();
    }

    @Override
    public int setIndexDelegate() {
        return 0;
    }

    @Override
    public int setClickedColor() {
        return Color.parseColor("#ffff8800");
    }
}
