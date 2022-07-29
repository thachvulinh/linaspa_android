package com.example.linaspa.main.ui.users;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.linaspa.R;
import com.example.linaspa.databinding.FragmentUsersBinding;
import com.example.linaspa.main.MainActivity;

import java.util.ArrayList;

public class UsersFragment extends Fragment {
    private FragmentUsersBinding binding;

    private  MainActivity mMainActivity;
    ListView lvUsers;
    ArrayList<Users> arrayUsers;
    UsersAdapter adapter;
    public String users_list="http://192.168.1.11/honespa.atwebpages.com/api/admin/users/list";
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        UsersViewModel usersViewModel =
                new ViewModelProvider(this).get(UsersViewModel.class);

        //binding = FragmentUsersBinding.inflate(inflater, container, false);
        //View root = binding.getRoot();
        mMainActivity=(MainActivity)getActivity();

        View view=inflater.inflate(R.layout.fragment_users,container,false);
        ListView lv=(ListView) view.findViewById(R.id.listviewUsers);
        lvUsers =(ListView) view.findViewById(R.id.listviewUsers);
        arrayUsers=new ArrayList<>();
        adapter=new UsersAdapter(mMainActivity,R.layout.row_users,arrayUsers);
        lvUsers.setAdapter(adapter);
        usersViewModel.getData(users_list,adapter,arrayUsers,mMainActivity);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
