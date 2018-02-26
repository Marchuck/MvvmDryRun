package pl.marczak.mvvmdryrun.main

import android.support.v4.app.FragmentManager
import dagger.Module
import dagger.Provides
import pl.marczak.mvvmdryrun.base.NavigationService
import pl.marczak.mvvmdryrun.di.PerActivity

@Module
class MainModule {

    @Provides
    @PerActivity
    fun providesSupportFragmentManager(mainActivity: MainActivity): FragmentManager = mainActivity.supportFragmentManager

    @Provides
    @PerActivity
    fun providesNavService(fm: FragmentManager,mainActivity: MainActivity) = NavigationService(fm,mainActivity)


}