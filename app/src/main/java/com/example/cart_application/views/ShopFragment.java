package com.example.cart_application.views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cart_application.R;
import com.example.cart_application.adapters.ShopListAdapter;
import com.example.cart_application.databinding.FragmentShopBinding;
import com.example.cart_application.models.Product;
import com.example.cart_application.viewmodels.ShopViewModel;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;


public class ShopFragment extends Fragment implements ShopListAdapter.ShopInterface{

    private static final String TAG = "ShopFragment";
    FragmentShopBinding fragmentShopBinding;
    private ShopListAdapter shopListAdapter;
    private ShopViewModel shopViewModel;
    private NavController navController;

    public ShopFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentShopBinding = FragmentShopBinding.inflate(inflater,container, false);
        return fragmentShopBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // yahan this ko add kiya  ShopInterface k liye jo shopListAdapter me banaya hai
        shopListAdapter = new ShopListAdapter(this);
        fragmentShopBinding.shopRecyclerView.setAdapter(shopListAdapter);

        // Item Decoration
        fragmentShopBinding.shopRecyclerView.addItemDecoration(new DividerItemDecoration(requireContext(),
                DividerItemDecoration.VERTICAL));
        fragmentShopBinding.shopRecyclerView.addItemDecoration(new DividerItemDecoration(requireContext(),
                DividerItemDecoration.HORIZONTAL));

        // ShopViewModel code
        shopViewModel = new ViewModelProvider(requireActivity()).get(ShopViewModel.class);
        shopViewModel.getProducts().observe(getViewLifecycleOwner(), new Observer<List<Product>>() {
            @Override
            public void onChanged(List<Product> products) {
                shopListAdapter.submitList(products);
            }
        });
        //setup Navigation
        navController = Navigation.findNavController(view);
    }

    @Override
    public void addItem(Product product) { // Add To Cart Button par addItem ko set kiya hai
        boolean isAdded = shopViewModel.addItemToCart(product);
        // ye code liye hai mix5 item cart fragment me add hone ek toast comment show hoga
        if (isAdded) {
            Snackbar.make(requireView(), product.getName() + "added to cart.", Snackbar.LENGTH_LONG)
                    .setAction("Checkout", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            navController.navigate(R.id.action_shopFragment_to_cartFragment);
                        }
                    })
                    .show();

        } else {
            Snackbar.make(requireView(),  "Already have the max quantity in cart.", Snackbar.LENGTH_LONG)
                    .show();
        }
    }

    @Override
    public void onItemClick(Product product) {
        shopViewModel.setProduct(product); // setProduct shopViewModel ka code detail product layout k liye
        //setup Navigation
        navController.navigate(R.id.action_shopFragment_to_productDetailFragment);
    }
}