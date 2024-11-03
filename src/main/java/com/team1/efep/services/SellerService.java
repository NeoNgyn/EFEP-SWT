package com.team1.efep.services;

import com.team1.efep.models.request_models.*;
import com.team1.efep.models.response_models.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Map;

public interface SellerService {

    String createFlower(String token, CreateFlowerRequest request, HttpSession session, Model model);

    CreateFlowerResponse createFlowerAPI(String token, CreateFlowerRequest request);

    String changeOrderStatus(ChangeOrderStatusRequest request, String token, Model model);

    ChangeOrderStatusResponse changeOrderStatusAPI(ChangeOrderStatusRequest request, String token);

    String viewOrderList(String token, HttpSession session, Model model);

    ViewOrderListResponse viewOrderListAPI(String token, int id);

    String viewFlowerListForSeller(String token, HttpSession session, Model model);

    ViewFlowerListForSellerResponse viewFlowerListForSellerAPI(String token, int sellerId);

    String viewBusinessPlan(String token, Model model);

    ViewBusinessPlanResponse viewBusinessPlanAPI(String token);

    String cancelBusinessPlan(CancelBusinessPlanRequest request, Model model);

    CancelBusinessPlanResponse cancelBusinessPlanAPI(CancelBusinessPlanRequest request);

    String viewBuyerList(String token, Model model);

    ViewBuyerListResponse viewBuyerListAPI(ViewBuyerListRequest request, String token);

    String searchBuyerList(HttpSession session, SearchBuyerListRequest request, Model model);

    SearchBuyerListResponse searchBuyerListAPI(SearchBuyerListRequest request, int sellerId);

    String viewOrderDetail(String token, ViewOrderDetailRequest request, Model model);

    ViewOrderDetailResponse viewOrderDetailAPI(String token, ViewOrderDetailRequest request);

    String filterOrder(FilterOrderRequest request, HttpSession session, Model model);

    FilterOrderResponse filterOrderAPI(FilterOrderRequest request);

    String createVNPayPaymentLink(String token, VNPayBusinessPlanRequest request, Model model, HttpServletRequest httpServletRequest);

    VNPayResponse createVNPayPaymentLinkAPI(String token, VNPayBusinessPlanRequest request, HttpServletRequest httpServletRequest);

    String getPaymentResult(String token, Map<String, String> params, HttpServletRequest httpServletRequest, Model model);

    VNPayResponse getPaymentResultAPI(String token, Map<String, String> params, HttpServletRequest httpServletRequest);

    String sortOrder(FilterOrderRequest filterOrderRequest, SortOrderRequest sortOrderRequest, HttpSession session, Model model);

    SortOrderResponse sortOrderAPI(FilterOrderRequest filterOrderRequest, SortOrderRequest sortOrderRequest);

    String updateFlower(String token, UpdateFlowerRequest request, HttpSession session, Model model);
    UpdateFlowerResponse updateFlowerAPI(String token, UpdateFlowerRequest request);

    List<String> getAllFlowerStatus();

    String deleteFlower(String token, DeleteFlowerRequest request, HttpSession session, Model model);

    DeleteFlowerResponse deleteFlowerAPI(String token, DeleteFlowerRequest request);

    String viewFlowerImage(ViewFlowerImageRequest request, HttpSession session, Model model);

    ViewFlowerImageResponse viewFlowerImageAPI(ViewFlowerImageRequest request);

    String addFlowerImage(AddFlowerImageRequest request, HttpSession session, Model model);

    AddFlowerImageResponse addFlowerImageAPI(AddFlowerImageRequest request);

    String deleteFlowerImage(DeleteFlowerImageRequest request, HttpSession session, Model model);

    DeleteFlowerImageResponse deleteFlowerImageAPI(DeleteFlowerImageRequest request);

    String confirmOrder(HttpSession session, Model model, int busPlanId);

    String viewBusinessPlanDetail(String token, Model model);
    ViewBusinessPlanDetailResponse viewBusinessPlanDetailAPI(String token, ViewBusinessPlanDetailRequest request);
}
