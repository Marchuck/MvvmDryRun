package pl.marczak.mvvmdryrun.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import pl.marczak.mvvmdryrun.main.MainActivity
import pl.marczak.mvvmdryrun.main.MainModule

@Module
abstract class ActivityBuilder {

    @PerActivity
    @ContributesAndroidInjector(modules = arrayOf(MainModule::class))
    abstract fun bindMainActivity(): MainActivity

}