package android.support.p000v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.p000v4.app.NotificationCompatBase.Action;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.Iterator;

@RequiresApi(26)
/* renamed from: android.support.v4.app.NotificationCompatApi26 */
class NotificationCompatApi26 {

    /* renamed from: android.support.v4.app.NotificationCompatApi26$Builder */
    public static class Builder implements NotificationBuilderWithBuilderAccessor, NotificationBuilderWithActions {

        /* renamed from: mB */
        private android.app.Notification.Builder f21mB;

        Builder(Context context, Notification n, CharSequence contentTitle, CharSequence contentText, CharSequence contentInfo, RemoteViews tickerView, int number, PendingIntent contentIntent, PendingIntent fullScreenIntent, Bitmap largeIcon, int progressMax, int progress, boolean progressIndeterminate, boolean showWhen, boolean useChronometer, int priority, CharSequence subText, boolean localOnly, String category, ArrayList<String> people, Bundle extras, int color, int visibility, Notification publicVersion, String groupKey, boolean groupSummary, String sortKey, CharSequence[] remoteInputHistory, RemoteViews contentView, RemoteViews bigContentView, RemoteViews headsUpContentView, String channelId, int badgeIcon, String shortcutId, long timeoutMs, boolean colorized, boolean colorizedSet, int groupAlertBehavior) {
            Notification notification = n;
            RemoteViews remoteViews = contentView;
            RemoteViews remoteViews2 = bigContentView;
            RemoteViews remoteViews3 = headsUpContentView;
            String str = channelId;
            this.f21mB = new android.app.Notification.Builder(context, str).setWhen(notification.when).setShowWhen(showWhen).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, tickerView).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(contentTitle).setContentText(contentText).setSubText(subText).setContentInfo(contentInfo).setContentIntent(contentIntent).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(fullScreenIntent, (notification.flags & 128) != 0).setLargeIcon(largeIcon).setNumber(number).setUsesChronometer(useChronometer).setPriority(priority).setProgress(progressMax, progress, progressIndeterminate).setLocalOnly(localOnly).setExtras(extras).setGroup(groupKey).setGroupSummary(groupSummary).setSortKey(sortKey).setCategory(category).setColor(color).setVisibility(visibility).setPublicVersion(publicVersion).setRemoteInputHistory(remoteInputHistory).setChannelId(str).setBadgeIconType(badgeIcon).setShortcutId(shortcutId).setTimeoutAfter(timeoutMs).setGroupAlertBehavior(groupAlertBehavior);
            if (colorizedSet) {
                this.f21mB.setColorized(colorized);
            } else {
                boolean z = colorized;
            }
            if (remoteViews != null) {
                this.f21mB.setCustomContentView(remoteViews);
            }
            if (remoteViews2 != null) {
                this.f21mB.setCustomBigContentView(remoteViews2);
            }
            if (remoteViews3 != null) {
                this.f21mB.setCustomHeadsUpContentView(remoteViews3);
            }
            Iterator it = people.iterator();
            while (it.hasNext()) {
                Iterator it2 = it;
                this.f21mB.addPerson((String) it.next());
                it = it2;
                RemoteViews remoteViews4 = contentView;
            }
        }

        public void addAction(Action action) {
            NotificationCompatApi24.addAction(this.f21mB, action);
        }

        public android.app.Notification.Builder getBuilder() {
            return this.f21mB;
        }

        public Notification build() {
            return this.f21mB.build();
        }
    }

    NotificationCompatApi26() {
    }
}
