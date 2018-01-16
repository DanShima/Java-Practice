package com.danshima.DressMaking;

import com.danshima.DressMaking.Dress;

public interface DressFormat {
    boolean make(Dress dress);
    String print(Dress dress);
}
