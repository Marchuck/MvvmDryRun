package pl.marczak.mvvmdryrun.login

import dagger.Module
import dagger.Provides
import pl.marczak.mvvmdryrun.di.PerActivity

@Module
class LoginModule {

    @Provides
    @PerActivity
    fun provideLoginRepository(): LoginRepository = ExampleLoginRepository()

}