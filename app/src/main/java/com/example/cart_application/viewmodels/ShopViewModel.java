package com.example.cart_application.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.cart_application.models.CartItem;
import com.example.cart_application.models.Product;
import com.example.cart_application.repositories.CartRepo;
import com.example.cart_application.repositories.ShopRepo;

import java.util.List;

public class ShopViewModel extends ViewModel {

    ShopRepo shopRepo = new ShopRepo();
    CartRepo cartRepo = new CartRepo();

    //MutableLiveData
    MutableLiveData<Product> mutableProduct = new MutableLiveData<>();
    public LiveData<List<Product>> getProducts() { // shopRepo k liye code
        return shopRepo.getProducts();
    }
    //mutableProduct //MutableLiveData
    public void setProduct(Product product) { // detail product layout k liye
        mutableProduct.setValue(product);
    }
    public LiveData<Product> getProduct() { // detail product layout k liye
        return mutableProduct;
    }
    public LiveData<List<CartItem>> getCart() {
        return cartRepo.getCart();
    }
    public boolean addItemToCart(Product product) {
        return cartRepo.addItemToCart(product);
    }

    // 7. cart fragment me delete icon button ka code public void deleteItem
    public void removeItemFromCart(CartItem cartItem) {
        cartRepo.removeItemFromCart(cartItem);
    }
    // 3. Spinner quantity code
    public void changeQuantity(CartItem cartItem, int quantity) {
        cartRepo.changeQuantity(cartItem, quantity);
    }
    // 1. TotalPrice code
    public LiveData<Double> getTotalPrice() {
        return cartRepo.getTotalPrice();
    }
    public void resetCart() {
        cartRepo.initCart();
    }
}