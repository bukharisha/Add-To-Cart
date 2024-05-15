package com.example.cart_application.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.cart_application.models.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ShopRepo {

    private MutableLiveData<List<Product>> mutableProductList;

    public LiveData<List<Product>> getProducts() {
        if (mutableProductList == null) {
            mutableProductList = new MutableLiveData<>();
            loadProducts();
        }
        return mutableProductList;
    }

    private void loadProducts() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(UUID.randomUUID().toString(), "iMac 21", 1299, true, "The iMac 21 is a sleek all-in-one desktop computer designed by Apple. It features a 21.5-inch Retina display with stunning color accuracy and sharp visuals, providing an immersive viewing experience. Powered by advanced Intel processors, the iMac 21 offers fast and efficient performance for various tasks, from productivity to light gaming.\n" +
                "\n" +
                "The design is slim and minimalistic, with an aluminum enclosure that complements modern aesthetics. It includes built-in stereo speakers for high-quality audio output and a FaceTime HD camera for video conferencing. The iMac 21 also has multiple connectivity options, such as USB-C, Thunderbolt, USB-A, and an SD card slot, allowing easy integration with other devices and peripherals.\n" +
                "\n" +
                "Running on macOS, it provides a smooth and intuitive user experience with seamless integration across the Apple ecosystem. The iMac 21 is perfect for those seeking a compact yet powerful desktop solution that combines style, performance, and versatility.",
                "https://firebasestorage.googleapis.com/v0/b/fly-cart-kotlin.appspot.com/o/i%20Mac%2021.png?alt=media&token=317465b7-faff-490d-9803-e78abbdc493c"));

        productList.add(new Product(UUID.randomUUID().toString(), "Hot 10", 300, true, "Infinix Hot 10 aik budget-friendly smartphone hai jo ke robust features aur stylish design ke sath aata hai. Ye phone 6.78-inch ke HD+ IPS display ke sath aata hai, jo ke bara aur bright viewing experience provide karta hai. Iska punch-hole design iska modern aur sleek look ko enhance karta hai.\n" +
                "\n" +
                "Infinix Hot 10 ka performance MediaTek Helio G70 octa-core processor par based hai, jo ke smooth multitasking aur gaming experience provide karta hai. Ye phone kai storage aur RAM variants mein aata hai, jisme 4GB tak RAM aur 64GB tak internal storage shamil hai, jo ke microSD card ke zariye expand kiya ja sakta hai.\n" +
                "\n" +
                "Camera ki baat karen to, Infinix Hot 10 ke piche quad-camera setup hai, jisme 16-megapixel ka primary sensor shamil hai. Ye camera system AI-based features, portrait mode, aur low-light photography ki capabilities ke sath aata hai. Iske ilawa, front mein 8-megapixel ka selfie camera hai, jo ke AI beautification aur face unlock features ko support karta hai.",
                "https://firebasestorage.googleapis.com/v0/b/fly-cart-kotlin.appspot.com/o/hot10.jpg?alt=media&token=ccc8c203-4274-437d-9c70-7473d1f884a4"));

        productList.add(new Product(UUID.randomUUID().toString(), "Honor 9x", 299, false, "\n" +
                "Honor 9X aik mid-range smartphone hai jo ke impressive features aur modern design ke sath aata hai. Iska display 6.59-inch ka Full HD+ LCD hai, jo ke edge-to-edge viewing experience provide karta hai aur bezels ko minimum rakhta hai. Ye phone notch-free aur pop-up selfie camera design ke sath aata hai, jo ke iske sleek aur clean appearance ko enhance karta hai.\n" +
                "\n" +
                "Honor 9X ka performance Kirin 710F octa-core processor par based hai, jo ke multitasking aur light gaming ke liye kaafi hai. Ye phone 4GB ya 6GB RAM aur 64GB ya 128GB internal storage ke sath aata hai, jo ke microSD card ke zariye further expand kiya ja sakta hai. Ye combination aapko ample storage aur smooth operation ka waada karta hai.\n" +
                "\n" +
                "Honor 9X ka camera setup bhi impressive hai. Piche triple-camera setup hai, jisme 48-megapixel ka primary sensor, 8-megapixel ka ultra-wide-angle lens, aur 2-megapixel ka depth sensor shamil hai. Ye camera system AI-based features, night mode, aur wide-angle photography ko support karta hai. Front mein, 16-megapixel ka pop-up selfie camera hai, jo ke unique aur modern touch provide karta hai.\n" +
                "\n" +
                "Battery life ki baat karen to, Honor 9X 4000 mAh ki battery ke sath aata hai, jo ke ek din ki usage ke liye kaafi hai. Ye phone Android-based EMUI operating system par chalta hai, jo ke customization aur user-friendly features ke sath aata hai. Connectivity options mein dual-SIM support, 4G LTE, Wi-Fi, aur Bluetooth shamil hain.\n" +
                "\n" +
                "Honor 9X un logon ke liye behtareen choice hai jo ke ek stylish aur feature-rich smartphone dhoond rahe hain jisme robust camera, ample storage, aur sleek design shamil ho.",
                "https://firebasestorage.googleapis.com/v0/b/fly-cart-kotlin.appspot.com/o/honor9x.png?alt=media&token=45bf3f69-6166-4212-a431-1701b0d83350"));

        productList.add(new Product(UUID.randomUUID().toString(), "iMac 21", 1299, true, "",
                "https://firebasestorage.googleapis.com/v0/b/fly-cart-kotlin.appspot.com/o/i%20Mac%2021.png?alt=media&token=317465b7-faff-490d-9803-e78abbdc493c"));

        productList.add(new Product(UUID.randomUUID().toString(), "iMac 21", 1299, true, "",
                "https://firebasestorage.googleapis.com/v0/b/fly-cart-kotlin.appspot.com/o/i%20Mac%2021.png?alt=media&token=317465b7-faff-490d-9803-e78abbdc493c"));

        productList.add(new Product(UUID.randomUUID().toString(), "iMac 21", 1299, true, "",
                "https://firebasestorage.googleapis.com/v0/b/fly-cart-kotlin.appspot.com/o/i%20Mac%2021.png?alt=media&token=317465b7-faff-490d-9803-e78abbdc493c"));

        productList.add(new Product(UUID.randomUUID().toString(), "Hot 10", 300, true, "",
                "https://firebasestorage.googleapis.com/v0/b/fly-cart-kotlin.appspot.com/o/hot10.jpg?alt=media&token=ccc8c203-4274-437d-9c70-7473d1f884a4"));

        productList.add(new Product(UUID.randomUUID().toString(), "Honor 9x", 299, false, "",
                "https://firebasestorage.googleapis.com/v0/b/fly-cart-kotlin.appspot.com/o/honor9x.png?alt=media&token=45bf3f69-6166-4212-a431-1701b0d83350"));

        productList.add(new Product(UUID.randomUUID().toString(), "iMac 21", 1299, true, "",
                "https://firebasestorage.googleapis.com/v0/b/fly-cart-kotlin.appspot.com/o/i%20Mac%2021.png?alt=media&token=317465b7-faff-490d-9803-e78abbdc493c"));
        productList.add(new Product(UUID.randomUUID().toString(), "iMac 21", 1299, true, "",
                "https://firebasestorage.googleapis.com/v0/b/fly-cart-kotlin.appspot.com/o/i%20Mac%2021.png?alt=media&token=317465b7-faff-490d-9803-e78abbdc493c"));
        productList.add(new Product(UUID.randomUUID().toString(), "iMac 21", 1299, true, "",
                "https://firebasestorage.googleapis.com/v0/b/fly-cart-kotlin.appspot.com/o/i%20Mac%2021.png?alt=media&token=317465b7-faff-490d-9803-e78abbdc493c"));
        productList.add(new Product(UUID.randomUUID().toString(), "Hot 10", 300, true, "",
                "https://firebasestorage.googleapis.com/v0/b/fly-cart-kotlin.appspot.com/o/hot10.jpg?alt=media&token=ccc8c203-4274-437d-9c70-7473d1f884a4"));
        productList.add(new Product(UUID.randomUUID().toString(), "Honor 9x", 299, false, "",
                "https://firebasestorage.googleapis.com/v0/b/fly-cart-kotlin.appspot.com/o/honor9x.png?alt=media&token=45bf3f69-6166-4212-a431-1701b0d83350"));
        productList.add(new Product(UUID.randomUUID().toString(), "iMac 21", 1299, true, "",
                "https://firebasestorage.googleapis.com/v0/b/fly-cart-kotlin.appspot.com/o/i%20Mac%2021.png?alt=media&token=317465b7-faff-490d-9803-e78abbdc493c"));
        productList.add(new Product(UUID.randomUUID().toString(), "iMac 21", 1299, true, "",
                "https://firebasestorage.googleapis.com/v0/b/fly-cart-kotlin.appspot.com/o/i%20Mac%2021.png?alt=media&token=317465b7-faff-490d-9803-e78abbdc493c"));
        mutableProductList.setValue(productList);
    }
}