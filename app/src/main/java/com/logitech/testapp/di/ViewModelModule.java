package com.logitech.testapp.di;

import android.arch.lifecycle.ViewModel;

import com.logitech.testapp.app.domain.interactor.MovieDetailUseCase;
import com.logitech.testapp.app.domain.interactor.MoviesListUseCase;
import com.logitech.testapp.core.viewmodel.ViewModelFactory;
import com.logitech.testapp.mapper.MovieDomainToModelMapper;
import com.logitech.testapp.scenes.detail.viewmodel.MovieDetailViewModel;
import com.logitech.testapp.scenes.mainmenu.viewmodel.MainActivityViewModel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Map;

import javax.inject.Provider;


import dagger.MapKey;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;

@Module
public class ViewModelModule {
 
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @MapKey
    @interface ViewModelKey {
        Class<? extends ViewModel> value();
    }
 
    @Provides
    ViewModelFactory viewModelFactory(Map<Class<? extends ViewModel>, Provider<ViewModel>> providerMap) {
        return new ViewModelFactory(providerMap);
    }

    @Provides
    @IntoMap
    @ViewModelKey(MainActivityViewModel.class)
    ViewModel MainActivityViewModel(MoviesListUseCase moviesListUseCase,
                                    MovieDomainToModelMapper domainToModelMapper) {
        return new MainActivityViewModel(moviesListUseCase,domainToModelMapper);
    }

    @Provides
    @IntoMap
    @ViewModelKey(MovieDetailViewModel.class)
    ViewModel MovieDetailViewModel(MovieDetailUseCase movieDetailUseCase,
                                    MovieDomainToModelMapper domainToModelMapper) {
        return new MovieDetailViewModel(movieDetailUseCase,domainToModelMapper);
    }
}