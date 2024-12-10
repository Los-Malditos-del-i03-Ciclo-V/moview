package pe.edu.certus.api.dashboard.port;

import org.springframework.ui.Model;

public interface ForDashboardMainPage {
    String showMovieDashboard(Model model);
    String showProjectionDashboard(Model model);
    String showOrdenDashboard(Model model);
    String showSnackDashboard(Model model);
    String showUserDashboard(Model model);
}
