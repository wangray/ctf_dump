package android.support.v4.i;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;

public interface p {
    ColorStateList getSupportBackgroundTintList();

    Mode getSupportBackgroundTintMode();

    void setSupportBackgroundTintList(ColorStateList colorStateList);

    void setSupportBackgroundTintMode(Mode mode);
}
