package i.am.eipeks.x_plore._activities;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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

public class Home extends AppCompatActivity implements
        View.OnFocusChangeListener,
        View.OnClickListener{

    private EditText password, name;
    private Button login;
    private TextInputLayout passwordInputLayout, nameInputLayout;

    private DisposableObserver<String> passwordObserver;
    private Observable<String> passwordObservable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        password = (EditText) findViewById(R.id.password);
        name = (EditText) findViewById(R.id.name);
        login = (Button) findViewById(R.id.login);

        passwordInputLayout = (TextInputLayout) findViewById(R.id.password_input_layout);
        nameInputLayout = (TextInputLayout) findViewById(R.id.name_input_layout);

        password.setOnFocusChangeListener(this);
        name.setOnFocusChangeListener(this);
        login.setOnClickListener(this);

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
                passwordInputLayout.setErrorEnabled(true);
                if (passwordObserver == null){
                    passwordObserver = passwordObservable
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribeWith(new DisposableObserver<String>() {
                                @Override
                                public void onNext(@NonNull String s) {
                                    if (s.length() < 8){
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
                if (!(password.getText().toString().length() < 8)){
                    passwordInputLayout.setErrorEnabled(false);
                }
                if (passwordObserver != null){
                    passwordObserver = null;
                }
                break;
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.login:
                startActivity(new Intent(this, Main.class));
                break;
        }
    }
}
