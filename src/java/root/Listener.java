package root;


import bean.UsuarioBean;
import javax.faces.application.Application;
import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Wellysson
 */
public class Listener implements PhaseListener{
    /**
     * 
     * @param event 
     */
    private static final long serialVersionUID = 1L;
    @Override
    public void afterPhase(PhaseEvent event) {
        FacesContext ctx = FacesContext.getCurrentInstance();
        if(!ctx.getViewRoot().getViewId().equals("/login.xhtml")){
            Application app = ctx.getApplication();
            UsuarioBean u = app.evaluateExpressionGet(ctx, "#{usuario}", UsuarioBean.class);
            /*if(!u.getUsuario().equals("admin")){
                NavigationHandler handler = app.getNavigationHandler();
                handler.handleNavigation(ctx, "", "login?faces-redirect=true");
                ctx.renderResponse();
            }*/
        }
    }

    @Override
    public void beforePhase(PhaseEvent event) {
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }
    
}
