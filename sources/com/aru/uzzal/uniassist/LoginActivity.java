package com.aru.uzzal.uniassist;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.ContactsContract.Profile;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.p003v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewPropertyAnimator;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity implements LoaderCallbacks<Cursor> {
    /* access modifiers changed from: private */
    public static final String[] DUMMY_CREDENTIALS = {"foo@example.com:hello", "bar@example.com:world"};
    private static final int REQUEST_READ_CONTACTS = 0;
    /* access modifiers changed from: private */
    public UserLoginTask mAuthTask = null;
    private AutoCompleteTextView mEmailView;
    /* access modifiers changed from: private */
    public View mLoginFormView;
    /* access modifiers changed from: private */
    public EditText mPasswordView;
    /* access modifiers changed from: private */
    public View mProgressView;

    private interface ProfileQuery {
        public static final int ADDRESS = 0;
        public static final int IS_PRIMARY = 1;
        public static final String[] PROJECTION = {"data1", "is_primary"};
    }

    public class UserLoginTask extends AsyncTask<Void, Void, Boolean> {
        private final String mEmail;
        private final String mPassword;

        UserLoginTask(String email, String password) {
            this.mEmail = email;
            this.mPassword = password;
        }

        /* access modifiers changed from: protected */
        public Boolean doInBackground(Void... params) {
            try {
                Thread.sleep(2000);
                for (String credential : LoginActivity.DUMMY_CREDENTIALS) {
                    String[] pieces = credential.split(":");
                    if (pieces[0].equals(this.mEmail)) {
                        return Boolean.valueOf(pieces[1].equals(this.mPassword));
                    }
                }
                return Boolean.valueOf(true);
            } catch (InterruptedException e) {
                return Boolean.valueOf(false);
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Boolean success) {
            LoginActivity.this.mAuthTask = null;
            LoginActivity.this.showProgress(false);
            if (success.booleanValue()) {
                LoginActivity.this.finish();
                return;
            }
            LoginActivity.this.mPasswordView.setError(LoginActivity.this.getString(C0457R.string.error_incorrect_password));
            LoginActivity.this.mPasswordView.requestFocus();
        }

        /* access modifiers changed from: protected */
        public void onCancelled() {
            LoginActivity.this.mAuthTask = null;
            LoginActivity.this.showProgress(false);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C0457R.layout.activity_login);
        this.mEmailView = (AutoCompleteTextView) findViewById(C0457R.C0459id.email);
        populateAutoComplete();
        this.mPasswordView = (EditText) findViewById(C0457R.C0459id.password);
        this.mPasswordView.setOnEditorActionListener(new OnEditorActionListener() {
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id != 6 && id != 0) {
                    return false;
                }
                LoginActivity.this.attemptLogin();
                return true;
            }
        });
        ((Button) findViewById(C0457R.C0459id.email_sign_in_button)).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                LoginActivity.this.attemptLogin();
            }
        });
        this.mLoginFormView = findViewById(C0457R.C0459id.login_form);
        this.mProgressView = findViewById(C0457R.C0459id.login_progress);
    }

    private void populateAutoComplete() {
        if (mayRequestContacts()) {
            getLoaderManager().initLoader(0, null, this);
        }
    }

    private boolean mayRequestContacts() {
        if (VERSION.SDK_INT < 23 || checkSelfPermission("android.permission.READ_CONTACTS") == 0) {
            return true;
        }
        if (shouldShowRequestPermissionRationale("android.permission.READ_CONTACTS")) {
            Snackbar.make((View) this.mEmailView, (int) C0457R.string.permission_rationale, -2).setAction(17039370, (OnClickListener) new OnClickListener() {
                @TargetApi(23)
                public void onClick(View v) {
                    LoginActivity.this.requestPermissions(new String[]{"android.permission.READ_CONTACTS"}, 0);
                }
            });
        } else {
            requestPermissions(new String[]{"android.permission.READ_CONTACTS"}, 0);
        }
        return false;
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 0 && grantResults.length == 1 && grantResults[0] == 0) {
            populateAutoComplete();
        }
    }

    /* access modifiers changed from: private */
    public void attemptLogin() {
        if (this.mAuthTask == null) {
            this.mEmailView.setError(null);
            this.mPasswordView.setError(null);
            String email = this.mEmailView.getText().toString();
            String password = this.mPasswordView.getText().toString();
            boolean cancel = false;
            View focusView = null;
            if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
                this.mPasswordView.setError(getString(C0457R.string.error_invalid_password));
                focusView = this.mPasswordView;
                cancel = true;
            }
            if (TextUtils.isEmpty(email)) {
                this.mEmailView.setError(getString(C0457R.string.error_field_required));
                focusView = this.mEmailView;
                cancel = true;
            } else if (!isEmailValid(email)) {
                this.mEmailView.setError(getString(C0457R.string.error_invalid_email));
                focusView = this.mEmailView;
                cancel = true;
            }
            if (cancel) {
                focusView.requestFocus();
            } else {
                showProgress(true);
                this.mAuthTask = new UserLoginTask(email, password);
                this.mAuthTask.execute(new Void[]{null});
            }
        }
    }

    private boolean isEmailValid(String email) {
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        return password.length() > 4;
    }

    /* access modifiers changed from: private */
    @TargetApi(13)
    public void showProgress(final boolean show) {
        int i = 0;
        if (VERSION.SDK_INT >= 13) {
            int shortAnimTime = getResources().getInteger(17694720);
            this.mLoginFormView.setVisibility(show ? 8 : 0);
            float f = 1.0f;
            this.mLoginFormView.animate().setDuration((long) shortAnimTime).alpha(show ? 0.0f : 1.0f).setListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animation) {
                    LoginActivity.this.mLoginFormView.setVisibility(show ? 8 : 0);
                }
            });
            View view = this.mProgressView;
            if (!show) {
                i = 8;
            }
            view.setVisibility(i);
            ViewPropertyAnimator duration = this.mProgressView.animate().setDuration((long) shortAnimTime);
            if (!show) {
                f = 0.0f;
            }
            duration.alpha(f).setListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animation) {
                    LoginActivity.this.mProgressView.setVisibility(show ? 0 : 8);
                }
            });
            return;
        }
        this.mProgressView.setVisibility(show ? 0 : 8);
        View view2 = this.mLoginFormView;
        if (show) {
            i = 8;
        }
        view2.setVisibility(i);
    }

    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        CursorLoader cursorLoader = new CursorLoader(this, Uri.withAppendedPath(Profile.CONTENT_URI, "data"), ProfileQuery.PROJECTION, "mimetype = ?", new String[]{"vnd.android.cursor.item/email_v2"}, "is_primary DESC");
        return cursorLoader;
    }

    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        List<String> emails = new ArrayList<>();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            emails.add(cursor.getString(0));
            cursor.moveToNext();
        }
        addEmailsToAutoComplete(emails);
    }

    public void onLoaderReset(Loader<Cursor> loader) {
    }

    private void addEmailsToAutoComplete(List<String> emailAddressCollection) {
        this.mEmailView.setAdapter(new ArrayAdapter<>(this, 17367050, emailAddressCollection));
    }
}
