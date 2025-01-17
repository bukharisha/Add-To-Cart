package com.example.cart_application.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.cart_application.models.CartItem;
import com.example.cart_application.models.Product;

import java.util.ArrayList;
import java.util.List;

public class CartRepo {
    private MutableLiveData<List<CartItem>> mutableCart = new MutableLiveData<>();
    // 2. TotalPrice code
    public MutableLiveData<Double> mutableTotalPrice = new MutableLiveData<>();

    public LiveData<List<CartItem>> getCart() {
        if (mutableCart.getValue() == null) {
            initCart();
        }
        return mutableCart;
    }
    public void initCart() {
        mutableCart.setValue(new ArrayList<CartItem>());
        // 9. TotalPrice code
        calculateCartTotal();
    }

    public boolean addItemToCart(Product product) {
        if (mutableCart.getValue() == null) {
            initCart();
        }
        List<CartItem> cartItemList = new ArrayList<>(mutableCart.getValue());
        //Shop mein jo product hai uske add to cart button per bar bar click karne per vah product
        // card fragment mein alag alag add na ho balke quantity mein maximum  5 tak hi add ho
        //  ye code es quantity k liye hai
        for (CartItem cartItem: cartItemList) {
            if (cartItem.getProduct().getId().equals(product.getId())) {
                if (cartItem.getQuantity() == 5) {
                    return false;
                }
                int index = cartItemList.indexOf(cartItem);
                cartItem.setQuantity(cartItem.getQuantity() + 1);
                cartItemList.set(index, cartItem);
                mutableCart.setValue(cartItemList);
                // 8. TotalPrice code
                calculateCartTotal();
                return true;
            }
        }
        CartItem cartItem = new CartItem(product, 1);
        cartItemList.add(cartItem);
        mutableCart.setValue(cartItemList);
        return true;
    }
    // cart fragment me delete icon button ka code public void deleteItem
    public void removeItemFromCart(CartItem cartItem) {
        if (mutableCart.getValue() == null) {
            return;
        }
        List<CartItem> cartItemList = new ArrayList<>(mutableCart.getValue());
        cartItemList.remove(cartItem);
        mutableCart.setValue(cartItemList);
        // 7. TotalPrice code
        calculateCartTotal();
    }
    // 4. Spinner quantity code
    public void changeQuantity(CartItem cartItem, int quantity) {
        if (mutableCart.getValue() == null) return;

        List<CartItem> cartItemList = new ArrayList<>(mutableCart.getValue());

        CartItem updatedItem = new CartItem(cartItem.getProduct(), quantity);
        cartItemList.set(cartItemList.indexOf(cartItem), updatedItem);

        mutableCart.setValue(cartItemList);
        // 6. TotalPrice code
        calculateCartTotal();
    }
    // 5. TotalPrice code
    private void calculateCartTotal() {
        if (mutableCart.getValue() == null) return;
        double total = 0.0;
        List<CartItem> cartItemList = mutableCart.getValue();
        for (CartItem cartItem: cartItemList) {
            total += cartItem.getProduct().getPrice() * cartItem.getQuantity();
        }
        mutableTotalPrice.setValue(total);
    }
    // 3. TotalPrice code
    public LiveData<Double> getTotalPrice() {
        if (mutableTotalPrice.getValue() == null) {
            mutableTotalPrice.setValue(0.0);
        }
        return mutableTotalPrice;
    }

}
