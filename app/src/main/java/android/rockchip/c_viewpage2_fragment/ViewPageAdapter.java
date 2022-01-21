package android.rockchip.c_viewpage2_fragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPageAdapter extends FragmentStateAdapter {
    public ViewPageAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }


    public ViewPageAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    public ViewPageAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment = null;

        switch (position) {
            case 0:
                fragment = new OneFragment();
                break;
            case 1:
                fragment = new TwoFragment();
                break;
            case 2:
                fragment = new ThreeFragment();
                break;
        }

        return fragment;
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
