package android.support.p000v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.compat.C0004R;
import android.support.p000v4.app.NotificationCompatBase.Action.Factory;
import android.support.p000v4.app.NotificationCompatBase.UnreadConversation;
import android.support.p000v4.app.RemoteInputCompatBase.RemoteInput;
import android.support.p000v4.text.BidiFormatter;
import android.support.p000v4.view.ViewCompat;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.widget.RemoteViews;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* renamed from: android.support.v4.app.NotificationCompat */
public class NotificationCompat {
    public static final int BADGE_ICON_LARGE = 2;
    public static final int BADGE_ICON_NONE = 0;
    public static final int BADGE_ICON_SMALL = 1;
    public static final String CATEGORY_ALARM = "alarm";
    public static final String CATEGORY_CALL = "call";
    public static final String CATEGORY_EMAIL = "email";
    public static final String CATEGORY_ERROR = "err";
    public static final String CATEGORY_EVENT = "event";
    public static final String CATEGORY_MESSAGE = "msg";
    public static final String CATEGORY_PROGRESS = "progress";
    public static final String CATEGORY_PROMO = "promo";
    public static final String CATEGORY_RECOMMENDATION = "recommendation";
    public static final String CATEGORY_REMINDER = "reminder";
    public static final String CATEGORY_SERVICE = "service";
    public static final String CATEGORY_SOCIAL = "social";
    public static final String CATEGORY_STATUS = "status";
    public static final String CATEGORY_SYSTEM = "sys";
    public static final String CATEGORY_TRANSPORT = "transport";
    @ColorInt
    public static final int COLOR_DEFAULT = 0;
    public static final int DEFAULT_ALL = -1;
    public static final int DEFAULT_LIGHTS = 4;
    public static final int DEFAULT_SOUND = 1;
    public static final int DEFAULT_VIBRATE = 2;
    public static final String EXTRA_AUDIO_CONTENTS_URI = "android.audioContents";
    public static final String EXTRA_BACKGROUND_IMAGE_URI = "android.backgroundImageUri";
    public static final String EXTRA_BIG_TEXT = "android.bigText";
    public static final String EXTRA_COMPACT_ACTIONS = "android.compactActions";
    public static final String EXTRA_CONVERSATION_TITLE = "android.conversationTitle";
    public static final String EXTRA_INFO_TEXT = "android.infoText";
    public static final String EXTRA_LARGE_ICON = "android.largeIcon";
    public static final String EXTRA_LARGE_ICON_BIG = "android.largeIcon.big";
    public static final String EXTRA_MEDIA_SESSION = "android.mediaSession";
    public static final String EXTRA_MESSAGES = "android.messages";
    public static final String EXTRA_PEOPLE = "android.people";
    public static final String EXTRA_PICTURE = "android.picture";
    public static final String EXTRA_PROGRESS = "android.progress";
    public static final String EXTRA_PROGRESS_INDETERMINATE = "android.progressIndeterminate";
    public static final String EXTRA_PROGRESS_MAX = "android.progressMax";
    public static final String EXTRA_REMOTE_INPUT_HISTORY = "android.remoteInputHistory";
    public static final String EXTRA_SELF_DISPLAY_NAME = "android.selfDisplayName";
    public static final String EXTRA_SHOW_CHRONOMETER = "android.showChronometer";
    public static final String EXTRA_SHOW_WHEN = "android.showWhen";
    public static final String EXTRA_SMALL_ICON = "android.icon";
    public static final String EXTRA_SUB_TEXT = "android.subText";
    public static final String EXTRA_SUMMARY_TEXT = "android.summaryText";
    public static final String EXTRA_TEMPLATE = "android.template";
    public static final String EXTRA_TEXT = "android.text";
    public static final String EXTRA_TEXT_LINES = "android.textLines";
    public static final String EXTRA_TITLE = "android.title";
    public static final String EXTRA_TITLE_BIG = "android.title.big";
    public static final int FLAG_AUTO_CANCEL = 16;
    public static final int FLAG_FOREGROUND_SERVICE = 64;
    public static final int FLAG_GROUP_SUMMARY = 512;
    @Deprecated
    public static final int FLAG_HIGH_PRIORITY = 128;
    public static final int FLAG_INSISTENT = 4;
    public static final int FLAG_LOCAL_ONLY = 256;
    public static final int FLAG_NO_CLEAR = 32;
    public static final int FLAG_ONGOING_EVENT = 2;
    public static final int FLAG_ONLY_ALERT_ONCE = 8;
    public static final int FLAG_SHOW_LIGHTS = 1;
    public static final int GROUP_ALERT_ALL = 0;
    public static final int GROUP_ALERT_CHILDREN = 2;
    public static final int GROUP_ALERT_SUMMARY = 1;
    static final NotificationCompatImpl IMPL;
    public static final int PRIORITY_DEFAULT = 0;
    public static final int PRIORITY_HIGH = 1;
    public static final int PRIORITY_LOW = -1;
    public static final int PRIORITY_MAX = 2;
    public static final int PRIORITY_MIN = -2;
    public static final int STREAM_DEFAULT = -1;
    public static final int VISIBILITY_PRIVATE = 0;
    public static final int VISIBILITY_PUBLIC = 1;
    public static final int VISIBILITY_SECRET = -1;

    /* renamed from: android.support.v4.app.NotificationCompat$Action */
    public static class Action extends android.support.p000v4.app.NotificationCompatBase.Action {
        @RestrictTo({Scope.LIBRARY_GROUP})
        public static final Factory FACTORY = new Factory() {
            public android.support.p000v4.app.NotificationCompatBase.Action build(int icon, CharSequence title, PendingIntent actionIntent, Bundle extras, RemoteInput[] remoteInputs, RemoteInput[] dataOnlyRemoteInputs, boolean allowGeneratedReplies) {
                Action action = new Action(icon, title, actionIntent, extras, (RemoteInput[]) remoteInputs, (RemoteInput[]) dataOnlyRemoteInputs, allowGeneratedReplies);
                return action;
            }

            public Action[] newArray(int length) {
                return new Action[length];
            }
        };
        public PendingIntent actionIntent;
        public int icon;
        private boolean mAllowGeneratedReplies;
        private final RemoteInput[] mDataOnlyRemoteInputs;
        final Bundle mExtras;
        private final RemoteInput[] mRemoteInputs;
        public CharSequence title;

        /* renamed from: android.support.v4.app.NotificationCompat$Action$Builder */
        public static final class Builder {
            private boolean mAllowGeneratedReplies;
            private final Bundle mExtras;
            private final int mIcon;
            private final PendingIntent mIntent;
            private ArrayList<RemoteInput> mRemoteInputs;
            private final CharSequence mTitle;

            public Builder(int icon, CharSequence title, PendingIntent intent) {
                this(icon, title, intent, new Bundle(), null, true);
            }

            public Builder(Action action) {
                this(action.icon, action.title, action.actionIntent, new Bundle(action.mExtras), action.getRemoteInputs(), action.getAllowGeneratedReplies());
            }

            private Builder(int icon, CharSequence title, PendingIntent intent, Bundle extras, RemoteInput[] remoteInputs, boolean allowGeneratedReplies) {
                ArrayList<RemoteInput> arrayList;
                this.mAllowGeneratedReplies = true;
                this.mIcon = icon;
                this.mTitle = Builder.limitCharSequenceLength(title);
                this.mIntent = intent;
                this.mExtras = extras;
                if (remoteInputs == null) {
                    arrayList = null;
                } else {
                    arrayList = new ArrayList<>(Arrays.asList(remoteInputs));
                }
                this.mRemoteInputs = arrayList;
                this.mAllowGeneratedReplies = allowGeneratedReplies;
            }

            public Builder addExtras(Bundle extras) {
                if (extras != null) {
                    this.mExtras.putAll(extras);
                }
                return this;
            }

            public Bundle getExtras() {
                return this.mExtras;
            }

            public Builder addRemoteInput(RemoteInput remoteInput) {
                if (this.mRemoteInputs == null) {
                    this.mRemoteInputs = new ArrayList<>();
                }
                this.mRemoteInputs.add(remoteInput);
                return this;
            }

            public Builder setAllowGeneratedReplies(boolean allowGeneratedReplies) {
                this.mAllowGeneratedReplies = allowGeneratedReplies;
                return this;
            }

            public Builder extend(Extender extender) {
                extender.extend(this);
                return this;
            }

            public Action build() {
                List<RemoteInput> dataOnlyInputs = new ArrayList<>();
                List<RemoteInput> textInputs = new ArrayList<>();
                if (this.mRemoteInputs != null) {
                    Iterator it = this.mRemoteInputs.iterator();
                    while (it.hasNext()) {
                        RemoteInput input = (RemoteInput) it.next();
                        if (input.isDataOnly()) {
                            dataOnlyInputs.add(input);
                        } else {
                            textInputs.add(input);
                        }
                    }
                }
                RemoteInput[] remoteInputArr = null;
                RemoteInput[] dataOnlyInputsArr = dataOnlyInputs.isEmpty() ? null : (RemoteInput[]) dataOnlyInputs.toArray(new RemoteInput[dataOnlyInputs.size()]);
                if (!textInputs.isEmpty()) {
                    remoteInputArr = (RemoteInput[]) textInputs.toArray(new RemoteInput[textInputs.size()]);
                }
                Action action = new Action(this.mIcon, this.mTitle, this.mIntent, this.mExtras, remoteInputArr, dataOnlyInputsArr, this.mAllowGeneratedReplies);
                return action;
            }
        }

        /* renamed from: android.support.v4.app.NotificationCompat$Action$Extender */
        public interface Extender {
            Builder extend(Builder builder);
        }

        /* renamed from: android.support.v4.app.NotificationCompat$Action$WearableExtender */
        public static final class WearableExtender implements Extender {
            private static final int DEFAULT_FLAGS = 1;
            private static final String EXTRA_WEARABLE_EXTENSIONS = "android.wearable.EXTENSIONS";
            private static final int FLAG_AVAILABLE_OFFLINE = 1;
            private static final int FLAG_HINT_DISPLAY_INLINE = 4;
            private static final int FLAG_HINT_LAUNCHES_ACTIVITY = 2;
            private static final String KEY_CANCEL_LABEL = "cancelLabel";
            private static final String KEY_CONFIRM_LABEL = "confirmLabel";
            private static final String KEY_FLAGS = "flags";
            private static final String KEY_IN_PROGRESS_LABEL = "inProgressLabel";
            private CharSequence mCancelLabel;
            private CharSequence mConfirmLabel;
            private int mFlags = 1;
            private CharSequence mInProgressLabel;

            public WearableExtender() {
            }

            public WearableExtender(Action action) {
                Bundle wearableBundle = action.getExtras().getBundle(EXTRA_WEARABLE_EXTENSIONS);
                if (wearableBundle != null) {
                    this.mFlags = wearableBundle.getInt(KEY_FLAGS, 1);
                    this.mInProgressLabel = wearableBundle.getCharSequence(KEY_IN_PROGRESS_LABEL);
                    this.mConfirmLabel = wearableBundle.getCharSequence(KEY_CONFIRM_LABEL);
                    this.mCancelLabel = wearableBundle.getCharSequence(KEY_CANCEL_LABEL);
                }
            }

            public Builder extend(Builder builder) {
                Bundle wearableBundle = new Bundle();
                if (this.mFlags != 1) {
                    wearableBundle.putInt(KEY_FLAGS, this.mFlags);
                }
                if (this.mInProgressLabel != null) {
                    wearableBundle.putCharSequence(KEY_IN_PROGRESS_LABEL, this.mInProgressLabel);
                }
                if (this.mConfirmLabel != null) {
                    wearableBundle.putCharSequence(KEY_CONFIRM_LABEL, this.mConfirmLabel);
                }
                if (this.mCancelLabel != null) {
                    wearableBundle.putCharSequence(KEY_CANCEL_LABEL, this.mCancelLabel);
                }
                builder.getExtras().putBundle(EXTRA_WEARABLE_EXTENSIONS, wearableBundle);
                return builder;
            }

            public WearableExtender clone() {
                WearableExtender that = new WearableExtender();
                that.mFlags = this.mFlags;
                that.mInProgressLabel = this.mInProgressLabel;
                that.mConfirmLabel = this.mConfirmLabel;
                that.mCancelLabel = this.mCancelLabel;
                return that;
            }

            public WearableExtender setAvailableOffline(boolean availableOffline) {
                setFlag(1, availableOffline);
                return this;
            }

            public boolean isAvailableOffline() {
                return (this.mFlags & 1) != 0;
            }

            private void setFlag(int mask, boolean value) {
                if (value) {
                    this.mFlags |= mask;
                } else {
                    this.mFlags &= mask ^ -1;
                }
            }

            public WearableExtender setInProgressLabel(CharSequence label) {
                this.mInProgressLabel = label;
                return this;
            }

            public CharSequence getInProgressLabel() {
                return this.mInProgressLabel;
            }

            public WearableExtender setConfirmLabel(CharSequence label) {
                this.mConfirmLabel = label;
                return this;
            }

            public CharSequence getConfirmLabel() {
                return this.mConfirmLabel;
            }

            public WearableExtender setCancelLabel(CharSequence label) {
                this.mCancelLabel = label;
                return this;
            }

            public CharSequence getCancelLabel() {
                return this.mCancelLabel;
            }

            public WearableExtender setHintLaunchesActivity(boolean hintLaunchesActivity) {
                setFlag(2, hintLaunchesActivity);
                return this;
            }

            public boolean getHintLaunchesActivity() {
                return (this.mFlags & 2) != 0;
            }

            public WearableExtender setHintDisplayActionInline(boolean hintDisplayInline) {
                setFlag(4, hintDisplayInline);
                return this;
            }

            public boolean getHintDisplayActionInline() {
                return (this.mFlags & 4) != 0;
            }
        }

        public Action(int icon2, CharSequence title2, PendingIntent intent) {
            this(icon2, title2, intent, new Bundle(), null, null, true);
        }

        Action(int icon2, CharSequence title2, PendingIntent intent, Bundle extras, RemoteInput[] remoteInputs, RemoteInput[] dataOnlyRemoteInputs, boolean allowGeneratedReplies) {
            this.icon = icon2;
            this.title = Builder.limitCharSequenceLength(title2);
            this.actionIntent = intent;
            this.mExtras = extras != null ? extras : new Bundle();
            this.mRemoteInputs = remoteInputs;
            this.mDataOnlyRemoteInputs = dataOnlyRemoteInputs;
            this.mAllowGeneratedReplies = allowGeneratedReplies;
        }

        public int getIcon() {
            return this.icon;
        }

        public CharSequence getTitle() {
            return this.title;
        }

        public PendingIntent getActionIntent() {
            return this.actionIntent;
        }

        public Bundle getExtras() {
            return this.mExtras;
        }

        public boolean getAllowGeneratedReplies() {
            return this.mAllowGeneratedReplies;
        }

        public RemoteInput[] getRemoteInputs() {
            return this.mRemoteInputs;
        }

        public RemoteInput[] getDataOnlyRemoteInputs() {
            return this.mDataOnlyRemoteInputs;
        }
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: android.support.v4.app.NotificationCompat$BadgeIconType */
    public @interface BadgeIconType {
    }

    /* renamed from: android.support.v4.app.NotificationCompat$BigPictureStyle */
    public static class BigPictureStyle extends Style {
        private Bitmap mBigLargeIcon;
        private boolean mBigLargeIconSet;
        private Bitmap mPicture;

        public BigPictureStyle() {
        }

        public BigPictureStyle(Builder builder) {
            setBuilder(builder);
        }

        public BigPictureStyle setBigContentTitle(CharSequence title) {
            this.mBigContentTitle = Builder.limitCharSequenceLength(title);
            return this;
        }

        public BigPictureStyle setSummaryText(CharSequence cs) {
            this.mSummaryText = Builder.limitCharSequenceLength(cs);
            this.mSummaryTextSet = true;
            return this;
        }

        public BigPictureStyle bigPicture(Bitmap b) {
            this.mPicture = b;
            return this;
        }

        public BigPictureStyle bigLargeIcon(Bitmap b) {
            this.mBigLargeIcon = b;
            this.mBigLargeIconSet = true;
            return this;
        }

        @RestrictTo({Scope.LIBRARY_GROUP})
        public void apply(NotificationBuilderWithBuilderAccessor builder) {
            if (VERSION.SDK_INT >= 16) {
                NotificationCompatJellybean.addBigPictureStyle(builder, this.mBigContentTitle, this.mSummaryTextSet, this.mSummaryText, this.mPicture, this.mBigLargeIcon, this.mBigLargeIconSet);
            }
        }
    }

    /* renamed from: android.support.v4.app.NotificationCompat$BigTextStyle */
    public static class BigTextStyle extends Style {
        private CharSequence mBigText;

        public BigTextStyle() {
        }

        public BigTextStyle(Builder builder) {
            setBuilder(builder);
        }

        public BigTextStyle setBigContentTitle(CharSequence title) {
            this.mBigContentTitle = Builder.limitCharSequenceLength(title);
            return this;
        }

        public BigTextStyle setSummaryText(CharSequence cs) {
            this.mSummaryText = Builder.limitCharSequenceLength(cs);
            this.mSummaryTextSet = true;
            return this;
        }

        public BigTextStyle bigText(CharSequence cs) {
            this.mBigText = Builder.limitCharSequenceLength(cs);
            return this;
        }

        @RestrictTo({Scope.LIBRARY_GROUP})
        public void apply(NotificationBuilderWithBuilderAccessor builder) {
            if (VERSION.SDK_INT >= 16) {
                NotificationCompatJellybean.addBigTextStyle(builder, this.mBigContentTitle, this.mSummaryTextSet, this.mSummaryText, this.mBigText);
            }
        }
    }

    /* renamed from: android.support.v4.app.NotificationCompat$Builder */
    public static class Builder {
        private static final int MAX_CHARSEQUENCE_LENGTH = 5120;
        @RestrictTo({Scope.LIBRARY_GROUP})
        public ArrayList<Action> mActions;
        int mBadgeIcon;
        RemoteViews mBigContentView;
        String mCategory;
        String mChannelId;
        int mColor;
        boolean mColorized;
        boolean mColorizedSet;
        @RestrictTo({Scope.LIBRARY_GROUP})
        public CharSequence mContentInfo;
        PendingIntent mContentIntent;
        @RestrictTo({Scope.LIBRARY_GROUP})
        public CharSequence mContentText;
        @RestrictTo({Scope.LIBRARY_GROUP})
        public CharSequence mContentTitle;
        RemoteViews mContentView;
        @RestrictTo({Scope.LIBRARY_GROUP})
        public Context mContext;
        Bundle mExtras;
        PendingIntent mFullScreenIntent;
        /* access modifiers changed from: private */
        public int mGroupAlertBehavior;
        String mGroupKey;
        boolean mGroupSummary;
        RemoteViews mHeadsUpContentView;
        @RestrictTo({Scope.LIBRARY_GROUP})
        public Bitmap mLargeIcon;
        boolean mLocalOnly;
        @RestrictTo({Scope.LIBRARY_GROUP})
        public Notification mNotification;
        @RestrictTo({Scope.LIBRARY_GROUP})
        public int mNumber;
        public ArrayList<String> mPeople;
        int mPriority;
        int mProgress;
        boolean mProgressIndeterminate;
        int mProgressMax;
        Notification mPublicVersion;
        @RestrictTo({Scope.LIBRARY_GROUP})
        public CharSequence[] mRemoteInputHistory;
        String mShortcutId;
        boolean mShowWhen;
        String mSortKey;
        @RestrictTo({Scope.LIBRARY_GROUP})
        public Style mStyle;
        @RestrictTo({Scope.LIBRARY_GROUP})
        public CharSequence mSubText;
        RemoteViews mTickerView;
        long mTimeout;
        @RestrictTo({Scope.LIBRARY_GROUP})
        public boolean mUseChronometer;
        int mVisibility;

        public Builder(@NonNull Context context, @NonNull String channelId) {
            this.mShowWhen = true;
            this.mActions = new ArrayList<>();
            this.mLocalOnly = false;
            this.mColor = 0;
            this.mVisibility = 0;
            this.mBadgeIcon = 0;
            this.mGroupAlertBehavior = 0;
            this.mNotification = new Notification();
            this.mContext = context;
            this.mChannelId = channelId;
            this.mNotification.when = System.currentTimeMillis();
            this.mNotification.audioStreamType = -1;
            this.mPriority = 0;
            this.mPeople = new ArrayList<>();
        }

        @Deprecated
        public Builder(Context context) {
            this(context, null);
        }

        public Builder setWhen(long when) {
            this.mNotification.when = when;
            return this;
        }

        public Builder setShowWhen(boolean show) {
            this.mShowWhen = show;
            return this;
        }

        public Builder setUsesChronometer(boolean b) {
            this.mUseChronometer = b;
            return this;
        }

        public Builder setSmallIcon(int icon) {
            this.mNotification.icon = icon;
            return this;
        }

        public Builder setSmallIcon(int icon, int level) {
            this.mNotification.icon = icon;
            this.mNotification.iconLevel = level;
            return this;
        }

        public Builder setContentTitle(CharSequence title) {
            this.mContentTitle = limitCharSequenceLength(title);
            return this;
        }

        public Builder setContentText(CharSequence text) {
            this.mContentText = limitCharSequenceLength(text);
            return this;
        }

        public Builder setSubText(CharSequence text) {
            this.mSubText = limitCharSequenceLength(text);
            return this;
        }

        public Builder setRemoteInputHistory(CharSequence[] text) {
            this.mRemoteInputHistory = text;
            return this;
        }

        public Builder setNumber(int number) {
            this.mNumber = number;
            return this;
        }

        public Builder setContentInfo(CharSequence info) {
            this.mContentInfo = limitCharSequenceLength(info);
            return this;
        }

        public Builder setProgress(int max, int progress, boolean indeterminate) {
            this.mProgressMax = max;
            this.mProgress = progress;
            this.mProgressIndeterminate = indeterminate;
            return this;
        }

        public Builder setContent(RemoteViews views) {
            this.mNotification.contentView = views;
            return this;
        }

        public Builder setContentIntent(PendingIntent intent) {
            this.mContentIntent = intent;
            return this;
        }

        public Builder setDeleteIntent(PendingIntent intent) {
            this.mNotification.deleteIntent = intent;
            return this;
        }

        public Builder setFullScreenIntent(PendingIntent intent, boolean highPriority) {
            this.mFullScreenIntent = intent;
            setFlag(128, highPriority);
            return this;
        }

        public Builder setTicker(CharSequence tickerText) {
            this.mNotification.tickerText = limitCharSequenceLength(tickerText);
            return this;
        }

        public Builder setTicker(CharSequence tickerText, RemoteViews views) {
            this.mNotification.tickerText = limitCharSequenceLength(tickerText);
            this.mTickerView = views;
            return this;
        }

        public Builder setLargeIcon(Bitmap icon) {
            this.mLargeIcon = icon;
            return this;
        }

        public Builder setSound(Uri sound) {
            this.mNotification.sound = sound;
            this.mNotification.audioStreamType = -1;
            return this;
        }

        public Builder setSound(Uri sound, int streamType) {
            this.mNotification.sound = sound;
            this.mNotification.audioStreamType = streamType;
            return this;
        }

        public Builder setVibrate(long[] pattern) {
            this.mNotification.vibrate = pattern;
            return this;
        }

        public Builder setLights(@ColorInt int argb, int onMs, int offMs) {
            this.mNotification.ledARGB = argb;
            this.mNotification.ledOnMS = onMs;
            this.mNotification.ledOffMS = offMs;
            int i = 0;
            boolean showLights = (this.mNotification.ledOnMS == 0 || this.mNotification.ledOffMS == 0) ? false : true;
            Notification notification = this.mNotification;
            int i2 = this.mNotification.flags & -2;
            if (showLights) {
                i = 1;
            }
            notification.flags = i | i2;
            return this;
        }

        public Builder setOngoing(boolean ongoing) {
            setFlag(2, ongoing);
            return this;
        }

        public Builder setColorized(boolean colorize) {
            this.mColorized = colorize;
            this.mColorizedSet = true;
            return this;
        }

        public Builder setOnlyAlertOnce(boolean onlyAlertOnce) {
            setFlag(8, onlyAlertOnce);
            return this;
        }

        public Builder setAutoCancel(boolean autoCancel) {
            setFlag(16, autoCancel);
            return this;
        }

        public Builder setLocalOnly(boolean b) {
            this.mLocalOnly = b;
            return this;
        }

        public Builder setCategory(String category) {
            this.mCategory = category;
            return this;
        }

        public Builder setDefaults(int defaults) {
            this.mNotification.defaults = defaults;
            if ((defaults & 4) != 0) {
                this.mNotification.flags |= 1;
            }
            return this;
        }

        private void setFlag(int mask, boolean value) {
            if (value) {
                this.mNotification.flags |= mask;
                return;
            }
            this.mNotification.flags &= mask ^ -1;
        }

        public Builder setPriority(int pri) {
            this.mPriority = pri;
            return this;
        }

        public Builder addPerson(String uri) {
            this.mPeople.add(uri);
            return this;
        }

        public Builder setGroup(String groupKey) {
            this.mGroupKey = groupKey;
            return this;
        }

        public Builder setGroupSummary(boolean isGroupSummary) {
            this.mGroupSummary = isGroupSummary;
            return this;
        }

        public Builder setSortKey(String sortKey) {
            this.mSortKey = sortKey;
            return this;
        }

        public Builder addExtras(Bundle extras) {
            if (extras != null) {
                if (this.mExtras == null) {
                    this.mExtras = new Bundle(extras);
                } else {
                    this.mExtras.putAll(extras);
                }
            }
            return this;
        }

        public Builder setExtras(Bundle extras) {
            this.mExtras = extras;
            return this;
        }

        public Bundle getExtras() {
            if (this.mExtras == null) {
                this.mExtras = new Bundle();
            }
            return this.mExtras;
        }

        public Builder addAction(int icon, CharSequence title, PendingIntent intent) {
            this.mActions.add(new Action(icon, title, intent));
            return this;
        }

        public Builder addAction(Action action) {
            this.mActions.add(action);
            return this;
        }

        public Builder setStyle(Style style) {
            if (this.mStyle != style) {
                this.mStyle = style;
                if (this.mStyle != null) {
                    this.mStyle.setBuilder(this);
                }
            }
            return this;
        }

        public Builder setColor(@ColorInt int argb) {
            this.mColor = argb;
            return this;
        }

        public Builder setVisibility(int visibility) {
            this.mVisibility = visibility;
            return this;
        }

        public Builder setPublicVersion(Notification n) {
            this.mPublicVersion = n;
            return this;
        }

        public Builder setCustomContentView(RemoteViews contentView) {
            this.mContentView = contentView;
            return this;
        }

        public Builder setCustomBigContentView(RemoteViews contentView) {
            this.mBigContentView = contentView;
            return this;
        }

        public Builder setCustomHeadsUpContentView(RemoteViews contentView) {
            this.mHeadsUpContentView = contentView;
            return this;
        }

        public Builder setChannelId(@NonNull String channelId) {
            this.mChannelId = channelId;
            return this;
        }

        public Builder setTimeoutAfter(long durationMs) {
            this.mTimeout = durationMs;
            return this;
        }

        public Builder setShortcutId(String shortcutId) {
            this.mShortcutId = shortcutId;
            return this;
        }

        public Builder setBadgeIconType(int icon) {
            this.mBadgeIcon = icon;
            return this;
        }

        public Builder setGroupAlertBehavior(int groupAlertBehavior) {
            this.mGroupAlertBehavior = groupAlertBehavior;
            return this;
        }

        public Builder extend(Extender extender) {
            extender.extend(this);
            return this;
        }

        @Deprecated
        public Notification getNotification() {
            return build();
        }

        public Notification build() {
            return NotificationCompat.IMPL.build(this, getExtender());
        }

        /* access modifiers changed from: protected */
        @RestrictTo({Scope.LIBRARY_GROUP})
        public BuilderExtender getExtender() {
            return new BuilderExtender();
        }

        protected static CharSequence limitCharSequenceLength(CharSequence cs) {
            if (cs == null) {
                return cs;
            }
            if (cs.length() > MAX_CHARSEQUENCE_LENGTH) {
                cs = cs.subSequence(0, MAX_CHARSEQUENCE_LENGTH);
            }
            return cs;
        }

        @RestrictTo({Scope.LIBRARY_GROUP})
        public RemoteViews getContentView() {
            return this.mContentView;
        }

        @RestrictTo({Scope.LIBRARY_GROUP})
        public RemoteViews getBigContentView() {
            return this.mBigContentView;
        }

        @RestrictTo({Scope.LIBRARY_GROUP})
        public RemoteViews getHeadsUpContentView() {
            return this.mHeadsUpContentView;
        }

        @RestrictTo({Scope.LIBRARY_GROUP})
        public long getWhenIfShowing() {
            if (this.mShowWhen) {
                return this.mNotification.when;
            }
            return 0;
        }

        @RestrictTo({Scope.LIBRARY_GROUP})
        public int getPriority() {
            return this.mPriority;
        }

        @RestrictTo({Scope.LIBRARY_GROUP})
        public int getColor() {
            return this.mColor;
        }
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    /* renamed from: android.support.v4.app.NotificationCompat$BuilderExtender */
    protected static class BuilderExtender {
        protected BuilderExtender() {
        }

        public Notification build(Builder b, NotificationBuilderWithBuilderAccessor builder) {
            RemoteViews styleContentView = b.mStyle != null ? b.mStyle.makeContentView(builder) : null;
            Notification n = builder.build();
            if (styleContentView != null) {
                n.contentView = styleContentView;
            } else if (b.mContentView != null) {
                n.contentView = b.mContentView;
            }
            if (VERSION.SDK_INT >= 16 && b.mStyle != null) {
                RemoteViews styleBigContentView = b.mStyle.makeBigContentView(builder);
                if (styleBigContentView != null) {
                    n.bigContentView = styleBigContentView;
                }
            }
            if (VERSION.SDK_INT >= 21 && b.mStyle != null) {
                RemoteViews styleHeadsUpContentView = b.mStyle.makeHeadsUpContentView(builder);
                if (styleHeadsUpContentView != null) {
                    n.headsUpContentView = styleHeadsUpContentView;
                }
            }
            return n;
        }
    }

    /* renamed from: android.support.v4.app.NotificationCompat$CarExtender */
    public static final class CarExtender implements Extender {
        private static final String EXTRA_CAR_EXTENDER = "android.car.EXTENSIONS";
        private static final String EXTRA_COLOR = "app_color";
        private static final String EXTRA_CONVERSATION = "car_conversation";
        private static final String EXTRA_LARGE_ICON = "large_icon";
        private static final String TAG = "CarExtender";
        private int mColor = 0;
        private Bitmap mLargeIcon;
        private UnreadConversation mUnreadConversation;

        /* renamed from: android.support.v4.app.NotificationCompat$CarExtender$UnreadConversation */
        public static class UnreadConversation extends android.support.p000v4.app.NotificationCompatBase.UnreadConversation {
            static final android.support.p000v4.app.NotificationCompatBase.UnreadConversation.Factory FACTORY = new android.support.p000v4.app.NotificationCompatBase.UnreadConversation.Factory() {
                public UnreadConversation build(String[] messages, RemoteInput remoteInput, PendingIntent replyPendingIntent, PendingIntent readPendingIntent, String[] participants, long latestTimestamp) {
                    UnreadConversation unreadConversation = new UnreadConversation(messages, (RemoteInput) remoteInput, replyPendingIntent, readPendingIntent, participants, latestTimestamp);
                    return unreadConversation;
                }
            };
            private final long mLatestTimestamp;
            private final String[] mMessages;
            private final String[] mParticipants;
            private final PendingIntent mReadPendingIntent;
            private final RemoteInput mRemoteInput;
            private final PendingIntent mReplyPendingIntent;

            /* renamed from: android.support.v4.app.NotificationCompat$CarExtender$UnreadConversation$Builder */
            public static class Builder {
                private long mLatestTimestamp;
                private final List<String> mMessages = new ArrayList();
                private final String mParticipant;
                private PendingIntent mReadPendingIntent;
                private RemoteInput mRemoteInput;
                private PendingIntent mReplyPendingIntent;

                public Builder(String name) {
                    this.mParticipant = name;
                }

                public Builder addMessage(String message) {
                    this.mMessages.add(message);
                    return this;
                }

                public Builder setReplyAction(PendingIntent pendingIntent, RemoteInput remoteInput) {
                    this.mRemoteInput = remoteInput;
                    this.mReplyPendingIntent = pendingIntent;
                    return this;
                }

                public Builder setReadPendingIntent(PendingIntent pendingIntent) {
                    this.mReadPendingIntent = pendingIntent;
                    return this;
                }

                public Builder setLatestTimestamp(long timestamp) {
                    this.mLatestTimestamp = timestamp;
                    return this;
                }

                public UnreadConversation build() {
                    String[] strArr = (String[]) this.mMessages.toArray(new String[this.mMessages.size()]);
                    UnreadConversation unreadConversation = new UnreadConversation(strArr, this.mRemoteInput, this.mReplyPendingIntent, this.mReadPendingIntent, new String[]{this.mParticipant}, this.mLatestTimestamp);
                    return unreadConversation;
                }
            }

            UnreadConversation(String[] messages, RemoteInput remoteInput, PendingIntent replyPendingIntent, PendingIntent readPendingIntent, String[] participants, long latestTimestamp) {
                this.mMessages = messages;
                this.mRemoteInput = remoteInput;
                this.mReadPendingIntent = readPendingIntent;
                this.mReplyPendingIntent = replyPendingIntent;
                this.mParticipants = participants;
                this.mLatestTimestamp = latestTimestamp;
            }

            public String[] getMessages() {
                return this.mMessages;
            }

            public RemoteInput getRemoteInput() {
                return this.mRemoteInput;
            }

            public PendingIntent getReplyPendingIntent() {
                return this.mReplyPendingIntent;
            }

            public PendingIntent getReadPendingIntent() {
                return this.mReadPendingIntent;
            }

            public String[] getParticipants() {
                return this.mParticipants;
            }

            public String getParticipant() {
                if (this.mParticipants.length > 0) {
                    return this.mParticipants[0];
                }
                return null;
            }

            public long getLatestTimestamp() {
                return this.mLatestTimestamp;
            }
        }

        public CarExtender() {
        }

        public CarExtender(Notification notification) {
            Bundle carBundle;
            if (VERSION.SDK_INT >= 21) {
                if (NotificationCompat.getExtras(notification) == null) {
                    carBundle = null;
                } else {
                    carBundle = NotificationCompat.getExtras(notification).getBundle(EXTRA_CAR_EXTENDER);
                }
                if (carBundle != null) {
                    this.mLargeIcon = (Bitmap) carBundle.getParcelable(EXTRA_LARGE_ICON);
                    this.mColor = carBundle.getInt(EXTRA_COLOR, 0);
                    this.mUnreadConversation = (UnreadConversation) NotificationCompat.IMPL.getUnreadConversationFromBundle(carBundle.getBundle(EXTRA_CONVERSATION), UnreadConversation.FACTORY, RemoteInput.FACTORY);
                }
            }
        }

        public Builder extend(Builder builder) {
            if (VERSION.SDK_INT < 21) {
                return builder;
            }
            Bundle carExtensions = new Bundle();
            if (this.mLargeIcon != null) {
                carExtensions.putParcelable(EXTRA_LARGE_ICON, this.mLargeIcon);
            }
            if (this.mColor != 0) {
                carExtensions.putInt(EXTRA_COLOR, this.mColor);
            }
            if (this.mUnreadConversation != null) {
                carExtensions.putBundle(EXTRA_CONVERSATION, NotificationCompat.IMPL.getBundleForUnreadConversation(this.mUnreadConversation));
            }
            builder.getExtras().putBundle(EXTRA_CAR_EXTENDER, carExtensions);
            return builder;
        }

        public CarExtender setColor(@ColorInt int color) {
            this.mColor = color;
            return this;
        }

        @ColorInt
        public int getColor() {
            return this.mColor;
        }

        public CarExtender setLargeIcon(Bitmap largeIcon) {
            this.mLargeIcon = largeIcon;
            return this;
        }

        public Bitmap getLargeIcon() {
            return this.mLargeIcon;
        }

        public CarExtender setUnreadConversation(UnreadConversation unreadConversation) {
            this.mUnreadConversation = unreadConversation;
            return this;
        }

        public UnreadConversation getUnreadConversation() {
            return this.mUnreadConversation;
        }
    }

    /* renamed from: android.support.v4.app.NotificationCompat$DecoratedCustomViewStyle */
    public static class DecoratedCustomViewStyle extends Style {
        private static final int MAX_ACTION_BUTTONS = 3;

        @RestrictTo({Scope.LIBRARY_GROUP})
        public void apply(NotificationBuilderWithBuilderAccessor builder) {
            if (VERSION.SDK_INT >= 24) {
                builder.getBuilder().setStyle(new android.app.Notification.DecoratedCustomViewStyle());
            }
        }

        @RestrictTo({Scope.LIBRARY_GROUP})
        public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor builder) {
            if (VERSION.SDK_INT < 24 && this.mBuilder.getContentView() != null) {
                return createRemoteViews(this.mBuilder.getContentView(), false);
            }
            return null;
        }

        @RestrictTo({Scope.LIBRARY_GROUP})
        public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor builder) {
            if (VERSION.SDK_INT >= 24) {
                return null;
            }
            RemoteViews bigContentView = this.mBuilder.getBigContentView();
            RemoteViews innerView = bigContentView != null ? bigContentView : this.mBuilder.getContentView();
            if (innerView == null) {
                return null;
            }
            return createRemoteViews(innerView, true);
        }

        @RestrictTo({Scope.LIBRARY_GROUP})
        public RemoteViews makeHeadsUpContentView(NotificationBuilderWithBuilderAccessor builder) {
            if (VERSION.SDK_INT >= 24) {
                return null;
            }
            RemoteViews headsUp = this.mBuilder.getHeadsUpContentView();
            RemoteViews innerView = headsUp != null ? headsUp : this.mBuilder.getContentView();
            if (headsUp == null) {
                return null;
            }
            return createRemoteViews(innerView, true);
        }

        private RemoteViews createRemoteViews(RemoteViews innerView, boolean showActions) {
            int actionVisibility = 0;
            RemoteViews remoteViews = applyStandardTemplate(true, C0004R.layout.notification_template_custom_big, false);
            remoteViews.removeAllViews(C0004R.C0006id.actions);
            boolean actionsVisible = false;
            if (showActions && this.mBuilder.mActions != null) {
                int numActions = Math.min(this.mBuilder.mActions.size(), 3);
                if (numActions > 0) {
                    actionsVisible = true;
                    for (int i = 0; i < numActions; i++) {
                        remoteViews.addView(C0004R.C0006id.actions, generateActionButton((Action) this.mBuilder.mActions.get(i)));
                    }
                }
            }
            if (!actionsVisible) {
                actionVisibility = 8;
            }
            remoteViews.setViewVisibility(C0004R.C0006id.actions, actionVisibility);
            remoteViews.setViewVisibility(C0004R.C0006id.action_divider, actionVisibility);
            buildIntoRemoteViews(remoteViews, innerView);
            return remoteViews;
        }

        private RemoteViews generateActionButton(Action action) {
            boolean tombstone = action.actionIntent == null;
            RemoteViews button = new RemoteViews(this.mBuilder.mContext.getPackageName(), tombstone ? C0004R.layout.notification_action_tombstone : C0004R.layout.notification_action);
            button.setImageViewBitmap(C0004R.C0006id.action_image, createColoredBitmap(action.getIcon(), this.mBuilder.mContext.getResources().getColor(C0004R.color.notification_action_color_filter)));
            button.setTextViewText(C0004R.C0006id.action_text, action.title);
            if (!tombstone) {
                button.setOnClickPendingIntent(C0004R.C0006id.action_container, action.actionIntent);
            }
            if (VERSION.SDK_INT >= 15) {
                button.setContentDescription(C0004R.C0006id.action_container, action.title);
            }
            return button;
        }
    }

    /* renamed from: android.support.v4.app.NotificationCompat$Extender */
    public interface Extender {
        Builder extend(Builder builder);
    }

    /* renamed from: android.support.v4.app.NotificationCompat$InboxStyle */
    public static class InboxStyle extends Style {
        private ArrayList<CharSequence> mTexts = new ArrayList<>();

        public InboxStyle() {
        }

        public InboxStyle(Builder builder) {
            setBuilder(builder);
        }

        public InboxStyle setBigContentTitle(CharSequence title) {
            this.mBigContentTitle = Builder.limitCharSequenceLength(title);
            return this;
        }

        public InboxStyle setSummaryText(CharSequence cs) {
            this.mSummaryText = Builder.limitCharSequenceLength(cs);
            this.mSummaryTextSet = true;
            return this;
        }

        public InboxStyle addLine(CharSequence cs) {
            this.mTexts.add(Builder.limitCharSequenceLength(cs));
            return this;
        }

        @RestrictTo({Scope.LIBRARY_GROUP})
        public void apply(NotificationBuilderWithBuilderAccessor builder) {
            if (VERSION.SDK_INT >= 16) {
                NotificationCompatJellybean.addInboxStyle(builder, this.mBigContentTitle, this.mSummaryTextSet, this.mSummaryText, this.mTexts);
            }
        }
    }

    /* renamed from: android.support.v4.app.NotificationCompat$MessagingStyle */
    public static class MessagingStyle extends Style {
        public static final int MAXIMUM_RETAINED_MESSAGES = 25;
        CharSequence mConversationTitle;
        List<Message> mMessages = new ArrayList();
        CharSequence mUserDisplayName;

        /* renamed from: android.support.v4.app.NotificationCompat$MessagingStyle$Message */
        public static final class Message {
            static final String KEY_DATA_MIME_TYPE = "type";
            static final String KEY_DATA_URI = "uri";
            static final String KEY_EXTRAS_BUNDLE = "extras";
            static final String KEY_SENDER = "sender";
            static final String KEY_TEXT = "text";
            static final String KEY_TIMESTAMP = "time";
            private String mDataMimeType;
            private Uri mDataUri;
            private Bundle mExtras = new Bundle();
            private final CharSequence mSender;
            private final CharSequence mText;
            private final long mTimestamp;

            public Message(CharSequence text, long timestamp, CharSequence sender) {
                this.mText = text;
                this.mTimestamp = timestamp;
                this.mSender = sender;
            }

            public Message setData(String dataMimeType, Uri dataUri) {
                this.mDataMimeType = dataMimeType;
                this.mDataUri = dataUri;
                return this;
            }

            public CharSequence getText() {
                return this.mText;
            }

            public long getTimestamp() {
                return this.mTimestamp;
            }

            public Bundle getExtras() {
                return this.mExtras;
            }

            public CharSequence getSender() {
                return this.mSender;
            }

            public String getDataMimeType() {
                return this.mDataMimeType;
            }

            public Uri getDataUri() {
                return this.mDataUri;
            }

            private Bundle toBundle() {
                Bundle bundle = new Bundle();
                if (this.mText != null) {
                    bundle.putCharSequence(KEY_TEXT, this.mText);
                }
                bundle.putLong(KEY_TIMESTAMP, this.mTimestamp);
                if (this.mSender != null) {
                    bundle.putCharSequence(KEY_SENDER, this.mSender);
                }
                if (this.mDataMimeType != null) {
                    bundle.putString(KEY_DATA_MIME_TYPE, this.mDataMimeType);
                }
                if (this.mDataUri != null) {
                    bundle.putParcelable(KEY_DATA_URI, this.mDataUri);
                }
                if (this.mExtras != null) {
                    bundle.putBundle(KEY_EXTRAS_BUNDLE, this.mExtras);
                }
                return bundle;
            }

            static Bundle[] getBundleArrayForMessages(List<Message> messages) {
                Bundle[] bundles = new Bundle[messages.size()];
                int N = messages.size();
                for (int i = 0; i < N; i++) {
                    bundles[i] = ((Message) messages.get(i)).toBundle();
                }
                return bundles;
            }

            static List<Message> getMessagesFromBundleArray(Parcelable[] bundles) {
                List<Message> messages = new ArrayList<>(bundles.length);
                for (int i = 0; i < bundles.length; i++) {
                    if (bundles[i] instanceof Bundle) {
                        Message message = getMessageFromBundle(bundles[i]);
                        if (message != null) {
                            messages.add(message);
                        }
                    }
                }
                return messages;
            }

            static Message getMessageFromBundle(Bundle bundle) {
                try {
                    if (bundle.containsKey(KEY_TEXT)) {
                        if (bundle.containsKey(KEY_TIMESTAMP)) {
                            Message message = new Message(bundle.getCharSequence(KEY_TEXT), bundle.getLong(KEY_TIMESTAMP), bundle.getCharSequence(KEY_SENDER));
                            if (bundle.containsKey(KEY_DATA_MIME_TYPE) && bundle.containsKey(KEY_DATA_URI)) {
                                message.setData(bundle.getString(KEY_DATA_MIME_TYPE), (Uri) bundle.getParcelable(KEY_DATA_URI));
                            }
                            if (bundle.containsKey(KEY_EXTRAS_BUNDLE)) {
                                message.getExtras().putAll(bundle.getBundle(KEY_EXTRAS_BUNDLE));
                            }
                            return message;
                        }
                    }
                    return null;
                } catch (ClassCastException e) {
                    return null;
                }
            }
        }

        MessagingStyle() {
        }

        public MessagingStyle(@NonNull CharSequence userDisplayName) {
            this.mUserDisplayName = userDisplayName;
        }

        public CharSequence getUserDisplayName() {
            return this.mUserDisplayName;
        }

        public MessagingStyle setConversationTitle(CharSequence conversationTitle) {
            this.mConversationTitle = conversationTitle;
            return this;
        }

        public CharSequence getConversationTitle() {
            return this.mConversationTitle;
        }

        public MessagingStyle addMessage(CharSequence text, long timestamp, CharSequence sender) {
            this.mMessages.add(new Message(text, timestamp, sender));
            if (this.mMessages.size() > 25) {
                this.mMessages.remove(0);
            }
            return this;
        }

        public MessagingStyle addMessage(Message message) {
            this.mMessages.add(message);
            if (this.mMessages.size() > 25) {
                this.mMessages.remove(0);
            }
            return this;
        }

        public List<Message> getMessages() {
            return this.mMessages;
        }

        public static MessagingStyle extractMessagingStyleFromNotification(Notification notification) {
            Bundle extras = NotificationCompat.getExtras(notification);
            if (extras != null && !extras.containsKey(NotificationCompat.EXTRA_SELF_DISPLAY_NAME)) {
                return null;
            }
            try {
                MessagingStyle style = new MessagingStyle();
                style.restoreFromCompatExtras(extras);
                return style;
            } catch (ClassCastException e) {
                return null;
            }
        }

        @RestrictTo({Scope.LIBRARY_GROUP})
        public void apply(NotificationBuilderWithBuilderAccessor builder) {
            CharSequence charSequence;
            if (VERSION.SDK_INT >= 24) {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                ArrayList arrayList4 = new ArrayList();
                ArrayList arrayList5 = new ArrayList();
                for (Message message : this.mMessages) {
                    arrayList.add(message.getText());
                    arrayList2.add(Long.valueOf(message.getTimestamp()));
                    arrayList3.add(message.getSender());
                    arrayList4.add(message.getDataMimeType());
                    arrayList5.add(message.getDataUri());
                }
                NotificationCompatApi24.addMessagingStyle(builder, this.mUserDisplayName, this.mConversationTitle, arrayList, arrayList2, arrayList3, arrayList4, arrayList5);
                return;
            }
            Message latestIncomingMessage = findLatestIncomingMessage();
            if (this.mConversationTitle != null) {
                builder.getBuilder().setContentTitle(this.mConversationTitle);
            } else if (latestIncomingMessage != null) {
                builder.getBuilder().setContentTitle(latestIncomingMessage.getSender());
            }
            if (latestIncomingMessage != null) {
                android.app.Notification.Builder builder2 = builder.getBuilder();
                if (this.mConversationTitle != null) {
                    charSequence = makeMessageLine(latestIncomingMessage);
                } else {
                    charSequence = latestIncomingMessage.getText();
                }
                builder2.setContentText(charSequence);
            }
            if (VERSION.SDK_INT >= 16) {
                SpannableStringBuilder completeMessage = new SpannableStringBuilder();
                boolean showNames = this.mConversationTitle != null || hasMessagesWithoutSender();
                for (int i = this.mMessages.size() - 1; i >= 0; i--) {
                    Message message2 = (Message) this.mMessages.get(i);
                    CharSequence line = showNames ? makeMessageLine(message2) : message2.getText();
                    if (i != this.mMessages.size() - 1) {
                        completeMessage.insert(0, "\n");
                    }
                    completeMessage.insert(0, line);
                }
                NotificationCompatJellybean.addBigTextStyle(builder, null, false, null, completeMessage);
            }
        }

        @Nullable
        private Message findLatestIncomingMessage() {
            for (int i = this.mMessages.size() - 1; i >= 0; i--) {
                Message message = (Message) this.mMessages.get(i);
                if (!TextUtils.isEmpty(message.getSender())) {
                    return message;
                }
            }
            if (!this.mMessages.isEmpty()) {
                return (Message) this.mMessages.get(this.mMessages.size() - 1);
            }
            return null;
        }

        private boolean hasMessagesWithoutSender() {
            for (int i = this.mMessages.size() - 1; i >= 0; i--) {
                if (((Message) this.mMessages.get(i)).getSender() == null) {
                    return true;
                }
            }
            return false;
        }

        private CharSequence makeMessageLine(Message message) {
            BidiFormatter bidi = BidiFormatter.getInstance();
            SpannableStringBuilder sb = new SpannableStringBuilder();
            boolean afterLollipop = VERSION.SDK_INT >= 21;
            int color = afterLollipop ? ViewCompat.MEASURED_STATE_MASK : -1;
            CharSequence replyName = message.getSender();
            if (TextUtils.isEmpty(message.getSender())) {
                replyName = this.mUserDisplayName == null ? "" : this.mUserDisplayName;
                color = (!afterLollipop || this.mBuilder.getColor() == 0) ? color : this.mBuilder.getColor();
            }
            CharSequence senderText = bidi.unicodeWrap(replyName);
            sb.append(senderText);
            sb.setSpan(makeFontColorSpan(color), sb.length() - senderText.length(), sb.length(), 33);
            sb.append("  ").append(bidi.unicodeWrap(message.getText() == null ? "" : message.getText()));
            return sb;
        }

        @NonNull
        private TextAppearanceSpan makeFontColorSpan(int color) {
            TextAppearanceSpan textAppearanceSpan = new TextAppearanceSpan(null, 0, 0, ColorStateList.valueOf(color), null);
            return textAppearanceSpan;
        }

        public void addCompatExtras(Bundle extras) {
            super.addCompatExtras(extras);
            if (this.mUserDisplayName != null) {
                extras.putCharSequence(NotificationCompat.EXTRA_SELF_DISPLAY_NAME, this.mUserDisplayName);
            }
            if (this.mConversationTitle != null) {
                extras.putCharSequence(NotificationCompat.EXTRA_CONVERSATION_TITLE, this.mConversationTitle);
            }
            if (!this.mMessages.isEmpty()) {
                extras.putParcelableArray(NotificationCompat.EXTRA_MESSAGES, Message.getBundleArrayForMessages(this.mMessages));
            }
        }

        /* access modifiers changed from: protected */
        @RestrictTo({Scope.LIBRARY_GROUP})
        public void restoreFromCompatExtras(Bundle extras) {
            this.mMessages.clear();
            this.mUserDisplayName = extras.getString(NotificationCompat.EXTRA_SELF_DISPLAY_NAME);
            this.mConversationTitle = extras.getString(NotificationCompat.EXTRA_CONVERSATION_TITLE);
            Parcelable[] parcelables = extras.getParcelableArray(NotificationCompat.EXTRA_MESSAGES);
            if (parcelables != null) {
                this.mMessages = Message.getMessagesFromBundleArray(parcelables);
            }
        }
    }

    @RequiresApi(16)
    /* renamed from: android.support.v4.app.NotificationCompat$NotificationCompatApi16Impl */
    static class NotificationCompatApi16Impl extends NotificationCompatBaseImpl {
        NotificationCompatApi16Impl() {
        }

        public Notification build(Builder b, BuilderExtender extender) {
            Builder builder = b;
            Context context = builder.mContext;
            Notification notification = builder.mNotification;
            CharSequence charSequence = builder.mContentTitle;
            CharSequence charSequence2 = builder.mContentText;
            CharSequence charSequence3 = builder.mContentInfo;
            RemoteViews remoteViews = builder.mTickerView;
            int i = builder.mNumber;
            PendingIntent pendingIntent = builder.mContentIntent;
            PendingIntent pendingIntent2 = builder.mFullScreenIntent;
            Bitmap bitmap = builder.mLargeIcon;
            int i2 = builder.mProgressMax;
            int i3 = builder.mProgress;
            boolean z = builder.mProgressIndeterminate;
            boolean z2 = builder.mUseChronometer;
            boolean z3 = z2;
            boolean z4 = z3;
            android.support.p000v4.app.NotificationCompatJellybean.Builder builder2 = new android.support.p000v4.app.NotificationCompatJellybean.Builder(context, notification, charSequence, charSequence2, charSequence3, remoteViews, i, pendingIntent, pendingIntent2, bitmap, i2, i3, z, z4, builder.mPriority, builder.mSubText, builder.mLocalOnly, builder.mExtras, builder.mGroupKey, builder.mGroupSummary, builder.mSortKey, builder.mContentView, builder.mBigContentView);
            NotificationCompat.addActionsToBuilder(builder2, builder.mActions);
            if (builder.mStyle != null) {
                builder.mStyle.apply(builder2);
            }
            Notification notification2 = extender.build(builder, builder2);
            if (builder.mStyle != null) {
                Bundle extras = NotificationCompat.getExtras(notification2);
                if (extras != null) {
                    builder.mStyle.addCompatExtras(extras);
                }
            }
            return notification2;
        }

        public Action getAction(Notification n, int actionIndex) {
            return (Action) NotificationCompatJellybean.getAction(n, actionIndex, Action.FACTORY, RemoteInput.FACTORY);
        }

        public Action[] getActionsFromParcelableArrayList(ArrayList<Parcelable> parcelables) {
            return (Action[]) NotificationCompatJellybean.getActionsFromParcelableArrayList(parcelables, Action.FACTORY, RemoteInput.FACTORY);
        }

        public ArrayList<Parcelable> getParcelableArrayListForActions(Action[] actions) {
            return NotificationCompatJellybean.getParcelableArrayListForActions(actions);
        }
    }

    @RequiresApi(19)
    /* renamed from: android.support.v4.app.NotificationCompat$NotificationCompatApi19Impl */
    static class NotificationCompatApi19Impl extends NotificationCompatApi16Impl {
        NotificationCompatApi19Impl() {
        }

        public Notification build(Builder b, BuilderExtender extender) {
            Builder builder = b;
            Context context = builder.mContext;
            Notification notification = builder.mNotification;
            CharSequence charSequence = builder.mContentTitle;
            CharSequence charSequence2 = builder.mContentText;
            CharSequence charSequence3 = builder.mContentInfo;
            RemoteViews remoteViews = builder.mTickerView;
            int i = builder.mNumber;
            PendingIntent pendingIntent = builder.mContentIntent;
            PendingIntent pendingIntent2 = builder.mFullScreenIntent;
            Bitmap bitmap = builder.mLargeIcon;
            int i2 = builder.mProgressMax;
            int i3 = builder.mProgress;
            boolean z = builder.mProgressIndeterminate;
            boolean z2 = builder.mShowWhen;
            boolean z3 = z2;
            boolean z4 = z3;
            android.support.p000v4.app.NotificationCompatKitKat.Builder builder2 = new android.support.p000v4.app.NotificationCompatKitKat.Builder(context, notification, charSequence, charSequence2, charSequence3, remoteViews, i, pendingIntent, pendingIntent2, bitmap, i2, i3, z, z4, builder.mUseChronometer, builder.mPriority, builder.mSubText, builder.mLocalOnly, builder.mPeople, builder.mExtras, builder.mGroupKey, builder.mGroupSummary, builder.mSortKey, builder.mContentView, builder.mBigContentView);
            NotificationCompat.addActionsToBuilder(builder2, builder.mActions);
            if (builder.mStyle != null) {
                builder.mStyle.apply(builder2);
            }
            return extender.build(builder, builder2);
        }

        public Action getAction(Notification n, int actionIndex) {
            return (Action) NotificationCompatKitKat.getAction(n, actionIndex, Action.FACTORY, RemoteInput.FACTORY);
        }
    }

    @RequiresApi(20)
    /* renamed from: android.support.v4.app.NotificationCompat$NotificationCompatApi20Impl */
    static class NotificationCompatApi20Impl extends NotificationCompatApi19Impl {
        NotificationCompatApi20Impl() {
        }

        public Notification build(Builder b, BuilderExtender extender) {
            Builder builder = b;
            Context context = builder.mContext;
            Notification notification = builder.mNotification;
            CharSequence charSequence = builder.mContentTitle;
            CharSequence charSequence2 = builder.mContentText;
            CharSequence charSequence3 = builder.mContentInfo;
            RemoteViews remoteViews = builder.mTickerView;
            int i = builder.mNumber;
            PendingIntent pendingIntent = builder.mContentIntent;
            PendingIntent pendingIntent2 = builder.mFullScreenIntent;
            Bitmap bitmap = builder.mLargeIcon;
            int i2 = builder.mProgressMax;
            int i3 = builder.mProgress;
            boolean z = builder.mProgressIndeterminate;
            boolean z2 = builder.mShowWhen;
            boolean z3 = builder.mUseChronometer;
            boolean z4 = z2;
            int i4 = builder.mPriority;
            CharSequence charSequence4 = builder.mSubText;
            boolean z5 = builder.mLocalOnly;
            ArrayList<String> arrayList = builder.mPeople;
            Bundle bundle = builder.mExtras;
            String str = builder.mGroupKey;
            boolean z6 = builder.mGroupSummary;
            String str2 = builder.mSortKey;
            RemoteViews remoteViews2 = builder.mContentView;
            RemoteViews remoteViews3 = builder.mBigContentView;
            boolean z7 = z4;
            android.support.p000v4.app.NotificationCompatApi20.Builder builder2 = new android.support.p000v4.app.NotificationCompatApi20.Builder(context, notification, charSequence, charSequence2, charSequence3, remoteViews, i, pendingIntent, pendingIntent2, bitmap, i2, i3, z, z7, z3, i4, charSequence4, z5, arrayList, bundle, str, z6, str2, remoteViews2, remoteViews3, b.mGroupAlertBehavior);
            NotificationCompat.addActionsToBuilder(builder2, builder.mActions);
            if (builder.mStyle != null) {
                builder.mStyle.apply(builder2);
            }
            Notification notification2 = extender.build(builder, builder2);
            if (builder.mStyle != null) {
                builder.mStyle.addCompatExtras(NotificationCompat.getExtras(notification2));
            }
            return notification2;
        }

        public Action getAction(Notification n, int actionIndex) {
            return (Action) NotificationCompatApi20.getAction(n, actionIndex, Action.FACTORY, RemoteInput.FACTORY);
        }

        public Action[] getActionsFromParcelableArrayList(ArrayList<Parcelable> parcelables) {
            return (Action[]) NotificationCompatApi20.getActionsFromParcelableArrayList(parcelables, Action.FACTORY, RemoteInput.FACTORY);
        }

        public ArrayList<Parcelable> getParcelableArrayListForActions(Action[] actions) {
            return NotificationCompatApi20.getParcelableArrayListForActions(actions);
        }
    }

    @RequiresApi(21)
    /* renamed from: android.support.v4.app.NotificationCompat$NotificationCompatApi21Impl */
    static class NotificationCompatApi21Impl extends NotificationCompatApi20Impl {
        NotificationCompatApi21Impl() {
        }

        public Notification build(Builder b, BuilderExtender extender) {
            Builder builder = b;
            Context context = builder.mContext;
            Notification notification = builder.mNotification;
            CharSequence charSequence = builder.mContentTitle;
            CharSequence charSequence2 = builder.mContentText;
            CharSequence charSequence3 = builder.mContentInfo;
            RemoteViews remoteViews = builder.mTickerView;
            int i = builder.mNumber;
            PendingIntent pendingIntent = builder.mContentIntent;
            PendingIntent pendingIntent2 = builder.mFullScreenIntent;
            Bitmap bitmap = builder.mLargeIcon;
            int i2 = builder.mProgressMax;
            int i3 = builder.mProgress;
            boolean z = builder.mProgressIndeterminate;
            boolean z2 = builder.mShowWhen;
            boolean z3 = builder.mUseChronometer;
            boolean z4 = z2;
            int i4 = builder.mPriority;
            CharSequence charSequence4 = builder.mSubText;
            boolean z5 = builder.mLocalOnly;
            String str = builder.mCategory;
            ArrayList<String> arrayList = builder.mPeople;
            Bundle bundle = builder.mExtras;
            int i5 = builder.mColor;
            int i6 = builder.mVisibility;
            Notification notification2 = builder.mPublicVersion;
            String str2 = builder.mGroupKey;
            boolean z6 = builder.mGroupSummary;
            String str3 = builder.mSortKey;
            RemoteViews remoteViews2 = builder.mContentView;
            RemoteViews remoteViews3 = builder.mBigContentView;
            RemoteViews remoteViews4 = builder.mHeadsUpContentView;
            boolean z7 = z4;
            android.support.p000v4.app.NotificationCompatApi21.Builder builder2 = new android.support.p000v4.app.NotificationCompatApi21.Builder(context, notification, charSequence, charSequence2, charSequence3, remoteViews, i, pendingIntent, pendingIntent2, bitmap, i2, i3, z, z7, z3, i4, charSequence4, z5, str, arrayList, bundle, i5, i6, notification2, str2, z6, str3, remoteViews2, remoteViews3, remoteViews4, b.mGroupAlertBehavior);
            NotificationCompat.addActionsToBuilder(builder2, builder.mActions);
            if (builder.mStyle != null) {
                builder.mStyle.apply(builder2);
            }
            Notification notification3 = extender.build(builder, builder2);
            if (builder.mStyle != null) {
                builder.mStyle.addCompatExtras(NotificationCompat.getExtras(notification3));
            }
            return notification3;
        }

        public Bundle getBundleForUnreadConversation(UnreadConversation uc) {
            return NotificationCompatApi21.getBundleForUnreadConversation(uc);
        }

        public UnreadConversation getUnreadConversationFromBundle(Bundle b, UnreadConversation.Factory factory, RemoteInput.Factory remoteInputFactory) {
            return NotificationCompatApi21.getUnreadConversationFromBundle(b, factory, remoteInputFactory);
        }
    }

    @RequiresApi(24)
    /* renamed from: android.support.v4.app.NotificationCompat$NotificationCompatApi24Impl */
    static class NotificationCompatApi24Impl extends NotificationCompatApi21Impl {
        NotificationCompatApi24Impl() {
        }

        public Notification build(Builder b, BuilderExtender extender) {
            Builder builder = b;
            Context context = builder.mContext;
            Notification notification = builder.mNotification;
            CharSequence charSequence = builder.mContentTitle;
            CharSequence charSequence2 = builder.mContentText;
            CharSequence charSequence3 = builder.mContentInfo;
            RemoteViews remoteViews = builder.mTickerView;
            int i = builder.mNumber;
            PendingIntent pendingIntent = builder.mContentIntent;
            PendingIntent pendingIntent2 = builder.mFullScreenIntent;
            Bitmap bitmap = builder.mLargeIcon;
            int i2 = builder.mProgressMax;
            int i3 = builder.mProgress;
            boolean z = builder.mProgressIndeterminate;
            boolean z2 = builder.mShowWhen;
            boolean z3 = builder.mUseChronometer;
            boolean z4 = z2;
            int i4 = builder.mPriority;
            CharSequence charSequence4 = builder.mSubText;
            boolean z5 = builder.mLocalOnly;
            String str = builder.mCategory;
            ArrayList<String> arrayList = builder.mPeople;
            Bundle bundle = builder.mExtras;
            int i5 = builder.mColor;
            int i6 = builder.mVisibility;
            Notification notification2 = builder.mPublicVersion;
            String str2 = builder.mGroupKey;
            boolean z6 = builder.mGroupSummary;
            String str3 = builder.mSortKey;
            CharSequence[] charSequenceArr = builder.mRemoteInputHistory;
            RemoteViews remoteViews2 = builder.mContentView;
            RemoteViews remoteViews3 = builder.mBigContentView;
            RemoteViews remoteViews4 = builder.mHeadsUpContentView;
            boolean z7 = z4;
            android.support.p000v4.app.NotificationCompatApi24.Builder builder2 = new android.support.p000v4.app.NotificationCompatApi24.Builder(context, notification, charSequence, charSequence2, charSequence3, remoteViews, i, pendingIntent, pendingIntent2, bitmap, i2, i3, z, z7, z3, i4, charSequence4, z5, str, arrayList, bundle, i5, i6, notification2, str2, z6, str3, charSequenceArr, remoteViews2, remoteViews3, remoteViews4, b.mGroupAlertBehavior);
            NotificationCompat.addActionsToBuilder(builder2, builder.mActions);
            if (builder.mStyle != null) {
                builder.mStyle.apply(builder2);
            }
            Notification notification3 = extender.build(builder, builder2);
            if (builder.mStyle != null) {
                builder.mStyle.addCompatExtras(NotificationCompat.getExtras(notification3));
            }
            return notification3;
        }

        public Action getAction(Notification n, int actionIndex) {
            return (Action) NotificationCompatApi24.getAction(n, actionIndex, Action.FACTORY, RemoteInput.FACTORY);
        }

        public Action[] getActionsFromParcelableArrayList(ArrayList<Parcelable> parcelables) {
            return (Action[]) NotificationCompatApi24.getActionsFromParcelableArrayList(parcelables, Action.FACTORY, RemoteInput.FACTORY);
        }

        public ArrayList<Parcelable> getParcelableArrayListForActions(Action[] actions) {
            return NotificationCompatApi24.getParcelableArrayListForActions(actions);
        }
    }

    @RequiresApi(26)
    /* renamed from: android.support.v4.app.NotificationCompat$NotificationCompatApi26Impl */
    static class NotificationCompatApi26Impl extends NotificationCompatApi24Impl {
        NotificationCompatApi26Impl() {
        }

        public Notification build(Builder b, BuilderExtender extender) {
            Builder builder = b;
            Context context = builder.mContext;
            Notification notification = builder.mNotification;
            CharSequence charSequence = builder.mContentTitle;
            CharSequence charSequence2 = builder.mContentText;
            CharSequence charSequence3 = builder.mContentInfo;
            RemoteViews remoteViews = builder.mTickerView;
            int i = builder.mNumber;
            PendingIntent pendingIntent = builder.mContentIntent;
            PendingIntent pendingIntent2 = builder.mFullScreenIntent;
            Bitmap bitmap = builder.mLargeIcon;
            int i2 = builder.mProgressMax;
            int i3 = builder.mProgress;
            boolean z = builder.mProgressIndeterminate;
            boolean z2 = builder.mShowWhen;
            boolean z3 = builder.mUseChronometer;
            boolean z4 = z2;
            int i4 = builder.mPriority;
            CharSequence charSequence4 = builder.mSubText;
            boolean z5 = builder.mLocalOnly;
            String str = builder.mCategory;
            ArrayList<String> arrayList = builder.mPeople;
            Bundle bundle = builder.mExtras;
            int i5 = builder.mColor;
            int i6 = builder.mVisibility;
            Notification notification2 = builder.mPublicVersion;
            String str2 = builder.mGroupKey;
            boolean z6 = builder.mGroupSummary;
            String str3 = builder.mSortKey;
            CharSequence[] charSequenceArr = builder.mRemoteInputHistory;
            RemoteViews remoteViews2 = builder.mContentView;
            RemoteViews remoteViews3 = builder.mBigContentView;
            RemoteViews remoteViews4 = builder.mHeadsUpContentView;
            String str4 = builder.mChannelId;
            int i7 = builder.mBadgeIcon;
            boolean z7 = z;
            String str5 = builder.mShortcutId;
            long j = builder.mTimeout;
            boolean z8 = builder.mColorized;
            boolean z9 = builder.mColorizedSet;
            boolean z10 = z7;
            boolean z11 = z8;
            int i8 = i4;
            CharSequence charSequence5 = charSequence4;
            boolean z12 = z5;
            String str6 = str;
            ArrayList<String> arrayList2 = arrayList;
            Bundle bundle2 = bundle;
            int i9 = i5;
            int i10 = i6;
            Notification notification3 = notification2;
            String str7 = str2;
            boolean z13 = z6;
            String str8 = str3;
            CharSequence[] charSequenceArr2 = charSequenceArr;
            RemoteViews remoteViews5 = remoteViews2;
            RemoteViews remoteViews6 = remoteViews3;
            RemoteViews remoteViews7 = remoteViews4;
            String str9 = str4;
            int i11 = i7;
            String str10 = str5;
            boolean z14 = z4;
            android.support.p000v4.app.NotificationCompatApi26.Builder builder2 = new android.support.p000v4.app.NotificationCompatApi26.Builder(context, notification, charSequence, charSequence2, charSequence3, remoteViews, i, pendingIntent, pendingIntent2, bitmap, i2, i3, z10, z14, z3, i8, charSequence5, z12, str6, arrayList2, bundle2, i9, i10, notification3, str7, z13, str8, charSequenceArr2, remoteViews5, remoteViews6, remoteViews7, str9, i11, str10, j, z11, z9, b.mGroupAlertBehavior);
            NotificationCompat.addActionsToBuilder(builder2, builder.mActions);
            if (builder.mStyle != null) {
                builder.mStyle.apply(builder2);
            }
            Notification notification4 = extender.build(builder, builder2);
            if (builder.mStyle != null) {
                builder.mStyle.addCompatExtras(NotificationCompat.getExtras(notification4));
            }
            return notification4;
        }
    }

    /* renamed from: android.support.v4.app.NotificationCompat$NotificationCompatBaseImpl */
    static class NotificationCompatBaseImpl implements NotificationCompatImpl {

        /* renamed from: android.support.v4.app.NotificationCompat$NotificationCompatBaseImpl$BuilderBase */
        public static class BuilderBase implements NotificationBuilderWithBuilderAccessor {
            private android.app.Notification.Builder mBuilder;

            BuilderBase(Context context, Notification n, CharSequence contentTitle, CharSequence contentText, CharSequence contentInfo, RemoteViews tickerView, int number, PendingIntent contentIntent, PendingIntent fullScreenIntent, Bitmap largeIcon, int progressMax, int progress, boolean progressIndeterminate) {
                Notification notification = n;
                boolean z = false;
                android.app.Notification.Builder deleteIntent = new android.app.Notification.Builder(context).setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, tickerView).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(contentTitle).setContentText(contentText).setContentInfo(contentInfo).setContentIntent(contentIntent).setDeleteIntent(notification.deleteIntent);
                if ((notification.flags & 128) != 0) {
                    z = true;
                }
                this.mBuilder = deleteIntent.setFullScreenIntent(fullScreenIntent, z).setLargeIcon(largeIcon).setNumber(number).setProgress(progressMax, progress, progressIndeterminate);
            }

            public android.app.Notification.Builder getBuilder() {
                return this.mBuilder;
            }

            public Notification build() {
                return this.mBuilder.getNotification();
            }
        }

        NotificationCompatBaseImpl() {
        }

        public Notification build(Builder b, BuilderExtender extender) {
            Builder builder = b;
            BuilderBase builder2 = new BuilderBase(builder.mContext, builder.mNotification, builder.mContentTitle, builder.mContentText, builder.mContentInfo, builder.mTickerView, builder.mNumber, builder.mContentIntent, builder.mFullScreenIntent, builder.mLargeIcon, builder.mProgressMax, builder.mProgress, builder.mProgressIndeterminate);
            return extender.build(builder, builder2);
        }

        public Action getAction(Notification n, int actionIndex) {
            return null;
        }

        public Action[] getActionsFromParcelableArrayList(ArrayList<Parcelable> arrayList) {
            return null;
        }

        public ArrayList<Parcelable> getParcelableArrayListForActions(Action[] actions) {
            return null;
        }

        public Bundle getBundleForUnreadConversation(UnreadConversation uc) {
            return null;
        }

        public UnreadConversation getUnreadConversationFromBundle(Bundle b, UnreadConversation.Factory factory, RemoteInput.Factory remoteInputFactory) {
            return null;
        }
    }

    /* renamed from: android.support.v4.app.NotificationCompat$NotificationCompatImpl */
    interface NotificationCompatImpl {
        Notification build(Builder builder, BuilderExtender builderExtender);

        Action getAction(Notification notification, int i);

        Action[] getActionsFromParcelableArrayList(ArrayList<Parcelable> arrayList);

        Bundle getBundleForUnreadConversation(UnreadConversation unreadConversation);

        ArrayList<Parcelable> getParcelableArrayListForActions(Action[] actionArr);

        UnreadConversation getUnreadConversationFromBundle(Bundle bundle, UnreadConversation.Factory factory, RemoteInput.Factory factory2);
    }

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: android.support.v4.app.NotificationCompat$NotificationVisibility */
    public @interface NotificationVisibility {
    }

    /* renamed from: android.support.v4.app.NotificationCompat$Style */
    public static abstract class Style {
        CharSequence mBigContentTitle;
        @RestrictTo({Scope.LIBRARY_GROUP})
        protected Builder mBuilder;
        CharSequence mSummaryText;
        boolean mSummaryTextSet = false;

        public void setBuilder(Builder builder) {
            if (this.mBuilder != builder) {
                this.mBuilder = builder;
                if (this.mBuilder != null) {
                    this.mBuilder.setStyle(this);
                }
            }
        }

        public Notification build() {
            if (this.mBuilder != null) {
                return this.mBuilder.build();
            }
            return null;
        }

        @RestrictTo({Scope.LIBRARY_GROUP})
        public void apply(NotificationBuilderWithBuilderAccessor builder) {
        }

        @RestrictTo({Scope.LIBRARY_GROUP})
        public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor builder) {
            return null;
        }

        @RestrictTo({Scope.LIBRARY_GROUP})
        public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor builder) {
            return null;
        }

        @RestrictTo({Scope.LIBRARY_GROUP})
        public RemoteViews makeHeadsUpContentView(NotificationBuilderWithBuilderAccessor builder) {
            return null;
        }

        @RestrictTo({Scope.LIBRARY_GROUP})
        public void addCompatExtras(Bundle extras) {
        }

        /* access modifiers changed from: protected */
        @RestrictTo({Scope.LIBRARY_GROUP})
        public void restoreFromCompatExtras(Bundle extras) {
        }

        /* JADX WARNING: Removed duplicated region for block: B:75:0x0200  */
        /* JADX WARNING: Removed duplicated region for block: B:84:0x024a  */
        /* JADX WARNING: Removed duplicated region for block: B:85:0x024c  */
        /* JADX WARNING: Removed duplicated region for block: B:88:0x0256  */
        @android.support.annotation.RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public android.widget.RemoteViews applyStandardTemplate(boolean r22, int r23, boolean r24) {
            /*
                r21 = this;
                r0 = r21
                android.support.v4.app.NotificationCompat$Builder r1 = r0.mBuilder
                android.content.Context r1 = r1.mContext
                android.content.res.Resources r1 = r1.getResources()
                android.widget.RemoteViews r2 = new android.widget.RemoteViews
                android.support.v4.app.NotificationCompat$Builder r3 = r0.mBuilder
                android.content.Context r3 = r3.mContext
                java.lang.String r3 = r3.getPackageName()
                r4 = r23
                r2.<init>(r3, r4)
                r3 = 0
                r5 = 0
                android.support.v4.app.NotificationCompat$Builder r6 = r0.mBuilder
                int r6 = r6.getPriority()
                r7 = -1
                r12 = 0
                if (r6 >= r7) goto L_0x0027
                r6 = 1
                goto L_0x0028
            L_0x0027:
                r6 = 0
            L_0x0028:
                r13 = r6
                int r6 = android.os.Build.VERSION.SDK_INT
                r8 = 21
                r14 = 16
                if (r6 < r14) goto L_0x005c
                int r6 = android.os.Build.VERSION.SDK_INT
                if (r6 >= r8) goto L_0x005c
                if (r13 == 0) goto L_0x004a
                int r6 = android.support.compat.C0004R.C0006id.notification_background
                java.lang.String r9 = "setBackgroundResource"
                int r10 = android.support.compat.C0004R.C0005drawable.notification_bg_low
                r2.setInt(r6, r9, r10)
                int r6 = android.support.compat.C0004R.C0006id.icon
                java.lang.String r9 = "setBackgroundResource"
                int r10 = android.support.compat.C0004R.C0005drawable.notification_template_icon_low_bg
                r2.setInt(r6, r9, r10)
                goto L_0x005c
            L_0x004a:
                int r6 = android.support.compat.C0004R.C0006id.notification_background
                java.lang.String r9 = "setBackgroundResource"
                int r10 = android.support.compat.C0004R.C0005drawable.notification_bg
                r2.setInt(r6, r9, r10)
                int r6 = android.support.compat.C0004R.C0006id.icon
                java.lang.String r9 = "setBackgroundResource"
                int r10 = android.support.compat.C0004R.C0005drawable.notification_template_icon_bg
                r2.setInt(r6, r9, r10)
            L_0x005c:
                android.support.v4.app.NotificationCompat$Builder r6 = r0.mBuilder
                android.graphics.Bitmap r6 = r6.mLargeIcon
                r10 = 8
                if (r6 == 0) goto L_0x00c5
                int r6 = android.os.Build.VERSION.SDK_INT
                if (r6 < r14) goto L_0x0077
                int r6 = android.support.compat.C0004R.C0006id.icon
                r2.setViewVisibility(r6, r12)
                int r6 = android.support.compat.C0004R.C0006id.icon
                android.support.v4.app.NotificationCompat$Builder r9 = r0.mBuilder
                android.graphics.Bitmap r9 = r9.mLargeIcon
                r2.setImageViewBitmap(r6, r9)
                goto L_0x007c
            L_0x0077:
                int r6 = android.support.compat.C0004R.C0006id.icon
                r2.setViewVisibility(r6, r10)
            L_0x007c:
                if (r22 == 0) goto L_0x0110
                android.support.v4.app.NotificationCompat$Builder r6 = r0.mBuilder
                android.app.Notification r6 = r6.mNotification
                int r6 = r6.icon
                if (r6 == 0) goto L_0x0110
                int r6 = android.support.compat.C0004R.dimen.notification_right_icon_size
                int r6 = r1.getDimensionPixelSize(r6)
                int r9 = android.support.compat.C0004R.dimen.notification_small_icon_background_padding
                int r9 = r1.getDimensionPixelSize(r9)
                int r9 = r9 * 2
                int r9 = r6 - r9
                int r11 = android.os.Build.VERSION.SDK_INT
                if (r11 < r8) goto L_0x00b0
                android.support.v4.app.NotificationCompat$Builder r7 = r0.mBuilder
                android.app.Notification r7 = r7.mNotification
                int r7 = r7.icon
                android.support.v4.app.NotificationCompat$Builder r11 = r0.mBuilder
                int r11 = r11.getColor()
                android.graphics.Bitmap r7 = r0.createIconWithBackground(r7, r6, r9, r11)
                int r11 = android.support.compat.C0004R.C0006id.right_icon
                r2.setImageViewBitmap(r11, r7)
                goto L_0x00bf
            L_0x00b0:
                int r11 = android.support.compat.C0004R.C0006id.right_icon
                android.support.v4.app.NotificationCompat$Builder r14 = r0.mBuilder
                android.app.Notification r14 = r14.mNotification
                int r14 = r14.icon
                android.graphics.Bitmap r7 = r0.createColoredBitmap(r14, r7)
                r2.setImageViewBitmap(r11, r7)
            L_0x00bf:
                int r7 = android.support.compat.C0004R.C0006id.right_icon
                r2.setViewVisibility(r7, r12)
                goto L_0x0110
            L_0x00c5:
                if (r22 == 0) goto L_0x0110
                android.support.v4.app.NotificationCompat$Builder r6 = r0.mBuilder
                android.app.Notification r6 = r6.mNotification
                int r6 = r6.icon
                if (r6 == 0) goto L_0x0110
                int r6 = android.support.compat.C0004R.C0006id.icon
                r2.setViewVisibility(r6, r12)
                int r6 = android.os.Build.VERSION.SDK_INT
                if (r6 < r8) goto L_0x0101
                int r6 = android.support.compat.C0004R.dimen.notification_large_icon_width
                int r6 = r1.getDimensionPixelSize(r6)
                int r7 = android.support.compat.C0004R.dimen.notification_big_circle_margin
                int r7 = r1.getDimensionPixelSize(r7)
                int r6 = r6 - r7
                int r7 = android.support.compat.C0004R.dimen.notification_small_icon_size_as_large
                int r7 = r1.getDimensionPixelSize(r7)
                android.support.v4.app.NotificationCompat$Builder r9 = r0.mBuilder
                android.app.Notification r9 = r9.mNotification
                int r9 = r9.icon
                android.support.v4.app.NotificationCompat$Builder r11 = r0.mBuilder
                int r11 = r11.getColor()
                android.graphics.Bitmap r9 = r0.createIconWithBackground(r9, r6, r7, r11)
                int r11 = android.support.compat.C0004R.C0006id.icon
                r2.setImageViewBitmap(r11, r9)
                goto L_0x0110
            L_0x0101:
                int r6 = android.support.compat.C0004R.C0006id.icon
                android.support.v4.app.NotificationCompat$Builder r9 = r0.mBuilder
                android.app.Notification r9 = r9.mNotification
                int r9 = r9.icon
                android.graphics.Bitmap r7 = r0.createColoredBitmap(r9, r7)
                r2.setImageViewBitmap(r6, r7)
            L_0x0110:
                android.support.v4.app.NotificationCompat$Builder r6 = r0.mBuilder
                java.lang.CharSequence r6 = r6.mContentTitle
                if (r6 == 0) goto L_0x011f
                int r6 = android.support.compat.C0004R.C0006id.title
                android.support.v4.app.NotificationCompat$Builder r7 = r0.mBuilder
                java.lang.CharSequence r7 = r7.mContentTitle
                r2.setTextViewText(r6, r7)
            L_0x011f:
                android.support.v4.app.NotificationCompat$Builder r6 = r0.mBuilder
                java.lang.CharSequence r6 = r6.mContentText
                if (r6 == 0) goto L_0x012f
                int r6 = android.support.compat.C0004R.C0006id.text
                android.support.v4.app.NotificationCompat$Builder r7 = r0.mBuilder
                java.lang.CharSequence r7 = r7.mContentText
                r2.setTextViewText(r6, r7)
                r3 = 1
            L_0x012f:
                int r6 = android.os.Build.VERSION.SDK_INT
                if (r6 >= r8) goto L_0x013b
                android.support.v4.app.NotificationCompat$Builder r6 = r0.mBuilder
                android.graphics.Bitmap r6 = r6.mLargeIcon
                if (r6 == 0) goto L_0x013b
                r6 = 1
                goto L_0x013c
            L_0x013b:
                r6 = 0
            L_0x013c:
                android.support.v4.app.NotificationCompat$Builder r7 = r0.mBuilder
                java.lang.CharSequence r7 = r7.mContentInfo
                if (r7 == 0) goto L_0x0155
                int r7 = android.support.compat.C0004R.C0006id.info
                android.support.v4.app.NotificationCompat$Builder r8 = r0.mBuilder
                java.lang.CharSequence r8 = r8.mContentInfo
                r2.setTextViewText(r7, r8)
                int r7 = android.support.compat.C0004R.C0006id.info
                r2.setViewVisibility(r7, r12)
                r3 = 1
                r6 = 1
            L_0x0152:
                r11 = r3
                r3 = r6
                goto L_0x0195
            L_0x0155:
                android.support.v4.app.NotificationCompat$Builder r7 = r0.mBuilder
                int r7 = r7.mNumber
                if (r7 <= 0) goto L_0x018d
                int r7 = android.support.compat.C0004R.integer.status_bar_notification_info_maxnum
                int r7 = r1.getInteger(r7)
                android.support.v4.app.NotificationCompat$Builder r8 = r0.mBuilder
                int r8 = r8.mNumber
                if (r8 <= r7) goto L_0x0173
                int r8 = android.support.compat.C0004R.C0006id.info
                int r9 = android.support.compat.C0004R.string.status_bar_notification_info_overflow
                java.lang.String r9 = r1.getString(r9)
                r2.setTextViewText(r8, r9)
                goto L_0x0185
            L_0x0173:
                java.text.NumberFormat r8 = java.text.NumberFormat.getIntegerInstance()
                int r9 = android.support.compat.C0004R.C0006id.info
                android.support.v4.app.NotificationCompat$Builder r11 = r0.mBuilder
                int r11 = r11.mNumber
                long r10 = (long) r11
                java.lang.String r10 = r8.format(r10)
                r2.setTextViewText(r9, r10)
            L_0x0185:
                int r8 = android.support.compat.C0004R.C0006id.info
                r2.setViewVisibility(r8, r12)
                r3 = 1
                r6 = 1
                goto L_0x0152
            L_0x018d:
                int r7 = android.support.compat.C0004R.C0006id.info
                r8 = 8
                r2.setViewVisibility(r7, r8)
                goto L_0x0152
            L_0x0195:
                android.support.v4.app.NotificationCompat$Builder r6 = r0.mBuilder
                java.lang.CharSequence r6 = r6.mSubText
                if (r6 == 0) goto L_0x01cb
                int r6 = android.os.Build.VERSION.SDK_INT
                r7 = 16
                if (r6 < r7) goto L_0x01cb
                int r6 = android.support.compat.C0004R.C0006id.text
                android.support.v4.app.NotificationCompat$Builder r7 = r0.mBuilder
                java.lang.CharSequence r7 = r7.mSubText
                r2.setTextViewText(r6, r7)
                android.support.v4.app.NotificationCompat$Builder r6 = r0.mBuilder
                java.lang.CharSequence r6 = r6.mContentText
                if (r6 == 0) goto L_0x01c3
                int r6 = android.support.compat.C0004R.C0006id.text2
                android.support.v4.app.NotificationCompat$Builder r7 = r0.mBuilder
                java.lang.CharSequence r7 = r7.mContentText
                r2.setTextViewText(r6, r7)
                int r6 = android.support.compat.C0004R.C0006id.text2
                r2.setViewVisibility(r6, r12)
                r5 = 1
                r14 = r5
                r10 = 8
                goto L_0x01ce
            L_0x01c3:
                int r6 = android.support.compat.C0004R.C0006id.text2
                r10 = 8
                r2.setViewVisibility(r6, r10)
                goto L_0x01cd
            L_0x01cb:
                r10 = 8
            L_0x01cd:
                r14 = r5
            L_0x01ce:
                if (r14 == 0) goto L_0x01f2
                int r5 = android.os.Build.VERSION.SDK_INT
                r6 = 16
                if (r5 < r6) goto L_0x01f2
                if (r24 == 0) goto L_0x01e4
                int r5 = android.support.compat.C0004R.dimen.notification_subtext_size
                int r5 = r1.getDimensionPixelSize(r5)
                float r5 = (float) r5
                int r6 = android.support.compat.C0004R.C0006id.text
                r2.setTextViewTextSize(r6, r12, r5)
            L_0x01e4:
                int r6 = android.support.compat.C0004R.C0006id.line1
                r7 = 0
                r8 = 0
                r9 = 0
                r15 = 0
                r5 = r2
                r16 = 8
                r10 = r15
                r5.setViewPadding(r6, r7, r8, r9, r10)
                goto L_0x01f4
            L_0x01f2:
                r16 = 8
            L_0x01f4:
                android.support.v4.app.NotificationCompat$Builder r5 = r0.mBuilder
                long r5 = r5.getWhenIfShowing()
                r7 = 0
                int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                if (r9 == 0) goto L_0x0246
                android.support.v4.app.NotificationCompat$Builder r5 = r0.mBuilder
                boolean r5 = r5.mUseChronometer
                if (r5 == 0) goto L_0x0233
                int r5 = android.os.Build.VERSION.SDK_INT
                r6 = 16
                if (r5 < r6) goto L_0x0233
                int r5 = android.support.compat.C0004R.C0006id.chronometer
                r2.setViewVisibility(r5, r12)
                int r5 = android.support.compat.C0004R.C0006id.chronometer
                java.lang.String r6 = "setBase"
                android.support.v4.app.NotificationCompat$Builder r7 = r0.mBuilder
                long r7 = r7.getWhenIfShowing()
                long r9 = android.os.SystemClock.elapsedRealtime()
                long r17 = java.lang.System.currentTimeMillis()
                long r19 = r9 - r17
                long r9 = r7 + r19
                r2.setLong(r5, r6, r9)
                int r5 = android.support.compat.C0004R.C0006id.chronometer
                java.lang.String r6 = "setStarted"
                r7 = 1
                r2.setBoolean(r5, r6, r7)
                goto L_0x0245
            L_0x0233:
                int r5 = android.support.compat.C0004R.C0006id.time
                r2.setViewVisibility(r5, r12)
                int r5 = android.support.compat.C0004R.C0006id.time
                java.lang.String r6 = "setTime"
                android.support.v4.app.NotificationCompat$Builder r7 = r0.mBuilder
                long r7 = r7.getWhenIfShowing()
                r2.setLong(r5, r6, r7)
            L_0x0245:
                r3 = 1
            L_0x0246:
                int r5 = android.support.compat.C0004R.C0006id.right_side
                if (r3 == 0) goto L_0x024c
                r6 = 0
                goto L_0x024e
            L_0x024c:
                r6 = 8
            L_0x024e:
                r2.setViewVisibility(r5, r6)
                int r5 = android.support.compat.C0004R.C0006id.line3
                if (r11 == 0) goto L_0x0256
                goto L_0x0258
            L_0x0256:
                r12 = 8
            L_0x0258:
                r2.setViewVisibility(r5, r12)
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.p000v4.app.NotificationCompat.Style.applyStandardTemplate(boolean, int, boolean):android.widget.RemoteViews");
        }

        @RestrictTo({Scope.LIBRARY_GROUP})
        public Bitmap createColoredBitmap(int iconId, int color) {
            return createColoredBitmap(iconId, color, 0);
        }

        private Bitmap createColoredBitmap(int iconId, int color, int size) {
            Drawable drawable = this.mBuilder.mContext.getResources().getDrawable(iconId);
            int width = size == 0 ? drawable.getIntrinsicWidth() : size;
            int height = size == 0 ? drawable.getIntrinsicHeight() : size;
            Bitmap resultBitmap = Bitmap.createBitmap(width, height, Config.ARGB_8888);
            drawable.setBounds(0, 0, width, height);
            if (color != 0) {
                drawable.mutate().setColorFilter(new PorterDuffColorFilter(color, Mode.SRC_IN));
            }
            drawable.draw(new Canvas(resultBitmap));
            return resultBitmap;
        }

        private Bitmap createIconWithBackground(int iconId, int size, int iconSize, int color) {
            Bitmap coloredBitmap = createColoredBitmap(C0004R.C0005drawable.notification_icon_background, color == 0 ? 0 : color, size);
            Canvas canvas = new Canvas(coloredBitmap);
            Drawable icon = this.mBuilder.mContext.getResources().getDrawable(iconId).mutate();
            icon.setFilterBitmap(true);
            int inset = (size - iconSize) / 2;
            icon.setBounds(inset, inset, iconSize + inset, iconSize + inset);
            icon.setColorFilter(new PorterDuffColorFilter(-1, Mode.SRC_ATOP));
            icon.draw(canvas);
            return coloredBitmap;
        }

        @RestrictTo({Scope.LIBRARY_GROUP})
        public void buildIntoRemoteViews(RemoteViews outerView, RemoteViews innerView) {
            hideNormalContent(outerView);
            outerView.removeAllViews(C0004R.C0006id.notification_main_column);
            outerView.addView(C0004R.C0006id.notification_main_column, innerView.clone());
            outerView.setViewVisibility(C0004R.C0006id.notification_main_column, 0);
            if (VERSION.SDK_INT >= 21) {
                outerView.setViewPadding(C0004R.C0006id.notification_main_column_container, 0, calculateTopPadding(), 0, 0);
            }
        }

        private void hideNormalContent(RemoteViews outerView) {
            outerView.setViewVisibility(C0004R.C0006id.title, 8);
            outerView.setViewVisibility(C0004R.C0006id.text2, 8);
            outerView.setViewVisibility(C0004R.C0006id.text, 8);
        }

        private int calculateTopPadding() {
            Resources resources = this.mBuilder.mContext.getResources();
            float largeFactor = (constrain(resources.getConfiguration().fontScale, 1.0f, 1.3f) - 1.0f) / 0.29999995f;
            return Math.round(((1.0f - largeFactor) * ((float) resources.getDimensionPixelSize(C0004R.dimen.notification_top_pad))) + (((float) resources.getDimensionPixelSize(C0004R.dimen.notification_top_pad_large_text)) * largeFactor));
        }

        private static float constrain(float amount, float low, float high) {
            if (amount < low) {
                return low;
            }
            return amount > high ? high : amount;
        }
    }

    /* renamed from: android.support.v4.app.NotificationCompat$WearableExtender */
    public static final class WearableExtender implements Extender {
        private static final int DEFAULT_CONTENT_ICON_GRAVITY = 8388613;
        private static final int DEFAULT_FLAGS = 1;
        private static final int DEFAULT_GRAVITY = 80;
        private static final String EXTRA_WEARABLE_EXTENSIONS = "android.wearable.EXTENSIONS";
        private static final int FLAG_BIG_PICTURE_AMBIENT = 32;
        private static final int FLAG_CONTENT_INTENT_AVAILABLE_OFFLINE = 1;
        private static final int FLAG_HINT_AVOID_BACKGROUND_CLIPPING = 16;
        private static final int FLAG_HINT_CONTENT_INTENT_LAUNCHES_ACTIVITY = 64;
        private static final int FLAG_HINT_HIDE_ICON = 2;
        private static final int FLAG_HINT_SHOW_BACKGROUND_ONLY = 4;
        private static final int FLAG_START_SCROLL_BOTTOM = 8;
        private static final String KEY_ACTIONS = "actions";
        private static final String KEY_BACKGROUND = "background";
        private static final String KEY_BRIDGE_TAG = "bridgeTag";
        private static final String KEY_CONTENT_ACTION_INDEX = "contentActionIndex";
        private static final String KEY_CONTENT_ICON = "contentIcon";
        private static final String KEY_CONTENT_ICON_GRAVITY = "contentIconGravity";
        private static final String KEY_CUSTOM_CONTENT_HEIGHT = "customContentHeight";
        private static final String KEY_CUSTOM_SIZE_PRESET = "customSizePreset";
        private static final String KEY_DISMISSAL_ID = "dismissalId";
        private static final String KEY_DISPLAY_INTENT = "displayIntent";
        private static final String KEY_FLAGS = "flags";
        private static final String KEY_GRAVITY = "gravity";
        private static final String KEY_HINT_SCREEN_TIMEOUT = "hintScreenTimeout";
        private static final String KEY_PAGES = "pages";
        public static final int SCREEN_TIMEOUT_LONG = -1;
        public static final int SCREEN_TIMEOUT_SHORT = 0;
        public static final int SIZE_DEFAULT = 0;
        public static final int SIZE_FULL_SCREEN = 5;
        public static final int SIZE_LARGE = 4;
        public static final int SIZE_MEDIUM = 3;
        public static final int SIZE_SMALL = 2;
        public static final int SIZE_XSMALL = 1;
        public static final int UNSET_ACTION_INDEX = -1;
        private ArrayList<Action> mActions = new ArrayList<>();
        private Bitmap mBackground;
        private String mBridgeTag;
        private int mContentActionIndex = -1;
        private int mContentIcon;
        private int mContentIconGravity = 8388613;
        private int mCustomContentHeight;
        private int mCustomSizePreset = 0;
        private String mDismissalId;
        private PendingIntent mDisplayIntent;
        private int mFlags = 1;
        private int mGravity = 80;
        private int mHintScreenTimeout;
        private ArrayList<Notification> mPages = new ArrayList<>();

        public WearableExtender() {
        }

        public WearableExtender(Notification notification) {
            Bundle extras = NotificationCompat.getExtras(notification);
            Bundle wearableBundle = extras != null ? extras.getBundle(EXTRA_WEARABLE_EXTENSIONS) : null;
            if (wearableBundle != null) {
                Action[] actions = NotificationCompat.IMPL.getActionsFromParcelableArrayList(wearableBundle.getParcelableArrayList(KEY_ACTIONS));
                if (actions != null) {
                    Collections.addAll(this.mActions, actions);
                }
                this.mFlags = wearableBundle.getInt(KEY_FLAGS, 1);
                this.mDisplayIntent = (PendingIntent) wearableBundle.getParcelable(KEY_DISPLAY_INTENT);
                Notification[] pages = NotificationCompat.getNotificationArrayFromBundle(wearableBundle, KEY_PAGES);
                if (pages != null) {
                    Collections.addAll(this.mPages, pages);
                }
                this.mBackground = (Bitmap) wearableBundle.getParcelable(KEY_BACKGROUND);
                this.mContentIcon = wearableBundle.getInt(KEY_CONTENT_ICON);
                this.mContentIconGravity = wearableBundle.getInt(KEY_CONTENT_ICON_GRAVITY, 8388613);
                this.mContentActionIndex = wearableBundle.getInt(KEY_CONTENT_ACTION_INDEX, -1);
                this.mCustomSizePreset = wearableBundle.getInt(KEY_CUSTOM_SIZE_PRESET, 0);
                this.mCustomContentHeight = wearableBundle.getInt(KEY_CUSTOM_CONTENT_HEIGHT);
                this.mGravity = wearableBundle.getInt(KEY_GRAVITY, 80);
                this.mHintScreenTimeout = wearableBundle.getInt(KEY_HINT_SCREEN_TIMEOUT);
                this.mDismissalId = wearableBundle.getString(KEY_DISMISSAL_ID);
                this.mBridgeTag = wearableBundle.getString(KEY_BRIDGE_TAG);
            }
        }

        public Builder extend(Builder builder) {
            Bundle wearableBundle = new Bundle();
            if (!this.mActions.isEmpty()) {
                wearableBundle.putParcelableArrayList(KEY_ACTIONS, NotificationCompat.IMPL.getParcelableArrayListForActions((Action[]) this.mActions.toArray(new Action[this.mActions.size()])));
            }
            if (this.mFlags != 1) {
                wearableBundle.putInt(KEY_FLAGS, this.mFlags);
            }
            if (this.mDisplayIntent != null) {
                wearableBundle.putParcelable(KEY_DISPLAY_INTENT, this.mDisplayIntent);
            }
            if (!this.mPages.isEmpty()) {
                wearableBundle.putParcelableArray(KEY_PAGES, (Parcelable[]) this.mPages.toArray(new Notification[this.mPages.size()]));
            }
            if (this.mBackground != null) {
                wearableBundle.putParcelable(KEY_BACKGROUND, this.mBackground);
            }
            if (this.mContentIcon != 0) {
                wearableBundle.putInt(KEY_CONTENT_ICON, this.mContentIcon);
            }
            if (this.mContentIconGravity != 8388613) {
                wearableBundle.putInt(KEY_CONTENT_ICON_GRAVITY, this.mContentIconGravity);
            }
            if (this.mContentActionIndex != -1) {
                wearableBundle.putInt(KEY_CONTENT_ACTION_INDEX, this.mContentActionIndex);
            }
            if (this.mCustomSizePreset != 0) {
                wearableBundle.putInt(KEY_CUSTOM_SIZE_PRESET, this.mCustomSizePreset);
            }
            if (this.mCustomContentHeight != 0) {
                wearableBundle.putInt(KEY_CUSTOM_CONTENT_HEIGHT, this.mCustomContentHeight);
            }
            if (this.mGravity != 80) {
                wearableBundle.putInt(KEY_GRAVITY, this.mGravity);
            }
            if (this.mHintScreenTimeout != 0) {
                wearableBundle.putInt(KEY_HINT_SCREEN_TIMEOUT, this.mHintScreenTimeout);
            }
            if (this.mDismissalId != null) {
                wearableBundle.putString(KEY_DISMISSAL_ID, this.mDismissalId);
            }
            if (this.mBridgeTag != null) {
                wearableBundle.putString(KEY_BRIDGE_TAG, this.mBridgeTag);
            }
            builder.getExtras().putBundle(EXTRA_WEARABLE_EXTENSIONS, wearableBundle);
            return builder;
        }

        public WearableExtender clone() {
            WearableExtender that = new WearableExtender();
            that.mActions = new ArrayList<>(this.mActions);
            that.mFlags = this.mFlags;
            that.mDisplayIntent = this.mDisplayIntent;
            that.mPages = new ArrayList<>(this.mPages);
            that.mBackground = this.mBackground;
            that.mContentIcon = this.mContentIcon;
            that.mContentIconGravity = this.mContentIconGravity;
            that.mContentActionIndex = this.mContentActionIndex;
            that.mCustomSizePreset = this.mCustomSizePreset;
            that.mCustomContentHeight = this.mCustomContentHeight;
            that.mGravity = this.mGravity;
            that.mHintScreenTimeout = this.mHintScreenTimeout;
            that.mDismissalId = this.mDismissalId;
            that.mBridgeTag = this.mBridgeTag;
            return that;
        }

        public WearableExtender addAction(Action action) {
            this.mActions.add(action);
            return this;
        }

        public WearableExtender addActions(List<Action> actions) {
            this.mActions.addAll(actions);
            return this;
        }

        public WearableExtender clearActions() {
            this.mActions.clear();
            return this;
        }

        public List<Action> getActions() {
            return this.mActions;
        }

        public WearableExtender setDisplayIntent(PendingIntent intent) {
            this.mDisplayIntent = intent;
            return this;
        }

        public PendingIntent getDisplayIntent() {
            return this.mDisplayIntent;
        }

        public WearableExtender addPage(Notification page) {
            this.mPages.add(page);
            return this;
        }

        public WearableExtender addPages(List<Notification> pages) {
            this.mPages.addAll(pages);
            return this;
        }

        public WearableExtender clearPages() {
            this.mPages.clear();
            return this;
        }

        public List<Notification> getPages() {
            return this.mPages;
        }

        public WearableExtender setBackground(Bitmap background) {
            this.mBackground = background;
            return this;
        }

        public Bitmap getBackground() {
            return this.mBackground;
        }

        public WearableExtender setContentIcon(int icon) {
            this.mContentIcon = icon;
            return this;
        }

        public int getContentIcon() {
            return this.mContentIcon;
        }

        public WearableExtender setContentIconGravity(int contentIconGravity) {
            this.mContentIconGravity = contentIconGravity;
            return this;
        }

        public int getContentIconGravity() {
            return this.mContentIconGravity;
        }

        public WearableExtender setContentAction(int actionIndex) {
            this.mContentActionIndex = actionIndex;
            return this;
        }

        public int getContentAction() {
            return this.mContentActionIndex;
        }

        public WearableExtender setGravity(int gravity) {
            this.mGravity = gravity;
            return this;
        }

        public int getGravity() {
            return this.mGravity;
        }

        public WearableExtender setCustomSizePreset(int sizePreset) {
            this.mCustomSizePreset = sizePreset;
            return this;
        }

        public int getCustomSizePreset() {
            return this.mCustomSizePreset;
        }

        public WearableExtender setCustomContentHeight(int height) {
            this.mCustomContentHeight = height;
            return this;
        }

        public int getCustomContentHeight() {
            return this.mCustomContentHeight;
        }

        public WearableExtender setStartScrollBottom(boolean startScrollBottom) {
            setFlag(8, startScrollBottom);
            return this;
        }

        public boolean getStartScrollBottom() {
            return (this.mFlags & 8) != 0;
        }

        public WearableExtender setContentIntentAvailableOffline(boolean contentIntentAvailableOffline) {
            setFlag(1, contentIntentAvailableOffline);
            return this;
        }

        public boolean getContentIntentAvailableOffline() {
            return (this.mFlags & 1) != 0;
        }

        public WearableExtender setHintHideIcon(boolean hintHideIcon) {
            setFlag(2, hintHideIcon);
            return this;
        }

        public boolean getHintHideIcon() {
            return (this.mFlags & 2) != 0;
        }

        public WearableExtender setHintShowBackgroundOnly(boolean hintShowBackgroundOnly) {
            setFlag(4, hintShowBackgroundOnly);
            return this;
        }

        public boolean getHintShowBackgroundOnly() {
            return (this.mFlags & 4) != 0;
        }

        public WearableExtender setHintAvoidBackgroundClipping(boolean hintAvoidBackgroundClipping) {
            setFlag(16, hintAvoidBackgroundClipping);
            return this;
        }

        public boolean getHintAvoidBackgroundClipping() {
            return (this.mFlags & 16) != 0;
        }

        public WearableExtender setHintScreenTimeout(int timeout) {
            this.mHintScreenTimeout = timeout;
            return this;
        }

        public int getHintScreenTimeout() {
            return this.mHintScreenTimeout;
        }

        public WearableExtender setHintAmbientBigPicture(boolean hintAmbientBigPicture) {
            setFlag(32, hintAmbientBigPicture);
            return this;
        }

        public boolean getHintAmbientBigPicture() {
            return (this.mFlags & 32) != 0;
        }

        public WearableExtender setHintContentIntentLaunchesActivity(boolean hintContentIntentLaunchesActivity) {
            setFlag(64, hintContentIntentLaunchesActivity);
            return this;
        }

        public boolean getHintContentIntentLaunchesActivity() {
            return (this.mFlags & 64) != 0;
        }

        public WearableExtender setDismissalId(String dismissalId) {
            this.mDismissalId = dismissalId;
            return this;
        }

        public String getDismissalId() {
            return this.mDismissalId;
        }

        public WearableExtender setBridgeTag(String bridgeTag) {
            this.mBridgeTag = bridgeTag;
            return this;
        }

        public String getBridgeTag() {
            return this.mBridgeTag;
        }

        private void setFlag(int mask, boolean value) {
            if (value) {
                this.mFlags |= mask;
            } else {
                this.mFlags &= mask ^ -1;
            }
        }
    }

    static void addActionsToBuilder(NotificationBuilderWithActions builder, ArrayList<Action> actions) {
        Iterator it = actions.iterator();
        while (it.hasNext()) {
            builder.addAction((Action) it.next());
        }
    }

    static {
        if (VERSION.SDK_INT >= 26) {
            IMPL = new NotificationCompatApi26Impl();
        } else if (VERSION.SDK_INT >= 24) {
            IMPL = new NotificationCompatApi24Impl();
        } else if (VERSION.SDK_INT >= 21) {
            IMPL = new NotificationCompatApi21Impl();
        } else if (VERSION.SDK_INT >= 20) {
            IMPL = new NotificationCompatApi20Impl();
        } else if (VERSION.SDK_INT >= 19) {
            IMPL = new NotificationCompatApi19Impl();
        } else if (VERSION.SDK_INT >= 16) {
            IMPL = new NotificationCompatApi16Impl();
        } else {
            IMPL = new NotificationCompatBaseImpl();
        }
    }

    static Notification[] getNotificationArrayFromBundle(Bundle bundle, String key) {
        Parcelable[] array = bundle.getParcelableArray(key);
        if ((array instanceof Notification[]) || array == null) {
            return (Notification[]) array;
        }
        Notification[] typedArray = new Notification[array.length];
        for (int i = 0; i < array.length; i++) {
            typedArray[i] = (Notification) array[i];
        }
        bundle.putParcelableArray(key, typedArray);
        return typedArray;
    }

    public static Bundle getExtras(Notification notification) {
        if (VERSION.SDK_INT >= 19) {
            return notification.extras;
        }
        if (VERSION.SDK_INT >= 16) {
            return NotificationCompatJellybean.getExtras(notification);
        }
        return null;
    }

    public static int getActionCount(Notification notification) {
        int i = 0;
        if (VERSION.SDK_INT >= 19) {
            if (notification.actions != null) {
                i = notification.actions.length;
            }
            return i;
        } else if (VERSION.SDK_INT >= 16) {
            return NotificationCompatJellybean.getActionCount(notification);
        } else {
            return 0;
        }
    }

    public static Action getAction(Notification notification, int actionIndex) {
        return IMPL.getAction(notification, actionIndex);
    }

    public static String getCategory(Notification notification) {
        if (VERSION.SDK_INT >= 21) {
            return notification.category;
        }
        return null;
    }

    public static boolean getLocalOnly(Notification notification) {
        boolean z = false;
        if (VERSION.SDK_INT >= 20) {
            if ((notification.flags & 256) != 0) {
                z = true;
            }
            return z;
        } else if (VERSION.SDK_INT >= 19) {
            return notification.extras.getBoolean(NotificationCompatExtras.EXTRA_LOCAL_ONLY);
        } else {
            if (VERSION.SDK_INT >= 16) {
                return NotificationCompatJellybean.getExtras(notification).getBoolean(NotificationCompatExtras.EXTRA_LOCAL_ONLY);
            }
            return false;
        }
    }

    public static String getGroup(Notification notification) {
        if (VERSION.SDK_INT >= 20) {
            return notification.getGroup();
        }
        if (VERSION.SDK_INT >= 19) {
            return notification.extras.getString(NotificationCompatExtras.EXTRA_GROUP_KEY);
        }
        if (VERSION.SDK_INT >= 16) {
            return NotificationCompatJellybean.getExtras(notification).getString(NotificationCompatExtras.EXTRA_GROUP_KEY);
        }
        return null;
    }

    public static boolean isGroupSummary(Notification notification) {
        boolean z = false;
        if (VERSION.SDK_INT >= 20) {
            if ((notification.flags & 512) != 0) {
                z = true;
            }
            return z;
        } else if (VERSION.SDK_INT >= 19) {
            return notification.extras.getBoolean(NotificationCompatExtras.EXTRA_GROUP_SUMMARY);
        } else {
            if (VERSION.SDK_INT >= 16) {
                return NotificationCompatJellybean.getExtras(notification).getBoolean(NotificationCompatExtras.EXTRA_GROUP_SUMMARY);
            }
            return false;
        }
    }

    public static String getSortKey(Notification notification) {
        if (VERSION.SDK_INT >= 20) {
            return notification.getSortKey();
        }
        if (VERSION.SDK_INT >= 19) {
            return notification.extras.getString(NotificationCompatExtras.EXTRA_SORT_KEY);
        }
        if (VERSION.SDK_INT >= 16) {
            return NotificationCompatJellybean.getExtras(notification).getString(NotificationCompatExtras.EXTRA_SORT_KEY);
        }
        return null;
    }

    public static String getChannelId(Notification notification) {
        if (VERSION.SDK_INT >= 26) {
            return notification.getChannelId();
        }
        return null;
    }

    public static long getTimeoutAfter(Notification notification) {
        if (VERSION.SDK_INT >= 26) {
            return notification.getTimeoutAfter();
        }
        return 0;
    }

    public static int getBadgeIconType(Notification notification) {
        if (VERSION.SDK_INT >= 26) {
            return notification.getBadgeIconType();
        }
        return 0;
    }

    public static String getShortcutId(Notification notification) {
        if (VERSION.SDK_INT >= 26) {
            return notification.getShortcutId();
        }
        return null;
    }

    public static int getGroupAlertBehavior(Notification notification) {
        if (VERSION.SDK_INT >= 26) {
            return notification.getGroupAlertBehavior();
        }
        return 0;
    }
}
