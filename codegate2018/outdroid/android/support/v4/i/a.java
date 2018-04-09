package android.support.v4.i;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;

public abstract class a implements Parcelable {
    public static final Creator<a> CREATOR = new ClassLoaderCreator<a>() {
        public a a(Parcel parcel) {
            return a(parcel, null);
        }

        public a a(Parcel parcel, ClassLoader classLoader) {
            if (parcel.readParcelable(classLoader) == null) {
                return a.d;
            }
            throw new IllegalStateException("superState must be null");
        }

        public a[] a(int i) {
            return new a[i];
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
            return a(parcel, classLoader);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return a(i);
        }
    };
    public static final a d = new a() {
    };
    private final Parcelable a;

    private a() {
        this.a = null;
    }

    protected a(Parcel parcel, ClassLoader classLoader) {
        Parcelable readParcelable = parcel.readParcelable(classLoader);
        if (readParcelable == null) {
            readParcelable = d;
        }
        this.a = readParcelable;
    }

    protected a(Parcelable parcelable) {
        if (parcelable == null) {
            throw new IllegalArgumentException("superState must not be null");
        }
        if (parcelable == d) {
            parcelable = null;
        }
        this.a = parcelable;
    }

    public final Parcelable a() {
        return this.a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.a, i);
    }
}
