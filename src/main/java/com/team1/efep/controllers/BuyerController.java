package com.team1.efep.controllers;

import com.team1.efep.configurations.AllPage;
import com.team1.efep.models.request_models.*;
import com.team1.efep.models.response_models.*;
import com.team1.efep.services.BuyerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Map;

//@Controller
@RestController
@RequiredArgsConstructor
@RequestMapping("/buyer")
@Tag(name = "Buyer")
public class BuyerController {

    private final BuyerService buyerService;

    @PostMapping("/pass/forgot")
    @Operation(hidden = true)
    public String forgot(ForgotPasswordRequest request, Model model, HttpSession session) {
        AllPage.allConfig(model, buyerService);
        return buyerService.sendEmail(request, model, session);
    }

    @PostMapping("/pass/forgot/api")
    public ForgotPasswordResponse forgot(@RequestBody ForgotPasswordRequest request) {
        return buyerService.sendEmailAPI(request);
    }

    @GetMapping("/otp/verify")
    @Operation(hidden = true)
    public String verifyOTP(@RequestParam(name = "code") String code, Model model, HttpSession session) {
        return buyerService.handleOTP(code, model, session);
    }

    @PostMapping("/pass/renew")
    @Operation(hidden = true)
    public String renewPass(RenewPasswordRequest request, Model model) {
        AllPage.allConfig(model, buyerService);
        return buyerService.renewPass(request, model);
    }

    @PostMapping("/pass/renew/api")
    public RenewPasswordResponse renewPass(@RequestBody RenewPasswordRequest request) {
        return buyerService.renewPassAPI(request);
    }

    @GetMapping("/flower")
    @Operation(hidden = true)
    public String viewFlowerList(HttpSession session, Model model) {
        AllPage.allConfig(model, buyerService);
        return buyerService.viewFlowerList(session, model);
    }

    @GetMapping("/flower/api")
    public ViewFlowerListResponse viewFlowerList() {
        return buyerService.viewFlowerListAPI();
    }

    //---------------ORDER----------------//
    @GetMapping("/order/history")
    @Operation(hidden = true)
    public String viewOrderHistory(
            @RequestHeader("Authorization") String token, // Thêm token vào header
            HttpSession session,
            Model model) {
        AllPage.allConfig(model, buyerService);
        return buyerService.viewOrderHistory(session, model, token); // Truyền token vào phương thức viewOrderHistory
    }

    @GetMapping("/order/history/api/{accountId}")
    public ViewOrderHistoryResponse viewOrderHistoryAPI(
            @PathVariable int accountId,
            @RequestHeader("Authorization") String token) { // Thêm token vào header
        return buyerService.viewOrderHistoryAPI(accountId, token); // Truyền token vào phương thức viewOrderHistoryAPI
    }

    @GetMapping("/order/detail")
    @Operation(hidden = true)
    public String viewOrderDetail(ViewOrderDetailRequest request, HttpSession session, Model model) {
        AllPage.allConfig(model, buyerService);
        return buyerService.viewOrderDetail(request, session, model);
    }

    @PostMapping("/order/detail/api")
    public ViewOrderDetailResponse viewOrderHistory(@RequestBody ViewOrderDetailRequest request) {
        return buyerService.viewOrderDetailAPI(request);
    }

    @GetMapping("/order/status")
    @Operation(hidden = true)
    public String viewOrderStatus(HttpSession session, Model model) {
        AllPage.allConfig(model, buyerService);
        return buyerService.viewOrderStatus(session, model);
    }

    @PostMapping("/order/status/api")
    public ViewOrderStatusResponse viewOrderStatus(@RequestBody ViewOrderStatusRequest request) {
        return buyerService.viewOrderStatusAPI(request);
    }

    @PutMapping("/order")
    @Operation(hidden = true)
    public String cancelOrder(
            @RequestBody CancelOrderRequest request,
            @RequestHeader("Authorization") String token, // Thêm token vào header
            HttpSession session,
            Model model) {
        AllPage.allConfig(model, buyerService);
        return buyerService.cancelOrder(request, session, model, token); // Truyền token vào phương thức cancelOrder
    }

    @PutMapping("/order/api")
    public CancelOrderResponse cancelOrderAPI(
            @RequestBody CancelOrderRequest request,
            @RequestHeader("Authorization") String token) { // Thêm token vào header
        return buyerService.cancelOrderAPI(request, token); // Truyền token vào phương thức cancelOrderAPI
    }

    @PostMapping("/order/payment")
    @Operation(hidden = true)
    public String createVNPayPaymentLink(
            VNPayRequest request,
            Model model,
            HttpServletRequest httpServletRequest,
            @RequestHeader("Authorization") String token) {

        AllPage.allConfig(model, buyerService);
        return buyerService.createVNPayPaymentLink(request, model, httpServletRequest, token);
    }

    @PostMapping("/order/payment/api")
    public VNPayResponse createVNPayPaymentLinkAPI(
            @RequestBody VNPayRequest request,
            HttpServletRequest httpServletRequest,
            @RequestHeader("Authorization") String token) {

        return buyerService.createVNPayPaymentLinkAPI(request, httpServletRequest, token);
    }

    @GetMapping("/order/payment/result")
    @Operation(hidden = true)
    public String getPaymentResult(
            @RequestParam Map<String, String> params,
            HttpServletRequest httpServletRequest,
            Model model,
            HttpSession session,
            @RequestHeader("Authorization") String token) {

        AllPage.allConfig(model, buyerService);
        return buyerService.getPaymentResult(params, httpServletRequest, model, session, token);
    }

    @GetMapping("/order/payment/result/api")
    public VNPayResponse getPaymentResultAPI(
            @RequestParam Map<String, String> params,
            @RequestParam int accountId,
            HttpServletRequest httpServletRequest,
            @RequestHeader("Authorization") String token) {

        return buyerService.getPaymentResultAPI(params, accountId, httpServletRequest, token);
    }

    @PostMapping("/order/cod")
    public String getCODPaymentResult(@RequestParam Map<String, String> params, HttpSession session, RedirectAttributes redirectAttributes) {
        return buyerService.getCODPaymentResult(params, session, redirectAttributes);
    }


    //------------------------------------WISHLIST---------------------------------//
    @PutMapping("/wishlist")
    @Operation(hidden = true)
    public String updateWishlist(
            UpdateWishlistRequest request,
            @RequestHeader("Authorization") String token, // Thêm token vào header
            HttpSession session,
            Model model) {
        AllPage.allConfig(model, buyerService);
        return buyerService.updateWishlist(request, session, model, token); // Truyền token vào phương thức updateWishlist
    }

    @PutMapping("/wishlist/api")
    public UpdateWishlistResponse updateWishlistAPI(
            @RequestBody UpdateWishlistRequest request,
            @RequestHeader("Authorization") String token) { // Thêm token vào header
        return buyerService.updateWishlistAPI(request, token); // Truyền token vào phương thức updateWishlistAPI
    }

    @DeleteMapping("/wishlist")
    @Operation(hidden = true)
    public String deleteWishlist(
            DeleteWishlistRequest request,
            @RequestHeader("Authorization") String token, // Thêm token vào header
            HttpSession session,
            Model model) {
        AllPage.allConfig(model, buyerService);
        return buyerService.deleteWishlist(request, session, model, token); // Truyền token vào phương thức deleteWishlist
    }

    @DeleteMapping("/wishlist/api")
    public DeleteWishlistResponse deleteWishlistAPI(
            @RequestBody DeleteWishlistRequest request,
            @RequestHeader("Authorization") String token) { // Thêm token vào header
        return buyerService.deleteWishlistAPI(request, token); // Truyền token vào phương thức deleteWishlistAPI
    }

    @DeleteMapping("/wishlist-item")
    @Operation(hidden = true)
    public String deleteWishlistItem(
            DeleteWishlistItemRequest request,
            @RequestHeader("Authorization") String token, // Thêm token vào header
            HttpSession session,
            Model model) {
        AllPage.allConfig(model, buyerService);
        return buyerService.deleteWishlistItem(request, session, model, token); // Truyền token vào phương thức deleteWishlistItem
    }

    @DeleteMapping("/wishlist-item/api")
    public DeleteWishlistItemResponse deleteWishlistItemAPI(
            @RequestBody DeleteWishlistItemRequest request,
            @RequestHeader("Authorization") String token) { // Thêm token vào header
        return buyerService.deleteWishlistItemAPI(request, token); // Truyền token vào phương thức deleteWishlistItemAPI
    }

    @GetMapping("/wishlist")
    @Operation(hidden = true)
    public String viewWishlist(@PathVariable int accountId, HttpSession session, Model model, @RequestHeader("Authorization") String token) {
        AllPage.allConfig(model, buyerService);
        return buyerService.viewWishlist(session, model, accountId, token);
    }

    @GetMapping("/wishlist/api/{accountId}")
    public ViewWishlistResponse viewWishlistAPI(
            @PathVariable int accountId,
            @RequestHeader("Authorization") String token) {
        return buyerService.viewWishlistAPI(accountId, token);
    }


    @PostMapping("/wishlist")
    @Operation(hidden = true)
    public String addToWishlist(
            AddToWishlistRequest request,
            HttpServletRequest httpServletRequest,
            HttpSession session,
            Model model,
            @RequestHeader("Authorization") String token) {

        AllPage.allConfig(model, buyerService);
        return buyerService.addToWishlist(request, httpServletRequest, session, model, token);
    }

    @PostMapping("/wishlist/api")
    public AddToWishlistResponse addToWishlistAPI(
            @RequestBody AddToWishlistRequest request,
            @RequestHeader("Authorization") String token) {

        return buyerService.addToWishlistAPI(request, token);
    }
    //-------------------------------------------------------------------------------//

    //mac dinh chay song song vs home page ==> ko can controller cho Thymeleaf
    @PostMapping("/flower/top/list/api")
    public ViewFlowerTopListResponse viewFlowerTopList(@RequestBody ViewFlowerTopListRequest request) {
        return buyerService.viewFlowerTopListAPI(request.getTop());
    }

    @PostMapping("/flower/search")
    @Operation(hidden = true)
    public String searchFlower(SearchFlowerRequest request, Model model) {
        AllPage.allConfig(model, buyerService);
        return buyerService.searchFlower(request, model);
    }

    @PostMapping("/flower/search/api")
    public SearchFlowerResponse searchFlower(@RequestBody SearchFlowerRequest request) {
        return buyerService.searchFlowerAPI(request);
    }

    @GetMapping("/flower/detail")
    @Operation(hidden = true)
    public String viewFlowerDetail(ViewFlowerDetailRequest request, Model model) {
        AllPage.allConfig(model, buyerService);
        return buyerService.viewFlowerDetail(request, model);
    }

    @GetMapping("/flower/detail/api")
    public ViewFlowerDetailResponse searchFlower(@RequestBody ViewFlowerDetailRequest request) {
        return buyerService.viewFlowerDetailAPI(request);
    }

//    @GetMapping("/category")
//    @Operation(hidden = true)
//    public String viewCategory(HttpSession session, Model model) {
//        return buyerService.viewCategory(session, model);
//    }

    @GetMapping("/category/api")
    public ViewCategoryListResponse viewCategory() {
        return buyerService.viewCategoryAPI();
    }

    @GetMapping("/order/confirm")
    public String confirmOrder(HttpSession session, Model model, @RequestHeader("Authorization") String token) {
        AllPage.allConfig(model, buyerService);
        return buyerService.confirmOrder(session, model, token);
    }


    @PostMapping("/category/filter")
    @Operation(hidden = true)
    public String filterCategory(FilterCategoryRequest request, Model model) {
        AllPage.allConfig(model, buyerService);
        return buyerService.filterCategory(request, model);
    }

    @PostMapping("/category/filter/api")
    public FilterCategoryResponse filterCategory(@RequestBody FilterCategoryRequest request) {
        return buyerService.filterCategoryAPI(request);
    }


}
