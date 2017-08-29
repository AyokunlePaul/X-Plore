package i.am.eipeks.x_plore._activities;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import i.am.eipeks.x_plore.R;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class Home extends AppCompatActivity implements View.OnFocusChangeListener {

    private EditText password, name;

    private TextInputLayout passwordInputLayout, nameInputLayout;

    private DisposableObserver<String> passwordObserver;
    private Observable<String> passwordObservable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        password = (EditText) findViewById(R.id.password);
        name = (EditText) findViewById(R.id.name);

        passwordInputLayout = (TextInputLayout) findViewById(R.id.password_input_layout);
        nameInputLayout = (TextInputLayout) findViewById(R.id.name_input_layout);

        password.setOnFocusChangeListener(this);
        name.setOnFocusChangeListener(this);

        passwordObservable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull final ObservableEmitter<String> e) throws Exception {
                password.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void afterTextChanged(Editable editable) {
                        e.onNext(editable.toString());
                    }
                });
            }
        });
    }

    @Override
    public void onFocusChange(View view, boolean b) {
        switch (view.getId()){
            case R.id.password:
                if (passwordObserver == null){
                    passwordObserver = passwordObservable
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribeWith(new DisposableObserver<String>() {
                                @Override
                                public void onNext(@NonNull String s) {
                                    if (s.length() < 8){
                                        passwordInputLayout.setErrorEnabled(true);
                                        passwordInputLayout.setError("Password must be at least 8-digits long");
                                    } else {
                                        onComplete();
                                    }
                                }

                                @Override
                                public void onError(@NonNull Throwable e) {

                                }

                                @Override
                                public void onComplete() {
                                    passwordInputLayout.setErrorEnabled(false);
                                }
                            });
                }
                break;
            case R.id.name:
                passwordInputLayout.setErrorEnabled(false);
                if (passwordObserver != null){
                    passwordObserver = null;
                }
                break;
        }
    }
}
