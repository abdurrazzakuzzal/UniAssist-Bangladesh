package android.support.p000v4.content.res;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.FontRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.p000v4.content.res.FontResourcesParserCompat.FamilyResourceEntry;
import android.support.p000v4.graphics.TypefaceCompat;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: android.support.v4.content.res.ResourcesCompat */
public final class ResourcesCompat {
    private static final String TAG = "ResourcesCompat";

    @Nullable
    public static Drawable getDrawable(@NonNull Resources res, @DrawableRes int id, @Nullable Theme theme) throws NotFoundException {
        if (VERSION.SDK_INT >= 21) {
            return res.getDrawable(id, theme);
        }
        return res.getDrawable(id);
    }

    @Nullable
    public static Drawable getDrawableForDensity(@NonNull Resources res, @DrawableRes int id, int density, @Nullable Theme theme) throws NotFoundException {
        if (VERSION.SDK_INT >= 21) {
            return res.getDrawableForDensity(id, density, theme);
        }
        if (VERSION.SDK_INT >= 15) {
            return res.getDrawableForDensity(id, density);
        }
        return res.getDrawable(id);
    }

    @ColorInt
    public static int getColor(@NonNull Resources res, @ColorRes int id, @Nullable Theme theme) throws NotFoundException {
        if (VERSION.SDK_INT >= 23) {
            return res.getColor(id, theme);
        }
        return res.getColor(id);
    }

    @Nullable
    public static ColorStateList getColorStateList(@NonNull Resources res, @ColorRes int id, @Nullable Theme theme) throws NotFoundException {
        if (VERSION.SDK_INT >= 23) {
            return res.getColorStateList(id, theme);
        }
        return res.getColorStateList(id);
    }

    @Nullable
    public static Typeface getFont(@NonNull Context context, @FontRes int id) throws NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return loadFont(context, id, new TypedValue(), 0, null);
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public static Typeface getFont(@NonNull Context context, @FontRes int id, TypedValue value, int style, @Nullable TextView targetView) throws NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return loadFont(context, id, value, style, targetView);
    }

    private static Typeface loadFont(@NonNull Context context, int id, TypedValue value, int style, @Nullable TextView targetView) {
        Resources resources = context.getResources();
        resources.getValue(id, value, true);
        Typeface typeface = loadFont(context, resources, value, id, style, targetView);
        if (typeface != null) {
            return typeface;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Font resource ID #0x");
        sb.append(Integer.toHexString(id));
        throw new NotFoundException(sb.toString());
    }

    private static Typeface loadFont(@NonNull Context context, Resources wrapper, TypedValue value, int id, int style, @Nullable TextView targetView) {
        Resources resources = wrapper;
        TypedValue typedValue = value;
        int i = id;
        int i2 = style;
        if (typedValue.string == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Resource \"");
            sb.append(resources.getResourceName(i));
            sb.append("\" (");
            sb.append(Integer.toHexString(id));
            sb.append(") is not a Font: ");
            sb.append(typedValue);
            throw new NotFoundException(sb.toString());
        }
        String file = typedValue.string.toString();
        if (!file.startsWith("res/")) {
            return null;
        }
        Typeface cached = TypefaceCompat.findFromCache(resources, i, i2);
        if (cached != null) {
            return cached;
        }
        try {
            if (file.toLowerCase().endsWith(".xml")) {
                FamilyResourceEntry familyEntry = FontResourcesParserCompat.parse(resources.getXml(i), resources);
                if (familyEntry != null) {
                    return TypefaceCompat.createFromResourcesFamilyXml(context, familyEntry, resources, i, i2, targetView);
                }
                Log.e(TAG, "Failed to find font-family tag");
                return null;
            }
            try {
                return TypefaceCompat.createFromResourcesFontFile(context, resources, i, file, i2);
            } catch (XmlPullParserException e) {
                e = e;
                XmlPullParserException e2 = e;
                String str = TAG;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Failed to parse xml resource ");
                sb2.append(file);
                Log.e(str, sb2.toString(), e2);
                return null;
            } catch (IOException e3) {
                e = e3;
                IOException e4 = e;
                String str2 = TAG;
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Failed to read xml resource ");
                sb3.append(file);
                Log.e(str2, sb3.toString(), e4);
                return null;
            }
        } catch (XmlPullParserException e5) {
            e = e5;
            Context context2 = context;
            XmlPullParserException e22 = e;
            String str3 = TAG;
            StringBuilder sb22 = new StringBuilder();
            sb22.append("Failed to parse xml resource ");
            sb22.append(file);
            Log.e(str3, sb22.toString(), e22);
            return null;
        } catch (IOException e6) {
            e = e6;
            Context context3 = context;
            IOException e42 = e;
            String str22 = TAG;
            StringBuilder sb32 = new StringBuilder();
            sb32.append("Failed to read xml resource ");
            sb32.append(file);
            Log.e(str22, sb32.toString(), e42);
            return null;
        }
    }

    private ResourcesCompat() {
    }
}
