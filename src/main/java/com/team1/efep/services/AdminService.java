package com.team1.efep.services;

import com.team1.efep.models.response_models.ViewBusinessServiceResponse;
import com.team1.efep.models.request_models.*;
import com.team1.efep.models.response_models.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;

public interface AdminService {

    String createBusinessPlan(CreateBusinessPlanRequest request, Model model, String token);

    CreateBusinessPlanResponse createBusinessPlanAPI(CreateBusinessPlanRequest request, String token);

    String updateBusinessPlan(UpdateBusinessPlanRequest request, Model model, String token);

    UpdateBusinessPlanResponse updateBusinessPlanAPI(UpdateBusinessPlanRequest request, String token);

    String disableBusinessPlan(DisableBusinessPlanRequest request, Model model, String token);

    DisableBusinessPlanResponse disableBusinessPlanAPI(DisableBusinessPlanRequest request, String token);

    String createBusinessService(CreateBusinessServiceRequest request, Model model, String token);
    CreateBusinessServiceResponse createBusinessServiceAPI(CreateBusinessServiceRequest request, String token);

    String updateBusinessService(UpdateBusinessServiceRequest request, Model model, String token);

    UpdateBusinessServiceResponse updateBusinessServiceAPI(UpdateBusinessServiceRequest request, String token);

    String deleteBusinessService(DeleteBusinessServiceRequest request, Model model, String token);
    DeleteBusinessServiceResponse deleteBusinessServiceAPI(DeleteBusinessServiceRequest request, String token);

    String viewUserList(HttpSession session, Model model);

    ViewUserListResponse viewUserListAPI();

    String viewBusinessPlan(HttpSession session, Model model, String token);

    ViewBusinessPlanResponse viewBusinessPlanAPI(String token);

    String viewBusinessService(HttpSession session, Model model, String token);
    ViewBusinessServiceResponse viewBusinessServiceAPI(String token);

    String banUser(BanUserRequest request, Model model);

    BanUserResponse banUserAPI(BanUserRequest request);

    String unBanUser(UnBanUserRequest request, Model model);

    UnBanUserResponse unBanUserAPI(UnBanUserRequest request);

    String searchUserList(HttpSession session, SearchUserListRequest request, Model model);

    SearchUserListResponse searchUserListAPI(SearchUserListRequest request);

    String createAccountForSeller(CreateAccountForSellerRequest request, Model model);

    CreateAccountForSellerResponse createAccountForSellerAPI(CreateAccountForSellerRequest request);
}
