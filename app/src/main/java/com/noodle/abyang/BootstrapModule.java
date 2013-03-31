package com.noodle.abyang;

import android.accounts.AccountManager;
import android.content.Context;

import com.noodle.abyang.authenticator.BootstrapAuthenticatorActivity;
import com.noodle.abyang.authenticator.LogoutService;
import com.noodle.abyang.core.CheckIn;
import com.noodle.abyang.core.TimerService;
import com.noodle.abyang.ui.BootstrapTimerActivity;
import com.noodle.abyang.ui.CarouselActivity;
import com.noodle.abyang.ui.CheckInsListFragment;
import com.noodle.abyang.ui.ItemListFragment;
import com.noodle.abyang.ui.NewsActivity;
import com.noodle.abyang.ui.NewsListFragment;
import com.noodle.abyang.ui.UserActivity;
import com.noodle.abyang.ui.UserListFragment;
import com.squareup.otto.Bus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Dagger module for setting up provides statements.
 * Register all of your entry points below.
 */
@Module
(
        complete = false,

        entryPoints = {
                BootstrapApplication.class,
                BootstrapAuthenticatorActivity.class,
                CarouselActivity.class,
                BootstrapTimerActivity.class,
                CheckInsListFragment.class,
                NewsActivity.class,
                NewsListFragment.class,
                UserActivity.class,
                UserListFragment.class,
                TimerService.class
        }

)
public class BootstrapModule  {

    @Singleton
    @Provides
    Bus provideOttoBus() {
        return new Bus();
    }

    @Provides
    @Singleton
    LogoutService provideLogoutService(final Context context, final AccountManager accountManager) {
        return new LogoutService(context, accountManager);
    }

}
