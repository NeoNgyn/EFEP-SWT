package com.team1.efep.controllers;

import com.team1.efep.models.request_models.*;
import com.team1.efep.models.response_models.*;
import com.team1.efep.services.SellerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
//@Controller
@RequiredArgsConstructor
@RequestMapping("/seller")
@Tag(name = "Seller")
public class SellerController {

    private final SellerService sellerService;

    //--------------------------------------------Flower------------------------------------------------//

    @PutMapping("/flower")
    @Operation(hidden = true)
    public String updateFlower(@RequestHeader("Authorization") String token, UpdateFlowerRequest request, HttpSession session, Model model) {
        return sellerService.updateFlower(token, request, session, model);
    }

    @PutMapping("/flower/api")
    public UpdateFlowerResponse updateFlowerAPI(@RequestHeader("Authorization") String token, @RequestBody UpdateFlowerRequest request) {
        return sellerService.updateFlowerAPI(token, request);
    }

    @DeleteMapping("/flower")
    @Operation(hidden = true)
    public String deleteFlower(@RequestHeader("Authorization") String token, DeleteFlowerRequest request, HttpSession session, Model model) {
        return sellerService.deleteFlower(token, request, session, model);
    }

    @DeleteMapping("/flower/api")
    public DeleteFlowerResponse deleteFlowerAPI(@RequestHeader("Authorization") String token, @RequestBody DeleteFlowerRequest request) {
        return sellerService.deleteFlowerAPI(token, request);
    }

    @GetMapping("/flower/image")
    @Operation(hidden = true)
    public String viewFlowerImage(ViewFlowerImageRequest request, HttpSession session, Model model) {
        return sellerService.viewFlowerImage(request, session, model);
    }

    @PostMapping("/flower/image/api")
    public ViewFlowerImageResponse viewFlowerImageAPI(@RequestBody ViewFlowerImageRequest request) {
        return sellerService.viewFlowerImageAPI(request);
    }

    @PostMapping("/flower/image/add")
    @Operation(hidden = true)
    public String addFlowerImage(AddFlowerImageRequest request, HttpSession session, Model model) {
        return sellerService.addFlowerImage(request, session, model);
    }

    @PostMapping("/flower/image/add/api")
    public AddFlowerImageResponse addFlowerImage(@RequestBody AddFlowerImageRequest request) {
        return sellerService.addFlowerImageAPI(request);
    }

    @DeleteMapping("/flower/image")
    @Operation(hidden = true)
    public String deleteFlowerImage(DeleteFlowerImageRequest request, HttpSession session, Model model) {
        return sellerService.deleteFlowerImage(request, session, model);
    }

    @DeleteMapping("/flower/image/api")
    public DeleteFlowerImageResponse deleteFlowerImage(@RequestBody DeleteFlowerImageRequest request) {
        return sellerService.deleteFlowerImageAPI(request);
    }

    @GetMapping("/flower/status")
    public List<String> getAllFlowerStatus() {
        return sellerService.getAllFlowerStatus();
    }

    @GetMapping("/view/flower")
    public String viewFlowerListForSeller(@RequestHeader("Authorization") String token, HttpSession session, Model model) {
        return sellerService.viewFlowerListForSeller(token, session, model);
    }

    @GetMapping("/view/flower/api")
    public ViewFlowerListForSellerResponse viewFlowerListForSeller(@RequestHeader("Authorization") String token, int sellerId) {
        return sellerService.viewFlowerListForSellerAPI(token, sellerId);
    }

    @PostMapping("/flower")
    @Operation(hidden = true)
    public String createFlower(@RequestHeader("Authorization") String token,
                               @RequestBody CreateFlowerRequest request,
                               HttpSession session, Model model) {
        return sellerService.createFlower(token, request, session, model);
    }

    @PostMapping("/flower/api")
    public CreateFlowerResponse createFlowerAPI(@RequestHeader("Authorization") String token,
                                                @RequestBody CreateFlowerRequest request) {
        return sellerService.createFlowerAPI(token, request);
    }

    //-------------------------------------------------------------------------------------------------//

    //--------------------------------------------Order------------------------------------------------//

    @PutMapping("/order/status")
    @Operation(hidden = true)
    public String changeOrderStatus(ChangeOrderStatusRequest request, @RequestHeader("Authorization") String token, Model model) {
        return sellerService.changeOrderStatus(request, token, model);
    }

    @PutMapping("/order/status/api")
    public ChangeOrderStatusResponse changeOrderStatusAPI(@RequestBody ChangeOrderStatusRequest request, @RequestHeader("Authorization") String token) {
        return sellerService.changeOrderStatusAPI(request, token);
    }

    @GetMapping("/order/list")
    @Operation(hidden = true)
    public String viewOrderList(@RequestHeader("Authorization") String token, HttpSession session, Model model) {
        return sellerService.viewOrderList(token, session, model);
    }

    @GetMapping("/order/list/api/{id}")
    public ViewOrderListResponse viewOrderListAPI(@RequestHeader("Authorization") String token, @PathVariable int id) {
        return sellerService.viewOrderListAPI(token, id);
    }

    @GetMapping("/order/detail")
    @Operation(hidden = true)
    public String viewOrderDetail(@RequestHeader("Authorization") String token, ViewOrderDetailRequest request, Model model) {
        return sellerService.viewOrderDetail(token, request, model);
    }

    @GetMapping("/order/detail/api")
    public ViewOrderDetailResponse viewOrderDetail(@RequestHeader("Authorization") String token, @RequestBody ViewOrderDetailRequest request) {
        return sellerService.viewOrderDetailAPI(token, request);
    }

    @PostMapping("/order/filter")
    @Operation(hidden = true)
    public String filterOrder(FilterOrderRequest request, HttpSession session, Model model) {
        return sellerService.filterOrder(request, session, model);
    }

    @PostMapping("/order/filter/api")
    public FilterOrderResponse filterOrder(@RequestBody FilterOrderRequest request) {
        return sellerService.filterOrderAPI(request);
    }

    @PostMapping("/order/payment")
    @Operation(hidden = true)
    public String createVNPayPaymentLink(@RequestHeader("Authorization") String token, VNPayBusinessPlanRequest request, Model model, HttpServletRequest httpServletRequest) {
        return sellerService.createVNPayPaymentLink(token, request, model, httpServletRequest);
    }

    @PostMapping("/order/payment/api")
    public VNPayResponse createVNPayPaymentLinkAPI(@RequestHeader("Authorization") String token, @RequestBody VNPayBusinessPlanRequest request, HttpServletRequest httpServletRequest) {
        return sellerService.createVNPayPaymentLinkAPI(token, request, httpServletRequest);
    }

    @GetMapping("/order/payment/result")
    @Operation(hidden = true)
    public String getPaymentResult(@RequestHeader("Authorization") String token, @RequestParam Map<String, String> params, HttpServletRequest httpServletRequest, Model model) {
        return sellerService.getPaymentResult(token, params, httpServletRequest, model);
    }

    @GetMapping("/order/payment/result/api")
    public VNPayResponse getPaymentResult(
            @RequestHeader("Authorization") String token,
            @RequestParam Map<String, String> params,
            HttpServletRequest httpServletRequest) {
        return sellerService.getPaymentResultAPI(token, params, httpServletRequest);
    }

    @GetMapping("/order/confirm")
    @Operation(hidden = true)
    public String confirmOrder(HttpSession session, Model model,@RequestParam int busPlanId) {
        return sellerService.confirmOrder(session, model, busPlanId);
    }

    @GetMapping("/order/sort")
    @Operation(hidden = true)
    public String sortOrder(FilterOrderRequest filterOrderRequest, SortOrderRequest sortOrderRequest, HttpSession session, Model model) {
        return sellerService.sortOrder(filterOrderRequest, sortOrderRequest, session, model);
    }

    @PostMapping("/order/sort/api")
    public SortOrderResponse sortOrder(@RequestBody FilterOrderRequest filterOrderRequest, @RequestBody SortOrderRequest sortOrderRequest) {
        return sellerService.sortOrderAPI(filterOrderRequest, sortOrderRequest);
    }

    //-------------------------------------------------------------------------------------------------//

    @PutMapping("/plan")
    public String cancelBusinessPlan(CancelBusinessPlanRequest request, Model model) {
        return sellerService.cancelBusinessPlan(request, model);
    }

    @PostMapping("/view/plan")
    @Operation(hidden = true)
    public String viewBusinessPlan(@RequestHeader("Authorization") String token, Model model) {
        return sellerService.viewBusinessPlan(token, model);
    }

    @PostMapping("/view/plan/api")
    public ViewBusinessPlanResponse viewBusinessPlanAPI(@RequestHeader("Authorization") String token) {
        return sellerService.viewBusinessPlanAPI(token);
    }
    @PutMapping("/plan/api")
    public CancelBusinessPlanResponse cancelBusinessPlan(@RequestBody CancelBusinessPlanRequest request) {
        return sellerService.cancelBusinessPlanAPI(request);
    }

    @GetMapping("/buyer/list")
    public String viewBuyerList(@RequestHeader("Authorization") String token, Model model) {
        return sellerService.viewBuyerList(token, model);
    }

    @PostMapping("/buyer/list/api")
    public ViewBuyerListResponse viewBuyerListAPI(@RequestBody ViewBuyerListRequest request, @RequestHeader("Authorization") String token) {
        return sellerService.viewBuyerListAPI(request, token);
    }

    @PostMapping("/search/buyer/")
    public String searchBuyerList(HttpSession session, SearchBuyerListRequest request, Model model) {
        return sellerService.searchBuyerList(session, request, model);
    }

    @PostMapping("/search/buyer/api")
    public SearchBuyerListResponse searchBuyerList(@RequestBody SearchBuyerListRequest request, @RequestBody int id) {
        return sellerService.searchBuyerListAPI(request, id);
    }

    @GetMapping("/plan/detail")
    @Operation(hidden = true)
    public String viewBusinessPlanDetail(@RequestHeader("Authorization") String token, Model model) {
        return sellerService.viewBusinessPlanDetail(token, model);
    }

    @GetMapping("/plan/detail/api")
    public ViewBusinessPlanDetailResponse viewBusinessPlanDetailAPI(@RequestHeader("Authorization") String token, ViewBusinessPlanDetailRequest request) {
        return sellerService.viewBusinessPlanDetailAPI(token, request);
    }
}
