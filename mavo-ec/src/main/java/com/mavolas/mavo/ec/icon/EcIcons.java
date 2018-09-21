package com.mavolas.mavo.ec.icon;

import com.joanzapata.iconify.Icon;

/**
 * Created by 宋棋安
 * on 2018/9/21.
 */
public enum  EcIcons  implements Icon{


    plus_circle( '\uE606' ),
    earth('\ue782'),
    image('\ue7de'),
    table('\ue7df'),
    id_card('\ue7e0'),
    highlight('\ue7e1');

    private char character;


    EcIcons(char character) {
        this.character = character;
    }

    @Override
    public String key() {
        return name().replace('_', '-');
    }

    @Override
    public char character() {
        return character;
    }
}
