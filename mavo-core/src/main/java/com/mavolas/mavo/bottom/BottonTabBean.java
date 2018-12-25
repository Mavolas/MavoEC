package com.mavolas.mavo.bottom;

/**
 * Author by Andy
 * Date on 2018/12/24.
 */
public class BottonTabBean {

    private final CharSequence ICON;
    private final CharSequence TITLE;


    public BottonTabBean(CharSequence icon, CharSequence title) {
        this.ICON = icon;
        this.TITLE = title;
    }

    public CharSequence getIcon() {
        return ICON;
    }

    public CharSequence getTitle() {
        return TITLE;
    }
}
