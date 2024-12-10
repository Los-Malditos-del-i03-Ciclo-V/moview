package pe.edu.certus.api.dashboard.adapter;//package pe.edu.certus.api.admin.dashboard.adapter;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import pe.edu.certus.api.admin.dashboard.port.ForDashboardMainPage;
//import pe.edu.certus.api.utils.costants.AdminEndpointsRoutes;
//import pe.edu.certus.api.utils.costants.AdminTemplateRoutes;
//
//@Controller
//@RequestMapping(AdminEndpointsRoutes.ADMIN_DASHBOARD_ENDPOINT)
//public class DashboardMainMainAdapter implements ForDashboardMainPage {
//    @Override
//    @GetMapping(AdminEndpointsRoutes.ADMIN_DASHBOARD_MOVIE_ENDPOINT)
//    public String showMovieDashboard(Model model) {
//        return AdminTemplateRoutes.DASHBOARD_MOVIE_PAGE;
//    }
//
//    @Override
//    @GetMapping(AdminEndpointsRoutes.ADMIN_DASHBOARD_PROJECTION_ENDPOINT)
//    public String showProjectionDashboard(Model model) {
//        return AdminTemplateRoutes.DASHBOARD_PROJECTION_PAGE;
//    }
//
//    @Override
//    @GetMapping(AdminEndpointsRoutes.ADMIN_DASHBOARD_ORDER_ENDPOINT)
//    public String showOrdenDashboard(Model model) {
//        return AdminTemplateRoutes.DASHBOARD_ORDER_PAGE;
//    }
//
//    @Override
//    @GetMapping(AdminEndpointsRoutes.ADMIN_DASHBOARD_SNACK_ENDPOINT)
//    public String showSnackDashboard(Model model) {
//        return AdminTemplateRoutes.DASHBOARD_SNACK_PAGE;
//    }
//
//    @Override
//    @GetMapping(AdminEndpointsRoutes.ADMIN_DASHBOARD_USER_ENDPOINT)
//    public String showUserDashboard(Model model) {
//        return AdminTemplateRoutes.DASHBOARD_USER_PAGE;
//    }
//}
