package com.example.dagger2example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.dagger2example.car.Car;
import com.example.dagger2example.dagger.ActivityComponent;
import com.example.dagger2example.dagger.DieselEngineModule;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    public Car car1, car2;

    private ActivityComponent activityComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activityComponent = ((ExampleApp) getApplication()).getAppComponent()
                .getActivityComponent(new DieselEngineModule(120));

        activityComponent.inject(this);

        //car = activityComponent.getCar();
        car1.drive();
        car2.drive();
    }
}
