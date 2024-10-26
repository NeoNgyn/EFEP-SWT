package com.team1.efep.services;

import com.team1.efep.models.request_models.*;
import com.team1.efep.models.response_models.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Map;

public interface BuyerService {
    String sendEmail(ForgotPasswordRequest request, Model model, HttpSession session);

    ForgotPasswordResponse sendEmailAPI(ForgotPasswordRequest request);

    String renewPass(RenewPasswordRequest request, Model model);

    RenewPasswordResponse renewPassAPI(RenewPasswordRequest request);

    String viewWishlist(HttpSession session, Model model, int accountId, String token);
    ViewWishlistResponse viewWishlistAPI(int accountId, String token);


    String addToWishlist(AddToWishlistRequest request, HttpServletRequest httpServletRequest, HttpSession session, Model model, String token);
    AddToWishlistResponse addToWishlistAPI(AddToWishlistRequest request, String token);

    String viewFlowerList(HttpSession session, Model model);

    ViewFlowerListResponse viewFlowerListAPI();

    void viewSlideBar(Model model);

    ViewSlideBarResponse viewSlideBarAPI();

    String deleteWishlistItem(DeleteWishlistItemRequest request, HttpSession session, Model model, String token);
    DeleteWishlistItemResponse deleteWishlistItemAPI(DeleteWishlistItemRequest request, String token);


    String viewOrderHistory(HttpSession session, Model model, String token);
    ViewOrderHistoryResponse viewOrderHistoryAPI(int accountId, String token);

    void viewFlowerTopList(int top, Model model);

    ViewFlowerTopListResponse viewFlowerTopListAPI(int top);

    String searchFlower(SearchFlowerRequest request, Model model);

    SearchFlowerResponse searchFlowerAPI(SearchFlowerRequest request);

    String viewFlowerDetail(ViewFlowerDetailRequest request, Model model);

    ViewFlowerDetailResponse viewFlowerDetailAPI(ViewFlowerDetailRequest request);

    String viewOrderDetail(ViewOrderDetailRequest request, HttpSession session, Model model);

    ViewOrderDetailResponse viewOrderDetailAPI(ViewOrderDetailRequest request);

    String viewOrderStatus(HttpSession session, Model model);

    ViewOrderStatusResponse viewOrderStatusAPI(ViewOrderStatusRequest request);

    String updateWishlist(UpdateWishlistRequest request, HttpSession session, Model model, String token);
    UpdateWishlistResponse updateWishlistAPI(UpdateWishlistRequest request, String token);

    String deleteWishlist(DeleteWishlistRequest request, HttpSession session, Model model, String token);
    DeleteWishlistResponse deleteWishlistAPI(DeleteWishlistRequest request, String token);

    String cancelOrder(CancelOrderRequest request, HttpSession session, Model model, String token);
    CancelOrderResponse cancelOrderAPI(CancelOrderRequest request, String token);

    String createVNPayPaymentLink(VNPayRequest request, Model model, HttpServletRequest httpServletRequest, String token);

    VNPayResponse createVNPayPaymentLinkAPI(VNPayRequest request, HttpServletRequest httpServletRequest, String token);


    String getPaymentResult(Map<String, String> params, HttpServletRequest httpServletRequest, Model model, HttpSession session, String token);

    VNPayResponse getPaymentResultAPI(Map<String, String> params, int accountId, HttpServletRequest httpServletRequest, String token);

    String getCODPaymentResult(Map<String, String> params, HttpSession session, RedirectAttributes redirectAttributes);

    void viewCategory(Model model);

    ViewCategoryListResponse viewCategoryAPI();

    String confirmOrder(HttpSession session, Model model, String token);

    String handleOTP(String code, Model model, HttpSession session);

    String filterCategory(FilterCategoryRequest request, Model model);

    FilterCategoryResponse filterCategoryAPI(FilterCategoryRequest request);

}
